# Does Spotbugs work with Kotlin?

In a word: _Yes_.

Spotbugs works by analyzing the bytecode, so Kotlin projects work with Spotbugs as well. For example:

The following Java function causes Spotbugs to emit an error:
```java
public static String generateSecretToken() {
    Random r = new Random();
    return Long.toHexString(r.nextLong());
}
// H B DMI: Random object created and used only once in Main.generateSecretToken()  At Main.java:[line 10]
```

Similarly, the following Kotlin function emits the same error:

```kotlin
fun generateSecretToken(): String {
    val r = Random()
    return java.lang.Long.toHexString(r.nextLong())
}
// B DMI: Random object created and used only once in MainKt.generateSecretToken()  At Main.kt:[line 9]
```

You can see for yourself by cloning this project and running `./gradlew check`.

## How do I apply the Spotbugs plugin?

Simply add the spotbugs gradle plugin:
```kotlin
plugins {
    id("com.github.spotbugs") version "5.1.3"
}
```