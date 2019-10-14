package com.example.mobile_hw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class First_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final double[] number = {0};
        setContentView(R.layout.first_page);
        final TextInputEditText formula = findViewById(R.id.formual);
        final TextView result = findViewById(R.id.result);
        final Button btn0 = findViewById(R.id.btn0);
        final Button btn1 = findViewById(R.id.btn1);
        final Button btn2 = findViewById(R.id.btn2);
        final Button btn3 = findViewById(R.id.btn3);
        final Button btn4 = findViewById(R.id.btn4);
        final Button btn5 = findViewById(R.id.btn5);
        final Button btn6 = findViewById(R.id.btn6);
        final Button btn7 = findViewById(R.id.btn7);
        final Button btn8 = findViewById(R.id.btn8);
        final Button btn9 = findViewById(R.id.btn9);
        final Button btn_add = findViewById(R.id.btn_add);
        final Button btn_sub = findViewById(R.id.btn_sub);
        final Button btn_mul = findViewById(R.id.btn_mul);
        final Button btn_div = findViewById(R.id.btn_div);
        final Button btn_clear = findViewById(R.id.btn_clear);
        final Button btn_resutl = findViewById(R.id.btn_result);
        View.OnClickListener cl = new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (v == btn1) {
                    formula.setText(formula.getText() + "1");
                }
                else if(v == btn2)
                    formula.setText(formula.getText() + "2");
                else if(v == btn3)
                    formula.setText(formula.getText() + "3");
                else if(v == btn4)
                    formula.setText(formula.getText() + "4");
                else if(v == btn5)
                    formula.setText(formula.getText() + "5");
                else if(v == btn6)
                    formula.setText(formula.getText() + "6");
                else if(v == btn7)
                    formula.setText(formula.getText() + "7");
                else if(v == btn8)
                    formula.setText(formula.getText() + "8");
                else if(v == btn9)
                    formula.setText(formula.getText() + "9");
                else if(v == btn0)
                    formula.setText(formula.getText() + "0");

                else if(v == btn_add) {
                    if(formula.getText().toString().length() != 0)
                    {
                        number[0] = Double.parseDouble(formula.getText().toString());
                        formula.setText(formula.getText() + "+");
                    }
                    else
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if(v == btn_sub) {
                    if(formula.getText().toString().length() != 0)
                    {
                        number[0] = Double.parseDouble(formula.getText().toString());
                        formula.setText(formula.getText() + "-");
                    }
                    else
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if(v == btn_mul){
                    if(formula.getText().toString().length() != 0)
                    {
                        number[0] = Double.parseDouble(formula.getText().toString());
                        formula.setText(formula.getText() + "*");
                    }
                    else
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }

                else if(v == btn_div) {
                    if(formula.getText().toString().length() != 0)
                    {
                        number[0] = Double.parseDouble(formula.getText().toString());
                        formula.setText(formula.getText() + "/");
                    }
                    else
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if(v == btn_clear) {
                    formula.setText(null);
                    result.setText(null);
                }
                else if(v == btn_resutl){
                    Double number2 = null;
                    char str_formual[] = formula.getText().toString().toCharArray();
                    double result_num = 0;
                    for(int i = 0;i<formula.getText().length();++i){
                            int cnt = 0;
                            if(str_formual[i] == '+'){
                               cnt = i+1;
                               number2 = Double.parseDouble(formula.getText().toString().substring(cnt,formula.getText().length()));
                               result_num = number[0] + number2 ;
                               break;
                        }

                        else if(str_formual[i] == '-'){
                                cnt = i+1;
                                number2 = Double.parseDouble(formula.getText().toString().substring(cnt,formula.getText().length()));
                                result_num = number[0] - number2 ;
                                break;
                        }
                        else if(str_formual[i] == '*'){
                                cnt = i+1;
                                number2 = Double.parseDouble(formula.getText().toString().substring(cnt,formula.getText().length()));
                                result_num = number[0] * number2 ;
                                break;

                        }
                        else if(str_formual[i] == '/'){
                                cnt = i+1;
                                number2 = Double.parseDouble(formula.getText().toString().substring(cnt,formula.getText().length()));
                                result_num = number[0] / number2 ;
                                break;
                        }
                    }
                    formula.setText("" + result_num);
                    result.setText("" + result_num);

                }

            }


        };
        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);
        btn3.setOnClickListener(cl);
        btn4.setOnClickListener(cl);
        btn5.setOnClickListener(cl);
        btn6.setOnClickListener(cl);
        btn7.setOnClickListener(cl);
        btn8.setOnClickListener(cl);
        btn9.setOnClickListener(cl);
        btn0.setOnClickListener(cl);
        btn_add.setOnClickListener(cl);
        btn_sub.setOnClickListener(cl);
        btn_mul.setOnClickListener(cl);
        btn_div.setOnClickListener(cl);
        btn_clear.setOnClickListener(cl);
        btn_resutl.setOnClickListener(cl);



    }
}
