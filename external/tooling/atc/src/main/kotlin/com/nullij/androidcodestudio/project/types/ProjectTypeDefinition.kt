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

package com.nullij.androidcodestudio.project.types

/**
 * Enum class ProjectType.
 *
 * @author nullij @ https://github.com/nullij
 */
enum class ProjectType(
    val displayName: String,
    val description: String,
    val language: ProjectLanguage,
    val requiresAndroidConfig: Boolean = true,
    val defaultMinSdk: Int = 21,
    val defaultTargetSdk: Int = 34,
    val plugins: List<String> = emptyList(),
    val features: List<String> = emptyList(),
) {

  /** Class ACTIVITY. */
  ACTIVITY(
      displayName = "Basic Activity",
      description = "Standard Android project with a single main activity",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Single Activity", "Basic UI", "Material Design"),
  ),

  /** Class JAVA_LIBRARY. */
  JAVA_LIBRARY(
      displayName = "Java Library",
      description = "Reusable Java library component",
      language = ProjectLanguage.JAVA,
      requiresAndroidConfig = false,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("java-library"),
      features = listOf("Java Library", "Reusable Components"),
  ),

  /** Class KOTLIN_LIBRARY. */
  KOTLIN_LIBRARY(
      displayName = "Kotlin Library",
      description = "Reusable Kotlin library component",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = false,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("kotlin"),
      features = listOf("Kotlin Library", "Reusable Components"),
  ),

  /** Class JITPACK_LIBRARY. */
  JITPACK_LIBRARY(
      displayName = "JitPack Library",
      description = "Library configured for JitPack distribution",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = false,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("kotlin"),
      features = listOf("JitPack Ready", "Library Distribution", "Maven Publishing"),
  ),

  /** Class COMPOSE. */
  COMPOSE(
      displayName = "Jetpack Compose",
      description = "Modern Android UI with Jetpack Compose",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Jetpack Compose", "Modern UI", "Declarative Programming"),
  ),

  /** Class GAME_ACTIVITY. */
  GAME_ACTIVITY(
      displayName = "Game Activity",
      description = "Android project optimized for game development",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Game Development", "GameActivity", "Performance Optimized"),
  ),

  /** Class EMPTY_PROJECT. */
  EMPTY_PROJECT(
      displayName = "Empty Project",
      description = "Minimal Android project with basic setup",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Minimal Setup", "Clean Slate"),
  ),

  /** Class MULTI_MODULE. */
  MULTI_MODULE(
      displayName = "Multi-Module Project",
      description = "Project with multiple modules for better architecture",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 21,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Multi-module", "Clean Architecture", "Feature Modules"),
  ),

  /** Class WEAR_OS. */
  WEAR_OS(
      displayName = "Wear OS",
      description = "Project for Android wearable devices",
      language = ProjectLanguage.KOTLIN,
      requiresAndroidConfig = true,
      defaultMinSdk = 26,
      defaultTargetSdk = 34,
      plugins = listOf("com.android.application", "org.jetbrains.kotlin.android"),
      features = listOf("Wear OS", "Wearable Devices", "Round Screen Support"),
  );

  /**
   * Indicates whether library
   *
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun isLibrary(): Boolean {
    return !requiresAndroidConfig
  }

  /**
   * Retrieves the package suffix
   *
   * @return the string
   */
  fun getPackageSuffix(): String {
    return when (this) {
      JAVA_LIBRARY,
      KOTLIN_LIBRARY -> "library"
      JITPACK_LIBRARY -> "lib"
      COMPOSE -> "compose"
      GAME_ACTIVITY -> "game"
      WEAR_OS -> "wear"
      MULTI_MODULE -> "app"
      else -> "app"
    }
  }

  /** Companion object Companion. */
  companion object {

    /**
     * Retrieves the types by languages
     *
     * @param language the [ProjectLanguage] instance
     * @return a collection of project types
     */
    fun getTypesByLanguage(language: ProjectLanguage): List<ProjectType> {
      return values().filter { it.language == language }
    }

    /**
     * Formats and displays the name
     *
     * @param displayName the display name text
     * @return the project type
     */
    fun fromDisplayName(displayName: String): ProjectType? {
      return values().find { it.displayName == displayName }
    }

    /**
     * Retrieves the library typeses
     *
     * @return a collection of project types
     */
    fun getLibraryTypes(): List<ProjectType> {
      return values().filter { it.isLibrary() }
    }

    /**
     * Retrieves the application typeses
     *
     * @return a collection of project types
     */
    fun getApplicationTypes(): List<ProjectType> {
      return values().filter { !it.isLibrary() }
    }
  }
}

/** Enum class ProjectLanguage. */
enum class ProjectLanguage {

  /** Class KOTLIN. */
  KOTLIN,

  /** Class JAVA. */
  JAVA,
}
