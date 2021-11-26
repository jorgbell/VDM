package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    C1975b f4793a;

    public final IBinder onBind(Intent intent) {
        return this.f4793a;
    }

    public final void onCreate() {
        super.onCreate();
        C2009ck.m5046j(getApplicationContext()).mo21842b(this);
    }
}
