package com.onejava.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ApiClientConfiguration {
    private String host, username, password;
    private int port;
    private boolean useHttps;
    private long connectTimeout, readTimeout;
}
