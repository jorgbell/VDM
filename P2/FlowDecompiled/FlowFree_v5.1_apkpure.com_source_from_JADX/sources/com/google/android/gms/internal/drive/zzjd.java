package com.google.android.gms.internal.drive;

import java.util.NoSuchElementException;

final class zzjd extends zzjf {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzjc zznu;

    zzjd(zzjc zzjc) {
        this.zznu = zzjc;
        this.limit = zzjc.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zznu.zzt(i);
        }
        throw new NoSuchElementException();
    }
}
