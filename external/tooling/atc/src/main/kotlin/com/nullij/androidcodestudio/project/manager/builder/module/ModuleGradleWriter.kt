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

package com.nullij.androidcodestudio.project.manager.builder.module

import java.io.File

/**
 * Enum class JavaVersion.
 *
 * @author nullij @ https://github.com/nullij
 */
enum class JavaVersion(val versionNumber: String, val versionName: String) {

  /** Class VERSION_1_8. */
  VERSION_1_8("1.8", "VERSION_1_8"),

  /** Class VERSION_11. */
  VERSION_11("11", "VERSION_11"),

  /** Class VERSION_17. */
  VERSION_17("17", "VERSION_17"),

  /** Class VERSION_21. */
  VERSION_21("21", "VERSION_21");

  /**
   * Performs the operation
   *
   * @return the string
   */
  fun toJvmName(): String {
    return versionName.replace("VERSION_", "JVM_")
  }

  /** Companion object Companion. */
  companion object {

    /**
     * Retrieves the version number
     *
     * @param version the version text
     * @return the java version
     */
    fun fromVersionNumber(version: String): JavaVersion {
      return entries.find { it.versionNumber == version }
          ?: throw IllegalArgumentException("Unsupported Java version: $version")
    }
  }
}

/** Enum class BuildFeature. */
enum class BuildFeature(val featureName: String) {

  /** Class VIEW_BINDING. */
  VIEW_BINDING("viewBinding"),

  /** Class DATA_BINDING. */
  DATA_BINDING("dataBinding"),

  /** Class COMPOSE. */
  COMPOSE("compose"),

  /** Class BUILD_CONFIG. */
  BUILD_CONFIG("buildConfig"),

  /** Class PREFAB. */
  PREFAB("prefab"),

  /** Class AIDL. */
  AIDL("aidl"),

  /** Class RENDER_SCRIPT. */
  RENDER_SCRIPT("renderScript"),

  /** Class RES_VALUES. */
  RES_VALUES("resValues"),

  /** Class SHADERS. */
  SHADERS("shaders"),

  /** Class ML_MODEL_BINDING. */
  ML_MODEL_BINDING("mlModelBinding"),
}

/** Data class CMakeConfig. */
data class CMakeConfig(
    val path: String,
    val version: String? = null,
    val arguments: List<String> = emptyList(),
    val cFlags: String? = null,
    val cppFlags: String? = null,
    val abiFilters: List<String> = emptyList(),
    val targets: List<String> = emptyList(),
)

/** Data class NdkBuildConfig. */
data class NdkBuildConfig(val path: String, val abiFilters: List<String> = emptyList())

/** Data class ExternalNativeBuild. */
data class ExternalNativeBuild(
    val cmake: CMakeConfig? = null,
    val ndkBuild: NdkBuildConfig? = null,
) {
  init {
    require(cmake != null || ndkBuild != null) {
      "At least one of cmake or ndkBuild must be configured"
    }
    require(!(cmake != null && ndkBuild != null)) {
      "Cannot configure both cmake and ndkBuild simultaneously"
    }
  }
}

/** Data class NdkConfig. */
data class NdkConfig(val abiFilters: List<String> = emptyList())

/** Data class GradleDependency. */
data class GradleDependency(val dependency: String)

/** Data class DefaultConfig. */
data class DefaultConfig(
    val applicationId: String,
    val minSdk: Int,
    val targetSdk: Int,
    val versionCode: Int = 1,
    val versionName: String = "1.0",
    val testInstrumentationRunner: String? = null,
    val ndk: NdkConfig? = null,
)

/** Data class ModuleGradleConfig. */
data class ModuleGradleConfig(
    val plugins: List<GradlePlugin>,
    val namespace: String,
    val compileSdk: Int,
    val defaultConfig: DefaultConfig,
    val buildFeatures: List<BuildFeature> = emptyList(),
    val javaVersion: JavaVersion = JavaVersion.VERSION_17,
    val enableKotlinOptions: Boolean = true,
    val enableCompose: Boolean = false,
    val composeCompilerVersion: String? = null,
    val dependencies: List<GradleDependency> = emptyList(),
    val externalNativeBuild: ExternalNativeBuild? = null,
    val ndkVersion: String? = null,
)

