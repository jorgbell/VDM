package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@AutoValue
public abstract class BatchedLogRequest {
    public abstract List<LogRequest> getLogRequests();

    public static BatchedLogRequest create(List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    public static DataEncoder createDataEncoder() {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        jsonDataEncoderBuilder.configureWith(AutoBatchedLogRequestEncoder.CONFIG);
        jsonDataEncoderBuilder.ignoreNullValues(true);
        return jsonDataEncoderBuilder.build();
    }
}
