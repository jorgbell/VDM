package com.amazon.device.iap.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.util.C0531d;
import org.json.JSONException;
import org.json.JSONObject;

public final class Product implements Parcelable {
    private static final String COINS_REWARD_AMOUNT = "coinsRewardAmount";
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        public Product[] newArray(int i) {
            return new Product[i];
        }
    };
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String PRODUCT_TYPE = "productType";
    private static final String SKU = "sku";
    private static final String SMALL_ICON_URL = "smallIconUrl";
    private static final String TITLE = "title";
    private final CoinsReward coinsReward;
    private final String description;
    private final String price;
    private final ProductType productType;
    private final String sku;
    private final String smallIconUrl;
    private final String title;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sku);
        parcel.writeString(this.productType.toString());
        parcel.writeString(this.description);
        parcel.writeString(this.price);
        parcel.writeString(this.smallIconUrl);
        parcel.writeString(this.title);
        parcel.writeInt(getCoinsRewardAmount());
    }

    private Product(Parcel parcel) {
        this.sku = parcel.readString();
        this.productType = ProductType.valueOf(parcel.readString());
        this.description = parcel.readString();
        this.price = parcel.readString();
        this.smallIconUrl = parcel.readString();
        this.title = parcel.readString();
        this.coinsReward = CoinsReward.from(parcel.dataAvail() > 0 ? parcel.readInt() : 0);
    }

    public Product(ProductBuilder productBuilder) {
        C0531d.m183a((Object) productBuilder.getSku(), "sku");
        C0531d.m183a((Object) productBuilder.getProductType(), PRODUCT_TYPE);
        C0531d.m183a((Object) productBuilder.getDescription(), DESCRIPTION);
        C0531d.m183a((Object) productBuilder.getTitle(), TITLE);
        C0531d.m183a((Object) productBuilder.getSmallIconUrl(), SMALL_ICON_URL);
        if (ProductType.SUBSCRIPTION != productBuilder.getProductType()) {
            C0531d.m183a((Object) productBuilder.getPrice(), "price");
        }
        this.sku = productBuilder.getSku();
        this.productType = productBuilder.getProductType();
        this.description = productBuilder.getDescription();
        this.price = productBuilder.getPrice();
        this.smallIconUrl = productBuilder.getSmallIconUrl();
        this.title = productBuilder.getTitle();
        this.coinsReward = CoinsReward.from(productBuilder.getCoinsRewardAmount());
    }

    public String getSku() {
        return this.sku;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSmallIconUrl() {
        return this.smallIconUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public CoinsReward getCoinsReward() {
        return this.coinsReward;
    }

    private int getCoinsRewardAmount() {
        CoinsReward coinsReward2 = this.coinsReward;
        if (coinsReward2 == null) {
            return 0;
        }
        return coinsReward2.getAmount();
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sku", this.sku);
        jSONObject.put(PRODUCT_TYPE, this.productType);
        jSONObject.put(DESCRIPTION, this.description);
        jSONObject.put("price", this.price);
        jSONObject.put(SMALL_ICON_URL, this.smallIconUrl);
        jSONObject.put(TITLE, this.title);
        jSONObject.put(COINS_REWARD_AMOUNT, getCoinsRewardAmount());
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }
}
