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
