package dev.schlaubi.lejos.gradle

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.jvm.tasks.Jar

abstract class LejosRunTask : Jar() {
    init {
        from((project.extensions.getByName("sourceSets") as SourceSetContainer).getByName("main").output.classesDirs)
        destinationDirectory.set(project.file("${project.buildDir}/lejos"))
        archiveBaseName.set("lejos-program-${name}")
        manifest.attributes(mapOf("Class-Path" to "/home/root/lejos/lib/ev3classes.jar /home/root/lejos/lib/opencv-2411.jar /home/root/lejos/lib/dbusjava.jar /home/root/lejos/libjna/usr/share/java/jna.jar"))

        from({ project.configurations.getByName("runtimeClasspath").map { if (it.isDirectory()) it else project.zipTree(it) } })
    }

    fun mainClass(name: String) = manifest.attributes(mapOf("Main-Class" to name))
}