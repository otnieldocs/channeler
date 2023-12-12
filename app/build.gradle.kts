plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply(from = "${rootDir}/versions.gradle.kts")

android {
    namespace = "com.otnieldocs.channelerapp"
    compileSdk = project.extra["compileSdk"].toString().toInt()

    defaultConfig {
        applicationId = "com.otnieldocs.channelerapp"
        minSdk = project.extra["minSdk"].toString().toInt()
        targetSdk = project.extra["targetSdk"].toString().toInt()
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = project.extra["composeCompiler"].toString()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${project.extra["androidxCoreVersion"].toString()}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${project.extra["androidxLifecycleRuntimeVersion"].toString()}")
    implementation("androidx.activity:activity-compose:${project.extra["androidxActivityComposeVersion"]}")
    implementation(platform("androidx.compose:compose-bom:${project.extra["androidxComposeBomVersion"].toString()}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:${project.extra["junitVersion"].toString()}")
    androidTestImplementation("androidx.test.ext:junit:${project.extra["testExtJunitVersion"].toString()}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.extra["testEspressoCoreVersion"]}")
    androidTestImplementation(platform("androidx.compose:compose-bom:${project.extra["androidxComposeBomVersion"]}"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}