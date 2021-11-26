package com.google.android.play.core.assetpacks;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.google.android.play.core.internal.C2058ag;

public class ExtractionForegroundService extends Service {

    /* renamed from: a */
    Context f4794a;

    /* renamed from: b */
    C2034i f4795b;

    /* renamed from: c */
    NotificationManager f4796c;

    /* renamed from: d */
    private final C2058ag f4797d = new C2058ag("ExtractionForegroundService");

    /* renamed from: a */
    private final synchronized void m4871a(Intent intent) {
        int intExtra;
        String stringExtra = intent.getStringExtra("notification_title");
        String stringExtra2 = intent.getStringExtra("notification_subtext");
        long longExtra = intent.getLongExtra("notification_timeout", 600000);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("notification_on_click_intent");
        int i = Build.VERSION.SDK_INT;
        Notification.Builder timeoutAfter = i >= 26 ? new Notification.Builder(this.f4794a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(longExtra) : new Notification.Builder(this.f4794a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        Notification.Builder contentTitle = timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(stringExtra == null ? "Downloading additional file" : stringExtra);
        if (stringExtra2 == null) {
            stringExtra = "Transferring";
        }
        contentTitle.setSubText(stringExtra);
        if (i >= 21 && (intExtra = intent.getIntExtra("notification_color", 0)) != 0) {
            timeoutAfter.setColor(intExtra).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f4797d.mo22027d("Starting foreground installation service.", new Object[0]);
        this.f4795b.mo22010a(true);
        if (i >= 26) {
            m4873c(intent.getStringExtra("notification_channel_name"));
        }
        startForeground(-1883842196, build);
    }

    /* renamed from: b */
    private final synchronized void m4872b() {
        this.f4797d.mo22027d("Stopping service.", new Object[0]);
        this.f4795b.mo22010a(false);
        stopForeground(true);
        stopSelf();
    }

    @TargetApi(26)
    /* renamed from: c */
    private final synchronized void m4873c(String str) {
        if (str == null) {
            str = "File downloads by Play";
        }
        this.f4796c.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", str, 2));
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        C2009ck.m5046j(getApplicationContext()).mo21843c(this);
        this.f4796c = (NotificationManager) this.f4794a.getSystemService("notification");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        m4871a(intent);
        int intExtra = intent.getIntExtra("action_type", 0);
        if (intExtra == 2) {
            m4872b();
        } else {
            this.f4797d.mo22025b("Unknown action type received: %d", Integer.valueOf(intExtra));
        }
        return 2;
    }
}
