
package org.wso2.carbon.apimgt.ballerina.threatprotection;

import ballerina.doc;


@doc:Description { value: "Analyzes payload for threats" }
@doc:Param { value: "payloadType: payload type (json/xml)" }
@doc:Param { value: "payload: json or xml payload to analyze" }
@doc:Return { value: "boolean: true of no threats detected, false otherwise" }
@doc:Return { value: "string: error information" }
native function analyze(string payloadType, string payload) (boolean, string);

@doc:Description { value: "Configures the analyzers" }
@doc:Param { value: "jsonInfo: ballerina struct containing JSONAnalyzer configurations" }
@doc:Param { value: "xmlInfo: ballerina struct containing XMLAnalyzer configurations" }
@doc:Return { value: "boolean: true if success, false otherwise" }
native function configure(any jsonInfo, any xmlInfo) (boolean);