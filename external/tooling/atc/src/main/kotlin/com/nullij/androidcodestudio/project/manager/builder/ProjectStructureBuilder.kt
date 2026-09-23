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
 * Class ProjectStructBuilder.
 *
 * @author nullij @ https://github.com/nullij
 */
class ProjectStructBuilder {

  /**
   * Creates a new instance of project structure
   *
   * @param moduleName the module name text
   * @param projectType the project type as a [ProjectType]
   * @param packageId the package id text
   * @param baseDir the base dir as a [File]
   * @param hasLayout whether has layout is enabled
   * @return the build result
   */
  fun buildProjectStructure(
      moduleName: String,
      projectType: ProjectType,
      packageId: String,
      baseDir: File,
      hasLayout: Boolean = true,
  ): BuildResult {
    return try {
      if (moduleName.isBlank()) {
        return BuildResult(false, "Module name cannot be blank")
      }

      if (packageId.isBlank()) {
        return BuildResult(false, "Package ID cannot be blank")
      }

      if (!baseDir.exists() && !baseDir.mkdirs()) {
        return BuildResult(
            false,
            "Failed to create base directory: ${baseDir.absolutePath}",
        )
      }

      val moduleDir = File(baseDir, moduleName)
      if (!createDirectory(moduleDir)) {
        return BuildResult(
            false,
            "Failed to create module directory: ${moduleDir.absolutePath}",
        )
      }

      val srcMainDir = File(moduleDir, "src/main")
      if (!createDirectory(srcMainDir)) {
        return BuildResult(false, "Failed to create src/main directory")
      }

      val languageDirName =
          when (projectType) {
            ProjectType.JAVA -> "java"
            ProjectType.KOTLIN -> "kotlin"
          }
      val languageDir = File(srcMainDir, languageDirName)
      if (!createDirectory(languageDir)) {
        return BuildResult(false, "Failed to create $languageDirName directory")
      }

      val packageDirs = convertPackageToDirs(packageId)
      val packageDir = File(languageDir, packageDirs)
      if (!createDirectory(packageDir)) {
        return BuildResult(false, "Failed to create package directory: $packageDirs")
      }

      val resDir = File(srcMainDir, "res")
      if (!createDirectory(resDir)) {
        return BuildResult(false, "Failed to create res directory")
      }

      val resourceDirs = getResourceDirectories(hasLayout)
      resourceDirs.forEach { resourceDir ->
        val dir = File(resDir, resourceDir)
        if (!createDirectory(dir)) {
          return BuildResult(false, "Failed to create resource directory: $resourceDir")
        }
      }

      if (moduleName == "app") {
        val gradleDir = File(baseDir, "gradle")
        if (!createDirectory(gradleDir)) {
          return BuildResult(false, "Failed to create gradle directory")
        }

        val wrapperDir = File(gradleDir, "wrapper")
        if (!createDirectory(wrapperDir)) {
          return BuildResult(false, "Failed to create gradle/wrapper directory")
        }
      }

      BuildResult(true, "Project structure created successfully for module: $moduleName")
    } catch (e: Exception) {
      BuildResult(false, "Error creating project structure: ${e.message}")
    }
  }

  /**
   * Converts the package to dirs
   *
   * @param packageId the package id text
   * @return the string
   */
  fun convertPackageToDirs(packageId: String): String {
    return packageId.replace('.', '/')
  }

  /**
   * Creates a new instance of directory
   *
   * @param directory the directory as a [File]
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  private fun createDirectory(directory: File): Boolean {
    return try {
      if (!directory.exists()) {
        directory.mkdirs()
      } else {
        true
      }
    } catch (e: Exception) {
      false
    }
  }

  /**
   * Retrieves the resource directorieses
   *
   * @param hasLayout whether has layout is enabled
   * @return a collection of strings
   */
  private fun getResourceDirectories(hasLayout: Boolean): List<String> {
    val directories =
        mutableListOf(
            "drawable",
            "drawable-v24",
            "mipmap-anydpi-v26",
            "mipmap-hdpi",
            "mipmap-mdpi",
            "mipmap-xhdpi",
            "mipmap-xxhdpi",
            "mipmap-xxxhdpi",
            "values",
            "values-night",
            "xml",
        )

    if (hasLayout) {
      directories.add("layout")
    }

    return directories
  }

  /**
   * Retrieves the main source path
   *
   * @param moduleName the module name text
   * @param projectType the project type as a [ProjectType]
   * @param packageId the package id text
   * @return the string
   */
  fun getMainSourcePath(moduleName: String, projectType: ProjectType, packageId: String): String {
    val languageDir =
        when (projectType) {
          ProjectType.JAVA -> "java"
          ProjectType.KOTLIN -> "kotlin"
        }
    val packagePath = convertPackageToDirs(packageId)
    return "$moduleName/src/main/$languageDir/$packagePath"
  }

  /**
   * Retrieves the res path
   *
   * @param moduleName the module name text
   * @return the string
   */
  fun getResPath(moduleName: String): String {
    return "$moduleName/src/main/res"
  }
}

/** Data class BuildResult. */
data class BuildResult(val success: Boolean, val message: String)

/** Enum class ProjectType. */
enum class ProjectType {

  /** Class JAVA. */
  JAVA,

  /** Class KOTLIN. */
  KOTLIN,
}
