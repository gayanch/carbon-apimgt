package org.wso2.carbon.apimgt.ballerina.threatprotection.configurations;

import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.JSONThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

/**
 * Created by gayan on 9/11/17.
 */
public class JSONConfig {
    private int maxPropertyCount = 0;
    private int maxStringLength = 0;
    private int maxArrayElementCount = 0;
    private int maxKeyLength = 0;
    private int maxJsonDepth = 0;

    private static JSONConfig instance = new JSONConfig();

    private JSONConfig() {
        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        JSONThreatProtectionConfigurations jsonThreatProtectionConfigurations =
                apimConfigurations.getJsonThreatProtectionConfigurations();
        //configure analyzer
        maxPropertyCount = jsonThreatProtectionConfigurations.getPropertyCount();
        maxStringLength = jsonThreatProtectionConfigurations.getStringLength();
        maxArrayElementCount = jsonThreatProtectionConfigurations.getArrayElementCount();
        maxKeyLength = jsonThreatProtectionConfigurations.getKeyLength();
        maxJsonDepth = jsonThreatProtectionConfigurations.getMaxDepth();
    }

    public int getMaxPropertyCount() {
        return maxPropertyCount;
    }

    public int getMaxStringLength() {
        return maxStringLength;
    }

    public int getMaxArrayElementCount() {
        return maxArrayElementCount;
    }

    public int getMaxKeyLength() {
        return maxKeyLength;
    }

    public int getMaxJsonDepth() {
        return maxJsonDepth;
    }

    public static JSONConfig getInstance() {
        return instance;
    }

}
