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
package org.mapstruct.ap.internal.model.assignment;

import static org.mapstruct.ap.internal.model.assignment.Assignment.AssignmentType.DIRECT;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.model.common.TypeFactory;
import org.mapstruct.ap.internal.prism.NullValueCheckStrategyPrism;

import static org.mapstruct.ap.internal.prism.NullValueCheckStrategyPrism.ALWAYS;

/**
 * This wrapper handles the situation were an assignment is done via the setter.
 *
 * In case of a pre-existing target the wrapper checks if there is an collection or map initialized on the target bean
 * (not null). If so it uses the addAll (for collections) or putAll (for maps). The collection / map is cleared in case
 * of a pre-existing target {@link org.mapstruct.MappingTarget }before adding the source entries.
 *
 * If there is no pre-existing target, or the target Collection / Map is not initialized (null) the setter is used to
 * create a new Collection / Map with the copy constructor.
 *
 * @author Sjaak Derksen
 */
public class SetterWrapperForCollectionsAndMaps extends WrapperForCollectionsAndMaps {

    private final boolean includeSourceNullCheck;
    private final Type targetType;
    private final TypeFactory typeFactory;
    private final boolean targetImmutable;

    public SetterWrapperForCollectionsAndMaps(Assignment decoratedAssignment,
                                              List<Type> thrownTypesToExclude,
                                              Type targetType,
                                              NullValueCheckStrategyPrism nvms,
                                              TypeFactory typeFactory,
                                              boolean fieldAssignment,
                                              boolean targetImmutable ) {

        super(
            decoratedAssignment,
            thrownTypesToExclude,
            targetType,
            fieldAssignment
        );
        this.includeSourceNullCheck = ALWAYS == nvms;
        this.targetType = targetType;
        this.typeFactory = typeFactory;
        this.targetImmutable = targetImmutable;
    }

    @Override
    public Set<Type> getImportTypes() {
        Set<Type> imported = super.getImportTypes();
        if ( isDirectAssignment() ) {
            if ( targetType.getImplementationType() != null ) {
                imported.addAll( targetType.getImplementationType().getImportTypes() );
            }
            else {
                imported.addAll( targetType.getImportTypes() );
            }

            if ( isEnumSet() ) {
                imported.add( typeFactory.getType( EnumSet.class ) );
            }
        }
        return imported;
    }

    public boolean isIncludeSourceNullCheck() {
        return includeSourceNullCheck;
    }

    public boolean isDirectAssignment() {
        return getType() == DIRECT;
    }

    public boolean isEnumSet() {
        return "java.util.EnumSet".equals( targetType.getFullyQualifiedName() );
    }

    public boolean isTargetImmutable() {
        return targetImmutable;
    }

}
