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
package org.apache.dubbo.xds.resource_new.matcher;

import org.apache.dubbo.common.lang.Nullable;
import org.apache.dubbo.common.utils.Assert;

import com.google.re2j.Pattern;

public class PathMatcher {

    @Nullable
    private final String path;

    @Nullable
    private final String prefix;

    @Nullable
    private final Pattern regEx;

    private final boolean caseSensitive;

    public static PathMatcher fromPath(String path, boolean caseSensitive) {
        Assert.notNull(path, "path must not be null");
        return create(path, null, null, caseSensitive);
    }

    public static PathMatcher fromPrefix(String prefix, boolean caseSensitive) {
        Assert.notNull(prefix, "prefix must not be null");
        return create(null, prefix, null, caseSensitive);
    }

    public static PathMatcher fromRegEx(Pattern regEx) {
        Assert.notNull(regEx, "regEx must not be null");
        return create(null, null, regEx, false /* doesn't matter */);
    }

    private static PathMatcher create(
            @Nullable String path, @Nullable String prefix, @Nullable Pattern regEx, boolean caseSensitive) {
        return new PathMatcher(path, prefix, regEx, caseSensitive);
    }

    PathMatcher(@Nullable String path, @Nullable String prefix, @Nullable Pattern regEx, boolean caseSensitive) {
        this.path = path;
        this.prefix = prefix;
        this.regEx = regEx;
        this.caseSensitive = caseSensitive;
    }

    @Nullable
    String path() {
        return path;
    }

    @Nullable
    String prefix() {
        return prefix;
    }

    @Nullable
    Pattern regEx() {
        return regEx;
    }

    boolean caseSensitive() {
        return caseSensitive;
    }

    public String toString() {
        return "PathMatcher{" + "path=" + path + ", " + "prefix=" + prefix + ", " + "regEx=" + regEx + ", "
                + "caseSensitive=" + caseSensitive + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof PathMatcher) {
            PathMatcher that = (PathMatcher) o;
            return (this.path == null ? that.path() == null : this.path.equals(that.path()))
                    && (this.prefix == null ? that.prefix() == null : this.prefix.equals(that.prefix()))
                    && (this.regEx == null ? that.regEx() == null : this.regEx.equals(that.regEx()))
                    && this.caseSensitive == that.caseSensitive();
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= (path == null) ? 0 : path.hashCode();
        h$ *= 1000003;
        h$ ^= (prefix == null) ? 0 : prefix.hashCode();
        h$ *= 1000003;
        h$ ^= (regEx == null) ? 0 : regEx.hashCode();
        h$ *= 1000003;
        h$ ^= caseSensitive ? 1231 : 1237;
        return h$;
    }
}