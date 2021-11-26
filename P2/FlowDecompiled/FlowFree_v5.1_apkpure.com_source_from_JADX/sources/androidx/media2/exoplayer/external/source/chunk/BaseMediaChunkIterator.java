package androidx.media2.exoplayer.external.source.chunk;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private final long fromIndex;

    public void reset() {
    }

    public BaseMediaChunkIterator(long j, long j2) {
        this.fromIndex = j;
        reset();
    }
}
