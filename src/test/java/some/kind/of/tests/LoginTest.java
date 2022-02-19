/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package some.kind.of.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import some.kind.of.framework.api.ApiInstance;
import some.kind.of.framework.utils.Login;
import some.kind.of.framework.utils.TestFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Login")
class LoginTest {

    private ApiInstance api;

    @BeforeEach
    public void setUp() {
        api = new TestFactory().getApi(Login.LOGGED_OUT);
    }

    @Test
    @DisplayName("Login Test")
    @Tag("Positive")
    void loginTest() {
        assertTrue(api.login());
    }

}
