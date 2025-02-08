plugins {
    id("java")
    id("org.springframework.boot") version "3.1.4" // 최신 버전 사용
    id("io.spring.dependency-management") version "1.1.3"
}

group = "io.spring.batch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {

    implementation ("com.mysql:mysql-connector-j")
    implementation ("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework:spring-web")
    compileOnly ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")
    testCompileOnly ("org.projectlombok:lombok")
    testAnnotationProcessor ("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}