/** Data class GradlePlugin. */
data class GradlePlugin(val type: String, val plugin: String)

/** Enum class GradleFileType. */
enum class GradleFileType(val extension: String, val fileName: String) {

  /** Class GROOVY. */
  GROOVY("gradle", "build.gradle"),

  /** Class KTS. */
  KTS("gradle.kts", "build.gradle.kts"),
}

/** Class IMLGradleWriter. */
interface IMLGradleWriter {

  /**
   * Creates a new instance of
   *
   * @param fileType the file type as a [GradleFileType]
   * @param config the [ModuleGradleConfig] instance
   * @return the string
   */
  fun generate(fileType: GradleFileType, config: ModuleGradleConfig): String

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param fileType the file type as a [GradleFileType]
   * @param config the [ModuleGradleConfig] instance
   * @return the file
   */
  fun writeToFile(outputDir: File, fileType: GradleFileType, config: ModuleGradleConfig): File
}

/** Class MLGradleWriter. */
class MLGradleWriter : IMLGradleWriter {

  /**
   * Creates a new instance of
   *
   * @param fileType the file type as a [GradleFileType]
   * @param config the [ModuleGradleConfig] instance
   * @return the string
   */
  override fun generate(fileType: GradleFileType, config: ModuleGradleConfig): String {
    return when (fileType) {
      GradleFileType.GROOVY -> generateGroovy(config)
      GradleFileType.KTS -> generateKts(config)
    }
  }

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param fileType the file type as a [GradleFileType]
   * @param config the [ModuleGradleConfig] instance
   * @return the file
   */
  override fun writeToFile(
      outputDir: File,
      fileType: GradleFileType,
      config: ModuleGradleConfig,
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
   * @param config the [ModuleGradleConfig] instance
   * @return the string
   */
  private fun generateGroovy(config: ModuleGradleConfig): String {
    val builder = StringBuilder()

    if (config.plugins.isNotEmpty()) {
      builder.appendLine("plugins {")
      builder.appendLine("    // Plugins automatically generated by MLGradleWriter.kt")
      config.plugins.forEach { plugin ->
        builder.appendLine("    ${buildPluginLine(plugin, false)}")
      }
      builder.appendLine("}")
      builder.appendLine()
    }

    builder.appendLine("android {")
    builder.appendLine("    namespace '${config.namespace}'")
    builder.appendLine("    compileSdk ${config.compileSdk}")

    config.ndkVersion?.let { builder.appendLine("    ndkVersion '$it'") }

    builder.appendLine()

    builder.appendLine("    defaultConfig {")
    builder.appendLine("        applicationId '${config.defaultConfig.applicationId}'")
    builder.appendLine("        minSdk ${config.defaultConfig.minSdk}")
    builder.appendLine("        targetSdk ${config.defaultConfig.targetSdk}")
    builder.appendLine("        versionCode ${config.defaultConfig.versionCode}")
    builder.appendLine("        versionName '${config.defaultConfig.versionName}'")

    config.defaultConfig.testInstrumentationRunner?.let {
      builder.appendLine()
      builder.appendLine("        testInstrumentationRunner '$it'")
    }

    config.defaultConfig.ndk?.let { ndkConfig ->
      if (ndkConfig.abiFilters.isNotEmpty()) {
        builder.appendLine()
        builder.appendLine("        ndk {")
        builder.append("            abiFilters ")
        builder.appendLine(ndkConfig.abiFilters.joinToString(", ") { "'$it'" })
        builder.appendLine("        }")
      }
    }

    builder.appendLine("    }")

    if (config.buildFeatures.isNotEmpty()) {
      builder.appendLine()
      builder.appendLine("    buildFeatures {")
      config.buildFeatures.forEach { feature ->
        builder.appendLine("        ${feature.featureName} true")
      }
      builder.appendLine("    }")
    }

    config.externalNativeBuild?.let { nativeBuild ->
      builder.appendLine()
      builder.appendLine("    externalNativeBuild {")

      nativeBuild.cmake?.let { cmake ->
        builder.appendLine("        cmake {")
        builder.appendLine("            path '${cmake.path}'")
        cmake.version?.let { version -> builder.appendLine("            version '$version'") }
        builder.appendLine("        }")
      }

      nativeBuild.ndkBuild?.let { ndkBuild ->
        builder.appendLine("        ndkBuild {")
        builder.appendLine("            path '${ndkBuild.path}'")
        builder.appendLine("        }")
      }

      builder.appendLine("    }")
    }

    builder.appendLine()
    builder.appendLine("    compileOptions {")
    builder.appendLine("        sourceCompatibility JavaVersion.${config.javaVersion.versionName}")
    builder.appendLine("        targetCompatibility JavaVersion.${config.javaVersion.versionName}")
    builder.appendLine("    }")

    if (config.enableKotlinOptions) {
      builder.appendLine("    kotlin {")
      builder.appendLine("        compilerOptions {")
      builder.appendLine(
          "            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.${config.javaVersion.toJvmName()})"
      )
      builder.appendLine("        }")
      builder.appendLine("    }")
    }

    if (config.enableCompose && config.composeCompilerVersion != null) {
      builder.appendLine("    composeOptions {")
      builder.appendLine(
          "        kotlinCompilerExtensionVersion = '${config.composeCompilerVersion}'"
      )
      builder.appendLine("    }")
      builder.appendLine("    packaging {")
      builder.appendLine("        resources {")
      builder.appendLine("            excludes += '/META-INF/{AL2.0,LGPL2.1}'")
      builder.appendLine("        }")
      builder.appendLine("    }")
    }

    builder.appendLine("}")

    if (config.dependencies.isNotEmpty()) {
      builder.appendLine()
      builder.appendLine("dependencies {")

      val outerCallRegex = Regex("""^(\w+)\((.+)\)$""")

      config.dependencies.forEach { dep ->
        val depStr = dep.dependency.trim()

        val cleaned =
            outerCallRegex.matchEntire(depStr)?.let { m ->
              val func = m.groupValues[1]
              val inner = m.groupValues[2]
              "$func $inner"
            } ?: depStr
        builder.appendLine("    $cleaned")
      }

      builder.appendLine("}")
    }

    return builder.toString()
  }

  /**
   * Creates a new instance of kts
   *
   * @param config the [ModuleGradleConfig] instance
   * @return the string
   */
  private fun generateKts(config: ModuleGradleConfig): String {
    val builder = StringBuilder()

    if (config.plugins.isNotEmpty()) {
      builder.appendLine("plugins {")
      builder.appendLine("    // Plugins automatically generated by MLGradleWriter.kt")
      config.plugins.forEach { plugin ->
        builder.appendLine("    ${buildPluginLine(plugin, true)}")
      }
      builder.appendLine("}")
      builder.appendLine()
    }

    builder.appendLine("android {")
    builder.appendLine("    namespace = \"${config.namespace}\"")
    builder.appendLine("    compileSdk = ${config.compileSdk}")

    config.ndkVersion?.let { builder.appendLine("    ndkVersion = \"$it\"") }

    builder.appendLine()

    builder.appendLine("    defaultConfig {")
    builder.appendLine("        applicationId = \"${config.defaultConfig.applicationId}\"")
    builder.appendLine("        minSdk = ${config.defaultConfig.minSdk}")
    builder.appendLine("        targetSdk = ${config.defaultConfig.targetSdk}")
    builder.appendLine("        versionCode = ${config.defaultConfig.versionCode}")
    builder.appendLine("        versionName = \"${config.defaultConfig.versionName}\"")

    config.defaultConfig.testInstrumentationRunner?.let {
      builder.appendLine()
      builder.appendLine("        testInstrumentationRunner = \"$it\"")
    }

    config.defaultConfig.ndk?.let { ndkConfig ->
      if (ndkConfig.abiFilters.isNotEmpty()) {
        builder.appendLine()
        builder.appendLine("        ndk {")
        builder.append("            abiFilters.addAll(listOf(")
        builder.append(ndkConfig.abiFilters.joinToString(", ") { "\"$it\"" })
        builder.appendLine("))")
        builder.appendLine("        }")
      }
    }

    builder.appendLine("    }")

    if (config.buildFeatures.isNotEmpty()) {
      builder.appendLine()
      builder.appendLine("    buildFeatures {")
      config.buildFeatures.forEach { feature ->
        builder.appendLine("        ${feature.featureName} = true")
      }
      builder.appendLine("    }")
    }

    config.externalNativeBuild?.let { nativeBuild ->
      builder.appendLine()
      builder.appendLine("    externalNativeBuild {")

      nativeBuild.cmake?.let { cmake ->
        builder.appendLine("        cmake {")
        builder.appendLine("            path = file(\"${cmake.path}\")")
        cmake.version?.let { version -> builder.appendLine("            version = \"$version\"") }
        builder.appendLine("        }")
      }

      nativeBuild.ndkBuild?.let { ndkBuild ->
        builder.appendLine("        ndkBuild {")
        builder.appendLine("            path = file(\"${ndkBuild.path}\")")
        builder.appendLine("        }")
      }

      builder.appendLine("    }")
    }

    builder.appendLine()
    builder.appendLine("    compileOptions {")
    builder.appendLine(
        "        sourceCompatibility = JavaVersion.${config.javaVersion.versionName}"
    )
    builder.appendLine(
        "        targetCompatibility = JavaVersion.${config.javaVersion.versionName}"
    )
    builder.appendLine("    }")

    if (config.enableKotlinOptions) {
      builder.appendLine("    kotlin {")
      builder.appendLine("        compilerOptions {")
      builder.appendLine(
          "            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.fromTarget(\"${config.javaVersion.versionNumber}\"))"
      )
      builder.appendLine("        }")
      builder.appendLine("    }")
    }

    if (config.enableCompose && config.composeCompilerVersion != null) {
      builder.appendLine("    composeOptions {")
      builder.appendLine(
          "        kotlinCompilerExtensionVersion = \"${config.composeCompilerVersion}\""
      )
      builder.appendLine("    }")
      builder.appendLine("    packaging {")
      builder.appendLine("        resources {")
      builder.appendLine("            excludes += \"/META-INF/{AL2.0,LGPL2.1}\"")
      builder.appendLine("        }")
      builder.appendLine("    }")
    }

    builder.appendLine("}")

    if (config.dependencies.isNotEmpty()) {
      builder.appendLine()
      builder.appendLine("dependencies {")
      config.dependencies.forEach { dep -> builder.appendLine("    ${dep.dependency}") }
      builder.appendLine("}")
    }

    return builder.toString()
  }

  /**
   * Creates a new instance of plugin line
   *
   * @param plugin the [GradlePlugin] instance
   * @param isKts whether is kts is enabled
   * @return the string
   */
  private fun buildPluginLine(plugin: GradlePlugin, isKts: Boolean): String {
    return when (plugin.type.lowercase()) {
      "id" -> {
        if (isKts) {
          "id(\"${plugin.plugin}\")"
        } else {
          "id '${plugin.plugin}'"
        }
      }
      "alias" -> {
        "alias(${plugin.plugin})"
      }
      else -> {
        if (isKts) {
          "${plugin.type}(\"${plugin.plugin}\")"
        } else {
          "${plugin.type} '${plugin.plugin}'"
        }
      }
    }
  }
}

/** Class ModuleGradleConfigBuilder. */
class ModuleGradleConfigBuilder {

