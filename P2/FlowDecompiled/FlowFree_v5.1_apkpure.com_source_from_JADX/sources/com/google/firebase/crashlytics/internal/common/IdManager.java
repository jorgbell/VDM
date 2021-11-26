package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final InstallerPackageNameProvider installerPackageNameProvider;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi2) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.appContext = context;
            this.appIdentifier = str;
            this.firebaseInstallationsApi = firebaseInstallationsApi2;
            this.installerPackageNameProvider = new InstallerPackageNameProvider();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private static String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public synchronized String getCrashlyticsInstallId() {
        String str;
        String str2 = this.crashlyticsInstallId;
        if (str2 != null) {
            return str2;
        }
        Logger.getLogger().mo22337v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        Task<String> id = this.firebaseInstallationsApi.getId();
        String string = sharedPrefs.getString("firebase.installation.id", (String) null);
        try {
            str = (String) Utils.awaitEvenIfOnMainThread(id);
        } catch (Exception e) {
            Logger.getLogger().mo22340w("Failed to retrieve Firebase Installations ID.", e);
            str = string != null ? string : null;
        }
        if (string == null) {
            Logger.getLogger().mo22337v("No cached Firebase Installations ID found.");
            SharedPreferences legacySharedPrefs = CommonUtils.getLegacySharedPrefs(this.appContext);
            String string2 = legacySharedPrefs.getString("crashlytics.installation.id", (String) null);
            if (string2 == null) {
                Logger.getLogger().mo22337v("No legacy Crashlytics installation ID found, creating new ID.");
                this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
            } else {
                Logger.getLogger().mo22337v("A legacy Crashlytics installation ID was found. Upgrading.");
                this.crashlyticsInstallId = string2;
                migrateLegacyId(string2, str, sharedPrefs, legacySharedPrefs);
            }
        } else if (string.equals(str)) {
            this.crashlyticsInstallId = sharedPrefs.getString("crashlytics.installation.id", (String) null);
            Logger.getLogger().mo22337v("Firebase Installations ID is unchanged from previous startup.");
            if (this.crashlyticsInstallId == null) {
                Logger.getLogger().mo22337v("Crashlytics installation ID was null, creating new ID.");
                this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
            }
        } else {
            this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
        }
        Logger logger = Logger.getLogger();
        logger.mo22337v("Crashlytics installation ID is " + this.crashlyticsInstallId);
        return this.crashlyticsInstallId;
    }

    private synchronized void migrateLegacyId(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger logger = Logger.getLogger();
        logger.mo22337v("Migrating legacy Crashlytics installation ID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    private synchronized String createAndStoreIid(String str, SharedPreferences sharedPreferences) {
        String formatId;
        formatId = formatId(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.mo22337v("Created new Crashlytics installation ID: " + formatId);
        sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString("firebase.installation.id", str).apply();
        return formatId;
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", new Object[]{removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL)});
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }
}
