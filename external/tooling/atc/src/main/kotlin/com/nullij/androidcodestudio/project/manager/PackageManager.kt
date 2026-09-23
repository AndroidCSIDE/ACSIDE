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

package com.nullij.androidcodestudio.project.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Class PackageHelper.
 *
 * @author nullij @ https://github.com/nullij
 */
class PackageHelper
private constructor(private val context: Context, private val projectId: String) {

  /** Companion object Companion. */
  companion object {

    /**
     * Represents the data store.
     *
     * @return the data store
     */
    private val Context.dataStore: DataStore<Preferences> by
        preferencesDataStore(name = "package_settings")

    /**
     * Creates a new instance of for project
     *
     * @param context the context as a [Context]
     * @param projectId the project id text
     * @return the package helper
     */
    fun createForProject(context: Context, projectId: String): PackageHelper {
      return PackageHelper(context.applicationContext, projectId)
    }
  }

  /** Performs the key operation. */
  private val PACKAGE_ID_KEY = stringPreferencesKey("package_id_$projectId")

  /**
   * Performs the operation.
   *
   * @return the string
   */
  private var currentPackageId: String = runBlocking {
    context.dataStore.data.map { preferences -> preferences[PACKAGE_ID_KEY] ?: "" }.first()
  }

  /**
   * Sets the package id
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param packageId the package id text
   */
  suspend fun setPackageId(packageId: String) {
    if (!isValidPackageId(packageId)) {
      throw IllegalArgumentException("Invalid package ID format: $packageId")
    }

    synchronized(this) { currentPackageId = packageId }

    context.dataStore.edit { preferences -> preferences[PACKAGE_ID_KEY] = packageId }
  }

  /**
   * Sets the package id blocking
   *
   * @param packageId the package id text
   */
  fun setPackageIdBlocking(packageId: String) = runBlocking { setPackageId(packageId) }

  /**
   * Retrieves the package id
   *
   * @return the string
   */
  fun getPackageId(): String {
    return currentPackageId
  }

  /**
   * Retrieves the package id flows
   *
   * @return a collection of strings
   */
  fun getPackageIdFlow(): Flow<String> {
    return context.dataStore.data.map { preferences -> preferences[PACKAGE_ID_KEY] ?: "" }
  }

  /**
   * Retrieves the stored package id
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return the string
   */
  suspend fun getStoredPackageId(): String {
    return context.dataStore.data.map { preferences -> preferences[PACKAGE_ID_KEY] ?: "" }.first()
  }

  /**
   * Retrieves the stored package id blocking
   *
   * @return the string
   */
  fun getStoredPackageIdBlocking(): String = runBlocking { getStoredPackageId() }

  /**
   * Indicates whether valid package id
   *
   * @param packageId the package id text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun isValidPackageId(packageId: String): Boolean {
    if (packageId.isBlank()) return false

    val packagePattern = "^[a-zA-Z][a-zA-Z0-9_]*(\\.[a-zA-Z][a-zA-Z0-9_]*)+$".toRegex()

    return packagePattern.matches(packageId) && packageId.length in 3..255
  }

  /**
   * Performs the package id operation
   *
   * This is a suspend function and can only be called from a coroutine.
   */
  suspend fun clearStoredPackageId() {
    synchronized(this) { currentPackageId = "" }

    context.dataStore.edit { preferences -> preferences.remove(PACKAGE_ID_KEY) }
  }

  /** Performs the package id blocking operation */
  fun clearStoredPackageIdBlocking() = runBlocking { clearStoredPackageId() }

  /**
   * Indicates whether package id is present
   *
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun hasPackageId(): Boolean {
    return currentPackageId.isNotBlank()
  }

  /**
   * Retrieves the application id
   *
   * @return the string
   */
  fun getApplicationId(): String {
    if (currentPackageId.isBlank()) return ""
    return currentPackageId.substringAfterLast('.', "app")
  }

  /**
   * Retrieves the base package
   *
   * @return the string
   */
  fun getBasePackage(): String {
    if (currentPackageId.isBlank()) return ""

    val lastDotIndex = currentPackageId.lastIndexOf('.')
    return if (lastDotIndex != -1) {
      currentPackageId.substring(0, lastDotIndex)
    } else {
      currentPackageId
    }
  }

  /**
   * Performs the path operation
   *
   * @return the string
   */
  fun toDirectoryPath(): String {
    if (currentPackageId.isBlank()) return ""
    return currentPackageId.replace('.', '/')
  }

  /**
   * Sets the package id
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param packageId the package id text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  suspend fun safeSetPackageId(packageId: String): Boolean {
    return if (isValidPackageId(packageId)) {
      setPackageId(packageId)
      true
    } else {
      false
    }
  }

  /**
   * Sets the package id blocking
   *
   * @param packageId the package id text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun safeSetPackageIdBlocking(packageId: String): Boolean = runBlocking {
    safeSetPackageId(packageId)
  }

  /**
   * Retrieves the project id
   *
   * @return the string
   */
  fun getProjectId(): String {
    return projectId
  }
}
