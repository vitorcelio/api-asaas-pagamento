package com.asaas.docs.configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class AsaasApiConfig {

    private static final String domainSandbox = "https://sandbox.asaas.com/api/%s/";
    private static final String domain = "https://asaas.com/api/%s/";

    @Getter
    @Setter
    private static VersionApi version = VersionApi.V_3;

    @Getter
    @Setter
    private static boolean isSandbox = true;

    @Getter
    @Setter
    @NonNull
    private static String apiKey;

    public static String BASE_URL() {
        return String.format(isSandbox ? domainSandbox : domain, version.getVersion());
    }

    // Constante Usada para testes
    public static final String API_KEY_ASAAS = "";

}
