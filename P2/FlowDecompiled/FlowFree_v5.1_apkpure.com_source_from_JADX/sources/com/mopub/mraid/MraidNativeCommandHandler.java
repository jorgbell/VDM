package com.mopub.mraid;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class MraidNativeCommandHandler {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    static boolean isCalendarAvailable(Context context) {
        return false;
    }

    public static boolean isStorePictureSupported(Context context) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isSmsAvailable(Context context) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isTelAvailable(Context context) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isInlineVideoAvailable(Activity activity, View view) {
        if (activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) {
            return false;
        }
        return true;
    }
}
