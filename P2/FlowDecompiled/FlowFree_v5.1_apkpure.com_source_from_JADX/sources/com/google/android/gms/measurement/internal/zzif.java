package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzif extends zzf {
    protected zzhy zza;
    private volatile zzhy zzb;
    private zzhy zzc;
    private final Map<Activity, zzhy> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzhy zzg;
    /* access modifiers changed from: private */
    public zzhy zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private String zzl;

    public zzif(zzfp zzfp) {
        super(zzfp);
    }

    /* access modifiers changed from: private */
    public final void zzB(zzhy zzhy, zzhy zzhy2, long j, boolean z, Bundle bundle) {
        long j2;
        zzhy zzhy3 = zzhy;
        zzhy zzhy4 = zzhy2;
        long j3 = j;
        Bundle bundle2 = bundle;
        zzg();
        boolean z2 = false;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z2) {
            zzC(this.zza, true, j3);
        }
        if (zzhy4 == null || zzhy4.zzc != zzhy3.zzc || !zzkp.zzS(zzhy4.zzb, zzhy3.zzb) || !zzkp.zzS(zzhy4.zza, zzhy3.zza)) {
            Bundle bundle3 = new Bundle();
            zzae zzc2 = this.zzs.zzc();
            zzdz<Boolean> zzdz = zzea.zzar;
            if (zzc2.zzn((String) null, zzdz)) {
                bundle3 = bundle2 != null ? new Bundle(bundle2) : new Bundle();
            }
            zzm(zzhy3, bundle3, true);
            if (zzhy4 != null) {
                String str = zzhy4.zza;
                if (str != null) {
                    bundle3.putString("_pn", str);
                }
                String str2 = zzhy4.zzb;
                if (str2 != null) {
                    bundle3.putString("_pc", str2);
                }
                bundle3.putLong("_pi", zzhy4.zzc);
            }
            if (z2) {
                zzjs zzjs = this.zzs.zzh().zzb;
                long j4 = j3 - zzjs.zzb;
                zzjs.zzb = j3;
                if (j4 > 0) {
                    this.zzs.zzl().zzac(bundle3, j4);
                }
            }
            String str3 = "auto";
            if (this.zzs.zzc().zzn((String) null, zzdz)) {
                if (!this.zzs.zzc().zzt()) {
                    bundle3.putLong("_mst", 1);
                }
                if (true == zzhy3.zze) {
                    str3 = "app";
                }
            }
            if (this.zzs.zzc().zzn((String) null, zzdz)) {
                long currentTimeMillis = this.zzs.zzay().currentTimeMillis();
                if (zzhy3.zze) {
                    long j5 = zzhy3.zzf;
                    if (j5 != 0) {
                        j2 = j5;
                        this.zzs.zzk().zzt(str3, "_vs", j2, bundle3);
                    }
                }
                j2 = currentTimeMillis;
                this.zzs.zzk().zzt(str3, "_vs", j2, bundle3);
            } else {
                zzhr zzk = this.zzs.zzk();
                zzfp zzfp = zzk.zzs;
                zzk.zzg();
                zzk.zzt(str3, "_vs", zzk.zzs.zzay().currentTimeMillis(), bundle3);
            }
        }
        this.zza = zzhy3;
        if (this.zzs.zzc().zzn((String) null, zzea.zzar) && zzhy3.zze) {
            this.zzh = zzhy3;
        }
        this.zzs.zzy().zzz(zzhy3);
    }

    /* access modifiers changed from: private */
    public final void zzC(zzhy zzhy, boolean z, long j) {
        this.zzs.zzB().zzc(this.zzs.zzay().elapsedRealtime());
        if (this.zzs.zzh().zzb.zzd(zzhy != null && zzhy.zzd, z, j) && zzhy != null) {
            zzhy.zzd = false;
        }
    }

    private final zzhy zzD(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhy zzhy = this.zzd.get(activity);
        if (zzhy == null) {
            zzhy zzhy2 = new zzhy((String) null, zzi(activity.getClass(), "Activity"), this.zzs.zzl().zzd());
            this.zzd.put(activity, zzhy2);
            zzhy = zzhy2;
        }
        return (this.zzs.zzc().zzn((String) null, zzea.zzar) && this.zzg != null) ? this.zzg : zzhy;
    }

    public static void zzm(zzhy zzhy, Bundle bundle, boolean z) {
        if (zzhy != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzhy.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzhy.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzhy.zzc);
                return;
            }
            z = false;
        }
        if (zzhy == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static /* synthetic */ void zzu(zzif zzif, Bundle bundle, zzhy zzhy, zzhy zzhy2, long j) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zzif.zzB(zzhy, zzhy2, j, true, zzif.zzs.zzl().zzF((String) null, "screen_view", bundle, (List<String>) null, true));
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final zzhy zzh(boolean z) {
        zzb();
        zzg();
        if (!this.zzs.zzc().zzn((String) null, zzea.zzar) || !z) {
            return this.zza;
        }
        zzhy zzhy = this.zza;
        return zzhy != null ? zzhy : this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final String zzi(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzc();
        if (length2 <= 100) {
            return str2;
        }
        this.zzs.zzc();
        return str2.substring(0, 100);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r2 > 100) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        if (r4 > 100) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e0, code lost:
        r0 = r12.zzs.zzau().zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        if (r3 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f0, code lost:
        if (r4 != null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f2, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r0.zzc("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
        if (r12.zzb != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ff, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0104, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzhy(r3, r4, r12.zzs.zzl().zzd(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        r12.zzs.zzav().zzh(new com.google.android.gms.measurement.internal.zzhz(r12, r13, r2, r0, r12.zzs.zzay().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0139, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzfp r0 = r12.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzea.zzar
            r2 = 0
            boolean r0 = r0.zzn(r2, r1)
            if (r0 != 0) goto L_0x001f
            com.google.android.gms.measurement.internal.zzfp r13 = r12.zzs
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzh()
            java.lang.String r14 = "Manual screen reporting is disabled."
            r13.zza(r14)
            return
        L_0x001f:
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x013a }
            if (r1 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzfp r13 = r12.zzs     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x0037:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x013a }
            r1 = 100
            if (r3 == 0) goto L_0x006b
            int r2 = r3.length()     // Catch:{ all -> 0x013a }
            if (r2 <= 0) goto L_0x0052
            int r2 = r3.length()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfp r4 = r12.zzs     // Catch:{ all -> 0x013a }
            r4.zzc()     // Catch:{ all -> 0x013a }
            if (r2 <= r1) goto L_0x006b
        L_0x0052:
            com.google.android.gms.measurement.internal.zzfp r13 = r12.zzs     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x013a }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x013a }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x006b:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x009d
            int r4 = r2.length()     // Catch:{ all -> 0x013a }
            if (r4 <= 0) goto L_0x0084
            int r4 = r2.length()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfp r5 = r12.zzs     // Catch:{ all -> 0x013a }
            r5.zzc()     // Catch:{ all -> 0x013a }
            if (r4 <= r1) goto L_0x009d
        L_0x0084:
            com.google.android.gms.measurement.internal.zzfp r13 = r12.zzs     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x013a }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x013a }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x009d:
            if (r2 != 0) goto L_0x00b2
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x013a }
            if (r1 == 0) goto L_0x00ae
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x013a }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zzi(r1, r2)     // Catch:{ all -> 0x013a }
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r1 = "Activity"
        L_0x00b0:
            r4 = r1
            goto L_0x00b3
        L_0x00b2:
            r4 = r2
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzhy r1 = r12.zzb     // Catch:{ all -> 0x013a }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x00df
            if (r1 == 0) goto L_0x00df
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x013a }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x013a }
            boolean r2 = com.google.android.gms.measurement.internal.zzkp.zzS(r2, r4)     // Catch:{ all -> 0x013a }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x013a }
            boolean r1 = com.google.android.gms.measurement.internal.zzkp.zzS(r1, r3)     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x00df
            if (r1 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfp r13 = r12.zzs     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x00df:
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfp r0 = r12.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            if (r3 != 0) goto L_0x00ef
            java.lang.String r1 = "null"
            goto L_0x00f0
        L_0x00ef:
            r1 = r3
        L_0x00f0:
            if (r4 != 0) goto L_0x00f5
            java.lang.String r2 = "null"
            goto L_0x00f6
        L_0x00f5:
            r2 = r4
        L_0x00f6:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.zzc(r5, r1, r2)
            com.google.android.gms.measurement.internal.zzhy r0 = r12.zzb
            if (r0 != 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzhy r0 = r12.zzc
            goto L_0x0104
        L_0x0102:
            com.google.android.gms.measurement.internal.zzhy r0 = r12.zzb
        L_0x0104:
            com.google.android.gms.measurement.internal.zzhy r1 = new com.google.android.gms.measurement.internal.zzhy
            com.google.android.gms.measurement.internal.zzfp r2 = r12.zzs
            com.google.android.gms.measurement.internal.zzkp r2 = r2.zzl()
            long r5 = r2.zzd()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.measurement.internal.zzfp r14 = r12.zzs
            com.google.android.gms.common.util.Clock r14 = r14.zzay()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfp r14 = r12.zzs
            com.google.android.gms.measurement.internal.zzfm r14 = r14.zzav()
            com.google.android.gms.measurement.internal.zzhz r15 = new com.google.android.gms.measurement.internal.zzhz
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzh(r15)
            return
        L_0x013a:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzif.zzj(android.os.Bundle, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r1 <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r1 <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzfp r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            boolean r0 = r0.zzt()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.zzhy r0 = r3.zzb
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L_0x0030:
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhy> r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzi(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzkp.zzS(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzkp.zzS(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.zzfp r2 = r3.zzs
            r2.zzc()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.zzfp r2 = r3.zzs
            r2.zzc()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzfp r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzhy r0 = new com.google.android.gms.measurement.internal.zzhy
            com.google.android.gms.measurement.internal.zzfp r1 = r3.zzs
            com.google.android.gms.measurement.internal.zzkp r1 = r1.zzl()
            long r1 = r1.zzd()
            r0.<init>(r5, r6, r1)
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhy> r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzA(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzif.zzk(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final zzhy zzl() {
        return this.zzb;
    }

    public final void zzn(String str, zzhy zzhy) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzhy != null) {
                this.zzl = str;
            }
        }
    }

    public final void zzo(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.zzs.zzc().zzt() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzhy(bundle2.getString(MediationMetaData.KEY_NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zzq(Activity activity) {
        if (this.zzs.zzc().zzn((String) null, zzea.zzar)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (this.zzs.zzc().zzn((String) null, zzea.zzaq) && this.zzs.zzc().zzt()) {
                        this.zzg = null;
                        this.zzs.zzav().zzh(new zzie(this));
                    }
                }
            }
        }
        if (!this.zzs.zzc().zzn((String) null, zzea.zzaq) || this.zzs.zzc().zzt()) {
            zzA(activity, zzD(activity), false);
            zzd zzB = this.zzs.zzB();
            zzB.zzs.zzav().zzh(new zzc(zzB, zzB.zzs.zzay().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        this.zzs.zzav().zzh(new zzib(this));
    }

    public final void zzr(Activity activity) {
        if (this.zzs.zzc().zzn((String) null, zzea.zzar)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = this.zzs.zzay().elapsedRealtime();
        if (!this.zzs.zzc().zzn((String) null, zzea.zzaq) || this.zzs.zzc().zzt()) {
            zzhy zzD = zzD(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzs.zzav().zzh(new zzid(this, zzD, elapsedRealtime));
            return;
        }
        this.zzb = null;
        this.zzs.zzav().zzh(new zzic(this, elapsedRealtime));
    }

    public final void zzs(Activity activity, Bundle bundle) {
        zzhy zzhy;
        if (this.zzs.zzc().zzt() && bundle != null && (zzhy = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzhy.zzc);
            bundle2.putString(MediationMetaData.KEY_NAME, zzhy.zza);
            bundle2.putString("referrer_name", zzhy.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzc().zzt()) {
            this.zzd.remove(activity);
        }
    }

    private final void zzA(Activity activity, zzhy zzhy, boolean z) {
        zzhy zzhy2;
        zzhy zzhy3 = zzhy;
        zzhy zzhy4 = this.zzb == null ? this.zzc : this.zzb;
        if (zzhy3.zzb == null) {
            zzhy2 = new zzhy(zzhy3.zza, activity != null ? zzi(activity.getClass(), "Activity") : null, zzhy3.zzc, zzhy3.zze, zzhy3.zzf);
        } else {
            zzhy2 = zzhy3;
        }
        this.zzc = this.zzb;
        this.zzb = zzhy2;
        this.zzs.zzav().zzh(new zzia(this, zzhy2, zzhy4, this.zzs.zzay().elapsedRealtime(), z));
    }
}
