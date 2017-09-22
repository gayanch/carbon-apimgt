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

package org.wso2.carbon.apimgt.rest.api.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * XMLThreatProtectionInfoDTO
 */
public class XMLThreatProtectionInfoDTO {
    @JsonProperty("dtdEnabled")
    private boolean dtdEnabled;

    @JsonProperty("externalEntitiesEnabled")
    private boolean externalEntitiesEnabled;

    @JsonProperty("maxDepth")
    private int maxDepth;

    @JsonProperty("elementCount")
    private int elementCount;

    @JsonProperty("attributeCount")
    private int attributeCount;

    @JsonProperty("attributeLength")
    private int attributeLength;

    @JsonProperty("entityExpansionLimit")
    private int entityExpansionLimit;

    @JsonProperty("childrenPerElement")
    private int childrenPerElement;

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
