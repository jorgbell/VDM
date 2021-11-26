package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

public class MraidControllerFactory {
    protected static MraidControllerFactory instance = new MraidControllerFactory();

    @VisibleForTesting
    public static void setInstance(MraidControllerFactory mraidControllerFactory) {
        instance = mraidControllerFactory;
    }

    public static MraidController create(Context context, String str, PlacementType placementType, boolean z) {
        return instance.internalCreate(context, str, placementType, z);
    }

    /* access modifiers changed from: protected */
    public MraidController internalCreate(Context context, String str, PlacementType placementType, boolean z) {
        return new MraidController(context, str, placementType, z);
    }
}
