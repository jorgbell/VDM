package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzee extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zzf;
    private final long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzee(zzfp zzfp, long j) {
        super(zzfp);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018a A[Catch:{ IllegalStateException -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c A[Catch:{ IllegalStateException -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a2 A[SYNTHETIC, Splitter:B:55:0x01a2] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e2 A[Catch:{ IllegalStateException -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x020e A[Catch:{ IllegalStateException -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x029d  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzfp r0 = r13.zzs
            android.content.Context r0 = r0.zzax()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzfp r1 = r13.zzs
            android.content.Context r1 = r1.zzax()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            java.lang.String r5 = ""
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zzb(r9, r8)
            goto L_0x0099
        L_0x0034:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0039 }
            goto L_0x004c
        L_0x0039:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzb(r9, r8)
        L_0x004c:
            if (r6 != 0) goto L_0x0051
            java.lang.String r6 = "manual_install"
            goto L_0x005a
        L_0x0051:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x005a
            r6 = r5
        L_0x005a:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.Context r7 = r7.zzax()     // Catch:{ NameNotFoundException -> 0x0084 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0084 }
            if (r7 == 0) goto L_0x0099
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0084 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0084 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0084 }
            if (r9 != 0) goto L_0x007b
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0084 }
            goto L_0x007c
        L_0x007b:
            r8 = r2
        L_0x007c:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0081 }
            int r3 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0081 }
            goto L_0x0099
        L_0x0081:
            r7 = r2
            r2 = r8
            goto L_0x0085
        L_0x0084:
            r7 = r2
        L_0x0085:
            com.google.android.gms.measurement.internal.zzfp r8 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzb()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r2)
            r2 = r7
        L_0x0099:
            r13.zza = r0
            r13.zzd = r6
            r13.zzb = r2
            r13.zzc = r3
            r2 = 0
            r13.zzf = r2
            com.google.android.gms.measurement.internal.zzfp r2 = r13.zzs
            java.lang.String r2 = r2.zzr()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            if (r2 != 0) goto L_0x00c2
            com.google.android.gms.measurement.internal.zzfp r2 = r13.zzs
            java.lang.String r2 = r2.zzs()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c2
            r2 = 1
            goto L_0x00c3
        L_0x00c2:
            r2 = 0
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzfp r6 = r13.zzs
            int r6 = r6.zzG()
            switch(r6) {
                case 0: goto L_0x014d;
                case 1: goto L_0x013d;
                case 2: goto L_0x012d;
                case 3: goto L_0x011d;
                case 4: goto L_0x010d;
                case 5: goto L_0x00fd;
                case 6: goto L_0x00ed;
                case 7: goto L_0x00dd;
                default: goto L_0x00cc;
            }
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x015c
        L_0x00dd:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x015c
        L_0x00ed:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzh()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x015c
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x015c
        L_0x010d:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x015c
        L_0x011d:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x015c
        L_0x012d:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x015c
        L_0x013d:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x015c
        L_0x014d:
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x015c:
            r13.zzj = r5
            r13.zzk = r5
            r13.zzl = r5
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs
            r7.zzat()
            if (r2 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzfp r2 = r13.zzs
            java.lang.String r2 = r2.zzr()
            r13.zzk = r2
        L_0x0171:
            r2 = 0
            com.google.android.gms.measurement.internal.zzfp r7 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            android.content.Context r7 = r7.zzax()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzfp r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r8 = r8.zzv()     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r9 = "google_app_id"
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzhx.zza(r7, r9, r8)     // Catch:{ IllegalStateException -> 0x022d }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x022d }
            if (r3 == r8) goto L_0x018c
            r8 = r7
            goto L_0x018d
        L_0x018c:
            r8 = r5
        L_0x018d:
            r13.zzj = r8     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.internal.measurement.zzmg.zzb()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzfp r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzag     // Catch:{ IllegalStateException -> 0x022d }
            boolean r8 = r8.zzn(r2, r9)     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r9 = "admob_app_id"
            if (r8 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzfp r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            android.content.Context r8 = r8.zzax()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzfp r10 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r10 = r10.zzv()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IllegalStateException -> 0x022d }
            android.content.res.Resources r11 = r8.getResources()     // Catch:{ IllegalStateException -> 0x022d }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x022d }
            if (r12 != 0) goto L_0x01bc
            goto L_0x01c0
        L_0x01bc:
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzfh.zza(r8)     // Catch:{ IllegalStateException -> 0x022d }
        L_0x01c0:
            java.lang.String r8 = "ga_app_id"
            java.lang.String r8 = com.google.android.gms.measurement.internal.zzfh.zzb(r8, r11, r10)     // Catch:{ IllegalStateException -> 0x022d }
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x022d }
            if (r3 == r12) goto L_0x01cd
            r5 = r8
        L_0x01cd:
            r13.zzl = r5     // Catch:{ IllegalStateException -> 0x022d }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x022d }
            if (r3 == 0) goto L_0x01db
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x022d }
            if (r3 != 0) goto L_0x020c
        L_0x01db:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzfh.zzb(r9, r11, r10)     // Catch:{ IllegalStateException -> 0x022d }
            r13.zzk = r3     // Catch:{ IllegalStateException -> 0x022d }
            goto L_0x020c
        L_0x01e2:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x022d }
            if (r3 != 0) goto L_0x020c
            com.google.android.gms.measurement.internal.zzfp r3 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            android.content.Context r3 = r3.zzax()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzfp r5 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r5 = r5.zzv()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x022d }
            android.content.res.Resources r7 = r3.getResources()     // Catch:{ IllegalStateException -> 0x022d }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalStateException -> 0x022d }
            if (r8 != 0) goto L_0x0202
            goto L_0x0206
        L_0x0202:
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzfh.zza(r3)     // Catch:{ IllegalStateException -> 0x022d }
        L_0x0206:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzfh.zzb(r9, r7, r5)     // Catch:{ IllegalStateException -> 0x022d }
            r13.zzk = r3     // Catch:{ IllegalStateException -> 0x022d }
        L_0x020c:
            if (r6 != 0) goto L_0x0241
            com.google.android.gms.measurement.internal.zzfp r3 = r13.zzs     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ IllegalStateException -> 0x022d }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzk()     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r5 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r13.zza     // Catch:{ IllegalStateException -> 0x022d }
            java.lang.String r7 = r13.zzj     // Catch:{ IllegalStateException -> 0x022d }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x022d }
            if (r7 == 0) goto L_0x0227
            java.lang.String r7 = r13.zzk     // Catch:{ IllegalStateException -> 0x022d }
            goto L_0x0229
        L_0x0227:
            java.lang.String r7 = r13.zzj     // Catch:{ IllegalStateException -> 0x022d }
        L_0x0229:
            r3.zzc(r5, r6, r7)     // Catch:{ IllegalStateException -> 0x022d }
            goto L_0x0241
        L_0x022d:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzfp r5 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r5.zzc(r6, r0, r3)
        L_0x0241:
            r13.zzh = r2
            com.google.android.gms.measurement.internal.zzfp r0 = r13.zzs
            r0.zzat()
            com.google.android.gms.measurement.internal.zzfp r0 = r13.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzq(r2)
            if (r0 != 0) goto L_0x0257
            goto L_0x028c
        L_0x0257:
            int r2 = r0.size()
            if (r2 != 0) goto L_0x026d
            com.google.android.gms.measurement.internal.zzfp r0 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzh()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x028e
        L_0x026d:
            java.util.Iterator r2 = r0.iterator()
        L_0x0271:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x028c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzfp r5 = r13.zzs
            com.google.android.gms.measurement.internal.zzkp r5 = r5.zzl()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r5.zzk(r6, r3)
            if (r3 != 0) goto L_0x0271
            goto L_0x028e
        L_0x028c:
            r13.zzh = r0
        L_0x028e:
            if (r1 == 0) goto L_0x029d
            com.google.android.gms.measurement.internal.zzfp r0 = r13.zzs
            android.content.Context r0 = r0.zzax()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r13.zzi = r0
            return
        L_0x029d:
            r13.zzi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzee.zzf():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0223  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzp zzh(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r34.zzg()
            com.google.android.gms.measurement.internal.zzp r31 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r3 = r34.zzi()
            java.lang.String r4 = r34.zzj()
            r34.zzb()
            java.lang.String r5 = r1.zzb
            r34.zzb()
            int r0 = r1.zzc
            long r6 = (long) r0
            r34.zzb()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            r0.zzf()
            r34.zzb()
            r34.zzg()
            long r9 = r1.zzf
            r11 = 0
            r2 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzkp r9 = r0.zzl()
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzs
            android.content.Context r0 = r0.zzax()
            com.google.android.gms.measurement.internal.zzfp r10 = r1.zzs
            android.content.Context r10 = r10.zzax()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzkp.zzN()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzfp r0 = r9.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00ce
        L_0x0078:
            if (r13 == 0) goto L_0x00cd
            boolean r10 = r9.zzW(r0, r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzfp r10 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.Context r10 = r10.zzax()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bd }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r0 == 0) goto L_0x00ab
            int r10 = r0.length     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 <= 0) goto L_0x00ab
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            long r9 = com.google.android.gms.measurement.internal.zzkp.zzO(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            r15 = r9
            goto L_0x0076
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzfp r0 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            goto L_0x0076
        L_0x00bb:
            r15 = r11
            goto L_0x0076
        L_0x00bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r9 = r9.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzb()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            r1.zzf = r9
        L_0x00d0:
            r13 = r9
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzs
            boolean r0 = r0.zzF()
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzd()
            boolean r9 = r9.zzk
            r10 = 1
            r15 = r9 ^ 1
            r34.zzg()
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            boolean r9 = r9.zzF()
            r11 = 0
            if (r9 != 0) goto L_0x00f2
        L_0x00ee:
            r20 = r11
            goto L_0x0178
        L_0x00f2:
            com.google.android.gms.internal.measurement.zznq.zzb()
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzea.zzai
            boolean r9 = r9.zzn(r11, r12)
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00ee
        L_0x0113:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs     // Catch:{ ClassNotFoundException -> 0x0176 }
            android.content.Context r9 = r9.zzax()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x0176 }
            if (r9 != 0) goto L_0x0126
            goto L_0x00ee
        L_0x0126:
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<android.content.Context> r18 = android.content.Context.class
            r12[r2] = r18     // Catch:{ Exception -> 0x0167 }
            java.lang.String r11 = "getInstance"
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x0167 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.measurement.internal.zzfp r10 = r1.zzs     // Catch:{ Exception -> 0x0167 }
            android.content.Context r10 = r10.zzax()     // Catch:{ Exception -> 0x0167 }
            r12[r2] = r10     // Catch:{ Exception -> 0x0167 }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x0167 }
            if (r11 != 0) goto L_0x0144
            goto L_0x0176
        L_0x0144:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x0157 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0157 }
            r20 = r9
            goto L_0x0178
        L_0x0157:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzh()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r10)
            goto L_0x0176
        L_0x0167:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzf()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r10)
        L_0x0176:
            r20 = 0
        L_0x0178:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r10 = r9.zzd()
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzc
            long r10 = r10.zza()
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0190
            long r9 = r9.zzc
            r12 = r3
            r21 = r9
            goto L_0x0199
        L_0x0190:
            r12 = r3
            long r2 = r9.zzc
            long r2 = java.lang.Math.min(r2, r10)
            r21 = r2
        L_0x0199:
            r34.zzb()
            int r11 = r1.zzi
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            boolean r23 = r2.zzs()
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzd()
            r2.zzg()
            android.content.SharedPreferences r2 = r2.zzd()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r24 = r2.getBoolean(r3, r9)
            r34.zzb()
            java.lang.String r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzp(r9)
            if (r2 != 0) goto L_0x01d2
            r25 = 0
            goto L_0x01de
        L_0x01d2:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r25 = r2
        L_0x01de:
            long r9 = r1.zzg
            java.util.List<java.lang.String> r2 = r1.zzh
            com.google.android.gms.internal.measurement.zzmg.zzb()
            r16 = r2
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            r19 = r3
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzag
            r26 = r9
            r9 = 0
            boolean r2 = r2.zzn(r9, r3)
            if (r2 == 0) goto L_0x0201
            java.lang.String r2 = r34.zzl()
            r29 = r2
            goto L_0x0203
        L_0x0201:
            r29 = r9
        L_0x0203:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzau
            boolean r2 = r2.zzn(r9, r3)
            if (r2 == 0) goto L_0x0223
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzd()
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            java.lang.String r2 = r2.zzd()
            goto L_0x0225
        L_0x0223:
            java.lang.String r2 = ""
        L_0x0225:
            r30 = r2
            r9 = 39065(0x9899, double:1.93007E-319)
            r17 = 0
            r28 = r16
            r2 = r31
            r32 = r19
            r3 = r12
            r33 = r11
            r11 = r13
            r13 = r35
            r14 = r0
            r16 = r20
            r19 = r21
            r21 = r33
            r22 = r23
            r23 = r24
            r24 = r32
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List<java.lang.String>) r28, (java.lang.String) r29, (java.lang.String) r30)
            return r31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzee.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzp");
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        zzb();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        zzb();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzo() {
        return this.zzh;
    }
}
