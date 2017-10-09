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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.core.dao.ThreatProtectionDAO;
import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionJsonPolicy;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionXmlPolicy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Layer implementation class for Threat Protection Policies
 */
public class ThreatProtectionDAOImpl implements ThreatProtectionDAO {
    private static final String THREAT_PROTECTION_JSON_TABLE = "AM_THREAT_PROTECTION_JSON";
    private static final String THREAT_PROTECTION_XML_TABLE = "AM_THREAT_PROTECTION_XML";

    //DB Column names
    private static final String UUID = "UUID";
    private static final String API_ID = "API_ID";
    private static final String ENABLED = "ENABLED";

    private static final String MAX_FIELD_COUNT = "MAX_FIELD_COUNT";
    private static final String MAX_STRING_LENGTH = "MAX_STRING_LENGTH";
    private static final String MAX_ARRAY_ELEMENT_COUNT = "MAX_ARRAY_ELEMENT_COUNT";
    private static final String MAX_FIELD_LENGTH = "MAX_FIELD_LENGTH";
    private static final String MAX_DEPTH = "MAX_DEPTH";

    private static final String DTD_ENABLED = "DTD_ENABLED";
    private static final String EXTERNAL_ENTITIES_ENABLED = "EXTERNAL_ENTITIES_ENABLED";
    private static final String MAX_ELEMENT_COUNT = "MAX_ELEMENT_COUNT";
    private static final String MAX_ATTRIBUTE_COUNT = "MAX_ATTRIBUTE_COUNT";
    private static final String MAX_ATTRIBUTE_LENGTH = "MAX_ATTRIBUTE_LENGTH";
    private static final String ENTITY_EXPANSION_LIMIT = "ENTITY_EXPANSION_LIMIT";
    private static final String MAX_CHILDREN_PER_ELEMENT = "MAX_CHILDREN_PER_ELEMENT";

    private static final Logger log = LoggerFactory.getLogger(ThreatProtectionDAOImpl.class);

