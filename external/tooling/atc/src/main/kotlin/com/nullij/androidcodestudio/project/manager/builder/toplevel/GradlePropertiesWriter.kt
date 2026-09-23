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
 * Data class GradleProperty.
 *
 * @author nullij @ https://github.com/nullij
 */
data class GradleProperty(val key: String, val value: String, val comment: String? = null)

/** Class TLGradleProperties. */
interface TLGradleProperties {

  /**
   * Creates a new instance of
   *
   * @param content the content text
   * @return the string
   */
  fun generate(content: String): String

  /**
   * Creates a new instance of
   *
   * @param properties the collection of properties
   * @param headerComment the header comment text, or `null` if omitted
   * @return the string
   */
  fun generate(properties: List<GradleProperty>, headerComment: String? = null): String

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param content the content text
   * @return the file
   */
  fun writeToFile(outputDir: File, content: String): File

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param properties the collection of properties
   * @param headerComment the header comment text, or `null` if omitted
   * @return the file
   */
  fun writeToFile(
      outputDir: File,
      properties: List<GradleProperty>,
      headerComment: String? = null,
  ): File
}

/** Class GradlePropertiesWriter. */
class GradlePropertiesWriter : TLGradleProperties {

  /** Companion object Companion. */
  companion object {

    /** Performs the name operation. */
    const val FILE_NAME = "gradle.properties"
  }

  /**
   * Creates a new instance of
   *
   * @param content the content text
   * @return the string
   */
  override fun generate(content: String): String {
    return content.trimIndent()
  }

  /**
   * Creates a new instance of
   *
   * @param properties the collection of properties
   * @param headerComment the header comment text, or `null` if omitted
   * @return the string
   */
  override fun generate(properties: List<GradleProperty>, headerComment: String?): String {
    val builder = StringBuilder()

    if (headerComment != null) {
      builder.appendLine("# $headerComment")
      builder.appendLine()
    }

    properties.forEach { property ->
      if (property.comment != null) {
        builder.appendLine("# ${property.comment}")
      }
      builder.appendLine("${property.key}=${property.value}")

      if (property.comment != null) {
        builder.appendLine()
      }
    }

    return builder.toString()
  }

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param content the content text
   * @return the file
   */
  override fun writeToFile(outputDir: File, content: String): File {
    if (!outputDir.exists()) {
      outputDir.mkdirs()
    }

    val generatedContent = generate(content)
    val file = File(outputDir, FILE_NAME)
    file.writeText(generatedContent)

    return file
  }

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param properties the collection of properties
   * @param headerComment the header comment text, or `null` if omitted
   * @return the file
   */
  override fun writeToFile(
      outputDir: File,
      properties: List<GradleProperty>,
      headerComment: String?,
  ): File {
    if (!outputDir.exists()) {
      outputDir.mkdirs()
    }

    val content = generate(properties, headerComment)
    val file = File(outputDir, FILE_NAME)
    file.writeText(content)

    return file
  }
}

/** Class GradlePropertyBuilder. */
class GradlePropertyBuilder {

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var key: String = ""

  /**
   * Represents the value.
   *
   * @return the string
   */
  private var value: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var comment: String? = null

  /**
   * Performs the operation
   *
   * @param key the key text
   */
  fun key(key: String) = apply { this.key = key }

  /**
   * Represents the value
   *
   * @param value the value text
   */
  fun value(value: String) = apply { this.value = value }

  /**
   * Performs the operation
   *
   * @param comment the comment text, or `null` if omitted
   */
  fun comment(comment: String?) = apply { this.comment = comment }

  /**
   * Creates a new instance of
   *
   * @return the gradle property
   */
  fun build(): GradleProperty {
    require(key.isNotBlank()) { "Property key cannot be blank" }
    require(value.isNotBlank()) { "Property value cannot be blank" }
    return GradleProperty(key, value, comment)
  }
}

/**
 * Performs the property operation
 *
 * @param block the block
 * @return the gradle property
 */
fun gradleProperty(block: GradlePropertyBuilder.() -> Unit): GradleProperty {
  return GradlePropertyBuilder().apply(block).build()
}

/** Object GradlePropertiesPresets. */
object GradlePropertiesPresets {

  /** Performs the android operation. */
  val STANDARD_ANDROID =
      """
      # Project-wide Gradle settings.
      # IDE (e.g. Android Studio) users:
      # Gradle settings configured through the IDE *will override*
      # any settings specified in this file.

      # For more details on how to configure your build environment visit
      # http://www.gradle.org/docs/current/userguide/build_environment.html

      # Specifies the JVM arguments used for the daemon process.
      # The setting is particularly useful for tweaking memory settings.
      org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8

      # When configured, Gradle will run in incubating parallel mode.
      # This option should only be used with decoupled projects. More details, visit
      # http://www.gradle.org/docs/current/userguide/multi_project_builds.html#sec:decoupled_projects
      # org.gradle.parallel=true

      # AndroidX package structure to make it clearer which packages are bundled with the
      # Android operating system, and which are packaged with your app's APK
      # https://developer.android.com/topic/libraries/support-library/androidx-rn
      android.useAndroidX=true

      # Kotlin code style for this project: "official" or "obsolete":
      kotlin.code.style=official

      # Enables namespacing of each library's R class so that its R class includes only the
      # resources declared in the library itself and none from the library's dependencies,
      # thereby reducing the size of the R class for that library
      android.nonTransitiveRClass=true
      """
          .trimIndent()

  /** Performs the operation. */
  val MINIMAL_ANDROID =
      """
      org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
      android.useAndroidX=true
      android.nonTransitiveRClass=true
      """
          .trimIndent()

  /** Performs the r class operation. */
  val NON_TRANSITIVE_R_CLASS =
      """
      android.nonTransitiveRClass=true
      android.useAndroidX=true
      """
          .trimIndent()
}
