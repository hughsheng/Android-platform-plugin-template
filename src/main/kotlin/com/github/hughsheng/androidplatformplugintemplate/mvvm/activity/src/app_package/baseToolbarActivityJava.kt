package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:42
 * @discription:
 **/
fun baseToolbarActivityJava(
    uiPackageName: String,
    hiltPackageName:String,
    pageName:String
) = """
    package ${uiPackageName};

    import android.os.Bundle;
    import ${hiltPackageName}.${pageName}ViewModel;
    import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
    import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;
    import dagger.hilt.android.AndroidEntryPoint;

    @AndroidEntryPoint
    public class ${pageName}Activity extends BaseToolbarActivity<ActivityWithToolbarBinding, ${pageName}ViewModel> {
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