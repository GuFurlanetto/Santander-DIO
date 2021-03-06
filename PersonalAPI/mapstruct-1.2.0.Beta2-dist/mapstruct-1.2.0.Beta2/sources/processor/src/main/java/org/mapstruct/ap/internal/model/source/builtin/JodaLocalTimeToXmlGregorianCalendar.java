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
package org.mapstruct.ap.internal.model.source.builtin;

import static org.mapstruct.ap.internal.util.Collections.asSet;

import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mapstruct.ap.internal.model.common.Parameter;
import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.model.common.TypeFactory;
import org.mapstruct.ap.internal.util.JodaTimeConstants;

/**
 * @author Sjaak Derksen
 */
public class JodaLocalTimeToXmlGregorianCalendar extends BuiltInMethod {

    private final Parameter parameter;
    private final Type returnType;
    private final Set<Type> importTypes;

    public JodaLocalTimeToXmlGregorianCalendar(TypeFactory typeFactory) {
        this.parameter = new Parameter(
            "dt",
            typeFactory.getType( JodaTimeConstants.LOCAL_TIME_FQN )
        );
        this.returnType = typeFactory.getType( XMLGregorianCalendar.class );

        this.importTypes = asSet(
            returnType,
            parameter.getType(),
            typeFactory.getType( DatatypeConstants.class ),
            typeFactory.getType( DatatypeFactory.class ),
            typeFactory.getType( DatatypeConfigurationException.class )
        );
    }

    @Override
    public Set<Type> getImportTypes() {
        return importTypes;
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }
}
