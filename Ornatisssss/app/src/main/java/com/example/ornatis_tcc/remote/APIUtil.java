package com.example.ornatis_tcc.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.2:3001";

    public static RouterInterface getEmpresaInterface(){

        return RetrofitEmpresa.getEmpresa(API_URL).create(RouterInterface.class);

    }
}
