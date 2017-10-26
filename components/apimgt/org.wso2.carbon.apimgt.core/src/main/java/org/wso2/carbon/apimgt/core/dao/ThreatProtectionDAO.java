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

package org.wso2.carbon.apimgt.core.dao;

import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionJsonPolicy;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionXmlPolicy;

import java.util.List;

/**
 * Provides access to Threat Protection data layer
 */
public interface ThreatProtectionDAO {

    /**
     * Get all JSON policies as a list
     * @return A list containing {@link ThreatProtectionJsonPolicy} objects.
     * An Empty list will be returned if no policies found.
     * @throws APIMgtDAOException if policy retrieval fails
     */
    List<ThreatProtectionJsonPolicy> getJsonPolicies() throws APIMgtDAOException;

    /**
     * Get all XML policies as a list
     * @return A list containing all {@link ThreatProtectionXmlPolicy} objects.
     * An Empty list will be returned if no policies found.
     * @throws APIMgtDAOException if policy retrieval fails
     */
    List<ThreatProtectionXmlPolicy> getXmlPolicies() throws APIMgtDAOException;

    /**
     * Get a JSON policy associated with apiId
     * @param apiId API_ID
     * @return  {@link ThreatProtectionJsonPolicy}, if no policy is found for apiID, a null will be returned.
     * @throws APIMgtDAOException if policy retrieval fails
     */
    ThreatProtectionJsonPolicy getJsonPolicy(String apiId) throws APIMgtDAOException;

    /**
     * Get an XML policy associated with apiId
     * @param apiId API_ID
     * @return {@link ThreatProtectionXmlPolicy}, if no policy is found for apiID, a null will be returned.
     * @throws APIMgtDAOException if policy retrieval fails
     */
    ThreatProtectionXmlPolicy getXmlPolicy(String apiId) throws APIMgtDAOException;

    /**
     * Adds a JSON policy to the database
     * @param policy {@link ThreatProtectionJsonPolicy}
     * @throws APIMgtDAOException if fails to add the policy
     */
    void addJsonPolicy(ThreatProtectionJsonPolicy policy) throws APIMgtDAOException;

    /**
     * Adds an XML policy to the database
     * @param policy {@link ThreatProtectionXmlPolicy}
     * @throws APIMgtDAOException if fails to add the policy
     */
    void addXmlPolicy(ThreatProtectionXmlPolicy policy) throws APIMgtDAOException;

    /**
     * Updates a JSON policy associated with policy.apiId
     * @param policy {@link ThreatProtectionJsonPolicy}
     * @throws APIMgtDAOException if fails to update the policy
     */
    void updateJsonPolicy(ThreatProtectionJsonPolicy policy) throws APIMgtDAOException;

    /**
     * Updates an XML policy associated with policy.apiId
     * @param policy {@link ThreatProtectionXmlPolicy}
     * @throws APIMgtDAOException if fails to update the policy
     */
    void updateXmlPolicy(ThreatProtectionXmlPolicy policy) throws APIMgtDAOException;

    /**
     * Checks whether a JSON policy exists for the apiId
     * @param apiId API_ID
     * @return true if policy exists, false otherwise
     * @throws APIMgtDAOException if fails to get the existence status of the policy
     */
    boolean isXmlPolicyExists(String apiId) throws APIMgtDAOException;

    /**
     * Checks whether a XML policy exists for the apiId
     * @param apiId API_ID
     * @return true if policy exists, false otherwise
     * @throws APIMgtDAOException if fails to get the existence status of the policy
     */
    boolean isJsonPolicyExists(String apiId) throws APIMgtDAOException;
}
