package org.wso2.carbon.apimgt.gateway.threatprotection;

import org.wso2.carbon.apimgt.gateway.holders as holder;
import org.wso2.carbon.apimgt.gateway.dto as dto;
import org.wso2.carbon.apimgt.ballerina.threatprotection;

function init() (boolean) {
    dto:JSONThreatProtectionInfo jsonThreatProtectionConf = holder:getJSONThreatProtectionConf();
    dto:XMLThreatProtectionInfo xmlThreatProtectionConf = holder:getXMLThreatProtectionConf();

    return threatprotection:configure(jsonThreatProtectionConf, xmlThreatProtectionConf);
}