package org.wso2.carbon.apimgt.gateway.services;

import ballerina.lang.messages;
import ballerina.net.http;
import ballerina.net.jms;
import ballerina.lang.system;

@jms:config {
    initialContextFactory:"org.apache.activemq.jndi.ActiveMQInitialContextFactory",
    providerUrl:"tcp://localhost:61616",
    connectionFactoryType:"topic",
    connectionFactoryName:"TopicConnectionFactory",
    destination:"ThreatProtectionTopic"
}
service<jms> ThreatProtectionJmsService {

    @http:GET {}
    resource onMessage (message m) {
        json event = messages:getJsonPayload(m);
        system:println(event);
    }

}

