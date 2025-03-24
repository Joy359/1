package func;

import java.io.File;
import java.net.URL;
import java.util.Objects;

/**
 * 轻量级测试运行器
 * 
 * <p>核心功能：</p>
 * <ul>
 *   <li>自动发现指定包路径下的测试类</li>
 *   <li>支持两种测试方法识别方式：
 *     <ol>
 *       <li>方法名以"test"开头</li>
 *       <li>使用@Test注解标记</li>
 *     </ol>
 *   </li>
 *   <li>提供基础测试统计功能</li>
 * </ul>
 */
public class TR {

    /**
     * 启动测试执行流程
     * 
     * @param args 命令行参数（当前版本未使用）
     */
    public static void main(String[] args) {
        runAllTests("test"); // 默认扫描test包
    }

    /**
     * 执行包级测试扫描
     * 
     * @param packageName 目标包名（使用点分隔符，如"com.tests"）
     */
    public static void runAllTests(String packageName) {
        try {
            // 获取类加载资源路径
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL packageURL = classLoader.getResource(packageName.replace(".", "/"));

            if (packageURL == null) {
                System.out.println(" 无法找到包: " + packageName);
                return;
            }

            // 转换为文件系统路径
            File directory = new File(packageURL.toURI());
            if (!directory.exists()) {
                System.out.println(" 目录不存在: " + directory.getAbsolutePath());
                return;
            }

            // 遍历.class文件
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().replace(".class", "");
                    runTests(className);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行单个测试类的所有测试方法
     * 
     * @param className 待测试类的全限定名
     */
    public static void runTests(String className) {
        try {
            Class<?> testClass = Class.forName(className);
            int passed = 0, failed = 0;

            // 反射获取所有方法
            for (var method : testClass.getDeclaredMethods()) {
                if (method.getName().startsWith("test") || method.isAnnotationPresent(Test.class)) {
                    try {
                        // 实例化并执行测试方法
                        Object instance = testClass.getDeclaredConstructor().newInstance();
                        method.invoke(instance);
                        System.out.println(" 成功: " + method.getName());
                        passed++;
                    } catch (Exception e) {
                        System.out.println(" 失败: " + method.getName() + " -> " + e.getCause());
                        failed++;
                    }
                }
            }
            System.out.println();
            System.out.println("测试完成：");
            System.out.println( className + "，通过: " + passed + "，失败: " + failed);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}