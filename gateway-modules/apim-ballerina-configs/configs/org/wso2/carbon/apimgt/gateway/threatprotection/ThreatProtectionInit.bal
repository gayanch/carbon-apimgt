package org.wso2.carbon.apimgt.gateway.threatprotection;

import ballerina.lang.errors;
import ballerina.lang.jsons;
import ballerina.lang.system;

import org.wso2.carbon.apimgt.gateway.holders as holder;
import org.wso2.carbon.apimgt.gateway.dto as dto;
import org.wso2.carbon.apimgt.gateway.utils;

import org.wso2.carbon.apimgt.ballerina.threatprotection;

function initThreatProtection() (boolean) {
    dto:JSONThreatProtectionInfoDTO jsonThreatProtectionConf = holder:getJSONThreatProtectionConf();
    dto:XMLThreatProtectionInfoDTO xmlThreatProtectionConf = holder:getXMLThreatProtectionConf();

    threatprotection:configureJsonAnalyzer(jsonThreatProtectionConf, "THREAT_PROTECTION_JSON_POLICY_ADD");
    threatprotection:configureXmlAnalyzer(xmlThreatProtectionConf, "THREAT_PROTECTION_XML_POLICY_ADD");

    //setting per-API policies
    try {
        json jsonPolicyList = utils:getThreatProtectionJsonPolicies();
        setPerApiJsonPolicies(jsonPolicyList);
        system:println("====JSON Policy List====");
        system:println(jsonPolicyList);
    } catch (errors:Error error) {
        system:println("Error occured while setting per-API JSON threat protection policies");
    }

    try {
        json xmlPolicyList = utils:getThreatProtectionXmlPolicies();
        setPerApiXmlPolicies(xmlPolicyList);
        system:println("====XML Policy List====");
        system:println(xmlPolicyList);
    } catch (errors:Error error) {
        system:println("Error occured while setting per-API XML threat protection policies");
    }


    return true;
}

function setPerApiJsonPolicies(json policyList) {
    json list = policyList.list;
    int numPolicies = jsons:getInt(list, "$.length()");
    int i = 0;
    dto:JSONThreatProtectionInfoDTO jsonThreatProtectionConf = {};
    while (i < numPolicies) {
        jsonThreatProtectionConf = utils:fromJSONToJSONThreatProtectionInfoDTO(list[i]);
        threatprotection:configureJsonAnalyzer(jsonThreatProtectionConf, "THREAT_PROTECTION_JSON_POLICY_ADD");
        i = i + 1;
    }
}

function setPerApiXmlPolicies(json policyList) {
    json list = policyList.list;
    int numPolicies = jsons:getInt(list, "$.length()");
    int i = 0;
    dto:XMLThreatProtectionInfoDTO xmlThreatProtectionConf = {};
    while (i < numPolicies) {
        xmlThreatProtectionConf = utils:fromJSONToXMLThreatProtectionInfoDTO(list[i]);
        threatprotection:configureXmlAnalyzer(xmlThreatProtectionConf, "THREAT_PROTECTION_XML_POLICY_ADD");
        i = i + 1;
    }
}