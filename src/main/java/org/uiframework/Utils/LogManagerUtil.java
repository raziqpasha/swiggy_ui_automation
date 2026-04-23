package org.uiframework.Utils;

import org.apache.logging.log4j.ThreadContext;

public class LogManagerUtil {

    public static void setTestName(String testName) {
        ThreadContext.put("testName", testName);
        // Store test name in ThreadLocal context
    }

    public static void clear() {
        ThreadContext.clearAll();
        // Clear after test ends
    }
}