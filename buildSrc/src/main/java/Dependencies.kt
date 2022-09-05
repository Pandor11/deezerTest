object Dependencies {


    object Kotlin {


    }

    object Dagger {
        const val version = "2.43.2"
        const val dagger = "com.google.dagger:dagger-android:$version"
        const val annotationProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Room {
        private const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Navigation {
        private const val version = "2.5.1"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.1"
        const val recycler = "androidx.recyclerview:recyclerview:1.1.0"
    }

    object Lifecycle {
        const val lifeCycleExt = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gson = "com.squareup.retrofit2:converter-gson:$version"

    }

    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.13.2"
    }

    object Coroutines {
        private const val version = "1.6.4"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }


    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}