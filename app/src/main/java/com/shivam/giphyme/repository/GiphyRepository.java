package com.shivam.giphyme.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shivam.giphyme.model.Data;
import com.shivam.giphyme.model.GiphyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.shivam.giphyme.config.Config.DEFAULT_LIMIT;
import static com.shivam.giphyme.config.Config.GIPHY_API_KEY;

public class GiphyRepository {

   public interface callback{
        void onSucces(List<Data> data);
    }
    private static final String  TAG = "GiphyRepository";

    private GiphyAPI giphyAPI;
    private static GiphyRepository giphyRepository;

    static {
        giphyRepository = new GiphyRepository();
    }

    private GiphyRepository() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(giphyAPI.baseUrl)
                .build();

        giphyAPI = retrofit.create(GiphyAPI.class);

        Log.d(TAG, "GiphyRepository: Gif API init");
    }

    public static GiphyRepository getInstance() {
        return giphyRepository;
    }

    public LiveData<List<Data>> getGiphyData(String query, final callback callback) {
        Log.d(TAG, "getGiphyData: calling giphy api");
        final MutableLiveData<List<Data>> imagesData = new MutableLiveData<>();

        giphyAPI.searchGif(GIPHY_API_KEY, query, DEFAULT_LIMIT, 0).enqueue(new Callback<GiphyResponse>() {
            @Override
            public void onResponse(Call<GiphyResponse> call, Response<GiphyResponse> response) {
                if (response.code() == 200) {
                    GiphyResponse giphyResponse = response.body();
                    Log.d(TAG, "onResponse: "+giphyResponse.toString());
                    imagesData.setValue(giphyResponse.getData());
                    callback.onSucces(giphyResponse.getData());
                    Log.d(TAG, "onResponse: data received");
                }else {
                    Log.d(TAG, "onResponse: something went wrong"+response.code());
                }
            }

            @Override
            public void onFailure(Call<GiphyResponse> call, Throwable t) {
                Log.d(TAG, "[ERROR] cant get gifs from Giphy, \n" + t.getLocalizedMessage());
            }
        });
        return imagesData;
    }

}
