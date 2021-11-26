package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzewj {
    DOUBLE(zzewk.DOUBLE, 1),
    FLOAT(zzewk.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzewk.BOOLEAN, 0),
    STRING(zzewk.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzewk.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzewk.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzewk zzs;

    private zzewj(zzewk zzewk, int i) {
        this.zzs = zzewk;
    }

    public final zzewk zza() {
        return this.zzs;
    }
}
