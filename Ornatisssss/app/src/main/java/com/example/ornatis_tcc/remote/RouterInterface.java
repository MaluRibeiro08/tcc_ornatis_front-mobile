package com.example.ornatis_tcc.remote;

import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.Funcionarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface RouterInterface {

    //INSERÇÃO DE CONTA
    @POST("/contaAdministradora/cadastrarConta")//rota da req e o verbo http
    Call<ContaAdministradora> addEmpresa(@Body ContaAdministradora objUsuario);

    //LISTAGEM DE CONTA
    @GET("/tcc_ornatis_back-end/api-ornatis/rotas/adm/?id_empresa={id_empresa}&acao=carregarDadosConta")
    Call<ContaAdministradora>getContaAdministradora(@Path("id_empresa") int id_empresa);

    //INSERÇÃO FUNCIONÁRIO
    @POST("/tcc_ornatis_back-end/api-ornatis/rotas/adm/contaAdministradora/")
    Call<Funcionarios> addFuncionario(@Body Funcionarios objFuncionario);

}
