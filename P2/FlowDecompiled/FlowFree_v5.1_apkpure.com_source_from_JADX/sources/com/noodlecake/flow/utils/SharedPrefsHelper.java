package com.noodlecake.flow.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {
    private SharedPreferences mPrefs;

    public SharedPrefsHelper(Context context) {
        this.mPrefs = context.getSharedPreferences(context.getPackageName() + ".application_preferences", 0);
    }

    public SharedPreferences getSharedPreferences() {
        return this.mPrefs;
    }

    public void setSharedPref(String str, String str2) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void setSharedPref(String str, Integer num) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putInt(str, num.intValue());
        edit.commit();
    }

    public void setSharedPref(String str, Boolean bool) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.commit();
    }

    public void setSharedPref(String str, Double d) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putFloat(str, Float.valueOf(d.toString()).floatValue());
        edit.commit();
    }

    public void setSharedPref(String str, Long l) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putLong(str, l.longValue());
        edit.commit();
    }

    public void removeSharedPref(String str) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.remove(str);
        edit.commit();
    }

    public String getStringPref(String str) {
        return this.mPrefs.getString(str, (String) null);
    }

    public Boolean getBoolPref(String str) {
        return Boolean.valueOf(this.mPrefs.getBoolean(str, false));
    }

    public Integer getIntPref(String str) {
        return Integer.valueOf(this.mPrefs.getInt(str, 0));
    }

    public Double getDoublePref(String str) {
        return Double.valueOf((double) this.mPrefs.getFloat(str, 0.0f));
    }

    public Long getLongPref(String str) {
        return Long.valueOf(this.mPrefs.getLong(str, 0));
    }
}
