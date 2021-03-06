package androidx.media2.exoplayer.external.extractor.ogg;

import androidx.media2.exoplayer.external.ParserException;
import androidx.media2.exoplayer.external.extractor.ExtractorInput;
import androidx.media2.exoplayer.external.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

final class OggPageHeader {
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces = new int[255];
    public int pageSegmentCount;
    public int revision;
    private final ParsableByteArray scratch = new ParsableByteArray(255);
    public int type;

    OggPageHeader() {
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean populate(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        this.scratch.reset();
        reset();
        if (!(extractorInput.getLength() == -1 || extractorInput.getLength() - extractorInput.getPeekPosition() >= 27) || !extractorInput.peekFully(this.scratch.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.scratch.readUnsignedInt() == 1332176723) {
            int readUnsignedByte = this.scratch.readUnsignedByte();
            this.revision = readUnsignedByte;
            if (readUnsignedByte == 0) {
                this.type = this.scratch.readUnsignedByte();
                this.granulePosition = this.scratch.readLittleEndianLong();
                this.scratch.readLittleEndianUnsignedInt();
                this.scratch.readLittleEndianUnsignedInt();
                this.scratch.readLittleEndianUnsignedInt();
                int readUnsignedByte2 = this.scratch.readUnsignedByte();
                this.pageSegmentCount = readUnsignedByte2;
                this.headerSize = readUnsignedByte2 + 27;
                this.scratch.reset();
                extractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
                for (int i = 0; i < this.pageSegmentCount; i++) {
                    this.laces[i] = this.scratch.readUnsignedByte();
                    this.bodySize += this.laces[i];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }
}
