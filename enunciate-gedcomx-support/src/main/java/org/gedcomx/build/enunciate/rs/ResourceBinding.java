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
package org.gedcomx.build.enunciate.rs;

import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan Heaton
 */
public class ResourceBinding {

  private final String path;
  private final ResourceDefinitionDeclaration definition;
  private final List<ResourceMethod> methods = new ArrayList<ResourceMethod>();
  private final Set<ResponseCode> statusCodes = new HashSet<ResponseCode>();
  private final Set<ResponseCode> warnings = new HashSet<ResponseCode>();
  private final Set<ResourceRelationship> resourceRelationships = new HashSet<ResourceRelationship>();

  public ResourceBinding(String path, ResourceDefinitionDeclaration definition) {
    this.path = path;
    this.definition = definition;
  }

  public String getPath() {
    return path;
  }

  public ResourceDefinitionDeclaration getDefinition() {
    return definition;
  }

  public Set<ResponseCode> getStatusCodes() {
    return statusCodes;
  }

  public Set<ResponseCode> getWarnings() {
    return warnings;
  }

  public Set<ResourceRelationship> getResourceRelationships() {
    return resourceRelationships;
  }

  public List<ResourceMethod> getMethods() {
    return methods;
  }
}