  /** Performs the operation. */
  private val plugins = mutableListOf<GradlePlugin>()

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var namespace: String = ""

  /**
   * Performs the sdk operation.
   *
   * @return the int
   */
  private var compileSdk: Int = 0

  /**
   * Performs the operation.
   *
   * @return the default config
   */
  private var defaultConfig: DefaultConfig? = null

  /** Creates a new instance of features. */
  private val buildFeatures = mutableListOf<BuildFeature>()

  /**
   * Represents the java version.
   *
   * @return the java version
   */
  private var javaVersion: JavaVersion = JavaVersion.VERSION_17

  /**
   * Enables kotlin options.
   *
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  private var enableKotlinOptions: Boolean = true

  /**
   * Enables compose.
   *
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  private var enableCompose: Boolean = false

  /**
   * Creates a new instance of compiler version.
   *
   * @return the string
   */
  private var composeCompilerVersion: String? = null

  /** Performs the operation. */
  private val dependencies = mutableListOf<GradleDependency>()

  /**
   * Performs the build operation.
   *
   * @return the external native build
   */
  private var externalNativeBuild: ExternalNativeBuild? = null

  /**
   * Performs the version operation.
   *
   * @return the string
   */
  private var ndkVersion: String? = null

  /**
   * Adds plugin
   *
   * @param plugin the [GradlePlugin] instance
   */
  fun addPlugin(plugin: GradlePlugin) = apply { plugins.add(plugin) }

