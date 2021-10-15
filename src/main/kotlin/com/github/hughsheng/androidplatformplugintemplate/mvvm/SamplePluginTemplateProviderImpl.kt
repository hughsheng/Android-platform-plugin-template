package com.github.hughsheng.androidplatformplugintemplate.mvvm
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.mvvmActivityTemplate

/**
 * @author: tl
 * @date: 2021/10/11 18:00
 * @discription:
 **/
class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        // activity的模板
        mvvmActivityTemplate,
    )
}