package com.americanairlines.appxmvvm.network;

import com.americanairlines.appxmvvm.model.JikanResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.americanairlines.appxmvvm.util.Constant.BASE_URL;

public class AnimeRetrofit {

    //Singleton 101
    //1. make constructor private
    //2. Create a instance variable(private)
    //3. create a getter - that checks if instance is null and only instantiates it if null

    private AnimeNetworkService animeNetworkService;

    private static AnimeRetrofit animeRetrofitInstance = null;

    public static AnimeRetrofit getAnimeRetrofitInstance() {

        if(animeRetrofitInstance == null)
            animeRetrofitInstance = new AnimeRetrofit();

        return animeRetrofitInstance;
    }

    private AnimeRetrofit() {
        animeNetworkService = createAnimeService(createRetrofit());
    }

    private AnimeNetworkService createAnimeService(Retrofit retrofit) {
        return retrofit.create(AnimeNetworkService.class);
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<JikanResponse> getSearchResults(String searchQuery){
        return animeNetworkService.searchAnime(searchQuery);
    }
}