  /**
   * Adds plugins
   *
   * @param plugins the plugins as a [GradlePlugin]
   */
  fun addPlugins(vararg plugins: GradlePlugin) = apply { this.plugins.addAll(plugins) }

  /**
   * Performs the operation
   *
   * @param namespace the namespace text
   */
  fun namespace(namespace: String) = apply { this.namespace = namespace }

  /**
   * Performs the sdk operation
   *
   * @param sdk the numeric sdk
   */
  fun compileSdk(sdk: Int) = apply { this.compileSdk = sdk }

  /**
   * Performs the operation
   *
   * @param config the [DefaultConfig] instance
   */
  fun defaultConfig(config: DefaultConfig) = apply { this.defaultConfig = config }

  /**
   * Adds build feature
   *
   * @param feature the [BuildFeature] instance
   */
  fun addBuildFeature(feature: BuildFeature) = apply { buildFeatures.add(feature) }

  /**
   * Adds build features
   *
   * @param features the features as a [BuildFeature]
   */
  fun addBuildFeatures(vararg features: BuildFeature) = apply { buildFeatures.addAll(features) }

  /**
   * Represents the java version
   *
   * @param version the [JavaVersion] instance
   */
  fun javaVersion(version: JavaVersion) = apply { this.javaVersion = version }

