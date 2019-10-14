package com.example.mobile_hw;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextInputEditText text_username , text_password;
    Button Button_login_btn;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_username = findViewById(R.id.TextInputEditText_user_name);
        text_password = findViewById(R.id.TextInputEditText_password);
        Button_login_btn = findViewById(R.id.Button_login_btn);
        sign_up =(Button) findViewById(R.id.btn_sign_up);

        //1. 값을 가져온다 - 검사(123@gmail.com / 1234)
        //2. 클릭을 감지한다
        //3.1번의 값을 다음 액티비티로 넘긴다
        Button_login_btn.setClickable(true);
        Button_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean next_page = false;

                String username = text_username.getText().toString();
                String password = text_password.getText().toString();
                String line = null;
                String check_id = null;
                String check_password = null;
                String temp_id = null;
                String temp_password = null;


                if((username.length() == 0)||(password.length() == 0)){
                    Toast.makeText(getApplicationContext(), "아이디또는 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    next_page = false;
                }
                else{
                    File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.txt");
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(saveFile));
                    } catch (FileNotFoundException e) {
                        try {
                            FileWriter fw = new FileWriter(saveFile);
                            fw.write("");
                            fw.close();
                            br = new BufferedReader(new FileReader(saveFile));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    int cnt = 0;
                    while(true)
                    {
                        try {
                            if (!((line = br.readLine())!=null)) break;

                            if (cnt%5 == 0) {
                                check_id = line;
                            }
                            else if(cnt%5 == 1) {
                                check_password = line;
                                if(check_id.equals(text_username.getText().toString())){
                                    break;
                                }
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ++cnt;
                    }
                }

                if(check_id.equals(text_username.getText().toString()) && check_password.equals(text_password.getText().toString()))
                    next_page = true;

                if(next_page == true){
                    Toast.makeText(getApplicationContext(), "정상적으로 로그인 되었습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, First_page.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "회원정보가 맞지 않습니다", Toast.LENGTH_SHORT).show();
                }

            }


        });

        sign_up.setClickable(true);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Create_account.class);
                startActivity(intent);
            }
        });


    }
}
