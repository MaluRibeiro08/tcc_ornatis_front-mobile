package com.example.ornatis_tcc.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.3";

    public static RouterInterface getUsuarioInterface(){

        return RetrofitEmpresa.getEmpresa(API_URL).create(RouterInterface.class);

    }
}
