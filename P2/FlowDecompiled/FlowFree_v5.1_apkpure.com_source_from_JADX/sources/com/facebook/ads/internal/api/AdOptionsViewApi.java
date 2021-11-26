package com.facebook.ads.internal.api;

import androidx.annotation.Keep;

@Keep
public interface AdOptionsViewApi extends AdComponentViewApiProvider {
    void setIconColor(int i);

    void setIconSizeDp(int i);

    void setSingleIcon(boolean z);
}
