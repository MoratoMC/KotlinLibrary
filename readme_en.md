# KotlinLibrary
Add Kotlin support for Bukkit, allowing you to avoid including large Kotlin libraries in your plugin Jar files.

## How to use?
1. Add a dependency to your plugin project
```yaml
name: example
main: org.example.Example
depend: [ KotlinLibrary ]
```
2. Modify your build.gradle file or build.gradle.kts
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

3. **Enjoy the small Jar file!**