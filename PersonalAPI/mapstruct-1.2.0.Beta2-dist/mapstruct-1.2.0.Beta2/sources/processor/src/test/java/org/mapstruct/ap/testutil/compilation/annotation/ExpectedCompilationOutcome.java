/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.testutil.compilation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Specifies the expected outcome of a compilation, comprising the actual result
 * and optionally one or more diagnostics.
 *
 * @author Gunnar Morling
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExpectedCompilationOutcome {

    /**
     * The expected result of a compilation.
     *
     * @return The expected result of a compilation.
     */
    CompilationResult value();

    /**
     * The expected diagnostics created during a compilation.
     *
     * @return The expected diagnostics created during a compilation.
     */
    Diagnostic[] diagnostics() default { };
}