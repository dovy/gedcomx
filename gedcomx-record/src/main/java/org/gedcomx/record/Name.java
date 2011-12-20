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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.NameType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A name field.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Name", propOrder = {"type", "parts"})
public class Name extends Field implements Partitionable<NamePart>, Typed<NameType> {

  private TypeReference<NameType> type;
  private List<NamePart> parts;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<NameType> getType() {
    return type;
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  public void setType(TypeReference<NameType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NameType getKnownType() {
    return getType() == null ? null : NameType.fromQNameURI(getType().getType());
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(NameType knownType) {
    setType(knownType == null ? null : new TypeReference<NameType>(knownType));
  }

  /**
   * The different parts of the name field.
   *
   * @return The different parts of the name field.
   */
  @XmlElement (name = "part")
  @JsonName ("parts")
  @JsonProperty ("parts")
  public List<NamePart> getParts() {
    return parts;
  }

  /**
   * The different parts of the name field.
   *
   * @param parts The different parts of the name field.
   */
  @JsonProperty ("parts")
  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}
