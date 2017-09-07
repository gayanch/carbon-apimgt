package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.json.JSONAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.AnalyzerPool;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.JSONAnalyzerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.XMLAnalyzerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.xml.XMLAnalyzer;

/**
 * Holds the object pools for XML and JSON Analyzers
 */
public class AnalyzerHolder {
    private static final String T_TEXT_XML = "text/xml";
    private static final String T_APPLICATION_XML = "application/xml";
    private static final String T_TEXT_JSON = "text/json";
    private static final String T_APPLICATION_JSON = "application/json";

    private static Logger logger = LoggerFactory.getLogger(AnalyzerHolder.class);

    private static AnalyzerPool<XMLAnalyzer> xmlAnalyzerAnalyzerPool;
    private static AnalyzerPool<JSONAnalyzer> jsonAnalyzerAnalyzerPool;

    static {
        xmlAnalyzerAnalyzerPool = new AnalyzerPool<>(new XMLAnalyzerFactory());
        jsonAnalyzerAnalyzerPool = new AnalyzerPool<>(new JSONAnalyzerFactory());
    }

    private AnalyzerHolder() {}

    public static APIMThreatAnalyzer getAnalyzer(String contentType) {
        APIMThreatAnalyzer analyzer = null;
        if (T_TEXT_XML.equalsIgnoreCase(contentType) || T_APPLICATION_XML.equalsIgnoreCase(contentType)) {
            try {
                analyzer = xmlAnalyzerAnalyzerPool.borrowObject();
            } catch (Exception e) {
                logger.error("Threat Protection: Failed to create XMLAnalyzer, " + e.getMessage());
            }
        } else if (T_TEXT_JSON.equalsIgnoreCase(contentType) || T_APPLICATION_JSON.equalsIgnoreCase(contentType)) {
            try {
                analyzer = jsonAnalyzerAnalyzerPool.borrowObject();
            } catch (Exception e) {
                logger.error("Threat Protection: Failed to create JSONAnalyzer, " + e.getMessage());
            }
        }
        return analyzer;
    }

    public static void returnObject(String contentType, APIMThreatAnalyzer analyzer) {
        if (T_TEXT_XML.equalsIgnoreCase(contentType) || T_APPLICATION_XML.equalsIgnoreCase(contentType)) {
           xmlAnalyzerAnalyzerPool.returnObject((XMLAnalyzer)analyzer);

        } else if (T_TEXT_JSON.equalsIgnoreCase(contentType) || T_APPLICATION_JSON.equalsIgnoreCase(contentType)) {
           jsonAnalyzerAnalyzerPool.returnObject((JSONAnalyzer)analyzer);
        }
    }
}
