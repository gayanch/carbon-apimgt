package org.wso2.carbon.apimgt.rest.api.core;


import io.swagger.annotations.ApiParam;

import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionPolicyDTO;
import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionPolicyIdListDTO;
import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionPolicyListDTO;
import org.wso2.carbon.apimgt.rest.api.core.factories.ThreatProtectionApiServiceFactory;

import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.formparam.FormDataParam;
import org.osgi.service.component.annotations.Component;

import java.io.InputStream;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Component(
    name = "org.wso2.carbon.apimgt.rest.api.core.ThreatProtectionApi",
    service = Microservice.class,
    immediate = true
)
@Path("/api/am/core/v1.[\\d]+/threat-protection")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@ApplicationPath("/threat-protection")
@io.swagger.annotations.Api(description = "the threat-protection API")
public class ThreatProtectionApi implements Microservice  {
   private final ThreatProtectionApiService delegate = ThreatProtectionApiServiceFactory.getThreatProtectionApi();

    @GET
    @Path("/apis/{apiId}/policy")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get threat protection policy IDs associated with an API", notes = "Can be used to get all policy IDs associated with an API", response = ThreatProtectionPolicyIdListDTO.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = ThreatProtectionPolicyIdListDTO.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "No associated policies found for API", response = ThreatProtectionPolicyIdListDTO.class) })
    public Response threatProtectionApisApiIdPolicyGet(@ApiParam(value = "The UUID of an API ",required=true) @PathParam("apiId") String apiId
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionApisApiIdPolicyGet(apiId,request);
    }
    @GET
    @Path("/policies")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all threat protection policies", notes = "all", response = ThreatProtectionPolicyListDTO.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ThreatProtectionPolicyListDTO.class) })
    public Response threatProtectionPoliciesGet( @Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionPoliciesGet(request);
    }
    @POST
    @Path("/policy")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "add a threat protection policy", notes = "add a threat protection policy", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response threatProtectionPolicyPost(@ApiParam(value = "Threat protection json policy request parameter " ,required=true) ThreatProtectionPolicyDTO threatProtectionPolicy
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionPolicyPost(threatProtectionPolicy,request);
    }
    @DELETE
    @Path("/policy/{threatProtectionPolicyId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a threat protection policy", notes = "Delete a threat protection policy", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok. Policy is deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error occurred during the operation", response = void.class) })
    public Response threatProtectionPolicyThreatProtectionPolicyIdDelete(@ApiParam(value = "The UUID of a Policy ",required=true) @PathParam("ThreatProtectionPolicyId") String threatProtectionPolicyId
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionPolicyThreatProtectionPolicyIdDelete(threatProtectionPolicyId,request);
    }
    @GET
    @Path("/policy/{threatProtectionPolicyId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get one threat protection policy", notes = "Get one threat protection policy", response = ThreatProtectionPolicyDTO.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ThreatProtectionPolicyDTO.class) })
    public Response threatProtectionPolicyThreatProtectionPolicyIdGet(@ApiParam(value = "The UUID of a Policy ",required=true) @PathParam("ThreatProtectionPolicyId") String threatProtectionPolicyId
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionPolicyThreatProtectionPolicyIdGet(threatProtectionPolicyId,request);
    }
    @POST
    @Path("/policy/{threatProtectionPolicyId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "post", notes = "desc", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = void.class) })
    public Response threatProtectionPolicyThreatProtectionPolicyIdPost(@ApiParam(value = "The UUID of a Policy ",required=true) @PathParam("ThreatProtectionPolicyId") String threatProtectionPolicyId
,@ApiParam(value = "Threat protection json policy request parameter " ,required=true) ThreatProtectionPolicyDTO threatProtectionPolicy
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionPolicyThreatProtectionPolicyIdPost(threatProtectionPolicyId,threatProtectionPolicy,request);
    }
}