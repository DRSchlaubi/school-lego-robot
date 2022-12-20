import org.gradle.api.provider.Property
import org.gradle.api.Project
import java.util.Properties

internal const val LEJOS_NAME = "lejos"
internal const val PROPERTIES_NAME = "localProperties"

abstract class LejosExtension {
    abstract val botIp: Property<String>
}

abstract class PropertiesExtension(private val properties: Properties) {
    fun get(key: Any) = properties.get(key)
    fun getString(key: Any) = get(key)?.toString()
}

internal val Project.lejos: LejosExtension
    get() = extensions.getByName(LEJOS_NAME) as LejosExtension

internal val Project.localProperties: PropertiesExtension
    get() = extensions.getByName(PROPERTIES_NAME) as PropertiesExtension
