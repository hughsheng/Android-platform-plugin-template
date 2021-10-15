package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.res.layout.mvvmFragmentXml
import com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package.*
import java.io.File

/**
 * @author: tl
 * @date: 2021/10/11 18:11
 * @discription:
 **/
fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    appPackageName: String,
    pageName: String,
    apiPackageName: String,
    uiPackageName: String,
    dataPackageName: String,
    hiltPackageName: String,
    activityType: ActivityType,
    fragmentType: FragmentType
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    //根据选择的类型创建activity
    var mvvmActivity = ""
    if (activityType == ActivityType.BaseToolbarActivity) {
        mvvmActivity = baseNoToolbarActivityJava(uiPackageName, hiltPackageName, pageName)
    } else if (activityType == ActivityType.BaseNoToolbarActivity) {
        mvvmActivity = baseToolbarActivityJava(uiPackageName, hiltPackageName, pageName)
    }


//    generateManifest(
//        moduleData = moduleData,
//        activityClass = "${pageName}.Activity",
//        activityTitle = "${uiPackageName}.${pageName}.Activity",
//        packageName = appPackageName,
//        isLauncher = false,
//        hasNoActionBar = false,
//        generateActivityTitle = true,
//        requireTheme = false,
//        useMaterial2 = false
//    )

    //根据选择的类型创建fragment
    var mvvmFragment = ""
    if (fragmentType == FragmentType.BaseFragment) {
        mvvmFragment = baseFragmentJava(appPackageName,uiPackageName, hiltPackageName, pageName)
    } else if (fragmentType == FragmentType.BaseListFragment) {
        mvvmFragment = baseListFragmentJava(appPackageName,uiPackageName, hiltPackageName, pageName)
    }


    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${toLowerCaseFirstOne(pageName)}/ui/${pageName}Activity.${ktOrJavaExt}"))

    //保存fragment
    if (fragmentType == FragmentType.BaseFragment) {
        save(mvvmFragment, srcOut.resolve("${toLowerCaseFirstOne(pageName)}/ui/${pageName}Fragment.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmFragmentXml(), resOut.resolve("layout/fragment_${toLowerCaseFirstOne(pageName)}.xml"))
    } else if (fragmentType == FragmentType.BaseListFragment) {
        save(mvvmFragment, srcOut.resolve("${toLowerCaseFirstOne(pageName)}/ui/${pageName}ListFragment.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmFragmentXml(), resOut.resolve("layout/fragment_${toLowerCaseFirstOne(pageName)}_list.xml"))
    }



    // 保存viewModel
    save(
        viewModelJava(hiltPackageName, appPackageName, pageName),
        srcOut.resolve("${toLowerCaseFirstOne(pageName)}/hilt/${pageName}ViewModel.${ktOrJavaExt}")
    )

    //todo 创建data文件夹
    createDirectory(File("${toLowerCaseFirstOne(pageName)}/data"))

    // 保存repository
    save(
        repositoryJava(hiltPackageName, apiPackageName, pageName),
        srcOut.resolve("${toLowerCaseFirstOne(pageName)}/hilt/${pageName}Repository.${ktOrJavaExt}")
    )

    //保存apiService
    save(
        apiServiceJava(apiPackageName, pageName),
        srcOut.resolve("${toLowerCaseFirstOne(pageName)}/api/${pageName}ApiService.${ktOrJavaExt}")
    )

    //保存module
    save(
        moduleJava(appPackageName, apiPackageName, pageName, hiltPackageName),
        srcOut.resolve("${toLowerCaseFirstOne(pageName)}/hilt/${pageName}Module.${ktOrJavaExt}")
    )
}

fun slashedPackageName(uiPackageName: String): String {
    return uiPackageName.replace(".", "/")
}

