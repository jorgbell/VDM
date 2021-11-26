package com.unity3d.services.monetization.placementcontent.purchasing;

import com.applovin.sdk.AppLovinEventTypes;
import com.unity3d.services.monetization.placementcontent.purchasing.Item;
import com.unity3d.services.monetization.placementcontent.purchasing.PromoMetadata;
import com.unity3d.services.purchasing.core.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PromoMetadataUtilities {
    public static PromoMetadata createPromoMetadataFromParamsMap(Map<String, Object> map) {
        PromoMetadata.Builder newBuilder = PromoMetadata.newBuilder();
        if (map.containsKey("impressionDate")) {
            newBuilder.withImpressionDate(new Date(((Long) map.get("impressionDate")).longValue()));
        }
        if (map.containsKey("offerDuration")) {
            newBuilder.withOfferDuration(Long.valueOf(map.get("offerDuration").toString()).longValue());
        }
        if (map.containsKey("costs")) {
            newBuilder.withCosts(getItemListFromList((List) map.get("costs")));
        }
        if (map.containsKey("payouts")) {
            newBuilder.withPayouts(getItemListFromList((List) map.get("payouts")));
        }
        if (map.containsKey(AppLovinEventTypes.USER_VIEWED_PRODUCT)) {
            newBuilder.withPremiumProduct(createProductFromMap((Map) map.get(AppLovinEventTypes.USER_VIEWED_PRODUCT)));
        }
        if (map.containsKey("userInfo")) {
            newBuilder.withCustomInfo((Map) map.get("userInfo"));
        }
        return newBuilder.build();
    }

    private static List<Item> getItemListFromList(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Map<String, Object> createItemFromMap : list) {
            arrayList.add(createItemFromMap(createItemFromMap));
        }
        return arrayList;
    }

    private static Item createItemFromMap(Map<String, Object> map) {
        Item.Builder newBuilder = Item.newBuilder();
        if (map.containsKey("itemId")) {
            newBuilder.withItemId((String) map.get("itemId"));
        }
        if (map.containsKey("quantity")) {
            newBuilder.withQuantity(((Number) map.get("quantity")).longValue());
        }
        if (map.containsKey("type")) {
            newBuilder.withType((String) map.get("type"));
        }
        return newBuilder.build();
    }

    private static Product createProductFromMap(Map<String, Object> map) {
        Product.Builder newBuilder = Product.newBuilder();
        if (map.containsKey("productId")) {
            newBuilder.withProductId((String) map.get("productId"));
        }
        if (map.containsKey("isoCurrencyCode")) {
            newBuilder.withIsoCurrencyCode((String) map.get("isoCurrencyCode"));
        }
        if (map.containsKey("localizedPriceString")) {
            newBuilder.withLocalizedPriceString((String) map.get("localizedPriceString"));
        }
        if (map.containsKey("localizedDescription")) {
            newBuilder.withLocalizedDescription((String) map.get("localizedDescription"));
        }
        if (map.containsKey("localizedTitle")) {
            newBuilder.withLocalizedTitle((String) map.get("localizedTitle"));
        }
        if (map.containsKey("localizedPrice")) {
            newBuilder.withLocalizedPrice(new Double(map.get("localizedPrice").toString()).doubleValue());
        }
        if (map.containsKey("productType")) {
            newBuilder.withProductType((String) map.get("productType"));
        }
        return newBuilder.build();
    }
}
