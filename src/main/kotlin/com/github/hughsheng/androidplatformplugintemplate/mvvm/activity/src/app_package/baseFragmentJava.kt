package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:45
 * @discription:
 **/
fun baseFragmentJava(
    appPackageName: String,
    uiPackageName: String,
    hiltPackageName: String,
    pageName: String
) = """
    package ${uiPackageName};

    import ${hiltPackageName}.${pageName}ViewModel;
    import com.guyuan.handlein.base.ui.fragment.BaseFragment;
    import ${appPackageName}.databinding.Fragment${pageName}Binding;
    
    public class ${pageName}Fragment extends BaseFragment<Fragment${pageName}Binding, ${pageName}ViewModel> {

        @Override
        protected void initialization() {
            
        }

        @Override
        protected int getVariableId() {
            return 0;
        }

        @Override
        protected int getLayoutID() {
            return 0;
        }
    }

"""