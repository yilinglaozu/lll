package com.baway.liujingyuan;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import net.AsyncTaskk;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bean.UserBean;
import mvp.intface.IntFace;
import mvp.presenter.Presenter;

public class MainActivity extends BaseActivity implements IntFace.ModelPresenterInterFace, IntFace.ModelViewInterFace {

    private EditText edit_name,edit_pass;
    private TextView textView;
    private Button button;
    private List<UserBean > list=new ArrayList<>();
    private Presenter modelpresenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    //视图
    @Override
    protected void initview() {
        edit_name=findViewById(R.id.zhanghao);
        edit_pass=findViewById(R.id.mima);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.btn);

        modelpresenter=new Presenter();


        //逻辑
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,RegstActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit_name.getText().toString().trim();
                String pass=edit_pass.getText().toString().trim();
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(pass) ){
                    Toast.makeText(MainActivity.this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if ("1179348728".equals(name) || "123".equals(pass) ){
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {

        AsyncTaskk.getInstance().getData("http://172.17.8.100/small/user/v1/login"
                , new AsyncTaskk.AsyncCallback() {
                    @Override
                    public void onError(int code, String msg) {

                    }

                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        UserBean userBean = gson.fromJson(result, UserBean.class);

                    }
                });

    }


    @Override
    public void toshow(List<UserBean> list) {

    }
}
