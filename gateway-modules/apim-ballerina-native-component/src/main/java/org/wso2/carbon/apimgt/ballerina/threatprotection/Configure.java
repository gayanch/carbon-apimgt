/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BBoolean;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.*;
import org.wso2.carbon.apimgt.ballerina.threatprotection.configurations.JSONConfig;
import org.wso2.carbon.apimgt.ballerina.threatprotection.configurations.XMLConfig;

/**
 * Native Function org.wso2.carbon.apimgt.ballerina.threatprotection:configure
 * This function is used to configure the json/xml analyzers.
 */
@BallerinaFunction(
        packageName = "org.wso2.carbon.apimgt.ballerina.threatprotection",
        functionName = "configure",
        args = { @Argument(name = "jsonInfo", type = TypeEnum.STRUCT, structType = "JSONThreatProtectionInfoDTO"),
                @Argument(name = "xmlInfo", type = TypeEnum.STRUCT, structType = "XMLThreatProtectionInfoDTO")},
        returnType = { @ReturnType(type = TypeEnum.BOOLEAN)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description", attributes = {@Attribute(name = "value",
        value = "Configures the xml/json analyzers ")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "jsonInfo",
        value = "JSONThreatProtectionInfoDTO struct")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "xmlInfo",
        value = "XMLThreatProtectionInfoDTO struct")})
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "boolean",
        value = "true if success, false otherwise")})
public class Configure extends AbstractNativeFunction {
    @Override
    public BValue[] execute(Context context) {
        BStruct jsonInfo = ((BStruct) getRefArgument(context, 0));
        BStruct xmlInfo = ((BStruct) getRefArgument(context, 1));

        //configure json analyzer
        int propertyCount = (int)jsonInfo.getIntField(0);
        int stringLength = (int)jsonInfo.getIntField(1);
        int arrayElementCount = (int)jsonInfo.getIntField(2);
        int keyLength = (int)jsonInfo.getIntField(3);
        int maxJSONDepth = (int)jsonInfo.getIntField(4);

        JSONConfig jsonConfig = JSONConfig.getInstance();
        jsonConfig.setMaxPropertyCount(propertyCount);
        jsonConfig.setMaxStringLength(stringLength);
        jsonConfig.setMaxArrayElementCount(arrayElementCount);
        jsonConfig.setMaxKeyLength(keyLength);
        jsonConfig.setMaxJsonDepth(maxJSONDepth);

        //configure xml analyzer
        boolean dtdEnabled = xmlInfo.getBooleanField(0) != 0;
        boolean externalEntitiesEnabled = xmlInfo.getBooleanField(1) != 0;
        int maxXMLDepth = (int)xmlInfo.getIntField(0);
        int elementCount = (int)xmlInfo.getIntField(1);
        int attributeCount = (int)xmlInfo.getIntField(2);
        int attributeLength = (int)xmlInfo.getIntField(3);
        int entityExpansionLimit = (int)xmlInfo.getIntField(4);
        int childrenPerElement = (int)xmlInfo.getIntField(5);

        XMLConfig xmlConfig = XMLConfig.getInstance();
        xmlConfig.setDtdEnabled(dtdEnabled);
        xmlConfig.setExternalEntitiesEnabled(externalEntitiesEnabled);
        xmlConfig.setMaxDepth(maxXMLDepth);
        xmlConfig.setMaxElementCount(elementCount);
        xmlConfig.setMaxAttributeCount(attributeCount);
        xmlConfig.setMaxAttributeLength(attributeLength);
        xmlConfig.setEntityExpansionLimit(entityExpansionLimit);
        xmlConfig.setMaxChildrenPerElement(childrenPerElement);

        return getBValues(new BBoolean(true));
    }
}
