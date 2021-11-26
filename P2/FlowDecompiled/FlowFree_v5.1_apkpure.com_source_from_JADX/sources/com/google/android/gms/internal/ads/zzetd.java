package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzetd;
import com.google.android.gms.internal.ads.zzeth;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzetd<MessageType extends zzeth<MessageType, BuilderType>, BuilderType extends zzetd<MessageType, BuilderType>> extends zzero<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzetd(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzeth) messagetype.zzb(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzeuw.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzero zzac(zzerp zzerp) {
        zzai((zzeth) zzerp);
        return this;
    }

    /* access modifiers changed from: protected */
    public void zzae() {
        MessageType messagetype = (zzeth) this.zza.zzb(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzaf */
    public final BuilderType clone() {
        BuilderType buildertype = (zzetd) this.zzc.zzb(5, (Object) null, (Object) null);
        buildertype.zzai(zzak());
        return buildertype;
    }

    /* renamed from: zzag */
    public MessageType zzak() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzeuw.zza().zzb(messagetype.getClass()).zzj(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzah() {
        MessageType zzag = zzak();
        if (zzag.zzat()) {
            return zzag;
        }
        throw new zzevs(zzag);
    }

    public final BuilderType zzai(MessageType messagetype) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaj(byte[] bArr, int i, int i2, zzest zzest) throws zzett {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        try {
            zzeuw.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzers(zzest));
            return this;
        } catch (zzett e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzett.zzb();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final /* bridge */ /* synthetic */ zzeuo zzbe() {
        return this.zzc;
    }
}
