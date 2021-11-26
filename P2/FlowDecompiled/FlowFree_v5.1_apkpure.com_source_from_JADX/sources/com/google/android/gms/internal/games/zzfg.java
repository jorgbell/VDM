package com.google.android.gms.internal.games;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzfg {
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    public IBinder zzjn;
    public int zzjo = -1;

    public zzfg(int i, IBinder iBinder) {
        this.gravity = i;
        this.zzjn = null;
    }

    public final Bundle zzce() {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", this.gravity);
        bundle.putInt("popupLocationInfo.displayId", this.zzjo);
        bundle.putInt("popupLocationInfo.left", this.left);
        bundle.putInt("popupLocationInfo.top", this.top);
        bundle.putInt("popupLocationInfo.right", this.right);
        bundle.putInt("popupLocationInfo.bottom", this.bottom);
        return bundle;
    }
}
