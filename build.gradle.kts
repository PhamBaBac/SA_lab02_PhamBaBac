plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.github.javaparser:javaparser-core:3.25.8")
    implementation("com.google.guava:guava:33.0.0-jre")
    implementation("org.apache.opennlp:opennlp-tools:2.3.2")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.slf4j:slf4j-api:1.7.32")
}

tasks.test {
    useJUnitPlatform()
}