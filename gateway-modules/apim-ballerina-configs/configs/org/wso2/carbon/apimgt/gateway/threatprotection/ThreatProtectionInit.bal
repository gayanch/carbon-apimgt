package org.wso2.carbon.apimgt.gateway.threatprotection;

import org.wso2.carbon.apimgt.gateway.holders as holder;
import org.wso2.carbon.apimgt.gateway.dto as dto;

import org.wso2.carbon.apimgt.ballerina.threatprotection;

function initThreatProtection() (boolean) {
    dto:JSONThreatProtectionInfoDTO jsonThreatProtectionConf = holder:getJSONThreatProtectionConf();
    dto:XMLThreatProtectionInfoDTO xmlThreatProtectionConf = holder:getXMLThreatProtectionConf();

    threatprotection:configureJsonAnalyzer(jsonThreatProtectionConf, "THREAT_PROTECTION_JSON_POLICY_ADD");
    threatprotection:configureXmlAnalyzer(xmlThreatProtectionConf, "THREAT_PROTECTION_XML_POLICY_ADD");
    return true;
}