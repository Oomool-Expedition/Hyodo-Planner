import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("kapt") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
}

allprojects {
	group = "com.oomool"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "java")

	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

	apply(plugin = "kotlin")
	apply(plugin = "kotlin-kapt")

	kapt {
		keepJavacAnnotationProcessors = true
	}

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-validation")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")

		implementation("org.springframework.boot:spring-boot-starter-security")
		implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

		implementation("com.google.firebase:firebase-admin:9.2.0")
		compileOnly("org.projectlombok:lombok")
		annotationProcessor("org.projectlombok:lombok")

		runtimeOnly("com.mysql:mysql-connector-j")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.security:spring-security-test")
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "21"
		}
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "21"
		targetCompatibility = "21"
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

project(":domain") {
	val jar: Jar by tasks
	val bootJar: BootJar by tasks

	bootJar.enabled = false
	jar.enabled = true
}

project(":app:core") {
	val jar: Jar by tasks
	val bootJar: BootJar by tasks

	bootJar.enabled = false
	jar.enabled = true

	dependencies {
		api(project(":domain"))
	}
}

project(":app:planner") {
	dependencies {
		implementation(project(":app:core"))
	}
}

project(":app:user") {
	dependencies {
		implementation(project(":app:core"))
	}
}