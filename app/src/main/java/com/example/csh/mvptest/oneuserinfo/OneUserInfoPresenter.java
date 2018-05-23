package com.example.csh.mvptest.oneuserinfo;

import com.example.csh.mvptest.entity.UserInfo;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class OneUserInfoPresenter implements OneUserInfoContract.UserInfoPresenter {
    private OneUserInfoContract.UserInfoView userInfoView;
    private OneUserInfoContract.UserInfoModel userInfoModel;

    public OneUserInfoPresenter(OneUserInfoContract.UserInfoView userInfoView) {
        this.userInfoView = userInfoView;
        userInfoModel = new OneUserInfoModel();
    }

    @Override
    public void getUsers(String token) {
        // 应该是 RXJava + OkHttp + Retrofit + Dagger 结合
        userInfoView.onLoading();
        // 这里只用 RXJava 模拟一下
        Observable.just(token).map(new Function<String, UserInfo>() {
            @Override
            public UserInfo apply(@NonNull String token) throws Exception {
                return userInfoModel.getUsers(token);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfo>() {
                    @Override
                    public void accept(UserInfo userInfo) throws Exception {
                        userInfoView.onSucceed(userInfo);
                    }
                });
    }

}