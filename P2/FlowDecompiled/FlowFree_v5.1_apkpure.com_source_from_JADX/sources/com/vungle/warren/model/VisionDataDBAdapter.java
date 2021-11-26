package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.persistence.DBAdapter;

public class VisionDataDBAdapter implements DBAdapter<VisionData> {
    public String tableName() {
        return "vision_data";
    }

    public ContentValues toContentValues(VisionData visionData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(visionData.timestamp));
        contentValues.put("creative", visionData.creative);
        contentValues.put("campaign", visionData.campaign);
        contentValues.put("advertiser", visionData.advertiser);
        return contentValues;
    }

    public VisionData fromContentValues(ContentValues contentValues) {
        return new VisionData(contentValues.getAsLong("timestamp").longValue(), contentValues.getAsString("creative"), contentValues.getAsString("campaign"), contentValues.getAsString("advertiser"));
    }
}
