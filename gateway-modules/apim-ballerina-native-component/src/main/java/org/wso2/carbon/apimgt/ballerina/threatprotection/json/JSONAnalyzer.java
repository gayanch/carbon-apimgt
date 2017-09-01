package org.wso2.carbon.apimgt.ballerina.threatprotection.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;
import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.JSONThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

import java.io.IOException;

/**
 * Created by gayan on 8/30/17.
 */
public class JSONAnalyzer implements APIMThreatAnalyzer {
    private static final String JSON_SCHEMA_TEMPLATE = "{" +
            "    \"type\": \"object\"," +
            "    \"maxProperties\": #_maxProperties," +
            "    \"patternProperties\": {" +
            "        \"^.{0,#_maxKeyLength}$\": {" +
            "            \"anyOf\": [" +
            "                { \"$ref\": \"#/definitions/boundedNumber\" }," +
            "                { \"$ref\": \"#/definitions/boundedString\" }," +
            "                { \"$ref\": \"#/definitions/boundedArray\" }," +
            "                { \"$ref\": \"#/definitions/boundedObject\"}," +
            "                { \"$ref\": \"#/definitions/booleanValues\"}," +
            "                { \"$ref\": \"#/definitions/nullValues\"}]" +
            "        }" +
            "    }," +
            "    \"definitions\": {" +
            "        \"boundedString\": {" +
            "            \"type\": \"string\"," +
            "            \"maxLength\": #_maxStringLength," +
            "            \"minLength\": 0" +
            "        }," +
            "        \"boundedNumber\": {" +
            "            \"type\": \"number\"" +
            "        }," +
            "        \"boundedArray\": {" +
            "            \"type\": \"array\"," +
            "            \"minItems\": 0," +
            "            \"maxItems\": #_maxArrayElements" +
            "        }," +
            "        \"boundedObject\": {" +
            "            \"type\": \"object\"," +
            "            \"maxProperties\": #_maxProperties" +
            "        }," +
            "        \"booleanValues\": {" +
            "            \"type\": \"boolean\" " +
            "        }," +
            "        \"nullValues\": {" +
            "            \"type\": \"null\"" +
            "        }" +
            "    }," +
            "    \"additionalProperties\": false" +
            "}";

    private JsonNode schemaNode;
    private JsonSchemaFactory factory;
    private JsonSchema schema;
    private Logger logger = LoggerFactory.getLogger(JSONAnalyzer.class);

    public JSONAnalyzer() {
        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        JSONThreatProtectionConfigurations jsonThreatProtectionConfigurations =
                apimConfigurations.getJsonThreatProtectionConfigurations();
        //configure analyzer
        int propertyCount = jsonThreatProtectionConfigurations.getPropertyCount();
        int stringLength = jsonThreatProtectionConfigurations.getStringLength();
        int arrayElementCount = jsonThreatProtectionConfigurations.getArrayElementCount();
        int keyLength = jsonThreatProtectionConfigurations.getKeyLength();

        String schemaString = JSON_SCHEMA_TEMPLATE.replace("^#_minProperties$", String.valueOf(0))
                .replaceAll("#_maxProperties", String.valueOf(propertyCount))
                .replace("#_maxKeyLength", String.valueOf(keyLength))
                .replace("#_maxStringLength", String.valueOf(stringLength))
                .replace("#_maxArrayElements", String.valueOf(arrayElementCount));
        logger.info(schemaString);
        factory = JsonSchemaFactory.byDefault();
        try {
            schemaNode = JsonLoader.fromString(schemaString);
            schema = factory.getJsonSchema(schemaNode);
            logger.info("Threat Protection: Schema Loaded");
        } catch (IOException e) {
            logger.error("Threat Protection: JSON Schema loading failed", e);
        } catch (ProcessingException e) {
            logger.error("Threat Protection: JSON schema processing error", e);
        }
    }

    @Override
    public void analyze(String payload) throws APIMThreatAnalyzerException {
        JsonNode payloadNode = null;
        ProcessingReport report = null;
        try {
            payloadNode = JsonLoader.fromString(payload);
            report = schema.validate(payloadNode);
        } catch (IOException e) {
           logger.error("Threat Protection: Payload json loading failed", e);
           throw new APIMThreatAnalyzerException("Threat Protection: Payload json loading failed: " + e.getMessage());
        } catch (ProcessingException e) {
            logger.error("Threat Protection: Payload json processing failed", e);
            throw new APIMThreatAnalyzerException("Threat Protection: Payload json processing failed: "
                    + e.getMessage());
        }

        if (!report.isSuccess()) {
            logger.warn("Threat Protection: JSON validation failed");
            throw new APIMThreatAnalyzerException("Threat Protection: JSON validation failed");
        }

    }
}
