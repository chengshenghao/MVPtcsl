package com.example.csh.mvptest.twouserinfo;

import com.example.csh.mvptest.base.Presenter;

/**
 * <p/>作者： lxg
 * <p/>创建时间: 17/11/02 11:05.
 */

public interface RecordPresenter extends Presenter<RecordView> {
    /**
     * 所有录单操作
     */
    void functionListData();
}