plugins {
    id("java")
    id("groovy")
    id("scala")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "groovy")
    apply(plugin = "scala")

    group = "io.github.chaosunity"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.codehaus.groovy:groovy:1.5.0")
        implementation("org.scala-lang:scala3-library_3:3.0.1")
    }
}

dependencies {
    implementation(project("lexer"))
    implementation(project("parser"))
}