package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @SuppressLint("NewApi")
    private void jinzhi(String op1, String op2){
        if(op1=="2"){
            switch (op2){
                case "8":
                    cal=Integer.toOctalString(Integer.parseInt(cal,2));
                    //cal=Integer.valueOf("0101",2).toString();
                    break;
                case "10":
                    cal=Integer.valueOf(cal,2).toString();
                    break;
                case "16":
                    int i = Integer.hashCode(Integer.parseInt(cal, 2));
                    cal=String.valueOf(i);
                    break;
            }
        }
        if(op1=="8"){
            switch (op2){
                case "2":
                    cal=Integer.toBinaryString(Integer.parseInt(cal,8));
                    break;
                case "10":
                    cal=Integer.valueOf(cal,8).toString();
                    break;
                case "16":
                    int i=Integer.hashCode(Integer.parseInt(cal,8));
                    cal=String.valueOf(i);
                    break;
            }
        }if(op1=="10"){
            switch (op2){
                case "8":
                    cal=Integer.toOctalString((int) Double.parseDouble(cal)) ;
                    break;
                case "2":
                    cal=Integer.toBinaryString((int) Double.parseDouble(cal)) ;
                    break;
                case "16":
                    cal=Integer.toHexString((int) Double.parseDouble(cal));
                    break;
            }
        }if(op1=="16"){
            switch (op2){
                case "8":
                    cal=Integer.toOctalString(Integer.parseInt(cal,16));
                    break;
                case "10":
                    cal=Integer.valueOf(cal,16).toString();
                    break;
                case "2":
                    cal= Integer.toBinaryString(Integer.parseInt(cal,16));
                    break;
            }
        }
    }
    private void tiji(String op1,String op2){
        if(op1=="mm^3"){
            switch (op2){
                case "dm^3":
                    first/=1000000;
                    break;
                case "cm^3":
                    first/=1000;
                    break;
                case "m^3":
                    first/=1000000000;
                    break;
            }
        }
        if(op1=="cm^3"){
            switch (op2){
                case "m^3":
                    first/=1000000;
                    break;
                case "dm^3":
                    first/=1000;
                    break;
                case "mm^3":
                    first*=1000;
                    break;
            }
        }
        if(op1=="dm^3"){
            switch (op2){
                case "mm^3":
                    first*=1000000;
                    break;
                case "cm^3":
                    first*=1000;
                    break;
                case "m^3":
                    first/=1000;
                    break;
            }
        }
        if(op1=="m^3"){
            switch (op2){
                case "dm^3":
                    first*=1000;
                    break;
                case "cm^3":
                    first*=1000000;
                    break;
                case "mm^3":
                    first*=1000000000;
                    break;
            }
        }
    }
    private void changdu(String op1,String op2){
        if(op1=="cm"){
            switch (op2){
                case "dm":
                    first/=10;
                    break;
                case "m":
                    first/=100;
                    break;
                case "km":
                    first/=100000;
                    break;
            }
        }
        if(op1=="dm"){
            switch (op2){
                case "cm":
                    first*=10;
                    break;
                case "m":
                    first/=10;
                    break;
                case "km":
                    first/=10000;
                    break;
            }
        }
        if(op1=="m"){
            switch (op2){
                case "dm":
                    first*=10;
                    break;
                case "cm":
                    first*=100;
                    break;
                case "km":
                    first/=1000;
                    break;
            }
        }
        if(op1=="km"){
            switch (op2){
                case "dm":
                    first*=10000;
                    break;
                case "cm":
                    first*=100000;
                    break;
                case "m":
                    first*=1000;
                    break;
            }
        }
    }

    private void jisuan(String op){
        switch (op){
            case "+" :
                first+=second;
                break;
            case "-" :
                first-=second;
                break;
            case "×" :
                first*=second;
                break;
            case "÷" :
                first/=second;
                break;
            case "sin":
                //Math.toRadians(second)
                first=Math.sin(second);
                break;
            case "cos":
                first=Math.cos(second);
                break;
            case "tan":
                first=Math.tan(second);
                break;

        }
    }

    private Boolean isFinish = false;
    private Boolean operate = false;
    private Boolean kh = false;
    private String opernum ="";
    private String op ="";
    private String op1 ="";
    // private String op2 ="";
    private String cal="";

    private double first;
    private double second;
    private double result;//用于保存计算结果，方便下次计算直接用
    private double tem;//存储计算sin时前面还有操作符时，存储操作符前面的第一个操作数


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        Button btn_sin = (Button) findViewById(R.id.btn_sin);
        Button btn_cos = (Button) findViewById(R.id.btn_cos);
        Button btn_tan = (Button) findViewById(R.id.btn_tan);
        Button btn_help = (Button) findViewById(R.id.btn_lg);
        Button btn_kh = (Button) findViewById(R.id.btn_kh);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_multi = (Button) findViewById(R.id.btn_multi);
        Button btn_division = (Button) findViewById(R.id.btn_division);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_AC = (Button) findViewById(R.id.btn_AC);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);
        Button btn_point = (Button) findViewById(R.id.btn_point);
        Button btn_equal = (Button) findViewById(R.id.btn_equal);
        Button btn_cm = (Button) findViewById(R.id.btn_cm);
        Button btn_dm = (Button) findViewById(R.id.btn_dm);
        Button btn_m = (Button) findViewById(R.id.btn_m);
        Button btn_km = (Button) findViewById(R.id.btn_km);
        Button btn_mm3 = (Button) findViewById(R.id.btn_mm3);
        Button btn_cm3 = (Button) findViewById(R.id.btn_cm3);
        Button btn_dm3 = (Button) findViewById(R.id.btn_dm3);
        Button btn_m3 = (Button) findViewById(R.id.btn_m3);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn16 = (Button) findViewById(R.id.btn16);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn10 = (Button) findViewById(R.id.btn10);
        final TextView tv_root = (TextView) findViewById(R.id.tV_root);
        final TextView tv_result = (TextView) findViewById(R.id.tV_result);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish){
                    jinzhi(op1,"2");
                    tv_result.setText(cal+"（2进制）");
                    op1="";

                }else {
                    cal=tv_root.getText().toString();
                    //Integer.getInteger(cal);
                    tv_root.append("（2进制）");
                    op1="2";

                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish){
                    jinzhi(op1,"8");
                    tv_result.setText(cal+"（8进制）");
                    op1="";

                }else {
                    cal=tv_root.getText().toString();

                    tv_root.append("（8进制）");
                    op1="8";

                }
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish){
                    jinzhi(op1,"10");
                    tv_result.setText(cal+"（10进制）");
                    op1="";

                }else {
                    cal=tv_root.getText().toString();

                    tv_root.append("（10进制）");
                    op1="10";

                }
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish){
                    jinzhi(op1,"16");
                    tv_result.setText(cal+"（16进制）");
                    op1="";

                }else {
                    cal=tv_root.getText().toString();

                    tv_root.append("（16进制）");
                    op1="16";

                }
            }
        });
        btn_mm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    tiji(op1,"mm^3");
                    tv_result.setText(String.valueOf(first)+"mm^3");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("mm^3");
                    op1="mm^3";
                }




            }
        });
        btn_cm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    tiji(op1,"cm^3");
                    tv_result.setText(String.valueOf(first)+"cm^3");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("cm^3");
                    op1="cm^3";
                }

            }
        });
        btn_dm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    tiji(op1,"dm^3");
                    tv_result.setText(String.valueOf(first)+"dm^3");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("dm^3");
                    op1="dm^3";
                }




            }
        });
        btn_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    tiji(op1,"m^3");
                    tv_result.setText(String.valueOf(first)+"m^3");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("m^3");
                    op1="m^3";
                }




            }
        });
        btn_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    changdu(op1,"cm");
                    tv_result.setText(String.valueOf(first)+"cm");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("cm");

                    op1="cm";
                }

            }
        });
        btn_dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish){
                    changdu(op1,"dm");
                    tv_result.setText(String.valueOf(first)+"dm");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("dm");
                    op1="dm";
                }




            }
        });
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFinish){
                    changdu(op1,"m");
                    tv_result.setText(String.valueOf(first)+"m");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("m");

                    op1="m";
                }


            }
        });
        btn_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFinish){
                    changdu(op1,"km");
                    tv_result.setText(String.valueOf(first)+"km");
                    op1="";
                }else//换算前isFinish为false，记录op1=“cm”
                {
                    first=Double.parseDouble(tv_root.getText().toString());

                    tv_root.append("km");

                    op1="km";
                }


            }
        });
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=
                        new AlertDialog.Builder(MainActivity.this);
                final View viewDialog= LayoutInflater.from(MainActivity.this).inflate(R.layout.help,null,false);
                builder.setTitle("帮助")
                        .setView(viewDialog)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface,int which){

                                Toast.makeText(MainActivity.this,"点击帮助",Toast.LENGTH_LONG).show();

                            }
                        });
                builder.create().show();
            }

        });
        btn_0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(isFinish)
                {
                    tv_root.setText("0");
                    isFinish=false;

                }else{
                    if(operate){
                        cal+="0";

                    }
                    tv_root.append("0");
                }

            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("1");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "1";

                    }
                    tv_root.append("1");
                }
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("2");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "2";
                    }
                    tv_root.append("2");
                }
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("3");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "3";
                    }
                    tv_root.append("3");
                }
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("4");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "4";
                    }
                    tv_root.append("4");
                }
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(isFinish)
                {
                    tv_root.setText("5");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "5";
                    }
                    tv_root.append("5");
                }
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("6");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "6";
                    }
                    tv_root.append("6");
                }
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("7");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "7";
                    }
                    tv_root.append("7");
                }
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("8");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "8";
                    }
                    tv_root.append("8");
                }
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFinish)
                {
                    tv_root.setText("9");
                    isFinish=false;

                }else {
                    if (operate) {
                        cal += "9";
                    }
                    tv_root.append("9");
                }
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText(cal);
                    tv_root.setText("sin(" + temp);
                    operate=true;
                    opernum="sin";
                    cal=Double.toString(result);
                    isFinish = false;
                }
                else if(operate){

                    tem=first;
//tv_result.setText(String.valueOf(temp));
                    tv_root.append("sin(");
                    operate=true;
                    opernum="sin";
                    // jisuan(opernum);
                    //opernum=op;
                    //second=first;
                    //first=temp;
                }
