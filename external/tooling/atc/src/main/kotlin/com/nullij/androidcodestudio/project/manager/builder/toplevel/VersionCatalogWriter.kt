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
 * Data class CatalogVersion.
 *
 * @author nullij @ https://github.com/nullij
 */
data class CatalogVersion(val name: String, val version: String)

/** Data class CatalogPlugin. */
data class CatalogPlugin(
    val alias: String,
    val id: String,
    val versionRef: String? = null,
    val version: String? = null,
)

/** Data class CatalogLibrary. */
data class CatalogLibrary(
    val alias: String,
    val group: String,
    val name: String,
    val versionRef: String? = null,
    val version: String? = null,
)

/** Data class CatalogSection. */
data class CatalogSection(val name: String, val entries: Map<String, Any>)

/** Class GLCatalog. */
interface GLCatalog {

  /**
   * Creates a new instance of
   *
   * @param versions the collection of versions
   * @param plugins the collection of plugins
   * @param libraries the collection of libraries
   * @param customSections the collection of custom sections
   * @return the string
   */
  fun generate(
      versions: List<CatalogVersion> = emptyList(),
      plugins: List<CatalogPlugin> = emptyList(),
      libraries: List<CatalogLibrary> = emptyList(),
      customSections: List<CatalogSection> = emptyList(),
  ): String

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param versions the collection of versions
   * @param plugins the collection of plugins
   * @param libraries the collection of libraries
   * @param customSections the collection of custom sections
   * @return the file
   */
  fun writeToFile(
      outputDir: File,
      versions: List<CatalogVersion> = emptyList(),
      plugins: List<CatalogPlugin> = emptyList(),
      libraries: List<CatalogLibrary> = emptyList(),
      customSections: List<CatalogSection> = emptyList(),
  ): File
}

/** Class VersionCatalogWriter. */
class VersionCatalogWriter : GLCatalog {

  /** Companion object Companion. */
  companion object {

    /** Performs the file name operation. */
    const val CATALOG_FILE_NAME = "libs.versions.toml"
  }

  /**
   * Creates a new instance of
   *
   * @param versions the collection of versions
   * @param plugins the collection of plugins
   * @param libraries the collection of libraries
   * @param customSections the collection of custom sections
   * @return the string
   */
  override fun generate(
      versions: List<CatalogVersion>,
      plugins: List<CatalogPlugin>,
      libraries: List<CatalogLibrary>,
      customSections: List<CatalogSection>,
  ): String {
    val builder = StringBuilder()

    if (versions.isNotEmpty()) {
      builder.appendLine("[versions]")
      versions.forEach { version -> builder.appendLine("${version.name} = \"${version.version}\"") }
      builder.appendLine()
    }

    if (plugins.isNotEmpty()) {
      builder.appendLine("[plugins]")
      plugins.forEach { plugin ->
        val pluginLine = buildPluginLine(plugin)
        builder.appendLine("$pluginLine")
      }
      builder.appendLine()
    }

    if (libraries.isNotEmpty()) {
      builder.appendLine("[libraries]")
      libraries.forEach { library ->
        val libraryLine = buildLibraryLine(library)
        builder.appendLine("$libraryLine")
      }
      builder.appendLine()
    }

    customSections.forEach { section ->
      builder.appendLine("[${section.name}]")
      section.entries.forEach { (key, value) ->
        val entryLine = buildCustomEntryLine(key, value)
        builder.appendLine("$entryLine")
      }
      builder.appendLine()
    }

    return builder.toString().trimEnd() + "\n"
  }

  /**
   * Sets the to file
   *
   * @param outputDir the output dir as a [File]
   * @param versions the collection of versions
   * @param plugins the collection of plugins
   * @param libraries the collection of libraries
   * @param customSections the collection of custom sections
   * @return the file
   */
  override fun writeToFile(
      outputDir: File,
      versions: List<CatalogVersion>,
      plugins: List<CatalogPlugin>,
      libraries: List<CatalogLibrary>,
      customSections: List<CatalogSection>,
  ): File {
    if (!outputDir.exists()) {
      outputDir.mkdirs()
    }

    val content = generate(versions, plugins, libraries, customSections)
    val file = File(outputDir, CATALOG_FILE_NAME)
    file.writeText(content)

    return file
  }

  /**
   * Creates a new instance of plugin line
   *
   * @param plugin the [CatalogPlugin] instance
   * @return the string
   */
  private fun buildPluginLine(plugin: CatalogPlugin): String {
    val parts = mutableListOf<String>()
    parts.add("id = \"${plugin.id}\"")

    when {
      plugin.versionRef != null -> parts.add("version.ref = \"${plugin.versionRef}\"")
      plugin.version != null -> parts.add("version = \"${plugin.version}\"")
    }

    return "${plugin.alias} = { ${parts.joinToString(", ")} }"
  }

  /**
   * Creates a new instance of library line
   *
   * @param library the [CatalogLibrary] instance
   * @return the string
   */
  private fun buildLibraryLine(library: CatalogLibrary): String {
    val parts = mutableListOf<String>()
    parts.add("group = \"${library.group}\"")
    parts.add("name = \"${library.name}\"")

    when {
      library.versionRef != null -> parts.add("version.ref = \"${library.versionRef}\"")
      library.version != null -> parts.add("version = \"${library.version}\"")
    }

    return "${library.alias} = { ${parts.joinToString(", ")} }"
  }

