/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;
import org.wso2.carbon.apimgt.ballerina.threatprotection.configurations.JSONConfig;
import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.JSONThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

import java.io.IOException;
import java.io.StringReader;

/**
 * Implementation of APIMThreatAnalyzer for JSON Payloads
 */
public class JSONAnalyzer implements APIMThreatAnalyzer {
    private static final String THREAT_PROTECTION_MSG_PREFIX = "Threat Protection-JSON: ";

    private Logger logger = LoggerFactory.getLogger(JSONAnalyzer.class);

    private int maxPropertyCount = 0;
    private int maxStringLength = 0;
    private int maxArrayElementCount = 0;
    private int maxKeyLength = 0;
    private int maxJsonDepth = 0;

    /**
     * Create a JSONAnalyzer using API-Specific configuration values
     */
    public JSONAnalyzer() {
        long start, end, diff;
        start = System.currentTimeMillis();
//        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
//        JSONThreatProtectionConfigurations jsonThreatProtectionConfigurations =
//                apimConfigurations.getJsonThreatProtectionConfigurations();
        //configure analyzer
//        maxPropertyCount = jsonThreatProtectionConfigurations.getPropertyCount();
//        maxStringLength = jsonThreatProtectionConfigurations.getStringLength();
//        maxArrayElementCount = jsonThreatProtectionConfigurations.getArrayElementCount();
//        maxKeyLength = jsonThreatProtectionConfigurations.getKeyLength();
//        maxJsonDepth = jsonThreatProtectionConfigurations.getMaxDepth();

        JSONConfig config = JSONConfig.getInstance();
        maxPropertyCount = config.getMaxPropertyCount();
        maxStringLength = config.getMaxStringLength();
        maxArrayElementCount = config.getMaxArrayElementCount();
        maxKeyLength = config.getMaxKeyLength();
        maxJsonDepth = config.getMaxJsonDepth();
        end = System.currentTimeMillis();
        diff = end -start;
        System.out.println("===JSON-Analyzer init: " + diff);
    }

    /**
     * Create a JSON using API-Specific configuration values
     *
     * @param apiId Unique id of an API
     */
    private JSONAnalyzer(String apiId) {
        //to-do: load api specific configurations for Analyzers
    }

    /**
     *
     * @param payload json payload
     * @throws APIMThreatAnalyzerException
     */
    @Override
    public void analyze(String payload) throws APIMThreatAnalyzerException {
        long start,end, diff;
        start = System.currentTimeMillis();
        JsonFactory factory = new JsonFactory();
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("===JSON-Factory creation: " + diff);
        try {
            //start = System.currentTimeMillis();
            JsonParser parser = factory.createParser(new StringReader(payload));

            int currentDepth = 0;
            int currentFieldCount = 0;

            JsonToken token;
            while ( (token = parser.nextToken()) != null) {
                switch (token) {
                    case START_OBJECT:
                        currentDepth += 1;

                        if (currentDepth > maxJsonDepth) {
                            logger.error(THREAT_PROTECTION_MSG_PREFIX + "Depth Limit Reached");
                            parser.close();
                            throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX + "Depth Limit Reached");
                        }
                        break;

                    case END_OBJECT:
                        currentDepth -= 1;
                        break;

                    case FIELD_NAME:
                        currentFieldCount += 1;
                        if (currentFieldCount > maxPropertyCount) {
                            logger.error(THREAT_PROTECTION_MSG_PREFIX + "Max Property Count Reached");
                            parser.close();
                            throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX
                                    + "Max Property Count Reached");
                        }

                        String name = parser.getCurrentName();
                        if (name.length() > maxKeyLength) {
                            logger.error(THREAT_PROTECTION_MSG_PREFIX + "Max Key Length Reached");
                            parser.close();
                            throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX
                                    + "Max Key Length Reached");
                        }
                        break;

                    case VALUE_STRING:
                        String value = parser.getText();
                        if (value.length() > maxStringLength) {
                            logger.error(THREAT_PROTECTION_MSG_PREFIX + "Max String Length Reached");
                            parser.close();
                            throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX
                                    + "Max String Length Reached");
                        }
                        break;

                    case START_ARRAY:
                        int arrayElementCount = 0;
                        while ( parser.nextToken() != JsonToken.END_ARRAY) {
                            arrayElementCount += 1;

                            if (arrayElementCount > maxArrayElementCount) {
                                logger.error(THREAT_PROTECTION_MSG_PREFIX + "Max Array Length Reached");
                                parser.close();
                                throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX
                                        + "Max Array Length Reached");
                            }
                        }
                }
            }
            parser.close();
            end = System.currentTimeMillis();
            diff = end - start;
            System.out.println("===JSON-Parse time: " + diff);
        } catch (IOException e) {
            logger.error(THREAT_PROTECTION_MSG_PREFIX + "Payload build failed", e);
            throw new APIMThreatAnalyzerException(THREAT_PROTECTION_MSG_PREFIX + e);
        }
    }
}