package org.wso2.carbon.apimgt.gateway.dto;

struct GatewayConfDTO {
    KeyManagerInfoDTO keyManagerInfo;
    JWTInfoDTO jwtInfo;
    AnalyticsInfoDTO analyticsInfo;
    ThrottlingInfoDTO throttlingInfo;
    JSONThreatProtectionInfoDTO jsonThreatProtectionInfo;
    XMLThreatProtectionInfoDTO xmlThreatProtectionInfo;
}

struct KeyManagerInfoDTO {
    string dcrEndpoint;
    string tokenEndpoint;
    string revokeEndpoint;
    string introspectEndpoint;
    CredentialsDTO credentials;
}

struct JWTInfoDTO {
    boolean enableJWTGeneration;
    string jwtHeader;
}

struct AnalyticsInfoDTO {
    boolean enabled;
    string type;
    string serverURL;
    string authServerURL;
    CredentialsDTO credentials;
}

struct ThrottlingInfoDTO {
    boolean enabled;
    string type;
    string serverURL;
    string authServerURL;
    CredentialsDTO credentials;
}

struct CredentialsDTO {
    string username;
    string password;
}

struct XMLThreatProtectionInfoDTO {
    string apiId;
    boolean dtdEnabled;
    boolean externalEntitiesEnabled;
    int maxDepth;
    int elementCount;
    int attributeCount;
    int attributeLength;
    int entityExpansionLimit;
    int childrenPerElement;
}

struct JSONThreatProtectionInfoDTO {
    string apiId;
    int propertyCount;
    int stringLength;
    int arrayElementCount;
    int keyLength;
    int maxDepth;
}