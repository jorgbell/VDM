package com.noodlecake.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class AmazonPurchaseWrapper {
    private static final String PURCHASE_PREFS = "NoodlecakeAmazonPurchases";
    private static final String TAG = "AmazonPurchaseWrapper";
    private static Context context = null;
    private static List<String> failedPurchases = new CopyOnWriteArrayList();
    private static AmazonPurchaseWrapper instance;
    private static AmazonPurchasingObserver observer;
    private static Map<String, String> pendingProductRequestIds = new HashMap();
    private static List<String> purchases;
    private static Map<RequestId, String> requestIdsToSku = new HashMap();

    private static native void handleMessage(String str, int i);

    private static native void handleProductListUpdate(String str, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    private static native void handleProductListUpdateError(String str, String str2);

    public static boolean isBillingSupported() {
        return true;
    }

    public static void init(Context context2) {
        Log.i(TAG, "Initializing AmazonPurchaseWrapper... ");
        context = context2;
        AmazonPurchasingObserver amazonPurchasingObserver = new AmazonPurchasingObserver();
        observer = amazonPurchasingObserver;
        PurchasingService.registerListener(context2, amazonPurchasingObserver);
        initPurchasesList();
    }

    public static void onResume() {
        Log.i(TAG, "Resuming AmazonPurchaseWrapper... ");
        PurchasingService.getUserData();
    }

    private static void persistPurchasesList() {
        Context context2;
        ObjectOutputStream objectOutputStream;
        List<String> list = purchases;
        if (list != null && (context2 = context) != null) {
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context2.openFileOutput("purchasesList.apw", 0)));
                objectOutputStream.writeObject(list);
                objectOutputStream.close();
            } catch (IOException e) {
                Log.e(TAG, "Error persisting pending purchases to disk. " + e.getMessage() + " " + e.getCause());
                e.printStackTrace();
            } catch (Throwable th) {
                objectOutputStream.close();
                throw th;
            }
        }
    }

    private static void initPurchasesList() {
        ObjectInputStream objectInputStream;
        purchases = new CopyOnWriteArrayList();
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(context.openFileInput("purchasesList.apw")));
            List<String> list = (List) objectInputStream.readObject();
            for (String str : list) {
                Log.i(TAG, "Recovered incomplete purchase: " + str);
            }
            purchases.addAll(list);
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException unused) {
        } catch (IOException e2) {
            Log.e(TAG, "Error recovering pending purchases from disk. " + e2.getMessage() + " " + e2.getCause());
            e2.printStackTrace();
        } catch (Throwable th) {
            objectInputStream.close();
            throw th;
        }
    }

    public static boolean buyItem(String str) {
        Log.i(TAG, "Buy item " + str);
        requestIdsToSku.put(PurchasingService.purchase(str), str);
        return true;
    }

    public static void itemBought(Receipt receipt) {
        String sku = receipt.getSku();
        ProductType productType = receipt.getProductType();
        Log.i(TAG, "Bought " + sku);
        boolean z = productType == ProductType.ENTITLED && hasPurchased(sku);
        SharedPreferences.Editor edit = context.getSharedPreferences(PURCHASE_PREFS, 0).edit();
        edit.putBoolean(sku, true);
        edit.commit();
        if (!z) {
            purchases.add(sku);
            persistPurchasesList();
            return;
        }
        Log.d(TAG, "Ignoring already bought item " + sku);
    }

    public static void finishTransaction(String str) {
        Log.d(TAG, "FINISH TRANSACTION FOR SKU " + str);
    }

    public static void itemFailed(RequestId requestId) {
        Log.i(TAG, "Failed requestId" + requestId);
        String str = requestIdsToSku.get(requestId);
        if (str != null) {
            failedPurchases.add(str);
            persistPurchasesList();
        }
    }

    public static void setUser(String str) {
        PurchasingService.getPurchaseUpdates(true);
    }

    public static void availableItemError() {
        for (String handleProductListUpdateError : pendingProductRequestIds.keySet()) {
            handleProductListUpdateError(handleProductListUpdateError, "Unknown error");
        }
        pendingProductRequestIds.clear();
    }

    public static void setAvailableItems(Map<String, Product> map) {
        Log.i(TAG, "Setting " + map.size() + " available items");
        for (Product next : map.values()) {
            Log.i(TAG, "Item " + next.getSku() + " == " + next.getPrice());
        }
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        String[] strArr3 = new String[map.size()];
        String[] strArr4 = new String[map.size()];
        for (String next2 : pendingProductRequestIds.keySet()) {
            int i = 0;
            for (Map.Entry<String, Product> value : map.entrySet()) {
                Product product = (Product) value.getValue();
                strArr[i] = product.getSku();
                strArr2[i] = product.getTitle();
                strArr3[i] = product.getDescription();
                strArr4[i] = product.getPrice();
                i++;
            }
            handleProductListUpdate(next2, strArr, strArr2, strArr3, strArr4);
        }
        pendingProductRequestIds.clear();
    }

    public static void handleAllMessages() {
        ArrayList<String> arrayList = new ArrayList<>(purchases);
        for (String str : arrayList) {
            Log.i(TAG, "Handle message for " + str);
            handleMessage(str, NoodlePurchaseState.SUCCESS.ordinal());
        }
        if (!arrayList.isEmpty()) {
            purchases.removeAll(arrayList);
            persistPurchasesList();
        }
        ArrayList<String> arrayList2 = new ArrayList<>(failedPurchases);
        for (String str2 : arrayList2) {
            Log.i(TAG, "Handle failed message for " + str2);
            handleMessage(str2, NoodlePurchaseState.CANCELLED.ordinal());
        }
        if (!arrayList2.isEmpty()) {
            failedPurchases.removeAll(arrayList2);
            persistPurchasesList();
        }
    }

    public static void restoreCompletedTransactions() {
        Log.i(TAG, "restoreCompletedTransactions");
        PurchasingService.getPurchaseUpdates(true);
    }

    private static boolean hasPurchased(String str) {
        return context.getSharedPreferences(PURCHASE_PREFS, 0).getBoolean(str, false);
    }

    public static void requestProductDetails(String str, String[] strArr) {
        Log.i(TAG, "Purchases AmazonPurchaseWrapper requestProductDetails");
        List<String> asList = Arrays.asList(strArr);
        HashSet hashSet = new HashSet();
        for (String str2 : asList) {
            hashSet.add(new String(str2) + "");
        }
        pendingProductRequestIds.put(str, str);
        PurchasingService.getProductData(hashSet);
    }
}
