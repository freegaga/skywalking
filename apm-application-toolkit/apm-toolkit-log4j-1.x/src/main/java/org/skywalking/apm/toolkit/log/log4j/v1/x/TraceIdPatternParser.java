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

package org.skywalking.apm.toolkit.log.log4j.v1.x;

import org.apache.log4j.helpers.PatternParser;

/**
 * Base on '%T', use {@link TraceIdPatternConverter} to convert the '%t' to traceId.
 * <p>
 * Created by wusheng on 2016/12/7.
 */
public class TraceIdPatternParser extends PatternParser {
    public TraceIdPatternParser(String pattern) {
        super(pattern);
    }

    @Override
    protected void finalizeConverter(char c) {
        if ('T' == c) {
            addConverter(new TraceIdPatternConverter());
        } else {
            super.finalizeConverter(c);
        }
    }
}
