package com.google.firebase.installations.local;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

@AutoValue
public abstract class PersistedInstallationEntry {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract PersistedInstallationEntry build();

        public abstract Builder setAuthToken(String str);

        public abstract Builder setExpiresInSecs(long j);

        public abstract Builder setFirebaseInstallationId(String str);

        public abstract Builder setFisError(String str);

        public abstract Builder setRefreshToken(String str);

        public abstract Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus);

        public abstract Builder setTokenCreationEpochInSecs(long j);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public abstract Builder toBuilder();

    static {
        builder().build();
    }

    public boolean isRegistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean isErrored() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isUnregistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean isNotGenerated() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean shouldAttemptMigration() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public PersistedInstallationEntry withUnregisteredFid(String str) {
        Builder builder = toBuilder();
        builder.setFirebaseInstallationId(str);
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED);
        return builder.build();
    }

    public PersistedInstallationEntry withRegisteredFid(String str, String str2, long j, String str3, long j2) {
        Builder builder = toBuilder();
        builder.setFirebaseInstallationId(str);
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED);
        builder.setAuthToken(str3);
        builder.setRefreshToken(str2);
        builder.setExpiresInSecs(j2);
        builder.setTokenCreationEpochInSecs(j);
        return builder.build();
    }

    public PersistedInstallationEntry withFisError(String str) {
        Builder builder = toBuilder();
        builder.setFisError(str);
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
        return builder.build();
    }

    public PersistedInstallationEntry withNoGeneratedFid() {
        Builder builder = toBuilder();
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED);
        return builder.build();
    }

    public PersistedInstallationEntry withAuthToken(String str, long j, long j2) {
        Builder builder = toBuilder();
        builder.setAuthToken(str);
        builder.setExpiresInSecs(j);
        builder.setTokenCreationEpochInSecs(j2);
        return builder.build();
    }

    public PersistedInstallationEntry withClearedAuthToken() {
        Builder builder = toBuilder();
        builder.setAuthToken((String) null);
        return builder.build();
    }

    public static Builder builder() {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.setTokenCreationEpochInSecs(0);
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION);
        builder.setExpiresInSecs(0);
        return builder;
    }
}
