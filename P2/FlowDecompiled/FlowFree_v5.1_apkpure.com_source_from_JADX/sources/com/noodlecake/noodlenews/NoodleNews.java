package com.noodlecake.noodlenews;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.noodlecake.lib.uikit.UIAlertView;
import org.cocos2dx.lib.Cocos2dxActivity;

public class NoodleNews {
    public static final int VERSION_FREE = 40;
    public static final int VERSION_FULL = 30;
    static Activity _activity;

    private static String[] getPackageNameVariants(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    public static void init(Activity activity) {
        _activity = activity;
    }

    public static void showMoreGames(final int i) {
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    Intent intent = new Intent(NoodleNews._activity, MoreGamesWebView.class);
                    intent.putExtra(MoreGamesWebView.PLATFORM_KEY, i);
                    NoodleNews._activity.startActivity(intent);
                }
            });
        }
    }

    public static String getMarketUrlForPackage(String str, int i) {
        return getAppUrlForPackage(str, i);
    }

    private static Intent getLaunchIntentForPackage(String str) {
        Intent intent = null;
        try {
            for (String launchIntentForPackage : getPackageNameVariants(str)) {
                intent = _activity.getPackageManager().getLaunchIntentForPackage(launchIntentForPackage);
                if (intent != null) {
                    break;
                }
            }
        } catch (Exception unused) {
            Log.v("Noodlenews", "Error determining launch intent for app: " + str);
        }
        return intent;
    }

    public static boolean isAppInstalled(String str) {
        return getLaunchIntentForPackage(str) != null;
    }

    public static boolean launchApp(final String str) {
        final Intent launchIntentForPackage = getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return false;
        }
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler == null) {
            return true;
        }
        handler.post(new Runnable() {
            public void run() {
                try {
                    NoodleNews._activity.startActivity(launchIntentForPackage);
                } catch (Exception unused) {
                    Log.v("Noodlenews", "Unable to start intent for app: " + str);
                }
            }
        });
        return true;
    }

    public static String getAppUrlForPackage(String str, int i) {
        if (i == 1 || i == 2) {
            return "amzn://apps/android?p=" + str;
        }
        return "market://details?id=" + str;
    }

    public static String getAppUrl(int i) {
        return getAppUrlForPackage(Cocos2dxActivity.getCocos2dxPackageName(), i);
    }

    public static void openURL(final String str) {
        Log.v("NoodleNews", "openURL: " + str);
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        NoodleNews._activity.startActivity(intent);
                    } catch (Exception unused) {
                        Log.v("Noodlenews", "Can not open url: " + str);
                    }
                }
            });
        }
    }

    public static void composeEmail(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        if (_activity.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            _activity.startActivity(Intent.createChooser(intent, "Choose Email Application:"));
        } else {
            UIAlertView.createDialog("No Email Available", "Could not find an available email application. Please set up email on your device.", "Ok", (String) null, (String) null, 404040);
        }
    }
}
