package version

object Dependency {


    object Core {
        const val androidKtx = "androidx.core:core-ktx:1.8.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1"
        const val coroutine_android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.5.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Lifecycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Dep.lifecycle}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Dep.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Dep.lifecycle}"
    }

    object Intuit {
        const val intuit = "com.intuit.sdp:sdp-android:${Version.Dep.intuit}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Version.Dep.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.Dep.hilt}"
        const val hiltWork = "androidx.hilt:hilt-work:1.0.0-alpha02"
    }

    object Navigation {
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.Dep.navigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.Dep.navigation}"
    }


    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Version.Dep.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.Dep.glide}"

    }


    object Log {
        const val timber = "com.jakewharton.timber:timber:${Version.Dep.timber}"
    }



    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:${Version.Dep.okHttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Version.Dep.okHttp}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Version.Dep.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.Dep.retrofit}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.Dep.room}"
        const val compiler = "androidx.room:room-compiler:${Version.Dep.room}"
        const val ktx = "androidx.room:room-ktx:${Version.Dep.room}"
        const val testing = "androidx.room:room-testing:${Version.Dep.room}"
    }


    object Test {
        const val junit = "junit:junit:4.13.2"
        const val extJunit = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"

    }


}