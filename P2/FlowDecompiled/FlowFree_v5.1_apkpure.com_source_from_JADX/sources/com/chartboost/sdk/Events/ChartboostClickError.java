package com.chartboost.sdk.Events;

public class ChartboostClickError extends ChartboostError {
    public final Code code;

    public enum Code {
        URI_INVALID(0),
        URI_UNRECOGNIZED(1),
        INTERNAL(3);
        
        private final int errorCode;

        private Code(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public ChartboostClickError(Code code2) {
        super(0);
        this.code = code2;
    }
}
