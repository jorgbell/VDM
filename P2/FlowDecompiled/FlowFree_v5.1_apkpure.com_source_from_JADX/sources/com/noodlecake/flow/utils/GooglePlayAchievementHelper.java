package com.noodlecake.flow.utils;

import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.Games;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import java.util.Vector;

public class GooglePlayAchievementHelper {
    private static String TAG = "GooglePlayAchievementHelper";
    private static Vector<String> submitted;

    public static void init() {
        submitted = new Vector<>();
    }

    public static void showAchievements() {
        NoodlecakeGameActivity.showAchievements();
    }

    public static void submitAchievement(String str) {
        if (NoodlecakeGameActivity.isGoogleAPIConnected() && !submitted.contains(str)) {
            String stringResource = NoodlecakeGameActivity.getStringResource(str);
            submitted.add(str);
            if (stringResource != null) {
                Games.getAchievementsClient(NoodlecakeGameActivity.getContext(), GoogleSignIn.getLastSignedInAccount(NoodlecakeGameActivity.getContext())).unlock(stringResource);
                return;
            }
            String str2 = TAG;
            Log.e(str2, "Could not find achievement " + str);
        }
    }
}
