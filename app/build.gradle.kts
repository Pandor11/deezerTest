plugins {
    id("com.android.application")
    kotlin("plugin.serialization") version "1.7.10"
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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




//    javaCompileOptions {
//        annotationProcessorOptions {
//            arguments += [
//                "room.schemaLocation":"$projectDir/schemas".toString(),
//                "room.incremental":"true",
//                "room.expandProjection":"true"
//            ]
//        }
//    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)

    implementation(Dependencies.Lifecycle.lifeCycleExt)


    // Dagger
    implementation(Dependencies.Dagger.dagger)
    implementation(Dependencies.Dagger.annotationProcessor)

    // Room
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.compiler)

    //Glide
    implementation(Dependencies.Glide.glide)

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.gson)

    //Okhttp
    implementation(Dependencies.Okhttp.okhttp)


    //Coroutines
    implementation(Dependencies.Coroutines.coroutines)

    //Navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)

}