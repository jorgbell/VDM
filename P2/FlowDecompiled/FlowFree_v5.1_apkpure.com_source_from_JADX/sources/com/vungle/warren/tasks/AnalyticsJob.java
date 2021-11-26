package com.vungle.warren.tasks;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vungle.warren.analytics.AdAnalytics;

public class AnalyticsJob implements Job {
    public static final String TAG = "AnalyticsJob";
    private final AdAnalytics adAnalytics;

    public static JobInfo makeJob(int i, String str, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("action_extra", i);
        bundle.putString("extra_body", str);
        bundle.putStringArray("extra_urls", strArr);
        JobInfo jobInfo = new JobInfo(TAG);
        jobInfo.setUpdateCurrent(false);
        jobInfo.setExtras(bundle);
        jobInfo.setReschedulePolicy(2000, 1);
        jobInfo.setRequiredNetworkType(1);
        jobInfo.setPriority(5);
        return jobInfo;
    }

    public AnalyticsJob(AdAnalytics adAnalytics2) {
        this.adAnalytics = adAnalytics2;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        String[] stringArray;
        int i = bundle.getInt("action_extra", -1);
        if (i == 0) {
            this.adAnalytics.mo27243ri(((JsonElement) new Gson().fromJson(bundle.getString("extra_body"), JsonElement.class)).getAsJsonObject());
            return 0;
        } else if (i != 1 || (stringArray = bundle.getStringArray("extra_urls")) == null) {
            return 0;
        } else {
            String[] ping = this.adAnalytics.ping(stringArray);
            if (ping.length == 0) {
                return 0;
            }
            bundle.putStringArray("extra_urls", ping);
            return 2;
        }
    }
}
