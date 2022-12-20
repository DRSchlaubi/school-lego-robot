import java.io.FileInputStream
import java.util.*

plugins {
    java
}

extensions.create(LEJOS_NAME, LejosExtension::class)

val localProperties = Properties()
val file = file("local.properties")
if (file.exists()) {
    FileInputStream(file).use { localProperties.load(it) }
}

extensions.create(PROPERTIES_NAME, PropertiesExtension::class, localProperties)
