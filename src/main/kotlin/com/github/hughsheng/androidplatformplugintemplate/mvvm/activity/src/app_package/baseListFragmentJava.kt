package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:35
 * @discription:
 **/
fun baseListFragmentJava (
    appPackageName:String,
    uiPackageName:String,
    hiltPackageName:String,
    pageName:String
)="""
    package ${uiPackageName};
    import ${hiltPackageName}.${pageName}ViewModel;
    import com.guyuan.handlein.base.ui.fragment.BaseListFragment;
    import ${appPackageName}.databinding.Fragment${pageName}ListBinding;

    public class ${pageName}ListFragment extends BaseListFragment<Object,Fragment${pageName}ListBinding,${pageName}ViewModel> {

        @Override
        protected void initView() {
            
        }

        @Override
        protected void refresh() {

        }

        @Override
        protected void loadMore() {

        }

        @Override
        protected boolean isPullEnable() {
            return false;
        }

        @Override
        protected boolean isLoadMoreEnable() {
            return false;
        }

        @Override
        protected int getVariableId() {
            return 0;
        }
    }
"""