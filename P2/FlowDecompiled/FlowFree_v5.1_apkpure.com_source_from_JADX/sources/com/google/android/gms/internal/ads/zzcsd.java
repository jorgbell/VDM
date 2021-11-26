package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcsd extends zzcrx {
    private String zzg;
    private int zzh = 1;

    public zzcsd(Context context) {
        this.zzf = new zzavn(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbk.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzcsk(1));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zzg(this.zze, new zzcrw(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzcrw(this));
                    } else {
                        this.zza.zzd(new zzcsk(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzcsk(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzcsk(1));
                }
            }
        }
    }

    public final zzefw<InputStream> zzb(zzawc zzawc) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                zzefw<InputStream> zzb = zzefo.zzb(new zzcsk(2));
                return zzb;
            } else if (this.zzc) {
                zzbcb<InputStream> zzbcb = this.zza;
                return zzbcb;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzawc;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zze(new zzcsb(this), zzbbw.zzf);
                zzbcb<InputStream> zzbcb2 = this.zza;
                return zzbcb2;
            }
        }
    }

    public final zzefw<InputStream> zzc(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                zzefw<InputStream> zzb = zzefo.zzb(new zzcsk(2));
                return zzb;
            } else if (this.zzc) {
                zzbcb<InputStream> zzbcb = this.zza;
                return zzbcb;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zze(new zzcsc(this), zzbbw.zzf);
                zzbcb<InputStream> zzbcb2 = this.zza;
                return zzbcb2;
            }
        }
    }
}
