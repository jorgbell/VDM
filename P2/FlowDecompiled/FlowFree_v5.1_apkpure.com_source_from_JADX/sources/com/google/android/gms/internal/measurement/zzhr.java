package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhn;
import com.google.android.gms.internal.measurement.zzhr;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public abstract class zzhr<MessageType extends zzhr<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>> extends zzgc<MessageType, BuilderType> {
    private static final Map<Object, zzhr<?, ?>> zza = new ConcurrentHashMap();
    protected zzjw zzc = zzjw.zza();
    protected int zzd = -1;

    static Object zzbA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static zzhw zzbB() {
        return zzhs.zzd();
    }

    protected static zzhx zzbC() {
        return zzil.zzf();
    }

    protected static zzhx zzbD(zzhx zzhx) {
        int size = zzhx.size();
        return zzhx.zzd(size == 0 ? 10 : size + size);
    }

    protected static <E> zzhy<E> zzbE() {
        return zzjf.zzd();
    }

    protected static <E> zzhy<E> zzbF(zzhy<E> zzhy) {
        int size = zzhy.size();
        return zzhy.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzhr> T zzbx(Class<T> cls) {
        Map<Object, zzhr<?, ?>> map = zza;
        T t = (zzhr) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhr) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhr) ((zzhr) zzkf.zzc(cls)).zzl(6, (Object) null, (Object) null);
            if (t != null) {
                map.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzhr> void zzby(Class<T> cls, T t) {
        zza.put(cls, t);
    }

    protected static Object zzbz(zziw zziw, String str, Object[] objArr) {
        return new zzjg(zziw, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzje.zza().zzb(getClass()).zzb(this, (zzhr) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzje.zza().zzb(getClass()).zzc(this);
        this.zzb = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zziy.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zziv zzbG() {
        zzhn zzhn = (zzhn) zzl(5, (Object) null, (Object) null);
        zzhn.zzaB(this);
        return zzhn;
    }

    public final /* bridge */ /* synthetic */ zziv zzbH() {
        return (zzhn) zzl(5, (Object) null, (Object) null);
    }

    public final /* bridge */ /* synthetic */ zziw zzbK() {
        return (zzhr) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbq() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(int i) {
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzhr<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>> BuilderType zzbt() {
        return (zzhn) zzl(5, (Object) null, (Object) null);
    }

    public final BuilderType zzbu() {
        BuilderType buildertype = (zzhn) zzl(5, (Object) null, (Object) null);
        buildertype.zzaB(this);
        return buildertype;
    }

    public final void zzbv(zzgy zzgy) throws IOException {
        zzje.zza().zzb(getClass()).zzm(this, zzgz.zza(zzgy));
    }

    public final int zzbw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzje.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);
}
