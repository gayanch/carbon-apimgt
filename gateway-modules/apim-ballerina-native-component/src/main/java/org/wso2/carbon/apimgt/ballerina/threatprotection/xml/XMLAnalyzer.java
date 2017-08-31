package org.wso2.carbon.apimgt.ballerina.threatprotection.xml;

import com.ctc.wstx.api.WstxInputProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzer;
import org.wso2.carbon.apimgt.ballerina.threatprotection.APIMThreatAnalyzerException;
import org.wso2.carbon.apimgt.core.configuration.models.APIMConfigurations;
import org.wso2.carbon.apimgt.core.configuration.models.XMLThreatProtectionConfigurations;
import org.wso2.carbon.apimgt.core.internal.ServiceReferenceHolder;

import java.io.StringReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

/**
 * Created by gayan on 8/30/17.
 */
public class XMLAnalyzer implements APIMThreatAnalyzer {
    private XMLInputFactory factory;
    private XMLEventReader reader;
    private Logger logger = LoggerFactory.getLogger(XMLAnalyzer.class);

    public XMLAnalyzer() {
        factory = XMLInputFactory.newInstance();

        //configure
        APIMConfigurations apimConfigurations = ServiceReferenceHolder.getInstance().getAPIMConfiguration();
        XMLThreatProtectionConfigurations xmlThreatProtectionConfigurations =
                apimConfigurations.getXmlThreatProtectionConfigurations();

        boolean dtdEnabled = xmlThreatProtectionConfigurations.isDtdEnabled();
        boolean externalEntitiesEnabled = xmlThreatProtectionConfigurations.isExternalEntitiesEnabled();
        int maxDepth = xmlThreatProtectionConfigurations.getMaxDepth();
        int maxElementCount = xmlThreatProtectionConfigurations.getElementCount();
        int maxAttributeCount = xmlThreatProtectionConfigurations.getAttributeCount();
        int maxAttributeLength = xmlThreatProtectionConfigurations.getAttributeLength();
        int entityExpansionLimit = xmlThreatProtectionConfigurations.getEntityExpansionLimit();
        int maxChildrenPerElement = xmlThreatProtectionConfigurations.getChildrenPerElement();

        factory.setProperty(XMLInputFactory.SUPPORT_DTD, dtdEnabled);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, externalEntitiesEnabled);
        factory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, maxAttributeLength);
        factory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTES_PER_ELEMENT, maxAttributeCount);
        factory.setProperty(WstxInputProperties.P_MAX_ELEMENT_DEPTH, maxDepth);
        factory.setProperty(WstxInputProperties.P_MAX_CHILDREN_PER_ELEMENT, maxChildrenPerElement);
        factory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, entityExpansionLimit);
        factory.setProperty(WstxInputProperties.P_MAX_ELEMENT_COUNT, maxElementCount);
    }

    @Override
    public void analyze(String payload) throws APIMThreatAnalyzerException {
        try {
            reader = factory.createXMLEventReader(new StringReader(payload));
            while (reader.hasNext()) {
                reader.nextEvent();
            }
        } catch (XMLStreamException e) {
            logger.error("Threat Protection: XML Validation Failed", e);
            throw new APIMThreatAnalyzerException("XML Validation Failed: " + e.getMessage());
        }

    }
}
