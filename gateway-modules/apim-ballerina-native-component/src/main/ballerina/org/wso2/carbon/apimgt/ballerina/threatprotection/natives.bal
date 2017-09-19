
package org.wso2.carbon.apimgt.ballerina.threatprotection;

import ballerina.doc;
import org.wso2.carbon.apimgt.gateway.dto;

@doc:Description { value: "Analyzes payload for threats" }
@doc:Param { value: "payloadType: payload type (json/xml)" }
@doc:Param { value: "payload: json or xml payload to analyze" }
@doc:Return { value: "boolean: true of no threats detected, false otherwise" }
@doc:Return { value: "string: error information" }
native function analyze(string payloadType, string payload) (boolean, string);

native function configure(dto:JSONThreatProtectionInfoDTO jsonInfo, dto:XMLThreatProtectionInfoDTO xmlInfo) (boolean);