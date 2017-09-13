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

import com.ctc.wstx.api.WstxInputProperties;
import com.ctc.wstx.stax.WstxInputFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;
import org.wso2.carbon.apimgt.ballerina.threatprotection.configurations.XMLConfig;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Implementation of APIMThreatAnalyzer for XML Payloads
 */
public class XMLAnalyzer implements APIMThreatAnalyzer {
    private XMLInputFactory factory;
    private Logger logger = LoggerFactory.getLogger(XMLAnalyzer.class);

    /**
     * Create a XMLAnalyzer using default configuration values
     */
    public XMLAnalyzer() {
        factory = WstxInputFactory.newInstance();
        //configure
        XMLConfig config = XMLConfig.getInstance();

        boolean dtdEnabled = config.isDtdEnabled();
        boolean externalEntitiesEnabled = config.isExternalEntitiesEnabled();
        int maxDepth = config.getMaxDepth();
        int maxElementCount = config.getMaxElementCount();
        int maxAttributeCount = config.getMaxAttributeCount();
        int maxAttributeLength = config.getMaxAttributeLength();
        int entityExpansionLimit = config.getEntityExpansionLimit();
        int maxChildrenPerElement = config.getMaxChildrenPerElement();

        factory.setProperty(XMLInputFactory.SUPPORT_DTD, dtdEnabled);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, externalEntitiesEnabled);
        factory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, maxAttributeLength);
        factory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTES_PER_ELEMENT, maxAttributeCount);
        factory.setProperty(WstxInputProperties.P_MAX_ELEMENT_DEPTH, maxDepth);
        factory.setProperty(WstxInputProperties.P_MAX_CHILDREN_PER_ELEMENT, maxChildrenPerElement);
        factory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, entityExpansionLimit);
        factory.setProperty(WstxInputProperties.P_MAX_ELEMENT_COUNT, maxElementCount);
    }

    /**
     * Create a XMLAnalyzer using API-Specific configuration values
     *
     * @param apiId Unique id of an API
     */
    private XMLAnalyzer(String apiId) {
        //to-do: load api specific configurations for Analyzers
    }

    /**
     *
     * @param payload xml payload
     * @throws APIMThreatAnalyzerException
     */
    @Override
    public void analyze(String payload) throws APIMThreatAnalyzerException {
        try {

            Reader payloadReader = new StringReader(payload);
            XMLEventReader reader = factory.createXMLEventReader(payloadReader);
            while (reader.hasNext()) {
                reader.nextEvent();
            }
            reader.close();
            payloadReader.close();
        } catch (XMLStreamException e) {
            logger.error("Threat Protection: XML Validation Failed", e);
            System.out.println(e.getMessage() + e);
            throw new APIMThreatAnalyzerException("XML Validation Failed: " + e.getMessage());

        } catch (IOException e) {
            logger.error("Threat Protection: XML Stream Reader error", e);
            System.out.println(e.getMessage() + e);
            throw new APIMThreatAnalyzerException("XML Stream Reader error: " + e.getMessage());
        }
    }
}