package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzero;
import com.google.android.gms.internal.ads.zzerp;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzero<MessageType extends zzerp<MessageType, BuilderType>, BuilderType extends zzero<MessageType, BuilderType>> implements zzeun {
    /* access modifiers changed from: protected */
    public abstract BuilderType zzac(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzeun zzad(zzeuo zzeuo) {
        if (zzbe().getClass().isInstance(zzeuo)) {
            zzac((zzerp) zzeuo);
            return this;
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
