package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

final class zzme implements zzlo {
    private final int flags;
    private final String info;
    private final Object[] zzue;
    private final zzlq zzuh;

    zzme(zzlq zzlq, String str, Object[] objArr) {
        this.zzuh = zzlq;
        this.info = str;
        this.zzue = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzek() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzel() {
        return this.zzue;
    }

    public final zzlq zzee() {
        return this.zzuh;
    }

    public final int zzec() {
        return (this.flags & 1) == 1 ? zzkk.zze.zzsf : zzkk.zze.zzsg;
    }

    public final boolean zzed() {
        return (this.flags & 2) == 2;
    }
}
