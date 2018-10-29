package com.example.shishengtao.secondarymarket.my_turn;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shishengtao.secondarymarket.R;

public class LoginActivity extends AppCompatActivity {

    private  TextView btn_reg;
    private TextView textView_forgetpsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        //设置光标在文字最后端闪烁
        EditText et=(EditText)findViewById(R.id.ET_login);
        et.setSelection(et.getText().toString().length());

        EditText et1=(EditText)findViewById(R.id.ET_password);
        et1.setSelection(et.getText().toString().length());
         btn_reg=(TextView) findViewById(R.id.Texview_register);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisteruserActivity.class);
                startActivity(intent);
            }
        });

        textView_forgetpsw=(TextView) findViewById(R.id.Texview_forgetPsw);
        textView_forgetpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,FindPassword.class);
                startActivity(intent);
            }
        });


    }
}
