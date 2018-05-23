package com.example.csh.mvptest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.csh.mvptest.oneuserinfo.OneActivity;
import com.example.csh.mvptest.oneuserinfo.OneUserInfoPresenter;
import com.example.csh.mvptest.retrofit.RetrofitActivity;
import com.example.csh.mvptest.three.ThreeActivity;
import com.example.csh.mvptest.twouserinfo.TwoActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private OneUserInfoPresenter presenter;
    // user presenter{
    @BindView(R.id.imageView)
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initImage();
    }

    //RXJAVA
    private void initImage() {
        Observable.just("http://60.29.131.62:11000/ZCTJFirstCHospital/appicon/icon_1.png")
                .map(new Function<String, Bitmap>() {
                    // 下载网络图片
                    @Override
                    public Bitmap apply(@NonNull String imagePath) throws Exception {
                        URL url = new URL(imagePath);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        InputStream inputStream = connection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        inputStream.close();
                        return bitmap;
                    }
                }).map(new Function<Bitmap, Bitmap>() {// 给图片加水印
            @Override
            public Bitmap apply(@NonNull Bitmap bitmap) throws Exception {
//                bitmap = BitmapUtils.drawText2Bitmap(bitmap, "RxJava");
                return bitmap;
            }
        }).subscribeOn(Schedulers.io())// 上面之前的执行在子线程中（线程的调度）
                .observeOn(AndroidSchedulers.mainThread())// 下面之后的执行在主线程中（线程的调度）
                .subscribe(new Consumer<Bitmap>() {// 显示图片
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        mImageView.setImageBitmap(bitmap);
                    }
                });
    }


    public void one(View view) {
        Intent intent = new Intent(this, OneActivity.class);
        startActivity(intent);
    }

    public void two(View view) {
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }
    public void three(View view) {
        Intent intent = new Intent(this, ThreeActivity.class);
        startActivity(intent);
    }
    public void Retrofit(View view) {
        Intent intent = new Intent(this, RetrofitActivity.class);
        startActivity(intent);
    }


}
