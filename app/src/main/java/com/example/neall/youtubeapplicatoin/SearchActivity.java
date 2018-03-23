package com.example.neall.youtubeapplicatoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements  OnVideoSelectedListener {

    final int MAX_RESULT =25;
    final String PART =  "snippet";
    final String API_KEY = "AIzaSyD23izr1ZAdU2cLlBR7S0XL3zvaSq4o8OA";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final int NEXT_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        layoutManager = new LinearLayoutManager(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_View);

        final YoutubeService service = retrofit.create(YoutubeService.class);

        final Button button = findViewById(R.id.rechercheButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(layoutManager);
                EditText search = (EditText) findViewById(R.id.queryEditText);
                String q = search.getText().toString();
                Call<YoutubeVideoResult> videos = service.GetVideo(API_KEY,PART,q,MAX_RESULT,"video");
                videos.enqueue(new Callback<YoutubeVideoResult>() {
                    @Override
                    public void onResponse(Call<YoutubeVideoResult> call, Response<YoutubeVideoResult> response) {
                        //Log.i("debug", String.valueOf(response.body().items.get(0).snippet.description));

                        adapter = new MyAdapter(response.body().items);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<YoutubeVideoResult> call, Throwable t) {
                        Log.i("debug",t.toString());
                    }
                });
            }
        });



    }





}
