package org.uiframework.utils;

import org.openqa.selenium.WebElement;
import java.util.List;

public class AssertUtils {

    //AssertUtils.assertTrue(title.contains("Swiggy"), "Verify homepage");
    // ================= TRUE =================
    public static void assertTrue(boolean condition, String message) {
        org.testng.Assert.assertTrue(condition, message);
    }


    // ================= FALSE =================
    public static void assertFalse(boolean condition, String message) {
        org.testng.Assert.assertFalse(condition, message);
    }

    // ================= EQUALS =================
    public static void assertEquals(Object actual, Object expected, String message) {
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    // ================= NOT EQUALS =================
    //AssertUtils.assertEquals(price, 100, "Verify price");
    public static void assertNotEquals(Object actual, Object expected, String message) {
        org.testng.Assert.assertNotEquals(actual, expected, message);
    }

    // ================= CONTAINS =================
    public static void assertContains(String actual, String expected, String message) {
        assertTrue(actual.contains(expected),
                message + " | Expected: " + expected + " in " + actual);
    }

    // ================= NOT NULL =================
    public static void assertNotNull(Object obj, String message) {
        org.testng.Assert.assertNotNull(obj, message);
    }

    // ================= NULL =================
    public static void assertNull(Object obj, String message) {
        org.testng.Assert.assertNull(obj, message);
    }

    // ================= ELEMENT DISPLAYED =================
    //AssertUtils.assertElementDisplayed(loginButton, "Login button visible");
    public static void assertElementDisplayed(WebElement element, String message) {
        assertTrue(element.isDisplayed(), message);
    }

    // ================= TEXT EQUALS =================
    //AssertUtils.assertTextEquals(header, "Home", "Verify header text");
    public static void assertTextEquals(WebElement element, String expected, String message) {
        assertEquals(element.getText(), expected, message);
    }

    // ================= LIST CONTAINS =================
//AssertUtils.assertListContains(items, "Pizza", "Verify item present");
    public static void assertListContains(List<String> list, String value, String message) {
        assertTrue(list.contains(value),
                message + " | Expected: " + value + " in " + list);
    }

    // ================= GREATER THAN =================
    public static void assertGreater(int actual, int expected, String message) {
        assertTrue(actual > expected,
                message + " | Expected > " + expected + " but got " + actual);
    }

    // ================= LESS THAN =================
    //AssertUtils.assertGreater(total, 0, "Verify total > 0");
    public static void assertLess(int actual, int expected, String message) {
        assertTrue(actual < expected,
                message + " | Expected < " + expected + " but got " + actual);
    }

    // ================= FORCE FAIL =================
    //AssertUtils.fail("Force failure");
    public static void fail(String message) {
        org.testng.Assert.fail(message);
    }
}
