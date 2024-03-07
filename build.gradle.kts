import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"

	kotlin("jvm") version "1.9.22"
	kotlin("kapt") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22" apply false
	kotlin("plugin.jpa") version "1.9.22" apply false
	kotlin("plugin.allopen") version "1.9.22" apply false
}

group = "freeapp.life"
version = "0.0.1-SNAPSHOT"

val projectGroup: String by project
val applicationVersion: String by project

java {
	sourceCompatibility = JavaVersion.VERSION_21
	targetCompatibility = JavaVersion.VERSION_21
}

allprojects {
	group = projectGroup
	version = applicationVersion

	repositories {
		mavenCentral()
	}

}



subprojects {
	apply(plugin = "java")

	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "kotlin-jpa")

	dependencies {

		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		//json 직렬화
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5-jakarta:2.15.2")
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate6:2.15.2")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5:2.15.2")
		implementation("com.fasterxml.jackson.core:jackson-databind")

		implementation("io.github.microutils:kotlin-logging:3.0.4")
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
		testImplementation("org.springframework.boot:spring-boot-starter-test")

	}

	dependencyManagement {
		imports {
			mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "21"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}

}

project(":module-storage") {
	val jar: Jar by tasks
	val bootJar: BootJar by tasks

	bootJar.enabled = false
	jar.enabled = true
}












