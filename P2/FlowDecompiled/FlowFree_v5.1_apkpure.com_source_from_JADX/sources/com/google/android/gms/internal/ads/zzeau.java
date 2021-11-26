package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeau {
    private static final Object zzf = new Object();
    private final Context zza;
    private final SharedPreferences zzb;
    private final String zzc;
    private final zzeab zzd;
    private boolean zze = false;

    public zzeau(Context context, zzhp zzhp, zzeab zzeab, boolean z) {
        this.zza = context;
        this.zzc = Integer.toString(zzhp.zza());
        this.zzb = context.getSharedPreferences("pcvmspf", 0);
        this.zzd = zzeab;
        this.zze = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zza.getDir("pccache", 0), this.zzc), str);
    }

    private final String zzf() {
        String valueOf = String.valueOf(this.zzc);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzg() {
        String valueOf = String.valueOf(this.zzc);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private static String zzh(zzhs zzhs) {
        zzhu zzi = zzhv.zzi();
        zzi.zza(zzhs.zza().zza());
        zzi.zzb(zzhs.zza().zzc());
        zzi.zzd(zzhs.zza().zze());
        zzi.zze(zzhs.zza().zzf());
        zzi.zzc(zzhs.zza().zzd());
        return Hex.bytesToStringLowercase(((zzhv) zzi.zzah()).zzan().zzy());
    }

    private final void zzi(int i, long j) {
        zzeab zzeab = this.zzd;
        if (zzeab != null) {
            zzeab.zza(i, j);
        }
    }

    private final void zzj(int i, long j, String str) {
        zzeab zzeab = this.zzd;
        if (zzeab != null) {
            zzeab.zzb(i, j, str);
        }
    }

    private final zzhv zzk(int i) {
        String str;
        zzest zzest;
        if (i == 1) {
            str = this.zzb.getString(zzg(), (String) null);
        } else {
            str = this.zzb.getString(zzf(), (String) null);
        }
        if (str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzesf zzs = zzesf.zzs(Hex.stringToBytes(str));
            if (this.zze) {
                zzest = zzest.zza();
            } else {
                zzest = zzest.zzb();
            }
            return zzhv.zzh(zzs, zzest);
        } catch (zzett unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzhs zzhs, zzeat zzeat) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhv zzk = zzk(1);
            String zza2 = zzhs.zza().zza();
            if (zzk == null || !zzk.zza().equals(zza2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze2 = zze(zza2);
                if (zze2.exists()) {
                    String str = "1";
                    if (true != zze2.isDirectory()) {
                        str = "0";
                    }
                    String str2 = "1";
                    if (true != zze2.isFile()) {
                        str2 = "0";
                    }
                    StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length());
                    sb.append("d:");
                    sb.append(str);
                    sb.append(",f:");
                    sb.append(str2);
                    zzj(4023, currentTimeMillis2, sb.toString());
                    zzi(4015, currentTimeMillis2);
                } else if (!zze2.mkdirs()) {
                    String str3 = "1";
                    if (true != zze2.canWrite()) {
                        str3 = "0";
                    }
                    zzj(4024, currentTimeMillis2, str3.length() != 0 ? "cw:".concat(str3) : new String("cw:"));
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze3 = zze(zza2);
                File file = new File(zze3, "pcam.jar");
                File file2 = new File(zze3, "pcbc");
                if (!zzeao.zzb(file, zzhs.zzc().zzy())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                } else if (!zzeao.zzb(file2, zzhs.zzd().zzy())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                } else if (zzeat == null || zzeat.zza(file)) {
                    String zzh = zzh(zzhs);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzb.getString(zzg(), (String) null);
                    SharedPreferences.Editor edit = this.zzb.edit();
                    edit.putString(zzg(), zzh);
                    if (string != null) {
                        edit.putString(zzf(), string);
                    }
                    if (!edit.commit()) {
                        zzi(4019, currentTimeMillis3);
                        return false;
                    }
                    HashSet hashSet = new HashSet();
                    zzhv zzk2 = zzk(1);
                    if (zzk2 != null) {
                        hashSet.add(zzk2.zza());
                    }
                    zzhv zzk3 = zzk(2);
                    if (zzk3 != null) {
                        hashSet.add(zzk3.zza());
                    }
                    for (File file3 : new File(this.zza.getDir("pccache", 0), this.zzc).listFiles()) {
                        if (!hashSet.contains(file3.getName())) {
                            zzeao.zze(file3);
                        }
                    }
                    zzi(5014, currentTimeMillis);
                    return true;
                } else {
                    zzi(4018, currentTimeMillis);
                    zzeao.zze(zze3);
                    return false;
                }
            } else {
                zzi(4014, currentTimeMillis);
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzhs r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zzf
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzhv r3 = r7.zza()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zza()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zze(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzesf r3 = r7.zzd()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.zzy()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzeao.zzb(r4, r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zzi(r7, r0)     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            r7 = 0
            return r7
        L_0x0030:
            java.lang.String r7 = zzh(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzb     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzg()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeau.zzb(com.google.android.gms.internal.ads.zzhs):boolean");
    }

    public final zzeam zzc(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhv zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze2 = zze(zzk.zza());
            File file = new File(zze2, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze2, "pcam");
            }
            File file2 = new File(zze2, "pcbc");
            File file3 = new File(zze2, "pcopt");
            zzi(5016, currentTimeMillis);
            zzeam zzeam = new zzeam(zzk, file, file2, file3);
            return zzeam;
        }
    }

    public final boolean zzd(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhv zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze2 = zze(zzk.zza());
            if (!new File(zze2, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            } else if (!new File(zze2, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            } else {
                zzi(5019, currentTimeMillis);
                return true;
            }
        }
    }
}
