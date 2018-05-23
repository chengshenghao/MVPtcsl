package com.example.csh.mvptest.twouserinfo;

import android.content.Context;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.base.BaseMvpPresenter;
import com.example.csh.mvptest.entity.FunctionItem;

import java.util.ArrayList;
import java.util.List;


/**
 * <p/>作者： lxg
 * <p/>创建时间: 17/11/02 11:05.
 */

public class RecordPresenterImpl extends BaseMvpPresenter<RecordView> implements RecordPresenter {


    public RecordPresenterImpl(Context context) {
        super(context);
    }

    @Override
    public void functionListData() {
        Context context = mView.context();
        List<FunctionItem> homeItems = new ArrayList<>();
        FunctionItem homeItem = new FunctionItem();
        homeItem.setName(context.getString(R.string.purchase));
        homeItem.setEnabled(true);
        homeItem.setImageId(R.drawable.selector_ic_storage);
        homeItems.add(homeItem);
        homeItem = new FunctionItem();
        homeItem.setName(context.getString(R.string.outbound_order));
        homeItem.setEnabled(true);
        homeItem.setImageId(R.drawable.selector_ic_outbound_order);
        homeItems.add(homeItem);
        homeItem = new FunctionItem();
        homeItem.setName(context.getString(R.string.roughing));
        homeItem.setImageId(R.drawable.selector_ic_roughing);
        homeItems.add(homeItem);
        homeItem = new FunctionItem();
        homeItem.setEnabled(false);
        homeItem.setName(context.getString(R.string.store_check));
        homeItem.setImageId(R.drawable.selector_ic_store_check);
        homeItems.add(homeItem);

        mView.showFunctionList(homeItems);
    }
}
