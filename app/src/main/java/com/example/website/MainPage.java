package com.example.website;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.website.model.Owner;
import com.example.website.model.UserInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity implements Adaptery.OnItemClickListener {
    public static final String Tags_Url = "Tags_Url";
    public static final String Html_Url = "Html_Url";
    public static final String Forks_Url = "Forks_Url";
    public static final String Keys_Url = "Keys_Url";
    public static final String Events_Url = "Events_Url";
    public static final String AVATAR_IMAGE = "IMAGE";
    public static final String LOGIN_NAME = "login_name";
    public final String TAG = getClass().getSimpleName();


    ProgressDialog progressDialog;
    private static String JSON_URL = "https://api.github.com/repositories";
    ArrayList<UserInfo> movieList;
    ArrayList<Owner> SubList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        GetData getData = new GetData();
        getData.execute();


    }

    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance

            progressDialog = new ProgressDialog(MainPage.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder builder = null;

            try {
                URL url = new URL(JSON_URL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                InputStreamReader reader = new InputStreamReader(con.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = "";
                builder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Log.e("error",builder.toString());
            return builder.toString();
        }


        @Override
        protected void onPostExecute(String fullResponse) {
            super.onPostExecute(fullResponse);
            progressDialog.dismiss();

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<UserInfo>>(){}.getType();
            ArrayList<UserInfo> movieList = gson.fromJson(fullResponse,listType);

            putDataIntoRecyclerView(movieList);



            //UserInfo userInfo = gson.fromJson(fullResponse,UserInfo.class);
            //System.out.println(userInfo.getDescription());
            /*try {
                JSONArray array = new JSONArray(fullResponse);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    MovieModelClass model = new MovieModelClass();
                    model.setName(object.getString("name"));
                    model.setFullname(object.getString("full_name"));
                    model.setDescription(object.getString("description"));
                    model.setToggle1(object.getBoolean("private"));
                    model.setToggle2(object.getBoolean("fork"));
                    String owner = object.getString("owner");
                    JSONObject object1 = new JSONObject(owner);
                    model.setImg(object1.getString("avatar_url"));
                    movieList.add(model);
             }

            } catch (JSONException e) {
                e.printStackTrace();
            }*/

        }
    }

    private void putDataIntoRecyclerView(ArrayList<UserInfo> movieList) {
        this.movieList = movieList;
        Adaptery adaptery = new Adaptery((ArrayList<UserInfo>) movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
        Adaptery.setOnItemClickListener(MainPage.this);
    }



        @Override
        public void onItemClick(int position) {
        if (movieList!=null && !movieList.isEmpty()) {
            UserInfo userInfo = movieList.get(position);
            MySingleton.getInstance().setUserInfo(userInfo);
                Intent detailIntent = new Intent(MainPage.this, DetailActivity.class);
                    startActivity(detailIntent);
            Log.e(TAG,userInfo.getArchiveUrl());

            }

        }


}





















//try{
//UserInfo currentItem = movieList.get(position);
//detailIntent.putExtra(AVATAR_IMAGE,currentItem.getOwner().getAvatarUrl());
//detailIntent.putExtra(LOGIN_NAME, currentItem.getOwner().getLogin());
//detailIntent.putExtra(Tags_Url, currentItem.getTagsUrl());
//detailIntent.putExtra(Forks_Url, currentItem.getForksUrl());
//detailIntent.putExtra(Keys_Url, currentItem.getKeysUrl());
//detailIntent.putExtra(Events_Url, currentItem.getEventsUrl());