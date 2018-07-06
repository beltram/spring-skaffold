import groovy.lang.GroovyObject
import org.gradle.api.tasks.util.PatternSet
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.contracts.model.structure.UNKNOWN_COMPUTATION.type
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.dsl.SpringBootExtension
import org.gradle.internal.os.OperatingSystem
import org.springframework.boot.gradle.tasks.run.BootRun

val springBootVersion = "2.0.3.RELEASE"

buildscript {
    repositories {
        mavenLocal()
        jcenter()
    }
    dependencies {
        val springBootVersion = "2.0.3.RELEASE"
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

plugins {
    val kotlinVersion = "1.2.51"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.5.RELEASE"
}

apply { plugin("org.springframework.boot") }

group = "io.beltram"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    jcenter()
}

dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-starter-parent:$springBootVersion") }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compile("org.springframework.boot:spring-boot-starter-webflux")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    testCompile ("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("io.projectreactor:reactor-test")
}


tasks {
    val build by tasks
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=compatibility")
        }
    }
    val test = withType<Test> { useJUnitPlatform() }
}