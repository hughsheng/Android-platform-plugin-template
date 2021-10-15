package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @author: tl
 * @date: 2021/10/11 18:07
 * @discription:
 **/
val mvvmActivityTemplate
    get() = template {
        name = "MVVM"
        description = "一键生成MVVM模板"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val pageName = stringParameter {
            name = "Page Name"
            default = "Test"
            help = "请填写页面名,如填写 Test,会自动生成 MainActivity, MainFragment等文件"
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val activityType = enumParameter<ActivityType> {
            name = "Activity Type"
            default = ActivityType.BaseToolbarActivity
            help = "请选择activity基类"
        }

        val fragmentType = enumParameter<FragmentType> {
            name = "Fragment Type"
            default = FragmentType.BaseFragment
            help = "请fragment基类"
        }

        //APP包名
        val appPackageName = stringParameter {
            name = "appPackage name"
            default = "com.idriverplus.landship"
            constraints = listOf(Constraint.PACKAGE)
        }

        //当前文件夹名
        val createPackageName = stringParameter {
            name = "package name"
            suggest = { packageName }
            default = "com.idriverplus.landship"
            constraints = listOf(Constraint.PACKAGE)
        }


        val apiPackageName = stringParameter {
            name = "Api Name"
            suggest = { createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".api" }
            default = createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".api"
            constraints = listOf(Constraint.PACKAGE)
        }

        val uiPackageName = stringParameter {
            name = "UI Name"
            suggest = { createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".ui" }
            default = createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".ui"
            constraints = listOf(Constraint.PACKAGE)
        }

        val dataPackageName = stringParameter {
            name = "Data Name"
            suggest = { createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".data" }
            default = createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".data"
            constraints = listOf(Constraint.PACKAGE)
        }

        val hiltPackageName = stringParameter {
            name = "Hilt Name"
            suggest = { createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".hilt" }
            default = createPackageName.value + "." + toLowerCaseFirstOne(pageName.value) + ".hilt"
            constraints = listOf(Constraint.PACKAGE)
        }

        widgets(
            TextFieldWidget(pageName),
            EnumWidget(activityType),
            EnumWidget(fragmentType),
            TextFieldWidget(apiPackageName),
            TextFieldWidget(uiPackageName),
            TextFieldWidget(dataPackageName),
            TextFieldWidget(hiltPackageName),
            TextFieldWidget(appPackageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                data as ModuleTemplateData,
                appPackageName.value,
                pageName.value,
                apiPackageName.value,
                uiPackageName.value,
                dataPackageName.value,
                hiltPackageName.value,
                activityType.value,
                fragmentType.value
            )
        }
    }

enum class ActivityType {
    BaseToolbarActivity, BaseNoToolbarActivity
}

enum class FragmentType {
    BaseFragment, BaseListFragment
}

fun toLowerCaseFirstOne(s: String): String {
    return if (Character.isLowerCase(s[0])) s else StringBuilder().append(
        Character.toLowerCase(
            s[0]
        )
    ).append(s.substring(1)).toString()
}
