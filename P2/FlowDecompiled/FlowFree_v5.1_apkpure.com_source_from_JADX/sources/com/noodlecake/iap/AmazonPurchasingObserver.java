package com.noodlecake.iap;

import android.util.Log;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserDataResponse;

public class AmazonPurchasingObserver implements PurchasingListener {
    private static final String TAG = "AmazonPurchaseObserver";

    public void onUserDataResponse(UserDataResponse userDataResponse) {
        Log.v(TAG, "onUserDataResponse received: Response - HIDDEN");
        Log.v(TAG, "RequestId:" + userDataResponse.getRequestId());
        Log.v(TAG, "RequestStatus:" + userDataResponse.getRequestStatus());
        if (userDataResponse.getRequestStatus() == UserDataResponse.RequestStatus.SUCCESSFUL) {
            AmazonPurchaseWrapper.setUser(userDataResponse.getUserData().getUserId());
            return;
        }
        Log.v(TAG, "onUserDataResponse: Unable to get user ID.");
        AmazonPurchaseWrapper.setUser((String) null);
    }

    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        Log.v(TAG, "onProductDataResponse received");
        Log.v(TAG, "RequestStatus " + productDataResponse.getRequestStatus());
        Log.v(TAG, "RequestId " + productDataResponse.getRequestId());
        Log.v(TAG, productDataResponse.toString());
        for (String str : productDataResponse.getUnavailableSkus()) {
            Log.v(TAG, "Unavailable SKU: " + str);
        }
        int i = C27041.f5599x4eb80c9f[productDataResponse.getRequestStatus().ordinal()];
        if (i == 1) {
            AmazonPurchaseWrapper.setAvailableItems(productDataResponse.getProductData());
        } else if (i == 2 || i == 3) {
            AmazonPurchaseWrapper.availableItemError();
        }
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        Log.v(TAG, "onPurchaseResponse received");
        Log.v(TAG, "RequestStatus:" + purchaseResponse.getRequestStatus());
        int i = C27041.f5600xc71ab397[purchaseResponse.getRequestStatus().ordinal()];
        if (i == 1 || i == 2) {
            Receipt receipt = purchaseResponse.getReceipt();
            if (!receipt.isCanceled()) {
                Log.v(TAG, "Bought item: " + receipt.getSku());
                AmazonPurchaseWrapper.itemBought(receipt);
                PurchasingService.notifyFulfillment(receipt.getReceiptId(), FulfillmentResult.FULFILLED);
                return;
            }
            Log.v(TAG, "Revoked Sku:" + receipt.getSku());
        } else if (i == 3 || i == 4) {
            Log.v(TAG, "Failed purchase for request " + purchaseResponse.getRequestId());
            AmazonPurchaseWrapper.itemFailed(purchaseResponse.getRequestId());
        } else if (i == 5) {
            Log.v(TAG, "Invalid Sku for request " + purchaseResponse.getRequestId());
        }
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        Log.v(TAG, "onPurchaseUpdatesResponse received");
        Log.v(TAG, "RequestStatus:" + purchaseUpdatesResponse.getRequestStatus());
        if (C27041.f5601xe10c5bef[purchaseUpdatesResponse.getRequestStatus().ordinal()] == 1) {
            for (Receipt next : purchaseUpdatesResponse.getReceipts()) {
                if (!next.isCanceled()) {
                    Log.v(TAG, "Updating bought item: " + next.getSku());
                    AmazonPurchaseWrapper.itemBought(next);
                    PurchasingService.notifyFulfillment(next.getReceiptId(), FulfillmentResult.FULFILLED);
                } else {
                    Log.v(TAG, "Updating revoked Sku:" + next.getSku());
                }
            }
            if (purchaseUpdatesResponse.hasMore()) {
                Log.v(TAG, "Initiating Another Purchase Updates");
                PurchasingService.getPurchaseUpdates(false);
            }
        }
    }

    /* renamed from: com.noodlecake.iap.AmazonPurchasingObserver$1 */
    static /* synthetic */ class C27041 {

        /* renamed from: $SwitchMap$com$amazon$device$iap$model$ProductDataResponse$RequestStatus */
        static final /* synthetic */ int[] f5599x4eb80c9f;

        /* renamed from: $SwitchMap$com$amazon$device$iap$model$PurchaseResponse$RequestStatus */
        static final /* synthetic */ int[] f5600xc71ab397;

        /* renamed from: $SwitchMap$com$amazon$device$iap$model$PurchaseUpdatesResponse$RequestStatus */
        static final /* synthetic */ int[] f5601xe10c5bef;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007e */
        static {
            /*
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus[] r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5601xe10c5bef = r0
                r1 = 1
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r2 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5601xe10c5bef     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r3 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5601xe10c5bef     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus[] r3 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5600xc71ab397 = r3
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.ALREADY_PURCHASED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f5600xc71ab397     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f5600xc71ab397     // Catch:{ NoSuchFieldError -> 0x004d }
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r3 = f5600xc71ab397     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r3 = f5600xc71ab397     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r4 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.INVALID_SKU     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                com.amazon.device.iap.model.ProductDataResponse$RequestStatus[] r3 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5599x4eb80c9f = r3
                com.amazon.device.iap.model.ProductDataResponse$RequestStatus r4 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r1 = f5599x4eb80c9f     // Catch:{ NoSuchFieldError -> 0x007e }
                com.amazon.device.iap.model.ProductDataResponse$RequestStatus r3 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x007e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                int[] r0 = f5599x4eb80c9f     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.amazon.device.iap.model.ProductDataResponse$RequestStatus r1 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.iap.AmazonPurchasingObserver.C27041.<clinit>():void");
        }
    }
}
