package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzh();
    private final Filter zzbc;
    private final zzb<?> zzmd;
    private final zzd zzme;
    private final zzr zzmf;
    private final zzv zzmg;
    private final zzp<?> zzmh;
    private final zzt zzmi;
    private final zzn zzmj;
    private final zzl zzmk;
    private final zzz zzml;

    FilterHolder(zzb<?> zzb, zzd zzd, zzr zzr, zzv zzv, zzp<?> zzp, zzt zzt, zzn<?> zzn, zzl zzl, zzz zzz) {
        this.zzmd = zzb;
        this.zzme = zzd;
        this.zzmf = zzr;
        this.zzmg = zzv;
        this.zzmh = zzp;
        this.zzmi = zzt;
        this.zzmj = zzn;
        this.zzmk = zzl;
        this.zzml = zzz;
        if (zzb != null) {
            this.zzbc = zzb;
        } else if (zzd != null) {
            this.zzbc = zzd;
        } else if (zzr != null) {
            this.zzbc = zzr;
        } else if (zzv != null) {
            this.zzbc = zzv;
        } else if (zzp != null) {
            this.zzbc = zzp;
        } else if (zzt != null) {
            this.zzbc = zzt;
        } else if (zzn != null) {
            this.zzbc = zzn;
        } else if (zzl != null) {
            this.zzbc = zzl;
        } else if (zzz != null) {
            this.zzbc = zzz;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public final Filter getFilter() {
        return this.zzbc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzme, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzmf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzmg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzmh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzmj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzmk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzml, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
