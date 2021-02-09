package com.example.website;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class TabView extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView email,call,status;
    private PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);
        //getSupportFragmentManager().beginTransaction().add(R.id.mail_container, new EmailFragment()).commit();

        //getSupportFragmentManager().beginTransaction().add(R.id.mail_container,new EmailFragment()).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mail_container,EmailFragment.getInstance("12")).addToBackStack(null).commit();


        email=findViewById(R.id.email);
        status=findViewById(R.id.status);
        call=findViewById(R.id.call);
        viewPager=findViewById(R.id.FragmentContainer);



        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                onChangeTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void onChangeTab(int position) {

        if(position==0)
        {
            email.setTextSize(25);
            status.setTextSize(15);
            call.setTextSize(15);
        }
        if(position==1)
        {
            email.setTextSize(15);
            status.setTextSize(25);
            call.setTextSize(15);
        }
        if(position==2)
        {
            email.setTextSize(15);
            status.setTextSize(15);
            call.setTextSize(25);
        }



         }


}




