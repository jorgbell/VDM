package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzecq {
    /* access modifiers changed from: private */
    public final zzeby zza;
    private final zzecn zzb;

    private zzecq(zzecn zzecn, byte[] bArr) {
        zzebx zzebx = zzebx.zza;
        this.zzb = zzecn;
        this.zza = zzebx;
    }

    public static zzecq zza(zzeby zzeby) {
        return new zzecq(new zzecn(zzeby), (byte[]) null);
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzf(CharSequence charSequence) {
        return new zzecm(this.zzb, this, charSequence);
    }

    public final List<String> zzc(CharSequence charSequence) {
        Iterator<String> zzf = zzf(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzf.hasNext()) {
            arrayList.add(zzf.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterable<String> zzb(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return new zzeco(this, charSequence);
    }
}
