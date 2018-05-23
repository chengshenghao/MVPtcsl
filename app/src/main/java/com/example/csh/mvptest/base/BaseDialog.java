package com.example.csh.mvptest.base;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.csh.mvptest.R;
import com.example.csh.mvptest.utils.ScreenUtils;


/**
 * Created by leixingguo on 2017/3/16.
 */

public abstract class BaseDialog extends DialogFragment {

    TextView mTextTitle;
    protected FrameLayout mFrameContent;
    LinearLayout mLinearBottom;
    FrameLayout mLinearTop;
    TextView mTextConfirm;
    TextView mTextCancel;
    ImageView mImgDismissDialog;

    protected int screenHeight;
    protected int screenWidth;

    private View.OnClickListener mOnClickConfirmListener;

    //对话框默认从右侧弹出
    private AnimationEnum animationEnum = AnimationEnum.ANIM_RIGHT;

    protected enum AnimationEnum {
        ANIM_LEFT, ANIM_RIGHT
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_dialog, container, false);
        mTextTitle = view.findViewById(R.id.text_title);
        mFrameContent = view.findViewById(R.id.frame_content);
        mLinearBottom = view.findViewById(R.id.ll_bottom);
        mTextConfirm = view.findViewById(R.id.text_confirm);
        mTextCancel = view.findViewById(R.id.text_cancel);
        mLinearTop = view.findViewById(R.id.fl_top);
        mImgDismissDialog = view.findViewById(R.id.img_return);
        View childView = getChildView();
        mFrameContent.addView(childView);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        screenHeight = ScreenUtils.getScreenHeight(getActivity());
        screenWidth = ScreenUtils.getScreenWidth(getActivity());
        mTextConfirm.setOnClickListener(mOnClickConfirmListener);
        mTextCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mImgDismissDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(getLayoutWidth(), getLayoutHeight());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected int getLayoutWidth() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    protected int getLayoutHeight() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    protected abstract View getChildView();

    protected final void showBottom(boolean isShow) {
        if (isShow) {
            mLinearBottom.setVisibility(View.VISIBLE);
        } else {
            mLinearBottom.setVisibility(View.GONE);
        }
    }

    protected final void showTop(boolean isShow) {
        if (isShow) {
            mLinearTop.setVisibility(View.VISIBLE);
        } else {
            mLinearTop.setVisibility(View.GONE);
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (!isAdded()) {
            super.show(manager, tag);
        }
    }

    @Override
    public void dismiss() {
        if (isAdded()) {
            super.dismiss();
        }
    }

    protected final void setTitle(String title) {
        mTextTitle.setText(title);
    }

    public void setClickConfirmListener(View.OnClickListener clickConfirmListener) {
        mOnClickConfirmListener = clickConfirmListener;
    }
}
