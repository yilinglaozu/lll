package com.baway.liujingyuan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import base.BaseActivity;

public class RegstActivity extends BaseActivity {

    private EditText edit_name,edit_pass,edit_shou;
    private TextView textView;
    private Button button;


    @Override
    protected int initLayout() {
        return R.layout.activity_regst;
    }

    @Override
    protected void initview() {
        edit_shou=findViewById(R.id.shoujihao);
        edit_name=findViewById(R.id.zhanghao);
        edit_pass=findViewById(R.id.mima);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit_shou.getText().toString().trim();
                String pass=edit_pass.getText().toString().trim();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(pass) ){
                    Toast.makeText(RegstActivity.this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if ("1179348728".equals(name) || "123".equals(pass) ){
                    Toast.makeText(RegstActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegstActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
