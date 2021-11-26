package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqs;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeqk<T_WRAPPER extends zzeqs<T_ENGINE>, T_ENGINE> {
    public static final zzeqk<zzeql, Cipher> zza = new zzeqk<>(new zzeql());
    public static final zzeqk<zzeqp, Mac> zzb = new zzeqk<>(new zzeqp());
    public static final zzeqk<zzeqm, KeyAgreement> zze = new zzeqk<>(new zzeqm());
    public static final zzeqk<zzeqo, KeyPairGenerator> zzf = new zzeqk<>(new zzeqo());
    public static final zzeqk<zzeqn, KeyFactory> zzg = new zzeqk<>(new zzeqn());
    private static final Logger zzh = Logger.getLogger(zzeqk.class.getName());
    private static final List<Provider> zzi;
    private final T_WRAPPER zzj;
    private final List<Provider> zzk = zzi;

    static {
        if (zzerc.zza()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzi = arrayList;
        } else {
            zzi = new ArrayList();
        }
    }

    public zzeqk(T_WRAPPER t_wrapper) {
        this.zzj = t_wrapper;
    }

    public final T_ENGINE zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : this.zzk) {
            try {
                return this.zzj.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zzj.zza(str, (Provider) null);
    }
}
