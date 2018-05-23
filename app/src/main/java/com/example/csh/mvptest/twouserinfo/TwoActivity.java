package com.example.csh.mvptest.twouserinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.csh.mvptest.R;

import static com.example.csh.mvptest.utils.ActivityUtils.addFragment;

public class TwoActivity extends AppCompatActivity {

    private RecordFragment mDefultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two2);
        mDefultFragment = RecordFragment.newInstance();
        if (mDefultFragment != null) {
            addFragment(getFragmentManager(), R.id.fl_main_content, mDefultFragment);
        }
    }
}
