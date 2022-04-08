package com.example.ornatis_tcc.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEmpresa {

    private static Retrofit retrofit = null;

    // ACESSO AO CLIENT
    public static Retrofit getEmpresa(String url) //essa parte é como a barra de endereco do postman ou dos nav.
    {//devolve o retrofit instanciado, logo, retorna um cliente.

        Gson gsonCriado = new GsonBuilder().setLenient().create();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gsonCriado)).build();
            //se não existir, ele cria um retrofit; diz onde ele deve bater e quem vai lidar com os dados de req e res
            // (gsonConverter vai lidar com os jsons)
        }

        return retrofit;
    }

}
