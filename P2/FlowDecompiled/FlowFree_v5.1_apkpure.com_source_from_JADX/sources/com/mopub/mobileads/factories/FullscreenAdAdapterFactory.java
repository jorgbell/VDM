package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdAdapter;
import com.mopub.mobileads.AdData;
import com.mopub.mobileads.FullscreenAdAdapter;

public class FullscreenAdAdapterFactory {
    protected static FullscreenAdAdapterFactory instance = new FullscreenAdAdapterFactory();

    @Deprecated
    public static void setInstance(FullscreenAdAdapterFactory fullscreenAdAdapterFactory) {
        instance = fullscreenAdAdapterFactory;
    }

    public static FullscreenAdAdapter create(Context context, String str, AdData adData) throws AdAdapter.BaseAdNotFoundException {
        return instance.internalCreate(context, str, adData);
    }

    /* access modifiers changed from: protected */
    public FullscreenAdAdapter internalCreate(Context context, String str, AdData adData) throws AdAdapter.BaseAdNotFoundException {
        return new FullscreenAdAdapter(context, str, adData);
    }
}
