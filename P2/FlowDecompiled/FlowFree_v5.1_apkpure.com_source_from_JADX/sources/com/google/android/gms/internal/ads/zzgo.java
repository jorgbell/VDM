package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgo extends zzhm {
    private static final zzhn<String> zzi = new zzhn<>();
    private final Context zzj;

    public zzgo(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, Context context) {
        super(zzge, "V7RbzNcQH9mmO13CLejXnEeLBww1fCswCmEYgCbR7fg0aaDM8vr+ky2aLbvCnh+x", "DtfbH9Wfu3mjs65hNYuog0nW6dBYb/642xmI9hs2Qf0=", zzcn, i, 29);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzp("E");
        AtomicReference<String> zza = zzi.zza(this.zzj.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zzf.invoke((Object) null, new Object[]{this.zzj}));
                }
            }
        }
        String str = zza.get();
        synchronized (this.zze) {
            this.zze.zzp(zzdx.zza(str.getBytes(), true));
        }
    }
}
