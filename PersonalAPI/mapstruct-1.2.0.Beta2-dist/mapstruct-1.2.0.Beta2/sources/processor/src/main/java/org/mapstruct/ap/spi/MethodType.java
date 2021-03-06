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
package org.mapstruct.ap.spi;

/**
 * Different types of a method.
 *
 * @author Gunnar Morling
 */
public enum MethodType {

    /**
     * A JavaBeans getter method, e.g. {@code public String getName()}.
     */
    GETTER,

    /**
     * A JavaBeans setter method, e.g. {@code public void setName(String name)}.
     */
    SETTER,

    /**
     * An adder method, e.g. {@code public void addItem(String item)}.
     */
    ADDER,

    /**
     * Any method which is neither a JavaBeans getter, setter nor an adder method.
     */
    OTHER,

    /**
     * A method to check whether a property is present, e.g. {@code public String hasName()}.
     */
    PRESENCE_CHECKER;
}
