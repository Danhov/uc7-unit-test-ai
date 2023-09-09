plugins {
    id("java")
    application
    jacoco
    id("org.sonarqube") version "4.2.1.3168"
}

group = "uc7.unitTest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Define the main class for the application.
    mainClass.set("uc7.unitTest.Main")
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}

sonar {
    properties {
        property("sonar.projectKey", "Danhov_uc7-unit-test-ai")
        property("sonar.organization", "danhov")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", "3e2efd7dd24072301286236f76e914eaa8359887")
    }
}