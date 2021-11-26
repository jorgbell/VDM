package com.noodlecake.iapv3;

import android.app.Activity;
import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.flurry.android.FlurryAgent;
import com.noodlecake.iap.NoodlePurchaseState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PurchaseWrapperV3 {
    /* access modifiers changed from: private */
    public static String TAG = "PurchaseWrapperV3";
    /* access modifiers changed from: private */
    public static BillingClient billingClient = null;
    private static Set<String> consumableSkus = new HashSet();
    /* access modifiers changed from: private */
    public static Activity ctx = null;
    private static boolean isNativeReady = false;
    /* access modifiers changed from: private */
    public static Map<String, SkuDetails> productDetails = new HashMap();
    /* access modifiers changed from: private */
    public static String queuedProductRequestId = null;
    /* access modifiers changed from: private */
    public static ArrayList<String> queuedRequestedProducts = null;
    private static boolean restorePurchasesEnabled = false;
    /* access modifiers changed from: private */
    public static List<String> skusBuying = new ArrayList();

    public static void finishTransaction(String str) {
    }

    /* access modifiers changed from: private */
    public static native void handleMessage(String str, int i);

    /* access modifiers changed from: private */
    public static native void handleProductListUpdate(String str, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    /* access modifiers changed from: private */
    public static native void handleProductListUpdateError(String str, String str2);

    private static native void handleSyncInventory(String[] strArr);

    public static boolean isBillingSupported() {
        return true;
    }

    public static void onActivityCreate(Activity activity) {
        ctx = activity;
        Log.v(TAG, "Creating Billing Client.");
        BillingClient.Builder newBuilder = BillingClient.newBuilder(ctx);
        newBuilder.setListener(new PurchasesListener());
        newBuilder.enablePendingPurchases();
        billingClient = newBuilder.build();
        restorePurchasesEnabled = true;
        connectBilling();
    }

    public static void onActivityResume() {
        Log.v(TAG, "onActivityResume");
        restorePurchasesEnabled = true;
        queryPurchases();
    }

    public static void onActivityDestroy() {
        Log.v(TAG, "onActivityDestroy");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 != null) {
            billingClient2.endConnection();
            billingClient = null;
        }
        ctx = null;
    }

    public static void addConsumableSku(String str) {
        String str2 = TAG;
        Log.v(str2, "addConsumableSku: " + str);
        consumableSkus.add(str);
    }

    public static void initializeConsumableSkus() {
        Log.v(TAG, "initializeConsumableSkus: ");
        for (String str : consumableSkus) {
            String str2 = TAG;
            Log.v(str2, "    " + str);
        }
        isNativeReady = true;
        queryPurchases();
    }

    public static void restoreCompletedTransactions() {
        Log.v(TAG, "restoreCompletedTransactions");
        restorePurchasesEnabled = true;
        queryPurchases();
    }

    public static boolean buyItem(final String str) {
        String str2 = TAG;
        Log.v(str2, "Buy item: " + str);
        Activity activity = ctx;
        if (activity == null) {
            Log.d(TAG, "Activity is not ready.");
            return false;
        } else if (!isNativeReady) {
            Log.d(TAG, "Native not ready.");
            return false;
        } else {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (!PurchaseWrapperV3.isBillingClientReady()) {
                        Log.d(PurchaseWrapperV3.TAG, "Billing Client not ready.");
                        PurchaseWrapperV3.handleMessage(str, NoodlePurchaseState.CANCELLED.ordinal());
                        return;
                    }
                    BillingFlowParams.Builder newBuilder = BillingFlowParams.newBuilder();
                    newBuilder.setSkuDetails((SkuDetails) PurchaseWrapperV3.productDetails.get(str));
                    BillingFlowParams build = newBuilder.build();
                    PurchaseWrapperV3.skusBuying.add(str);
                    BillingResult launchBillingFlow = PurchaseWrapperV3.billingClient.launchBillingFlow(PurchaseWrapperV3.ctx, build);
                    boolean unused = PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(launchBillingFlow);
                    if (launchBillingFlow.getResponseCode() == 7) {
                        PurchaseWrapperV3.restoreCompletedTransactions();
                    }
                }
            });
            return true;
        }
    }

    private static void debugUnpurchaseAll() {
        Log.v(TAG, "DEBUG unpurchaseAll");
        Purchase.PurchasesResult queryPurchases = billingClient.queryPurchases("inapp");
        if (!isBillingResultOkAndHandleReconnect(queryPurchases.getBillingResult())) {
            String str = TAG;
            Log.d(str, "Failed to query inventory: " + queryPurchases);
            return;
        }
        debugConsumeTransactions(queryPurchases.getPurchasesList());
    }

    public static void requestProductDetails(final String str, final String[] strArr) {
        ctx.runOnUiThread(new Runnable() {
            public void run() {
                String str = new String(str);
                List<String> asList = Arrays.asList(strArr);
                ArrayList arrayList = new ArrayList();
                for (String str2 : asList) {
                    arrayList.add(new String(str2) + "");
                }
                if (PurchaseWrapperV3.isBillingClientReady()) {
                    PurchaseWrapperV3.sendRequestProductDetails(str, arrayList);
                } else if (PurchaseWrapperV3.queuedProductRequestId == null) {
                    String unused = PurchaseWrapperV3.queuedProductRequestId = str;
                    ArrayList unused2 = PurchaseWrapperV3.queuedRequestedProducts = arrayList;
                } else {
                    Log.d(PurchaseWrapperV3.TAG, "Failed to query (available products) update: Queue is full");
                    PurchaseWrapperV3.handleProductListUpdateError(str, "Unknown error");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void queryPurchases() {
        Activity activity;
        if (isNativeReady && (activity = ctx) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Log.v(PurchaseWrapperV3.TAG, "queryPurchases");
                    if (!PurchaseWrapperV3.isBillingClientReady()) {
                        Log.d(PurchaseWrapperV3.TAG, "billingClient not ready.");
                        return;
                    }
                    Purchase.PurchasesResult queryPurchases = PurchaseWrapperV3.billingClient.queryPurchases("inapp");
                    if (!PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(queryPurchases.getBillingResult())) {
                        String access$200 = PurchaseWrapperV3.TAG;
                        Log.d(access$200, "Failed to query purchases: " + queryPurchases);
                        return;
                    }
                    Log.v(PurchaseWrapperV3.TAG, "Query purchases was successful.");
                    PurchaseWrapperV3.processPurchases(queryPurchases.getPurchasesList(), true);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void sendRequestProductDetails(String str, ArrayList<String> arrayList) {
        if (!isBillingClientReady()) {
            Log.d(TAG, "Failed to query (available products) update: Billing Client not ready");
            handleProductListUpdateError(str, "Unknown error");
            return;
        }
        SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
        newBuilder.setSkusList(arrayList);
        newBuilder.setType("inapp");
        billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsListener(str));
    }

    /* access modifiers changed from: private */
    public static void processPurchases(List<Purchase> list, boolean z) {
        Log.v(TAG, "processPurchases");
        if (!isNativeReady) {
            Log.v(TAG, "Native is not ready");
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        Log.v(TAG, "Processing all purchases...");
        ArrayList arrayList = new ArrayList(list.size());
        for (Purchase next : list) {
            String sku = next.getSku();
            Object obj = "Purchased";
            if (!isConsumableSku(sku)) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Processing non-consumable: ");
                sb.append(sku);
                sb.append(" (");
                if (next.getPurchaseState() != 1) {
                    obj = Integer.valueOf(next.getPurchaseState());
                }
                sb.append(obj);
                sb.append(")");
                Log.v(str, sb.toString());
                String str2 = TAG;
                Log.v(str2, "    purchase: " + next.toString());
                if (next.getPurchaseState() == 1) {
                    if (!next.isAcknowledged()) {
                        skusBuying.remove(sku);
                        AcknowledgePurchaseParams.Builder newBuilder = AcknowledgePurchaseParams.newBuilder();
                        newBuilder.setPurchaseToken(next.getPurchaseToken());
                        AcknowledgePurchaseParams build = newBuilder.build();
                        Log.v(TAG, "    ACKNOWLEDGING");
                        billingClient.acknowledgePurchase(build, new PurchaseSaveAcknowledgePurchaseResponseListener(next));
                    } else {
                        arrayList.add(sku);
                        if (restorePurchasesEnabled) {
                            handleMessage(sku, NoodlePurchaseState.SUCCESS.ordinal());
                        }
                    }
                }
            } else {
                String str3 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Processing consumable: ");
                sb2.append(sku);
                sb2.append(" (");
                if (next.getPurchaseState() != 1) {
                    obj = Integer.valueOf(next.getPurchaseState());
                }
                sb2.append(obj);
                sb2.append(")");
                Log.v(str3, sb2.toString());
                String str4 = TAG;
                Log.v(str4, "    purchase: " + next.toString());
                if (next.getPurchaseState() == 1) {
                    skusBuying.remove(sku);
                    ConsumeParams.Builder newBuilder2 = ConsumeParams.newBuilder();
                    newBuilder2.setPurchaseToken(next.getPurchaseToken());
                    ConsumeParams build2 = newBuilder2.build();
                    Log.v(TAG, "    CONSUMING");
                    billingClient.consumeAsync(build2, new PurchaseSaveConsumeResponseListener(next));
                }
            }
        }
        if (z) {
            handleSyncInventory((String[]) arrayList.toArray(new String[arrayList.size()]));
            if (restorePurchasesEnabled) {
                restorePurchasesEnabled = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void requestQueuedProductDetails() {
        String str = queuedProductRequestId;
        if (str != null) {
            sendRequestProductDetails(str, queuedRequestedProducts);
            queuedProductRequestId = null;
            queuedRequestedProducts = null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isBillingResultOkAndHandleReconnect(BillingResult billingResult) {
        if (billingResult.getResponseCode() == -1) {
            connectBilling();
            return false;
        }
        if (billingResult.getResponseCode() != 0) {
            String str = TAG;
            Log.d(str, "Billing Result Code (Not OK): " + billingResult.getResponseCode());
        }
        if (billingResult.getResponseCode() == 0) {
            return true;
        }
        return false;
    }

    private static void connectBilling() {
        Log.v(TAG, "Connecting billing client...");
        ctx.runOnUiThread(new Runnable() {
            public void run() {
                PurchaseWrapperV3.billingClient.startConnection(new BillingClientStateListener() {
                    public void onBillingServiceDisconnected() {
                    }

                    public void onBillingSetupFinished(BillingResult billingResult) {
                        Log.v(PurchaseWrapperV3.TAG, "Connection finished.");
                        if (billingResult.getResponseCode() == 0) {
                            PurchaseWrapperV3.requestQueuedProductDetails();
                            PurchaseWrapperV3.queryPurchases();
                            return;
                        }
                        String access$200 = PurchaseWrapperV3.TAG;
                        Log.d(access$200, "Problem setting up in-app billing: " + billingResult.getDebugMessage());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static void logFlurryPayment(String str, String str2) {
        double d;
        Map<String, SkuDetails> map = productDetails;
        String str3 = null;
        SkuDetails skuDetails = (map == null || !map.containsKey(str)) ? null : productDetails.get(str);
        HashMap hashMap = new HashMap();
        String title = skuDetails != null ? skuDetails.getTitle() : null;
        if (skuDetails != null) {
            double priceAmountMicros = (double) skuDetails.getPriceAmountMicros();
            Double.isNaN(priceAmountMicros);
            d = priceAmountMicros / 1000000.0d;
        } else {
            d = 0.0d;
        }
        if (skuDetails != null) {
            str3 = skuDetails.getPriceCurrencyCode();
        }
        FlurryAgent.logPayment(title, str, 1, d, str3, str2, hashMap);
    }

    private static boolean isConsumableSku(String str) {
        if (!isNativeReady) {
            Log.d(TAG, "isConsumableSku called before native is ready.");
        }
        return consumableSkus.contains(str);
    }

    /* access modifiers changed from: private */
    public static boolean isBillingClientReady() {
        BillingClient billingClient2 = billingClient;
        return billingClient2 != null && billingClient2.isReady();
    }

    private static class SkuDetailsListener implements SkuDetailsResponseListener {
        private String requestId = null;

        public SkuDetailsListener(String str) {
            this.requestId = str;
        }

        public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
            Log.v(PurchaseWrapperV3.TAG, "onSkuDetailsResponse");
            if (PurchaseWrapperV3.billingClient == null) {
                PurchaseWrapperV3.handleProductListUpdateError(this.requestId, "Unknown error");
            } else if (!PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(billingResult)) {
                String access$200 = PurchaseWrapperV3.TAG;
                Log.d(access$200, "Failed to query update: " + billingResult.getDebugMessage());
                PurchaseWrapperV3.handleProductListUpdateError(this.requestId, billingResult.getDebugMessage());
            } else {
                String[] strArr = new String[list.size()];
                String[] strArr2 = new String[list.size()];
                String[] strArr3 = new String[list.size()];
                String[] strArr4 = new String[list.size()];
                int i = 0;
                for (SkuDetails next : list) {
                    strArr[i] = next.getSku();
                    strArr2[i] = next.getTitle();
                    strArr3[i] = next.getDescription();
                    strArr4[i] = next.getPrice();
                    PurchaseWrapperV3.productDetails.put(next.getSku(), next);
                    i++;
                }
                PurchaseWrapperV3.handleProductListUpdate(this.requestId, strArr, strArr2, strArr3, strArr4);
            }
        }
    }

    private static class PurchasesListener implements PurchasesUpdatedListener {
        private PurchasesListener() {
        }

        public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
            String access$200 = PurchaseWrapperV3.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onPurchasesUpdated(");
            sb.append(billingResult.getDebugMessage());
            sb.append(",");
            sb.append(billingResult.getResponseCode());
            sb.append(",");
            sb.append(list != null ? list.toString() : "Null Purchases");
            sb.append(")");
            Log.v(access$200, sb.toString());
            if (PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(billingResult)) {
                PurchaseWrapperV3.processPurchases(list, false);
                for (String access$300 : PurchaseWrapperV3.skusBuying) {
                    PurchaseWrapperV3.handleMessage(access$300, NoodlePurchaseState.CANCELLED.ordinal());
                }
                PurchaseWrapperV3.skusBuying.clear();
            }
        }
    }

    private static class PurchaseSaveAcknowledgePurchaseResponseListener implements AcknowledgePurchaseResponseListener {
        private Purchase purchase = null;

        public PurchaseSaveAcknowledgePurchaseResponseListener(Purchase purchase2) {
            this.purchase = purchase2;
        }

        public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
            String access$200 = PurchaseWrapperV3.TAG;
            Log.v(access$200, "Acknowledge finished: " + billingResult.getResponseCode());
            if (PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(billingResult)) {
                PurchaseWrapperV3.handleMessage(this.purchase.getSku(), NoodlePurchaseState.SUCCESS.ordinal());
                PurchaseWrapperV3.logFlurryPayment(this.purchase.getSku(), this.purchase.getPurchaseToken());
                String access$2002 = PurchaseWrapperV3.TAG;
                Log.v(access$2002, "Acknowledge purchase successful. " + this.purchase.getSku());
                return;
            }
            PurchaseWrapperV3.handleMessage(this.purchase.getSku(), NoodlePurchaseState.CANCELLED.ordinal());
            String access$2003 = PurchaseWrapperV3.TAG;
            Log.v(access$2003, "Error acknowledging purchase: " + billingResult.getDebugMessage());
        }
    }

    private static class PurchaseSaveConsumeResponseListener implements ConsumeResponseListener {
        private Purchase purchase = null;

        public PurchaseSaveConsumeResponseListener(Purchase purchase2) {
            this.purchase = purchase2;
        }

        public void onConsumeResponse(BillingResult billingResult, String str) {
            String access$200 = PurchaseWrapperV3.TAG;
            Log.v(access$200, "Consume finished: " + billingResult.getResponseCode() + ", Purchase token: " + str);
            if (PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(billingResult)) {
                PurchaseWrapperV3.handleMessage(this.purchase.getSku(), NoodlePurchaseState.SUCCESS.ordinal());
                PurchaseWrapperV3.logFlurryPayment(this.purchase.getSku(), str);
                String access$2002 = PurchaseWrapperV3.TAG;
                Log.v(access$2002, "Purchase consumable successful. " + this.purchase.getSku());
                return;
            }
            PurchaseWrapperV3.handleMessage(this.purchase.getSku(), NoodlePurchaseState.CANCELLED.ordinal());
            String access$2003 = PurchaseWrapperV3.TAG;
            Log.v(access$2003, "Error consuming purchase: " + billingResult.getDebugMessage());
        }
    }

    private static void debugUnpurchase(final String str) {
        String str2 = TAG;
        Log.v(str2, "DEBUG unpurchase: " + str);
        ctx.runOnUiThread(new Runnable() {
            public void run() {
                Purchase.PurchasesResult queryPurchases = PurchaseWrapperV3.billingClient.queryPurchases("inapp");
                if (!PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(queryPurchases.getBillingResult())) {
                    String access$200 = PurchaseWrapperV3.TAG;
                    Log.d(access$200, "Failed to query inventory: " + queryPurchases);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Purchase next : queryPurchases.getPurchasesList()) {
                    if (next.getSku().equalsIgnoreCase(str)) {
                        arrayList.add(next);
                    }
                }
                PurchaseWrapperV3.debugConsumeTransactions(arrayList);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void debugConsumeTransactions(final List<Purchase> list) {
        Log.v(TAG, "DEBUG consumeTransactions");
        ctx.runOnUiThread(new Runnable() {
            public void run() {
                for (final Purchase purchase : list) {
                    ConsumeParams.Builder newBuilder = ConsumeParams.newBuilder();
                    newBuilder.setPurchaseToken(purchase.getPurchaseToken());
                    PurchaseWrapperV3.billingClient.consumeAsync(newBuilder.build(), new ConsumeResponseListener() {
                        public void onConsumeResponse(BillingResult billingResult, String str) {
                            if (PurchaseWrapperV3.isBillingResultOkAndHandleReconnect(billingResult)) {
                                String access$200 = PurchaseWrapperV3.TAG;
                                Log.v(access$200, "Consumption successful. Purchase " + purchase);
                                return;
                            }
                            String access$2002 = PurchaseWrapperV3.TAG;
                            Log.d(access$2002, "Error while consuming: " + purchase + ", " + billingResult.getDebugMessage());
                        }
                    });
                }
            }
        });
    }
}
