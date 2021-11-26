package org.cocos2dx.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.applovin.sdk.AppLovinEventTypes;
import com.noodlecake.lib.UIKit;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

public abstract class Cocos2dxActivity extends Activity {
    private static final int HANDLER_SHOW_DIALOG = 1;
    private static final int HANDLER_SHOW_EXIT_DIALOG = 2;
    private static Cocos2dxMusic backgroundMusicPlayer;
    private static String exitMsg;
    private static String exitNo;
    private static String exitTitle;
    private static String exitYes;
    private static Handler handler;
    private static Activity myActivity;
    private static Context myContext;
    private static String packageName;
    private static Cocos2dxSound soundPlayer;

    public static Handler getHandler() {
        return handler;
    }

    public static Context getContext() {
        return myContext;
    }

    public static Activity getActivity() {
        return myActivity;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        backgroundMusicPlayer = new Cocos2dxMusic(this);
        soundPlayer = new Cocos2dxSound(this);
        setVolumeControlStream(3);
        myContext = this;
        myActivity = this;
        Cocos2dxBitmap.setContext(this);
        handler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Cocos2dxActivity cocos2dxActivity = Cocos2dxActivity.this;
                    Object obj = message.obj;
                    cocos2dxActivity.showDialog(((DialogMessage) obj).title, ((DialogMessage) obj).message);
                } else if (i == 2) {
                    Cocos2dxActivity cocos2dxActivity2 = Cocos2dxActivity.this;
                    Object obj2 = message.obj;
                    cocos2dxActivity2.showExitDialog(((DialogMessage) obj2).title, ((DialogMessage) obj2).message, ((DialogMessage) obj2).button1, ((DialogMessage) obj2).button2);
                }
            }
        };
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static void showMessageBox(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new DialogMessage(str, str2);
        handler.sendMessage(message);
    }

    public static void setExitDialogText(String str, String str2, String str3, String str4) {
        exitTitle = str;
        exitMsg = str2;
        exitYes = str3;
        exitNo = str4;
    }

    public static void showConfirmExitDialog() {
        String str = exitTitle;
        if (str == null) {
            str = "Confirm Exit";
        }
        String str2 = exitMsg;
        if (str2 == null) {
            str2 = "Are you sure that you want to exit " + myContext.getApplicationInfo().loadLabel(myContext.getPackageManager()) + "?";
        }
        String str3 = exitYes;
        if (str3 == null) {
            str3 = "Yes";
        }
        String str4 = exitNo;
        if (str4 == null) {
            str4 = "No";
        }
        Message message = new Message();
        message.what = 2;
        message.obj = new DialogMessage(str, str2, str3, str4);
        handler.sendMessage(message);
    }

    public static void shareDialog(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", str3);
        intent.putExtra("android.intent.extra.TEXT", str2);
        getContext().startActivity(Intent.createChooser(intent, str));
    }

    public static void shareDialog(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", str3);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("image/png");
        try {
            if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                externalStoragePublicDirectory.mkdirs();
                File file = new File(externalStoragePublicDirectory, "FlowShare.png");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            } else {
                File file2 = new File(getContext().getCacheDir(), AppLovinEventTypes.USER_SHARED_LINK);
                file2.mkdirs();
                File file3 = new File(file2, "FlowShare.png");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                Context context = getContext();
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, getContext().getPackageName() + ".fileProvider", file3));
                intent.setFlags(1);
            }
            getContext().startActivity(Intent.createChooser(intent, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void preloadBackgroundMusic(String str) {
        backgroundMusicPlayer.preloadBackgroundMusic(str);
    }

    public static void playBackgroundMusic(String str, boolean z) {
        backgroundMusicPlayer.playBackgroundMusic(str, z);
    }

    public static void stopBackgroundMusic() {
        backgroundMusicPlayer.stopBackgroundMusic();
    }

    public static void pauseBackgroundMusic() {
        backgroundMusicPlayer.pauseBackgroundMusic();
    }

    public static void resumeBackgroundMusic() {
        backgroundMusicPlayer.resumeBackgroundMusic();
    }

    public static void rewindBackgroundMusic() {
        backgroundMusicPlayer.rewindBackgroundMusic();
    }

    public static boolean isBackgroundMusicPlaying() {
        return backgroundMusicPlayer.isBackgroundMusicPlaying();
    }

    public static float getBackgroundMusicVolume() {
        return backgroundMusicPlayer.getBackgroundVolume();
    }

    public static void setBackgroundMusicVolume(float f) {
        backgroundMusicPlayer.setBackgroundVolume(f);
    }

    public static int playEffect(String str, boolean z) {
        return soundPlayer.playEffect(str, z);
    }

    public static void stopEffect(int i) {
        soundPlayer.stopEffect(i);
    }

    public static void pauseEffect(int i) {
        soundPlayer.pauseEffect(i);
    }

    public static void resumeEffect(int i) {
        soundPlayer.resumeEffect(i);
    }

    public static float getEffectsVolume() {
        return soundPlayer.getEffectsVolume();
    }

    public static void setEffectsVolume(float f) {
        soundPlayer.setEffectsVolume(f);
    }

    public static void preloadEffect(String str) {
        soundPlayer.preloadEffect(str);
    }

    public static void unloadEffect(String str) {
        soundPlayer.unloadEffect(str);
    }

    public static void stopAllEffects() {
        soundPlayer.stopAllEffects();
    }

    public static void pauseAllEffects() {
        soundPlayer.pauseAllEffects();
    }

    public static void resumeAllEffects() {
        soundPlayer.resumeAllEffects();
    }

    public static void end() {
        backgroundMusicPlayer.end();
        soundPlayer.end();
    }

    public static String getCocos2dxPackageName() {
        return packageName;
    }

    public static long systemUptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static void terminateProcess() {
        ((Activity) myContext).finish();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        UIKit.onStart();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        UIKit.onNewIntent();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UIKit.onResume();
        resumeBackgroundMusic();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UIKit.onPause();
        pauseBackgroundMusic();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        UIKit.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void setPackageName(String str) {
        packageName = str;
        try {
            Log.w("apk path", getApplication().getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to locate assets, aborting...");
        }
    }

    /* access modifiers changed from: private */
    public void showDialog(String str, String str2) {
        if (!isFinishing()) {
            new AlertDialog.Builder(this).setTitle(str).setMessage(str2).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create().show();
        }
    }

    /* access modifiers changed from: private */
    public void showExitDialog(String str, String str2, String str3, String str4) {
        if (!isFinishing()) {
            new AlertDialog.Builder(this).setTitle(str).setMessage(str2).setNegativeButton(str4, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setPositiveButton(str3, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Cocos2dxActivity.terminateProcess();
                }
            }).create().show();
        }
    }

    public static void showNotificationMessage(String str) {
        Handler handler2 = getHandler();
        final String str2 = new String(str);
        if (handler2 != null) {
            handler2.post(new Runnable() {
                public void run() {
                    Context context = Cocos2dxActivity.getContext();
                    if (context != null) {
                        Toast makeText = Toast.makeText(context, str2, 1);
                        makeText.setGravity(80, 0, 0);
                        makeText.show();
                    }
                }
            });
        }
    }
}
