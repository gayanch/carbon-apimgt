package org.wso2.carbon.apimgt.rest.api.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.core.dao.ThreatProtectionDAO;
import org.wso2.carbon.apimgt.core.dao.impl.DAOFactory;
import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;
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

public class ThreatProtectionApiServiceImpl extends ThreatProtectionApiService {

    private Logger log = LoggerFactory.getLogger(ThreatProtectionApiServiceImpl.class);

    @Override
    public Response threatProtectionJsonApiIdGet(String apiId
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao =  DAOFactory.getThreatProtectionDAO();
            ThreatProtectionJsonPolicy policy = dao.getJsonPolicy(apiId);
            ThreatProtectionJsonPolicyDTO dto = MappingUtil.toThreatProtectionJsonPolicyDTO(policy);
            return Response.ok().entity(dto).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting JSON ThreatProtectionJsonPolicy for " + apiId, e);
        }
        return Response.status(404).build();
        //return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response threatProtectionJsonApiIdPost(String apiId
, ThreatProtectionJsonPolicyDTO threatProtectionJsonPolicy
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            ThreatProtectionJsonPolicy policy = MappingUtil.toThreatProtectionJsonPolicy(threatProtectionJsonPolicy);
            dao.addJsonPolicy(policy);
            return Response.ok().build();
        } catch (APIMgtDAOException e) {
            log.error("Error adding JSON ThreatProtectionJsonPolicy for " + apiId, e);
        }
        return Response.status(500).build();
    }
    @Override
    public Response threatProtectionXmlApiIdGet(String apiId
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            ThreatProtectionXmlPolicy policy = dao.getXmlPolicy(apiId);
            return Response.ok().entity(MappingUtil.toThreatProtectionXmlPolicyDTO(policy)).build();
        } catch (APIMgtDAOException e) {
            log.error("Error getting XML ThreatProtectionJsonPolicy for " + apiId, e);
        }
        return Response.status(500).build();
    }
    @Override
    public Response threatProtectionXmlApiIdPost(String apiId
, ThreatProtectionXmlPolicyDTO threatProtectionXmlPolicy
  ,Request request) throws NotFoundException {
        try {
            ThreatProtectionDAO dao = DAOFactory.getThreatProtectionDAO();
            dao.addXmlPolicy(MappingUtil.toThreatProtectionXmlPolicy(threatProtectionXmlPolicy));
            return Response.status(201).entity("created").build();
        } catch (APIMgtDAOException e) {
            log.error("Error adding XML ThreatProtectionJsonPolicy for " + apiId, e);
        }
        return Response.status(500).entity("Failed to add XML policy for " + apiId).build();
    }
}
