package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.zzfh;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzal extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzbs zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzbs zzbs, String str, String str2, Context context, Bundle bundle) {
        super(zzbs, true);
        this.zze = zzbs;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (zzbs.zzV(this.zza, this.zzb)) {
                String str4 = this.zzb;
                str2 = this.zza;
                str = str4;
                str3 = this.zze.zzd;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            Preconditions.checkNotNull(this.zzc);
            zzbs zzbs = this.zze;
            zzq unused = zzbs.zzj = zzbs.zzc(this.zzc, true);
            if (this.zze.zzj == null) {
                Log.w(this.zze.zzd, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            zzz zzz = new zzz(39065, (long) Math.max(localVersion, remoteVersion), remoteVersion < localVersion, str3, str2, str, this.zzd, zzfh.zza(this.zzc));
            zzq zzP = this.zze.zzj;
            Preconditions.checkNotNull(zzP);
            zzP.initialize(ObjectWrapper.wrap(this.zzc), zzz, this.zzh);
        } catch (Exception e) {
            this.zze.zzT(e, true, false);
        }
    }
}
