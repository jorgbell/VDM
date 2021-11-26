package com.noodlecake.noodlenews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bigduckgames.flow.AnalyticsManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.noodlecake.flow.utils.CloudStorageHelper;
import com.noodlecake.flow.utils.GooglePlayAchievementHelper;
import com.noodlecake.flow.utils.SharedPrefsHelper;
import com.noodlecake.iapv3.PurchaseWrapperV3;
import com.noodlecake.lib.UIKit;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import gnustep.foundation.Common;
import java.util.HashMap;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.Cocos2dxRenderer;

public class NoodlecakeGameActivity extends Cocos2dxActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RC_SIGN_IN = 9001;
    public static final int REQUEST_ACHIEVEMENTS = 1;
    private static final String TAG = "NoodlecakeGameActivity";
    private static Context context = null;
    private static GoogleSignInClient googleSignInClient = null;
    public static byte[] google_bytes = {43, 35, 34, 38, 58, 12, 9, 10, 40, 12, 15, 54, 63, 35, 46, 52, 85, 68, 4, 113, 117, 53, 54, 32, 37, 114, 123, 112, 115, 104, 74, 117, 5, 3, 14, 4, 5, 85, 120, 113, 119, 102, 15, 9, 48, 12, 81, 73, 75, 4, 97, 40, 55, 38, 87, 55, 47, 14, 7, 38, 18, 35, 69, 102, 115, 103, 7, 49, 14, 47, 36, 44, 2, 33, 58, 8, 2, 22, 70, 71, 125, 115, 98, 28, 1, 54, 38, 63, 22, 38, 2, 24, 18, 85, 1, 35, 65, 113, 3, 34, 25, 52, 35, 30, 39, 62, 38, 59, 83, 8, 103, 113, 6, 60, 5, 66, 7, 118, 99, 87, 37, 11, 11, 85, 64, 68, 125, 120, 33, 69, 5, 16, 9, 4, 15, 97, 4, 89, 69, 121, 122, 126, 27, 82, 1, 85, 21, 63, 4, 10, 98, 34, 51, 52, 52, 95, 51, 49, 8, 15, 92, 102, 102, 124, 54, 23, 73, 43, 43, 62, 45, 82, 58, 1, 3, 2, 92, 91, 80, 0, 2, 1, 84, 3, 27, 16, 13, 107, 52, 2, 0, 0, 45, 58, 117, 98, 37, 90, 42, 47, 28, 53, 123, 117, 28, 95, 45, 112, 32, 36, 36, 39, 3, 67, 97, 126, 82, 44, 88, 81, 62, 99, 27, 87, 70, 1, 74, 27, 48, 32, 117, 55, 36, 65, 92, 7, 79, 123, 41, 113, 63, 52, 48, 39, 64, 30, 101, 48, 43, 49, 5, 59, 46, 50, 12, 2, 18, 90, 26, 68, 5, 0, 45, 49, 37, 43, 89, 62, 94, 19, 42, 11, 2, 2, 99, 80, 113, 14, 83, 69, 11, 73, 47, 19, 61, 61, 115, 0, 23, 54, 94, 56, 105, 125, 22, 65, 12, 7, 21, 77, 2, 42, 11, 28, 38, 13, 29, 49, 54, 88, 34, 82, 126, 98, 98, 12, 55, 45, 29, 119, 0, 0, 92, 14, 62, 126, 16, 56, 51, 109, 14, 94, 94, 112, 0, 69, 114, 126, 24, 11, 22, 84, 88, 17, 112, 6, 40, 1, 34, 0, 86, 24, 47, 38, 6, 50, 100, 99, 71, 92, 37, 20, 7, 16, 8, 5, 88, 82, 47, 71, 5, 83, 94, Byte.MAX_VALUE, 101, 106, 114, 99, 60, 42, 27, 9, 35, 13, 18, 0, 47, 35, 41, 57, 114, 122};
    private static Handler handler = new Handler();
    /* access modifiers changed from: private */
    public static NoodlecakeGameActivity instance = null;
    private static FrameLayout layout_main = null;
    private static boolean mIsResolving = false;
    private static boolean mSigningIn = false;
    private static SharedPrefsHelper prefsHelper;
    private boolean hasDepthBuffer;
    private boolean hasNews;
    private boolean hasPopups;
    private boolean hasPurchases;
    protected Cocos2dxGLSurfaceView mGLView;
    private int platform;
    private int version;

    public static native int getPlatform();

    public static native int getVersion();

    public static native void sendApiConnected();

    static {
        Class<NoodlecakeGameActivity> cls = NoodlecakeGameActivity.class;
    }

    public NoodlecakeGameActivity(boolean z, boolean z2, boolean z3) {
        this(z, z2, z3, false);
    }

    public NoodlecakeGameActivity(boolean z, boolean z2, boolean z3, boolean z4) {
        this.platform = 4;
        this.version = 30;
        this.hasPopups = z;
        this.hasPurchases = z2;
        this.hasNews = z3;
        this.hasDepthBuffer = z4;
        this.platform = getPlatform();
        this.version = getVersion();
        context = this;
        instance = this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle, int i, int i2, int i3) {
        super.onCreate(bundle);
        setContentView(i);
        layout_main = (FrameLayout) getWindow().getDecorView().findViewById(16908290);
        Cocos2dxGLSurfaceView cocos2dxGLSurfaceView = (Cocos2dxGLSurfaceView) findViewById(i2);
        this.mGLView = cocos2dxGLSurfaceView;
        cocos2dxGLSurfaceView.setTextField((EditText) findViewById(i3));
        this.mGLView.setEGLConfigChooser(this.hasDepthBuffer);
        this.mGLView.setCocos2dxRenderer(new Cocos2dxRenderer());
        setPackageName(getApplication().getPackageName());
        Common.setup(this);
        UIKit.init(this);
        if (this.hasPurchases) {
            PurchaseWrapperV3.onActivityCreate(this);
        }
        if (this.hasNews) {
            try {
                Class.forName("com.noodlecake.noodlenews.NoodleNews").getMethod("init", new Class[]{Activity.class}).invoke((Object) null, new Object[]{this});
            } catch (Exception e) {
                Log.e(TAG, "" + e);
                this.hasNews = false;
            }
        }
        GooglePlayAchievementHelper.init();
        prefsHelper = new SharedPrefsHelper(getContext());
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        builder.requestScopes(Drive.SCOPE_APPFOLDER, new Scope[0]);
        googleSignInClient = GoogleSignIn.getClient((Activity) this, builder.build());
    }

    private void signInSilently() {
        googleSignInClient.silentSignIn().addOnCompleteListener((Activity) this, new OnCompleteListener<GoogleSignInAccount>() {
            public void onComplete(Task<GoogleSignInAccount> task) {
                if (task.isSuccessful()) {
                    Log.d(NoodlecakeGameActivity.TAG, "signInSilently(): success");
                    NoodlecakeGameActivity.this.onConnected(task.getResult());
                    return;
                }
                Log.d(NoodlecakeGameActivity.TAG, "signInSilently(): failure", task.getException());
                NoodlecakeGameActivity.this.onDisconnected();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d(TAG, "NoodlecakeGameActivity onActivityResult");
        super.onActivityResult(i, i2, intent);
        if (i == 9001) {
            try {
                onConnected(GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class));
            } catch (ApiException e) {
                String message = e.getMessage();
                if (message != null) {
                    boolean isEmpty = message.isEmpty();
                }
                onDisconnected();
            }
        } else if (i != 1) {
            Log.w(TAG, "NoodlecakeGameActivity onActivityResult - Unexpected activity result with request code '" + i + "'");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.e(TAG, "NoodlecakeGameActivity should be called with overloaded onCreate method");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.hasPopups) {
            try {
                Class.forName("com.noodlecake.noodlenews.Popup").getMethod("appCreate", new Class[]{Context.class, Handler.class}).invoke((Object) null, new Object[]{this, handler});
            } catch (Exception e) {
                Log.e(TAG, "" + e);
                this.hasPopups = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mGLView.onPause();
        if (this.hasPopups) {
            try {
                Class.forName("com.noodlecake.noodlenews.Popup").getMethod("appPausing", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                Log.e(TAG, "" + e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.hasPopups) {
            try {
                Class.forName("com.noodlecake.noodlenews.Popup").getMethod("appStopped", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                Log.e(TAG, "" + e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mGLView.onResume();
        if (this.hasPopups) {
            try {
                Class.forName("com.noodlecake.noodlenews.Popup").getMethod("appResuming", new Class[]{Bundle.class}).invoke((Object) null, new Object[]{getIntent().getExtras()});
            } catch (Exception e) {
                Log.e(TAG, "" + e);
            }
        }
        if (this.hasPurchases) {
            PurchaseWrapperV3.onActivityResume();
        }
        signInSilently();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.hasPurchases) {
            PurchaseWrapperV3.onActivityDestroy();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void onConnected(GoogleSignInAccount googleSignInAccount) {
        Log.v(TAG, "Connected to google api client");
        Games.getGamesClient(this, GoogleSignIn.getLastSignedInAccount(getContext())).setViewForPopups(layout_main);
        sendApiConnected();
        if (CloudStorageHelper.shouldLoadOnConnection() || !CloudStorageHelper.hasLoadedSuccessfully()) {
            CloudStorageHelper.loadCloudData();
        }
    }

    /* access modifiers changed from: private */
    public void onDisconnected() {
        Log.d(TAG, "onDisconnected()");
    }

    private boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(this) != null;
    }

    public static void loginToGoogleAPI() {
        if (!isGoogleAPIConnected()) {
            instance.startActivityForResult(googleSignInClient.getSignInIntent(), 9001);
        }
    }

    public static void logoffGoogleAPI() {
        if (instance.isSignedIn()) {
            googleSignInClient.signOut().addOnCompleteListener((Activity) instance, new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    NoodlecakeGameActivity.instance.onDisconnected();
                }
            });
        }
    }

    public static boolean isGoogleAPIConnected() {
        return instance.isSignedIn();
    }

    public static boolean shouldGoogleAPIConnect() {
        return !isGoogleAPIConnected();
    }

    public static void showAchievements() {
        Games.getAchievementsClient(getContext(), GoogleSignIn.getLastSignedInAccount(getContext())).getAchievementsIntent().addOnSuccessListener(new OnSuccessListener<Intent>() {
            public void onSuccess(Intent intent) {
                NoodlecakeGameActivity.instance.startActivityForResult(intent, 1);
            }
        });
    }

    public static boolean gotoQuickReviewScreen(int i, final int i2, final int i3) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Handler handler2 = Cocos2dxActivity.getHandler();
        if (handler2 == null) {
            return true;
        }
        handler2.post(new Runnable() {
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("first", i2 == 0 ? "1" : "0");
                hashMap.put("count", String.valueOf(i2 + 1));
                hashMap.put("levelsCompleted", String.valueOf(i3));
                AnalyticsManager.logEventStart(NoodlecakeGameActivity.instance, "ShowReviewPrompt", hashMap);
                ReviewManager create = ReviewManagerFactory.create(NoodlecakeGameActivity.instance);
                create.requestReviewFlow().addOnCompleteListener(new com.google.android.play.core.tasks.OnCompleteListener() {
                    public final void onComplete(com.google.android.play.core.tasks.Task task) {
                        NoodlecakeGameActivity.C27524.lambda$run$1(ReviewManager.this, task);
                    }
                });
            }

            static /* synthetic */ void lambda$run$1(ReviewManager reviewManager, com.google.android.play.core.tasks.Task task) {
                if (task.isSuccessful()) {
                    reviewManager.launchReviewFlow(NoodlecakeGameActivity.instance, (ReviewInfo) task.getResult()).addOnCompleteListener($$Lambda$NoodlecakeGameActivity$4$VBxwMokjGuUQoqdjtoZnmHv7zM.INSTANCE);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("action", "GooglePlay");
                Exception exception = task.getException();
                if (exception != null) {
                    hashMap.put("error_cause", exception.getCause() != null ? exception.getCause().getMessage() : "Null Cause");
                    hashMap.put("error_description", exception.getMessage());
                }
                AnalyticsManager.logEventEnd(NoodlecakeGameActivity.instance, "ShowReviewPrompt", hashMap);
            }

            static /* synthetic */ void lambda$null$0(com.google.android.play.core.tasks.Task task) {
                HashMap hashMap = new HashMap();
                hashMap.put("action", "GooglePlay");
                AnalyticsManager.logEventEnd(NoodlecakeGameActivity.instance, "ShowReviewPrompt", hashMap);
            }
        });
        return true;
    }

    public static void gotoReviewScreen(final int i) {
        Handler handler2 = Cocos2dxActivity.getHandler();
        if (handler2 != null) {
            handler2.post(new Runnable() {
                public void run() {
                    String appUrl = NoodleNews.getAppUrl(i);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(appUrl));
                    NoodlecakeGameActivity.instance.startActivity(intent);
                }
            });
        }
    }

    public static String getStringResource(String str) {
        try {
            Resources resources = instance.getResources();
            return resources.getText(resources.getIdentifier(str, "string", instance.getPackageName())).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }
}
