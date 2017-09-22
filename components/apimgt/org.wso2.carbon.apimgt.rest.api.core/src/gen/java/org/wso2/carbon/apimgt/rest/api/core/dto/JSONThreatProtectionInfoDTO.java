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
 * JSONThreatProtectionInfoDTO
 */
public class JSONThreatProtectionInfoDTO {
    @JsonProperty("propertyCount")
    private int propertyCount;

    @JsonProperty("stringLength")
    private int stringLength;

    @JsonProperty("arrayElementCount")
    private int arrayElementCount;

    @JsonProperty("keyLength")
    private int keyLength;

    @JsonProperty("maxDepth")
    private int maxDepth;

    public void setPropertyCount(int propertyCount) {
        this.propertyCount = propertyCount;
    }

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }

    public void setArrayElementCount(int arrayElementCount) {
        this.arrayElementCount = arrayElementCount;
    }

    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    public int getStringLength() {
        return stringLength;
    }

    public int getArrayElementCount() {
        return arrayElementCount;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
}
