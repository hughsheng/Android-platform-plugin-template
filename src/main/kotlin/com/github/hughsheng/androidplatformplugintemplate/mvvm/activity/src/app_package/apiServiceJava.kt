package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:27
 * @discription:
 **/
fun apiServiceJava(
    apiPackageName:String,
    pageName:String
) = """
    package ${apiPackageName};

    import com.example.httplibrary.bean.ResultBean;
    import com.idriverplus.landship.base.api.BaseApiService;
    import io.reactivex.rxjava3.core.Observable;
    import okhttp3.RequestBody;
    import retrofit2.http.Body;
    import retrofit2.http.POST;

    public interface ${pageName}ApiService {
      
    }
"""