package com.example.csh.mvptest.oneuserinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.entity.UserInfo;
/*
* 基础版
* */
public class OneActivity extends AppCompatActivity implements OneUserInfoContract.UserInfoView{
    private OneUserInfoPresenter presenter;
    // user presenter{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        presenter = new OneUserInfoPresenter(this);
        presenter.getUsers("user token");
    }

    @Override
    public void onLoading() {
        // 正在联网获取加载中...
        Log.e("TAG", "加载中...");
    }

    @Override
    public void onError() {
        Log.e("TAG", "出错...");
    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        Log.e("TAG", "成功...");
    }

}
