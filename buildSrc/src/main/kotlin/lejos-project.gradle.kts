plugins {
    java
}

tasks {
    task<Jar>("buildForLejos") {
        manifest.attributes(
                "Main-Cl"
        )
    }
}