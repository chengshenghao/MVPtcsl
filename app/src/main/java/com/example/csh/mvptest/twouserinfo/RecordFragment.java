package com.example.csh.mvptest.twouserinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.adpter.FunctionAdapter;
import com.example.csh.mvptest.base.BaseMvpFragment;
import com.example.csh.mvptest.entity.FunctionItem;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 快捷入口
 * <p/>作者： lxg
 * <p/>创建时间: 17/11/02 9:24.
 * 泛型版
 */

public class RecordFragment extends BaseMvpFragment<RecordPresenter>
        implements RecordView {//FunctionAdapter.OnClickHomeItemListener,

    @BindView(R.id.rv_fun_list)
    RecyclerView rvFunList;

    public static RecordFragment newInstance() {
        Bundle args = new Bundle();
        RecordFragment fragment = new RecordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected RecordPresenter createPresent() {
        return new RecordPresenterImpl(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_function;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.functionListData();
    }

    @Override
    public void showFunctionList(List<FunctionItem> functionItems) {
        rvFunList.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        FunctionAdapter functionAdapter = new FunctionAdapter(functionItems);
        rvFunList.setAdapter(functionAdapter);
//        functionAdapter.setOnClickHomeItemListener(this);
    }

    @OnClick(R.id.iv_break)
    public void onClickBreak() {
        getActivity().finish();
    }

//    @Override
//    public void onClickHomeItem(int position) {
//        switch (position) {
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            default:
//                break;
//        }
//    }
}
