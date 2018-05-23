package com.example.csh.mvptest.twouserinfo;

import com.example.csh.mvptest.base.MvpView;
import com.example.csh.mvptest.entity.FunctionItem;

import java.util.List;

public interface RecordView extends MvpView {
    /**
     * 显示所有录单操作的方法
     *
     * @param functionItems
     */
    void showFunctionList(List<FunctionItem> functionItems);
}
