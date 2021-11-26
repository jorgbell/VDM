package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.drive.zzfb;
import com.google.android.gms.internal.drive.zzkk;

public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zzk();
    private final String zzad;
    private final long zzae;
    private final int zzaf;
    private final long zzf;
    private volatile String zzh = null;

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzae);
        SafeParcelWriter.writeLong(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public DriveId(String str, long j, long j2, int i) {
        this.zzad = str;
        boolean z = true;
        Preconditions.checkArgument(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzae = j;
        this.zzf = j2;
        this.zzaf = i;
    }

    public int hashCode() {
        if (this.zzae == -1) {
            return this.zzad.hashCode();
        }
        String valueOf = String.valueOf(String.valueOf(this.zzf));
        String valueOf2 = String.valueOf(String.valueOf(this.zzae));
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null && obj.getClass() == DriveId.class) {
            DriveId driveId = (DriveId) obj;
            if (driveId.zzf != this.zzf) {
                return false;
            }
            long j = driveId.zzae;
            if (j == -1 && this.zzae == -1) {
                return driveId.zzad.equals(this.zzad);
            }
            String str2 = this.zzad;
            if (str2 == null || (str = driveId.zzad) == null) {
                if (j == this.zzae) {
                    return true;
                }
            } else if (j != this.zzae || !str.equals(str2)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public final String encodeToString() {
        if (this.zzh == null) {
            zzfb.zza zzan = zzfb.zzan();
            zzan.zzm(1);
            String str = this.zzad;
            if (str == null) {
                str = "";
            }
            zzan.zze(str);
            zzan.zzg(this.zzae);
            zzan.zzh(this.zzf);
            zzan.zzn(this.zzaf);
            String valueOf = String.valueOf(Base64.encodeToString(((zzfb) ((zzkk) zzan.zzdf())).toByteArray(), 10));
            this.zzh = valueOf.length() != 0 ? "DriveId:".concat(valueOf) : new String("DriveId:");
        }
        return this.zzh;
    }

    public String toString() {
        return encodeToString();
    }
}
