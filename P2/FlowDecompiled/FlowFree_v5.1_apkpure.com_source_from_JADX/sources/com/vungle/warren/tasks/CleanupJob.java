package com.vungle.warren.tasks;

import android.os.Bundle;
import android.util.Log;
import com.vungle.warren.AdLoader;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class CleanupJob implements Job {
    static final String TAG = "com.vungle.warren.tasks.CleanupJob";
    private final AdLoader adLoader;
    private final Designer designer;
    private final Repository repository;

    CleanupJob(Designer designer2, Repository repository2, AdLoader adLoader2) {
        this.designer = designer2;
        this.repository = repository2;
        this.adLoader = adLoader2;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        Class<Advertisement> cls = Advertisement.class;
        if (this.designer == null || this.repository == null) {
            return 1;
        }
        Log.d(TAG, "CleanupJob: Current directory snapshot");
        FileUtility.printDirectoryTree(this.designer.getCacheDirectory());
        File[] listFiles = this.designer.getCacheDirectory().listFiles();
        List<Placement> list = this.repository.loadAll(Placement.class).get();
        if (list == null || list.size() == 0) {
            return 0;
        }
        Collection collection = this.repository.loadValidPlacements().get();
        HashSet hashSet = new HashSet();
        try {
            for (Placement placement : list) {
                if (collection == null || collection.isEmpty() || collection.contains(placement)) {
                    List<String> list2 = this.repository.findAdsForPlacement(placement.getId()).get();
                    if (list2 != null) {
                        for (String str : list2) {
                            Advertisement advertisement = this.repository.load(str, cls).get();
                            if (advertisement == null) {
                                Log.w(TAG, "removing adv " + str + " from placement " + placement.getId());
                                this.repository.deleteAdvertisement(placement.getId());
                            } else if (advertisement.getExpireTime() > System.currentTimeMillis() || advertisement.getState() == 2) {
                                hashSet.add(advertisement.getId());
                                Log.w(TAG, "setting valid adv " + str + " for placement " + placement.getId());
                            } else {
                                this.repository.deleteAdvertisement(str);
                                if (placement.isAutoCached()) {
                                    this.adLoader.loadEndless(placement, 1000);
                                }
                            }
                        }
                    }
                } else {
                    Log.d(TAG, String.format(Locale.ENGLISH, "Placement %s is no longer valid, deleting it and its advertisement", new Object[]{placement.getId()}));
                    this.repository.delete(placement);
                }
            }
            List<Advertisement> list3 = this.repository.loadAll(cls).get();
            if (list3 != null) {
                for (Advertisement advertisement2 : list3) {
                    if (advertisement2.getState() == 2) {
                        hashSet.add(advertisement2.getId());
                        Log.d(TAG, "found adv in viewing state " + advertisement2.getId());
                    } else if (!hashSet.contains(advertisement2.getId())) {
                        Log.e(TAG, "delete ad " + advertisement2.getId());
                        this.repository.deleteAdvertisement(advertisement2.getId());
                    }
                }
            }
            for (File file : listFiles) {
                if (!hashSet.contains(file.getName())) {
                    Log.v(TAG, String.format(Locale.ENGLISH, "Deleting assets under directory %s", new Object[]{file.getName()}));
                    FileUtility.delete(file);
                }
            }
            return 0;
        } catch (DatabaseHelper.DBException unused) {
            return 1;
        } catch (IOException e) {
            Log.e(TAG, "Failed to delete asset directory!", e);
            return 1;
        }
    }

    public static JobInfo makeJobInfo() {
        JobInfo jobInfo = new JobInfo(TAG);
        jobInfo.setPriority(0);
        jobInfo.setUpdateCurrent(true);
        return jobInfo;
    }
}
