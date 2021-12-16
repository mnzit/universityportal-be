package com.nepalaya.up.callback;

import org.springframework.http.HttpHeaders;

public interface AuthCallback {

    void patch (HttpHeaders httpHeaders);
}
