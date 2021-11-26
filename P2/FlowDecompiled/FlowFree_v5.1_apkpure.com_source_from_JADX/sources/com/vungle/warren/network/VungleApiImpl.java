package com.vungle.warren.network;

import com.google.gson.JsonObject;
import com.vungle.warren.network.converters.Converter;
import com.vungle.warren.network.converters.EmptyResponseConverter;
import com.vungle.warren.network.converters.JsonConverter;
import java.util.Map;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class VungleApiImpl implements VungleApi {
    private static final Converter<ResponseBody, Void> emptyResponseConverter = new EmptyResponseConverter();
    private static final Converter<ResponseBody, JsonObject> jsonConverter = new JsonConverter();
    HttpUrl baseUrl;
    Call.Factory okHttpClient;

    public VungleApiImpl(HttpUrl httpUrl, Call.Factory factory) {
        this.baseUrl = httpUrl;
        this.okHttpClient = factory;
    }

    public Call<JsonObject> config(String str, JsonObject jsonObject) {
        return createNewPostCall(str, this.baseUrl.toString() + "config", jsonObject);
    }

    public Call<JsonObject> reportNew(String str, String str2, Map<String, String> map) {
        return createNewGetCall(str, str2, map, jsonConverter);
    }

    public Call<JsonObject> ads(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    /* renamed from: ri */
    public Call<JsonObject> mo27452ri(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> sendLog(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<Void> pingTPAT(String str, String str2) {
        return createNewGetCall(str, str2, (Map<String, String>) null, emptyResponseConverter);
    }

    private Call<JsonObject> createNewPostCall(String str, String str2, JsonObject jsonObject) {
        String jsonElement = jsonObject != null ? jsonObject.toString() : "";
        Request.Builder defaultBuilder = defaultBuilder(str, str2);
        defaultBuilder.post(RequestBody.create((MediaType) null, jsonElement));
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder.build()), jsonConverter);
    }

    private <T> Call<T> createNewGetCall(String str, String str2, Map<String, String> map, Converter<ResponseBody, T> converter) {
        HttpUrl.Builder newBuilder = HttpUrl.get(str2).newBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                newBuilder.addQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        Request.Builder defaultBuilder = defaultBuilder(str, newBuilder.build().toString());
        defaultBuilder.get();
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder.build()), converter);
    }

    private Request.Builder defaultBuilder(String str, String str2) {
        Request.Builder builder = new Request.Builder();
        builder.url(str2);
        builder.addHeader("User-Agent", str);
        builder.addHeader("Vungle-Version", "5.7.0");
        builder.addHeader("Content-Type", "application/json");
        return builder;
    }
}
