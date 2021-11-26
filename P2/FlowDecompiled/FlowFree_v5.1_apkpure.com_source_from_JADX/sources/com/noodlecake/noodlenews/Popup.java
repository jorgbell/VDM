package com.noodlecake.noodlenews;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.bigduckgames.flow.AnalyticsManager;
import com.mopub.common.Constants;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Popup {
    private static final String POPUP_URI = "https://news.noodlecake.net/popups/";
    private static final String TAG = "Popup";
    /* access modifiers changed from: private */
    public static Context appContext = null;
    private static Handler appHandler = null;
    private static String cancelText = null;
    private static String closeText = null;
    /* access modifiers changed from: private */
    public static String currencyName = "Coins";
    private static String getItPlainText = null;
    private static String getItText = null;
    /* access modifiers changed from: private */
    public static boolean isPaused = true;
    /* access modifiers changed from: private */
    public static Map<Integer, PopupTransaction> listedTransactions = Collections.synchronizedMap(new HashMap());
    private static int moreGamesCount = 0;
    private static int newsIdToBeShown = 0;
    private static String noThanksText;
    private static String okText;
    private static String okayText;
    private static int pendingCurrency = 0;
    /* access modifiers changed from: private */
    public static String platform;
    private static PopupTransactionDB transactionDB;

    public static void appStopped() {
    }

    public static void appCreate(Context context, Handler handler) {
        appContext = context;
        appHandler = handler;
        PopupTransactionDB popupTransactionDB = transactionDB;
        if (popupTransactionDB != null) {
            popupTransactionDB.close();
        }
        transactionDB = new PopupTransactionDB(appContext);
    }

    public static void appResuming(Bundle bundle) {
        isPaused = false;
        if (platform != null) {
            pollPopupServer();
        }
    }

    public static void setPlatform(int i) {
        if (i == 1 || i == 2) {
            platform = "amazon";
        } else if (i == 0) {
            platform = Constants.ANDROID_PLATFORM;
        } else {
            Log.w(TAG, "Popups not supported on current platform (" + i + ")");
            platform = null;
        }
        if (platform != null) {
            pollPopupServer();
        }
    }

    public static void appPausing() {
        isPaused = true;
    }

    public static Context getContext() {
        return appContext;
    }

    public static Handler getHandler() {
        return appHandler;
    }

    public static void incomingPushBundle(Bundle bundle) {
        int i;
        try {
            i = new JSONObject(bundle.getString("com.parse.Data")).getInt("news_id");
        } catch (Exception unused) {
            i = 0;
        }
        if (!showPopupforNewsId(i) && i != 0) {
            newsIdToBeShown = i;
            pollPopupServer();
        }
    }

    public static void checkForPendingNewsId() {
        int i = newsIdToBeShown;
        if (i != 0) {
            showPopupforNewsId(i);
        }
        newsIdToBeShown = 0;
    }

    public static boolean showPopupforNewsId(int i) {
        for (PopupTransaction next : getTransactionsNotAcked()) {
            if (next.getPopupId() == i) {
                popItUp(next);
                return true;
            }
        }
        return false;
    }

    public static void checkParameterizedPopup(int i) {
        for (PopupTransaction next : getTransactionsNotAcked()) {
            if (!next.isImmediate() && next.getParameter1() != null && Integer.parseInt(next.getParameter1()) == i) {
                popItUp(next);
                return;
            }
        }
    }

    public static boolean hasParameterizedPopup(int i) {
        for (PopupTransaction next : getTransactionsNotAcked()) {
            if (!next.isImmediate() && next.getParameter1() != null && Integer.parseInt(next.getParameter1()) == i) {
                return true;
            }
        }
        return false;
    }

    public static void checkImmediatePopup() {
        for (PopupTransaction next : getTransactionsNotAcked()) {
            if (next.isImmediate()) {
                popItUp(next);
                return;
            }
        }
    }

    public static boolean hasImmediatePopup() {
        for (PopupTransaction isImmediate : getTransactionsNotAcked()) {
            if (isImmediate.isImmediate()) {
                return true;
            }
        }
        return false;
    }

    public static void setPopupButtonText(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        closeText = str;
        cancelText = str2;
        noThanksText = str3;
        getItPlainText = str4;
        getItText = str5;
        okText = str6;
        okayText = str7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0 == null) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        if (r1 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void localizePopupButtonText(com.noodlecake.noodlenews.PopupTransaction r4) {
        /*
            java.lang.String r0 = r4.getNegativeButtonText()
            java.lang.String r1 = r4.getPositiveButtonText()
            java.lang.String r2 = "Close"
            boolean r3 = r2.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0017
            java.lang.String r0 = closeText
            if (r0 == 0) goto L_0x0015
            goto L_0x0030
        L_0x0015:
            r0 = r2
            goto L_0x0030
        L_0x0017:
            java.lang.String r2 = "Cancel"
            boolean r3 = r2.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0024
            java.lang.String r0 = cancelText
            if (r0 == 0) goto L_0x0015
            goto L_0x0030
        L_0x0024:
            java.lang.String r2 = "No thanks"
            boolean r3 = r2.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0030
            java.lang.String r0 = noThanksText
            if (r0 == 0) goto L_0x0015
        L_0x0030:
            java.lang.String r2 = "Get It"
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x003f
            java.lang.String r1 = getItPlainText
            if (r1 == 0) goto L_0x003d
            goto L_0x0065
        L_0x003d:
            r1 = r2
            goto L_0x0065
        L_0x003f:
            java.lang.String r2 = "Get It!"
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x004c
            java.lang.String r1 = getItText
            if (r1 == 0) goto L_0x003d
            goto L_0x0065
        L_0x004c:
            java.lang.String r2 = "OK"
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0059
            java.lang.String r1 = okText
            if (r1 == 0) goto L_0x003d
            goto L_0x0065
        L_0x0059:
            java.lang.String r2 = "Okay"
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0065
            java.lang.String r1 = okayText
            if (r1 == 0) goto L_0x003d
        L_0x0065:
            r4.setNegativeButtonText(r0)
            r4.setPositiveButtonText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.noodlenews.Popup.localizePopupButtonText(com.noodlecake.noodlenews.PopupTransaction):void");
    }

    public static void popItUp(PopupTransaction popupTransaction) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("id", "" + popupTransaction.getId());
            hashMap.put("popup_id", "" + popupTransaction.getPopupId());
            hashMap.put("type", popupTransaction.getType());
            hashMap.put("url", popupTransaction.getParameter2() != null ? popupTransaction.getParameter2() : "none");
            AnalyticsManager.logEventStart(appContext, "NoodlePopup", hashMap);
            AnalyticsManager.logEventEnd(appContext, "NoodlePopup", (Map<String, String>) null);
        } catch (Exception unused) {
        }
        localizePopupButtonText(popupTransaction);
        if (popupTransaction.getType().equals("MAILING_LIST")) {
            EmailPopup.popUpEmailDialog(popupTransaction);
        } else if (popupTransaction.getType().equals("URL_OPEN")) {
            OpenUrlPopup.openUrl(popupTransaction);
        } else if (popupTransaction.getType().equals("ALERT")) {
            AlertPopup.popUpAlert(popupTransaction);
        }
        transactionDB.markPopupIdAcked(popupTransaction.getPopupId());
    }

    public static void addCurrency(int i) {
        PopupTransaction popupTransaction = listedTransactions.get(Integer.valueOf(i));
        if (popupTransaction.getParameter3() != null && Integer.parseInt(popupTransaction.getParameter3()) > 0) {
            pendingCurrency += Integer.parseInt(popupTransaction.getParameter3());
        }
    }

    public static int shouldCredit() {
        int i = pendingCurrency;
        if (i <= 0) {
            return 0;
        }
        pendingCurrency = i - i;
        return i;
    }

    public static int getMoreGamesCount() {
        return moreGamesCount;
    }

    public static void showSuccess(final int i) {
        Handler handler = appHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (Popup.appContext != null) {
                        Context access$000 = Popup.appContext;
                        Toast makeText = Toast.makeText(access$000, "Thanks!  You've received " + i + " " + Popup.currencyName + "!", 1);
                        makeText.setGravity(80, 0, 0);
                        makeText.show();
                    }
                }
            });
        }
    }

    public static void pollPopupServer() {
        if (appHandler != null && platform != null) {
            final C27582 r0 = new Thread() {
                public void run() {
                    String str;
                    NetworkInfo activeNetworkInfo;
                    String packageName = Popup.appContext.getPackageName();
                    try {
                        str = Popup.appContext.getPackageManager().getPackageInfo(Popup.appContext.getPackageName(), 0).versionName;
                    } catch (PackageManager.NameNotFoundException unused) {
                        str = "1.0";
                    }
                    String str2 = "?bundle_id=" + packageName + "&platform=" + Popup.platform + "&version=" + str;
                    Log.i(Popup.TAG, Popup.POPUP_URI + str2);
                    try {
                        URI uri = new URI(Popup.POPUP_URI + str2);
                        try {
                            if (!Popup.isPaused && (activeNetworkInfo = ((ConnectivityManager) Popup.appContext.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                                checkPopups(uri);
                                Popup.checkForPendingNewsId();
                            }
                        } catch (JSONException e) {
                            Log.i(Popup.TAG, "json exception " + e.getMessage());
                        } catch (Exception e2) {
                            Log.i(Popup.TAG, "regular exception " + e2.getMessage());
                        }
                    } catch (URISyntaxException unused2) {
                    }
                }

                public void checkPopups(URI uri) throws IOException, ClientProtocolException, JSONException {
                    Popup.listedTransactions.putAll(Popup.parsePollingResponse(new JSONObject((String) new DefaultHttpClient().execute(new HttpGet(uri), new BasicResponseHandler()))));
                }
            };
            appHandler.post(new Runnable() {
                public void run() {
                    r0.start();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static HashMap<Integer, PopupTransaction> parsePollingResponse(JSONObject jSONObject) throws JSONException {
        HashMap<Integer, PopupTransaction> hashMap = new HashMap<>();
        try {
            moreGamesCount = jSONObject.getInt("game_count");
        } catch (Exception unused) {
            moreGamesCount = 0;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("results");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            PopupTransaction popupTransaction = new PopupTransaction(jSONObject2.getInt("id"));
            popupTransaction.setPopupId(jSONObject2.getInt("popup_id"));
            if (!jSONObject2.isNull("title")) {
                popupTransaction.setTitle(jSONObject2.getString("title"));
            }
            if (!jSONObject2.isNull("description")) {
                popupTransaction.setDescription(jSONObject2.getString("description"));
            }
            if (!jSONObject2.isNull("type")) {
                popupTransaction.setType(jSONObject2.getString("type"));
            }
            boolean z = true;
            if (jSONObject2.getInt("immediate") != 1) {
                z = false;
            }
            popupTransaction.setImmediate(z);
            if (!jSONObject2.isNull("positive_button_text")) {
                popupTransaction.setPositiveButtonText(jSONObject2.getString("positive_button_text"));
            }
            if (!jSONObject2.isNull("negative_button_text")) {
                popupTransaction.setNegativeButtonText(jSONObject2.getString("negative_button_text"));
            }
            if (!jSONObject2.isNull("parameter_1")) {
                popupTransaction.setParameter1(jSONObject2.getString("parameter_1"));
            }
            if (!jSONObject2.isNull("parameter_2")) {
                popupTransaction.setParameter2(jSONObject2.getString("parameter_2"));
            }
            if (!jSONObject2.isNull("parameter_3")) {
                popupTransaction.setParameter3(jSONObject2.getString("parameter_3"));
            }
            if (!jSONObject2.isNull("parameter_4")) {
                popupTransaction.setParameter4(jSONObject2.getString("parameter_4"));
            }
            hashMap.put(Integer.valueOf(popupTransaction.getId()), popupTransaction);
        }
        return hashMap;
    }

    public static ArrayList<PopupTransaction> getTransactionsNotAcked() {
        ArrayList<PopupTransaction> arrayList = new ArrayList<>();
        synchronized (listedTransactions) {
            for (PopupTransaction next : listedTransactions.values()) {
                if (transactionDB.popupIdNotAcked(next.getPopupId())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static void setCurrencyName(String str) {
        currencyName = str;
    }
}
