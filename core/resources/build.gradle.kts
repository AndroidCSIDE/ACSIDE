/*
 *  This file is part of ACSIDE.
 *
 *  ACSIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ACSIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with ACSIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.nullij.androidcodestudio.config.BuildConfig

plugins {
    id("com.android.library")
    alias(libs.plugins.acsideBuildConfig)
}

android {
    namespace = "${BuildConfig.packageName}.resources"
    compileSdk = BuildConfig.compileSdk

    defaultConfig {
        minSdk = BuildConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = BuildConfig.javaVersion
        targetCompatibility = BuildConfig.javaVersion
    }

    kotlin { compilerOptions { jvmTarget.set(BuildConfig.kotlinVersion) } }
}

dependencies { implementation(libs.google.material) }
