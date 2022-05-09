package com.example.ornatis_tcc.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.9:3001";

    public static RouterInterface getEmpresaInterface(){

        return RetrofitEmpresa.getEmpresa(API_URL).create(RouterInterface.class);

    }
}
