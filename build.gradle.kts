import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    //java
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.flywaydb.flyway") version "8.0.1"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

group = "com.sora"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven (url = "http://google-api-client-libraries.appspot.com/mavenrepo")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.5.6")
    // OpenAPI
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("mysql:mysql-connector-java:8.0.25")
    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4:1.16") // logging
    implementation("org.flywaydb:flyway-core:8.0.1")
    // Youtube API
    implementation("com.google.apis:google-api-services-youtube:v3-rev8-1.12.0-beta")
    implementation("com.google.http-client:google-http-client-jackson2:1.12.0-beta")

    compileOnly("org.projectlombok:lombok:1.18.22")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.6")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.6")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        // Make sure output from standard out or error is shown in Gradle output.
        //showStandardStreams = true
        showExceptions = true
        showCauses = true
        showStackTraces = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

flyway {
    url = "jdbc:mysql://localhost:23306/chihuahua?useSSL=false"
    user = "mao"
    password = "mao"
}
