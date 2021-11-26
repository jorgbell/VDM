package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public enum zzkl {
    DOUBLE(zzkm.DOUBLE, 1),
    FLOAT(zzkm.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzkm.BOOLEAN, 0),
    STRING(zzkm.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzkm.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzkm.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzkm zzs;

    private zzkl(zzkm zzkm, int i) {
        this.zzs = zzkm;
    }

    public final zzkm zza() {
        return this.zzs;
    }
}
