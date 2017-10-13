package org.wso2.carbon.apimgt.rest.api.core;


import io.swagger.annotations.ApiParam;

import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionJsonPolicyDTO;
import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionXmlPolicyDTO;
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
    @Path("/json/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "get", notes = "desc", response = ThreatProtectionJsonPolicyDTO.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ThreatProtectionJsonPolicyDTO.class) })
    public Response threatProtectionJsonApiIdGet(@ApiParam(value = "The UUID of an API ",required=true) @PathParam("apiId") String apiId
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionJsonApiIdGet(apiId,request);
    }
    @POST
    @Path("/json/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "post", notes = "desc", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response threatProtectionJsonApiIdPost(@ApiParam(value = "The UUID of an API ",required=true) @PathParam("apiId") String apiId
,@ApiParam(value = "Threat protection json policy request parameter " ,required=true) ThreatProtectionJsonPolicyDTO threatProtectionJsonPolicy
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionJsonApiIdPost(apiId,threatProtectionJsonPolicy,request);
    }
    @GET
    @Path("/xml/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get an xml policy", notes = "xml policy", response = ThreatProtectionXmlPolicyDTO.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ThreatProtectionXmlPolicyDTO.class) })
    public Response threatProtectionXmlApiIdGet(@ApiParam(value = "The UUID of an API ",required=true) @PathParam("apiId") String apiId
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionXmlApiIdGet(apiId,request);
    }
    @POST
    @Path("/xml/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "add an xml policy", notes = "add an xml policy", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response threatProtectionXmlApiIdPost(@ApiParam(value = "The UUID of an API ",required=true) @PathParam("apiId") String apiId
,@ApiParam(value = "Threat protection xml policy request parameter " ,required=true) ThreatProtectionXmlPolicyDTO threatProtectionXmlPolicy
 ,@Context Request request)
    throws NotFoundException {
        return delegate.threatProtectionXmlApiIdPost(apiId,threatProtectionXmlPolicy,request);
    }
}
