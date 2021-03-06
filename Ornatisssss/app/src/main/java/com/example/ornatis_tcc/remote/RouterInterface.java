package com.example.ornatis_tcc.remote;

import com.example.ornatis_tcc.model.Consumidor;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.Especialidade;
import com.example.ornatis_tcc.model.Funcionario;
import com.example.ornatis_tcc.model.PartesCorpo;
import com.example.ornatis_tcc.model.Servico;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface RouterInterface {

//CONSUMIDOR
    //CADASTRO DA CONTA
    @POST("/consumidor/cadastrarConta")//rota da req e o verbo http
    Call<Consumidor> addConsumidor(@Body Consumidor objConsumidor);

//ADM
    //CONTA ADM
        //INSERÇÃO DE CONTA
        @POST("/contaAdministradora/cadastrarConta")//rota da req e o verbo http
        Call<ContaAdministradora> addEmpresa(@Body ContaAdministradora objUsuario);

        //LISTAGEM DE DADOS DE PERFIL
        @GET("/contaAdministradora/listarPerfil/{id_empresa}")
        Call<ContaAdministradora> getDadosPerfilEstabelecimento(@Path("id_empresa") int id_empresa);

    //FUNCIONARIOS
        //INSERÇÃO DE FUNCIONÁRIO
        @POST("/contaAdministradora/cadastroFuncionario")
        Call<Funcionario> addFuncionario(@Body Funcionario objFuncionario);

        //LISTAGEM DE FUNCIONÁRIOS
        @GET("/contaAdministradora/listarFuncionarios/{id_empresa}")
        Call<ArrayList<Funcionario>> getFuncionarios(@Path("id_empresa") int id_empresa);

        //EXCLUSÃO DE FUNCIONÁRIO
        @DELETE("/contaAdministradora/desabilitarFuncionario/{id_funcionario}")
        Call<Funcionario> deleteFuncionario(@Path("id_funcionario") int id_funcionario);

    //SERVIÇOS
        //INSERÇÃO DE SERVIÇO
        @POST("/contaAdministradora/cadastrarServico")
        Call<Servico> addServico(@Body Servico objServico);

        //GET CATEGORIAS
        @GET("/contaAdministradora/getEspecialidades/{id_empresa}")
        Call<ArrayList<Especialidade>> getEspecialidades(@Path("id_empresa") int id_empresa);

        //GET PARTES DO CORPO
        @GET("/contaAdministradora/getPartesCorpo/{id_empresa}")
        Call<ArrayList<PartesCorpo>> getPartesCorpo(@Path("id_empresa") int id_empresa);

        //LISTAGEM DE SERVIÇOS
        @GET("/contaAdministradora/listarServicos/{id_empresa}")
        Call<ArrayList<Servico>> getServicos(@Path("id_empresa") int id_empresa);

        //EXCLUSÃO DE SERVIÇOS
        @DELETE("contaAdministradora/desabilitarServico/{id_servico}")
        Call<Servico> deleteServico(@Path("id_servico") int id_servico);



    //DESATUALIZADAS

        //LISTAGEM DE CONTA
        @GET("/tcc_ornatis_back-end/api-ornatis/rotas/adm/{id_empresa}&acao=carregarDadosConta")
        Call<ContaAdministradora>getContaAdministradora(@Path("id_empresa") int id_empresa);


    //LISTAGEM DE FUNCIONÁRIOS
    //    @GET("/tcc_ornatis_back-end/api-ornatis/rotas/adm/")
    //    Call<ArrayList<Funcionarios>>getFuncionario();

        //LISTAGEM DOS DADOS DO FUNCIONÁRIO
    //    @GET("/tcc_ornatis_back-end/api-ornatis/rotas/adm/")
    //    Call<Funcionarios>getFuncionarioId();

}
