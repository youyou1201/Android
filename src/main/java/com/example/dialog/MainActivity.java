package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

        public void onClick(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog1, null, false);
            builder.setTitle("登录对话框").setView(viewDialog).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    EditText editTextUserId = viewDialog.findViewById(R.id.userId);
                    EditText editTextUserPassword = viewDialog.findViewById(R.id.userPassword);
                    if ((editTextUserId.getText().toString().equals("abc")) && (editTextUserPassword.getText().toString().equals("123")))
                        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "UserId:" + editTextUserId.getText().toString() + "UserPassWord:" + editTextUserPassword.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    EditText editTextUserId = viewDialog.findViewById(R.id.userId);
                    EditText editTextUserPassword = viewDialog.findViewById(R.id.userPassword);

                }
            });
            builder.create().show();
        }
        });
    }

}