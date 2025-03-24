package func;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义断言工具类
 * 提供常见的测试断言方法
 */
public class Assert {
    // 存储所有断言错误信息
    private static final List<String> errors = new ArrayList<>();

    /**
     * 断言两个值相等
     */
    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) return;
        if (expected == null || actual == null || !expected.equals(actual)) {
            String errorMessage = "期望值: " + expected + "，实际值: " + actual;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言条件为true
     */
    public static void assertTrue(boolean condition) {
        if (!condition) {
            String errorMessage = "期望true，实际false";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言条件为false
     */
    public static void assertFalse(boolean condition) {
        if (condition) {
            String errorMessage = "期望false，实际true";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言对象不为null
     */
    public static void assertNotNull(Object object) {
        if (object == null) {
            String errorMessage = "期望非null，实际为null";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言对象为null
     */
    public static void assertNull(Object object) {
        if (object != null) {
            String errorMessage = "期望null，实际为: " + object;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言第一个数值大于第二个
     */
    public static void assertGreaterThan(Number actual, Number expected) {
        if (!(actual.doubleValue() > expected.doubleValue())) {
            String errorMessage = "期望 " + actual + " > " + expected;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言第一个数值小于第二个
     */
    public static void assertLessThan(Number actual, Number expected) {
        if (!(actual.doubleValue() < expected.doubleValue())) {
            String errorMessage = "期望 " + actual + " < " + expected;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 统一报告所有断言错误
     */
    public static void reportErrors() {
        if (!errors.isEmpty()) {
            throw new AssertionError("测试失败:\n" + String.join("\n", errors));
        }
    }
}