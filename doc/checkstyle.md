## checkstyle

### 1. 配置

```bash
plugins {
    id "checkstyle"
}

checkstyle 
    toolVersion = "10.23.0"
}
```

整体基于google的checkstyle规则，主要修改了以下几个地方：

* 1.1 代码行长度限制修改为120
* 1.2 javadoc的要求
* 1.3 import规范使用兼容idea默认的import风格

### 2. 运行

```bash
./gradlew check
```