  /**
   * Creates a new instance of custom entry line
   *
   * @param key the key text
   * @param value the value as a [Any]
   * @return the string
   */
  private fun buildCustomEntryLine(key: String, value: Any): String {
    return when (value) {
      is String -> "$key = \"$value\""
      is List<*> -> "$key = [${value.joinToString(", ") { "\"$it\"" }}]"
      is Map<*, *> -> {
        val mapContent = value.entries.joinToString(", ") { (k, v) -> "$k = \"$v\"" }
        "$key = { $mapContent }"
      }
      else -> "$key = \"$value\""
    }
  }
}

/** Class CatalogVersionBuilder. */
class CatalogVersionBuilder {

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var name: String = ""

  /**
   * Represents the version.
   *
   * @return the string
   */
  private var version: String = ""

  /**
   * Performs the operation
   *
   * @param name the name text
   */
  fun name(name: String) = apply { this.name = name }

  /**
   * Represents the version
   *
   * @param version the version text
   */
  fun version(version: String) = apply { this.version = version }

  /**
   * Creates a new instance of
   *
   * @return the catalog version
   */
  fun build(): CatalogVersion {
    require(name.isNotBlank()) { "Version name cannot be blank" }
    require(version.isNotBlank()) { "Version string cannot be blank" }
    return CatalogVersion(name, version)
  }
}

/** Class CatalogPluginBuilder. */
class CatalogPluginBuilder {

  /**
   * Represents the alias.
   *
   * @return the string
   */
  private var alias: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var id: String = ""

  /**
   * Represents the version ref.
   *
   * @return the string
   */
  private var versionRef: String? = null

  /**
   * Represents the version.
   *
   * @return the string
   */
  private var version: String? = null

  /**
   * Represents the alias
   *
   * @param alias the alias text
   */
  fun alias(alias: String) = apply { this.alias = alias }

  /**
   * Performs the operation
   *
   * @param id the id text
   */
  fun id(id: String) = apply { this.id = id }

  /**
   * Represents the version ref
   *
   * @param versionRef the version ref text, or `null` if omitted
   */
  fun versionRef(versionRef: String?) = apply { this.versionRef = versionRef }

  /**
   * Represents the version
   *
   * @param version the version text, or `null` if omitted
   */
  fun version(version: String?) = apply { this.version = version }

  /**
   * Creates a new instance of
   *
   * @return the catalog plugin
   */
  fun build(): CatalogPlugin {
    require(alias.isNotBlank()) { "Plugin alias cannot be blank" }
    require(id.isNotBlank()) { "Plugin ID cannot be blank" }
    return CatalogPlugin(alias, id, versionRef, version)
  }
}

/** Class CatalogLibraryBuilder. */
class CatalogLibraryBuilder {

  /**
   * Represents the alias.
   *
   * @return the string
   */
  private var alias: String = ""

  /**
   * Represents the group.
   *
   * @return the string
   */
  private var group: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var name: String = ""

  /**
   * Represents the version ref.
   *
   * @return the string
   */
  private var versionRef: String? = null

  /**
   * Represents the version.
   *
   * @return the string
   */
  private var version: String? = null

  /**
   * Represents the alias
   *
   * @param alias the alias text
   */
  fun alias(alias: String) = apply { this.alias = alias }

  /**
   * Represents the group
   *
   * @param group the group text
   */
  fun group(group: String) = apply { this.group = group }

  /**
   * Performs the operation
   *
   * @param name the name text
   */
  fun name(name: String) = apply { this.name = name }

  /**
   * Represents the version ref
   *
   * @param versionRef the version ref text, or `null` if omitted
   */
  fun versionRef(versionRef: String?) = apply { this.versionRef = versionRef }

  /**
   * Represents the version
   *
   * @param version the version text, or `null` if omitted
   */
  fun version(version: String?) = apply { this.version = version }

  /**
   * Creates a new instance of
   *
   * @return the catalog library
   */
  fun build(): CatalogLibrary {
    require(alias.isNotBlank()) { "Library alias cannot be blank" }
    require(group.isNotBlank()) { "Library group cannot be blank" }
    require(name.isNotBlank()) { "Library name cannot be blank" }
    return CatalogLibrary(alias, group, name, versionRef, version)
  }
}

/**
 * Performs the version operation
 *
 * @param block the block
 * @return the catalog version
 */
fun catalogVersion(block: CatalogVersionBuilder.() -> Unit): CatalogVersion {
  return CatalogVersionBuilder().apply(block).build()
}

/**
 * Performs the plugin operation
 *
 * @param block the block
 * @return the catalog plugin
 */
fun catalogPlugin(block: CatalogPluginBuilder.() -> Unit): CatalogPlugin {
  return CatalogPluginBuilder().apply(block).build()
}

/**
 * Performs the library operation
 *
 * @param block the block
 * @return the catalog library
 */
fun catalogLibrary(block: CatalogLibraryBuilder.() -> Unit): CatalogLibrary {
  return CatalogLibraryBuilder().apply(block).build()
}

/**
 * Performs the section operation
 *
 * @param name the name text
 * @param block the block as a [MutableMap]
 * @return the catalog section
 */
fun catalogSection(name: String, block: MutableMap<String, Any>.() -> Unit): CatalogSection {
  val entries = mutableMapOf<String, Any>()
  entries.apply(block)
  return CatalogSection(name, entries)
}
