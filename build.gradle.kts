plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "dev.ajuda"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}
sourceSets {
	create("integrationTest") {
		java.srcDir("src/integrationTest/java")
		resources.srcDir("src/integrationTest/resources")
		compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
		runtimeClasspath += output + compileClasspath
	}
}
tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<ProcessResources> {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named<ProcessResources>("processIntegrationTestResources") {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.register<Test>("integrationTest") {
	description = "Executa os testes de integração"
	group = "verification"

	testClassesDirs = sourceSets["integrationTest"].output.classesDirs
	classpath = sourceSets["integrationTest"].runtimeClasspath

	useJUnitPlatform() // necessário para JUnit 5
	shouldRunAfter("test")
}
tasks.named("check") {
	dependsOn("integrationTest")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springframework.security:spring-security-crypto")
	implementation("org.apache.commons:commons-lang3")
	implementation("org.springframework:spring-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	"integrationTestImplementation"("org.testcontainers:testcontainers")
	"integrationTestImplementation"("org.testcontainers:junit-jupiter")
	"integrationTestImplementation"("org.testcontainers:postgresql")

}



