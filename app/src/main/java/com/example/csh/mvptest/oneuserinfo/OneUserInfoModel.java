package com.example.csh.mvptest.oneuserinfo;

import com.example.csh.mvptest.entity.UserInfo;

public class OneUserInfoModel implements OneUserInfoContract.UserInfoModel {

    @Override
    public UserInfo getUsers(String token) throws Exception {
        // 模拟数据
        Thread.sleep(2000);
        return new UserInfo("Darren", "14726932514");
    }
}