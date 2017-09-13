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

package org.wso2.carbon.apimgt.ballerina.threatprotection.configurations;

import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.JSONThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

/**
 * Configuration holding class for {@link org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.JSONAnalyzer}
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
