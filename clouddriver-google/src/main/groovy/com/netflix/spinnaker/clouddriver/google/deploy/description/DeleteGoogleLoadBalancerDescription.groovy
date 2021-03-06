/*
 * Copyright 2015 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.clouddriver.google.deploy.description

import com.google.common.collect.ImmutableList
import com.netflix.frigga.Names
import com.netflix.spinnaker.clouddriver.google.model.loadbalancing.GoogleLoadBalancerType
import com.netflix.spinnaker.clouddriver.security.resources.ApplicationNameable
import com.netflix.spinnaker.clouddriver.security.resources.ServerGroupNameable

class DeleteGoogleLoadBalancerDescription extends AbstractGoogleCredentialsDescription implements ApplicationNameable {
  Long deleteOperationTimeoutSeconds
  String loadBalancerName
  String region
  String accountName
  Boolean deleteHealthChecks = true
  GoogleLoadBalancerType loadBalancerType

  @Override
  Collection<String> getApplications() {
    return ImmutableList.of(Names.parseName(loadBalancerName).getApp())
  }
}
