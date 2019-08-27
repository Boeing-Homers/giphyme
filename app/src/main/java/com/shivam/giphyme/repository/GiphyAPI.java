package com.shivam.giphyme.repository;

import com.shivam.giphyme.model.GiphyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyAPI {

    String baseUrl = "https://api.giphy.com/v1/stickers/";

    @GET("search")
    Call<GiphyResponse> searchGif(@Query("api_key") String apiKey,
                                  @Query("q") String query,
                                  @Query("limit") int limit,
                                  @Query("offset") int offset);
}
