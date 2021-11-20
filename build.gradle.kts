import org.apache.tools.ant.filters.ReplaceTokens
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "dev.siro256.spigotpl.confinechickens"
version = "1.0.0"

repositories {
    maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
}

dependencies {
    //Kotlin
    implementation(kotlin("stdlib"))

    //Spigot
    implementation("org.spigotmc:spigot-api:1.17-R0.1-SNAPSHOT")
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "16"

        //Strict
        kotlinOptions.allWarningsAsErrors = true
    }

    withType<ProcessResources> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        filteringCharset = "UTF-8"

        from(sourceSets.main.get().resources.srcDirs) {
            include("plugin.yml")

            filter<ReplaceTokens>(
                "tokens" to mapOf(
                    "name" to project.name,
                    "version" to version
                )
            )
        }

        from(projectDir) {
            include("LICENSE")
        }
    }

    withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE

        from(configurations.api.get().apply { isCanBeResolved = true }.map { if (it.isDirectory) it else zipTree(it) })
    }
}
