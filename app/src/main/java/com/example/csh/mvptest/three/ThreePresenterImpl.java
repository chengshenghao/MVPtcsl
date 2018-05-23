package com.example.csh.mvptest.three;

import android.content.Context;

import com.example.csh.mvptest.base.BaseMvpPresenter;

public class ThreePresenterImpl extends BaseMvpPresenter<ThreeView> implements ThreePresenter {
    public ThreePresenterImpl(Context context) {
        super(context);
    }

    @Override
    public void getResult() {
        mView.showResult("我是获取到的结果");
    }
}
