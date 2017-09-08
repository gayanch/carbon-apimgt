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

package org.wso2.carbon.apimgt.ballerina.threatprotection.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.threatprotection.analyzer.JSONAnalyzer;

/**
 * JSONThreatAnalyzer Factory Class for used in {@link AnalyzerPool}
 */
public class JSONAnalyzerFactory extends BasePooledObjectFactory<JSONAnalyzer> {
    private static int objcount = 0;
    //private Logger logger = LoggerFactory.getLogger(JSONAnalyzerFactory.class);

    @Override
    public JSONAnalyzer create() throws Exception {
        objcount += 1;
        System.out.println("===JSONAnalyzerFactory-Object Count:" + objcount);
        return new JSONAnalyzer();
    }

    @Override
    public PooledObject<JSONAnalyzer> wrap(JSONAnalyzer jsonAnalyzer) {
        return new DefaultPooledObject<>(jsonAnalyzer);
    }


}
