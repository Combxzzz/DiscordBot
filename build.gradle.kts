plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("dev.combos.mtgbot.Main")
}

group = "dev.combos.mtgbot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("net.dv8tion:JDA:6.7.0")
    implementation("ch.qos.logback:logback-classic:1.6.5")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}