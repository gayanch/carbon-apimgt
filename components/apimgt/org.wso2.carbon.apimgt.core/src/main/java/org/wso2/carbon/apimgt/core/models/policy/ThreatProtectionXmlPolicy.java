/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
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

package org.wso2.carbon.apimgt.core.models.policy;

/**
 * Models a policy for XML Threat Protection
 */
public class ThreatProtectionXmlPolicy {
    private String uuid;
    private boolean enabled;
    private String apiId;
    private boolean dtdEnabled;
    private boolean externalEntitiesEnabled;
    private int maxDepth;
    private int maxElementCount;
    private int maxAttributeCount;
    private int maxAttributeLength;
    private int entityExpansionLimit;
    private int maxChildrenPerElement;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public int getMaxElementCount() {
        return maxElementCount;
    }

    public void setMaxElementCount(int maxElementCount) {
        this.maxElementCount = maxElementCount;
    }

    public int getMaxAttributeCount() {
        return maxAttributeCount;
    }

    public void setMaxAttributeCount(int maxAttributeCount) {
        this.maxAttributeCount = maxAttributeCount;
    }

    public int getMaxAttributeLength() {
        return maxAttributeLength;
    }

    public void setMaxAttributeLength(int maxAttributeLength) {
        this.maxAttributeLength = maxAttributeLength;
    }

    public int getEntityExpansionLimit() {
        return entityExpansionLimit;
    }

    public void setEntityExpansionLimit(int entityExpansionLimit) {
        this.entityExpansionLimit = entityExpansionLimit;
    }

    public int getMaxChildrenPerElement() {
        return maxChildrenPerElement;
    }

    public void setMaxChildrenPerElement(int maxChildrenPerElement) {
        this.maxChildrenPerElement = maxChildrenPerElement;
    }
}
