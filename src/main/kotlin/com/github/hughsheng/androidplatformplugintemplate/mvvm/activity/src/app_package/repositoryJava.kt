package com.github.hughsheng.androidplatformplugintemplate.mvvm.activity.src.app_package

/**
 * @author: tl
 * @date: 2021/10/12 15:51
 * @discription:
 **/
fun repositoryJava(
    dataPackageName: String,
    apiPackageName: String,
    pageName: String
) = """
package ${dataPackageName};

import com.example.httplibrary.bean.ResultBean;
import ${apiPackageName}.${pageName}ApiService;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;

public class ${pageName}Repository  {
  private final ${pageName}ApiService apiService ;

  public ${pageName}Repository(${pageName}ApiService apiService) {
    this.apiService = apiService;
  }

}
"""