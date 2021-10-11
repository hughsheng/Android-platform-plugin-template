package com.github.hughsheng.androidplatformplugintemplate.services

import com.intellij.openapi.project.Project
import com.github.hughsheng.androidplatformplugintemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
