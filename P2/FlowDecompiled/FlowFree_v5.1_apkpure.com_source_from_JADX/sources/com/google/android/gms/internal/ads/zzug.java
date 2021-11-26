package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzug {
    private final zzum zza;
    @GuardedBy("this")
    private final zzvz zzb;
    private final boolean zzc;

    private zzug() {
        this.zzb = zzwa.zze();
        this.zzc = false;
        this.zza = new zzum();
    }

    public static zzug zza() {
        return new zzug();
    }

    private final synchronized void zzd(zzui zzui) {
        zzvz zzvz = this.zzb;
        zzvz.zzd();
        List<String> zzd = zzaeq.zzd();
        ArrayList arrayList = new ArrayList();
        for (String split : zzd) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        zzvz.zzc(arrayList);
        zzul zzul = new zzul(this.zza, ((zzwa) this.zzb.zzah()).zzao(), (zzuk) null);
        zzul.zzb(zzui.zza());
        zzul.zza();
        String valueOf2 = String.valueOf(Integer.toString(zzui.zza(), 10));
        zze.zza(valueOf2.length() != 0 ? "Logging Event with event code : ".concat(valueOf2) : new String("Logging Event with event code : "));
    }

    private final synchronized void zze(zzui zzui) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzf(zzui).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzf(zzui zzui) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zza(), Long.valueOf(zzs.zzj().elapsedRealtime()), Integer.valueOf(zzui.zza()), Base64.encodeToString(((zzwa) this.zzb.zzah()).zzao(), 3)});
    }

    public final synchronized void zzb(zzui zzui) {
        if (this.zzc) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdd)).booleanValue()) {
                zze(zzui);
            } else {
                zzd(zzui);
            }
        }
    }

    public final synchronized void zzc(zzuf zzuf) {
        if (this.zzc) {
            try {
                zzuf.zza(this.zzb);
            } catch (NullPointerException e) {
                zzs.zzg().zzg(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public zzug(zzum zzum) {
        this.zzb = zzwa.zze();
        this.zza = zzum;
        this.zzc = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzdc)).booleanValue();
    }
}
