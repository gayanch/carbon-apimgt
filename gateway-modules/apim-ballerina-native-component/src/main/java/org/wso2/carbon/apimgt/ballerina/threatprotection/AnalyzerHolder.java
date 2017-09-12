package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.APIMThreatAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.JSONAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.AnalyzerPool;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.JSONAnalyzerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.pool.XMLAnalyzerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.XMLAnalyzer;

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
    private static GenericObjectPoolConfig poolConfig;

    static {
        poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(400);
        poolConfig.setBlockWhenExhausted(false);
        poolConfig.setMaxWaitMillis(0);

        xmlAnalyzerAnalyzerPool = new AnalyzerPool<>(new XMLAnalyzerFactory(), poolConfig);
        jsonAnalyzerAnalyzerPool = new AnalyzerPool<>(new JSONAnalyzerFactory(), poolConfig);
    }

    private AnalyzerHolder() {}

    public static APIMThreatAnalyzer getAnalyzer(String contentType) {
        APIMThreatAnalyzer analyzer = null;
        if (T_TEXT_XML.equalsIgnoreCase(contentType) || T_APPLICATION_XML.equalsIgnoreCase(contentType)) {
            try {
                analyzer = xmlAnalyzerAnalyzerPool.borrowObject();
                System.out.println("XML: Created: " + xmlAnalyzerAnalyzerPool.getCreatedCount());
                System.out.println("XML Borrowed: " + xmlAnalyzerAnalyzerPool.getBorrowedCount());
                System.out.println("XML Returned: " + xmlAnalyzerAnalyzerPool.getReturnedCount());
                System.out.println("XML Destroyed: " + xmlAnalyzerAnalyzerPool.getDestroyedCount());
                System.out.println("XML Mean wait: " + xmlAnalyzerAnalyzerPool.getMeanBorrowWaitTimeMillis());
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
//        switch (contentType) {
//            case T_APPLICATION_JSON:
//            case T_TEXT_JSON:
//                analyzer = new JSONAnalyzer();
//                break;
//
//            case T_APPLICATION_XML:
//            case T_TEXT_XML:
//                analyzer = new XMLAnalyzer();
//                break;
//        }
        return analyzer;
    }

    public static void returnObject(APIMThreatAnalyzer analyzer) {
        if (analyzer instanceof JSONAnalyzer) {
            jsonAnalyzerAnalyzerPool.returnObject((JSONAnalyzer) analyzer);
        } else if (analyzer instanceof XMLAnalyzer) {
            xmlAnalyzerAnalyzerPool.returnObject((XMLAnalyzer) analyzer);
        }
    }
}
