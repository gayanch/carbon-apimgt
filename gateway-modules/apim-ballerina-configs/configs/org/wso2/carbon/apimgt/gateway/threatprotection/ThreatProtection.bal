package org.wso2.carbon.apimgt.gateway.threatprotection;

import ballerina.lang.errors;
import ballerina.lang.messages;
import ballerina.lang.system;
import ballerina.net.http;

import org.wso2.carbon.apimgt.ballerina.threatprotection;

function requestInterceptor(message m) (boolean, message) {
    system:println("invoking threat protection interceptor");
    initThreatProtection();
    return analyzePayload(m);
}

function responseInterceptor (message m) (boolean, message) {
    system:println("invoking response threat protection interceptor");
    return true, m;
}

function analyzePayload(message m) (boolean, message) {
    string contentType;
    try {
        contentType = messages:getHeader(m, "Content-Type");
    } catch (errors:Error e) {
        system:println("Threat Protection: No Content-Type declared");
        return true, m;
    }

    string payload = messages:getStringPayload(m);
    boolean ok;
    string errMessage;
    ok, errMessage = threatprotection:analyze(contentType, payload);

    if (ok) {
        return true, m;
    }

    system:println("Threat Protection: " + errMessage);
    message response = {};
    http:setStatusCode(response, 400);
    messages:setStringPayload(response, "Malformed Payload");

    return false, response;
}