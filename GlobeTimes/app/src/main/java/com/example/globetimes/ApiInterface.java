package com.example.globetimes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiInterface {

    String Base_URL= "https://newsapi.org/v2/";


    //It gets 2 things 1: api key and 2 : top headline
    @GET("top-headlines")
    Call<mainNews> getNews(

//by creating this getnews function it returns only news
            @Query("country") String country,  //To pass any country name
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    ) ;

    // For specific news category (home, tech, health, sports)
    @GET("top-headlines")
    Call<mainNews> getCategoryNews(

//by creating this getnews function it returns only news
            @Query("country") String country,  //To pass any country name
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    );

}
