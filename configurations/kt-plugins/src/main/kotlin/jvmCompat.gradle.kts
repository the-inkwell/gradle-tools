import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val javaVersion: JvmTarget = if (rootProject.extra.has("javaVersion")) {
    val version = rootProject.extra.get("javaVersion") as String
    println("using $version")
    JvmTarget.fromTarget(version)
} else {
    println("Warning : you didn't define any javaVersion in your rootProject. Using 17 by default")
    JvmTarget.JVM_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(javaVersion)
    }
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = javaVersion.target
    targetCompatibility = javaVersion.target
}
