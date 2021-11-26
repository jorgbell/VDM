package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzxs implements zzetj {
    VIDEO_ERROR_CODE_UNSPECIFIED(0),
    OPENGL_RENDERING_FAILED(1),
    CACHE_LOAD_FAILED(2),
    ANDROID_TARGET_API_TOO_LOW(3);
    
    private final int zzf;

    private zzxs(int i) {
        this.zzf = i;
    }

    public static zzxs zza(int i) {
        if (i == 0) {
            return VIDEO_ERROR_CODE_UNSPECIFIED;
        }
        if (i == 1) {
            return OPENGL_RENDERING_FAILED;
        }
        if (i == 2) {
            return CACHE_LOAD_FAILED;
        }
        if (i != 3) {
            return null;
        }
        return ANDROID_TARGET_API_TOO_LOW;
    }

    public static zzetl zzb() {
        return zzxr.zza;
    }

    public final String toString() {
        return "<" + zzxs.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }
}
