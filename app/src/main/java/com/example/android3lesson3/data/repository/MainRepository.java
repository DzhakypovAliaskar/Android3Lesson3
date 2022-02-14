package com.example.android3lesson3.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.android3lesson3.App;
import com.example.android3lesson3.common.Resource;
import com.example.android3lesson3.data.models.Character;
import com.example.android3lesson3.data.models.RickAndMortyResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public MutableLiveData<Resource<RickAndMortyResponse<Character>>> getCharacters() {
        MutableLiveData<Resource<RickAndMortyResponse<Character>>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        App.api.getCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(@NonNull Call<RickAndMortyResponse<Character>> call, @NonNull Response<RickAndMortyResponse<Character>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(null, response.message()));
                }
            }
            @Override
            public void onFailure(@NonNull Call<RickAndMortyResponse<Character>> call, @NonNull Throwable t) {
                liveData.setValue(Resource.error(null, t.getLocalizedMessage()));
            }
        });
        return liveData;
    }
}
