package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@RecentlyNonNull Status status) {
        super(status);
    }
}
