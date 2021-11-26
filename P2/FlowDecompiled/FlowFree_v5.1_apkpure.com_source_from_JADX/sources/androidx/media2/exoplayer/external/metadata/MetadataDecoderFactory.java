package androidx.media2.exoplayer.external.metadata;

import androidx.media2.exoplayer.external.Format;

public interface MetadataDecoderFactory {
    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
