package com.vungle.warren.network;

import okhttp3.Headers;
import okhttp3.ResponseBody;

public final class Response<T> {
    private final T body;
    private final okhttp3.Response rawResponse;

    public static <T> Response<T> success(T t, okhttp3.Response response) {
        if (response.isSuccessful()) {
            return new Response<>(response, t, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public T body() {
        return this.body;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
