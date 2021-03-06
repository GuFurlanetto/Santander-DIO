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
package org.mapstruct.ap.internal.conversion;

import static org.mapstruct.ap.internal.util.Collections.asSet;

import java.math.BigInteger;
import java.util.Set;

import org.mapstruct.ap.internal.model.common.ConversionContext;
import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.util.NativeTypes;

/**
 * Conversion between {@link BigInteger} and wrappers of native number types.
 *
 * @author Gunnar Morling
 */
public class BigIntegerToWrapperConversion extends SimpleConversion {

    private final Class<?> targetType;

    public BigIntegerToWrapperConversion(Class<?> targetType) {
        if ( targetType.isPrimitive() ) {
            throw new IllegalArgumentException( targetType + " is a primitive type." );
        }

        this.targetType = NativeTypes.getPrimitiveType( targetType );
    }

    @Override
    public String getToExpression(ConversionContext conversionContext) {
        return "<SOURCE>." + targetType.getName() + "Value()";
    }

    @Override
    public String getFromExpression(ConversionContext conversionContext) {
        String toLongValueStr = "";
        if ( targetType == float.class || targetType == double.class ) {
            toLongValueStr = ".longValue()";
        }

        return "BigInteger.valueOf( <SOURCE>" + toLongValueStr + " )";
    }

    @Override
    protected Set<Type> getFromConversionImportTypes(ConversionContext conversionContext) {
        return asSet( conversionContext.getTypeFactory().getType( BigInteger.class ) );
    }
}
