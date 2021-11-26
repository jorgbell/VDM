package com.google.android.gms.internal.drive;

public enum zznr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzjc.zznq),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zztd;

    private zznr(Object obj) {
        this.zztd = obj;
    }
}
