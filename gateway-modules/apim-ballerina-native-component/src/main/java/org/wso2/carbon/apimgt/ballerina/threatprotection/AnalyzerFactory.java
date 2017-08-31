package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.wso2.carbon.apimgt.ballerina.threatprotection.json.JSONAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.xml.XMLAnalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gayan on 8/30/17.
 */
public class AnalyzerFactory {
    public static final String T_JSON = "json";
    public static final String T_XML = "xml";

    private static Map<String, APIMThreatAnalyzer> xmlAnlyzers;
    private static Map<String, APIMThreatAnalyzer> jsonAnalyzers;

    static {
        xmlAnlyzers = new HashMap<>();
        jsonAnalyzers = new HashMap<>();
    }

    public static APIMThreatAnalyzer getAnalyzer(String type, String id) {
        APIMThreatAnalyzer analyzer = null;
        if (T_XML.equalsIgnoreCase(type)) {
            analyzer = xmlAnlyzers.computeIfAbsent(id, k -> new XMLAnalyzer());
        } else if (T_JSON.equalsIgnoreCase(type)) {
            analyzer = jsonAnalyzers.computeIfAbsent(id, k -> new JSONAnalyzer());
        }

        return analyzer;
    }
}
