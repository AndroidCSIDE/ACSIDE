import com.nullij.androidcodestudio.config.BuildConfig

plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.compose.compiler)
  id("acs.buildconfig")
}

android {
  namespace = "${BuildConfig.packageName}.resources"
  compileSdk = BuildConfig.compileSdk

  defaultConfig {
    minSdk = BuildConfig.minSdk
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  
  compileOptions {
    sourceCompatibility = BuildConfig.javaVersion
    targetCompatibility = BuildConfig.javaVersion
  }
  
  kotlin {
      compilerOptions {
          jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.fromTarget("17"))
      }
  }
  
}

dependencies {
  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.material)
}