 package com.example.website;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;
 import android.view.View;
 import android.widget.ImageView;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;

 import com.squareup.picasso.Picasso;

 import java.util.Locale;


public class DetailActivity extends AppCompatActivity {
   /* private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;*/

    private int seconds;
    private boolean running;
    private boolean wasRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if(savedInstanceState!=null){
            savedInstanceState.getInt("seconds");
            savedInstanceState.getBoolean("running");
            savedInstanceState.getBoolean("wasRunning");
        }

        runTimer();

        //Intent intent = getIntent();

       /* ImageView imageView = findViewById(R.id.image_view_detail);
        String imageUrl = UserInfo.getInstance().getOwner().getAvatarUrl();
        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);


        String logName = UserInfo.getInstance().getOwner().getLogin();
        TextView Logname = findViewById(R.id.text_view_login_name);
        Logname.setText(logName);*/

        /*TextView textViewUrl1 = findViewById(R.id.text_view_url1);
        MySingleton.getInstance().getUserInfo().setHtmlUrl(textViewUrl1.getText().toString());
        textViewUrl1.setText(MySingleton.getInstance().getUserInfo().getHtmlUrl());


        TextView textViewUrl2 = findViewById(R.id.text_view_url2);
        UserInfo.getInstance().setForksUrl(textViewUrl2.getText().toString());
        textViewUrl2.setText(UserInfo.getInstance().getForksUrl());*/

        Intent intent=this.getIntent();
        if(intent !=null) {

            ImageView imageView = findViewById(R.id.image_view_detail);
            String imageUrl = MySingleton.getInstance().getUserInfo().getOwner().getAvatarUrl();
            Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);


            String logName = MySingleton.getInstance().getUserInfo().getOwner().getLogin();
            TextView Logname = findViewById(R.id.text_view_login_name);
            Logname.setText(logName);

            TextView textViewUrl1 = findViewById(R.id.text_view_url1);
            textViewUrl1.setText(MySingleton.getInstance().getUserInfo().getHtmlUrl());

            TextView textViewUrl2 = findViewById(R.id.text_view_url2);
            textViewUrl2.setText(MySingleton.getInstance().getUserInfo().getForksUrl());



            TextView textViewUrl3 = findViewById(R.id.text_view_url3);
            String info3 = MySingleton.getInstance().getUserInfo().getTagsUrl();
            textViewUrl3.setText(info3);


            TextView textViewUrl4 = findViewById(R.id.text_view_url4);
            String info4 = MySingleton.getInstance().getUserInfo().getEventsUrl();
            textViewUrl4.setText(info4);


            TextView textViewUrl5 = findViewById(R.id.text_view_url5);
            String info5 = MySingleton.getInstance().getUserInfo().getHooksUrl();
            textViewUrl5.setText(info5);
        }



        /*

        String imageUrl = intent.getStringExtra(AVATAR_IMAGE);
        ImageView imageView = findViewById(R.id.image_view_detail);
        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);

        String url3 = ((Intent) intent).getStringExtra(Forks_Url);
        TextView textViewUrl3 = findViewById(R.id.text_view_url3);
        textViewUrl3.setText(url3);

        String url1 = intent.getStringExtra(Tags_Url);
        TextView textViewUrl1 = findViewById(R.id.text_view_url1);
        textViewUrl1.setText(url1);

         String Name = intent.getStringExtra(LOGIN_NAME);
        TextView Name1 = findViewById(R.id.text_view_login_name);
        Name1.setText(Name);

        String url4 = intent.getStringExtra(Keys_Url);
        TextView textViewUrl4 = findViewById(R.id.text_view_url4);
        textViewUrl4.setText(url4);

        String url5 = intent.getStringExtra(Events_Url);
        TextView textViewUrl5 = findViewById(R.id.text_view_url5);
        textViewUrl5.setText(url5);*/
    }


    public void onStart(View view) {
        running= true;
    }
    public void onStop(View view) {
        running= false;
    }
    /*public void onReset(View view) {
        running= false;
        seconds=0;
    }*/

    @Override
    protected void onPause(){
        super.onPause();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running=true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("seconds", seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning",wasRunning);
    }

    private void runTimer(){
        TextView timeView =findViewById(R.id.text_view_countdown);
        Handler handler= new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes =(seconds % 3600)/ 60;
                int secs =seconds % 60;

                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours,minutes,secs);
                timeView.setText(time);


                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }


        //parseJSON();

        /*private void parseJSON() {
            RequestQueue queue =Volley.newRequestQueue(getContext());
            String url = "https://api.github.com/repositories";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            try {


                                JSONArray array = new JSONArray(s);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject object = array.getJSONObject(i);

                                    MovieModelClass model = new MovieModelClass();

                                    model.setLogin(object.getString("login"));
                                    model.setExtraurl(object.getString("html_url"));
                                    model.setExtraurl(object.getString("followers_url"));
                                    model.setExtraurl(object.getString("following_url"));
                                    model.setExtraurl(object.getString("gists_url"));
                                    model.setExtraurl(object.getString("starred_url"));


                                    String url1 = intent.getStringExtra(EXTRA_URL1);
                                    String url2 = intent.getStringExtra(EXTRA_URL2);
                                    String url3 = intent.getStringExtra(EXTRA_URL3);
                                    String url4 = intent.getStringExtra(EXTRA_URL4);
                                    String url5 = intent.getStringExtra(EXTRA_URL5);
                                   String name = intent.getStringExtra(LOGIN_NAME);

                                    TextView textViewLogin = findViewById(R.id.text_view_login_name);
                                    TextView textViewUrl1 = findViewById(R.id.text_view_url1);
                                    TextView textViewUrl2 = findViewById(R.id.text_view_url2);
                                    TextView textViewUrl3 = findViewById(R.id.text_view_url3);
                                    TextView textViewUrl4 = findViewById(R.id.text_view_url4);
                                    TextView textViewUrl5 = findViewById(R.id.text_view_url5);

                                    textViewLogin.setText(name);
                                    textViewUrl1.setText(url1);
                                    textViewUrl2.setText(url2);
                                    textViewUrl3.setText(url3);
                                    textViewUrl4.setText(url4);
                                    textViewUrl5.setText(url5);
                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    onPause();
                } else {
                    startTimer(true, mTimeLeftInMillis);
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer(boolean b, long mTimeLeftInMillis) {
        mCountDownTimer = new CountDownTimer(DetailActivity.this.mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                DetailActivity.this.mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    protected void onPause() {

        super.onPause();
        mCountDownTimer.cancel();
        mCountDownTimer = null;
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    protected void onResume() {
        super.onResume();
        startTimer(true, mTimeLeftInMillis);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }*/


    }

