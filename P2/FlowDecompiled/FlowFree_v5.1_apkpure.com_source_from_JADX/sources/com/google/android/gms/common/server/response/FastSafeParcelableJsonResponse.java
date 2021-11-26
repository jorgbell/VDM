package com.google.android.gms.common.server.response;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @RecentlyNonNull
    public final int describeContents() {
        return 0;
    }

    @RecentlyNullable
    public Object getValueObject(@RecentlyNonNull String str) {
        return null;
    }

    @RecentlyNonNull
    public boolean isPrimitiveFieldSet(@RecentlyNonNull String str) {
        return false;
    }

    @RecentlyNonNull
    public int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                Object fieldValue = getFieldValue(next);
                Preconditions.checkNotNull(fieldValue);
                i = (i * 31) + fieldValue.hashCode();
            }
        }
        return i;
    }

    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                if (!fastJsonResponse.isFieldSet(next) || !Objects.equal(getFieldValue(next), fastJsonResponse.getFieldValue(next))) {
                    return false;
                }
            } else if (fastJsonResponse.isFieldSet(next)) {
                return false;
            }
        }
        return true;
    }
}
