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

package com.nullij.androidcodestudio.project.manager.builder

import java.io.File

/**
 * Enum class LanguageType.
 *
 * @author nullij @ https://github.com/nullij
 */
enum class LanguageType(val extension: String, val dirName: String) {

  /** Class JAVA. */
  JAVA("java", "java"),

  /** Class KOTLIN. */
  KOTLIN("kt", "kotlin"),
}

/** Data class ActivityConfig. */
data class ActivityConfig(
    val moduleName: String,
    val languageType: LanguageType,
    val packageId: String,
    val activityName: String,
    val content: String,
)

/** Class MainActivityBuilder. */
interface MainActivityBuilder {

  /**
   * Creates a new instance of
   *
   * @param content the content text
   * @return the string
   */
  fun generate(content: String): String

  /**
   * Sets the to file
   *
   * @param projectRoot the project root as a [File]
   * @param config the [ActivityConfig] instance
   * @return the file
   */
  fun writeToFile(projectRoot: File, config: ActivityConfig): File

  /**
   * Creates a new instance of file
   *
   * @param directory the directory as a [File]
   * @param fileName the file name text
   * @param extension the extension text
   * @param content the content text
   * @return the file
   */
  fun createFile(directory: File, fileName: String, extension: String, content: String): File
}

/** Class ActivityWriter. */
class ActivityWriter : MainActivityBuilder {

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
   * Sets the to file
   *
   * @param projectRoot the project root as a [File]
   * @param config the [ActivityConfig] instance
   * @return the file
   */
  override fun writeToFile(projectRoot: File, config: ActivityConfig): File {
    val sourcePath =
        buildSourcePath(
            moduleName = config.moduleName,
            languageType = config.languageType,
            packageId = config.packageId,
        )

    val targetDir = File(projectRoot, sourcePath)
    if (!targetDir.exists()) {
      targetDir.mkdirs()
    }

    val generatedContent = generate(config.content)

    val fileName = "${config.activityName}.${config.languageType.extension}"
    val file = File(targetDir, fileName)
    file.writeText(generatedContent)

    return file
  }

  /**
   * Creates a new instance of file
   *
   * @param directory the directory as a [File]
   * @param fileName the file name text
   * @param extension the extension text
   * @param content the content text
   * @return the file
   */
  override fun createFile(
      directory: File,
      fileName: String,
      extension: String,
      content: String,
  ): File {
    if (!directory.exists()) {
      directory.mkdirs()
    }

    val generatedContent = generate(content)

    val fullFileName =
        if (extension.isNotEmpty()) {
          "$fileName.$extension"
        } else {
          fileName
        }

    val file = File(directory, fullFileName)
    file.writeText(generatedContent)

    return file
  }

  /**
   * Creates a new instance of source path
   *
   * @param moduleName the module name text
   * @param languageType the language type as a [LanguageType]
   * @param packageId the package id text
   * @return the string
   */
  private fun buildSourcePath(
      moduleName: String,
      languageType: LanguageType,
      packageId: String,
  ): String {
    val packagePath = packageIdToPath(packageId)
    return "$moduleName/src/main/${languageType.dirName}/$packagePath"
  }

  /**
   * Performs the to path operation
   *
   * @param packageId the package id text
   * @return the string
   */
  private fun packageIdToPath(packageId: String): String {
    return packageId.replace('.', File.separatorChar)
  }
}

/** Class ActivityConfigBuilder. */
class ActivityConfigBuilder {

  /**
   * Performs the name operation.
   *
   * @return the string
   */
  private var moduleName: String = ""

  /**
   * Represents the language type.
   *
   * @return the language type
   */
  private var languageType: LanguageType = LanguageType.KOTLIN

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var packageId: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var activityName: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var content: String = ""

  /**
   * Performs the name operation
   *
   * @param moduleName the module name text
   */
  fun moduleName(moduleName: String) = apply { this.moduleName = moduleName }

  /**
   * Represents the language type
   *
   * @param languageType the language type as a [LanguageType]
   */
  fun languageType(languageType: LanguageType) = apply { this.languageType = languageType }

  /**
   * Performs the operation
   *
   * @param packageId the package id text
   */
  fun packageId(packageId: String) = apply { this.packageId = packageId }

  /**
   * Performs the operation
   *
   * @param activityName the activity name text
   */
  fun activityName(activityName: String) = apply { this.activityName = activityName }

  /**
   * Performs the operation
   *
   * @param content the content text
   */
  fun content(content: String) = apply { this.content = content }

  /**
   * Creates a new instance of
   *
   * @return the activity config
   */
  fun build(): ActivityConfig {
    require(moduleName.isNotBlank()) { "Module name cannot be blank" }
    require(packageId.isNotBlank()) { "Package ID cannot be blank" }
    require(activityName.isNotBlank()) { "Activity name cannot be blank" }
    require(content.isNotBlank()) { "Activity content cannot be blank" }
    return ActivityConfig(moduleName, languageType, packageId, activityName, content)
  }
}

/**
 * Performs the operation
 *
 * @param block the block
 * @return the activity config
 */
fun activityConfig(block: ActivityConfigBuilder.() -> Unit): ActivityConfig {
  return ActivityConfigBuilder().apply(block).build()
}

/** Object PackageHelper. */
object PackageHelper {

  /**
   * Performs the to path operation
   *
   * @param packageId the package id text
   * @return the string
   */
  fun packageIdToPath(packageId: String): String {
    return packageId.replace('.', File.separatorChar)
  }

  /**
   * Performs the operation
   *
   * @param path the path text
   * @return the string
   */
  fun pathToPackageId(path: String): String {
    return path.replace(File.separatorChar, '.')
  }

  /**
   * Indicates whether valid package id
   *
   * @param packageId the package id text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun isValidPackageId(packageId: String): Boolean {
    if (packageId.isBlank()) return false

    val parts = packageId.split('.')
    if (parts.size < 2) return false

    return parts.all { part ->
      part.isNotEmpty() && part[0].isJavaIdentifierStart() && part.all { it.isJavaIdentifierPart() }
    }
  }

  /**
   * Creates a new instance of source path
   *
   * @param moduleName the module name text
   * @param languageType the language type as a [LanguageType]
   * @param packageId the package id text
   * @return the string
   */
  fun buildSourcePath(moduleName: String, languageType: LanguageType, packageId: String): String {
    val packagePath = packageIdToPath(packageId)
    return "$moduleName/src/main/${languageType.dirName}/$packagePath"
  }
}
