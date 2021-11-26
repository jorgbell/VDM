package com.bigduckgames.flow;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.noodlecake.flow.utils.SharedPrefsHelper;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import java.util.Calendar;

public class FlowNotificationManager {
    public static final String DAILY_CHANNEL_ID = "DailyPuzzles";
    public static final String NEW_PACK_CHANNEL_ID = "NewPack";
    public static final String NOTIFICATION_ALARMS_PREF_KEY = "NotificationAlarms";
    public static final String NOTIFICATION_ALARM_DAILY_REMINDER = "NotificationAlarm_DailyReminder";
    public static final String NOTIFICATION_ALARM_WEEKLY_NEW = "NotificationAlarm_WeeklyNew";
    public static final String NOTIFICATION_ALARM_WEEKLY_REMINDER = "NotificationAlarm_WeeklyReminder";
    public static final int NOTIFICATION_ID_DAILY_REMINDER = 0;
    public static final int NOTIFICATION_ID_WEEKLY_NEW = 2;
    public static final int NOTIFICATION_ID_WEEKLY_REMINDER = 1;
    public static final String WEEKLY_CHANNEL_ID = "WeeklyPuzzles";

    public static void onBoot(Context context, Intent intent) {
        String stringPref = new SharedPrefsHelper(context).getStringPref(NOTIFICATION_ALARMS_PREF_KEY);
        if (stringPref != null) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            String[] split = stringPref.split(";");
            for (String load : split) {
                NotificationData load2 = NotificationData.load(load, context, false);
                if (load2 != null) {
                    long j = load2.Timeout;
                    if (j < 0 || timeInMillis < load2.Time + j) {
                        setNotificationAlarm(load2, context);
                    }
                }
            }
        }
    }

    public static void onStart(Context context) {
        createNotificationChannel(DAILY_CHANNEL_ID, "Daily Puzzles", "Notifies you about losing your daily streak.", context);
        createNotificationChannel(WEEKLY_CHANNEL_ID, "Weekly Puzzles", "Notifies you about weekly puzzles.", context);
        createNotificationChannel(NEW_PACK_CHANNEL_ID, "New Packs", "Notifies you about new pack releases.", context);
    }

    public static void scheduleNotificationAlarm(int i, String str, String str2, double d, int i2, String str3) {
        Context context = NoodlecakeGameActivity.getContext();
        if (context != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis((long) (d * 1000.0d));
            NotificationData notificationData = new NotificationData();
            notificationData.f2628Id = i;
            notificationData.Title = str;
            notificationData.Content = str2;
            notificationData.Time = instance.getTimeInMillis();
            notificationData.Uri = str3;
            if (i2 > 0) {
                notificationData.Timeout = (long) (i2 * 1000);
            }
            if (i >= 10600 && i <= 10699) {
                notificationData.AlarmName = NOTIFICATION_ALARM_DAILY_REMINDER;
                notificationData.AndroidNotifId = 0;
                notificationData.NotificationChannelId = DAILY_CHANNEL_ID;
            } else if (i >= 10700 && i <= 10749) {
                notificationData.AlarmName = NOTIFICATION_ALARM_WEEKLY_REMINDER;
                notificationData.AndroidNotifId = 1;
                notificationData.NotificationChannelId = WEEKLY_CHANNEL_ID;
            } else if (i >= 10750 && i <= 10799) {
                notificationData.AlarmName = NOTIFICATION_ALARM_WEEKLY_NEW;
                notificationData.AndroidNotifId = 2;
                notificationData.NotificationChannelId = WEEKLY_CHANNEL_ID;
            }
            addNotificationAlarm(notificationData, context);
        }
    }

    public static void createNotificationChannel(String str, String str2, String str3, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 3);
            notificationChannel.setDescription(str3);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static void showNotificationForAlarm(String str, Context context) {
        NotificationData load = NotificationData.load(str, context, true);
        if (load != null) {
            showNotification(load, context);
            removeNotificationAlarm(load, context);
        }
    }

    public static void showNotification(NotificationData notificationData, Context context) {
        String str = notificationData.Uri;
        Uri parse = str != null ? Uri.parse(str) : null;
        Log.d("FlowNotificationManager", notificationData.toString(true, false, false));
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", parse, context, C1203flow.class).putExtra("id", Integer.toString(notificationData.f2628Id)), 134217728);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationData.NotificationChannelId);
        builder.setContentTitle(notificationData.Title);
        builder.setContentText(notificationData.Content);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(notificationData.Content);
        builder.setStyle(bigTextStyle);
        builder.setContentIntent(activity);
        builder.setAutoCancel(true);
        builder.setPriority(0);
        builder.setDefaults(-1);
        long j = notificationData.Timeout;
        if (j > 0) {
            builder.setTimeoutAfter(j);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setSmallIcon(R.drawable.notification_small);
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.notification_large));
            builder.setColor(context.getResources().getColor(R.color.notification_color));
        } else {
            builder.setSmallIcon(R.drawable.icon);
        }
        NotificationManagerCompat.from(context).notify(notificationData.AndroidNotifId, builder.build());
    }

    private static void setNotificationAlarm(NotificationData notificationData, Context context) {
        ((AlarmManager) context.getSystemService("alarm")).set(1, notificationData.Time, PendingIntent.getBroadcast(context, 0, new Intent(notificationData.AlarmName, (Uri) null, context, AlarmReceiver.class), 0));
    }

    private static void addNotificationAlarm(NotificationData notificationData, Context context) {
        notificationData.save(context);
        setNotificationAlarm(notificationData, context);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(context);
        String stringPref = sharedPrefsHelper.getStringPref(NOTIFICATION_ALARMS_PREF_KEY);
        if (stringPref == null) {
            sharedPrefsHelper.setSharedPref(NOTIFICATION_ALARMS_PREF_KEY, notificationData.AlarmName);
        } else {
            String[] split = stringPref.split(";");
            String str = notificationData.AlarmName;
            for (int i = 0; i < split.length; i++) {
                if (!split[i].equalsIgnoreCase(notificationData.AlarmName) && split[i].trim().length() > 0) {
                    str = (str + ";") + split[i];
                }
            }
            sharedPrefsHelper.setSharedPref(NOTIFICATION_ALARMS_PREF_KEY, str);
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, BootReceiver.class), 1, 1);
    }

    private static void removeNotificationAlarm(NotificationData notificationData, Context context) {
        if (notificationData != null) {
            boolean z = false;
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(notificationData.AlarmName, (Uri) null, context, AlarmReceiver.class), 0));
            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(context);
            String stringPref = sharedPrefsHelper.getStringPref(NOTIFICATION_ALARMS_PREF_KEY);
            if (stringPref == null) {
                z = true;
            } else {
                String[] split = stringPref.split(";");
                String str = "";
                int i = 0;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!split[i2].equalsIgnoreCase(notificationData.AlarmName) && split[i2].trim().length() > 0) {
                        if (i > 0) {
                            str = str + ";";
                        }
                        str = str + split[i2];
                        i++;
                    }
                }
                if (i <= 0) {
                    z = true;
                }
                sharedPrefsHelper.setSharedPref(NOTIFICATION_ALARMS_PREF_KEY, str);
            }
            if (z) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, BootReceiver.class), 2, 1);
            }
        }
    }

    public static void cancelNotificationAlarms() {
        Context context = NoodlecakeGameActivity.getContext();
        if (context != null) {
            removeNotificationAlarm(NotificationData.load(NOTIFICATION_ALARM_DAILY_REMINDER, context, true), context);
            removeNotificationAlarm(NotificationData.load(NOTIFICATION_ALARM_WEEKLY_REMINDER, context, true), context);
            removeNotificationAlarm(NotificationData.load(NOTIFICATION_ALARM_WEEKLY_NEW, context, true), context);
        }
    }

    public static void clearNotifications() {
        Context context = NoodlecakeGameActivity.getContext();
        if (context != null) {
            NotificationManagerCompat.from(context).cancelAll();
        }
    }

    public static class NotificationData {
        public String AlarmName;
        public int AndroidNotifId;
        public String Content;

        /* renamed from: Id */
        public int f2628Id;
        public String NotificationChannelDescription;
        public String NotificationChannelId;
        public String NotificationChannelName;
        public long Time;
        public long Timeout = -1;
        public String Title;
        public String Uri;

        public String getSharedPrefKey(String str) {
            return "NotificationData_" + this.AlarmName + "_" + str;
        }

        public void save(Context context) {
            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(context);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Id"), Integer.valueOf(this.f2628Id));
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("AndroidNotifId"), Integer.valueOf(this.AndroidNotifId));
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Title"), this.Title);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Content"), this.Content);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Uri"), this.Uri);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("ChannelId"), this.NotificationChannelId);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("ChannelName"), this.NotificationChannelName);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("ChannelDesc"), this.NotificationChannelDescription);
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Timeout"), Long.valueOf(this.Timeout));
            sharedPrefsHelper.setSharedPref(getSharedPrefKey("Time"), Long.valueOf(this.Time));
        }

        public static NotificationData load(String str, Context context, boolean z) {
            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(context);
            NotificationData notificationData = new NotificationData();
            notificationData.AlarmName = str;
            notificationData.f2628Id = sharedPrefsHelper.getIntPref(notificationData.getSharedPrefKey("Id")).intValue();
            notificationData.AndroidNotifId = sharedPrefsHelper.getIntPref(notificationData.getSharedPrefKey("AndroidNotifId")).intValue();
            notificationData.Title = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("Title"));
            notificationData.Content = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("Content"));
            notificationData.Uri = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("Uri"));
            notificationData.NotificationChannelId = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("ChannelId"));
            notificationData.NotificationChannelName = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("ChannelName"));
            notificationData.NotificationChannelDescription = sharedPrefsHelper.getStringPref(notificationData.getSharedPrefKey("ChannelDesc"));
            notificationData.Timeout = sharedPrefsHelper.getLongPref(notificationData.getSharedPrefKey("Timeout")).longValue();
            notificationData.Time = sharedPrefsHelper.getLongPref(notificationData.getSharedPrefKey("Time")).longValue();
            if (notificationData.Title == null) {
                return null;
            }
            if (z) {
                removeData(notificationData, context);
            }
            return notificationData;
        }

        private static void removeData(NotificationData notificationData, Context context) {
            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(context);
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Id"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("AndroidNotifId"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Title"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Content"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Uri"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("ChannelId"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("ChannelName"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("ChannelDesc"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Timeout"));
            sharedPrefsHelper.removeSharedPref(notificationData.getSharedPrefKey("Time"));
        }

        public String toString(boolean z, boolean z2, boolean z3) {
            String str = "Notification Data - Id: " + this.f2628Id + " - Uri: " + this.Uri;
            if (z) {
                str = str + " - Title: '" + this.Title + "' - Content: '" + this.Content + "'";
            }
            if (z2) {
                str = str + " - Channel ID: " + this.NotificationChannelId + " - Channel Name: '" + this.NotificationChannelName + "' - Channel Description: '" + this.NotificationChannelDescription + "'";
            }
            if (!z3) {
                return str;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.Time);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(this.Time + this.Timeout);
            return str + " - Time: " + instance.getTime() + " - Expiration Time: " + instance2.getTime();
        }
    }
}
