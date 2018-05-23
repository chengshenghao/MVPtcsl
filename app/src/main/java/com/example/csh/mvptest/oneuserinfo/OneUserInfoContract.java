package com.example.csh.mvptest.oneuserinfo;

import com.example.csh.mvptest.entity.UserInfo;

public interface OneUserInfoContract {
    interface UserInfoView {
        void onLoading();
        void onError();
        void onSucceed(UserInfo userInfo);
    }
    // user presenter 层
    interface UserInfoPresenter {
        void getUsers(String token);
    }
    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface UserInfoModel {
        UserInfo getUsers(String token) throws Exception;
    }
}
