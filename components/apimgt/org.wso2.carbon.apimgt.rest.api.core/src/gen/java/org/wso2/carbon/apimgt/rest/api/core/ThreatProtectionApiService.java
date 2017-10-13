package org.wso2.carbon.apimgt.rest.api.core;

import org.wso2.carbon.apimgt.rest.api.core.*;
import org.wso2.carbon.apimgt.rest.api.core.dto.*;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.Request;

import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionJsonPolicyDTO;
import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionXmlPolicyDTO;

import java.util.List;
import org.wso2.carbon.apimgt.rest.api.core.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public abstract class ThreatProtectionApiService {
    public abstract Response threatProtectionJsonApiIdGet(String apiId
  ,Request request) throws NotFoundException;
    public abstract Response threatProtectionJsonApiIdPost(String apiId
 ,ThreatProtectionJsonPolicyDTO threatProtectionJsonPolicy
  ,Request request) throws NotFoundException;
    public abstract Response threatProtectionXmlApiIdGet(String apiId
  ,Request request) throws NotFoundException;
    public abstract Response threatProtectionXmlApiIdPost(String apiId
 ,ThreatProtectionXmlPolicyDTO threatProtectionXmlPolicy
  ,Request request) throws NotFoundException;
}
