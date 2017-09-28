/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
        String payloadType = "application/xml";
        String payload = "<a></a>";

        BValue[] args = {new BString(payloadType), new BString(payload)};

        BValue[] ret = BLangFunctions.invokeNew(programFile, "testAnalyzer", args);
        Assert.assertEquals(ret[0].stringValue(), "true");
        Assert.assertNull(null);
    }

    @Test
    public void testJsonAnalyzer() {
        String payloadType = "application/json";
        String payload = "{\"a\": 1}";

        BValue[] args = {new BString(payloadType), new BString(payload)};

        BValue[] ret = BLangFunctions.invokeNew(programFile, "testAnalyzer", args);
        Assert.assertEquals(ret[0].stringValue(), "true");
        Assert.assertNull(null);
    }
}
