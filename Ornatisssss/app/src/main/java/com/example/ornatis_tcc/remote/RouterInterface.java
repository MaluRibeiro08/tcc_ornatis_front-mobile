package com.example.ornatis_tcc.remote;

import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.Funcionarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface RouterInterface {

    //INSERÇÃO DE CONTA
    @POST("/tcc_ornatis_back-end/api-ornatis/rotas/adm/contaAdministradora/")//rota da req e o verbo http
    Call<ContaAdministradora> addEmpresa(@Body ContaAdministradora objUsuario);

    //LISTAGEM DE CONTA
    @GET("/tcc_ornatis_back-end/api-ornatis/rotas/adm/???")
    Call<List<ContaAdministradora>>getContaAdministradora();

    //INSERÇÃO FUNCIONÁRIO
    @POST("/tcc_ornatis_back-end/api-ornatis/rotas/adm/contaAdministradora/")
    Call<Funcionarios> addFuncionario(@Body Funcionarios objFuncionario);

}
