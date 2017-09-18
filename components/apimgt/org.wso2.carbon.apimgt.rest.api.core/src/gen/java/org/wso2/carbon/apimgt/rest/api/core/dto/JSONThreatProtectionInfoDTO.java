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
