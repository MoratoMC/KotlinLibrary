# KotlinLibrary
为bukkit添加kotlin支持, 让你不需要在你的插件Jar文件中包含巨大的Kotlin库.

## 如何使用?
1. 在你的插件项目中添加依赖
```yaml
name: example
main: org.example.Example
depend: [ KotlinLibrary ]
```
2. 修改你的build.gradle文件或build.gradle.kts
```groovy
depends {
    ...
    compileOnly "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    ...
}
```
```kotlin
dependencies {
    ...
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    ...
}
```

3. **大功告成! 享受超小的Jar文件吧!**