  /**
   * Enables kotlin options
   *
   * @param enable whether enable
   */
  fun enableKotlinOptions(enable: Boolean) = apply { this.enableKotlinOptions = enable }

  /**
   * Enables compose
   *
   * @param enable whether enable
   * @param compilerVersion the compiler version text, or `null` if omitted
   */
  fun enableCompose(enable: Boolean, compilerVersion: String? = null) = apply {
    this.enableCompose = enable
    this.composeCompilerVersion = compilerVersion
  }

  /**
   * Adds dependency
   *
   * @param dependency the [GradleDependency] instance
   */
  fun addDependency(dependency: GradleDependency) = apply { dependencies.add(dependency) }

  /**
   * Adds dependencies
   *
   * @param deps the deps as a [GradleDependency]
   */
  fun addDependencies(vararg deps: GradleDependency) = apply { dependencies.addAll(deps) }

  /**
   * Performs the build operation
   *
   * @param build the [ExternalNativeBuild] instance
   */
  fun externalNativeBuild(build: ExternalNativeBuild) = apply { this.externalNativeBuild = build }

  /**
   * Performs the version operation
   *
   * @param version the version text
   */
  fun ndkVersion(version: String) = apply { this.ndkVersion = version }

  /**
   * Creates a new instance of
   *
   * @return the module gradle config
   */
  fun build(): ModuleGradleConfig {
    require(namespace.isNotBlank()) { "Namespace cannot be blank" }
    require(compileSdk > 0) { "Compile SDK must be greater than 0" }
    requireNotNull(defaultConfig) { "Default config must be set" }

    return ModuleGradleConfig(
        plugins = plugins.toList(),
        namespace = namespace,
        compileSdk = compileSdk,
        defaultConfig = defaultConfig!!,
        buildFeatures = buildFeatures.toList(),
        javaVersion = javaVersion,
        enableKotlinOptions = enableKotlinOptions,
        enableCompose = enableCompose,
        composeCompilerVersion = composeCompilerVersion,
        dependencies = dependencies.toList(),
        externalNativeBuild = externalNativeBuild,
        ndkVersion = ndkVersion,
    )
  }
}

/**
 * Performs the gradle config operation
 *
 * @param block the block
 * @return the module gradle config
 */
fun moduleGradleConfig(block: ModuleGradleConfigBuilder.() -> Unit): ModuleGradleConfig {
  return ModuleGradleConfigBuilder().apply(block).build()
}
