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
package org.mapstruct.ap.test.nestedbeans.other;

import java.util.List;

public class CarDto {

    private String name;
    private int year;
    private List<WheelDto> wheels;

    public CarDto() {
    }

    public CarDto(String name, int year, List<WheelDto> wheels) {
        this.name = name;
        this.year = year;
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<WheelDto> getWheels() {
        return wheels;
    }

    public void setWheels(List<WheelDto> wheels) {
        this.wheels = wheels;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }

        CarDto carDto = (CarDto) o;

        if ( year != carDto.year ) {
            return false;
        }
        if ( name != null ? !name.equals( carDto.name ) : carDto.name != null ) {
            return false;
        }
        return wheels != null ? wheels.equals( carDto.wheels ) : carDto.wheels == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + ( wheels != null ? wheels.hashCode() : 0 );
        return result;
    }

    @Override
    public String toString() {
        return "CarDto{" +
            "name='" + name + '\'' +
            ", year=" + year +
            ", wheels=" + wheels +
            '}';
    }

}
