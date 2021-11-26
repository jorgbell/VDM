package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.chartboost.sdk.impl.x */
public class C1406x {

    /* renamed from: b */
    private static C1406x f3483b = new C1406x(new Handler(Looper.getMainLooper()));

    /* renamed from: a */
    public final Handler f3484a;

    public C1406x(Handler handler) {
        this.f3484a = handler;
    }

    /* renamed from: b */
    public static C1406x m3823b() {
        return f3483b;
    }

    /* renamed from: a */
    public boolean mo10695a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: c */
    public boolean mo10697c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: a */
    public String mo10694a() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: a */
    public AdvertisingIdClient.Info mo10693a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException, IllegalStateException {
        return AdvertisingIdClient.getAdvertisingIdInfo(context);
    }

    /* renamed from: a */
    public boolean mo10696a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    /* renamed from: a */
    public Bitmap mo10692a(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, (BitmapFactory.Options) null);
    }
}
