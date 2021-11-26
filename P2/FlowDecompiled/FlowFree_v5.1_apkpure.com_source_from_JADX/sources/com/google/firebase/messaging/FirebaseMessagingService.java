package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
public class FirebaseMessagingService extends EnhancedIntentService {
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        } else {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Received duplicate message: ".concat(valueOf) : new String("Received duplicate message: "));
            return true;
        }
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService newNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            try {
                if (!new DisplayNotification(this, notificationParams, newNetworkIOExecutor).handleNotification()) {
                    newNetworkIOExecutor.shutdown();
                    if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                        MessagingAnalytics.logNotificationForeground(intent);
                    }
                } else {
                    return;
                }
            } finally {
                newNetworkIOExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void passMessageIntentToSdk(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "gcm"
            if (r0 != 0) goto L_0x000b
            r0 = r1
        L_0x000b:
            int r2 = r0.hashCode()
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r2) {
                case -2062414158: goto L_0x0032;
                case 102161: goto L_0x002a;
                case 814694033: goto L_0x0020;
                case 814800675: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x003c
        L_0x0016:
            java.lang.String r1 = "send_event"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003c
            r1 = 2
            goto L_0x003d
        L_0x0020:
            java.lang.String r1 = "send_error"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003c
            r1 = 3
            goto L_0x003d
        L_0x002a:
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003c
            r1 = 0
            goto L_0x003d
        L_0x0032:
            java.lang.String r1 = "deleted_messages"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003c
            r1 = 1
            goto L_0x003d
        L_0x003c:
            r1 = -1
        L_0x003d:
            if (r1 == 0) goto L_0x007f
            if (r1 == r5) goto L_0x007b
            if (r1 == r4) goto L_0x0071
            if (r1 == r3) goto L_0x005e
            java.lang.String r7 = "Received message with unknown type: "
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0052
            java.lang.String r7 = r7.concat(r0)
            goto L_0x0058
        L_0x0052:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r7)
            r7 = r0
        L_0x0058:
            java.lang.String r0 = "FirebaseMessaging"
            android.util.Log.w(r0, r7)
            return
        L_0x005e:
            java.lang.String r0 = r6.getMessageId(r7)
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r2 = "error"
            java.lang.String r7 = r7.getStringExtra(r2)
            r1.<init>(r7)
            r6.onSendError(r0, r1)
            return
        L_0x0071:
            java.lang.String r0 = "google.message_id"
            java.lang.String r7 = r7.getStringExtra(r0)
            r6.onMessageSent(r7)
            return
        L_0x007b:
            r6.onDeletedMessages()
            return
        L_0x007f:
            com.google.firebase.messaging.MessagingAnalytics.logNotificationReceived(r7)
            r6.dispatchMessage(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.passMessageIntentToSdk(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().getMessagingEvent();
    }

    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            handleMessageIntent(intent);
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }
}
