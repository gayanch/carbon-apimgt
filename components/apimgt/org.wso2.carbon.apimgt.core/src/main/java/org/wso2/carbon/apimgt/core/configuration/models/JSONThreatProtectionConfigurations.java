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
 * Class to hold JSON threat protection configurations
 */
@Configuration(description = "Configurations for json threat protection")
public class JSONThreatProtectionConfigurations {

    @Element(description = "Enabled/Disabled Status")
    private boolean enabled = true;

    @Element(description = "API ID of the Applicable API")
    private String apiId = "GLOBAL";

    @Element(description = "Maximum number of properties")
    private int propertyCount = 10000;

    @Element(description = "Maximum length of string values")
    private int stringLength = 100;

    @Element(description = "Maximum element count for arrays")
    private int arrayElementCount = 10000;

    @Element(description = "Maximum length(in chars) of json keys")
    private int keyLength = 10000;

    @Element(description = "Maximum depth of a json document")
    private int maxDepth = 10000;

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

    public int getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(int propertyCount) {
        this.propertyCount = propertyCount;
    }

    public int getStringLength() {
        return stringLength;
    }

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }

    public int getArrayElementCount() {
        return arrayElementCount;
    }

    public void setArrayElementCount(int arrayElementCount) {
        this.arrayElementCount = arrayElementCount;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
