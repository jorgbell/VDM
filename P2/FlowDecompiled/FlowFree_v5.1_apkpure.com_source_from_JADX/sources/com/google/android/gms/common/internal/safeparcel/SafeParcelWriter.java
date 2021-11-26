package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class SafeParcelWriter {
    public static int beginObjectHeader(@RecentlyNonNull Parcel parcel) {
        return zzb(parcel, 20293);
    }

    public static void finishObjectHeader(@RecentlyNonNull Parcel parcel, int i) {
        zzc(parcel, i);
    }

    public static void writeBoolean(@RecentlyNonNull Parcel parcel, int i, boolean z) {
        zza(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBooleanArray(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull boolean[] zArr, boolean z) {
        if (zArr != null) {
            int zzb = zzb(parcel, i);
            parcel.writeBooleanArray(zArr);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBooleanObject(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Boolean bool, boolean z) {
        if (bool != null) {
            zza(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBundle(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z) {
        if (bundle != null) {
            int zzb = zzb(parcel, i);
            parcel.writeBundle(bundle);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeByteArray(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z) {
        if (bArr != null) {
            int zzb = zzb(parcel, i);
            parcel.writeByteArray(bArr);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeDoubleObject(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Double d, boolean z) {
        if (d != null) {
            zza(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeFloat(@RecentlyNonNull Parcel parcel, int i, float f) {
        zza(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatObject(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Float f, boolean z) {
        if (f != null) {
            zza(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIBinder(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int zzb = zzb(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeInt(@RecentlyNonNull Parcel parcel, int i, int i2) {
        zza(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull int[] iArr, boolean z) {
        if (iArr != null) {
            int zzb = zzb(parcel, i);
            parcel.writeIntArray(iArr);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIntegerList(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<Integer> list, boolean z) {
        if (list != null) {
            int zzb = zzb(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIntegerObject(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Integer num, boolean z) {
        if (num != null) {
            zza(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeLong(@RecentlyNonNull Parcel parcel, int i, long j) {
        zza(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongObject(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Long l, boolean z) {
        if (l != null) {
            zza(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcel(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int zzb = zzb(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcelable(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int zzb = zzb(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeString(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z) {
        if (str != null) {
            int zzb = zzb(parcel, i);
            parcel.writeString(str);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeStringArray(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z) {
        if (strArr != null) {
            int zzb = zzb(parcel, i);
            parcel.writeStringArray(strArr);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeStringList(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<String> list, boolean z) {
        if (list != null) {
            int zzb = zzb(parcel, i);
            parcel.writeStringList(list);
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int zzb = zzb(parcel, i);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, t, i2);
                }
            }
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z) {
        if (list != null) {
            int zzb = zzb(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzc(parcel, zzb);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    private static void zza(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static int zzb(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static <T extends Parcelable> void zzd(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
