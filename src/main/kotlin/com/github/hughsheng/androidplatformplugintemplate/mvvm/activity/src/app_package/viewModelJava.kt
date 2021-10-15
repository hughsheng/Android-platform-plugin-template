package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:57
 * @discription:
 **/
fun viewModelJava(
    hiltPackageName: String,
    appPackageName: String,
    pageName: String
) = """
    package ${hiltPackageName};
    import com.example.httplibrary.bean.ErrorResultBean;
    import com.example.mvvmlibrary.base.data.BaseViewModel;
    import com.guyuan.handlein.base.util.CommonUtils;
    import ${appPackageName}.base.api.RxJavaHelper;
    import ${hiltPackageName}.${pageName}Repository;
    import javax.inject.Inject;
    import dagger.hilt.android.lifecycle.HiltViewModel;
    import io.reactivex.rxjava3.disposables.Disposable;
    import io.reactivex.rxjava3.functions.Consumer;
    import okhttp3.RequestBody;

    @HiltViewModel
    public class ${pageName}ViewModel extends BaseViewModel {

        public ${pageName}Repository repository;

        @Inject
        public ${pageName}ViewModel(${pageName}Repository repository) {
            this.repository = repository;
        }


    }
""".trimIndent()