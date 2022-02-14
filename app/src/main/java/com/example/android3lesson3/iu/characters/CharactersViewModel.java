package com.example.android3lesson3.iu.characters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.android3lesson3.App;
import com.example.android3lesson3.common.Resource;
import com.example.android3lesson3.data.models.Character;
import com.example.android3lesson3.data.models.RickAndMortyResponse;

public class CharactersViewModel extends ViewModel {

    public LiveData<Resource<RickAndMortyResponse<Character>>> characterLiveData;

    public CharactersViewModel() {
    }

    public void getCharacters(){
        characterLiveData = App.repository.getCharacters();
    }
}