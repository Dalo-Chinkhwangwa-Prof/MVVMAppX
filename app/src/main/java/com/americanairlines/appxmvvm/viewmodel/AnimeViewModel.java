package com.americanairlines.appxmvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.americanairlines.appxmvvm.model.JikanResponse;
import com.americanairlines.appxmvvm.model.Result;
import com.americanairlines.appxmvvm.network.AnimeRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.americanairlines.appxmvvm.util.DebugLogger.logDebug;
import static com.americanairlines.appxmvvm.util.DebugLogger.logError;

public class AnimeViewModel extends ViewModel {

    private MutableLiveData<List<Result>> animeSearchResults = new MutableLiveData<>();

    public LiveData<List<Result>> searchForAnime(String searchQuery) {
        //
        new Thread() {
            @Override
            public void run() {
                super.run();
                //use Retrofit Call object to read data

                AnimeRetrofit.getAnimeRetrofitInstance().getSearchResults(searchQuery)
                        .enqueue(new Callback<JikanResponse>() {
                            @Override
                            public void onResponse(Call<JikanResponse> call, Response<JikanResponse> response) {

                                if (response.isSuccessful() && response.body() != null && !response.body().getResults().isEmpty()) {
                                    animeSearchResults.postValue(response.body().getResults());
                                } else
                                    logDebug("Empty list...");
                            }

                            @Override
                            public void onFailure(Call<JikanResponse> call, Throwable t) {
                                logError(t.getMessage());
                            }
                        });


            }
        }.start();

        return animeSearchResults;
    }
}












