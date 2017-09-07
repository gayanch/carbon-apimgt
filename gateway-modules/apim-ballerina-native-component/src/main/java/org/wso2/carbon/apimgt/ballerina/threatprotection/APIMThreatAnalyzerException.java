package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.APIMThreatAnalyzer;

/**
 * Exception thrown by {@link APIMThreatAnalyzer} method
 */
public class APIMThreatAnalyzerException extends Exception {
    public APIMThreatAnalyzerException(String s) {
        super(s);
    }
}
