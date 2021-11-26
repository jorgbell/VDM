package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeht {
    private static final Logger zza = Logger.getLogger(zzeht.class.getName());
    private static final ConcurrentMap<String, zzehs> zzb = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzehr> zzc = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzegr<?>> zze = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzehl<?, ?>> zzf = new ConcurrentHashMap();

    private zzeht() {
    }

    @Deprecated
    public static zzegr<?> zza(String str) throws GeneralSecurityException {
        if (str != null) {
            ConcurrentMap<String, zzegr<?>> concurrentMap = zze;
            Locale locale = Locale.US;
            zzegr<?> zzegr = (zzegr) concurrentMap.get(str.toLowerCase(locale));
            if (zzegr != null) {
                return zzegr;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(locale).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkpublickeysign") || str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static synchronized <KeyProtoT extends zzeuo> void zzc(zzehb<KeyProtoT> zzehb, boolean z) throws GeneralSecurityException {
        synchronized (zzeht.class) {
            String zzb2 = zzehb.zzb();
            zzo(zzb2, zzehb.getClass(), true);
            ConcurrentMap<String, zzehs> concurrentMap = zzb;
            if (!concurrentMap.containsKey(zzb2)) {
                concurrentMap.put(zzb2, new zzehp(zzehb));
                zzc.put(zzb2, new zzehr(zzehb));
            }
            zzd.put(zzb2, Boolean.TRUE);
        }
    }

    public static synchronized <KeyProtoT extends zzeuo, PublicKeyProtoT extends zzeuo> void zzd(zzehn<KeyProtoT, PublicKeyProtoT> zzehn, zzehb<PublicKeyProtoT> zzehb, boolean z) throws GeneralSecurityException {
        Class<?> zze2;
        synchronized (zzeht.class) {
            zzo("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzehn.getClass(), true);
            zzo("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzehb.getClass(), false);
            ConcurrentMap<String, zzehs> concurrentMap = zzb;
            if (concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (zze2 = ((zzehs) concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze()) != null) {
                if (!zze2.equals(zzehb.getClass())) {
                    zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey with inconsistent public key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzehn.getClass().getName(), zze2.getName(), zzehb.getClass().getName()}));
                }
            }
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || ((zzehs) concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze() == null) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzehq(zzehn, zzehb));
                zzc.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzehr(zzehn));
            }
            ConcurrentMap<String, Boolean> concurrentMap2 = zzd;
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", Boolean.TRUE);
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", new zzehp(zzehb));
            }
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", Boolean.FALSE);
        }
    }

    public static synchronized <B, P> void zze(zzehl<B, P> zzehl) throws GeneralSecurityException {
        synchronized (zzeht.class) {
            if (zzehl != null) {
                Class<P> zzb2 = zzehl.zzb();
                ConcurrentMap<Class<?>, zzehl<?, ?>> concurrentMap = zzf;
                if (concurrentMap.containsKey(zzb2)) {
                    zzehl zzehl2 = (zzehl) concurrentMap.get(zzb2);
                    if (!zzehl.getClass().equals(zzehl2.getClass())) {
                        Logger logger = zza;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzb2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzb2.getName(), zzehl2.getClass().getName(), zzehl.getClass().getName()}));
                    }
                }
                concurrentMap.put(zzb2, zzehl);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static zzegw<?> zzf(String str) throws GeneralSecurityException {
        return zzn(str).zzb();
    }

    public static synchronized zzeny zzg(zzeod zzeod) throws GeneralSecurityException {
        zzeny zzf2;
        synchronized (zzeht.class) {
            zzegw<?> zzf3 = zzf(zzeod.zza());
            if (((Boolean) zzd.get(zzeod.zza())).booleanValue()) {
                zzf2 = zzf3.zzf(zzeod.zzc());
            } else {
                String valueOf = String.valueOf(zzeod.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzf2;
    }

    public static synchronized zzeuo zzh(zzeod zzeod) throws GeneralSecurityException {
        zzeuo zzc2;
        synchronized (zzeht.class) {
            zzegw<?> zzf2 = zzf(zzeod.zza());
            if (((Boolean) zzd.get(zzeod.zza())).booleanValue()) {
                zzc2 = zzf2.zzc(zzeod.zzc());
            } else {
                String valueOf = String.valueOf(zzeod.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzc2;
    }

    public static <P> P zzi(String str, zzeuo zzeuo, Class<P> cls) throws GeneralSecurityException {
        return zzp(str, cls).zzb(zzeuo);
    }

    public static <P> P zzj(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zzq(str, zzesf.zzs(bArr), cls);
    }

    public static <P> P zzk(zzeny zzeny, Class<P> cls) throws GeneralSecurityException {
        return zzq(zzeny.zza(), zzeny.zzc(), cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzehk, com.google.android.gms.internal.ads.zzehk<B>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <B, P> P zzl(com.google.android.gms.internal.ads.zzehk<B> r4, java.lang.Class<P> r5) throws java.security.GeneralSecurityException {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.google.android.gms.internal.ads.zzehl<?, ?>> r0 = zzf
            java.lang.Object r5 = r0.get(r5)
            com.google.android.gms.internal.ads.zzehl r5 = (com.google.android.gms.internal.ads.zzehl) r5
            if (r5 != 0) goto L_0x002e
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            java.lang.Class r4 = r4.zze()
            java.lang.String r4 = r4.getName()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "No wrapper found for "
            int r1 = r4.length()
            if (r1 == 0) goto L_0x0025
            java.lang.String r4 = r0.concat(r4)
            goto L_0x002a
        L_0x0025:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x002a:
            r5.<init>(r4)
            throw r5
        L_0x002e:
            java.lang.Class r0 = r5.zzc()
            java.lang.Class r1 = r4.zze()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            java.lang.Object r4 = r5.zza(r4)
            return r4
        L_0x0041:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Class r5 = r5.zzc()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Class r4 = r4.zze()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            java.lang.String r2 = java.lang.String.valueOf(r4)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = r1 + 44
            int r1 = r1 + r2
            r3.<init>(r1)
            java.lang.String r1 = "Wrong input primitive class, expected "
            r3.append(r1)
            r3.append(r5)
            java.lang.String r5 = ", got "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = r3.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeht.zzl(com.google.android.gms.internal.ads.zzehk, java.lang.Class):java.lang.Object");
    }

    public static Class<?> zzm(Class<?> cls) {
        zzehl zzehl = (zzehl) zzf.get(cls);
        if (zzehl == null) {
            return null;
        }
        return zzehl.zzc();
    }

    private static synchronized zzehs zzn(String str) throws GeneralSecurityException {
        zzehs zzehs;
        synchronized (zzeht.class) {
            ConcurrentMap<String, zzehs> concurrentMap = zzb;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzehs = (zzehs) concurrentMap.get(str);
        }
        return zzehs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void zzo(java.lang.String r6, java.lang.Class<?> r7, boolean r8) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzeht> r0 = com.google.android.gms.internal.ads.zzeht.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzehs> r1 = zzb     // Catch:{ all -> 0x0089 }
            boolean r2 = r1.containsKey(r6)     // Catch:{ all -> 0x0089 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0089 }
            com.google.android.gms.internal.ads.zzehs r1 = (com.google.android.gms.internal.ads.zzehs) r1     // Catch:{ all -> 0x0089 }
            java.lang.Class r2 = r1.zzc()     // Catch:{ all -> 0x0089 }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0089 }
            if (r2 != 0) goto L_0x005f
            java.util.logging.Logger r8 = zza     // Catch:{ all -> 0x0089 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Attempted overwrite of a registered key manager for key type "
            int r4 = r6.length()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x002e
            java.lang.String r3 = r3.concat(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x0034
        L_0x002e:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0089 }
            r4.<init>(r3)     // Catch:{ all -> 0x0089 }
            r3 = r4
        L_0x0034:
            java.lang.String r4 = "com.google.crypto.tink.Registry"
            java.lang.String r5 = "ensureKeyManagerInsertable"
            r8.logp(r2, r4, r5, r3)     // Catch:{ all -> 0x0089 }
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0089 }
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0089 }
            r3 = 0
            r2[r3] = r6     // Catch:{ all -> 0x0089 }
            r6 = 1
            java.lang.Class r1 = r1.zzc()     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0089 }
            r2[r6] = r1     // Catch:{ all -> 0x0089 }
            r6 = 2
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0089 }
            r2[r6] = r7     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            java.lang.String r6 = java.lang.String.format(r6, r2)     // Catch:{ all -> 0x0089 }
            r8.<init>(r6)     // Catch:{ all -> 0x0089 }
            throw r8     // Catch:{ all -> 0x0089 }
        L_0x005f:
            if (r8 == 0) goto L_0x0087
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r7 = zzd     // Catch:{ all -> 0x0089 }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ all -> 0x0089 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0089 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0089 }
            if (r7 != 0) goto L_0x0087
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0089 }
            java.lang.String r8 = "New keys are already disallowed for key type "
            int r1 = r6.length()     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x007e
            java.lang.String r6 = r8.concat(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x0083
        L_0x007e:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0089 }
            r6.<init>(r8)     // Catch:{ all -> 0x0089 }
        L_0x0083:
            r7.<init>(r6)     // Catch:{ all -> 0x0089 }
            throw r7     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r0)
            return
        L_0x0089:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeht.zzo(java.lang.String, java.lang.Class, boolean):void");
    }

    private static <P> zzegw<P> zzp(String str, Class<P> cls) throws GeneralSecurityException {
        zzehs zzn = zzn(str);
        if (zzn.zzd().contains(cls)) {
            return zzn.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzn.zzc());
        Set<Class<?>> zzd2 = zzn.zzd();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzd2) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        int length = String.valueOf(name).length();
        StringBuilder sb3 = new StringBuilder(length + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    private static <P> P zzq(String str, zzesf zzesf, Class<P> cls) throws GeneralSecurityException {
        return zzp(str, cls).zza(zzesf);
    }

    public static synchronized <P> void zzb(zzegw<P> zzegw, boolean z) throws GeneralSecurityException {
        synchronized (zzeht.class) {
            if (zzegw != null) {
                String zzd2 = zzegw.zzd();
                zzo(zzd2, zzegw.getClass(), z);
                zzb.putIfAbsent(zzd2, new zzeho(zzegw));
                zzd.put(zzd2, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }
}
