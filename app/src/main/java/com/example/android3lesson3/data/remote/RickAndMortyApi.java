package com.example.android3lesson3.data.remote;

import com.example.android3lesson3.data.models.Character;
import com.example.android3lesson3.data.models.RickAndMortyResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {

    @GET("character")
    Call<RickAndMortyResponse<Character>> getCharacters();
}