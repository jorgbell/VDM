package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.drive.zzaw;

@Deprecated
public final class Drive {
    public static final Api.ClientKey<zzaw> CLIENT_KEY;
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    private static final Api.AbstractClientBuilder<zzaw, Object> zzq;
    private static final Api.AbstractClientBuilder<zzaw, zzb> zzr;
    private static final Api.AbstractClientBuilder<zzaw, zza> zzs;

    public static class zzb implements Api.ApiOptions {
    }

    public static class zza implements Api.ApiOptions.HasGoogleSignInAccountOptions {
        private final GoogleSignInAccount zzaa;
        private final Bundle zzz;

        public final Bundle zzh() {
            return this.zzz;
        }

        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaa;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zza = (zza) obj;
                if (!Objects.equal(this.zzaa, zza.getGoogleSignInAccount())) {
                    return false;
                }
                String string = this.zzz.getString("method_trace_filename");
                String string2 = zza.zzz.getString("method_trace_filename");
                return ((string == null && string2 == null) || !(string == null || string2 == null || !string.equals(string2))) && this.zzz.getBoolean("bypass_initial_sync") == zza.zzz.getBoolean("bypass_initial_sync") && this.zzz.getInt("proxy_type") == zza.zzz.getInt("proxy_type");
            }
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzaa, this.zzz.getString("method_trace_filename", ""), Integer.valueOf(this.zzz.getInt("proxy_type")), Boolean.valueOf(this.zzz.getBoolean("bypass_initial_sync")));
        }
    }

    static {
        Api.ClientKey<zzaw> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zze zze = new zze();
        zzq = zze;
        zzf zzf = new zzf();
        zzr = zzf;
        zzg zzg = new zzg();
        zzs = zzg;
        new Scope("https://www.googleapis.com/auth/drive.file");
        new Scope("https://www.googleapis.com/auth/drive");
        new Scope("https://www.googleapis.com/auth/drive.apps");
        new Api("Drive.API", zze, clientKey);
        new Api("Drive.INTERNAL_API", zzf, clientKey);
        new Api("Drive.API_CONNECTIONLESS", zzg, clientKey);
    }
}
