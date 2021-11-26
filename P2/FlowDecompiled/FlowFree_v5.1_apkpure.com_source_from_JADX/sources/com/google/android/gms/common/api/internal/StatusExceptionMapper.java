package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface StatusExceptionMapper {
    @RecentlyNonNull
    Exception getException(@RecentlyNonNull Status status);
}
