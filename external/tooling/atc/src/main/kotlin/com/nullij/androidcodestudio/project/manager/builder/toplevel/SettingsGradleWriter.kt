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

package com.nullij.androidcodestudio.project.manager.builder.toplevel

import java.io.File

/**
 * Enum class SettingsGradleFileType.
 *
 * @author nullij @ https://github.com/nullij
 */
enum class SettingsGradleFileType(val extension: String, val fileName: String) {

  /** Class GROOVY. */
  GROOVY("gradle", "settings.gradle"),

  /** Class KTS. */
  KTS("gradle.kts", "settings.gradle.kts"),
}

/** Data class SettingsGradleConfig. */
data class SettingsGradleConfig(
    val pluginManagementBody: String? = null,
    val dependencyResolutionBody: String? = null,
    val rootProjectName: String,
    val includes: List<String> = emptyList(),
)

/** Class TLSettingsGradle. */
interface TLSettingsGradle {

  /**
   * Creates a new instance of
   *
   * @param fileType the file type as a [SettingsGradleFileType]
   * @param config the [SettingsGradleConfig] instance
   * @return the string
   */
  fun generate(fileType: SettingsGradleFileType, config: SettingsGradleConfig): String

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param fileType the file type as a [SettingsGradleFileType]
   * @param config the [SettingsGradleConfig] instance
   * @return the file
   */
  fun writeToFile(
      outputDir: File,
      fileType: SettingsGradleFileType,
      config: SettingsGradleConfig,
  ): File
}

/** Class SettingsGradleWriter. */
class SettingsGradleWriter : TLSettingsGradle {

  /**
   * Creates a new instance of
   *
   * @param fileType the file type as a [SettingsGradleFileType]
   * @param config the [SettingsGradleConfig] instance
   * @return the string
   */
  override fun generate(fileType: SettingsGradleFileType, config: SettingsGradleConfig): String {
    return when (fileType) {
      SettingsGradleFileType.GROOVY -> generateGroovy(config)
      SettingsGradleFileType.KTS -> generateKts(config)
    }
  }

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param fileType the file type as a [SettingsGradleFileType]
   * @param config the [SettingsGradleConfig] instance
   * @return the file
   */
  override fun writeToFile(
      outputDir: File,
      fileType: SettingsGradleFileType,
      config: SettingsGradleConfig,
  ): File {
    if (!outputDir.exists()) {
      outputDir.mkdirs()
    }

    val content = generate(fileType, config)
    val file = File(outputDir, fileType.fileName)
    file.writeText(content)

    return file
  }

  /**
   * Creates a new instance of groovy
   *
   * @param config the [SettingsGradleConfig] instance
   * @return the string
   */
  private fun generateGroovy(config: SettingsGradleConfig): String {
    val builder = StringBuilder()

    if (config.pluginManagementBody != null) {
      builder.appendLine("pluginManagement {")
      builder.appendLine(config.pluginManagementBody.trimIndent().prependIndent("    "))
      builder.appendLine("}")
      builder.appendLine()
    }

    if (config.dependencyResolutionBody != null) {
      builder.appendLine("dependencyResolutionManagement {")
      builder.appendLine(config.dependencyResolutionBody.trimIndent().prependIndent("    "))
      builder.appendLine("}")
      builder.appendLine()
    }

    builder.appendLine("rootProject.name = \"${config.rootProjectName}\"")

    if (config.includes.isNotEmpty()) {
      builder.appendLine()
      config.includes.forEach { module -> builder.appendLine("include(\"$module\")") }
    }

    return builder.toString()
  }

  /**
   * Creates a new instance of kts
   *
   * @param config the [SettingsGradleConfig] instance
   * @return the string
   */
  private fun generateKts(config: SettingsGradleConfig): String {
    val builder = StringBuilder()

    if (config.pluginManagementBody != null) {
      builder.appendLine("pluginManagement {")
      builder.appendLine(config.pluginManagementBody.trimIndent().prependIndent("    "))
      builder.appendLine("}")
      builder.appendLine()
    }

    if (config.dependencyResolutionBody != null) {
      builder.appendLine("dependencyResolutionManagement {")
      builder.appendLine(config.dependencyResolutionBody.trimIndent().prependIndent("    "))
      builder.appendLine("}")
      builder.appendLine()
    }

    builder.appendLine("rootProject.name = \"${config.rootProjectName}\"")

    if (config.includes.isNotEmpty()) {
      builder.appendLine()
      config.includes.forEach { module -> builder.appendLine("include(\"$module\")") }
    }

    return builder.toString()
  }
}

/** Class SettingsGradleConfigBuilder. */
class SettingsGradleConfigBuilder {

  /**
   * Performs the management body operation.
   *
   * @return the string
   */
  private var pluginManagementBody: String? = null

  /**
   * Performs the resolution body operation.
   *
   * @return the string
   */
  private var dependencyResolutionBody: String? = null

  /**
   * Performs the project name operation.
   *
   * @return the string
   */
  private var rootProjectName: String = ""

  /**
   * Determines if.
   *
   * @return the mutable list
   */
  private val includes: MutableList<String> = mutableListOf()

  /**
   * Performs the management operation
   *
   * @param body the body text
   */
  fun pluginManagement(body: String) = apply { this.pluginManagementBody = body }

  /**
   * Performs the resolution operation
   *
   * @param body the body text
   */
  fun dependencyResolution(body: String) = apply { this.dependencyResolutionBody = body }

  /**
   * Performs the project name operation
   *
   * @param name the name text
   */
  fun rootProjectName(name: String) = apply { this.rootProjectName = name }

  /**
   * Performs the operation
   *
   * @param modules the modules text
   */
  fun include(vararg modules: String) = apply { this.includes.addAll(modules) }

  /**
   * Performs the operation
   *
   * @param modules the collection of modules
   */
  fun include(modules: List<String>) = apply { this.includes.addAll(modules) }

  /**
   * Creates a new instance of
   *
   * @return the settings gradle config
   */
  fun build(): SettingsGradleConfig {
    require(rootProjectName.isNotBlank()) { "Root project name cannot be blank" }
    return SettingsGradleConfig(
        pluginManagementBody = pluginManagementBody,
        dependencyResolutionBody = dependencyResolutionBody,
        rootProjectName = rootProjectName,
        includes = includes.toList(),
    )
  }
}

/**
 * Performs the config operation
 *
 * @param block the block
 * @return the settings gradle config
 */
fun settingsGradleConfig(block: SettingsGradleConfigBuilder.() -> Unit): SettingsGradleConfig {
  return SettingsGradleConfigBuilder().apply(block).build()
}

/** Object RepositoryPresets. */
object RepositoryPresets {

  /** Performs the groovy operation. */
  val STANDARD_GROOVY =
      """
      repositories {
          google()
          mavenCentral()
          gradlePluginPortal()
      }
      """
          .trimIndent()

  /** Performs the kts operation. */
  val STANDARD_KTS =
      """
      repositories {
          google()
          mavenCentral()
          gradlePluginPortal()
      }
      """
          .trimIndent()

  /** Performs the resolution groovy operation. */
  val DEPENDENCY_RESOLUTION_GROOVY =
      """
      repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
      repositories {
          google()
          mavenCentral()
      }
      """
          .trimIndent()

  /** Performs the resolution kts operation. */
  val DEPENDENCY_RESOLUTION_KTS =
      """
      repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
      repositories {
          google()
          mavenCentral()
      }
      """
          .trimIndent()
}