    @Override
    public List<ThreatProtectionJsonPolicy> getJsonPolicies() throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            return getJsonPolicies(connection);
        } catch (SQLException e) {
            String errorMsg = "Error getting JSON Threat Protection policies";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    @Override
    public List<ThreatProtectionXmlPolicy> getXmlPolicies() throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            return getXmlPolicies(connection);
        } catch (SQLException e) {
            String errorMsg = "Error getting XML Threat Protection policies";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    @Override
    public ThreatProtectionJsonPolicy getJsonPolicy(String apiId) throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            return getJsonPolicy(apiId, connection);
        } catch (SQLException e) {
            String errorMsg = "Error getting JSON Threat Protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    @Override
    public ThreatProtectionXmlPolicy getXmlPolicy(String apiId) throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            return getXmlPolicy(apiId, connection);
        } catch (SQLException e) {
            String errorMsg = "Error getting XML Threat Protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    @Override
    public void addJsonPolicy(ThreatProtectionJsonPolicy policy) throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            addJsonPolicy(policy, connection);
        } catch (SQLException e) {
            String errorMsg = "Error adding JSON Threat Protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    @Override
    public void addXmlPolicy(ThreatProtectionXmlPolicy policy) throws APIMgtDAOException {
        try (Connection connection = DAOUtil.getConnection()) {
            addXmlPolicy(policy, connection);
        } catch (SQLException e) {
            String errorMsg = "Error adding XML Threat Protection policy: Connection Error";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private List<ThreatProtectionJsonPolicy> getJsonPolicies(Connection connection) throws APIMgtDAOException {
        String sqlQuery = "SELECT UUID," +
                "API_ID," +
                "ENABLED," +
                "MAX_FIELD_COUNT," +
                "MAX_STRING_LENGTH," +
                "MAX_ARRAY_ELEMENT_COUNT," +
                "MAX_FIELD_LENGTH," +
                "MAX_DEPTH" +
                " FROM " + THREAT_PROTECTION_JSON_TABLE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                List<ThreatProtectionJsonPolicy> list = new ArrayList<>();
                while (rs.next()) {
                    ThreatProtectionJsonPolicy policy = new ThreatProtectionJsonPolicy();
                    policy.setUuid(rs.getString(UUID));
                    policy.setApiId(rs.getString(API_ID));
                    policy.setEnabled(rs.getBoolean(ENABLED));
                    policy.setMaxFieldCount(rs.getInt(MAX_FIELD_COUNT));
                    policy.setMaxStringLength(rs.getInt(MAX_STRING_LENGTH));
                    policy.setMaxArrayElementCount(rs.getInt(MAX_ARRAY_ELEMENT_COUNT));
                    policy.setMaxFieldLength(rs.getInt(MAX_FIELD_LENGTH));
                    policy.setMaxDepth(rs.getInt(MAX_DEPTH));
                    list.add(policy);
                }
                return list;
            }
        } catch (SQLException e) {
            String errorMsg = "Error getting JSON threat protection policies";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private ThreatProtectionJsonPolicy getJsonPolicy(String apiId, Connection connection) throws APIMgtDAOException {
        String sqlQuery = "SELECT UUID," +
                "API_ID," +
                "ENABLED," +
                "MAX_FIELD_COUNT," +
                "MAX_STRING_LENGTH," +
                "MAX_ARRAY_ELEMENT_COUNT," +
                "MAX_FIELD_LENGTH," +
                "MAX_DEPTH" +
                " FROM " + THREAT_PROTECTION_JSON_TABLE +
                " WHERE API_ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, apiId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                ThreatProtectionJsonPolicy policy = null;
                if (rs.next()) {
                    policy = new ThreatProtectionJsonPolicy();
                    policy.setUuid(rs.getString(UUID));
                    policy.setApiId(rs.getString(API_ID));
                    policy.setEnabled(rs.getBoolean(ENABLED));
                    policy.setMaxFieldCount(rs.getInt(MAX_FIELD_COUNT));
                    policy.setMaxStringLength(rs.getInt(MAX_STRING_LENGTH));
                    policy.setMaxArrayElementCount(rs.getInt(MAX_ARRAY_ELEMENT_COUNT));
                    policy.setMaxFieldLength(rs.getInt(MAX_FIELD_LENGTH));
                    policy.setMaxDepth(rs.getInt(MAX_DEPTH));
                } else {
                    log.warn("No JSON Threat Protection Policy found for API_ID: " + apiId);
                }
                return policy;
            }
        } catch (SQLException e) {
            String errorMsg = "Error getting JSON threat protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private void addJsonPolicy(ThreatProtectionJsonPolicy policy, Connection connection) throws APIMgtDAOException {
        String sqlQuery = "INSERT (UUID, " +
                "API_ID, " +
                "ENABLED, " +
                "MAX_FIELD_COUNT, " +
                "MAX_STRING_LENGTH, " +
                "MAX_ARRAY_ELEMENT_COUNT, " +
                "MAX_FIELD_LENGTH, " +
                "MAX_DEPTH) INTO " + THREAT_PROTECTION_JSON_TABLE +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, policy.getUuid());
            preparedStatement.setString(2, policy.getApiId());
            preparedStatement.setBoolean(3, policy.isEnabled());
            preparedStatement.setInt(4, policy.getMaxFieldCount());
            preparedStatement.setInt(5, policy.getMaxStringLength());
            preparedStatement.setInt(6, policy.getMaxArrayElementCount());
            preparedStatement.setInt(7, policy.getMaxFieldLength());
            preparedStatement.setInt(8, policy.getMaxDepth());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorMsg = "Error adding JSON Threat Protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private List<ThreatProtectionXmlPolicy> getXmlPolicies(Connection connection) throws APIMgtDAOException {
        String sqlQuery = "SELECT UUID," +
                "API_ID," +
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                List<ThreatProtectionXmlPolicy> list = new ArrayList<>();
                while (rs.next()) {
                    ThreatProtectionXmlPolicy policy = new ThreatProtectionXmlPolicy();
                    policy.setUuid(rs.getString(UUID));
                    policy.setApiId(rs.getString(API_ID));
                    policy.setEnabled(rs.getBoolean(ENABLED));
                    policy.setDtdEnabled(rs.getBoolean(DTD_ENABLED));
                    policy.setExternalEntitiesEnabled(rs.getBoolean(EXTERNAL_ENTITIES_ENABLED));
                    policy.setMaxDepth(rs.getInt(MAX_DEPTH));
                    policy.setMaxElementCount(rs.getInt(MAX_ELEMENT_COUNT));
                    policy.setMaxAttributeCount(rs.getInt(MAX_ATTRIBUTE_COUNT));
                    policy.setMaxAttributeLength(rs.getInt(MAX_ATTRIBUTE_LENGTH));
                    policy.setEntityExpansionLimit(rs.getInt(ENTITY_EXPANSION_LIMIT));
                    policy.setMaxChildrenPerElement(rs.getInt(MAX_CHILDREN_PER_ELEMENT));
                    list.add(policy);
                }
                return list;
            }
        } catch (SQLException e) {
            String errorMsg = "Error getting XML threat protection policies";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private ThreatProtectionXmlPolicy getXmlPolicy(String apiId, Connection connection) throws APIMgtDAOException {
        String sqlQuery = "SELECT UUID," +
                "API_ID," +
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, apiId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                ThreatProtectionXmlPolicy policy = null;
                if (rs.next()) {
                    policy = new ThreatProtectionXmlPolicy();
                    policy.setUuid(rs.getString(UUID));
                    policy.setApiId(rs.getString(API_ID));
                    policy.setEnabled(rs.getBoolean(ENABLED));
                    policy.setDtdEnabled(rs.getBoolean(DTD_ENABLED));
                    policy.setExternalEntitiesEnabled(rs.getBoolean(EXTERNAL_ENTITIES_ENABLED));
                    policy.setMaxDepth(rs.getInt(MAX_DEPTH));
                    policy.setMaxElementCount(rs.getInt(MAX_ELEMENT_COUNT));
                    policy.setMaxAttributeCount(rs.getInt(MAX_ATTRIBUTE_COUNT));
                    policy.setMaxAttributeLength(rs.getInt(MAX_ATTRIBUTE_LENGTH));
                    policy.setEntityExpansionLimit(rs.getInt(ENTITY_EXPANSION_LIMIT));
                    policy.setMaxChildrenPerElement((rs.getInt(MAX_CHILDREN_PER_ELEMENT)));
                } else {
                    log.warn("No XML Threat Protection Policy found for API_ID: " + apiId);
                }
                return policy;
            }
        } catch (SQLException e) {
            String errorMsg = "Error getting XML threat protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }

    private void addXmlPolicy(ThreatProtectionXmlPolicy policy, Connection connection) throws APIMgtDAOException {
        String sqlQuery = "INSERT (UUID, " +
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, policy.getUuid());
            preparedStatement.setString(2, policy.getApiId());
            preparedStatement.setBoolean(3, policy.isEnabled());
            preparedStatement.setBoolean(4, policy.isDtdEnabled());
            preparedStatement.setBoolean(5, policy.isExternalEntitiesEnabled());
            preparedStatement.setInt(6, policy.getMaxDepth());
            preparedStatement.setInt(7, policy.getMaxElementCount());
            preparedStatement.setInt(8, policy.getMaxAttributeCount());
            preparedStatement.setInt(9, policy.getMaxAttributeLength());
            preparedStatement.setInt(10, policy.getEntityExpansionLimit());
            preparedStatement.setInt(11, policy.getMaxChildrenPerElement());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorMsg = "Error adding XML Threat Protection policy";
            log.error(errorMsg, e);
            throw new APIMgtDAOException(errorMsg, e);
        }
    }
}
