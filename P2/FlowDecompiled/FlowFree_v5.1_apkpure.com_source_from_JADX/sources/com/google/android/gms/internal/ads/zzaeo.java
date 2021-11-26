package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaeo implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    /* access modifiers changed from: private */
    public SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze != null) {
            try {
                this.zzh = new JSONObject((String) zzaes.zza(new zzaem(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final void zza(Context context) {
        if (!this.zzd) {
            synchronized (this.zzb) {
                if (!this.zzd) {
                    if (!this.zza) {
                        this.zza = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzg = applicationContext;
                    try {
                        this.zzf = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (!(remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null)) {
                            context = remoteContext;
                        }
                        if (context != null) {
                            zzaaa.zza();
                            SharedPreferences zza2 = zzaek.zza(context);
                            this.zze = zza2;
                            if (zza2 != null) {
                                zza2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzagq.zzb(new zzaen(this));
                            zzf();
                            this.zzd = true;
                            return;
                        }
                        this.zza = false;
                        this.zzc.open();
                    } finally {
                        this.zza = false;
                        this.zzc.open();
                    }
                }
            }
        }
    }

    public final <T> T zzb(zzaei<T> zzaei) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                T zzf2 = zzaei.zzf();
                return zzf2;
            }
        }
        if (zzaei.zzm() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzaei.zzf();
            }
            return zzaei.zza(bundle);
        } else if (zzaei.zzm() != 1 || !this.zzh.has(zzaei.zze())) {
            return zzaes.zza(new zzael(this, zzaei));
        } else {
            return zzaei.zzc(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzc() {
        return this.zze.getString("flag_configuration", "{}");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(zzaei zzaei) {
        return zzaei.zzd(this.zze);
    }
}
