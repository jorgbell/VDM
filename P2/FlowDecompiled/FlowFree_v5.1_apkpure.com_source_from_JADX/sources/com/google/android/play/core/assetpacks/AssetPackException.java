package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.C2039a;
import com.google.android.play.core.tasks.C2173j;

public class AssetPackException extends C2173j {
    AssetPackException(int i) {
        super(String.format("Asset Pack Download Error(%d): %s", new Object[]{Integer.valueOf(i), C2039a.m5106a(i)}));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }
}
