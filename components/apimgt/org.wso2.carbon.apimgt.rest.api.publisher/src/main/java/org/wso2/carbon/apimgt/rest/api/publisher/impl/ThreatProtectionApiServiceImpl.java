package org.wso2.carbon.apimgt.rest.api.publisher.impl;

import org.wso2.carbon.apimgt.rest.api.publisher.*;
import org.wso2.carbon.apimgt.rest.api.publisher.dto.*;


import java.util.List;
import org.wso2.carbon.apimgt.rest.api.publisher.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class ThreatProtectionApiServiceImpl extends ThreatProtectionApiService {
    @Override
    public Response threatProtectionAddPolicyApiIdPolicyIdPost(String apiId
, String threatProtectionPolicyId
  ,Request request) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response threatProtectionPoliciesGet( Request request) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response threatProtectionPolicyApiIdGet(String apiId
  ,Request request) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response threatProtectionRemovePolicyApiIdPolicyIdPost(String apiId
, String threatProtectionPolicyId
  ,Request request) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
