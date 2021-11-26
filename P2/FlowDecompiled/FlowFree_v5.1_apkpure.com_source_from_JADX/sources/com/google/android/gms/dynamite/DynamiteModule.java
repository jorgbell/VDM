package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class DynamiteModule {
    @RecentlyNonNull
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzh();
    @RecentlyNonNull
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzi();
    @RecentlyNonNull
    public static final VersionPolicy PREFER_REMOTE = new zzd();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzb = null;
    @GuardedBy("DynamiteModule.class")
    private static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    private static int zzd = -1;
    private static final ThreadLocal<zzk> zze = new ThreadLocal<>();
    private static final ThreadLocal<Long> zzf = new zzb();
    private static final zzm zzg = new zzc();
    @GuardedBy("DynamiteModule.class")
    private static zzo zzi;
    @GuardedBy("DynamiteModule.class")
    private static zzp zzj;
    private final Context zzh;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzb zzb) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzb zzb) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface VersionPolicy {
        zzn zza(Context context, String str, zzm zzm) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzh = context;
    }

    public static int getLocalVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int getRemoteVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        return zza(context, str, false);
    }

    @RecentlyNonNull
    public static DynamiteModule load(@RecentlyNonNull Context context, @RecentlyNonNull VersionPolicy versionPolicy, @RecentlyNonNull String str) throws LoadingException {
        int i;
        Boolean bool;
        DynamiteModule dynamiteModule;
        IObjectWrapper iObjectWrapper;
        zzp zzp;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy2 = versionPolicy;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        ThreadLocal<zzk> threadLocal = zze;
        zzk zzk = threadLocal.get();
        zzk zzk2 = new zzk((zzb) null);
        threadLocal.set(zzk2);
        ThreadLocal<Long> threadLocal2 = zzf;
        long longValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            zzn zza = versionPolicy2.zza(context2, str2, zzg);
            int i2 = zza.zza;
            int i3 = zza.zzb;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = zza.zzc;
            if (i4 == 0 || ((i4 == -1 && zza.zza == 0) || (i4 == 1 && zza.zzb == 0))) {
                int i5 = zza.zza;
                int i6 = zza.zzb;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (zzb) null);
            } else if (i4 == -1) {
                DynamiteModule zzd2 = zzd(context2, str2);
                if (longValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(longValue));
                }
                Cursor cursor = zzk2.zza;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(zzk);
                return zzd2;
            } else if (i4 == 1) {
                try {
                    int i7 = zza.zzb;
                    try {
                        synchronized (cls) {
                            bool = zzb;
                        }
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 51);
                                sb3.append("Selected remote version of ");
                                sb3.append(str2);
                                sb3.append(", version >= ");
                                sb3.append(i7);
                                Log.i("DynamiteModule", sb3.toString());
                                synchronized (cls) {
                                    zzp = zzj;
                                }
                                if (zzp != null) {
                                    zzk zzk3 = threadLocal.get();
                                    if (zzk3 == null || zzk3.zza == null) {
                                        throw new LoadingException("No result cursor", (zzb) null);
                                    }
                                    Context applicationContext = context.getApplicationContext();
                                    Cursor cursor2 = zzk3.zza;
                                    ObjectWrapper.wrap(null);
                                    synchronized (cls) {
                                        valueOf = Boolean.valueOf(zzd >= 2);
                                    }
                                    if (valueOf.booleanValue()) {
                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                        iObjectWrapper2 = zzp.zzf(ObjectWrapper.wrap(applicationContext), str2, i7, ObjectWrapper.wrap(cursor2));
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                        iObjectWrapper2 = zzp.zze(ObjectWrapper.wrap(applicationContext), str2, i7, ObjectWrapper.wrap(cursor2));
                                    }
                                    Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                    if (context3 != null) {
                                        dynamiteModule = new DynamiteModule(context3);
                                    } else {
                                        throw new LoadingException("Failed to get module context", (zzb) null);
                                    }
                                } else {
                                    throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzb) null);
                                }
                            } else {
                                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 51);
                                sb4.append("Selected remote version of ");
                                sb4.append(str2);
                                sb4.append(", version >= ");
                                sb4.append(i7);
                                Log.i("DynamiteModule", sb4.toString());
                                zzo zzf2 = zzf(context);
                                if (zzf2 != null) {
                                    int zzi2 = zzf2.zzi();
                                    if (zzi2 >= 3) {
                                        zzk zzk4 = threadLocal.get();
                                        if (zzk4 != null) {
                                            iObjectWrapper = zzf2.zzk(ObjectWrapper.wrap(context), str2, i7, ObjectWrapper.wrap(zzk4.zza));
                                        } else {
                                            throw new LoadingException("No cached result cursor holder", (zzb) null);
                                        }
                                    } else if (zzi2 == 2) {
                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                        iObjectWrapper = zzf2.zzg(ObjectWrapper.wrap(context), str2, i7);
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                        iObjectWrapper = zzf2.zze(ObjectWrapper.wrap(context), str2, i7);
                                    }
                                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                                        dynamiteModule = new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                                    } else {
                                        throw new LoadingException("Failed to load remote module.", (zzb) null);
                                    }
                                } else {
                                    throw new LoadingException("Failed to create IDynamiteLoader.", (zzb) null);
                                }
                            }
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor3 = zzk2.zza;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            threadLocal.set(zzk);
                            return dynamiteModule;
                        }
                        throw new LoadingException("Failed to determine which loading route to use.", (zzb) null);
                    } catch (RemoteException e) {
                        throw new LoadingException("Failed to load remote module.", e, (zzb) null);
                    } catch (LoadingException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        CrashUtils.addDynamiteErrorToDropBox(context2, th);
                        throw new LoadingException("Failed to load remote module.", th, (zzb) null);
                    }
                } catch (LoadingException e3) {
                    String valueOf2 = String.valueOf(e3.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to load remote module: ".concat(valueOf2) : new String("Failed to load remote module: "));
                    int i8 = zza.zza;
                    if (i8 != 0) {
                        if (versionPolicy.zza(context2, str2, new zzl(i8, 0)).zzc == -1) {
                            DynamiteModule zzd3 = zzd(context2, str2);
                            if (i != 0) {
                                zzf.set(Long.valueOf(longValue));
                            }
                            return zzd3;
                        }
                    }
                    throw new LoadingException("Remote load failed. No local fallback found.", e3, (zzb) null);
                }
            } else {
                StringBuilder sb5 = new StringBuilder(47);
                sb5.append("VersionPolicy returned invalid code:");
                sb5.append(0);
                throw new LoadingException(sb5.toString(), (zzb) null);
            }
        } finally {
            if (longValue == 0) {
                zzf.remove();
            } else {
                zzf.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = zzk2.zza;
            if (cursor4 != null) {
                cursor4.close();
            }
            zze.set(zzk);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0095=Splitter:B:39:0x0095, B:23:0x0056=Splitter:B:23:0x0056, B:18:0x0039=Splitter:B:18:0x0039} */
    public static int zza(@androidx.annotation.RecentlyNonNull android.content.Context r9, @androidx.annotation.RecentlyNonNull java.lang.String r10, boolean r11) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01b3 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01b0 }
            r2 = 0
            if (r1 != 0) goto L_0x00d3
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r3 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.Class r1 = r1.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.String r3 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.Class r3 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            monitor-enter(r3)     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
            java.lang.Object r4 = r1.get(r2)     // Catch:{ all -> 0x00a3 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x003c
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a3 }
            if (r4 != r1) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a3 }
            goto L_0x00a1
        L_0x0036:
            zze(r4)     // Catch:{ LoadingException -> 0x0039 }
        L_0x0039:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a3 }
            goto L_0x00a1
        L_0x003c:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r9.getApplicationContext()     // Catch:{ all -> 0x00a3 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x00a3 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x0056
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a3 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a3 }
            goto L_0x00a1
        L_0x0056:
            int r4 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x0098 }
            java.lang.String r5 = zzc     // Catch:{ LoadingException -> 0x0098 }
            if (r5 == 0) goto L_0x0095
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0098 }
            if (r5 == 0) goto L_0x0065
            goto L_0x0095
        L_0x0065:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x0098 }
            r6 = 29
            if (r5 < r6) goto L_0x007a
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x0098 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x0098 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x0098 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0098 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0098 }
            goto L_0x0088
        L_0x007a:
            com.google.android.gms.dynamite.zza r5 = new com.google.android.gms.dynamite.zza     // Catch:{ LoadingException -> 0x0098 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x0098 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x0098 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0098 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0098 }
        L_0x0088:
            zze(r5)     // Catch:{ LoadingException -> 0x0098 }
            r1.set(r2, r5)     // Catch:{ LoadingException -> 0x0098 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0098 }
            zzb = r5     // Catch:{ LoadingException -> 0x0098 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r0)     // Catch:{ all -> 0x01b0 }
            return r4
        L_0x0095:
            monitor-exit(r3)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r0)     // Catch:{ all -> 0x01b0 }
            return r4
        L_0x0098:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a3 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a3 }
        L_0x00a1:
            monitor-exit(r3)     // Catch:{ all -> 0x00a3 }
            goto L_0x00d1
        L_0x00a3:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a3 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00aa, IllegalAccessException -> 0x00a8, NoSuchFieldException -> 0x00a6 }
        L_0x00a6:
            r1 = move-exception
            goto L_0x00ab
        L_0x00a8:
            r1 = move-exception
            goto L_0x00ab
        L_0x00aa:
            r1 = move-exception
        L_0x00ab:
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x01b0 }
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x01b0 }
            int r4 = r4.length()     // Catch:{ all -> 0x01b0 }
            int r4 = r4 + 30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r5.<init>(r4)     // Catch:{ all -> 0x01b0 }
            java.lang.String r4 = "Failed to load module via V2: "
            r5.append(r4)     // Catch:{ all -> 0x01b0 }
            r5.append(r1)     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01b0 }
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x01b0 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01b0 }
        L_0x00d1:
            zzb = r1     // Catch:{ all -> 0x01b0 }
        L_0x00d3:
            monitor-exit(r0)     // Catch:{ all -> 0x01b0 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01b3 }
            r1 = 0
            if (r0 == 0) goto L_0x0101
            int r9 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x00e0 }
            return r9
        L_0x00e0:
            r10 = move-exception
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01b3 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x01b3 }
            int r2 = r10.length()     // Catch:{ all -> 0x01b3 }
            if (r2 == 0) goto L_0x00f8
            java.lang.String r10 = r0.concat(r10)     // Catch:{ all -> 0x01b3 }
            goto L_0x00fd
        L_0x00f8:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x01b3 }
            r10.<init>(r0)     // Catch:{ all -> 0x01b3 }
        L_0x00fd:
            android.util.Log.w(r11, r10)     // Catch:{ all -> 0x01b3 }
            return r1
        L_0x0101:
            com.google.android.gms.dynamite.zzo r3 = zzf(r9)     // Catch:{ all -> 0x01b3 }
            if (r3 != 0) goto L_0x0109
            goto L_0x01a9
        L_0x0109:
            int r0 = r3.zzi()     // Catch:{ RemoteException -> 0x0183 }
            r4 = 3
            if (r0 < r4) goto L_0x015d
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0183 }
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf     // Catch:{ RemoteException -> 0x0183 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0183 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0183 }
            long r7 = r0.longValue()     // Catch:{ RemoteException -> 0x0183 }
            r5 = r10
            r6 = r11
            com.google.android.gms.dynamic.IObjectWrapper r10 = r3.zzj(r4, r5, r6, r7)     // Catch:{ RemoteException -> 0x0183 }
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)     // Catch:{ RemoteException -> 0x0183 }
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ RemoteException -> 0x0183 }
            if (r10 == 0) goto L_0x014a
            boolean r11 = r10.moveToFirst()     // Catch:{ RemoteException -> 0x015a, all -> 0x0157 }
            if (r11 != 0) goto L_0x0135
            goto L_0x014a
        L_0x0135:
            int r11 = r10.getInt(r1)     // Catch:{ RemoteException -> 0x015a, all -> 0x0157 }
            if (r11 <= 0) goto L_0x0142
            boolean r0 = zzc(r10)     // Catch:{ RemoteException -> 0x015a, all -> 0x0157 }
            if (r0 == 0) goto L_0x0142
            goto L_0x0143
        L_0x0142:
            r2 = r10
        L_0x0143:
            if (r2 == 0) goto L_0x0148
            r2.close()     // Catch:{ all -> 0x01b3 }
        L_0x0148:
            r1 = r11
            goto L_0x01a9
        L_0x014a:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r0)     // Catch:{ RemoteException -> 0x015a, all -> 0x0157 }
            if (r10 == 0) goto L_0x01a9
            r10.close()     // Catch:{ all -> 0x01b3 }
            goto L_0x01a9
        L_0x0157:
            r11 = move-exception
            r2 = r10
            goto L_0x01aa
        L_0x015a:
            r11 = move-exception
            r2 = r10
            goto L_0x0185
        L_0x015d:
            r4 = 2
            if (r0 != r4) goto L_0x0170
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0183 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0183 }
            int r1 = r3.zzh(r0, r10, r11)     // Catch:{ RemoteException -> 0x0183 }
            goto L_0x01a9
        L_0x0170:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0183 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0183 }
            int r1 = r3.zzf(r0, r10, r11)     // Catch:{ RemoteException -> 0x0183 }
            goto L_0x01a9
        L_0x0180:
            r10 = move-exception
            r11 = r10
            goto L_0x01aa
        L_0x0183:
            r10 = move-exception
            r11 = r10
        L_0x0185:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0180 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0180 }
            int r3 = r11.length()     // Catch:{ all -> 0x0180 }
            if (r3 == 0) goto L_0x019c
            java.lang.String r11 = r0.concat(r11)     // Catch:{ all -> 0x0180 }
            goto L_0x01a1
        L_0x019c:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0180 }
            r11.<init>(r0)     // Catch:{ all -> 0x0180 }
        L_0x01a1:
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0180 }
            if (r2 == 0) goto L_0x01a9
            r2.close()     // Catch:{ all -> 0x01b3 }
        L_0x01a9:
            return r1
        L_0x01aa:
            if (r2 == 0) goto L_0x01af
            r2.close()     // Catch:{ all -> 0x01b3 }
        L_0x01af:
            throw r11     // Catch:{ all -> 0x01b3 }
        L_0x01b0:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01b0 }
            throw r10     // Catch:{ all -> 0x01b3 }
        L_0x01b3:
            r10 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r9, r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        if (zzc(r9) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r9, java.lang.String r10, boolean r11) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r9 = "api_force_staging"
            java.lang.String r4 = "api"
            r5 = 1
            if (r5 == r11) goto L_0x0019
            r9 = r4
        L_0x0019:
            android.net.Uri$Builder r11 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r11.<init>()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r11 = r11.scheme(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r11 = r11.authority(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r11.path(r9)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r9.appendPath(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r10 = "requestStartTime"
            java.lang.String r11 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r10, r11)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri r4 = r9.build()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r9 == 0) goto L_0x0081
            boolean r10 = r9.moveToFirst()     // Catch:{ Exception -> 0x0090 }
            if (r10 == 0) goto L_0x0081
            r10 = 0
            int r10 = r9.getInt(r10)     // Catch:{ Exception -> 0x0090 }
            if (r10 <= 0) goto L_0x007a
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r11 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r11)     // Catch:{ Exception -> 0x0090 }
            r1 = 2
            java.lang.String r1 = r9.getString(r1)     // Catch:{ all -> 0x0077 }
            zzc = r1     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x0077 }
            if (r1 < 0) goto L_0x006f
            int r1 = r9.getInt(r1)     // Catch:{ all -> 0x0077 }
            zzd = r1     // Catch:{ all -> 0x0077 }
        L_0x006f:
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            boolean r11 = zzc(r9)     // Catch:{ Exception -> 0x0090 }
            if (r11 == 0) goto L_0x007a
            goto L_0x007b
        L_0x0077:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            throw r10     // Catch:{ Exception -> 0x0090 }
        L_0x007a:
            r0 = r9
        L_0x007b:
            if (r0 == 0) goto L_0x0080
            r0.close()
        L_0x0080:
            return r10
        L_0x0081:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r11 = "Failed to retrieve remote module version."
            android.util.Log.w(r10, r11)     // Catch:{ Exception -> 0x0090 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0090 }
            java.lang.String r11 = "Failed to connect to dynamite module ContentResolver."
            r10.<init>(r11, r0)     // Catch:{ Exception -> 0x0090 }
            throw r10     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            r10 = move-exception
            goto L_0x0098
        L_0x0092:
            r9 = move-exception
            r10 = r9
            goto L_0x00a7
        L_0x0095:
            r9 = move-exception
            r10 = r9
            r9 = r0
        L_0x0098:
            boolean r11 = r10 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00a5 }
            if (r11 == 0) goto L_0x009d
            throw r10     // Catch:{ all -> 0x00a5 }
        L_0x009d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = "V2 version check failed"
            r11.<init>(r1, r10, r0)     // Catch:{ all -> 0x00a5 }
            throw r11     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r10 = move-exception
            r0 = r9
        L_0x00a7:
            if (r0 == 0) goto L_0x00ac
            r0.close()
        L_0x00ac:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean zzc(Cursor cursor) {
        zzk zzk = zze.get();
        if (zzk == null || zzk.zza != null) {
            return false;
        }
        zzk.zza = cursor;
        return true;
    }

    private static DynamiteModule zzd(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    private static void zze(ClassLoader classLoader) throws LoadingException {
        zzp zzp;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzp = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzp) {
                    zzp = (zzp) queryLocalInterface;
                } else {
                    zzp = new zzp(iBinder);
                }
            }
            zzj = zzp;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzb) null);
        }
    }

    private static zzo zzf(Context context) {
        zzo zzo;
        synchronized (DynamiteModule.class) {
            zzo zzo2 = zzi;
            if (zzo2 != null) {
                return zzo2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzo = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzo) {
                        zzo = (zzo) queryLocalInterface;
                    } else {
                        zzo = new zzo(iBinder);
                    }
                }
                if (zzo != null) {
                    zzi = zzo;
                    return zzo;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    @RecentlyNonNull
    public Context getModuleContext() {
        return this.zzh;
    }

    @RecentlyNonNull
    public IBinder instantiate(@RecentlyNonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzh.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zzb) null);
        }
    }
}
