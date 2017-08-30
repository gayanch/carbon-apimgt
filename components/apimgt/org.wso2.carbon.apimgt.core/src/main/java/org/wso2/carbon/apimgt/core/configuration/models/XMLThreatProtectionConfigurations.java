package org.wso2.carbon.apimgt.core.configuration.models;

import org.wso2.carbon.kernel.annotations.Configuration;
import org.wso2.carbon.kernel.annotations.Element;

/**
 * Class to hold XML threat protection configurations
 */
@Configuration(description = "Configrations for xml threat protection")
public class XMLThreatProtectionConfigurations {

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
}
