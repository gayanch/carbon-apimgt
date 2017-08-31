package org.wso2.carbon.apimgt.ballerina.threatprotection;

/**
 * Created by gayan on 8/30/17.
 */
public interface APIMThreatAnalyzer {
    void analyze(String payload) throws APIMThreatAnalyzerException;
}
