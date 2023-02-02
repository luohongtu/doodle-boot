/*
 * Copyright (c) 2022-present Doodle. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.doodle.boot.autoconfigure.gsocket;

import org.doodle.boot.gsocket.messaging.GSocketStrategies;
import org.doodle.boot.gsocket.messaging.GSocketStrategiesBuilder;
import org.doodle.boot.gsocket.messaging.GSocketStrategiesBuilderCustomizer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class GSocketStrategiesAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public GSocketStrategies gSocketStrategies(
      ObjectProvider<GSocketStrategiesBuilderCustomizer> customizers) {
    GSocketStrategiesBuilder builder = new GSocketStrategiesBuilder();
    customizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
    return builder.build();
  }
}
