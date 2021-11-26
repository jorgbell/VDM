package androidx.work;

import android.annotation.SuppressLint;

public interface Operation {
    @SuppressLint({"SyntheticAccessor"})
    public static final State.IN_PROGRESS IN_PROGRESS = new State.IN_PROGRESS();
    @SuppressLint({"SyntheticAccessor"})
    public static final State.SUCCESS SUCCESS = new State.SUCCESS();

    public static abstract class State {
        State() {
        }

        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }

        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public FAILURE(Throwable th) {
                this.mThrowable = th;
            }

            public Throwable getThrowable() {
                return this.mThrowable;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.mThrowable.getMessage()});
            }
        }
    }
}
