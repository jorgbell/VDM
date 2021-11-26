package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public abstract class zzgb<MessageType extends zzgc<MessageType, BuilderType>, BuilderType extends zzgb<MessageType, BuilderType>> implements zziv {
    public abstract BuilderType zzar(byte[] bArr, int i, int i2) throws zzib;

    public abstract BuilderType zzas(byte[] bArr, int i, int i2, zzhd zzhd) throws zzib;

    /* access modifiers changed from: protected */
    public abstract BuilderType zzat(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zziv zzau(zziw zziw) {
        if (zzbK().getClass().isInstance(zziw)) {
            zzat((zzgc) zziw);
            return this;
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* bridge */ /* synthetic */ zziv zzav(byte[] bArr, zzhd zzhd) throws zzib {
        zzas(bArr, 0, bArr.length, zzhd);
        return this;
    }

    public final /* bridge */ /* synthetic */ zziv zzaw(byte[] bArr) throws zzib {
        zzar(bArr, 0, bArr.length);
        return this;
    }
}
