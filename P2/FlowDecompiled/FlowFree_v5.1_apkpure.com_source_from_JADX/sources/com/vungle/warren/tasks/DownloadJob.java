package com.vungle.warren.tasks;

import android.os.Bundle;
import com.vungle.warren.AdLoader;
import com.vungle.warren.VungleStaticApi;
import java.util.Collection;

public class DownloadJob implements Job {
    static final String TAG = "com.vungle.warren.tasks.DownloadJob";
    private final AdLoader adLoader;
    private final VungleStaticApi vungleApi;

    public DownloadJob(AdLoader adLoader2, VungleStaticApi vungleStaticApi) {
        this.adLoader = adLoader2;
        this.vungleApi = vungleStaticApi;
    }

    public static JobInfo makeJobInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("placement", str);
        JobInfo jobInfo = new JobInfo(TAG + " " + str);
        jobInfo.setUpdateCurrent(true);
        jobInfo.setExtras(bundle);
        jobInfo.setPriority(4);
        return jobInfo;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        String string = bundle.getString("placement", (String) null);
        Collection<String> validPlacements = this.vungleApi.getValidPlacements();
        if (string == null || !validPlacements.contains(string)) {
            return 1;
        }
        this.adLoader.loadPendingInternal(string);
        return 0;
    }
}
