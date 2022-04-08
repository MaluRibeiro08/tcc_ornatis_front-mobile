package com.example.ornatis_tcc.remote;

import com.example.ornatis_tcc.model.ContaAdministradora;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface RouterInterface {

    @POST("/tcc_ornatis_back-end/api-ornatis/rotas/contaAdministradora/")//rota da req e o verbo http
    Call<ContaAdministradora> addUsuario(@Body ContaAdministradora objUsuario);
}
