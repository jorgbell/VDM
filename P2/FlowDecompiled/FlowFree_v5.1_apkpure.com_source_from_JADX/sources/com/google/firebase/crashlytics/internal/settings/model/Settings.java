package com.google.firebase.crashlytics.internal.settings.model;

public interface Settings {
    FeaturesSettingsData getFeaturesData();

    SessionSettingsData getSessionData();
}
