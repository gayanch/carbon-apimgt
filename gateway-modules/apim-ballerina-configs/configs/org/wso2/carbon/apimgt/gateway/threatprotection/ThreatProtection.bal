package org.wso2.carbon.apimgt.gateway.threatprotection;

import ballerina.lang.errors;
import ballerina.lang.messages;
import ballerina.lang.system;
import ballerina.net.http;

import org.wso2.carbon.apimgt.ballerina.threatprotection;

function requestInterceptor(message m) (boolean, message) {
    system:println("invoking threat protection interceptor");
    string contentType;
    try {
        contentType = messages:getHeader(m, "Content-Type");
    } catch(errors:Error err) {
        //no content type
        system:println("Threat Protection: no Content-Type declared");
        return true, m;
    }

    if (contentType == "text/json" || contentType == "application/json") {
        string payload = messages:getStringPayload(m);
        boolean ok;
        message response = {};
        ok, _ = threatprotection:analyze("json", payload);

        if (!ok) {
            http:setStatusCode(response, 400);
            messages:setStringPayload(response, "Malformed Request");
            return false, response;
        }
    }

    if (contentType == "text/xml" || contentType == "application/xml") {
        string payload = messages:getStringPayload(m);
        boolean ok;
        message response = {};
        ok, _ = threatprotection:analyze("xml", payload);

        if (!ok) {
            http:setStatusCode(response, 400);
            messages:setStringPayload(response, "Malformed Request");
            return false, response;
        }
    }

    return true, m;
}

function responseInterceptor (message m) (boolean, message) {
    system:println("invoking response threat protection interceptor");
    return true, m;
}