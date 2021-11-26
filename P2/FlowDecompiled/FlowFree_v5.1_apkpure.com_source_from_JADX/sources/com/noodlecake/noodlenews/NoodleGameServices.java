package com.noodlecake.noodlenews;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.noodlecake.flow.utils.FirebaseHelper;

public class NoodleGameServices {
    public static String[] getAchievements() {
        return new String[0];
    }

    public static boolean isAuthenticated() {
        return false;
    }

    public static boolean isSupported() {
        return false;
    }

    public static void loadAchievements() {
    }

    public static void showAchievements() {
    }

    public static void updateProgress(String str, float f) {
    }

    public void initialize(Activity activity) {
    }

    public void release() {
    }

    public NoodleGameServices(Activity activity) {
        FirebaseHelper.init(FirebaseAnalytics.getInstance(activity));
    }
}
