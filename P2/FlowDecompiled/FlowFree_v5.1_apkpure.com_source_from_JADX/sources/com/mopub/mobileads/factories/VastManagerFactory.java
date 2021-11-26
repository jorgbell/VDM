package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastManager;

public class VastManagerFactory {
    protected static VastManagerFactory instance = new VastManagerFactory();

    public static VastManager create(Context context) {
        Preconditions.checkNotNull(context, "context cannot be null");
        return instance.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean z) {
        Preconditions.checkNotNull(context, "context cannot be null");
        return instance.internalCreate(context, z);
    }

    public VastManager internalCreate(Context context, boolean z) {
        Preconditions.checkNotNull(context, "context cannot be null");
        return new VastManager(context, z);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory vastManagerFactory) {
        instance = vastManagerFactory;
    }
}
