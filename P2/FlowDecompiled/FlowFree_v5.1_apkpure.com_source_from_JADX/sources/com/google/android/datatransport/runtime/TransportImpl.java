package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.SendRequest;

final class TransportImpl<T> implements Transport<T> {
    private final String name;
    private final Encoding payloadEncoding;
    private final Transformer<T, byte[]> transformer;
    private final TransportContext transportContext;
    private final TransportInternal transportInternal;

    static /* synthetic */ void lambda$send$0(Exception exc) {
    }

    TransportImpl(TransportContext transportContext2, String str, Encoding encoding, Transformer<T, byte[]> transformer2, TransportInternal transportInternal2) {
        this.transportContext = transportContext2;
        this.name = str;
        this.payloadEncoding = encoding;
        this.transformer = transformer2;
        this.transportInternal = transportInternal2;
    }

    public void send(Event<T> event) {
        schedule(event, TransportImpl$$Lambda$1.lambdaFactory$());
    }

    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal2 = this.transportInternal;
        SendRequest.Builder builder = SendRequest.builder();
        builder.setTransportContext(this.transportContext);
        builder.setEvent(event);
        builder.setTransportName(this.name);
        builder.setTransformer(this.transformer);
        builder.setEncoding(this.payloadEncoding);
        transportInternal2.send(builder.build(), transportScheduleCallback);
    }
}
