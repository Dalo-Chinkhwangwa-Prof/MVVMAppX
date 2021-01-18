package com.americanairlines.appxmvvm.network;

import com.americanairlines.appxmvvm.model.JikanResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.americanairlines.appxmvvm.util.Constant.PATH;
import static com.americanairlines.appxmvvm.util.Constant.SEARCH_QUERY;

public interface AnimeNetworkService {

    @GET(PATH)
    public Call<JikanResponse>  searchAnime(@Query(SEARCH_QUERY) String searchQuery);

}
