package com.vungle.warren.analytics;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class VungleAnalytics implements AdAnalytics {
    /* access modifiers changed from: private */
    public static final String TAG = "VungleAnalytics";
    private final VungleApiClient client;

    public VungleAnalytics(VungleApiClient vungleApiClient) {
        this.client = vungleApiClient;
    }

    public String[] ping(String[] strArr) {
        if (strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (!this.client.pingTPAT(str)) {
                        arrayList.add(str);
                    }
                } catch (VungleApiClient.ClearTextTrafficException unused) {
                    Log.e(TAG, "Cleartext Network Traffic is Blocked : " + str);
                } catch (MalformedURLException unused2) {
                    Log.e(TAG, "Invalid Url : " + str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: ri */
    public void mo27243ri(JsonObject jsonObject) {
        if (jsonObject != null) {
            this.client.mo27222ri(jsonObject).enqueue(new Callback<JsonObject>(this) {
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Log.d(VungleAnalytics.TAG, "send RI success");
                }

                public void onFailure(Call<JsonObject> call, Throwable th) {
                    Log.d(VungleAnalytics.TAG, "send RI Failure");
                }
            });
        }
    }
}
