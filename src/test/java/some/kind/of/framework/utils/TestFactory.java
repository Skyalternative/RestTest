/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package some.kind.of.framework.utils;

import some.kind.of.framework.api.ApiInstance;

public class TestFactory {
    public ApiInstance getApi(Login loginState) {
        ApiInstance api = new ApiInstance(new ConfigHandler());

        if (loginState == Login.LOGGED_IN) {
            api.login();
        }

        return api;
    }
}
