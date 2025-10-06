tasks.withType<Wrapper> {
    gradleVersion = "8.14.3"
}

group = "org.jetbrains.kotlinx.kover.dependency.issue"
version = "1.0.0"

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.2.20"

    id("org.jetbrains.kotlinx.kover") version "0.9.2"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

plugins.withType<JavaPlugin> {
    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm", "1.10.2")

    // Test
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5", "2.2.20")
    testImplementation("io.mockk", "mockk", "1.14.5")
}
