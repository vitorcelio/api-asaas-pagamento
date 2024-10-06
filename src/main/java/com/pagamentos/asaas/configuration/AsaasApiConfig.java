package com.pagamentos.asaas.configuration;

import lombok.Getter;
import lombok.Setter;

public class AsaasApiConfig {

    private static VersaoApi versao = VersaoApi.V_3;
    private static Boolean isSandbox = Boolean.TRUE;
    private static String baseDominioSandbox = "https://sandbox.asaas.com/api/%s/payments/";
    private static String baseDominio = "https://asaas.com/api/%s/payments/";

    @Setter
    @Getter
    private static String apiKey;

    public static void setVersao(VersaoApi versao) {
        AsaasApiConfig.versao = versao;
    }

    public static void setIsSandbox(Boolean isSandbox) {
        AsaasApiConfig.isSandbox = isSandbox;
    }

    public static String getBaseDominio() {
        return String.format(isSandbox ? baseDominioSandbox : baseDominio, versao.getVersao());
    }

}
