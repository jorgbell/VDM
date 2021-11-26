package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeug implements zzevg {
    private static final zzeum zzb = new zzeue();
    private final zzeum zza;

    public zzeug() {
        zzeum zzeum;
        zzeum[] zzeumArr = new zzeum[2];
        zzeumArr[0] = zzetc.zza();
        try {
            zzeum = (zzeum) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzeum = zzb;
        }
        zzeumArr[1] = zzeum;
        zzeuf zzeuf = new zzeuf(zzeumArr);
        zzetr.zzb(zzeuf, "messageInfoFactory");
        this.zza = zzeuf;
    }

    private static boolean zzb(zzeul zzeul) {
        return zzeul.zzc() == 1;
    }

    public final <T> zzevf<T> zza(Class<T> cls) {
        Class<zzeth> cls2 = zzeth.class;
        zzevh.zza(cls);
        zzeul zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzeus.zzg(zzevh.zzC(), zzesw.zza(), zzc.zzb());
            }
            return zzeus.zzg(zzevh.zzA(), zzesw.zzb(), zzc.zzb());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzeur.zzl(cls, zzc, zzeuu.zzb(), zzeuc.zze(), zzevh.zzC(), zzesw.zza(), zzeuk.zzb());
            }
            return zzeur.zzl(cls, zzc, zzeuu.zzb(), zzeuc.zze(), zzevh.zzC(), (zzesu<?>) null, zzeuk.zzb());
        } else if (zzb(zzc)) {
            return zzeur.zzl(cls, zzc, zzeuu.zza(), zzeuc.zzd(), zzevh.zzA(), zzesw.zzb(), zzeuk.zza());
        } else {
            return zzeur.zzl(cls, zzc, zzeuu.zza(), zzeuc.zzd(), zzevh.zzB(), (zzesu<?>) null, zzeuk.zza());
        }
    }
}
