package com.example.csh.mvptest.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.base.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 加载对话框
 * <p/>作者： lxg
 * <p/>创建时间: 18/02/08 16:23.
 */

public class LoadingDialog extends BaseDialog {

    private static final String KEY_MSG = "msg";
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    Unbinder unbinder;

    public static LoadingDialog newInstance() {
        Bundle args = new Bundle();
        LoadingDialog fragment = new LoadingDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public static LoadingDialog newInstance(String msg) {
        Bundle args = new Bundle();
        args.putString(KEY_MSG, msg);
        LoadingDialog fragment = new LoadingDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View getChildView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_loding, null, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArguments().getString(KEY_MSG, getActivity().getString(R.string.default_loading_msg));
        setCancelable(false);
        showBottom(false);
        showTop(false);
    }

    @Override
    protected int getLayoutWidth() {
        return (int) (screenHeight * 0.4);
    }

    @Override
    protected int getLayoutHeight() {
        return (int) (screenHeight * 0.3);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
