package org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer;

import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;

/**
 * Interface for json/xml analyzers
 */
public interface APIMThreatAnalyzer {
    /**
     * Analyzes json/xml payloads for malicious content
     *
     * @param payload json/xml payload
     * @throws APIMThreatAnalyzerException
     */
    void analyze(String payload) throws APIMThreatAnalyzerException;
}
