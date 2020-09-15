package com.example.login;

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

        Button button=findViewById(R.id.button);
        final TextView textView=findViewById(R.id.t);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "1");
            }
        });
    }
}
