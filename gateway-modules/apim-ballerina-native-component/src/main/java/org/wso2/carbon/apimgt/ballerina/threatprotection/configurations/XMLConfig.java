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

package org.wso2.carbon.apimgt.ballerina.threatprotection.configurations;

import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.XMLThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

/**
 * Configuration holding class for {@link org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.XMLAnalyzer}
 */
public class XMLConfig {
    private boolean dtdEnabled;
    private boolean externalEntitiesEnabled;
    private int maxDepth;
    private int maxElementCount;
    private int maxAttributeCount;
    private int maxAttributeLength;
    private int entityExpansionLimit;
    private int maxChildrenPerElement;

    private static XMLConfig instance = new XMLConfig();

    private XMLConfig() {
        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        XMLThreatProtectionConfigurations xmlThreatProtectionConfigurations =
                apimConfigurations.getXmlThreatProtectionConfigurations();

        this.dtdEnabled = xmlThreatProtectionConfigurations.isDtdEnabled();
        this.externalEntitiesEnabled = xmlThreatProtectionConfigurations.isExternalEntitiesEnabled();
        this.maxDepth = xmlThreatProtectionConfigurations.getMaxDepth();
        this.maxElementCount = xmlThreatProtectionConfigurations.getElementCount();
        this.maxAttributeCount = xmlThreatProtectionConfigurations.getAttributeCount();
        this.maxAttributeLength = xmlThreatProtectionConfigurations.getAttributeLength();
        this.entityExpansionLimit = xmlThreatProtectionConfigurations.getEntityExpansionLimit();
        this.maxChildrenPerElement = xmlThreatProtectionConfigurations.getChildrenPerElement();
    }

    public boolean isDtdEnabled() {
        return dtdEnabled;
    }

    public boolean isExternalEntitiesEnabled() {
        return externalEntitiesEnabled;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public int getMaxElementCount() {
        return maxElementCount;
    }

    public int getMaxAttributeCount() {
        return maxAttributeCount;
    }

    public int getMaxAttributeLength() {
        return maxAttributeLength;
    }

    public int getEntityExpansionLimit() {
        return entityExpansionLimit;
    }

    public int getMaxChildrenPerElement() {
        return maxChildrenPerElement;
    }

    public static XMLConfig getInstance() {
        return instance;
    }
}
