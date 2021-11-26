package gnustep.foundation;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.File;
import java.util.Locale;

public class Common {
    private static String apkPath;
    private static String appLabel;
    private static String cacheDir;
    private static String countryString;
    private static String documentsDir;
    private static String languageString;
    private static String packageName;
    private static String versionCode;
    private static String versionName;

    public static void setup(Activity activity) {
        String packageName2 = activity.getApplication().getPackageName();
        packageName = packageName2;
        Log.w("package name", packageName2);
        PackageManager packageManager = activity.getApplication().getPackageManager();
        try {
            String str = packageManager.getApplicationInfo(packageName, 0).sourceDir;
            apkPath = str;
            Log.w("apk path", str);
            File cacheDir2 = activity.getCacheDir();
            if (cacheDir2 != null) {
                String absolutePath = cacheDir2.getAbsolutePath();
                cacheDir = absolutePath;
                Log.w("cache dir", absolutePath);
            }
            File filesDir = activity.getApplicationContext().getFilesDir();
            if (filesDir != null) {
                String absolutePath2 = filesDir.getAbsolutePath();
                documentsDir = absolutePath2;
                Log.w("documents dir", absolutePath2);
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                versionName = packageInfo.versionName;
                versionCode = "" + packageInfo.versionCode;
                appLabel = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (PackageManager.NameNotFoundException e) {
                versionName = "0.0";
                versionCode = "0";
                e.printStackTrace();
            }
            Locale locale = Locale.getDefault();
            if (locale != null) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                if (Locale.SIMPLIFIED_CHINESE.getLanguage().equals(language) && Locale.SIMPLIFIED_CHINESE.getCountry().equals(country)) {
                    languageString = "zh-Hans";
                } else if (Locale.TRADITIONAL_CHINESE.getLanguage().equals(language) && Locale.TRADITIONAL_CHINESE.getCountry().equals(country)) {
                    languageString = "zh-Hant";
                } else if (language == null || language.length() <= 0) {
                    languageString = "en";
                } else {
                    languageString = language;
                }
                countryString = country;
                return;
            }
            languageString = "en";
            countryString = null;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            throw new RuntimeException("Unable to locate assets, aborting...");
        }
    }

    public static String getPackageName() {
        return packageName;
    }

    public static String getPackageDir() {
        return apkPath;
    }

    public static String getAppLabel() {
        return appLabel;
    }

    public static String getVersionName() {
        return versionName;
    }

    public static String getVersionCode() {
        return versionCode;
    }

    public static String getTmpDir() {
        return cacheDir;
    }

    public static String getDocumentsDir() {
        return documentsDir;
    }

    public static String getDefaultLanguageString() {
        return languageString;
    }

    public static String getDefaultCountryString() {
        return countryString;
    }
}
