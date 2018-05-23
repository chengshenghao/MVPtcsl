package com.example.csh.mvptest.base;

import android.content.Context;

public interface MvpView {
    Context context();

    void showTip(String message);

    void showLoading();

    void hideLoading();
}