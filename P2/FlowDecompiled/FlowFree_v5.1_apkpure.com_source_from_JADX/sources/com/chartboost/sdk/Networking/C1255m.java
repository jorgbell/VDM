package com.chartboost.sdk.Networking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.chartboost.sdk.Networking.m */
public class C1255m {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo10169a(C1243c<?> cVar) throws IOException {
        return (HttpURLConnection) new URL(cVar.f2848b).openConnection();
    }
}
