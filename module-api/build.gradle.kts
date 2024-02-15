import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("java")
    kotlin("kapt")
}

configurations {
    runtimeOnly {
        exclude(group = "commons-logging", module = "commons-logging")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}


dependencies {

    api(project(":module-storage"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")

}