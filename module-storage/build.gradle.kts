
plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("kapt")
}



dependencies {

    compileOnly(project(":module-core"))

    implementation("com.linecorp.kotlin-jdsl:jpql-dsl:3.3.1")
    implementation("com.linecorp.kotlin-jdsl:jpql-render:3.3.1")

    runtimeOnly("com.mysql:mysql-connector-j")
}

tasks.test {
    useJUnitPlatform()
}