package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzayl implements zzayr {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final List<Future<Void>> zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    @GuardedBy("lock")
    private final zzewp zzd;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzexn> zze;
    @GuardedBy("lock")
    private final List<String> zzf = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzg = new ArrayList();
    private final Context zzh;
    private final zzayo zzi;
    private final Object zzj = new Object();
    private HashSet<String> zzk = new HashSet<>();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzayl(Context context, zzbbq zzbbq, zzayo zzayo, String str, zzayn zzayn, byte[] bArr) {
        Preconditions.checkNotNull(zzayo, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap<>();
        this.zzi = zzayo;
        for (String lowerCase : zzayo.zze) {
            this.zzk.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzewp zze2 = zzexr.zze();
        zze2.zza(zzexj.OCTAGON_AD);
        zze2.zzc(str);
        zze2.zzd(str);
        zzewq zza2 = zzewr.zza();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zza2.zza(str2);
        }
        zze2.zze((zzewr) zza2.zzah());
        zzexp zza3 = zzexq.zza();
        zza3.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = zzbbq.zza;
        if (str3 != null) {
            zza3.zza(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zza3.zzb(apkVersion);
        }
        zze2.zzl((zzexq) zza3.zzah());
        this.zzd = zze2;
    }

    public final zzayo zza() {
        return this.zzi;
    }

    public final void zzb(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzj();
            } else {
                this.zzd.zzi(str);
            }
        }
    }

    public final boolean zzc() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzayo r0 = r7.zzi
            boolean r0 = r0.zzc
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r7.zzl
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            com.google.android.gms.ads.internal.zzs.zzc()
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L_0x0014
            goto L_0x006d
        L_0x0014:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch:{ RuntimeException -> 0x002d }
            r8.setDrawingCacheEnabled(r0)     // Catch:{ RuntimeException -> 0x002d }
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch:{ RuntimeException -> 0x002d }
            if (r3 == 0) goto L_0x0026
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch:{ RuntimeException -> 0x002d }
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            r8.setDrawingCacheEnabled(r2)     // Catch:{ RuntimeException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r3 = r1
        L_0x002f:
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.internal.ads.zzbbk.zzg(r4, r2)
        L_0x0034:
            if (r3 != 0) goto L_0x006c
            int r2 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r3 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            if (r2 == 0) goto L_0x005f
            if (r3 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            int r4 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r5 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ RuntimeException -> 0x0065 }
            r5.<init>(r4)     // Catch:{ RuntimeException -> 0x0065 }
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch:{ RuntimeException -> 0x0065 }
            r8.draw(r5)     // Catch:{ RuntimeException -> 0x0065 }
            r1 = r4
            goto L_0x006d
        L_0x005f:
            java.lang.String r8 = "Width or height of view is zero"
            com.google.android.gms.internal.ads.zzbbk.zzi(r8)     // Catch:{ RuntimeException -> 0x0065 }
            goto L_0x006d
        L_0x0065:
            r8 = move-exception
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.internal.ads.zzbbk.zzg(r2, r8)
            goto L_0x006d
        L_0x006c:
            r1 = r3
        L_0x006d:
            if (r1 != 0) goto L_0x0075
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzayq.zza(r8)
            return
        L_0x0075:
            r7.zzl = r0
            com.google.android.gms.internal.ads.zzayg r8 = new com.google.android.gms.internal.ads.zzayg
            r8.<init>(r7, r1)
            com.google.android.gms.ads.internal.util.zzr.zzk(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayl.zzd(android.view.View):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzj
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzm = r2     // Catch:{ all -> 0x00b7 }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzexn> r2 = r6.zze     // Catch:{ all -> 0x00b7 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzexn> r8 = r6.zze     // Catch:{ all -> 0x00b7 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzexn r7 = (com.google.android.gms.internal.ads.zzexn) r7     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzexm r8 = com.google.android.gms.internal.ads.zzexm.zzb(r1)     // Catch:{ all -> 0x00b7 }
            r7.zzd(r8)     // Catch:{ all -> 0x00b7 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzexn r1 = com.google.android.gms.internal.ads.zzexo.zzd()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzexm r9 = com.google.android.gms.internal.ads.zzexm.zzb(r9)     // Catch:{ all -> 0x00b7 }
            if (r9 == 0) goto L_0x0031
            r1.zzd(r9)     // Catch:{ all -> 0x00b7 }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzexn> r9 = r6.zze     // Catch:{ all -> 0x00b7 }
            int r9 = r9.size()     // Catch:{ all -> 0x00b7 }
            r1.zza(r9)     // Catch:{ all -> 0x00b7 }
            r1.zzb(r7)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzewu r9 = com.google.android.gms.internal.ads.zzewx.zza()     // Catch:{ all -> 0x00b7 }
            java.util.HashSet<java.lang.String> r2 = r6.zzk     // Catch:{ all -> 0x00b7 }
            int r2 = r2.size()     // Catch:{ all -> 0x00b7 }
            if (r2 <= 0) goto L_0x00a7
            if (r8 == 0) goto L_0x00a7
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00b7 }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00b7 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00b7 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00b7 }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00b7 }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b7 }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00b7 }
            java.util.HashSet<java.lang.String> r5 = r6.zzk     // Catch:{ all -> 0x00b7 }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00b7 }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzews r4 = com.google.android.gms.internal.ads.zzewt.zza()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzesf r3 = com.google.android.gms.internal.ads.zzesf.zzu(r3)     // Catch:{ all -> 0x00b7 }
            r4.zza(r3)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzesf r2 = com.google.android.gms.internal.ads.zzesf.zzu(r2)     // Catch:{ all -> 0x00b7 }
            r4.zzb(r2)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzeth r2 = r4.zzah()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzewt r2 = (com.google.android.gms.internal.ads.zzewt) r2     // Catch:{ all -> 0x00b7 }
            r9.zza(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0053
        L_0x00a7:
            com.google.android.gms.internal.ads.zzeth r8 = r9.zzah()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzewx r8 = (com.google.android.gms.internal.ads.zzewx) r8     // Catch:{ all -> 0x00b7 }
            r1.zzc(r8)     // Catch:{ all -> 0x00b7 }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzexn> r8 = r6.zze     // Catch:{ all -> 0x00b7 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x00b7:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            goto L_0x00bb
        L_0x00ba:
            throw r7
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayl.zze(java.lang.String, java.util.Map, int):void");
    }

    public final void zzf() {
        synchronized (this.zzj) {
            this.zze.keySet();
            zzefw zza2 = zzefo.zza(Collections.emptyMap());
            zzayh zzayh = new zzayh(this);
            zzefx zzefx = zzbbw.zzf;
            zzefw zzh2 = zzefo.zzh(zza2, zzayh, zzefx);
            zzefw zzg2 = zzefo.zzg(zzh2, 10, TimeUnit.SECONDS, zzbbw.zzd);
            zzefo.zzo(zzh2, new zzayk(this, zzg2), zzefx);
            zzc.add(zzg2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzg(Map map) throws Exception {
        zzefw<O> zzi2;
        zzexn zzexn;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = optJSONArray.length();
                            synchronized (this.zzj) {
                                zzexn = this.zze.get(str);
                            }
                            if (zzexn == null) {
                                String valueOf = String.valueOf(str);
                                zzayq.zza(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzexn.zze(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zza;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zza = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzagi.zzb.zze().booleanValue()) {
                    zzbbk.zze("Failed to get SafeBrowsing metadata", e);
                }
                return zzefo.zzb(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zza(zzexj.OCTAGON_AD_SB_MATCH);
            }
        }
        boolean z3 = this.zza;
        if ((!z3 || !this.zzi.zzg) && ((!this.zzm || !this.zzi.zzf) && (z3 || !this.zzi.zzd))) {
            return zzefo.zza(null);
        }
        synchronized (this.zzj) {
            for (zzexn zzah : this.zze.values()) {
                this.zzd.zzg((zzexo) zzah.zzah());
            }
            this.zzd.zzm(this.zzf);
            this.zzd.zzn(this.zzg);
            if (zzayq.zzb()) {
                String zzb2 = this.zzd.zzb();
                String zzh2 = this.zzd.zzh();
                StringBuilder sb = new StringBuilder(String.valueOf(zzb2).length() + 53 + String.valueOf(zzh2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(zzb2);
                sb.append("\n  clickUrl: ");
                sb.append(zzh2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzexo next : this.zzd.zzf()) {
                    sb2.append("    [");
                    sb2.append(next.zzc());
                    sb2.append("] ");
                    sb2.append(next.zza());
                }
                zzayq.zza(sb2.toString());
            }
            zzefw<String> zzb3 = new zzbe(this.zzh).zzb(1, this.zzi.zzb, (Map<String, String>) null, ((zzexr) this.zzd.zzah()).zzao());
            if (zzayq.zzb()) {
                zzb3.zze(zzayi.zza, zzbbw.zza);
            }
            zzi2 = zzefo.zzi(zzb3, zzayj.zza, zzbbw.zzf);
        }
        return zzi2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Bitmap bitmap) {
        zzesd zzA = zzesf.zzA();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzA);
        synchronized (this.zzj) {
            zzewp zzewp = this.zzd;
            zzexc zza2 = zzexg.zza();
            zza2.zzc(zzA.zza());
            zza2.zzb("image/png");
            zza2.zza(zzexf.TYPE_CREATIVE);
            zzewp.zzk((zzexg) zza2.zzah());
        }
    }
}
