package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.C1419Ad;

public interface FullScreenAd extends C1419Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    C1419Ad.LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
