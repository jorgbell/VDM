package com.google.android.datatransport.runtime.scheduling.persistence;

public abstract class EventStoreModule {
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }
}
