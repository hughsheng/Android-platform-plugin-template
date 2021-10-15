package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:40
 * @discription:
 **/
fun baseNoToolbarActivityJava(
    uiPackageName:String,
    hiltPackageName:String,
    pageName:String
)="""
    package ${uiPackageName};

    import android.os.Bundle;

    import ${hiltPackageName}.${pageName}ViewModel;
    import com.guyuan.handlein.base.databinding.ActivityWithoutToolbarBinding;
    import com.guyuan.handlein.base.ui.activity.BaseNoToolbarActivity;
    import dagger.hilt.android.AndroidEntryPoint;

    @AndroidEntryPoint
    public class ${pageName}Activity extends BaseNoToolbarActivity<ActivityWithoutToolbarBinding,${pageName}ViewModel> {
        @Override
        protected void initFragment(Bundle savedInstanceState) {

        }

        @Override
        protected int getLayoutID() {
            return 0;
        }

        @Override
        protected int getVariableId() {
            return 0;
        }
    }
"""