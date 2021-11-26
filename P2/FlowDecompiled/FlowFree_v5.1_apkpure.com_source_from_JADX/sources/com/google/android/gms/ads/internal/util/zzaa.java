package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzaa implements View.OnApplyWindowInsetsListener {
    private final Activity zzb;

    zzaa(zzab zzab, Activity activity) {
        this.zzb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzab.zzs(this.zzb, view, windowInsets);
    }
}
