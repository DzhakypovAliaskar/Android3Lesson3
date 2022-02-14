package com.example.android3lesson3.data.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RickAndMortyResponse<T> {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<T> result = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResults(List<T> characters) {
        this.result = result;
    }
}