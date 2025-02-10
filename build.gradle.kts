import com.google.protobuf.gradle.*

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"

	//gRPC
	id("com.google.protobuf") version "0.9.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("com.plaid:plaid-java:29.0.0")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.graphql:spring-graphql-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	//gRPC
	implementation("io.grpc:grpc-kotlin-stub:1.4.1")
	implementation("com.google.protobuf:protobuf-kotlin:4.28.3")
	implementation("net.devh:grpc-server-spring-boot-starter:3.1.0.RELEASE")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:4.28.3"
	}

	plugins {
		create("grpc") {
			artifact = "io.grpc:protoc-gen-grpc-java:1.68.1"
		}
		create("grpckt") {
			artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.1:jdk8@jar"
		}
	}

	generateProtoTasks {
		all().forEach {
			it.plugins {
				create("grpc")
				create("grpckt")
			}
			it.builtins {
				create("kotlin")
			}
		}
	}
}

sourceSets {
	main {
		java {
			srcDir("build/generated/source/proto/main")
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.compileKotlin {
	dependsOn("generateProto")
}
