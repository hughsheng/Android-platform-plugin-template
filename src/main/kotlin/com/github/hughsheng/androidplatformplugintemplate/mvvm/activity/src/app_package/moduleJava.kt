package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:48
 * @discription:
 **/
fun moduleJava(
appPackageName:String,
apiPackageName:String,
pageName:String,
hiltPackageName:String
)="""
    package ${hiltPackageName};

    import ${appPackageName}.base.hilt.BaseModule;
    import ${apiPackageName}.${pageName}ApiService;
    import ${hiltPackageName}.${pageName}Repository;

    import dagger.Module;
    import dagger.Provides;
    import dagger.hilt.InstallIn;
    import dagger.hilt.android.components.ViewModelComponent;


    @Module
    @InstallIn(ViewModelComponent.class)
    public class ${pageName}Module extends BaseModule {

      @Provides
      public ${pageName}ApiService provides${pageName}ApiService() {
        return retrofit.create(${pageName}ApiService.class);
      }

      @Provides
      public ${pageName}Repository provides${pageName}Repository(${pageName}ApiService apiService) {
        return new ${pageName}Repository(apiService);
      }
    }
"""