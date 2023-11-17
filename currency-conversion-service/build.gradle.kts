import org.springframework.boot.buildpack.platform.build.PullPolicy
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
	java
	id("org.springframework.boot") version "3.0.3"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.roofflex"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2022.0.1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

	// Micrometer - Vendor-neutral application observability facade.
	// Instrument your JVM-based application code without vendor lock-in.
	// Observation (Metrics & Logs) + Tracing.
	implementation("io.micrometer:micrometer-observation")

	// OpenTelemetry - Simplified Observability (metrics, logs, and traces)
	// Serves as a brisge between Micrometer and Zipkin
	implementation("io.micrometer:micrometer-tracing-bridge-otel")
	// Zipkin exports telemetry
	implementation("io.opentelemetry:opentelemetry-exporter-zipkin")

	// Enables tracing of REST API calls made using Feign
	implementation("io.github.openfeign:feign-micrometer");

	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


tasks.named<BootBuildImage>("bootBuildImage") {
	imageName.set("roofflex/microservicescourse-${project.name}:${project.version}")
	pullPolicy.set(PullPolicy.IF_NOT_PRESENT)
}
