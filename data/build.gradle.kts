plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
//    id("com.google.devtools.ksp")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.androidTestInstrumentation
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Room.roomRuntime)
    implementation(Libs.AndroidX.Room.roomKtx)
    kapt(Libs.AndroidX.Room.roomCompiler)
//    ksp(Libs.AndroidX.Room.roomCompiler)

    testImplementation(Libs.JUnit.junit)

    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junitKtx)
}