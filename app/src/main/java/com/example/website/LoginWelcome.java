package com.example.website;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginWelcome extends AppCompatActivity {
    TextView TxUseremail, TxUsername, MyWelcome;
    String MyrecvdEmail, MyrcvdUsername;
    Button Button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_welcome);

        MyrecvdEmail = getIntent().getStringExtra("MyKey");
        MyrcvdUsername = getIntent().getStringExtra("MyuserKey");

        TxUseremail = findViewById(R.id.txuseremail);
        TxUsername = findViewById(R.id.txusername);
        MyWelcome = findViewById(R.id.Mywelcome);
        Button1=findViewById(R.id.button1);


        TxUseremail.setText(MyrecvdEmail);
        TxUsername.setText(MyrcvdUsername);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackHome = new Intent(LoginWelcome.this, MainActivity.class);
                startActivity(BackHome);
            }
        });
    }
}


