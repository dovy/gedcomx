/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.record;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Record data that has characteristics.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "HasCharacteristics" )
public interface HasCharacteristics {

  /**
   * The characteristics of a record resource.
   *
   * @return The characteristics of a record resource.
   */
  List<Characteristic> getCharacteristics();

  /**
   * The characteristic fields on this persona.
   *
   * @param characteristics The characteristic fields on this persona.
   */
  void setCharacteristics(List<Characteristic> characteristics);
}