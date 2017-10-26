/*
 *
 *   Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.carbon.apimgt.rest.api.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.core.api.APIGateway;
import org.wso2.carbon.apimgt.core.dao.ThreatProtectionDAO;
import org.wso2.carbon.apimgt.core.dao.impl.DAOFactory;
import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;
import org.wso2.carbon.apimgt.core.exception.GatewayException;
import org.wso2.carbon.apimgt.core.impl.APIManagerFactory;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionJsonPolicy;
import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionXmlPolicy;
import org.wso2.carbon.apimgt.rest.api.core.*;
import org.wso2.carbon.apimgt.rest.api.core.dto.*;


import java.util.List;
import org.wso2.carbon.apimgt.rest.api.core.NotFoundException;

import java.io.InputStream;

import org.wso2.carbon.apimgt.rest.api.core.utils.MappingUtil;
import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * Implementation class for {@link ThreatProtectionApiService}
 */
public class ThreatProtectionApiServiceImpl extends ThreatProtectionApiService {

    private Logger log = LoggerFactory.getLogger(ThreatProtectionApiServiceImpl.class);

    /**
     * Retrieve JSON threat protection policy
     * @param apiId API_ID
     * @param request {@link Request}
     * @return JSON threat protection policy
     * @throws NotFoundException if failed to retrieve the policy
     */
    @Override
    public Response threatProtectionJsonApiIdGet(String apiId
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao =  DAOFactory.getThreatProtectionDAO();
            ThreatProtectionJsonPolicy policy = dao.getJsonPolicy(apiId);
            if (policy == null) {
                return Response.status(404).build();
            }
            ThreatProtectionJsonPolicyDTO dto = MappingUtil.toThreatProtectionJsonPolicyDTO(policy);
            return Response.ok().entity(dto).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting JSON ThreatProtectionJsonPolicy for API_ID: " + apiId, e);
        }
        return Response.status(404).build();
        //return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    /**
     * Add a JSON threat protection policy
     * @param apiId API_ID
     * @param threatProtectionJsonPolicy {@link ThreatProtectionJsonPolicyDTO}
     * @param request {@link Request}
     * @return http status 201, if failed 500
     * @throws NotFoundException
     */
    @Override
    public Response threatProtectionJsonApiIdPost(String apiId
, ThreatProtectionJsonPolicyDTO threatProtectionJsonPolicy
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            ThreatProtectionJsonPolicy policy = MappingUtil.toThreatProtectionJsonPolicy(threatProtectionJsonPolicy);
            APIGateway gateway = APIManagerFactory.getInstance().getApiGateway();
            if (dao.isJsonPolicyExists(policy.getApiId())) {
                dao.updateJsonPolicy(policy);
                gateway.updateJsonThreatProtectionPolicy(policy);
                //200
            } else {
                dao.addJsonPolicy(policy);
                //send 201
                gateway.addJsonThreatProtectionPolicy(policy);
            }
            return Response.status(201).entity("created").build();
        } catch (APIMgtDAOException e) {
            log.error("Error adding JSON ThreatProtectionJsonPolicy for API_ID: " + apiId, e);
        } catch (GatewayException e) {
            log.error("Error publishing JSON Threat Protection Policy to Gateway");
        }
        return Response.status(500).build();
    }

    /**
     * Retrieve all JSON threat protection policies
     * @param request {@link Request}
     * @return A list of JSON threat protection policies
     * @throws NotFoundException if failed to retrieve policies
     */
    @Override
    public Response threatProtectionJsonGet(Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            List<ThreatProtectionJsonPolicy> list = dao.getJsonPolicies();
            ThreatProtectionJsonPolicyListDTO listDTO = new ThreatProtectionJsonPolicyListDTO();
            for (ThreatProtectionJsonPolicy policy: list) {
                listDTO.addListItem(MappingUtil.toThreatProtectionJsonPolicyDTO(policy));
            }
            return Response.ok().entity(listDTO).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting JSON ThreatProtectionJsonPolicy list", e);
        }
        return Response.status(500).entity("Internal Server Error").build();
    }

    /**
     * Retrieve an XML threat protection policy
     * @param apiId API_ID
     * @param request {@link Request}
     * @return XML threat protection policy
     * @throws NotFoundException if failed to retrieve the policy
     */
    @Override
    public Response threatProtectionXmlApiIdGet(String apiId
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            ThreatProtectionXmlPolicy policy = dao.getXmlPolicy(apiId);
            if (policy == null) {
                return Response.status(404).build();
            }
            return Response.ok().entity(MappingUtil.toThreatProtectionXmlPolicyDTO(policy)).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting XML ThreatProtectionJsonPolicy for API_ID: " + apiId, e);
        }
        return Response.status(500).build();
    }

    /**
     * Add an XML threat protection policy
     * @param apiId API_ID
     * @param threatProtectionXmlPolicy {@link ThreatProtectionXmlPolicyDTO}
     * @param request {@link Request}
     * @return http status 201, if failed 500
     * @throws NotFoundException
     */
    @Override
    public Response threatProtectionXmlApiIdPost(String apiId
, ThreatProtectionXmlPolicyDTO threatProtectionXmlPolicy
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            ThreatProtectionXmlPolicy policy = MappingUtil.toThreatProtectionXmlPolicy(threatProtectionXmlPolicy);
            APIGateway gateway = APIManagerFactory.getInstance().getApiGateway();
            if (dao.isXmlPolicyExists(policy.getApiId())) {
                dao.updateXmlPolicy(policy);
                gateway.updateXmlThreatProtectionPolicy(policy);
            } else {
                dao.addXmlPolicy(policy);
                gateway.addXmlThreatProtectionPolicy(policy);
            }
            return Response.status(201).entity("created").build();
        } catch (APIMgtDAOException e) {
            log.error("Error adding XML ThreatProtectionJsonPolicy for API_ID: " + apiId, e);
        } catch (GatewayException e) {
            log.error("Error publishing XML Threat Protection Policy to Gateway");
        }
        return Response.status(500).entity("Failed to add XML policy for API_ID: " + apiId).build();
    }

    /**
     * Retrieve all XML threat protection policies
     * @param request {@link Request}
     * @return A list of all XML threat protection policies
     * @throws NotFoundException if failed to retrieve the list of policies
     */
    @Override
    public Response threatProtectionXmlGet(Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            List<ThreatProtectionXmlPolicy> list = dao.getXmlPolicies();
            ThreatProtectionXmlPolicyListDTO listDTO = new ThreatProtectionXmlPolicyListDTO();
            for (ThreatProtectionXmlPolicy policy: list) {
                listDTO.addListItem(MappingUtil.toThreatProtectionXmlPolicyDTO(policy));
            }
            return Response.ok().entity(listDTO).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting Xml ThreatProtectionXmlPolicy list", e);
        }
        return Response.status(500).entity("Internal Server Error").build();
    }
}
