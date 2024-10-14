package com.asaas.docs.configuration;

import lombok.Getter;
import lombok.Setter;

public class AsaasApiConfig {

    private static VersionApi version = VersionApi.V_3;
    private static boolean isSandbox = true;
    private static final String domainSandbox = "https://sandbox.asaas.com/api/%s/";
    private static final String domain = "https://asaas.com/api/%s/";

    @Setter
    @Getter
    private static String apiKey;

    public static void setVersion(VersionApi version) {
        AsaasApiConfig.version = version;
    }

    public static void setIsSandbox(boolean isSandbox) {
        AsaasApiConfig.isSandbox = isSandbox;
    }

    public static String BASE_URL() {
        return String.format(isSandbox ? domainSandbox : domain, version.getVersao());
    }

    public static final String API_KEY_ASAAS = "";

}
