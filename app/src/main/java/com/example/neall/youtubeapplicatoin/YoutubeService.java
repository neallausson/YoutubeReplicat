package com.example.neall.youtubeapplicatoin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by neall on 23/02/2018.
 */

public interface YoutubeService {
    @GET("search")
    Call<YoutubeVideoResult> GetVideo (
                         @Query( "key")String api_key ,
                         @Query( "part") String part ,
                         @Query( "q") String q ,
                         @Query("maxResults") int max_result,
                         @Query("type") String type);
}
