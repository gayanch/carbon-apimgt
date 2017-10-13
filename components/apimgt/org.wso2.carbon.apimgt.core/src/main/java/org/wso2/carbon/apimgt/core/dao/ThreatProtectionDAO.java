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
    List<ThreatProtectionJsonPolicy> getJsonPolicies() throws APIMgtDAOException;

    List<ThreatProtectionXmlPolicy> getXmlPolicies() throws APIMgtDAOException;

    ThreatProtectionJsonPolicy getJsonPolicy(String apiId) throws APIMgtDAOException;

    ThreatProtectionXmlPolicy getXmlPolicy(String apiId) throws APIMgtDAOException;

    void addJsonPolicy(ThreatProtectionJsonPolicy policy) throws APIMgtDAOException;

    void addXmlPolicy(ThreatProtectionXmlPolicy policy) throws APIMgtDAOException;

    boolean isXmlPolicyExists(String apiId) throws APIMgtDAOException;

    boolean isJsonPolicyExists(String apiId) throws APIMgtDAOException;
}
