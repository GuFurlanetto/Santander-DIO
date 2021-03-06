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
package org.mapstruct.ap.test.inheritfromconfig;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * @author Andreas Gudian
 */
@MapperConfig(
    mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AutoInheritedDriverConfig {
    @Mappings({
        @Mapping(target = "primaryKey", source = "dto.id"),
        @Mapping(target = "auditTrail", ignore = true),
        @Mapping(target = "driverName", source = "drv.name")
    })
    CarWithDriverEntity baseDtoToEntity(DriverDto drv, BaseVehicleDto dto);
}
