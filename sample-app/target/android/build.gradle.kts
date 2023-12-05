import version.LibraryVersions

plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "io.github.seyoungcho2.composeslider"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.github.seyoungcho2.composeslider"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersions.composeComplier
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":filled-slider-compose"))
    implementation("androidx.core:core-ktx:${LibraryVersions.androidCore}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersions.lifecycleRuntime}")
    implementation("androidx.activity:activity-compose:${LibraryVersions.activityCompose}")

    // Compose
    implementation(compose.runtime)
    implementation(compose.ui)
    implementation(compose.foundation)
    implementation(compose.material3)
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Test
    testImplementation("junit:junit:${LibraryVersions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${LibraryVersions.androidJUnit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${LibraryVersions.espresso}")
}