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
import java.io.File
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Data class ProjectInfo.
 *
 * @author nullij @ https://github.com/nullij
 */
data class ProjectInfo(
    val projectId: String,
    val projectName: String,
    val projectDir: String,
    val projectType: String,
)

/** Enum class ProjectSource. */
enum class ProjectSource {

  /** Class TEMPLATE_CREATOR. */
  TEMPLATE_CREATOR,

  /** Class EXTERNAL. */
  EXTERNAL,
}

/** Class ProjectManager. */
class ProjectManager private constructor(private val context: Context) {

  /** Companion object Companion. */
  companion object {

    /**
     * Represents the data store.
     *
     * @return the data store
     */
    private val Context.dataStore: DataStore<Preferences> by
        preferencesDataStore(name = "project_tracking")

    /**
     * Represents the instance.
     *
     * @return the project manager
     */
    @Volatile private var instance: ProjectManager? = null

    /**
     * Retrieves the instance
     *
     * @param context the context as a [Context]
     * @return the project manager
     */
    fun getInstance(context: Context): ProjectManager {
      return instance
          ?: synchronized(this) {
            instance ?: ProjectManager(context.applicationContext).also { instance = it }
          }
    }
  }

  /** Performs the key operation. */
  private val PROJECTS_KEY = stringPreferencesKey("tracked_projects")

  /** Performs the counter key operation. */
  private val PROJECT_COUNTER_KEY = stringPreferencesKey("project_counter")

  /**
   * Adds project
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectInfo the project info as a [ProjectInfo]
   * @param source the [ProjectSource] instance
   */
  suspend fun addProject(
      projectInfo: ProjectInfo,
      source: ProjectSource = ProjectSource.TEMPLATE_CREATOR,
  ) {
    val projects = getTrackedProjects().toMutableList()

    if (projects.any { it.projectDir == projectInfo.projectDir }) {
      return
    }

    projects.add(projectInfo)
    saveProjects(projects)
  }

  /**
   * Adds project blocking
   *
   * @param projectInfo the project info as a [ProjectInfo]
   * @param source the [ProjectSource] instance
   */
  fun addProjectBlocking(
      projectInfo: ProjectInfo,
      source: ProjectSource = ProjectSource.TEMPLATE_CREATOR,
  ) = runBlocking { addProject(projectInfo, source) }

  /**
   * Removes the specified project
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectId the project id text
   */
  suspend fun removeProject(projectId: String) {
    val projects = getTrackedProjects().toMutableList()
    projects.removeAll { it.projectId == projectId }
    saveProjects(projects)
  }

  /**
   * Removes the specified project blocking
   *
   * @param projectId the project id text
   */
  fun removeProjectBlocking(projectId: String) = runBlocking { removeProject(projectId) }

  /**
   * Performs the operation
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectId the project id text
   * @param updatedInfo the updated info as a [ProjectInfo]
   */
  suspend fun updateProject(projectId: String, updatedInfo: ProjectInfo) {
    val projects = getTrackedProjects().toMutableList()
    val index = projects.indexOfFirst { it.projectId == projectId }

    if (index != -1) {
      projects[index] = updatedInfo
      saveProjects(projects)
    }
  }

  /**
   * Performs the blocking operation
   *
   * @param projectId the project id text
   * @param updatedInfo the updated info as a [ProjectInfo]
   */
  fun updateProjectBlocking(projectId: String, updatedInfo: ProjectInfo) = runBlocking {
    updateProject(projectId, updatedInfo)
  }

  /**
   * Retrieves the tracked projectses
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return a collection of project infos
   */
  suspend fun getTrackedProjects(): List<ProjectInfo> {
    return context.dataStore.data
        .map { preferences ->
          val projectsJson = preferences[PROJECTS_KEY] ?: "[]"
          parseProjectsFromJson(projectsJson)
        }
        .first()
  }

  /**
   * Retrieves the tracked projects blockings
   *
   * @return a collection of project infos
   */
  fun getTrackedProjectsBlocking(): List<ProjectInfo> = runBlocking { getTrackedProjects() }

  /**
   * Retrieves the project by id
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectId the project id text
   * @return the project info
   */
  suspend fun getProjectById(projectId: String): ProjectInfo? {
    return getTrackedProjects().find { it.projectId == projectId }
  }

