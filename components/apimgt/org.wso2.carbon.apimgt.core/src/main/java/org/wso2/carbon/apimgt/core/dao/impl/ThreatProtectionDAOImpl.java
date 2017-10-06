/*
 *
 *   Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.carbon.apimgt.core.dao.impl;

import org.wso2.carbon.apimgt.core.dao.ThreatProtectionDAO;
import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionJsonPolicy;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionXmlPolicy;

import java.util.List;

/**
 * DAO Layer implementation class for Threat Protection Policies
 */
public class ThreatProtectionDAOImpl implements ThreatProtectionDAO {
    private static final String THREAT_PROTECTION_JSON_TABLE = "AM_THREAT_PROTECTION_JSON";
    private static final String THREAT_PROTECTION_XML_TABLE = "AM_THREAT_PROTECTION_XML";

    @Override
    public List<ThreatProtectionJsonPolicy> getJsonPolicies() throws APIMgtDAOException {
        String sql = "SELECT API_ID," +
                "ENABLED, MAX_FIELD_COUNT," +
                "MAX_STRING_LENGTH," +
                "MAX_ARRAY_ELEMENT_COUNT," +
                "MAX_FIELD_LENGTH," +
                "MAX_DEPTH" +
                " FROM " + THREAT_PROTECTION_JSON_TABLE;
        return null;
    }

    @Override
    public List<ThreatProtectionXmlPolicy> getXmlPolicies() throws APIMgtDAOException {
        String sql = "SELECT API_ID," +
                "ENABLED," +
                "DTD_ENABLED," +
                "EXTERNAL_ENTITIES_ENABLED," +
                "MAX_DEPTH," +
                "MAX_ELEMENT_COUNT," +
                "MAX_ATTRIBUTE_COUNT," +
                "MAX_ATTRIBUTE_LENGTH," +
                "ENTITY_EXPANSION_LIMIT," +
                "MAX_CHILDREN_PER_ELEMENT" +
                " FROM " + THREAT_PROTECTION_XML_TABLE;
        return null;
    }

    @Override
    public ThreatProtectionJsonPolicy getJsonPolicy(String apiId) throws APIMgtDAOException {
        String sql = "SELECT API_ID," +
                "ENABLED, MAX_FIELD_COUNT," +
                "MAX_STRING_LENGTH," +
                "MAX_ARRAY_ELEMENT_COUNT," +
                "MAX_FIELD_LENGTH," +
                "MAX_DEPTH" +
                " FROM " + THREAT_PROTECTION_JSON_TABLE +
                " WHERE API_ID = ?";
        return null;
    }

    @Override
    public ThreatProtectionXmlPolicy getXmlPolicy(String apiId) throws APIMgtDAOException {
        String sql = "SELECT API_ID," +
                "ENABLED," +
                "DTD_ENABLED," +
                "EXTERNAL_ENTITIES_ENABLED," +
                "MAX_DEPTH," +
                "MAX_ELEMENT_COUNT," +
                "MAX_ATTRIBUTE_COUNT," +
                "MAX_ATTRIBUTE_LENGTH," +
                "ENTITY_EXPANSION_LIMIT," +
                "MAX_CHILDREN_PER_ELEMENT" +
                " FROM " + THREAT_PROTECTION_XML_TABLE +
                " WHERE API_ID = ?";
        return null;
    }

    @Override
    public void addJsonPolicy(ThreatProtectionJsonPolicy policy) throws APIMgtDAOException {
        String sql = "INSERT (UUID, " +
                "API_ID, " +
                "ENABLED, " +
                "MAX_FIELD_COUNT, " +
                "MAX_STRING_LENGTH, " +
                "MAX_ARRAY_ELEMENT_COUNT, " +
                "MAX_FIELD_LENGTH, " +
                "MAX_DEPTH) INTO " + THREAT_PROTECTION_JSON_TABLE +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public void addXmlPolicy(ThreatProtectionXmlPolicy policy) throws APIMgtDAOException {
        String sql = "INSERT (UUID, " +
                "API_ID, " +
                "ENABLED, " +
                "DTD_ENABLED, " +
                "EXTERNAL_ENTITIES_ENABLED, " +
                "MAX_DEPTH, " +
                "MAX_ELEMENT_COUNT, " +
                "MAX_ATTRIBUTE_COUNT, " +
                "MAX_ATTRIBUTE_LENGTH, " +
                "ENTITY_EXPANSION_LIMIT, " +
                "MAX_CHILDREN_PER_ELEMENT) INTO " + THREAT_PROTECTION_XML_TABLE +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
