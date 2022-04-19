package com.example.ornatis_tcc.remote;

import com.example.ornatis_tcc.model.ContaAdministradora;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface RouterInterface {

    //INSERÇÃO
    @POST("/tcc_ornatis_back-end/api-ornatis/rotas/contaAdministradora/")//rota da req e o verbo http
    Call<ContaAdministradora> addEmpresa(@Body ContaAdministradora objUsuario);

    //LISTAGEM
    @GET("/tcc_ornatis_back-end/api-ornatis/rotas/????/")
    Call<List<ContaAdministradora>>getContaAdministradora();

}
