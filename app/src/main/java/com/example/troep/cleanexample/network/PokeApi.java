package com.example.troep.cleanexample.network;

import com.example.troep.cleanexample.network.pojo.Pokemon;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by troep on 4/29/17.
 */

public interface PokeApi {

    @GET("pokemon/{id}")
    Observable<Pokemon> getPokemon(@Path("id") int id);
}
