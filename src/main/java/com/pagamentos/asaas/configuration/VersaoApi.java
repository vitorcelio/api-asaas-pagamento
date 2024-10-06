package com.pagamentos.asaas.configuration;

public enum VersaoApi {

    V_3("v3");

    private final String versao;

    VersaoApi(String versao) {
        this.versao = versao;
    }

    public String getVersao() {
        return versao;
    }

}
