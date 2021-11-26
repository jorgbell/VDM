package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzm();
    public static final DriveSpace zzah;
    public static final DriveSpace zzai;
    public static final DriveSpace zzaj;
    private static final Set<DriveSpace> zzak;
    private final String name;

    DriveSpace(String str) {
        Preconditions.checkNotNull(str);
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.name.equals(((DriveSpace) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.name;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    static {
        DriveSpace driveSpace = new DriveSpace("DRIVE");
        zzah = driveSpace;
        DriveSpace driveSpace2 = new DriveSpace("APP_DATA_FOLDER");
        zzai = driveSpace2;
        DriveSpace driveSpace3 = new DriveSpace("PHOTOS");
        zzaj = driveSpace3;
        Set<DriveSpace> of = CollectionUtils.setOf(driveSpace, driveSpace2, driveSpace3);
        zzak = of;
        TextUtils.join(",", of.toArray());
        Pattern.compile("[A-Z0-9_]*");
    }
}
