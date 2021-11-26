package com.vungle.warren.model;

import android.content.ContentValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mopub.mobileads.UnityRouter;
import com.unity3d.ads.metadata.MediationMetaData;
import com.vungle.warren.model.Report;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReportDBAdapter implements DBAdapter<Report> {
    private Gson gson = new GsonBuilder().create();
    Type stringType = new TypeToken<ArrayList<String>>(this) {
    }.getType();
    Type userActionsType = new TypeToken<ArrayList<Report.UserAction>>(this) {
    }.getType();

    public String tableName() {
        return "report";
    }

    public ContentValues toContentValues(Report report) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", report.getId());
        contentValues.put("ad_duration", Long.valueOf(report.adDuration));
        contentValues.put("adStartTime", Long.valueOf(report.adStartTime));
        contentValues.put("adToken", report.adToken);
        contentValues.put("ad_type", report.adType);
        contentValues.put("appId", report.appId);
        contentValues.put("campaign", report.campaign);
        contentValues.put("incentivized", Boolean.valueOf(report.incentivized));
        contentValues.put("header_bidding", Boolean.valueOf(report.headerBidding));
        contentValues.put(MediationMetaData.KEY_ORDINAL, Integer.valueOf(report.ordinal));
        contentValues.put(UnityRouter.PLACEMENT_ID_KEY, report.placementId);
        contentValues.put("template_id", report.templateId);
        contentValues.put("tt_download", Long.valueOf(report.ttDownload));
        contentValues.put("url", report.url);
        contentValues.put("user_id", report.userID);
        contentValues.put("videoLength", Long.valueOf(report.videoLength));
        contentValues.put("videoViewed", Integer.valueOf(report.videoViewed));
        contentValues.put("was_CTAC_licked", Boolean.valueOf(report.wasCTAClicked));
        contentValues.put("user_actions", this.gson.toJson((Object) new ArrayList(report.userActions), this.userActionsType));
        contentValues.put("clicked_through", this.gson.toJson((Object) new ArrayList(report.clickedThrough), this.stringType));
        contentValues.put("errors", this.gson.toJson((Object) new ArrayList(report.errors), this.stringType));
        contentValues.put("status", Integer.valueOf(report.status));
        contentValues.put("ad_size", report.adSize);
        contentValues.put("init_timestamp", Long.valueOf(report.initTimeStamp));
        contentValues.put("asset_download_duration", Long.valueOf(report.assetDownloadDuration));
        return contentValues;
    }

    public Report fromContentValues(ContentValues contentValues) {
        Report report = new Report();
        report.adDuration = contentValues.getAsLong("ad_duration").longValue();
        report.adStartTime = contentValues.getAsLong("adStartTime").longValue();
        report.adToken = contentValues.getAsString("adToken");
        report.adType = contentValues.getAsString("ad_type");
        report.appId = contentValues.getAsString("appId");
        report.campaign = contentValues.getAsString("campaign");
        report.ordinal = contentValues.getAsInteger(MediationMetaData.KEY_ORDINAL).intValue();
        report.placementId = contentValues.getAsString(UnityRouter.PLACEMENT_ID_KEY);
        report.templateId = contentValues.getAsString("template_id");
        report.ttDownload = contentValues.getAsLong("tt_download").longValue();
        report.url = contentValues.getAsString("url");
        report.userID = contentValues.getAsString("user_id");
        report.videoLength = contentValues.getAsLong("videoLength").longValue();
        report.videoViewed = contentValues.getAsInteger("videoViewed").intValue();
        report.wasCTAClicked = ContentValuesUtil.getBoolean(contentValues, "was_CTAC_licked");
        report.incentivized = ContentValuesUtil.getBoolean(contentValues, "incentivized");
        report.headerBidding = ContentValuesUtil.getBoolean(contentValues, "header_bidding");
        report.status = contentValues.getAsInteger("status").intValue();
        report.adSize = contentValues.getAsString("ad_size");
        report.initTimeStamp = contentValues.getAsLong("init_timestamp").longValue();
        report.assetDownloadDuration = contentValues.getAsLong("asset_download_duration").longValue();
        List list = (List) this.gson.fromJson(contentValues.getAsString("clicked_through"), this.stringType);
        List list2 = (List) this.gson.fromJson(contentValues.getAsString("errors"), this.stringType);
        List list3 = (List) this.gson.fromJson(contentValues.getAsString("user_actions"), this.userActionsType);
        if (list != null) {
            report.clickedThrough.addAll(list);
        }
        if (list2 != null) {
            report.errors.addAll(list2);
        }
        if (list3 != null) {
            report.userActions.addAll(list3);
        }
        return report;
    }
}
