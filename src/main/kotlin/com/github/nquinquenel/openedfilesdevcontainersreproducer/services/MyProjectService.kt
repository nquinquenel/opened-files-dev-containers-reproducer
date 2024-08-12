package com.github.nquinquenel.openedfilesdevcontainersreproducer.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.github.nquinquenel.openedfilesdevcontainersreproducer.MyBundle

@Service(Service.Level.PROJECT)
class MyProjectService(private val project: Project) {

    init {
        thisLogger().info(MyBundle.message("projectService", project.name))
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    fun getOpenedProjects(): String {
        val result = StringBuilder()
        FileEditorManager.getInstance(project).openFiles.forEach { result.append("<br/>${it.name}") }
        return result.toString()
    }
}
