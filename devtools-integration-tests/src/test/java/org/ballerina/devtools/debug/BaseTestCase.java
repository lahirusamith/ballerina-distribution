/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerina.devtools.debug;

import org.ballerinalang.debugger.test.utils.DebugTestRunner;
import org.ballerinalang.test.context.BallerinaTestException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Parent test class for all debug integration test cases.
 */
public class BaseTestCase {

    @BeforeSuite(alwaysRun = true)
    public void initialize() throws BallerinaTestException, IOException {
        Path projectResourcePath = Paths.get("src", "test", "resources", "debug", "project-based-tests").toAbsolutePath();
        Path singleFileResourcePath = Paths.get("src", "test", "resources", "debug", "single-file-tests").toAbsolutePath();
        DebugTestRunner.initialize(projectResourcePath, singleFileResourcePath);
    }

    @AfterSuite(alwaysRun = true)
    public void destroy() {
        DebugTestRunner.destroy();
    }
}
