package com.example.globetimes;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

   String BASE_URL= "https://newsapi.org/v2/";


   @GET("top-headlines")
    Call<mainNews> getNews(

            @Query("country") String country,  //to change any country name whichever we want
            @Query("pageSize") int pageSize,
            @Query("apikey") String apikey

   );


   //To call the specific category news(ex : health, sports etc)
    @GET("top-headlines")
    Call<mainNews> getCategoryNews(

            @Query("country") String country,  //to change any country name whichever we want
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apikey") String apikey

    );


}
