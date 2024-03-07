
plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("kapt")
}



dependencies {

    api("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.linecorp.kotlin-jdsl:jpql-dsl:3.3.1")
    implementation("com.linecorp.kotlin-jdsl:jpql-render:3.3.1")

    //runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}