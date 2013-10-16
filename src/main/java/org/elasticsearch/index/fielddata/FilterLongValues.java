/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.index.fielddata;

/**
 * <code>FilterLongValues</code> contains another {@link LongValues}, which it
 * uses as its basic source of data, possibly transforming the data along the
 * way or providing additional functionality.
 */
public class FilterLongValues extends LongValues {

    protected final LongValues delegate;

    protected FilterLongValues(LongValues delegate) {
        super(delegate.isMultiValued());
        this.delegate = delegate;
    }

    @Override
    public boolean hasValue(int docId) {
        return delegate.hasValue(docId);
    }

    @Override
    public long getValue(int docId) {
        return delegate.getValue(docId);
    }

    @Override
    public int setDocument(int docId) {
        return delegate.setDocument(docId);
    }

    @Override
    public long nextValue() {
        return delegate.nextValue();
    }

    @Override
    public long getValueMissing(int docId, long missingValue) {
        return delegate.getValueMissing(docId, missingValue);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
