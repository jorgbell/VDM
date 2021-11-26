package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.util.C0531d;
import org.json.JSONException;
import org.json.JSONObject;

public final class UserDataResponse {
    private static final String REQUEST_ID = "REQUEST_ID";
    private static final String REQUEST_STATUS = "REQUEST_STATUS";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\")";
    private static final String USER_DATA = "USER_DATA";
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final UserData userData;

    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        NOT_SUPPORTED
    }

    public UserDataResponse(UserDataResponseBuilder userDataResponseBuilder) {
        C0531d.m183a((Object) userDataResponseBuilder.getRequestId(), "requestId");
        C0531d.m183a((Object) userDataResponseBuilder.getRequestStatus(), "requestStatus");
        this.requestId = userDataResponseBuilder.getRequestId();
        this.requestStatus = userDataResponseBuilder.getRequestStatus();
        this.userData = userDataResponseBuilder.getUserData();
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = super.toString();
        objArr[1] = this.requestId;
        RequestStatus requestStatus2 = this.requestStatus;
        String str = "null";
        objArr[2] = requestStatus2 != null ? requestStatus2.toString() : str;
        UserData userData2 = this.userData;
        if (userData2 != null) {
            str = userData2.toString();
        }
        objArr[3] = str;
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REQUEST_ID, this.requestId);
        jSONObject.put(REQUEST_STATUS, this.requestStatus);
        UserData userData2 = this.userData;
        jSONObject.put(USER_DATA, userData2 != null ? userData2.toJSON() : "");
        return jSONObject;
    }
}
