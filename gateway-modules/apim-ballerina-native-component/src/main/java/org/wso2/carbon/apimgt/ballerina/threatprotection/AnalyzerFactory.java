/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.wso2.carbon.apimgt.ballerina.threatprotection.json.JSONAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.xml.XMLAnalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class to create {@link APIMThreatAnalyzer} objects
 */
public class AnalyzerFactory {
    public static final String T_TEXT_JSON = "text/json";
    public static final String T_APPLICATION_JSON = "application/json";
    public static final String T_TEXT_XML = "text/xml";
    public static final String T_APPLICATION_XML = "application/xml";

    private static Map<String, APIMThreatAnalyzer> xmlAnlyzers;
    private static Map<String, APIMThreatAnalyzer> jsonAnalyzers;

    static {
        xmlAnlyzers = new HashMap<>();
        jsonAnalyzers = new HashMap<>();
    }

    /**
     * Get {@link APIMThreatAnalyzer} objects to analyze json/xml payloads
     *
     * @param type Content-Type of the payload
     * @param id Unique id of the API
     * @return {@link APIMThreatAnalyzer} which holds cache manager object
     */
    public static APIMThreatAnalyzer getAnalyzer(String type, String id) {
        APIMThreatAnalyzer analyzer = null;
        if (T_TEXT_XML.equalsIgnoreCase(type) || T_APPLICATION_XML.equalsIgnoreCase(type)) {
            analyzer = xmlAnlyzers.computeIfAbsent(id, k -> new XMLAnalyzer());
        } else if (T_APPLICATION_JSON.equalsIgnoreCase(type) || T_TEXT_JSON.equalsIgnoreCase(type)) {
            analyzer = jsonAnalyzers.computeIfAbsent(id, k -> new JSONAnalyzer());
        }

        return analyzer;
    }
}
