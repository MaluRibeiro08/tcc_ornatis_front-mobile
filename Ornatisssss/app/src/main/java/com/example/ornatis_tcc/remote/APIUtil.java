package com.example.ornatis_tcc.remote;

public class APIUtil {

    private static final String API_URL = "http://192.168.15.6";

    public static RouterInterface getEmpresaInterface(){

        return RetrofitEmpresa.getEmpresa(API_URL).create(RouterInterface.class);

    }
}
