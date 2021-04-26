plugins {
    java
    id("org.springframework.boot") version "2.2.8.RELEASE"
    id("io.spring.dependency-management") version "1.0.5.RELEASE"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("au.com.bytecode:opencsv:2.4")
    implementation("junit", "junit", "4.12")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.postgresql:postgresql:42.2.2")
    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")


}
