package com.example.ornatis_tcc.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEmpresa {

    private static Retrofit retrofit = null;

    // ACESSO AO CLIENT
    public static Retrofit getEmpresa(String url) {
        //devolve o retrofit instanciado, logo, retorna um cliente.

        Gson gsonCriado = new GsonBuilder().setLenient().create();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gsonCriado)).build();

        }
        return retrofit;
    }
}