  /**
   * Retrieves the project by id blocking
   *
   * @param projectId the project id text
   * @return the project info
   */
  fun getProjectByIdBlocking(projectId: String): ProjectInfo? = runBlocking {
    getProjectById(projectId)
  }

  /**
   * Retrieves the project by directory
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectDir the project dir text
   * @return the project info
   */
  suspend fun getProjectByDirectory(projectDir: String): ProjectInfo? {
    return getTrackedProjects().find { it.projectDir == projectDir }
  }

  /**
   * Retrieves the project by directory blocking
   *
   * @param projectDir the project dir text
   * @return the project info
   */
  fun getProjectByDirectoryBlocking(projectDir: String): ProjectInfo? = runBlocking {
    getProjectByDirectory(projectDir)
  }

  /**
   * Retrieves the projects by types
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectType the project type text
   * @return a collection of project infos
   */
  suspend fun getProjectsByType(projectType: String): List<ProjectInfo> {
    return getTrackedProjects().filter { it.projectType == projectType }
  }

  /**
   * Retrieves the projects by type blockings
   *
   * @param projectType the project type text
   * @return a collection of project infos
   */
  fun getProjectsByTypeBlocking(projectType: String): List<ProjectInfo> = runBlocking {
    getProjectsByType(projectType)
  }

  /**
   * Retrieves the tracked projects flows
   *
   * @return a collection of list<project info>s
   */
  fun getTrackedProjectsFlow(): Flow<List<ProjectInfo>> {
    return context.dataStore.data.map { preferences ->
      val projectsJson = preferences[PROJECTS_KEY] ?: "[]"
      parseProjectsFromJson(projectsJson)
    }
  }

  /**
   * Indicates whether project tracked
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projectDir the project dir text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  suspend fun isProjectTracked(projectDir: String): Boolean {
    return getTrackedProjects().any { it.projectDir == projectDir }
  }

  /**
   * Indicates whether project tracked blocking
   *
   * @param projectDir the project dir text
   * @return `true` if the operation succeeded or condition is met; `false` otherwise
   */
  fun isProjectTrackedBlocking(projectDir: String): Boolean = runBlocking {
    isProjectTracked(projectDir)
  }

  /**
   * Performs the and track external projectses operation
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param directory the directory as a [File]
   * @return a collection of project infos
   */
  suspend fun scanAndTrackExternalProjects(directory: File): List<ProjectInfo> {
    val newlyTracked = mutableListOf<ProjectInfo>()

    if (!directory.exists() || !directory.isDirectory) {
      return newlyTracked
    }

    directory.listFiles()?.forEach { subDir ->
      if (subDir.isDirectory) {
        val buildFile = File(subDir, "build.gradle")
        val buildKtsFile = File(subDir, "build.gradle.kts")

        if (buildFile.exists() || buildKtsFile.exists()) {
          if (!isProjectTracked(subDir.absolutePath)) {
            val projectInfo = createExternalProjectInfo(subDir)
            addProject(projectInfo, ProjectSource.EXTERNAL)
            newlyTracked.add(projectInfo)
          }
        }
      }
    }

    return newlyTracked
  }

  /**
   * Performs the and track external projects blockings operation
   *
   * @param directory the directory as a [File]
   * @return a collection of project infos
   */
  fun scanAndTrackExternalProjectsBlocking(directory: File): List<ProjectInfo> = runBlocking {
    scanAndTrackExternalProjects(directory)
  }

  /**
   * Creates a new instance of template project info
   *
   * @param projectName the project name text
   * @param projectDir the project dir text
   * @param projectType the project type text
   * @return the project info
   */
  fun createTemplateProjectInfo(
      projectName: String,
      projectDir: String,
      projectType: String,
  ): ProjectInfo {
    return ProjectInfo(
        projectId = generateProjectId(),
        projectName = projectName,
        projectDir = projectDir,
        projectType = projectType,
    )
  }

  /**
   * Creates a new instance of external project info
   *
   * @param projectDir the project dir as a [File]
   * @return the project info
   */
  private fun createExternalProjectInfo(projectDir: File): ProjectInfo {
    val projectName = sanitizeProjectName(projectDir.name)
    return ProjectInfo(
        projectId = generateProjectId(),
        projectName = projectName,
        projectDir = projectDir.absolutePath,
        projectType = "External",
    )
  }

