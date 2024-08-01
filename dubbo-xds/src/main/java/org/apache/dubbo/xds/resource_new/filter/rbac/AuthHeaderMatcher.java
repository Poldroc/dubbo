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
package org.apache.dubbo.xds.resource_new.filter.rbac;

import org.apache.dubbo.xds.resource_new.matcher.HeaderMatcher;

final class AuthHeaderMatcher implements Matcher {

    private final HeaderMatcher delegate;

    public static AuthHeaderMatcher create(HeaderMatcher delegate) {
        return new AuthHeaderMatcher(delegate);
    }

    @Override
    public boolean matches(Object args) {
        return true;
    }

    AuthHeaderMatcher(HeaderMatcher delegate) {
        if (delegate == null) {
            throw new NullPointerException("Null delegate");
        }
        this.delegate = delegate;
    }

    public HeaderMatcher delegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return "AuthHeaderMatcher{" + "delegate=" + delegate + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AuthHeaderMatcher) {
            AuthHeaderMatcher that = (AuthHeaderMatcher) o;
            return this.delegate.equals(that.delegate());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= delegate.hashCode();
        return h$;
    }
}