package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class ApiExceptionMapper implements StatusExceptionMapper {
    @RecentlyNonNull
    public Exception getException(@RecentlyNonNull Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
