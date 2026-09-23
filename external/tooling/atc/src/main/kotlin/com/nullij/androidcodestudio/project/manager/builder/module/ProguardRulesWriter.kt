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
 * Data class ProguardRule.
 *
 * @author nullij @ https://github.com/nullij
 */
data class ProguardRule(val rule: String, val comment: String? = null)

/** Class MLProguardRules. */
interface MLProguardRules {

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
   * @param rules the collection of rules
   * @param headerComment the header comment text, or `null` if omitted
   * @return the string
   */
  fun generate(rules: List<ProguardRule>, headerComment: String? = null): String

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
   * @param rules the collection of rules
   * @param headerComment the header comment text, or `null` if omitted
   * @return the file
   */
  fun writeToFile(outputDir: File, rules: List<ProguardRule>, headerComment: String? = null): File
}

/** Class ProguardRulesWriter. */
class ProguardRulesWriter : MLProguardRules {

  /** Companion object Companion. */
  companion object {

    /** Performs the name operation. */
    const val FILE_NAME = "proguard-rules.pro"
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
   * @param rules the collection of rules
   * @param headerComment the header comment text, or `null` if omitted
   * @return the string
   */
  override fun generate(rules: List<ProguardRule>, headerComment: String?): String {
    val builder = StringBuilder()

    if (headerComment != null) {
      builder.appendLine("# $headerComment")
      builder.appendLine()
    }

    rules.forEach { rule ->
      if (rule.comment != null) {
        builder.appendLine("# ${rule.comment}")
      }
      builder.appendLine(rule.rule.trimIndent())
      builder.appendLine()
    }

    return builder.toString().trimEnd() + "\n"
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
   * @param rules the collection of rules
   * @param headerComment the header comment text, or `null` if omitted
   * @return the file
   */
  override fun writeToFile(
      outputDir: File,
      rules: List<ProguardRule>,
      headerComment: String?,
  ): File {
    if (!outputDir.exists()) {
      outputDir.mkdirs()
    }

    val content = generate(rules, headerComment)
    val file = File(outputDir, FILE_NAME)
    file.writeText(content)

    return file
  }
}

/** Class ProguardRuleBuilder. */
class ProguardRuleBuilder {

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var rule: String = ""

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var comment: String? = null

  /**
   * Performs the operation
   *
   * @param rule the rule text
   */
  fun rule(rule: String) = apply { this.rule = rule }

  /**
   * Performs the operation
   *
   * @param comment the comment text, or `null` if omitted
   */
  fun comment(comment: String?) = apply { this.comment = comment }

  /**
   * Creates a new instance of
   *
   * @return the proguard rule
   */
  fun build(): ProguardRule {
    require(rule.isNotBlank()) { "ProGuard rule cannot be blank" }
    return ProguardRule(rule, comment)
  }
}

/**
 * Performs the rule operation
 *
 * @param block the block
 * @return the proguard rule
 */
fun proguardRule(block: ProguardRuleBuilder.() -> Unit): ProguardRule {
  return ProguardRuleBuilder().apply(block).build()
}

/** Object ProguardRulesPresets. */
object ProguardRulesPresets {

  /** Performs the operation. */
  val DEFAULT_ANDROID =
      """
      # Add project specific ProGuard rules here.
      # You can control the set of applied configuration files using the
      # proguardFiles setting in build.gradle.
      #
      # For more details, see
      #   http://developer.android.com/guide/developing/tools/proguard.html

      # If your project uses WebView with JS, uncomment the following
      # and specify the fully qualified class name to the JavaScript interface
      # class:
      #-keepclassmembers class fqcn.of.javascript.interface.for.webview {
      #   public *;
      #}

      # Uncomment this to preserve the line number information for
      # debugging stack traces.
      #-keepattributes SourceFile,LineNumberTable

      # If you keep the line number information, uncomment this to
      # hide the original source file name.
      #-renamesourcefileattribute SourceFile
      """
          .trimIndent()

  /** Performs the all operation. */
  val KEEP_ALL =
      """
      # Keep all classes
      -keep class ** { *; }
      -keepclassmembers class ** { *; }
      """
          .trimIndent()

  /** Performs the operation. */
  val RETROFIT =
      """
      # Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
      # EnclosingMethod is required to use InnerClasses.
      -keepattributes Signature, InnerClasses, EnclosingMethod

      # Retrofit does reflection on method and parameter annotations.
      -keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

      # Keep annotation default values (e.g., retrofit2.http.Field.encoded).
      -keepattributes AnnotationDefault

      # Retain service method parameters when optimizing.
      -keepclassmembers,allowshrinking,allowobfuscation interface * {
          @retrofit2.http.* <methods>;
      }

      # Ignore annotation used for build tooling.
      -dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

      # Ignore JSR 305 annotations for embedding nullability information.
      -dontwarn javax.annotation.**

      # Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
      -dontwarn kotlin.Unit

      # Top-level functions that can only be used by Kotlin.
      -dontwarn retrofit2.KotlinExtensions
      -dontwarn retrofit2.KotlinExtensions$*

      # With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
      # and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
      -if interface * { @retrofit2.http.* <methods>; }
      -keep,allowobfuscation interface <1>

      # Keep inherited services.
      -if interface * { @retrofit2.http.* <methods>; }
      -keep,allowobfuscation interface * extends <1>

      # Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
      -keep,allowobfuscation,allowshrinking interface retrofit2.Call
      -keep,allowobfuscation,allowshrinking class retrofit2.Response

      # With R8 full mode generic signatures are stripped for classes that are not
      # kept. Suspend functions are wrapped in continuations where the type argument
      # is used.
      -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
      """
          .trimIndent()

  /** Represents the gson. */
  val GSON =
      """
      # Gson uses generic type information stored in a class file when working with fields. Proguard
      # removes such information by default, so configure it to keep all of it.
      -keepattributes Signature

      # For using GSON @Expose annotation
      -keepattributes *Annotation*

      # Gson specific classes
      -dontwarn sun.misc.**

      # Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
      # JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
      -keep class * extends com.google.gson.TypeAdapter
      -keep class * implements com.google.gson.TypeAdapterFactory
      -keep class * implements com.google.gson.JsonSerializer
      -keep class * implements com.google.gson.JsonDeserializer

      # Prevent R8 from leaving Data object members always null
      -keepclassmembers,allowobfuscation class * {
        @com.google.gson.annotations.SerializedName <fields>;
      }

      # Retain generic signatures of TypeToken and its subclasses with R8 version 3.0 and higher.
      -keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
      -keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken
      """
          .trimIndent()

  /** Performs the operation. */
  val OKHTTP =
      """
      # JSR 305 annotations are for embedding nullability information.
      -dontwarn javax.annotation.**

      # A resource is loaded with a relative path so the package of this class must be preserved.
      -keeppackagenames okhttp3.internal.publicsuffix.*
      -adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz

      # Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
      -dontwarn org.codehaus.mojo.animal_sniffer.*

      # OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
      -dontwarn okhttp3.internal.platform.**
      -dontwarn org.conscrypt.**
      -dontwarn org.bouncycastle.**
      -dontwarn org.openjsse.**
      """
          .trimIndent()

  /** Performs the info operation. */
  val DEBUG_INFO =
      """
      # Keep source file and line numbers for better stack traces
      -keepattributes SourceFile,LineNumberTable
      -renamesourcefileattribute SourceFile
      """
          .trimIndent()
}
