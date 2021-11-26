package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhl {
    private final zzge zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class<?>[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzhl(zzge zzge, String str, String str2, Class<?>... clsArr) {
        this.zzb = zzge;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzge.zzd().submit(new zzhk(this));
    }

    static /* synthetic */ void zzb(zzhl zzhl) {
        CountDownLatch countDownLatch;
        try {
            Class loadClass = zzhl.zzb.zze().loadClass(zzhl.zzc(zzhl.zzb.zzg(), zzhl.zzc));
            if (loadClass == null) {
                countDownLatch = zzhl.zzg;
            } else {
                zzhl.zze = loadClass.getMethod(zzhl.zzc(zzhl.zzb.zzg(), zzhl.zzd), zzhl.zzf);
                if (zzhl.zze == null) {
                    countDownLatch = zzhl.zzg;
                }
                countDownLatch = zzhl.zzg;
            }
        } catch (zzfj | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzhl.zzg;
        } catch (Throwable th) {
            zzhl.zzg.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzfj, UnsupportedEncodingException {
        return new String(this.zzb.zzf().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
