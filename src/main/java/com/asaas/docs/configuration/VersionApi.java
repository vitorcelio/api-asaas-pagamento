package com.asaas.docs.configuration;

import lombok.Getter;

@Getter
public enum VersionApi {

    V_3("v3", 3);

    private final String version;
    private final int numberVersion;

    VersionApi(String version, int numeroVersion) {
        this.version = version;
        this.numberVersion = numeroVersion;
    }

}
