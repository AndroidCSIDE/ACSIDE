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
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Class SdkVersionHelper.
 *
 * @author nullij @ https://github.com/nullij
 */
class SdkVersionHelper private constructor(private val context: Context) {

  /** Companion object Companion. */
  companion object {

    /**
     * Represents the data store.
     *
     * @return the data store
     */
    private val Context.dataStore: DataStore<Preferences> by
        preferencesDataStore(name = "sdk_version_settings")

    /** Performs the key operation. */
    private val MIN_SDK_KEY = intPreferencesKey("pref_min_sdk_version")

    /** Performs the sdk key operation. */
    private val TARGET_SDK_KEY = intPreferencesKey("pref_target_sdk_version")

    /** Performs the sdk key operation. */
    private val MAX_SDK_KEY = intPreferencesKey("pref_max_sdk_version")

    /**
     * Represents the instance.
     *
     * @return the sdk version helper
     */
    @Volatile private var instance: SdkVersionHelper? = null

    /**
     * Retrieves the instance
     *
     * @param context the context as a [Context]
     * @return the sdk version helper
     */
    fun getInstance(context: Context): SdkVersionHelper {
      return instance
          ?: synchronized(this) {
            instance ?: SdkVersionHelper(context.applicationContext).also { instance = it }
          }
    }
  }

  /**
   * Performs the operation.
   *
   * @return the int
   */
  private var currentMinSdk: Int = 0

  /**
   * Performs the sdk operation.
   *
   * @return the int
   */
  private var currentTargetSdk: Int = 0

  /**
   * Performs the sdk operation.
   *
   * @return the int
   */
  private var currentMaxSdk: Int = 0

  init {
    runBlocking {
      context.dataStore.data
          .map { preferences ->
            currentMinSdk = preferences[MIN_SDK_KEY] ?: 0
            currentTargetSdk = preferences[TARGET_SDK_KEY] ?: 0
            currentMaxSdk = preferences[MAX_SDK_KEY] ?: 0
          }
          .first()
    }
  }

  /**
   * Sets the min sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param minSdk the numeric min sdk
   */
  suspend fun setMinSdk(minSdk: Int) {
    synchronized(this) { currentMinSdk = minSdk }

    context.dataStore.edit { preferences -> preferences[MIN_SDK_KEY] = minSdk }
  }

  /**
   * Sets the min sdk blocking
   *
   * @param minSdk the numeric min sdk
   */
  fun setMinSdkBlocking(minSdk: Int) = runBlocking { setMinSdk(minSdk) }

  /**
   * Sets the target sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param targetSdk the numeric target sdk
   */
  suspend fun setTargetSdk(targetSdk: Int) {
    synchronized(this) { currentTargetSdk = targetSdk }

    context.dataStore.edit { preferences -> preferences[TARGET_SDK_KEY] = targetSdk }
  }

  /**
   * Sets the target sdk blocking
   *
   * @param targetSdk the numeric target sdk
   */
  fun setTargetSdkBlocking(targetSdk: Int) = runBlocking { setTargetSdk(targetSdk) }

  /**
   * Sets the max sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param maxSdk the numeric max sdk
   */
  suspend fun setMaxSdk(maxSdk: Int) {
    synchronized(this) { currentMaxSdk = maxSdk }

    context.dataStore.edit { preferences -> preferences[MAX_SDK_KEY] = maxSdk }
  }

  /**
   * Sets the max sdk blocking
   *
   * @param maxSdk the numeric max sdk
   */
  fun setMaxSdkBlocking(maxSdk: Int) = runBlocking { setMaxSdk(maxSdk) }

  /**
   * Retrieves the min sdk
   *
   * @return the int
   */
  fun getMinSdk(): Int {
    return currentMinSdk
  }

  /**
   * Retrieves the target sdk
   *
   * @return the int
   */
  fun getTargetSdk(): Int {
    return currentTargetSdk
  }

  /**
   * Retrieves the max sdk
   *
   * @return the int
   */
  fun getMaxSdk(): Int {
    return currentMaxSdk
  }

  /**
   * Retrieves the min sdk flows
   *
   * @return a collection of ints
   */
  fun getMinSdkFlow(): Flow<Int> {
    return context.dataStore.data.map { preferences -> preferences[MIN_SDK_KEY] ?: 0 }
  }

  /**
   * Retrieves the target sdk flows
   *
   * @return a collection of ints
   */
  fun getTargetSdkFlow(): Flow<Int> {
    return context.dataStore.data.map { preferences -> preferences[TARGET_SDK_KEY] ?: 0 }
  }

  /**
   * Retrieves the max sdk flows
   *
   * @return a collection of ints
   */
  fun getMaxSdkFlow(): Flow<Int> {
    return context.dataStore.data.map { preferences -> preferences[MAX_SDK_KEY] ?: 0 }
  }

  /**
   * Retrieves the stored min sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return the int
   */
  suspend fun getStoredMinSdk(): Int {
    return context.dataStore.data.map { preferences -> preferences[MIN_SDK_KEY] ?: 0 }.first()
  }

  /**
   * Retrieves the stored target sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return the int
   */
  suspend fun getStoredTargetSdk(): Int {
    return context.dataStore.data.map { preferences -> preferences[TARGET_SDK_KEY] ?: 0 }.first()
  }

  /**
   * Retrieves the stored max sdk
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return the int
   */
  suspend fun getStoredMaxSdk(): Int {
    return context.dataStore.data.map { preferences -> preferences[MAX_SDK_KEY] ?: 0 }.first()
  }

  /**
   * Removes the specified
   *
   * This is a suspend function and can only be called from a coroutine.
   */
  suspend fun clear() {
    synchronized(this) {
      currentMinSdk = 0
      currentTargetSdk = 0
      currentMaxSdk = 0
    }

    context.dataStore.edit { preferences ->
      preferences.remove(MIN_SDK_KEY)
      preferences.remove(TARGET_SDK_KEY)
      preferences.remove(MAX_SDK_KEY)
    }
  }

  /** Performs the operation */
  fun clearBlocking() = runBlocking { clear() }

  /**
   * Sets the all sdk versions
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param minSdk the numeric min sdk
   * @param targetSdk the numeric target sdk
   * @param maxSdk the numeric max sdk
   */
  suspend fun setAllSdkVersions(minSdk: Int, targetSdk: Int, maxSdk: Int) {
    synchronized(this) {
      currentMinSdk = minSdk
      currentTargetSdk = targetSdk
      currentMaxSdk = maxSdk
    }

    context.dataStore.edit { preferences ->
      preferences[MIN_SDK_KEY] = minSdk
      preferences[TARGET_SDK_KEY] = targetSdk
      preferences[MAX_SDK_KEY] = maxSdk
    }
  }

  /**
   * Sets the all sdk versions blocking
   *
   * @param minSdk the numeric min sdk
   * @param targetSdk the numeric target sdk
   * @param maxSdk the numeric max sdk
   */
  fun setAllSdkVersionsBlocking(minSdk: Int, targetSdk: Int, maxSdk: Int) = runBlocking {
    setAllSdkVersions(minSdk, targetSdk, maxSdk)
  }

  /**
   * Indicates whether valid configuration
   *
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun isValidConfiguration(): Boolean {
    return currentMinSdk > 0 &&
        currentTargetSdk >= currentMinSdk &&
        (currentMaxSdk == 0 || currentMaxSdk >= currentTargetSdk)
  }
}
