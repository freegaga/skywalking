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

package org.skywalking.apm.collector.storage.table.jvm;

import org.skywalking.apm.collector.core.data.Column;
import org.skywalking.apm.collector.core.data.Data;
import org.skywalking.apm.collector.core.data.operator.CoverOperation;
import org.skywalking.apm.collector.core.data.operator.NonOperation;

/**
 * @author peng-yongsheng
 */
public class MemoryMetric extends Data {

    private static final Column[] STRING_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_ID, new NonOperation()),
    };

    private static final Column[] LONG_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_INIT, new CoverOperation()),
        new Column(MemoryMetricTable.COLUMN_MAX, new CoverOperation()),
        new Column(MemoryMetricTable.COLUMN_USED, new CoverOperation()),
        new Column(MemoryMetricTable.COLUMN_COMMITTED, new CoverOperation()),
        new Column(MemoryMetricTable.COLUMN_TIME_BUCKET, new CoverOperation()),
    };

    private static final Column[] DOUBLE_COLUMNS = {
    };

    private static final Column[] INTEGER_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_INSTANCE_ID, new CoverOperation()),
    };

    private static final Column[] BOOLEAN_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_IS_HEAP, new CoverOperation()),
    };
    private static final Column[] BYTE_COLUMNS = {};

    public MemoryMetric(String id) {
        super(id, STRING_COLUMNS, LONG_COLUMNS, DOUBLE_COLUMNS, INTEGER_COLUMNS, BOOLEAN_COLUMNS, BYTE_COLUMNS);
    }

    public Long getInit() {
        return getDataLong(0);
    }

    public Long getMax() {
        return getDataLong(1);
    }

    public Long getUsed() {
        return getDataLong(2);
    }

    public Long getCommitted() {
        return getDataLong(3);
    }

    public Long getTimeBucket() {
        return getDataLong(4);
    }

    public Boolean getIsHeap() {
        return getDataBoolean(0);
    }

    public Integer getInstanceId() {
        return getDataInteger(0);
    }
}