  /**
   * Creates a new instance of project id
   *
   * @return the string
   */
  private fun generateProjectId(): String {
    return "project_${UUID.randomUUID().toString().replace("-", "").substring(0, 8)}"
  }

  /**
   * Validates that project name
   *
   * @param name the name text
   * @return the string
   */
  private fun sanitizeProjectName(name: String): String {
    return name
        .replace("_", " ")
        .replace("-", " ")
        .split(" ")
        .joinToString(" ") { word ->
          word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
        .trim()
  }

  /**
   * Sets the projects
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @param projects the collection of projects
   */
  private suspend fun saveProjects(projects: List<ProjectInfo>) {
    context.dataStore.edit { preferences ->
      val projectsJson = convertProjectsToJson(projects)
      preferences[PROJECTS_KEY] = projectsJson
    }
  }

  /**
   * Converts the projects to json
   *
   * @param projects the collection of projects
   * @return the string
   */
  private fun convertProjectsToJson(projects: List<ProjectInfo>): String {
    val jsonBuilder = StringBuilder()
    jsonBuilder.append("[")

    projects.forEachIndexed { index, project ->
      if (index > 0) jsonBuilder.append(",")
      jsonBuilder.append("{")
      jsonBuilder.append("\"projectId\":\"${project.projectId}\",")
      jsonBuilder.append("\"projectName\":\"${project.projectName}\",")
      jsonBuilder.append("\"projectDir\":\"${project.projectDir}\",")
      jsonBuilder.append("\"projectType\":\"${project.projectType}\"")
      jsonBuilder.append("}")
    }

    jsonBuilder.append("]")
    return jsonBuilder.toString()
  }

  /**
   * Converts the projects from jsons
   *
   * @param json the json text
   * @return a collection of project infos
   */
  private fun parseProjectsFromJson(json: String): List<ProjectInfo> {
    if (json == "[]" || json.isBlank()) {
      return emptyList()
    }

    try {
      val projects = mutableListOf<ProjectInfo>()
      val cleanJson = json.trim()

      if (cleanJson.startsWith("[") && cleanJson.endsWith("]")) {
        val content = cleanJson.substring(1, cleanJson.length - 1)
        if (content.isNotBlank()) {
          val projectStrings = content.split("},{")

          projectStrings.forEach { projectString ->
            val cleanString = projectString.replace("{", "").replace("}", "")
            val parts = cleanString.split(",")

            if (parts.size >= 4) {
              val projectId = extractValue(parts[0])
              val projectName = extractValue(parts[1])
              val projectDir = extractValue(parts[2])
              val projectType = extractValue(parts[3])

              if (
                  projectId.isNotBlank() &&
                      projectName.isNotBlank() &&
                      projectDir.isNotBlank() &&
                      projectType.isNotBlank()
              ) {
                projects.add(ProjectInfo(projectId, projectName, projectDir, projectType))
              }
            }
          }
        }
      }

      return projects
    } catch (e: Exception) {
      return emptyList()
    }
  }

  /**
   * Filters the value
   *
   * @param pair the pair text
   * @return the string
   */
  private fun extractValue(pair: String): String {
    val colonIndex = pair.indexOf(":")
    return if (colonIndex != -1) {
      pair.substring(colonIndex + 1).trim().replace("\"", "")
    } else {
      ""
    }
  }

  /**
   * Performs the operation
   *
   * This is a suspend function and can only be called from a coroutine.
   */
  suspend fun clearAllProjects() {
    context.dataStore.edit { preferences -> preferences.remove(PROJECTS_KEY) }
  }

  /** Performs the blocking operation */
  fun clearAllProjectsBlocking() = runBlocking { clearAllProjects() }

  /**
   * Retrieves the project count
   *
   * This is a suspend function and can only be called from a coroutine.
   *
   * @return the int
   */
  suspend fun getProjectCount(): Int {
    return getTrackedProjects().size
  }

  /**
   * Retrieves the project count blocking
   *
   * @return the int
   */
  fun getProjectCountBlocking(): Int = runBlocking { getProjectCount() }
}
