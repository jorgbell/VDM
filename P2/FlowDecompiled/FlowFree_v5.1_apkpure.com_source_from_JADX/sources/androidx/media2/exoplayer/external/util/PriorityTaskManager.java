package androidx.media2.exoplayer.external.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority = Integer.MIN_VALUE;
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

    public static class PriorityTooLowException extends IOException {
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i));
            this.highestPriority = Math.max(this.highestPriority, i);
        }
    }

    public void remove(int i) {
        int i2;
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i));
            if (this.queue.isEmpty()) {
                i2 = Integer.MIN_VALUE;
            } else {
                Integer peek = this.queue.peek();
                Util.castNonNull(peek);
                i2 = peek.intValue();
            }
            this.highestPriority = i2;
            this.lock.notifyAll();
        }
    }
}
