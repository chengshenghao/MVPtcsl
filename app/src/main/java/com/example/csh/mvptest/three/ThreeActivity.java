package com.example.csh.mvptest.three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.csh.mvptest.R;
import com.example.csh.mvptest.twouserinfo.RecordFragment;

import static com.example.csh.mvptest.utils.ActivityUtils.addFragment;
/*
* 第一次尝试编写
* */
public class ThreeActivity extends AppCompatActivity {

    private ThreeFragment mThreeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        mThreeFragment = ThreeFragment.newInstance();
        if (mThreeFragment != null) {
            addFragment(getFragmentManager(), R.id.fl_main_content, mThreeFragment);
        }
    }
}
