package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.button1);
        final TextView textView1=findViewById(R.id.t);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView1.setText(textView1.getText().toString() + "1");
            }
        });
        Button button2=findViewById(R.id.button2);
        final TextView textView2=findViewById(R.id.t);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView2.setText(textView2.getText().toString() + "2");
            }
        });
        Button button3=findViewById(R.id.button3);
        final TextView textView3=findViewById(R.id.t);

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView3.setText(textView3.getText().toString() + "3");
            }
        });
        Button button4=findViewById(R.id.button4);
        final TextView textView4=findViewById(R.id.t);

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView4.setText(textView4.getText().toString() + "4");
            }
        });
        Button button5=findViewById(R.id.button5);
        final TextView textView5=findViewById(R.id.t);

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView5.setText(textView5.getText().toString() + "5");
            }
        });
        Button button6=findViewById(R.id.button6);
        final TextView textView6=findViewById(R.id.t);

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView6.setText(textView6.getText().toString() + "6");
            }
        });
        Button button7=findViewById(R.id.button7);
        final TextView textView7=findViewById(R.id.t);

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView7.setText(textView7.getText().toString() + "7");
            }
        });
        Button button8=findViewById(R.id.button8);
        final TextView textView8=findViewById(R.id.t);

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView8.setText(textView8.getText().toString() + "8");
            }
        });
        Button button9=findViewById(R.id.button9);
        final TextView textView9=findViewById(R.id.t);

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView9.setText(textView9.getText().toString() + "9");
            }
        });
        Button button0=findViewById(R.id.button0);
        final TextView textView0=findViewById(R.id.t);

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView0.setText(textView0.getText().toString() + "0");
            }
        });
        Button button11=findViewById(R.id.button11);
        final TextView textView11=findViewById(R.id.t);

        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView11.setText(textView11.getText().toString() + "+");
            }
        });
        Button button12=findViewById(R.id.button12);
        final TextView textView12=findViewById(R.id.t);

        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView12.setText(textView12.getText().toString() + "-");
            }
        });
        Button button13=findViewById(R.id.button13);
        final TextView textView13=findViewById(R.id.t);

        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView13.setText(textView13.getText().toString() + "*");
            }
        });
        Button button14=findViewById(R.id.button14);
        final TextView textView14=findViewById(R.id.t);

        button14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView14.setText(textView14.getText().toString() + "/");
            }
        });
        Button button18=findViewById(R.id.button18);
        final TextView textView18=findViewById(R.id.t);

        button18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView18.setText(textView18.getText().toString() + "%");
            }
        });
    }
}