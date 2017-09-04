package org.wso2.carbon.apimgt.core.configuration.models;

import org.wso2.carbon.kernel.annotations.Configuration;
import org.wso2.carbon.kernel.annotations.Element;

/**
 * Class to hold JSON threat protection configurations
 */
@Configuration(description = "Configurations for json threat protection")
public class JSONThreatProtectionConfigurations {

    @Element(description = "Maximum number of properties")
    private int propertyCount = 10000;

    @Element(description = "Maximum length of string values")
    private int stringLength = 10000;

    @Element(description = "Maximum element count for arrays")
    private int arrayElementCount = 10000;

    @Element(description = "Maximum length(in chars) of json keys")
    private int keyLength = 10000;

    @Element(description = "Maximum depth of a json document")
    private int maxDepth = 10000;

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

    public int getMaxDepth() { return maxDepth; }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
