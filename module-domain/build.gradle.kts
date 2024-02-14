
plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("kapt")
}

dependencies {
    //compileOnly(project(":module-domain"))
}

tasks.test {
    useJUnitPlatform()
}