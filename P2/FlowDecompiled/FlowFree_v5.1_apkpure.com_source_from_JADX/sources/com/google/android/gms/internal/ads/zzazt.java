package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzazt {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicReference<ExecutorService> zzb = new AtomicReference<>((Object) null);
    private final Object zzc = new Object();
    @GuardedBy("gmpAppIdLock")
    private String zzd = null;
    @GuardedBy("gmpAppIdLock")
    private String zze = null;
    private final AtomicInteger zzf = new AtomicInteger(-1);
    private final AtomicReference<Object> zzg = new AtomicReference<>((Object) null);
    private final AtomicReference<Object> zzh = new AtomicReference<>((Object) null);
    private final ConcurrentMap<String, Method> zzi = new ConcurrentHashMap(9);
    private final AtomicReference<zzbhx> zzj = new AtomicReference<>((Object) null);
    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> zzk = new ArrayBlockingQueue(20);
    private final Object zzl = new Object();

    private final void zzA(String str, boolean z) {
        if (!this.zza.get()) {
            StringBuilder sb = new StringBuilder(str.length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzbbk.zzi(sb.toString());
            if (z) {
                zzbbk.zzi("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zza.set(true);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.concurrent.ExecutorService zzB() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzb
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0065
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzebm r0 = com.google.android.gms.internal.ads.zzebp.zza()
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaeq.zzab
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzazq r2 = new com.google.android.gms.internal.ads.zzazq
            r2.<init>(r9)
            r3 = 2
            java.util.concurrent.ExecutorService r0 = r0.zza(r1, r2, r3)
            goto L_0x005f
        L_0x002d:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaeq.zzab
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r2 = r2.zzb(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.android.gms.internal.ads.zzaeo r3 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.LinkedBlockingQueue r7 = new java.util.concurrent.LinkedBlockingQueue
            r7.<init>()
            com.google.android.gms.internal.ads.zzazq r8 = new com.google.android.gms.internal.ads.zzazq
            r8.<init>(r9)
            r4 = 1
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x005f:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r1 = r9.zzb
            r2 = 0
            r1.compareAndSet(r2, r0)
        L_0x0065:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzb
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazt.zzB():java.util.concurrent.ExecutorService");
    }

    private final boolean zzC(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                zzA("getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zzD(String str, zzazs zzazs) {
        synchronized (this.zzj) {
            FutureTask futureTask = new FutureTask(new zzazg(this, zzazs, str), (Object) null);
            if (this.zzj.get() != null) {
                futureTask.run();
            } else {
                this.zzk.offer(futureTask);
            }
        }
    }

    private final <T> T zzE(String str, T t, zzazr<T> zzazr) {
        synchronized (this.zzj) {
            if (this.zzj.get() != null) {
                try {
                    T zza2 = zzazr.zza(this.zzj.get());
                    return zza2;
                } catch (Exception unused) {
                    zzA(str, false);
                    return t;
                }
            }
        }
    }

    static final boolean zzv(Context context) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzac)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzaaa.zzc().zzb(zzaeq.zzad)).intValue()) {
            return false;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzae)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final void zzw(Context context, String str, String str2, Bundle bundle) {
        String str3;
        Class<String> cls = String.class;
        if (zzb(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str3 = "Invalid event ID: ".concat(valueOf);
                } else {
                    str3 = new String("Invalid event ID: ");
                }
                zzbbk.zzg(str3, e);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzv(context)) {
                zzD("logEventInternal", new zzazf(str, bundle2));
            } else if (zzC(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
                Method method = (Method) this.zzi.get("logEventInternal");
                if (method == null) {
                    try {
                        method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{cls, cls, Bundle.class});
                        this.zzi.put("logEventInternal", method);
                    } catch (Exception unused) {
                        zzA("logEventInternal", true);
                        method = null;
                    }
                }
                try {
                    method.invoke(this.zzg.get(), new Object[]{"am", str, bundle2});
                } catch (Exception unused2) {
                    zzA("logEventInternal", true);
                }
            }
        }
    }

    private final Method zzx(Context context, String str) {
        Method method = (Method) this.zzi.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzi.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzA(str, false);
            return null;
        }
    }

    private final void zzy(Context context, String str, String str2) {
        if (zzC(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            Method method = (Method) this.zzi.get(str2);
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, new Class[]{String.class});
                    this.zzi.put(str2, method);
                } catch (Exception unused) {
                    zzA(str2, false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzg.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(str2.length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zze.zza(sb.toString());
            } catch (Exception unused2) {
                zzA(str2, false);
            }
        }
    }

    private final Object zzz(String str, Context context) {
        if (!zzC(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            return null;
        }
        try {
            return zzx(context, str).invoke(this.zzg.get(), new Object[0]);
        } catch (Exception unused) {
            zzA(str, true);
            return null;
        }
    }

    public final boolean zza() {
        synchronized (this.zzl) {
        }
        return false;
    }

    public final boolean zzb(Context context) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzV)).booleanValue() && !this.zza.get()) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaf)).booleanValue()) {
                return true;
            }
            if (this.zzf.get() == -1) {
                zzzy.zza();
                if (!zzbbd.zzn(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzzy.zza();
                    if (zzbbd.zzo(context)) {
                        zzbbk.zzi("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzf.set(0);
                    }
                }
                this.zzf.set(1);
            }
            if (this.zzf.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void zzc(Context context, zzads zzads) {
        zzazu.zzd(context).zzb().zzc(zzads);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzah)).booleanValue() && zzb(context) && zzv(context)) {
            synchronized (this.zzl) {
            }
        }
    }

    public final void zzd(Context context, zzys zzys) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzah)).booleanValue() && zzb(context) && zzv(context)) {
            synchronized (this.zzl) {
            }
        }
    }

    public final void zze(Bundle bundle) {
        zzD("setConsent", new zzazc(bundle));
    }

    public final void zzf(Context context, String str) {
        if (zzb(context)) {
            if (zzv(context)) {
                zzD("beginAdUnitExposure", new zzazi(str));
            } else {
                zzy(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzg(Context context, String str) {
        if (zzb(context)) {
            if (zzv(context)) {
                zzD("endAdUnitExposure", new zzazj(str));
            } else {
                zzy(context, str, "endAdUnitExposure");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzh(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzb(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = zzv(r7)
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzazr r7 = com.google.android.gms.internal.ads.zzazk.zza
            java.lang.String r0 = "getCurrentScreenNameOrScreenClass"
            java.lang.Object r7 = r6.zzE(r0, r2, r7)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r6.zzg
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurement"
            boolean r1 = r6.zzC(r7, r4, r1, r3)
            if (r1 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            java.lang.reflect.Method r3 = r6.zzx(r7, r0)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r6.zzg     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.zzx(r7, r3)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r6.zzg     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            return r3
        L_0x0055:
            return r2
        L_0x0056:
            r6.zzA(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazt.zzh(android.content.Context):java.lang.String");
    }

    @Deprecated
    public final void zzi(Context context, String str) {
        Class<String> cls = String.class;
        if (!zzb(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzv(context)) {
            zzD("setScreenName", new zzazl(context, str));
        } else if (zzC(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzh, false)) {
            Method method = (Method) this.zzi.get("setCurrentScreen");
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", new Class[]{Activity.class, cls, cls});
                    this.zzi.put("setCurrentScreen", method);
                } catch (Exception unused) {
                    zzA("setCurrentScreen", false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzh.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused2) {
                zzA("setCurrentScreen", false);
            }
        }
    }

    public final String zzj(Context context) {
        if (!zzb(context)) {
            return null;
        }
        synchronized (this.zzc) {
            String str = this.zzd;
            if (str != null) {
                return str;
            }
            if (zzv(context)) {
                this.zzd = (String) zzE("getGmpAppId", this.zzd, zzazm.zza);
            } else {
                this.zzd = (String) zzz("getGmpAppId", context);
            }
            String str2 = this.zzd;
            return str2;
        }
    }

    public final String zzk(Context context) {
        if (!zzb(context)) {
            return null;
        }
        long longValue = ((Long) zzaaa.zzc().zzb(zzaeq.zzaa)).longValue();
        if (zzv(context)) {
            if (longValue >= 0) {
                return (String) zzB().submit(new zzazo(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zzE("getAppInstanceId", (Object) null, zzazn.zza);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zzz("getAppInstanceId", context);
        } else {
            try {
                return (String) zzB().submit(new zzazp(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    public final String zzl(Context context) {
        if (!zzb(context)) {
            return null;
        }
        if (zzv(context)) {
            Long l = (Long) zzE("getAdEventId", (Object) null, zzazd.zza);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zzz = zzz("generateEventId", context);
        if (zzz != null) {
            return zzz.toString();
        }
        return null;
    }

    public final String zzm(Context context) {
        if (!zzb(context)) {
            return null;
        }
        synchronized (this.zzc) {
            String str = this.zze;
            if (str != null) {
                return str;
            }
            if (zzv(context)) {
                this.zze = (String) zzE("getAppIdOrigin", this.zze, zzaze.zza);
            } else {
                this.zze = "fa";
            }
            String str2 = this.zze;
            return str2;
        }
    }

    public final void zzn(Context context, String str) {
        zzw(context, "_ac", str, (Bundle) null);
    }

    public final void zzo(Context context, String str) {
        zzw(context, "_ai", str, (Bundle) null);
    }

    public final void zzp(Context context, String str) {
        zzw(context, "_aq", str, (Bundle) null);
    }

    public final void zzq(Context context, String str) {
        zzw(context, "_aa", str, (Bundle) null);
    }

    public final void zzr(Context context, String str, String str2, String str3, int i) {
        if (zzb(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zzw(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zze.zza(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(zzazs zzazs, String str) {
        if (this.zzj.get() != null) {
            try {
                zzazs.zza(this.zzj.get());
            } catch (Exception unused) {
                zzA(str, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzt(Context context) throws Exception {
        return (String) zzz("getAppInstanceId", context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzu() throws Exception {
        return (String) zzE("getAppInstanceId", (Object) null, zzazh.zza);
    }
}
