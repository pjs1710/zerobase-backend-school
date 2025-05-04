plugins {
    id("java")
}

group = "dev.timer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("net.datafaker:datafaker:2.4.2")


}

tasks.test {
    useJUnitPlatform()
}