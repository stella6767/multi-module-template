
plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("kapt")
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}