package dev.schlaubi.lejos.gradle

import lejos
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.jvm.tasks.Jar
import java.io.File

abstract class LejosRunTask : Jar() {
    init {
        from((project.extensions.getByName("sourceSets") as SourceSetContainer).getByName("main").output.classesDirs)
        destinationDirectory.set(project.file("${project.buildDir}/lejos"))
        archiveBaseName.set("lejos-program-${name}")
        manifest.attributes(mapOf("Class-Path" to "/home/root/lejos/lib/ev3classes.jar /home/root/lejos/lib/opencv-2411.jar /home/root/lejos/lib/dbusjava.jar /home/root/lejos/libjna/usr/share/java/jna.jar"))

        from({ project.configurations.getByName("runtimeClasspath").map { if (it.isDirectory()) it else project.zipTree(it) } })

        doLast { startBotTask() }
    }

    fun mainClass(name: String) = manifest.attributes(mapOf("Main-Class" to name))

    private fun startBotTask() {
        project.exec {
            standardOutput = System.out
            val base = System.getenv("LEJOS_HOME") ?: error("Please define LEJOS_HOME")
            commandLine("$base/bin/ev3scpupload.bat")
            val file = archiveFile.get().asFile
            args("-n", project.lejos.botIp.get(), "-r", file.absolutePath, "/home/lejos/programs/${file.name}")
        }
    }
}