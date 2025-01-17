

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)


        id ("kotlin-kapt")// Add this line
        id ("dagger.hilt.android.plugin") // Hilt plugin

}

android {
    namespace = "com.example.navigationapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.navigationapplication"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
}

dependencies {

        implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0") // or latest version
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")// optional for LiveData

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.kts)
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)
    implementation (libs.retrofit)
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation (libs.androidx.recyclerview)

}