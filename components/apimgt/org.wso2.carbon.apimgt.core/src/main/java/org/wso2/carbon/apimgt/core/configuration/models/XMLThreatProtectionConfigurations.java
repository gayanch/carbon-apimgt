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

package org.wso2.carbon.apimgt.core.configuration.models;

import org.wso2.carbon.kernel.annotations.Configuration;
import org.wso2.carbon.kernel.annotations.Element;

/**
 * Class to hold XML threat protection configurations
 */
@Configuration(description = "Configrations for xml threat protection")
public class XMLThreatProtectionConfigurations {

    @Element(description = "Enabled/Disabled Status")
    private boolean enabled = true;

    @Element(description = "API ID of the Applicable API")
    private String apiId = "GLOBAL";

    @Element(description = "DTD enabled")
    private boolean dtdEnabled = false;

    @Element(description = "Ecternal entities enabled")
    private boolean externalEntitiesEnabled = false;

    @Element(description = "Maximum Depth of a XML Doc")
    private int maxDepth = 1000;

    @Element(description = "Maximum element count")
    private int elementCount = 10000;

    @Element(description = "Maximum attribute count")
    private int attributeCount = 1000;

    @Element(description = "Maximum Length (in chars) of Attributes")
    private int attributeLength = 1000;

    @Element(description = "Entity expansion limit")
    private int entityExpansionLimit = 10000;

    @Element(description = "Maximum children per element")
    private int childrenPerElement = 1000;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public boolean isDtdEnabled() {
        return dtdEnabled;
    }

    public void setDtdEnabled(boolean dtdEnabled) {
        this.dtdEnabled = dtdEnabled;
    }

    public boolean isExternalEntitiesEnabled() {
        return externalEntitiesEnabled;
    }

    public void setExternalEntitiesEnabled(boolean externalEntitiesEnabled) {
        this.externalEntitiesEnabled = externalEntitiesEnabled;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public int getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(int attributeCount) {
        this.attributeCount = attributeCount;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public int getEntityExpansionLimit() {
        return entityExpansionLimit;
    }

    public void setEntityExpansionLimit(int entityExpansionLimit) {
        this.entityExpansionLimit = entityExpansionLimit;
    }

    public int getChildrenPerElement() {
        return childrenPerElement;
    }

    public void setChildrenPerElement(int childrenPerElement) {
        this.childrenPerElement = childrenPerElement;
    }
}
