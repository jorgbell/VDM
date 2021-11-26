package com.amazon.device.iap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.util.C0532e;

public final class ResponseReceiver extends BroadcastReceiver {
    private static final String TAG = ResponseReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        try {
            C0524d.m156d().mo7497a(context, intent);
        } catch (Exception e) {
            String str = TAG;
            C0532e.m189b(str, "Error in onReceive: " + e);
        }
    }
}
