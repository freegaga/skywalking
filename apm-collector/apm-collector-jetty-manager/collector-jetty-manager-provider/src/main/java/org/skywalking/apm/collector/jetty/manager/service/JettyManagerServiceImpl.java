/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.collector.jetty.manager.service;

import java.util.HashMap;
import java.util.Map;
import org.skywalking.apm.collector.server.Server;
import org.skywalking.apm.collector.server.jetty.JettyServer;

/**
 * @author peng-yongsheng
 */
public class JettyManagerServiceImpl implements JettyManagerService {

    private Map<String, JettyServer> servers = new HashMap<>();

    @Override public Server getElseCreateServer(String host, int port, String contextPath) {
        String id = host + String.valueOf(port);
        if (servers.containsKey(id)) {
            return servers.get(id);
        } else {
            JettyServer server = new JettyServer(host, port, contextPath);
            servers.put(id, server);
            return server;
        }
    }
}