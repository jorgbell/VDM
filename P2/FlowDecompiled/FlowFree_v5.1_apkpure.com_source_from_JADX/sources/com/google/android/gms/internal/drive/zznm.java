package com.google.android.gms.internal.drive;

public enum zznm {
    DOUBLE(zznr.DOUBLE, 1),
    FLOAT(zznr.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zznr.BOOLEAN, 0),
    STRING(zznr.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zznr.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zznr.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zznr zzxm;
    private final int zzxn;

    private zznm(zznr zznr, int i) {
        this.zzxm = zznr;
        this.zzxn = i;
    }

    public final zznr zzfj() {
        return this.zzxm;
    }

    public final int zzfk() {
        return this.zzxn;
    }
}
