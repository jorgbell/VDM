package com.unity3d.services.monetization.placementcontent.core;

import com.unity3d.services.monetization.UnityMonetization;
import java.util.Map;

public class NoFillPlacementContent extends PlacementContent {
    /* access modifiers changed from: protected */
    public String getDefaultEventCategory() {
        return "NO_FILL";
    }

    public boolean isReady() {
        return false;
    }

    public void sendCustomEvent(CustomEvent customEvent) {
    }

    public NoFillPlacementContent(String str, Map<String, Object> map) {
        super(str, map);
    }

    public UnityMonetization.PlacementContentState getState() {
        return UnityMonetization.PlacementContentState.NO_FILL;
    }
}
