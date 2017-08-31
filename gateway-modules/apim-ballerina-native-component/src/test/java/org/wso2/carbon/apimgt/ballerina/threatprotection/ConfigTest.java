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
