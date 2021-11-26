package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class zzh extends DataBufferRef {
    public zzh(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* access modifiers changed from: protected */
    public final int zza(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }

    /* access modifiers changed from: protected */
    public final String zza(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }
}
