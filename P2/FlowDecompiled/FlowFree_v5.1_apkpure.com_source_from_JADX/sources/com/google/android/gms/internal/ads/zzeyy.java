package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyy extends CustomTabsServiceConnection {
    private final WeakReference<zzafo> zza;

    public zzeyy(zzafo zzafo, byte[] bArr) {
        this.zza = new WeakReference<>(zzafo);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzafo zzafo = (zzafo) this.zza.get();
        if (zzafo != null) {
            zzafo.zzf(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzafo zzafo = (zzafo) this.zza.get();
        if (zzafo != null) {
            zzafo.zzg();
        }
    }
}
