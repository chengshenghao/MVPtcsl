package com.example.csh.mvptest.three;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.base.BaseMvpFragment;
import com.example.csh.mvptest.base.Presenter;
import com.example.csh.mvptest.entity.FunctionItem;
import com.example.csh.mvptest.twouserinfo.RecordFragment;
import com.example.csh.mvptest.twouserinfo.RecordPresenter;
import com.example.csh.mvptest.twouserinfo.RecordPresenterImpl;
import com.example.csh.mvptest.twouserinfo.RecordView;

import java.util.List;

import butterknife.BindView;

public class ThreeFragment extends BaseMvpFragment<ThreePresenter> implements ThreeView {
    @BindView(R.id.tv)
    TextView textView;
    public static ThreeFragment newInstance() {
        Bundle args = new Bundle();
        ThreeFragment fragment = new ThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected ThreePresenter createPresent() {
        return new ThreePresenterImpl(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getResult();
    }

    @Override
    public void showResult(String string) {
        textView.setText(string);
    }
}
