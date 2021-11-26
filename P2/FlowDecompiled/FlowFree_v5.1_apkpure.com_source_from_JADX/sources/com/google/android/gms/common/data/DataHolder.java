package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
    private final int zaa;
    private final String[] zab;
    private Bundle zac;
    private final CursorWindow[] zad;
    private final int zae;
    private final Bundle zaf;
    private int[] zag;
    private int zah;
    private boolean zai = false;
    private boolean zaj = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class zaa extends RuntimeException {
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zaa = i;
        this.zab = strArr;
        this.zad = cursorWindowArr;
        this.zae = i2;
        this.zaf = bundle;
    }

    public final void zaa() {
        this.zac = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zab;
            if (i2 >= strArr.length) {
                break;
            }
            this.zac.putInt(strArr[i2], i2);
            i2++;
        }
        this.zag = new int[this.zad.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zad;
            if (i < cursorWindowArr.length) {
                this.zag[i] = i3;
                i3 += this.zad[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zah = i3;
                return;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class Builder {
        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr);
            new ArrayList();
            new HashMap();
        }

        /* synthetic */ Builder(String[] strArr, String str, zab zab) {
            this(strArr, (String) null);
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zab, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zad, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    @RecentlyNonNull
    public final int getStatusCode() {
        return this.zae;
    }

    @RecentlyNullable
    public final Bundle getMetadata() {
        return this.zaf;
    }

    private final void zaa(String str, int i) {
        Bundle bundle = this.zac;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zah) {
            throw new CursorIndexOutOfBoundsException(i, this.zah);
        }
    }

    @RecentlyNonNull
    public final boolean hasColumn(@RecentlyNonNull String str) {
        return this.zac.containsKey(str);
    }

    @RecentlyNonNull
    public final long getLong(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return this.zad[i2].getLong(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final int getInteger(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return this.zad[i2].getInt(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final String getString(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return this.zad[i2].getString(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final boolean getBoolean(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return Long.valueOf(this.zad[i2].getLong(i, this.zac.getInt(str))).longValue() == 1;
    }

    @RecentlyNonNull
    public final float zaa(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return this.zad[i2].getFloat(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final boolean hasNull(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zaa(str, i);
        return this.zad[i2].isNull(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final int getCount() {
        return this.zah;
    }

    @RecentlyNonNull
    public final int getWindowIndex(@RecentlyNonNull int i) {
        int[] iArr;
        int i2 = 0;
        Preconditions.checkState(i >= 0 && i < this.zah);
        while (true) {
            iArr = this.zag;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    @RecentlyNonNull
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.zai;
        }
        return z;
    }

    public final void close() {
        synchronized (this) {
            if (!this.zai) {
                this.zai = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zad;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.zaj && this.zad.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    static {
        new zab(new String[0], (String) null);
    }
}
