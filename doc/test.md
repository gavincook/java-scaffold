## 测试

### 1. 执行

```bash
./gradlew clean test
```

### 2. 测试控制台输出

#### 2.1 gradle预定义配置

```groovy
tasks.named('test') {
    useJUnitPlatform {
        includeEngines 'junit-jupiter', 'spock'
    }
    testLogging {
        events "passed", "skipped", "failed"
        exceptionFormat "full"
        showStandardStreams = true
    }
}
```

输出样例如下：

```plain
> Task :test

UserServiceTest > getUser -- should get user by id STANDARD_OUT
    10:41:01.995 [Test worker] INFO com.example.biz.domain.service.UserService -- Retrieving user with ID: 1

UserServiceTest > getUser -- should get user by id PASSED

BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```

无测试用例执行的统计信息。

#### 2.2 插件配置方式

* 增加插件依赖

```groovy
plugins {
    id "com.adarshr.test-logger" version "4.0.0"
}
```

* 配置插件

```groovy
  testlogger {
    // pick a theme - mocha, standard, plain, mocha-parallel, standard-parallel or plain-parallel 
    theme 'standard'
    // set to false to disable detailed failure logs
    showExceptions true

    // set to false to hide stack traces
    showStackTraces true

    // set to true to remove any filtering applied to stack traces
    showFullStackTraces false

    // set to false to hide exception causes
    showCauses true

    // set threshold in milliseconds to highlight slow tests
    slowThreshold 2000

    // displays a breakdown of passes, failures and skips along with total duration
    showSummary true

    // set to true to see simple class names
    showSimpleNames false

    // set to false to hide passed tests
    showPassed true

    // set to false to hide skipped tests
    showSkipped true

    // set to false to hide failed tests
    showFailed true

    // enable to see standard out and error streams inline with the test results
    showStandardStreams true

    // set to false to hide passed standard out and error streams
    showPassedStandardStreams true

    // set to false to hide skipped standard out and error streams
    showSkippedStandardStreams true

    // set to false to hide failed standard out and error streams
    showFailedStandardStreams true
}
```

此时需要移除`testLogging`中的配置，否则可能出现一些输出重复。输出样例

```plain
> Task :test

com.example.biz.domain.service.UserServiceTest

  Test getUser -- should get user by id PASSED

    10:45:58.456 [Test worker] INFO com.example.biz.domain.service.UserService -- Retrieving user with ID: 1


SUCCESS: Executed 1 tests in 678ms


BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed

```

可以看到会输出一些统计相关信息，格式也做了一些调整。