/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.xds.resource_new.route.plugin;

public class NamedPluginConfig {

    private final String name;

    private final PluginConfig config;

    NamedPluginConfig(String name, PluginConfig config) {
        if (name == null) {
            throw new NullPointerException("Null name");
        }
        this.name = name;
        if (config == null) {
            throw new NullPointerException("Null config");
        }
        this.config = config;
    }

    String name() {
        return name;
    }

    PluginConfig config() {
        return config;
    }

    @Override
    public String toString() {
        return "NamedPluginConfig{" + "name=" + name + ", " + "config=" + config + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof NamedPluginConfig) {
            NamedPluginConfig that = (NamedPluginConfig) o;
            return this.name.equals(that.name()) && this.config.equals(that.config());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= name.hashCode();
        h$ *= 1000003;
        h$ ^= config.hashCode();
        return h$;
    }

    public static NamedPluginConfig create(String name, PluginConfig config) {
        return new NamedPluginConfig(name, config);
    }
}