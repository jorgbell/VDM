package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import com.google.android.gms.internal.drive.zzkk.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkk<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzit<MessageType, BuilderType> {
    private static Map<Object, zzkk<?, ?>> zzrs = new ConcurrentHashMap();
    protected zzmy zzrq = zzmy.zzfa();
    private int zzrr = -1;

    public static class zzb<T extends zzkk<T, ?>> extends zziv<T> {
        public zzb(T t) {
        }
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzrx = 1;
        public static final int zzry = 2;
        public static final int zzrz = 3;
        public static final int zzsa = 4;
        public static final int zzsb = 5;
        public static final int zzsc = 6;
        public static final int zzsd = 7;
        private static final /* synthetic */ int[] zzse = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzsf = 1;
        public static final int zzsg = 2;
        public static final int zzsi = 1;
        public static final int zzsj = 2;

        public static int[] zzdh() {
            return (int[]) zzse.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzkk<MessageType, BuilderType> implements zzls {
        protected zzkb<Object> zzrw = zzkb.zzcn();

        /* access modifiers changed from: package-private */
        public final zzkb<Object> zzdg() {
            if (this.zzrw.isImmutable()) {
                this.zzrw = (zzkb) this.zzrw.clone();
            }
            return this.zzrw;
        }
    }

    public String toString() {
        return zzlt.zza(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzne;
        if (i != 0) {
            return i;
        }
        int hashCode = zzmd.zzej().zzq(this).hashCode(this);
        this.zzne = hashCode;
        return hashCode;
    }

    public static abstract class zza<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zziu<MessageType, BuilderType> {
        private final MessageType zzrt;
        protected MessageType zzru;
        private boolean zzrv = false;

        protected zza(MessageType messagetype) {
            this.zzrt = messagetype;
            this.zzru = (zzkk) messagetype.zza(zze.zzsa, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzdb() {
            if (this.zzrv) {
                MessageType messagetype = (zzkk) this.zzru.zza(zze.zzsa, (Object) null, (Object) null);
                zza(messagetype, this.zzru);
                this.zzru = messagetype;
                this.zzrv = false;
            }
        }

        /* renamed from: zzdc */
        public MessageType zzde() {
            if (this.zzrv) {
                return this.zzru;
            }
            this.zzru.zzbp();
            this.zzrv = true;
            return this.zzru;
        }

        /* renamed from: zzdd */
        public final MessageType zzdf() {
            MessageType messagetype = (zzkk) zzde();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzmw(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzdb();
            zza(this.zzru, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzmd.zzej().zzq(messagetype).zzc(messagetype, messagetype2);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ zziu zza(zzit zzit) {
            zza((zzkk) zzit);
            return this;
        }

        public final /* synthetic */ zzlq zzda() {
            return this.zzrt;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzrt.zza(zze.zzsb, (Object) null, (Object) null);
            zza.zza((zzkk) zzde());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzkk) zza(zze.zzsc, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzmd.zzej().zzq(this).equals(this, (zzkk) obj);
    }

    /* access modifiers changed from: protected */
    public final void zzbp() {
        zzmd.zzej().zzq(this).zzd(this);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzcw() {
        return (zza) zza(zze.zzsb, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, true);
    }

    /* access modifiers changed from: package-private */
    public final int zzbm() {
        return this.zzrr;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i) {
        this.zzrr = i;
    }

    public final void zzb(zzjr zzjr) throws IOException {
        zzmd.zzej().zzf(getClass()).zza(this, zzjt.zza(zzjr));
    }

    public final int zzcx() {
        if (this.zzrr == -1) {
            this.zzrr = zzmd.zzej().zzq(this).zzn(this);
        }
        return this.zzrr;
    }

    static <T extends zzkk<?, ?>> T zzd(Class<T> cls) {
        T t = (zzkk) zzrs.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzkk) zzrs.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzkk) ((zzkk) zznd.zzh(cls)).zza(zze.zzsc, (Object) null, (Object) null);
            if (t != null) {
                zzrs.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzkk<?, ?>> void zza(Class<T> cls, T t) {
        zzrs.put(cls, t);
    }

    protected static Object zza(zzlq zzlq, String str, Object[] objArr) {
        return new zzme(zzlq, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static final <T extends zzkk<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzrx, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzp = zzmd.zzej().zzq(t).zzp(t);
        if (z) {
            t.zza(zze.zzry, (Object) zzp ? t : null, (Object) null);
        }
        return zzp;
    }

    public final /* synthetic */ zzlr zzcy() {
        zza zza2 = (zza) zza(zze.zzsb, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzlq zzda() {
        return (zzkk) zza(zze.zzsc, (Object) null, (Object) null);
    }
}
