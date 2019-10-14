package com.example.mobile_hw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class Create_account extends AppCompatActivity {



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
        setContentView(R.layout.create_account);

        final TextInputEditText user_id = findViewById(R.id.user_id);
        final TextInputEditText user_password = findViewById(R.id.user_password);
        final TextInputEditText user_name = findViewById(R.id.user_name);
        final TextInputEditText user_phone = findViewById(R.id.user_phone);
        final TextInputEditText user_adress = findViewById(R.id.user_address);
        final CheckBox agree = (CheckBox) findViewById(R.id.agree);
        Button return_login = findViewById(R.id.retturn_login);


        return_login.setClickable(true);
        return_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int all_possible = 0;
                String line = null;
                String temp = null;
                boolean save_id = false;
                boolean save_password = false;
                boolean save_name = false;
                boolean save_phone = false;
                boolean save_adress = false;
                boolean save_box =false;

                File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.txt");
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(saveFile));
                } catch (FileNotFoundException e) {
                    try {
                        FileWriter fw = new FileWriter(saveFile);
                        fw.write("");
                        br = new BufferedReader(new FileReader(saveFile));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                //아이디 검사

                String get_id = null;
                int cnt = 0;
                while(true)
                {
                    try {
                        if (!((line = br.readLine())!=null)) {
                            save_id = true;
                            break;
                        }

                        if (cnt%5 == 0) {
                            temp = line;
                            if(temp.equals(user_id.getText().toString())){
                                save_id = false;
                                break;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ++cnt;
                }



                //비밀번호 검사
                //1.조합검사
                String get_password = user_password.getText().toString();
                int password_len = get_password.length();
                char ch_password[]  = get_password.toCharArray();
                int password_pos = 0;
                for(int i = 0; i<password_len; ++i){                                //특수문자
                    if(((int)ch_password[i] >= 33) && ((int)ch_password[i] <= 47)){
                        password_pos += 1;
                        break;
                    }
                }
                for(int i = 0; i<password_len; ++i){                                //숫자
                    if(((int)ch_password[i] >= 48) && ((int)ch_password[i] <= 57)){
                        password_pos += 1;
                        break;
                    }
                }
                for(int i = 0; i<password_len; ++i) {                               //영어
                    if ((((int) ch_password[i] >= 65) && ((int) ch_password[i] <= 90))||(((int) ch_password[i] >= 97) && ((int) ch_password[i] <= 122))) {
                        password_pos += 1;
                        break;
                    }
                }
                if((password_pos != 3)||(password_len<8)) {
                    save_password = false;
                }
                else
                    save_password = true;

                //이름 검사
                String get_name = user_name.getText().toString();
                if(get_name.length() != 0)
                    save_name = true;

                //phone 검사
                String get_phone = user_phone.getText().toString();
                if(get_phone.length() != 0)
                    save_phone = true;

                //주소 검사
                String get_adress = user_adress.getText().toString();
                if(get_adress.length() != 0)
                    save_adress = true;

                //체크 박스
                boolean get_agree = agree.isChecked();
                if (get_agree == true)
                    save_box = true;

                if((save_id == true)&&(save_password == true)&&(save_name == true)&&(save_phone == true)&&(save_adress == true)&&(save_box == true)) {
                        //유저 정보 저장
                        try {
                            FileWriter fw = new FileWriter(saveFile);
                            fw.write(user_id.getText().toString() + "\n");
                            fw.write(user_password.getText().toString() + "\n");
                            fw.write(user_name.getText().toString() + "\n");
                            fw.write(user_phone.getText().toString() + "\n");
                            fw.write(user_adress.getText().toString() + "\n");
                            fw.flush();
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //로그인 페이지로 돌아가기
                        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Create_account.this, MainActivity.class);
                        startActivity(intent);

                }
                else if(save_id != true)
                    Toast.makeText(getApplicationContext(), "아이디가 중복되었습니다", Toast.LENGTH_LONG).show();
                else if(save_password != true)
                    Toast.makeText(getApplicationContext(), "비밀번호 조합이 맞지 않습니다", Toast.LENGTH_LONG).show();
                else if(save_name != true)
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요", Toast.LENGTH_LONG).show();
                else if(save_phone != true)
                    Toast.makeText(getApplicationContext(), "핸드폰 번호를 입력해주세요", Toast.LENGTH_LONG).show();
                else if(save_adress != true)
                    Toast.makeText(getApplicationContext(), "주소를 입력해주세요", Toast.LENGTH_LONG).show();
            }
        });

    }
}
