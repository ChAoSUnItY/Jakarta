plugins {
    id("java")
    id("groovy")
}

group = "io.github.chaosunity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project("lexer"))
    implementation(project("parser"))

    implementation("org.codehaus.groovy:groovy:1.5.0")
}