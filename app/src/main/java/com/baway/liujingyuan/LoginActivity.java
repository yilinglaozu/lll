package com.baway.liujingyuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import base.BaseActivity;

public class LoginActivity extends BaseActivity {


    private ImageView image;
    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initview() {
        image=findViewById(R.id.imager);

        Glide.with(this).load(R.mipmap.mm)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(image);

    }

    @Override
    protected void initData() {

    }
}
