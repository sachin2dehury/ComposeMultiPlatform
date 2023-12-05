import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
//    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        commonMain.dependencies {

//            implementation("androidx.navigation:navigation-compose:2.7.5")
//            implementation("androidx.paging:paging-compose:3.2.1")

//            implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

//            implementation("com.google.dagger:hilt-android:2.48.1")
//            ksp("com.google.dagger:hilt-compiler:2.48.1")

            implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
            implementation("com.squareup.retrofit2:retrofit:2.9.0")


            implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

            implementation("com.squareup.okhttp3:okhttp:4.12.0")

//            implementation("io.coil-kt:coil-compose:2.5.0")

//            implementation("androidx.palette:palette-ktx:1.0.0")
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
//            implementation("org.jetbrains.kotlin:kotlin-stdlib-jre8:1.9.21")
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
        }
    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
