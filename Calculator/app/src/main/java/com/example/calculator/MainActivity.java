package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;  /*显示计算过程及结果*/
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button10, button11, button12, button13, button14, button15, button16, button17, button18;
    double num1 = 0, num2 = 0;
    double result = 0;   /*计算结果*/
    int op = 0;     /*判断操作数*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.t);    /*与用户界面程序中组件建立关联*/
        button16 = (Button) findViewById(R.id.button16);   /*清除*/
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        button11 = (Button) findViewById(R.id.button11);   /*加*/
        button12 = (Button) findViewById(R.id.button12);   /*减*/
        button13 = (Button) findViewById(R.id.button13);   /*乘*/
        button14 = (Button) findViewById(R.id.button14);    /*除*/
        button10 = (Button) findViewById(R.id.button10);   /*点*/
        button15 = (Button) findViewById(R.id.button15);       /*等于*/


        button1.setOnClickListener(new mClick());
        button2.setOnClickListener(new mClick());
        button3.setOnClickListener(new mClick());
        button4.setOnClickListener(new mClick());
        button5.setOnClickListener(new mClick());
        button6.setOnClickListener(new mClick());
        button7.setOnClickListener(new mClick());
        button8.setOnClickListener(new mClick());
        button9.setOnClickListener(new mClick());
        button0.setOnClickListener(new mClick());
        button10.setOnClickListener(new mClick());
        button11.setOnClickListener(new mClick());
        button12.setOnClickListener(new mClick());
        button13.setOnClickListener(new mClick());
        button14.setOnClickListener(new mClick());
        button15.setOnClickListener(new mClick());
        button16.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        public void onClick(View v) {

            switch (v.getId()) {           /*用swtich（）方法，判断点击按钮的id*/
                case R.id.button16:    /*清除，直接将输入的所有符号清空*/
                    txt.setText(null);
                    break;
                /*数字，小数点按键*/
                case R.id.button1:
                    String str1 = txt.getText().toString();
                    str1 += "1";
                case R.id.button2:
                    String str2 = txt.getText().toString();
                    str2 += "2";
                    txt.setText(str2);
                    break;
                case R.id.button3:
                    String str3 = txt.getText().toString();
                    str3 += "3";
                    txt.setText(str3);
                    break;
                case R.id.button4:
                    String str4 = txt.getText().toString();
                    str4 += "4";
                    txt.setText(str4);
                    break;
                case R.id.button5:
                    String str5 = txt.getText().toString();
                    str5 += "5";
                    txt.setText(str5);
                    break;
                case R.id.button6:
                    String str6 = txt.getText().toString();
                    str6 += "6";
                    txt.setText(str6);
                    break;
                case R.id.button7:
                    String str7 = txt.getText().toString();
                    str7 += "7";
                    txt.setText(str7);
                    break;
                case R.id.button8:
                    String str8 = txt.getText().toString();
                    str8 += "8";
                    txt.setText(str8);
                    break;
                case R.id.button9:
                    String str9 = txt.getText().toString();
                    str9 += "9";
                    txt.setText(str9);
                    break;
                case R.id.button0:
                    String strr = txt.getText().toString();
                    strr += "0";
                    txt.setText(strr);
                    break;
                case R.id.button10:
                    String strd = txt.getText().toString();
                    strd += ".";
                    txt.setText(strd);
                    break;
                case R.id.button11:
                    String stradd = txt.getText().toString();/*按运算符，获取要计算的数字，并放入num1等待计算*/
                    if (stradd.equals(null))  /*判断按运算符前是否输入要计算的数字，若为空，则返回*/ {
                        return;
                    }
                    num1 = Double.valueOf(stradd);/*将获取的字符串转化为double类型以便计算*/
                    txt.setText(null);
                    op = 1;
                    break;
                case R.id.button12:
                    String strsub = txt.getText().toString();
                    if (strsub.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(strsub);
                    txt.setText(null);
                    op = 2;
                    break;
                case R.id.button13:
                    String strmut = txt.getText().toString();
                    if (strmut.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(strmut);
                    txt.setText(null);
                    op = 3;
                    break;
                case R.id.button14:
                    String strdiv = txt.getText().toString();
                    if (strdiv.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(strdiv);
                    txt.setText(null);
                    op = 4;
                    break;
                case R.id.button15:
                    String strequ = txt.getText().toString();
                    num2 = Double.valueOf(strequ);
                    txt.setText(null);
                    switch (op) {      /*用switch函数来判断进行何种操作，实施运算并得出结果*/
                        case 1:
                            result = num1 + num2;
                            txt.setText(String.valueOf(num1) + "+" + String.valueOf(num2) + "=" + String.valueOf(result));/*获取结果并将其转为字符串输出*/
                            break;
                        case 2:
                            result = num1 - num2;
                            txt.setText(String.valueOf(num1) + "-" + String.valueOf(num2) + "=" + String.valueOf(result));
                            break;
                        case 3:
                            result = num1 * num2;
                            txt.setText(String.valueOf(num1) + "*" + String.valueOf(num2) + "=" + String.valueOf(result));
                            break;
                        case 4:
                            if (num2 == 0) {
                                txt.setText("除数不能为0！");   /*规定除数不能为0，否则报错*/
                            } else {
                                result = num1 / num2;
                                txt.setText(String.valueOf(num1) + "/" + String.valueOf(num2) + "=" + String.valueOf(result));
                            }
                            break;
                        default:
                            result = 0;
                            break;

                    }
            }
        }
    }
}