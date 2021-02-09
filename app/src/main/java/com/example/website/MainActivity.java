package com.example.website;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EtEmail,Etpass,EtUsername;
    Button Btlogin;
    String StringEmail, StringPass,StringUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtEmail=findViewById(R.id.etEmail);
        Etpass=findViewById(R.id.etPass);
        Btlogin=findViewById(R.id.btlogin);
        EtUsername=findViewById(R.id.etUsername);


        Btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringEmail = EtEmail.getText().toString();
                StringPass = Etpass.getText().toString();
                StringUsername=EtUsername.getText().toString();

                if (StringEmail.equals("admin123@gmail.com") && StringPass.equals("admin@123")) {
                    Intent MymovingIntent= new Intent(MainActivity.this, LoginWelcome.class);
                    MymovingIntent.putExtra("MyKey", StringEmail);
                    MymovingIntent.putExtra("MyuserKey", StringUsername);
                    startActivity(MymovingIntent );

                } else {
                    Toast.makeText(MainActivity.this, "login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