//                else if(operate){
//                    second=Double.parseDouble(cal);
//                    jisuan(opernum);
//                    tv_root.append("sin(");
//                    operate=true;
//                    opernum="sin";
//                    cal="";
//                }
                else{
                    // first=Double.parseDouble(tv_root.getText().toString());
                    //tv_result.append(String.valueOf(first+"+"+second));
                    tv_root.append("sin(");
                    operate=true;
                    opernum="sin";


                }
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText(cal);
                    tv_root.setText("cos(" + temp);
                    operate=true;
                    opernum="cos";
                    cal=Double.toString(result);
                    isFinish = false;
                }
                else if(operate){

                    tem=first;
                    tv_root.append("cos(");
                    operate=true;
                    opernum="cos";

                }

                else{

                    tv_root.append("cos(");
                    operate=true;
                    opernum="cos";


                }
            }
        });


        btn_tan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText(cal);
                    tv_root.setText("tan(" + temp);
                    operate=true;
                    opernum="tan";
                    cal=Double.toString(result);
                    isFinish = false;
                }
                else if(operate){

                    tem=first;
                    tv_root.append("tan(");
                    operate=true;
                    opernum="tan";

                }

                else{

                    tv_root.append("tan(");
                    operate=true;
                    opernum="tan";


                }
            }
        });





        btn_point.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isFinish) {
                    tv_root.setText("0.");
                    tv_result.setText("");
                    isFinish = false;
                } else {
                    if (tv_root.getText().toString().isEmpty() || tv_root.getText().toString().equals("0.")) {
                        tv_root.setText("0.");
                    } else {
                        if(operate){
                            cal+=".";
                        }
                        tv_root.append(".");
                    }

                }

            }

        });
        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setText("");
                tv_root.setText("");
                op="";
                cal="";
                opernum="";
                operate=false;
                kh=false;
                first=0;
                second=0;
                op1="";
                isFinish = false;
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish) {
                    tv_root.setText("");
                    tv_result.setText("");
                    isFinish = false;
                } else {
                    String temp = tv_root.getText().toString();
                    if (temp.length() != 1&&temp.length() != 0) {
                        if (temp.charAt(temp.length() - 1) == '('&&(Character.isLetter(temp.charAt(temp.length() - 2) )))
                        {
                            temp = temp.substring(0, temp.length() - 3);
                            if (temp.isEmpty()) {

                                tv_root.setText("");
                                return;
                                //isFinish = false;
                            }
                            if (Character.isLetter(temp.charAt(temp.length() - 1))) {
                                temp = temp.substring(0, temp.length() - 1);
                            }
                        }  else if(temp.charAt(temp.length() - 1) == '('&&(!(Character.isLetter(temp.charAt(temp.length() - 2) ))))
                        {
                            temp = temp.substring(0, temp.length() - 1);
                            //tv_result.setText("false");
                            kh=false;
                        }else {
                            temp = temp.substring(0, temp.length() - 1);
                            cal= cal.substring(0, cal.length() - 1);

                        }
                    } else {
                        temp = "";
                    }
                    tv_root.setText(temp);
                }
            }

        });
        btn_kh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opernum=="sin"||opernum=="cos"||opernum=="tan")
                {
                    tv_root.append(")");
                    if(op!=""){
                        second=Double.parseDouble(cal);

                        jisuan(opernum);
                        //tv_result.setText(String.valueOf(second));
                        second=first;
                        //tv_result.setText(String.valueOf(second));

                        first=tem;
                        tem=second;
                        opernum=op;
                    }
                }else if(kh){
                    double temp;
                    temp=second;
                    second=Double.parseDouble(cal);
                    jisuan(opernum);
                    opernum=op;
                    second=first;
                    first=temp;
                    //tv_result.setText(String.valueOf(first)+" "+String.valueOf(second));//6+5
                    cal=String.valueOf(second);
                    tv_root.append(")");
                    kh=false;
                }else{
                    tv_root.append("(");
                    kh=true;//有左括号
                }
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText("");
                    tv_root.setText(temp + "+");
                    first=result;
                    operate=true;
                    opernum="+";
                    op="+";

                    isFinish = false;
                } else if(!kh&&operate)
                {

                    second=Double.parseDouble(cal);
                    jisuan(opernum);
                    tv_root.append("+");
                    //tv_result.setText(String.valueOf(first));
                    operate=true;
                    opernum="+";
                    op="+";
                    cal="";

                }else if(kh)
                {tv_root.append("+");
                    second=first;
                    //tv_result.setText(String.valueOf(second));//6
                    operate=true;
                    opernum="+";
                    //op="+";
                    first=Double.parseDouble(cal);
                    cal="";
                }
                else{
                    first=Double.parseDouble(tv_root.getText().toString());
                    // tv_result.append(String.valueOf(first));
                    tv_root.append("+");
                    operate=true;
                    opernum="+";
                    op="+";


                }

            }

        });


        btn_sub.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText("");
                    tv_root.setText(temp + "-");
                    first=result;
                    operate=true;
                    opernum="-";
                    op="-";

                    isFinish = false;
                } else if(!kh&&operate)
                {

                    second=Double.parseDouble(cal);
                    jisuan(opernum);
                    tv_root.append("-");
                    operate=true;
                    opernum="-";
                    op="-";
                    cal="";
                }
                else if(kh)
                {tv_root.append("-");
                    second=first;
                    //tv_result.setText(String.valueOf(second));//6
                    operate=true;
                    opernum="-";
                    first=Double.parseDouble(cal);
                    cal="";
                }else {
                    first=Double.parseDouble(tv_root.getText().toString());
                    tv_root.append("-");
                    operate=true;
                    opernum="-";
                    op="-";

                }

            }

        });


        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText("");
                    tv_root.setText(temp + "×");
                    first=result;
                    operate=true;
                    opernum="×";
                    op="×";
                    isFinish = false;
                }
                else if(!kh&&operate){
                    second=Double.parseDouble(cal);
                    jisuan(opernum);
                    tv_root.append("×");
                    operate=true;
                    opernum="×";
                    cal="";
                    op="×";
                }
                else if(kh)
                {tv_root.append("×");
                    second=first;
                    //tv_result.setText(String.valueOf(second));//6
                    operate=true;
                    opernum="×";
                    first=Double.parseDouble(cal);
                    cal="";
                }else {
                    first=Double.parseDouble(tv_root.getText().toString());
                    tv_root.append("×");
                    operate=true;
                    opernum="×";
                    op="×";
                }
            }

        });


        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinish) {
                    String temp = tv_result.getText().toString();
                    tv_result.setText("");
                    tv_root.setText(temp + "÷");
                    first=result;
                    operate=true;
                    opernum="÷";
                    op="÷";
                    isFinish = false;
                } else if(!kh&&operate){
                    second=Double.parseDouble(cal);
                    jisuan(opernum);
                    tv_root.append("÷");
                    operate=true;
                    opernum="÷";
                    cal="";
                    op="÷";
                }else if(kh)
                {tv_root.append("÷");
                    second=first;
                    //tv_result.setText(String.valueOf(second));//6
                    operate=true;
                    opernum="÷";
                    first=Double.parseDouble(cal);
                    cal="";
                }else {
                    first=Double.parseDouble(tv_root.getText().toString());
                    tv_root.append("÷");
                    operate=true;
                    opernum="÷";
                    op="÷";
                }

            }

        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinish)
                {
                    if (tv_root.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this, "输入不能为空！", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(operate){
                            // TextUtils.isEmpty(opernum);
//if(opernum!="sin"&&opernum!="cos"&&opernum!="tan"){
                            second=Double.parseDouble(cal);
                            // tv_root.append(String.valueOf(second));
                            // tv_root.append(String.valueOf(second)+"  "+String.valueOf(first)+" "+opernum);
                            if(tem!=0){
                                second=tem;
                            }
                            jisuan(opernum);
                            //double d=1;
                            //jisuan(d,"+",2);

                            tv_result.setText(String.valueOf(first));
                            result=first;
                            first=0;
                            second=0;
                            op="";
                            cal="";
                            operate=false;
                            isFinish=true;
                        }
                        else{
                            isFinish=true;
                        }

                    }
                }
            }
        });



    }

}






