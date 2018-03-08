package com.example.neall.youtubeapplicatoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements  OnVideoSelectedListener {

    final int MAX_RESULT =25;
    final String PART =  "snippet";
    final String API_KEY = "AIzaSyD23izr1ZAdU2cLlBR7S0XL3zvaSq4o8OA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        YoutubeService service = retrofit.create(YoutubeService.class);

        Call<YoutubeVideoResult> videos = service.GetVideo(API_KEY,PART,"esilv",MAX_RESULT);
        videos.enqueue(new Callback<YoutubeVideoResult>() {
            @Override
            public void onResponse(Call<YoutubeVideoResult> call, Response<YoutubeVideoResult> response) {
                Log.i("debug", String.valueOf(response.body().items.get(0).snippet.title));

            }

            @Override
            public void onFailure(Call<YoutubeVideoResult> call, Throwable t) {
                Log.i("debug",t.toString());
            }
        });


    }



}
