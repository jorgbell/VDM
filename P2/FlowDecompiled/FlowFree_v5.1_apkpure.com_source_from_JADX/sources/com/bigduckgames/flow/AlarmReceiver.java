package com.bigduckgames.flow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        FlowNotificationManager.showNotificationForAlarm(intent.getAction(), context);
    }
}
