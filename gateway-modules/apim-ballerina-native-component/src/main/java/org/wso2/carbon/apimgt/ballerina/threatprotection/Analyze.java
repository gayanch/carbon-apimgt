package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BBoolean;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Created by gayan on 8/30/17.
 */

@BallerinaFunction(
        packageName = "org.wso2.carbon.apimgt.ballerina.threatprotection",
        functionName = "analyze",
        args = { @Argument(name = "payloadType", type = TypeEnum.STRING),
                 @Argument(name = "payload", type = TypeEnum.STRING)},
        returnType = { @ReturnType(type = TypeEnum.BOOLEAN),
                       @ReturnType(type = TypeEnum.STRING)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description", attributes = {@Attribute(name = "value",
        value = "Analyzes json/xml payloads for threats")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "payloadType",
        value = "Type of the payload (xml/json)")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "payload",
        value = "Payload string")})
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "boolean",
        value = "true if no threats detected, false otherwise")})
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "string",
        value = "error information if found")})
public class Analyze extends AbstractNativeFunction {
    @Override
    public BValue[] execute(Context context) {

        String payloadType = getStringArgument(context, 0);
        String payload = getStringArgument(context, 1);

        APIMThreatAnalyzer analyzer = AnalyzerFactory.getAnalyzer(payloadType, "GLOBAL");
        if (analyzer == null) {
            return getBValues(new BBoolean(false), new BString("Unknown Payload Type"));
        }

        boolean ok = true;
        String errMessage = null;

        try {
            analyzer.analyze(payload);
        } catch (APIMThreatAnalyzerException e) {
            ok = false;
            errMessage = e.getMessage();
        }

        return getBValues(new BBoolean(ok), new BString(errMessage));
    }
}
