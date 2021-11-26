package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        public abstract Builder setExtras(byte[] bArr);

        public abstract Builder setPriority(Priority priority);
    }

    public abstract String getBackendName();

    public abstract byte[] getExtras();

    public abstract Priority getPriority();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getBackendName();
        objArr[1] = getPriority();
        objArr[2] = getExtras() == null ? "" : Base64.encodeToString(getExtras(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public static Builder builder() {
        AutoValue_TransportContext.Builder builder = new AutoValue_TransportContext.Builder();
        builder.setPriority(Priority.DEFAULT);
        return builder;
    }

    public TransportContext withPriority(Priority priority) {
        Builder builder = builder();
        builder.setBackendName(getBackendName());
        builder.setPriority(priority);
        builder.setExtras(getExtras());
        return builder.build();
    }
}
