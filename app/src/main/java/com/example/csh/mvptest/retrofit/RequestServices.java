package com.example.csh.mvptest.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LHD on 2016/6/25.
 */
public interface RequestServices {
    //请求方式为GET，参数为basil2style，因为没有变量所以下面getString方法也不需要参数
    @GET("basil2style") 
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<ResponseBody> getString();
}