package org.wso2.carbon.apimgt.ballerina.threatprotection.configurations;

import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.XMLThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

/**
 * Created by gayan on 9/11/17.
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
