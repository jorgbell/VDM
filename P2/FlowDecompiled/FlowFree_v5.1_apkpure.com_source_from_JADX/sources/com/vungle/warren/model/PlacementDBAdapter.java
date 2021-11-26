package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.AdConfig;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;

public class PlacementDBAdapter implements DBAdapter<Placement> {
    public String tableName() {
        return "placement";
    }

    public ContentValues toContentValues(Placement placement) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", placement.identifier);
        contentValues.put("incentivized", Boolean.valueOf(placement.incentivized));
        contentValues.put("header_bidding", Boolean.valueOf(placement.headerBidding));
        contentValues.put("auto_cached", Boolean.valueOf(placement.autoCached));
        contentValues.put("wakeup_time", Long.valueOf(placement.wakeupTime));
        contentValues.put("is_valid", Boolean.valueOf(placement.isValid));
        contentValues.put("refresh_duration", Integer.valueOf(placement.adRefreshDuration));
        contentValues.put("supported_template_types", Integer.valueOf(placement.placementAdType));
        contentValues.put("ad_size", placement.getAdSize().getName());
        contentValues.put("autocache_priority", Integer.valueOf(placement.autoCachePriority));
        return contentValues;
    }

    public Placement fromContentValues(ContentValues contentValues) {
        Placement placement = new Placement();
        placement.identifier = contentValues.getAsString("item_id");
        placement.wakeupTime = contentValues.getAsLong("wakeup_time").longValue();
        placement.incentivized = ContentValuesUtil.getBoolean(contentValues, "incentivized");
        placement.headerBidding = ContentValuesUtil.getBoolean(contentValues, "header_bidding");
        placement.autoCached = ContentValuesUtil.getBoolean(contentValues, "auto_cached");
        placement.isValid = ContentValuesUtil.getBoolean(contentValues, "is_valid");
        placement.adRefreshDuration = contentValues.getAsInteger("refresh_duration").intValue();
        placement.placementAdType = contentValues.getAsInteger("supported_template_types").intValue();
        placement.adSize = AdConfig.AdSize.fromName(contentValues.getAsString("ad_size"));
        placement.autoCachePriority = contentValues.getAsInteger("autocache_priority").intValue();
        return placement;
    }
}
