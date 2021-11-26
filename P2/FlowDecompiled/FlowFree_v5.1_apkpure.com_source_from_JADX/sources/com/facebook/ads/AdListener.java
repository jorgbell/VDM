package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

@Keep
public interface AdListener {
    @Benchmark
    void onAdClicked(C1419Ad ad);

    @Benchmark
    void onAdLoaded(C1419Ad ad);

    @Benchmark
    void onError(C1419Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(C1419Ad ad);
}
