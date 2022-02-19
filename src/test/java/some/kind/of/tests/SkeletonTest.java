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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import some.kind.of.framework.api.WaiveApi;
import some.kind.of.framework.utils.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("fast")
class SkeletonTest {

    @Test
    @DisplayName("Test sample")
    void testSample() {
        WaiveApi api = new TestFactory().getApi();
        assertEquals(2, api.sum(1, 1), "1 + 1 should equal 2");
    }

}
