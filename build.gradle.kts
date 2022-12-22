import dev.schlaubi.lejos.gradle.LejosRunTask

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.5.1/samples
 */

plugins {
    java
    `lejos-project`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(files(lejosHome("lib", "ev3", "ev3classes.jar")))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}

tasks {
    task<LejosRunTask>("runTest1") {
        mainClass("Test")
    }
    task<LejosRunTask>("runTest2") {
        mainClass("Test2")
    }
    task<LejosRunTask>("runTableWalker") {
        mainClass("TableWalker")
    }
}

lejos {
    botIp.set(localProperties.getString("bot-ip") ?: error("""Please define "bot-ip" in local.properties"""))
}
