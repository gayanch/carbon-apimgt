/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.XMLThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

/**
 * Created by gayan on 8/30/17.
 */
public class ConfigTest {
    @Test
    public void testConfigRead() {
        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        XMLThreatProtectionConfigurations conf =  apimConfigurations.getXmlThreatProtectionConfigurations();
        Assert.assertFalse(conf.isDtdEnabled());
        Assert.assertFalse(conf.isExternalEntitiesEnabled());
        Assert.assertEquals(1000, conf.getMaxDepth());
        Assert.assertEquals(10000, conf.getElementCount());
        Assert.assertEquals(1000, conf.getAttributeCount());
        Assert.assertEquals(1000, conf.getAttributeLength());
        Assert.assertEquals(10000, conf.getEntityExpansionLimit());
    }
}
