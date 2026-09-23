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
 *   along with ACSIDE.  If not, see <https://www.gnu.org/licenses/\>.
 */

/*
 * Android Template Creator - Free and open-source project
 * Android Template Creator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for complete details.
 *
 * A copy of the LGPL license can be found at <https://www.gnu.org/licenses/lgpl-3.0.html>.
 */

import com.nullij.androidcodestudio.config.BuildConfig

/*
 ** @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

plugins {
    alias(libs.plugins.androidLibrary)
    id("acs.buildconfig")
}

android {
    namespace = "${BuildConfig.packageName}.atc"
    compileSdk = 36

    defaultConfig { minSdk = 21 }

    buildFeatures { buildConfig = false }

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
    // AndroidX
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    implementation(libs.datastore)
    implementation(libs.kotlinx.coroutines.android)
}
