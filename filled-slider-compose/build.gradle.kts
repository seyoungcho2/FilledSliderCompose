import version.LibraryVersions

apply {
    from("publish-remote.gradle")
}

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    ios()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "filledslider"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose Support
                val composeBom = platform("androidx.compose:compose-bom:${LibraryVersions.composeBom}")
                implementation(composeBom)
                implementation("androidx.compose.material3:material3")
                implementation("androidx.compose.ui:ui")
            }
        }
        val commonTest by getting {
            dependencies {
                // Test
                implementation("junit:junit:${LibraryVersions.junit}")

                // Compose Android Studio Preview support
                implementation("androidx.compose.ui:ui-tooling")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:${LibraryVersions.androidCore}")
                implementation("androidx.appcompat:appcompat:${LibraryVersions.appCompat}")

                // Compose Android Studio Preview support
                implementation("androidx.compose.ui:ui-tooling-preview")
            }
        }
        val androidUnitTest by getting {
            dependencies {
                // Compose Support
                val composeBom = platform("androidx.compose:compose-bom:${LibraryVersions.composeBom}")
                implementation(composeBom)

                // Test
                implementation("androidx.test.ext:junit:${LibraryVersions.androidJUnit}")
                implementation("androidx.test.espresso:espresso-core:${LibraryVersions.espresso}")
            }
        }
        val desktopMain by getting {
            dependencies {
                // Compose Android Studio Preview support
                implementation("androidx.compose.ui:ui-tooling")
            }
        }
        val desktopTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependencies {
            }
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "io.github.seyoungcho2.slider"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersions.composeComplier
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}