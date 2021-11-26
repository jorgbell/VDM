package com.facebook.ads.internal.api;

import androidx.annotation.Keep;

@Keep
public interface Repairable {
    void repair(Throwable th);
}
