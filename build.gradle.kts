plugins {
    kotlin("jvm") version "1.6.0"
}

group = "dev.siro256.spigotpl.confinechickens"
version = "0.1.0-SNAPSHOT"

repositories {
    maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
}

dependencies {
    //Kotlin
    implementation(kotlin("stdlib"))
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

        from(projectDir) {
            include("LICENSE")
        }
    }

    withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE

        from(configurations.api.get().apply { isCanBeResolved = true }.map { if (it.isDirectory) it else zipTree(it) })
    }
}
