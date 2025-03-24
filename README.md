## 项目概述
这是一个简单的 Java 测试框架示例

## 项目结构

工作区包含以下文件夹和文件：

- `src`: 用于存放源代码的文件夹
  - `func`: 包含自定义的测试框架和断言工具类
    - `Assert.java`: 自定义断言工具类
    - `TR.java`: 轻量级测试运行器
  - `test`: 包含测试类
    - `test1.java`: 基础断言功能测试类
    - `test2.java`: 断言功能测试类
- `lib`: 用于存放依赖项的文件夹
- `bin`: 用于存放编译后的输出文件的文件夹

> 如果您想自定义文件夹结构，请打开 `.vscode/settings.json` 并更新相关设置。

## 测试框架

### TR.java

`TR` 是一个轻量级的测试运行器，核心功能包括：

- 自动发现指定包路径下的测试类。
- 支持两种测试方法识别方式：
  - 方法名以 "test" 开头。
  - 使用 `@Test` 注解标记。
- 提供基础测试统计功能。

### Assert.java

`Assert` 是一个自定义的断言工具类，提供了常见的测试断言方法，包括：

- `assertEquals`: 断言两个值相等。
- `assertTrue`: 断言条件为 true。
- `assertFalse`: 断言条件为 false。
- `assertNotNull`: 断言对象不为 null。
- `assertNull`: 断言对象为 null。
- `assertGreaterThan`: 断言第一个数值大于第二个。
- `assertLessThan`: 断言第一个数值小于第二个。
- `reportErrors`: 统一报告所有断言错误。

## 使用说明

### 运行项目

1. 打开项目文件夹 `MyTR`。
2. 确保安装了 Java Development Kit (JDK)。
3. 使用 VS Code 打开项目。
4. 打开终端并运行以下命令来编译项目：
   ```sh
   javac -d bin src/func/*.java src/test/*.java
