package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzio implements zzji {
    private static final zziu zzb = new zzim();
    private final zziu zza;

    public zzio() {
        zziu zziu;
        zziu[] zziuArr = new zziu[2];
        zziuArr[0] = zzhm.zza();
        try {
            zziu = (zziu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zziu = zzb;
        }
        zziuArr[1] = zziu;
        zzin zzin = new zzin(zziuArr);
        zzhz.zzb(zzin, "messageInfoFactory");
        this.zza = zzin;
    }

    private static boolean zzb(zzit zzit) {
        return zzit.zzc() == 1;
    }

    public final <T> zzjh<T> zza(Class<T> cls) {
        Class<zzhr> cls2 = zzhr.class;
        zzjj.zza(cls);
        zzit zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzja.zzf(zzjj.zzC(), zzhg.zza(), zzc.zzb());
            }
            return zzja.zzf(zzjj.zzA(), zzhg.zzb(), zzc.zzb());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zziz.zzk(cls, zzc, zzjc.zzb(), zzik.zzd(), zzjj.zzC(), zzhg.zza(), zzis.zzb());
            }
            return zziz.zzk(cls, zzc, zzjc.zzb(), zzik.zzd(), zzjj.zzC(), (zzhe<?>) null, zzis.zzb());
        } else if (zzb(zzc)) {
            return zziz.zzk(cls, zzc, zzjc.zza(), zzik.zzc(), zzjj.zzA(), zzhg.zzb(), zzis.zza());
        } else {
            return zziz.zzk(cls, zzc, zzjc.zza(), zzik.zzc(), zzjj.zzB(), (zzhe<?>) null, zzis.zza());
        }
    }
}
