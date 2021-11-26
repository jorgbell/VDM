package com.chartboost.sdk.Events;

public class ChartboostShowError extends ChartboostError {
    public final Code code;
    public boolean shouldRetry;

    public enum Code {
        INTERNAL(0),
        SESSION_NOT_STARTED(7),
        AD_ALREADY_VISIBLE(8),
        INTERNET_UNAVAILABLE(25),
        PRESENTATION_FAILURE(33),
        NO_CACHED_AD(34),
        BANNER_DISABLED(36),
        BANNER_VIEW_IS_DETACHED(37);
        
        private final int errorCode;

        private Code(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public ChartboostShowError(Code code2, boolean z) {
        super(2);
        this.code = code2;
        this.shouldRetry = z;
    }
}
