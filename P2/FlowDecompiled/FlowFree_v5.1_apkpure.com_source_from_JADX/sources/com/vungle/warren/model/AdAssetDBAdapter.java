package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.persistence.DBAdapter;

public class AdAssetDBAdapter implements DBAdapter<AdAsset> {
    public String tableName() {
        return "adAsset";
    }

    public ContentValues toContentValues(AdAsset adAsset) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", adAsset.identifier);
        contentValues.put("ad_identifier", adAsset.adIdentifier);
        contentValues.put("paren_id", adAsset.parentId);
        contentValues.put("server_path", adAsset.serverPath);
        contentValues.put("local_path", adAsset.localPath);
        contentValues.put("file_status", Integer.valueOf(adAsset.status));
        contentValues.put("file_type", Integer.valueOf(adAsset.fileType));
        contentValues.put("file_size", Long.valueOf(adAsset.fileSize));
        contentValues.put("retry_count", Integer.valueOf(adAsset.retryCount));
        contentValues.put("retry_error", Integer.valueOf(adAsset.retryTypeError));
        return contentValues;
    }

    public AdAsset fromContentValues(ContentValues contentValues) {
        AdAsset adAsset = new AdAsset(contentValues.getAsString("ad_identifier"), contentValues.getAsString("server_path"), contentValues.getAsString("local_path"), contentValues.getAsString("item_id"));
        adAsset.status = contentValues.getAsInteger("file_status").intValue();
        adAsset.fileType = contentValues.getAsInteger("file_type").intValue();
        adAsset.fileSize = (long) contentValues.getAsInteger("file_size").intValue();
        adAsset.retryCount = contentValues.getAsInteger("retry_count").intValue();
        adAsset.retryTypeError = contentValues.getAsInteger("retry_error").intValue();
        adAsset.parentId = contentValues.getAsString("paren_id");
        return adAsset;
    }
}
