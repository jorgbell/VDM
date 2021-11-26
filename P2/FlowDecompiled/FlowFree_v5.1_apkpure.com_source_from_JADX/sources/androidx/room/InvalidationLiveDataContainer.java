package androidx.room;

import java.util.Collections;
import java.util.IdentityHashMap;

class InvalidationLiveDataContainer {
    InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        Collections.newSetFromMap(new IdentityHashMap());
    }
}
