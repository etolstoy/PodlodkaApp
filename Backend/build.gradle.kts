import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	dependencies {
		classpath("gradle.plugin.com.palantir.gradle.docker:gradle-docker:0.13.0")
	}
}

plugins {
	id("org.springframework.boot") version "2.1.8.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("com.palantir.docker") version "0.22.1"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

group = "ru.podlodka.backend"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val appName = "Podlodka"
val appVer by lazy { "0.1${gitRev()}" }

repositories {
	mavenCentral()
}

springBoot {
	buildInfo {
		properties {
			artifact = "$appName-$appVer.jar"
			version = appVer
			name = appName
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
	withType(KotlinCompile::class).configureEach {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	bootJar {
		manifest {
			attributes("Multi-Release" to true)
		}

		archiveBaseName.set(appName)
		archiveVersion.set(appVer)

		if (project.hasProperty("archiveName")) {
			archiveFileName.set(project.properties["archiveName"] as String)
		}
	}

	docker {
		val build = build.get()
		val bootJar = bootJar.get()
		val dockerImageName = "etolstoy/podlodka"

		dependsOn(build)

		name = "$dockerImageName:latest"
		tag("current", "$dockerImageName:$appVer")
		tag("latest", "$dockerImageName:latest")
		files(bootJar.archiveFile)
		setDockerfile(file("$projectDir/Dockerfile"))
		buildArgs(
				mapOf(
						"JAR_FILE" to bootJar.archiveFileName.get(),
						"JAVA_OPTS" to "-XX:-TieredCompilation",
						"PORT" to "8080"
				)
		)
		pull(true)
	}
}

fun gitRev() = ProcessBuilder("git", "rev-parse", "--short", "HEAD").start().let { p ->
	p.waitFor(100, TimeUnit.MILLISECONDS)
	p.inputStream.bufferedReader().readLine() ?: "none"
}