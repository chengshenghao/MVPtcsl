package com.example.csh.mvptest.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.entity.FunctionItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 功能列表适配器
 * <p/>作者： lxg
 * <p/>创建时间: 17/11/01 10:04.
 */

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.HomeHolder> {
    private List<FunctionItem> mHomeItemList;
    private OnClickHomeItemListener mOnClickHomeItemListener;

    public FunctionAdapter(List<FunctionItem> homeItemList) {
        mHomeItemList = homeItemList;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HomeHolder homeHolder = new HomeHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false));
        return homeHolder;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, final int position) {
        holder.dataBind(mHomeItemList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickHomeItemListener != null) {
                    mOnClickHomeItemListener.onClickHomeItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHomeItemList.size();
    }

    public void setOnClickHomeItemListener(OnClickHomeItemListener onClickHomeItemListener) {
        mOnClickHomeItemListener = onClickHomeItemListener;
    }

    static class HomeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_function)
        ImageView mFunctionImage;
        @BindView(R.id.tv_function_name)
        TextView mFunctionName;
        @BindView(R.id.tv_label_count)
        TextView tvCount;

        public HomeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void dataBind(FunctionItem homeItem) {
            itemView.setEnabled(homeItem.isEnabled());
            mFunctionName.setText(homeItem.getName());
            mFunctionImage.setImageResource(homeItem.getImageId());
            if (homeItem.getCount() > 0) {
                tvCount.setText(homeItem.getCount());
                tvCount.setVisibility(View.VISIBLE);
            } else {
                tvCount.setVisibility(View.GONE);
            }
        }
    }

    public interface OnClickHomeItemListener {
        void onClickHomeItem(int position);
    }
}
