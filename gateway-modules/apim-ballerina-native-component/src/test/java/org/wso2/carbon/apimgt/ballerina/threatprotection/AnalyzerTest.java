package org.wso2.carbon.apimgt.ballerina.threatprotection;

import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.util.codegen.ProgramFile;
import org.ballerinalang.util.program.BLangFunctions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wso2.carbon.apimgt.ballerina.caching.util.BTestUtils;

/**
 * Created by gayan on 8/30/17.
 */
public class AnalyzerTest {
    private ProgramFile programFile;
    //private static Logger log = LoggerFactory.getLogger(AnalyzerTest.class);
    @BeforeTest
    public void setup() {
        programFile = BTestUtils.parseBalFile("samples/threatprotection/analyzerTest.bal");
    }

    @Test
    public void testXmlAnalyzer() {
        String payloadType = "xml";
        String payload = "<a></a>";

        BValue[] args = {new BString(payloadType), new BString(payload)};

        BValue[] ret = BLangFunctions.invokeNew(programFile, "testAnalyzer", args);
        Assert.assertEquals(ret[0].stringValue(), "true");
        Assert.assertNull(ret[1].stringValue());
    }

    @Test
    public void testJsonAnalyzer() {
        String payloadType = "json";
        String payload = "{\"a\": 1}";

        BValue[] args = {new BString(payloadType), new BString(payload)};

        BValue[] ret = BLangFunctions.invokeNew(programFile, "testAnalyzer", args);
        Assert.assertEquals(ret[0].stringValue(), "true");
        Assert.assertNull(ret[1].stringValue());
    }
}
