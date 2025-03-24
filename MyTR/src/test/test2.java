package test;

import func.Assert;
import func.Test;

/**
 * 断言功能测试类
 * 
 * <p>包含对Assert工具类各种断言方法的测试用例</p>
 */
public class test2 {

    /**
     * 基础断言测试
     * 
     * <p>测试基本的相等、true/false断言功能</p>
     */
    @Test
    public void testBasicAssertions() {
        // 测试相等断言
        Assert.assertEquals(7, 2 + 5);  // 预期通过：7等于2+5
        
        // 测试true断言
        Assert.assertTrue(2 > 1);        // 预期通过：2确实大于1
        
        // 测试false断言
        Assert.assertFalse(2 > 6);       // 预期通过：2不大于6
    }

    /**
     * null值断言测试
     * 
     * <p>测试对null值的断言功能</p>
     */
    @Test
    public void testNullAssertions() {
        // 测试null断言
        Assert.assertNull(null);         // 预期通过：输入确实是null
        
        // 测试非null断言
        Assert.assertNotNull("konichiha");   // 预期通过：字符串不是null
    }

    /**
     * 异常处理测试
     * 
     * <p>测试在异常情况下的断言行为</p>
     */
    @Test
    public void testException() {
        try {
            int result = 78 / 0;  // 预期抛出ArithmeticException
            Assert.assertTrue(false); // 不应执行到此
        } catch (ArithmeticException e) {
            // 验证确实捕获到了预期异常
            Assert.assertTrue(true);  // 预期通过：捕获到除零异常
        }
    }

    /**
     * 性能测试
     * 
     * <p>测试代码执行时间是否符合预期</p>
     */
    @Test
    public void testPerformance() {
        // 记录开始时间
        long startTime = System.nanoTime();

        // 模拟计算密集型操作
        double result = 0;
        for (int i = 0; i < 6666666; i++) {
            result += Math.sqrt(i);
        }

        // 记录结束时间
        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1e6; // 纳秒转毫秒

        // 断言执行时间在合理范围内
        Assert.assertTrue(durationMs < 66);  // 预期执行时间小于10ms
        
        // 验证计算结果有效性
        Assert.assertTrue(result > 0);      // 预期计算结果为正数

        System.out.println("性能测试执行时间: " + durationMs + "ms");
    }

    /**
     * 边界值测试
     * 
     * <p>测试整数边界值的断言功能</p>
     */
    @Test
    public void testBoundaryValues() {
        // 测试int最大值
        Assert.assertEquals(Integer.MAX_VALUE, 2147483647);  // 预期通过
        
        // 测试int最小值
        Assert.assertEquals(Integer.MIN_VALUE, -2147483648); // 预期通过
    }
}