package com.example.csh.mvptest.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csh.mvptest.utils.LoadingDialog;
import com.example.csh.mvptest.widget.Tip;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * <p/>作者： lxg
 * <p/>创建时间: 17/10/11 16:07.
 */

public abstract class BaseMvpFragment<P extends Presenter> extends Fragment implements MvpView {
    private static final String TAG = BaseMvpFragment.class.getSimpleName();
    protected P presenter;
    private Unbinder unbinder;
    protected CompositeDisposable mCompositeDisposable;
    private LoadingDialog mLoadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mCompositeDisposable = new CompositeDisposable();
        presenter = createPresent();
        return view;
    }

    protected abstract P createPresent();

    protected abstract int getLayoutId();
    //执行的某些初始化操作
    protected void init() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        init();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.newInstance();
        }
        mLoadingDialog.show(getChildFragmentManager(), TAG);
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showTip(String message) {
        Tip.showTip(getActivity(), message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();
        unbinder.unbind();
        mCompositeDisposable.clear();
    }
}
