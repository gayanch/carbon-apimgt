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

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;
import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.JSONThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

import java.io.IOException;

/**
 * Implementation of APIMThreatAnalyzer for JSON Payloads
 */
public class JSONAnalyzer implements APIMThreatAnalyzer {
    private static final String JSON_SCHEMA_TEMPLATE = "{" +
            "    \"type\": \"object\"," +
            "    \"maxProperties\": #_maxProperties," +
            "    \"patternProperties\": {" +
            "        \"^.{0,#_maxKeyLength}$\": {" +
            "            \"anyOf\": [" +
            "                { \"$ref\": \"#/definitions/boundedNumber\" }," +
            "                { \"$ref\": \"#/definitions/boundedString\" }," +
            "                { \"$ref\": \"#/definitions/boundedArray\" }," +
            "                { \"$ref\": \"#/definitions/boundedObject\"}," +
            "                { \"$ref\": \"#/definitions/booleanValues\"}," +
            "                { \"$ref\": \"#/definitions/nullValues\"}]" +
            "        }" +
            "    }," +
            "    \"definitions\": {" +
            "        \"boundedString\": {" +
            "            \"type\": \"string\"," +
            "            \"maxLength\": #_maxStringLength," +
            "            \"minLength\": 0" +
            "        }," +
            "        \"boundedNumber\": {" +
            "            \"type\": \"number\"" +
            "        }," +
            "        \"boundedArray\": {" +
            "            \"type\": \"array\"," +
            "            \"minItems\": 0," +
            "            \"maxItems\": #_maxArrayElements" +
            "        }," +
            "        \"boundedObject\": {" +
            "            \"type\": \"object\"," +
            "            \"maxProperties\": #_maxProperties" +
            "        }," +
            "        \"booleanValues\": {" +
            "            \"type\": \"boolean\" " +
            "        }," +
            "        \"nullValues\": {" +
            "            \"type\": \"null\"" +
            "        }" +
            "    }," +
            "    \"additionalProperties\": false" +
            "}";

    private JsonSchema schema;
    private Logger logger = LoggerFactory.getLogger(JSONAnalyzer.class);
    private int maxJsonDepth = 0;

    /**
     * Create a JSONAnalyzer using API-Specific configuration values
     */
    public JSONAnalyzer() {

        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        JSONThreatProtectionConfigurations jsonThreatProtectionConfigurations =
                apimConfigurations.getJsonThreatProtectionConfigurations();
        //configure analyzer
        int propertyCount = jsonThreatProtectionConfigurations.getPropertyCount();
        int stringLength = jsonThreatProtectionConfigurations.getStringLength();
        int arrayElementCount = jsonThreatProtectionConfigurations.getArrayElementCount();
        int keyLength = jsonThreatProtectionConfigurations.getKeyLength();
        maxJsonDepth = jsonThreatProtectionConfigurations.getMaxDepth();

        String schemaString = JSON_SCHEMA_TEMPLATE.replaceAll("#_maxProperties", String.valueOf(propertyCount))
                .replace("#_maxKeyLength", String.valueOf(keyLength))
                .replace("#_maxStringLength", String.valueOf(stringLength))
                .replace("#_maxArrayElements", String.valueOf(arrayElementCount));
        logger.info(schemaString);

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        try {
            JsonNode schemaNode = JsonLoader.fromString(schemaString);
            schema = factory.getJsonSchema(schemaNode);
            logger.info("Threat Protection: Schema Loaded");
        } catch (IOException e) {
            logger.error("Threat Protection: JSON Schema loading failed", e);
        } catch (ProcessingException e) {
            logger.error("Threat Protection: JSON schema processing error", e);
        }
    }

    /**
     * Create a JSON using API-Specific configuration values
     *
     * @param apiId Unique id of an API
     */
    public JSONAnalyzer(String apiId) {
        //to-do: load api specific configurations for Analyzers
    }

    @Override
    public void analyze(String payload) throws APIMThreatAnalyzerException {
        //check depth
        if (!checkDepth(payload, maxJsonDepth)) {
            logger.error("Threat Protection: Maximum depth of json document exceeded the configured limit");
            throw new APIMThreatAnalyzerException(
                    "Threat Protection: Maximum depth of json document exceeded the configured limit");
        }
        JsonNode payloadNode = null;
        ProcessingReport report = null;
        try {
            payloadNode = JsonLoader.fromString(payload);
            report = schema.validate(payloadNode);
        } catch (IOException e) {
           logger.error("Threat Protection: Payload json loading failed", e);
           throw new APIMThreatAnalyzerException("Threat Protection: Payload json loading failed: " + e.getMessage());
        } catch (ProcessingException e) {
            logger.error("Threat Protection: Payload json processing failed", e);
            throw new APIMThreatAnalyzerException("Threat Protection: Payload json processing failed: "
                    + e.getMessage());
        }

        if (!report.isSuccess()) {
            logger.warn("Threat Protection: JSON validation failed");
            throw new APIMThreatAnalyzerException("Threat Protection: JSON validation failed");
        }

    }

    /**
     * Checks whether depth of json payload exceeds the maximum specified depth
     *
     * @param json json payload
     * @param maxDepth maximum desired depth of json payload
     * @return true if depth is below maxDepth, false otherwise
     */
    private boolean checkDepth(String json, int maxDepth) {
        if (maxDepth <= 0) {
            return true;
        }

        int currentMax = 0;
        for (char ch: json.toCharArray()) {
            if (ch == '{') {
                currentMax += 1;
            } else if (ch == '}') {
                currentMax -= 1;
            }

            if (currentMax > maxDepth) {
                return false;
            }
        }
        return true;
    }
}
