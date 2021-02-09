package com.example.website;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity  {
    Button LoginBt,FragmentBt,ProductBt, NetworkBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        LoginBt = findViewById(R.id.btLogin);
        FragmentBt = findViewById(R.id.btFragment);
        ProductBt=findViewById(R.id.btProduct);
        NetworkBt= findViewById(R.id.btNetwork);
        LoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackLoginpage = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(BackLoginpage);
            }
        });
        FragmentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackFragmentpage = new Intent(FirstActivity.this, TabView.class);
                startActivity(BackFragmentpage);
            }
        });
        ProductBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackProductpage = new Intent(FirstActivity.this, NavigationProduct.class);
                startActivity(BackProductpage);
            }
        });
        NetworkBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackNetworkpage = new Intent(FirstActivity.this, MainPage.class);
                startActivity(BackNetworkpage);
            }
        });




    }

}
