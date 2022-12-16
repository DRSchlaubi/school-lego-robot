val lejosHome by lazy { System.getenv("LEJOS_HOME") ?: error("Please define a LEJOS_HOME environment variable") }
fun lejosHome(vararg children: String) = lejosHome + children.joinToString("/", "/")