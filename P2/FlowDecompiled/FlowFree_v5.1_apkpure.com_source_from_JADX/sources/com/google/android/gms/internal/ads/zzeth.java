package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzetd;
import com.google.android.gms.internal.ads.zzeth;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeth<MessageType extends zzeth<MessageType, BuilderType>, BuilderType extends zzetd<MessageType, BuilderType>> extends zzerp<MessageType, BuilderType> {
    private static final Map<Object, zzeth<?, ?>> zzb = new ConcurrentHashMap();
    protected zzevu zzc = zzevu.zza();
    protected int zzd = -1;

    private static <T extends zzeth<T, ?>> T zza(T t) throws zzett {
        if (t == null || t.zzat()) {
            return t;
        }
        zzett zzett = new zzett(new zzevs(t).getMessage());
        zzett.zza(t);
        throw zzett;
    }

    static Object zzaA(Method method, Object obj, Object... objArr) {
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

    protected static zzetm zzaB() {
        return zzeti.zzd();
    }

    protected static zzetm zzaC(zzetm zzetm) {
        int size = zzetm.size();
        return zzetm.zzf(size == 0 ? 10 : size + size);
    }

    protected static zzetp zzaD() {
        return zzeud.zzd();
    }

    protected static <E> zzetq<E> zzaE() {
        return zzeux.zzd();
    }

    protected static <E> zzetq<E> zzaF(zzetq<E> zzetq) {
        int size = zzetq.size();
        return zzetq.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzeth<T, ?>> T zzaG(T t, byte[] bArr, int i, int i2, zzest zzest) throws zzett {
        T t2 = (zzeth) t.zzb(4, (Object) null, (Object) null);
        try {
            zzevf<?> zzb2 = zzeuw.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, 0, i2, new zzers(zzest));
            zzb2.zzj(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzett) {
                throw ((zzett) e.getCause());
            }
            zzett zzett = new zzett(e.getMessage());
            zzett.zza(t2);
            throw zzett;
        } catch (IndexOutOfBoundsException unused) {
            zzett zzb3 = zzett.zzb();
            zzb3.zza(t2);
            throw zzb3;
        }
    }

    protected static <T extends zzeth<T, ?>> T zzaH(T t, zzesf zzesf) throws zzett {
        T t2;
        zzest zza = zzest.zza();
        try {
            zzesj zzo = zzesf.zzo();
            t2 = (zzeth) t.zzb(4, (Object) null, (Object) null);
            zzevf<?> zzb2 = zzeuw.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzesk.zza(zzo), zza);
            zzb2.zzj(t2);
            zzo.zzb(0);
            zza(t2);
            zza(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzett) {
                throw ((zzett) e.getCause());
            }
            zzett zzett = new zzett(e.getMessage());
            zzett.zza(t2);
            throw zzett;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzett) {
                throw ((zzett) e2.getCause());
            }
            throw e2;
        } catch (zzett e3) {
            e3.zza(t2);
            throw e3;
        } catch (zzett e4) {
            throw e4;
        }
    }

    protected static <T extends zzeth<T, ?>> T zzaI(T t, zzesf zzesf, zzest zzest) throws zzett {
        T t2;
        try {
            zzesj zzo = zzesf.zzo();
            t2 = (zzeth) t.zzb(4, (Object) null, (Object) null);
            zzevf<?> zzb2 = zzeuw.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzesk.zza(zzo), zzest);
            zzb2.zzj(t2);
            zzo.zzb(0);
            zza(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzett) {
                throw ((zzett) e.getCause());
            }
            zzett zzett = new zzett(e.getMessage());
            zzett.zza(t2);
            throw zzett;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzett) {
                throw ((zzett) e2.getCause());
            }
            throw e2;
        } catch (zzett e3) {
            e3.zza(t2);
            throw e3;
        } catch (zzett e4) {
            throw e4;
        }
    }

    protected static <T extends zzeth<T, ?>> T zzaJ(T t, byte[] bArr) throws zzett {
        T zzaG = zzaG(t, bArr, 0, bArr.length, zzest.zza());
        zza(zzaG);
        return zzaG;
    }

    protected static <T extends zzeth<T, ?>> T zzaK(T t, byte[] bArr, zzest zzest) throws zzett {
        T zzaG = zzaG(t, bArr, 0, bArr.length, zzest);
        zza(zzaG);
        return zzaG;
    }

    static <T extends zzeth> T zzax(Class<T> cls) {
        Map<Object, zzeth<?, ?>> map = zzb;
        T t = (zzeth) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzeth) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzeth) ((zzeth) zzewd.zzc(cls)).zzb(6, (Object) null, (Object) null);
            if (t != null) {
                map.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzeth> void zzay(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    protected static Object zzaz(zzeuo zzeuo, String str, Object[] objArr) {
        return new zzeuy(zzeuo, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzeuw.zza().zzb(getClass()).zzb(this, (zzeth) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzeuw.zza().zzb(getClass()).zzc(this);
        this.zza = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zzeuq.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzeun zzaL() {
        zzetd zzetd = (zzetd) zzb(5, (Object) null, (Object) null);
        zzetd.zzai(this);
        return zzetd;
    }

    public final /* bridge */ /* synthetic */ zzeun zzaM() {
        return (zzetd) zzb(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzap() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzaq(int i) {
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzeth<MessageType, BuilderType>, BuilderType extends zzetd<MessageType, BuilderType>> BuilderType zzas() {
        return (zzetd) zzb(5, (Object) null, (Object) null);
    }

    public final BuilderType zzau() {
        BuilderType buildertype = (zzetd) zzb(5, (Object) null, (Object) null);
        buildertype.zzai(this);
        return buildertype;
    }

    public final void zzav(zzeso zzeso) throws IOException {
        zzeuw.zza().zzb(getClass()).zzn(this, zzesp.zza(zzeso));
    }

    public final int zzaw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzeuw.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    public final /* bridge */ /* synthetic */ zzeuo zzbe() {
        return (zzeth) zzb(6, (Object) null, (Object) null);
    }

    public final boolean zzat() {
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzeuw.zza().zzb(getClass()).zzk(this);
        zzb(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }
}
