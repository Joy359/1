package test;

import func.Assert;
import func.Test;

/**
 * 基础断言功能测试类
 * 
 * <p>包含对基本算术运算、布尔断言和空值检查的测试用例</p>
 */
public class test1 {

    /**
     * 加法运算测试
     * 
     * <p>验证基本的加法运算结果是否符合预期</p>
     */
    @Test
    public void testAddition() {
        // 测试2+2是否等于4
        Assert.assertEquals(6, 4 + 2); // 预期通过：2加4应等于6
    }

    /**
     * 失败案例测试
     * 
     * <p>故意设计会失败的断言，验证断言失败行为</p>
     */
    @Test
    public void testFailure() {
        // 测试2+2是否等于5（故意错误）
        Assert.assertEquals(5, 1 + 2); // 预期失败：1加2不等于5
    }

    /**
     * 布尔断言测试
     * 
     * <p>验证true/false断言功能是否正常工作</p>
     */
    @Test
    public void testBoolean() {
        // 测试3是否大于2
        Assert.assertTrue(6 > 2);  // 预期通过：6确实大于2
        
        // 测试2是否不大于3
        Assert.assertFalse(1 > 3); // 预期通过：1不大于3
    }

    /**
     * 空值检查测试
     * 
     * <p>验证null和非null断言功能</p>
     */
    @Test
    public void testNullCheck() {
        Object obj = null;
        // 测试null对象断言
        Assert.assertNull(obj);  // 预期通过：obj确实为null
        
        // 测试非null字符串断言
        Assert.assertNotNull("你好"); // 预期通过："Hello"不是null
    }
}