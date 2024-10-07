package com.asaas.docs.configuration;

public enum VersionApi {

    V_3("v3");

    private final String versao;

    VersionApi(String versao) {
        this.versao = versao;
    }

    public String getVersao() {
        return versao;
    }

}
