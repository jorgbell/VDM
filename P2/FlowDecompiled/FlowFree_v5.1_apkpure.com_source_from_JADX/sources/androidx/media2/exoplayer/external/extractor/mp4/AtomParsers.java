package androidx.media2.exoplayer.external.extractor.mp4;

import android.util.Pair;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.ParserException;
import androidx.media2.exoplayer.external.drm.DrmInitData;
import androidx.media2.exoplayer.external.extractor.mp4.Atom;
import androidx.media2.exoplayer.external.metadata.Metadata;
import androidx.media2.exoplayer.external.util.Assertions;
import androidx.media2.exoplayer.external.util.Log;
import androidx.media2.exoplayer.external.util.MimeTypes;
import androidx.media2.exoplayer.external.util.ParsableByteArray;
import androidx.media2.exoplayer.external.util.Util;
import androidx.media2.exoplayer.external.video.AvcConfig;
import androidx.media2.exoplayer.external.video.ColorInfo;
import androidx.media2.exoplayer.external.video.DolbyVisionConfig;
import androidx.media2.exoplayer.external.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 4 : -1;
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(1835297121);
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(containerAtomOfType.getLeafAtomOfType(1751411826).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(1953196132).data);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j2 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != -9223372036854775807L) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(1835296868).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(1937011556).data, parseTkhd.f10id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (!z) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom2.getContainerAtomOfType(1701082227));
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.f10id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0372  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable parseStbl(androidx.media2.exoplayer.external.extractor.mp4.Track r37, androidx.media2.exoplayer.external.extractor.mp4.Atom.ContainerAtom r38, androidx.media2.exoplayer.external.extractor.GaplessInfoHolder r39) throws androidx.media2.exoplayer.external.ParserException {
        /*
            r1 = r37
            r0 = r38
            r2 = r39
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0015
            androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$StszSampleSizeBox r4 = new androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$StszSampleSizeBox
            r4.<init>(r3)
            goto L_0x0023
        L_0x0015:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x04d5
            androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$Stz2SampleSizeBox r4 = new androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r4.<init>(r3)
        L_0x0023:
            int r3 = r4.getSampleCount()
            r5 = 0
            if (r3 != 0) goto L_0x0044
            androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable r9 = new androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            r4 = 0
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r9
            r1 = r37
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0044:
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x0057
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r8 = 1
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            androidx.media2.exoplayer.external.util.ParsableByteArray r6 = r6.data
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            androidx.media2.exoplayer.external.util.ParsableByteArray r9 = r9.data
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            androidx.media2.exoplayer.external.util.ParsableByteArray r10 = r10.data
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0079
            androidx.media2.exoplayer.external.util.ParsableByteArray r11 = r11.data
            goto L_0x007a
        L_0x0079:
            r11 = r12
        L_0x007a:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            androidx.media2.exoplayer.external.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0086
            androidx.media2.exoplayer.external.util.ParsableByteArray r0 = r0.data
            goto L_0x0087
        L_0x0086:
            r0 = r12
        L_0x0087:
            androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$ChunkIterator r13 = new androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x00a8
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x00a9
        L_0x00a8:
            r15 = 0
        L_0x00a9:
            r16 = -1
            if (r11 == 0) goto L_0x00be
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00c0
            int r12 = r11.readUnsignedIntToInt()
            int r16 = r12 + -1
            r12 = r11
            goto L_0x00c0
        L_0x00be:
            r12 = r11
            r6 = 0
        L_0x00c0:
            boolean r11 = r4.isFixedSampleSize()
            if (r11 == 0) goto L_0x00da
            androidx.media2.exoplayer.external.Format r11 = r1.format
            java.lang.String r11 = r11.sampleMimeType
            java.lang.String r5 = "audio/raw"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x00da
            if (r8 != 0) goto L_0x00da
            if (r15 != 0) goto L_0x00da
            if (r6 != 0) goto L_0x00da
            r5 = 1
            goto L_0x00db
        L_0x00da:
            r5 = 0
        L_0x00db:
            r18 = 0
            if (r5 != 0) goto L_0x024e
            long[] r5 = new long[r3]
            int[] r11 = new int[r3]
            long[] r7 = new long[r3]
            r38 = r6
            int[] r6 = new int[r3]
            r23 = r10
            r2 = r16
            r25 = r18
            r27 = r25
            r1 = 0
            r10 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r16 = r15
            r15 = r14
            r14 = r9
            r36 = r8
            r8 = r38
        L_0x0101:
            r38 = r36
            java.lang.String r9 = "AtomParsers"
            if (r1 >= r3) goto L_0x01c3
            r28 = r27
            r27 = r22
            r22 = 1
        L_0x010d:
            if (r27 != 0) goto L_0x012a
            boolean r22 = r13.moveNext()
            if (r22 == 0) goto L_0x012a
            r30 = r14
            r31 = r15
            long r14 = r13.offset
            r32 = r3
            int r3 = r13.numSamples
            r27 = r3
            r28 = r14
            r14 = r30
            r15 = r31
            r3 = r32
            goto L_0x010d
        L_0x012a:
            r32 = r3
            r30 = r14
            r31 = r15
            if (r22 != 0) goto L_0x014e
            java.lang.String r2 = "Unexpected end of chunk data"
            androidx.media2.exoplayer.external.util.Log.m16w(r9, r2)
            long[] r5 = java.util.Arrays.copyOf(r5, r1)
            int[] r11 = java.util.Arrays.copyOf(r11, r1)
            long[] r7 = java.util.Arrays.copyOf(r7, r1)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            r3 = r1
            r2 = r21
            r1 = r27
            goto L_0x01cb
        L_0x014e:
            if (r0 == 0) goto L_0x0161
        L_0x0150:
            if (r24 != 0) goto L_0x015f
            if (r16 <= 0) goto L_0x015f
            int r24 = r0.readUnsignedIntToInt()
            int r21 = r0.readInt()
            int r16 = r16 + -1
            goto L_0x0150
        L_0x015f:
            int r24 = r24 + -1
        L_0x0161:
            r3 = r21
            r5[r1] = r28
            int r9 = r4.readNextSampleSize()
            r11[r1] = r9
            r9 = r11[r1]
            if (r9 <= r10) goto L_0x0172
            r9 = r11[r1]
            r10 = r9
        L_0x0172:
            long r14 = (long) r3
            long r14 = r25 + r14
            r7[r1] = r14
            if (r12 != 0) goto L_0x017b
            r9 = 1
            goto L_0x017c
        L_0x017b:
            r9 = 0
        L_0x017c:
            r6[r1] = r9
            if (r1 != r2) goto L_0x018c
            r9 = 1
            r6[r1] = r9
            int r8 = r8 + -1
            if (r8 <= 0) goto L_0x018c
            int r2 = r12.readUnsignedIntToInt()
            int r2 = r2 - r9
        L_0x018c:
            r15 = r2
            r9 = r3
            r14 = r31
            long r2 = (long) r14
            long r25 = r25 + r2
            int r2 = r30 + -1
            if (r2 != 0) goto L_0x01a4
            if (r38 <= 0) goto L_0x01a4
            int r2 = r23.readUnsignedIntToInt()
            int r3 = r23.readInt()
            int r14 = r38 + -1
            goto L_0x01a7
        L_0x01a4:
            r3 = r14
            r14 = r38
        L_0x01a7:
            r38 = r2
            r2 = r11[r1]
            r21 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r22 = r27 + -1
            int r1 = r1 + 1
            r27 = r2
            r2 = r15
            r15 = r21
            r3 = r32
            r21 = r9
            r36 = r14
            r14 = r38
            goto L_0x0101
        L_0x01c3:
            r32 = r3
            r30 = r14
            r2 = r21
            r1 = r22
        L_0x01cb:
            long r12 = (long) r2
            long r25 = r25 + r12
        L_0x01ce:
            if (r16 <= 0) goto L_0x01de
            int r2 = r0.readUnsignedIntToInt()
            if (r2 == 0) goto L_0x01d8
            r0 = 0
            goto L_0x01df
        L_0x01d8:
            r0.readInt()
            int r16 = r16 + -1
            goto L_0x01ce
        L_0x01de:
            r0 = 1
        L_0x01df:
            if (r8 != 0) goto L_0x01f1
            if (r30 != 0) goto L_0x01f1
            if (r1 != 0) goto L_0x01f1
            if (r38 != 0) goto L_0x01f1
            r2 = r24
            if (r2 != 0) goto L_0x01f3
            if (r0 != 0) goto L_0x01ee
            goto L_0x01f3
        L_0x01ee:
            r4 = r37
            goto L_0x0247
        L_0x01f1:
            r2 = r24
        L_0x01f3:
            r4 = r37
            int r12 = r4.f11id
            if (r0 != 0) goto L_0x01fc
            java.lang.String r0 = ", ctts invalid"
            goto L_0x01fe
        L_0x01fc:
            java.lang.String r0 = ""
        L_0x01fe:
            int r13 = r0.length()
            int r13 = r13 + 262
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r13)
            java.lang.String r13 = "Inconsistent stbl box for track "
            r14.append(r13)
            r14.append(r12)
            java.lang.String r12 = ": remainingSynchronizationSamples "
            r14.append(r12)
            r14.append(r8)
            java.lang.String r8 = ", remainingSamplesAtTimestampDelta "
            r14.append(r8)
            r8 = r30
            r14.append(r8)
            java.lang.String r8 = ", remainingSamplesInChunk "
            r14.append(r8)
            r14.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r14.append(r1)
            r8 = r38
            r14.append(r8)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r14.append(r1)
            r14.append(r2)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            androidx.media2.exoplayer.external.util.Log.m16w(r9, r0)
        L_0x0247:
            r0 = r3
            r2 = r5
            r5 = r7
            r3 = r11
            r7 = r25
            goto L_0x0288
        L_0x024e:
            r4 = r1
            r32 = r3
            int r0 = r13.length
            long[] r1 = new long[r0]
            int[] r0 = new int[r0]
        L_0x0257:
            boolean r2 = r13.moveNext()
            if (r2 == 0) goto L_0x0268
            int r2 = r13.index
            long r5 = r13.offset
            r1[r2] = r5
            int r3 = r13.numSamples
            r0[r2] = r3
            goto L_0x0257
        L_0x0268:
            androidx.media2.exoplayer.external.Format r2 = r4.format
            int r3 = r2.pcmEncoding
            int r2 = r2.channelCount
            int r2 = androidx.media2.exoplayer.external.util.Util.getPcmFrameSize(r3, r2)
            long r5 = (long) r14
            androidx.media2.exoplayer.external.extractor.mp4.FixedSampleSizeRechunker$Results r0 = androidx.media2.exoplayer.external.extractor.mp4.FixedSampleSizeRechunker.rechunk(r2, r1, r0, r5)
            long[] r1 = r0.offsets
            int[] r2 = r0.sizes
            int r3 = r0.maximumSize
            long[] r5 = r0.timestamps
            int[] r6 = r0.flags
            long r7 = r0.duration
            r10 = r3
            r0 = r32
            r3 = r2
            r2 = r1
        L_0x0288:
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r4.timescale
            r15 = r11
            r11 = r7
            long r11 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r11, r13, r15)
            long[] r1 = r4.editListDurations
            if (r1 == 0) goto L_0x04b5
            boolean r1 = r39.hasGaplessInfo()
            if (r1 == 0) goto L_0x029f
            goto L_0x04b5
        L_0x029f:
            long[] r1 = r4.editListDurations
            int r9 = r1.length
            r11 = 1
            if (r9 != r11) goto L_0x0331
            int r9 = r4.type
            if (r9 != r11) goto L_0x0331
            int r9 = r5.length
            r11 = 2
            if (r9 < r11) goto L_0x0331
            long[] r9 = r4.editListMediaTimes
            r11 = 0
            r15 = r9[r11]
            r21 = r1[r11]
            long r11 = r4.timescale
            long r13 = r4.movieTimescale
            r23 = r11
            r25 = r13
            long r11 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r11 = r11 + r15
            r21 = r5
            r22 = r7
            r24 = r15
            r26 = r11
            boolean r1 = canApplyEditWithGaplessInfo(r21, r22, r24, r26)
            if (r1 == 0) goto L_0x0331
            long r21 = r7 - r11
            r1 = 0
            r11 = r5[r1]
            long r30 = r15 - r11
            androidx.media2.exoplayer.external.Format r1 = r4.format
            int r1 = r1.sampleRate
            long r11 = (long) r1
            long r13 = r4.timescale
            r32 = r11
            r34 = r13
            long r11 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r30, r32, r34)
            androidx.media2.exoplayer.external.Format r1 = r4.format
            int r1 = r1.sampleRate
            long r13 = (long) r1
            r9 = r0
            long r0 = r4.timescale
            r23 = r13
            r25 = r0
            long r0 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r21, r23, r25)
            int r13 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r13 != 0) goto L_0x02fd
            int r13 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r13 == 0) goto L_0x0332
        L_0x02fd:
            r13 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 > 0) goto L_0x0332
            int r15 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r15 > 0) goto L_0x0332
            int r7 = (int) r11
            r8 = r39
            r8.encoderDelay = r7
            int r1 = (int) r0
            r8.encoderPadding = r1
            long r0 = r4.timescale
            r7 = 1000000(0xf4240, double:4.940656E-318)
            androidx.media2.exoplayer.external.util.Util.scaleLargeTimestampsInPlace(r5, r7, r0)
            long[] r0 = r4.editListDurations
            r1 = 0
            r11 = r0[r1]
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.movieTimescale
            r15 = r0
            long r7 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r11, r13, r15)
            androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable r9 = new androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0331:
            r9 = r0
        L_0x0332:
            long[] r0 = r4.editListDurations
            int r1 = r0.length
            r11 = 1
            if (r1 != r11) goto L_0x0372
            r1 = 0
            r11 = r0[r1]
            int r13 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r13 != 0) goto L_0x0372
            long[] r0 = r4.editListMediaTimes
            r11 = r0[r1]
            r0 = 0
        L_0x0344:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x035b
            r13 = r5[r0]
            long r15 = r13 - r11
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r4.timescale
            r19 = r13
            long r13 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r15, r17, r19)
            r5[r0] = r13
            int r0 = r0 + 1
            goto L_0x0344
        L_0x035b:
            long r13 = r7 - r11
            r15 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.timescale
            r17 = r0
            long r7 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r13, r15, r17)
            androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable r9 = new androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0372:
            int r1 = r4.type
            r7 = 1
            if (r1 != r7) goto L_0x0379
            r1 = 1
            goto L_0x037a
        L_0x0379:
            r1 = 0
        L_0x037a:
            int r7 = r0.length
            int[] r7 = new int[r7]
            int r0 = r0.length
            int[] r0 = new int[r0]
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0384:
            long[] r14 = r4.editListDurations
            int r15 = r14.length
            if (r11 >= r15) goto L_0x03ef
            long[] r15 = r4.editListMediaTimes
            r38 = r2
            r16 = r3
            r2 = r15[r11]
            r21 = -1
            int r15 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r15 == 0) goto L_0x03de
            r21 = r14[r11]
            long r14 = r4.timescale
            r28 = r9
            r27 = r10
            long r9 = r4.movieTimescale
            r23 = r14
            r25 = r9
            long r9 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r14 = 1
            int r15 = androidx.media2.exoplayer.external.util.Util.binarySearchCeil(r5, r2, r14, r14)
            r7[r11] = r15
            long r2 = r2 + r9
            r9 = 0
            int r2 = androidx.media2.exoplayer.external.util.Util.binarySearchCeil(r5, r2, r1, r9)
            r0[r11] = r2
        L_0x03b8:
            r2 = r7[r11]
            r3 = r0[r11]
            if (r2 >= r3) goto L_0x03cb
            r2 = r7[r11]
            r2 = r6[r2]
            r2 = r2 & r14
            if (r2 != 0) goto L_0x03cb
            r2 = r7[r11]
            int r2 = r2 + r14
            r7[r11] = r2
            goto L_0x03b8
        L_0x03cb:
            r2 = r0[r11]
            r3 = r7[r11]
            int r2 = r2 - r3
            int r12 = r12 + r2
            r2 = r7[r11]
            if (r13 == r2) goto L_0x03d7
            r2 = 1
            goto L_0x03d8
        L_0x03d7:
            r2 = 0
        L_0x03d8:
            r2 = r2 | r8
            r3 = r0[r11]
            r8 = r2
            r13 = r3
            goto L_0x03e4
        L_0x03de:
            r28 = r9
            r27 = r10
            r9 = 0
            r14 = 1
        L_0x03e4:
            int r11 = r11 + 1
            r2 = r38
            r3 = r16
            r10 = r27
            r9 = r28
            goto L_0x0384
        L_0x03ef:
            r38 = r2
            r16 = r3
            r3 = r9
            r27 = r10
            r9 = 0
            r14 = 1
            if (r12 == r3) goto L_0x03fb
            goto L_0x03fc
        L_0x03fb:
            r14 = 0
        L_0x03fc:
            r1 = r8 | r14
            if (r1 == 0) goto L_0x0403
            long[] r2 = new long[r12]
            goto L_0x0405
        L_0x0403:
            r2 = r38
        L_0x0405:
            if (r1 == 0) goto L_0x040a
            int[] r3 = new int[r12]
            goto L_0x040c
        L_0x040a:
            r3 = r16
        L_0x040c:
            if (r1 == 0) goto L_0x0410
            r10 = 0
            goto L_0x0412
        L_0x0410:
            r10 = r27
        L_0x0412:
            if (r1 == 0) goto L_0x0417
            int[] r8 = new int[r12]
            goto L_0x0418
        L_0x0417:
            r8 = r6
        L_0x0418:
            long[] r11 = new long[r12]
            r13 = r18
            r12 = 0
        L_0x041d:
            long[] r15 = r4.editListDurations
            int r15 = r15.length
            if (r9 >= r15) goto L_0x0498
            long[] r15 = r4.editListMediaTimes
            r23 = r15[r9]
            r15 = r7[r9]
            r25 = r7
            r7 = r0[r9]
            r26 = r0
            if (r1 == 0) goto L_0x0442
            int r0 = r7 - r15
            r39 = r10
            r10 = r38
            java.lang.System.arraycopy(r10, r15, r2, r12, r0)
            r10 = r16
            java.lang.System.arraycopy(r10, r15, r3, r12, r0)
            java.lang.System.arraycopy(r6, r15, r8, r12, r0)
            goto L_0x0446
        L_0x0442:
            r39 = r10
            r10 = r16
        L_0x0446:
            r0 = r39
        L_0x0448:
            if (r15 >= r7) goto L_0x0482
            r19 = 1000000(0xf4240, double:4.940656E-318)
            r16 = r6
            r27 = r7
            long r6 = r4.movieTimescale
            r17 = r13
            r21 = r6
            long r6 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r17, r19, r21)
            r17 = r5[r15]
            long r28 = r17 - r23
            r30 = 1000000(0xf4240, double:4.940656E-318)
            r17 = r13
            long r13 = r4.timescale
            r32 = r13
            long r13 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r28, r30, r32)
            long r6 = r6 + r13
            r11[r12] = r6
            if (r1 == 0) goto L_0x0477
            r6 = r3[r12]
            if (r6 <= r0) goto L_0x0477
            r0 = r10[r15]
        L_0x0477:
            int r12 = r12 + 1
            int r15 = r15 + 1
            r6 = r16
            r13 = r17
            r7 = r27
            goto L_0x0448
        L_0x0482:
            r16 = r6
            r17 = r13
            long[] r6 = r4.editListDurations
            r13 = r6[r9]
            long r13 = r17 + r13
            int r9 = r9 + 1
            r6 = r16
            r7 = r25
            r16 = r10
            r10 = r0
            r0 = r26
            goto L_0x041d
        L_0x0498:
            r39 = r10
            r17 = r13
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.movieTimescale
            r21 = r0
            long r9 = androidx.media2.exoplayer.external.util.Util.scaleLargeTimestamp(r17, r19, r21)
            androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable r12 = new androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable
            r0 = r12
            r1 = r37
            r4 = r39
            r5 = r11
            r6 = r8
            r7 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x04b5:
            r38 = r2
            r16 = r6
            r27 = r10
            r10 = r3
            long r0 = r4.timescale
            r2 = 1000000(0xf4240, double:4.940656E-318)
            androidx.media2.exoplayer.external.util.Util.scaleLargeTimestampsInPlace(r5, r2, r0)
            androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable r9 = new androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r2 = r38
            r3 = r10
            r4 = r27
            r6 = r16
            r7 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x04d5:
            androidx.media2.exoplayer.external.ParserException r0 = new androidx.media2.exoplayer.external.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            goto L_0x04de
        L_0x04dd:
            throw r0
        L_0x04de:
            goto L_0x04dd
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.extractor.mp4.AtomParsers.parseStbl(androidx.media2.exoplayer.external.extractor.mp4.Track, androidx.media2.exoplayer.external.extractor.mp4.Atom$ContainerAtom, androidx.media2.exoplayer.external.extractor.GaplessInfoHolder):androidx.media2.exoplayer.external.extractor.mp4.TrackSampleTable");
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1835365473) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(readInt4);
                Log.m16w("AtomParsers", sb.toString());
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((readUnsignedShort >> 10) & 31) + 96));
        sb.append((char) (((readUnsignedShort >> 5) & 31) + 96));
        sb.append((char) ((readUnsignedShort & 31) + 96));
        return Pair.create(Long.valueOf(readUnsignedInt), sb.toString());
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 778924083 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == 1667329389) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            parsableByteArray2.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j = Long.MAX_VALUE;
        if (i5 != 1414810956) {
            if (i5 == 1954034535) {
                int i6 = (i3 - 8) - 8;
                byte[] bArr = new byte[i6];
                parsableByteArray2.readBytes(bArr, 0, i6);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i5 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i5 == 1937010800) {
                j = 0;
            } else if (i5 == 1664495672) {
                stsdData2.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData2.format = Format.createTextSampleFormat(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData2 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i7 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int i9 = i;
        if (i9 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i7, i8);
            if (parseSampleEntryEncryptionData != null) {
                i9 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitData2;
        String str = null;
        String str2 = null;
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z = false;
        float f = 1.0f;
        int i10 = -1;
        while (position - i7 < i8) {
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i7 == i8) {
                break;
            }
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                Assertions.checkState(str == null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str = "video/avc";
            } else if (readInt2 == 1752589123) {
                Assertions.checkState(str == null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = "video/hevc";
            } else if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                if (parse3 != null) {
                    str2 = parse3.codecs;
                    str = "video/dolby-vision";
                }
            } else if (readInt2 == 1987076931) {
                Assertions.checkState(str == null);
                str = i9 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (readInt2 == 1635135811) {
                Assertions.checkState(str == null);
                str = "video/av01";
            } else if (readInt2 == 1681012275) {
                Assertions.checkState(str == null);
                str = "video/3gpp";
            } else if (readInt2 == 1702061171) {
                Assertions.checkState(str == null);
                Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                str = (String) parseEsdsFromParent.first;
                list = Collections.singletonList((byte[]) parseEsdsFromParent.second);
            } else if (readInt2 == 1885434736) {
                f = parsePaspFromParent(parsableByteArray2, position2);
                z = true;
            } else if (readInt2 == 1937126244) {
                bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
            } else if (readInt2 == 1936995172) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray2.skipBytes(3);
                if (readUnsignedByte == 0) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (readUnsignedByte2 == 0) {
                        i10 = 0;
                    } else if (readUnsignedByte2 == 1) {
                        i10 = 1;
                    } else if (readUnsignedByte2 == 2) {
                        i10 = 2;
                    } else if (readUnsignedByte2 == 3) {
                        i10 = 3;
                    }
                }
            }
            position += readInt;
            i7 = i2;
        }
        if (str != null) {
            stsdData2.format = Format.createVideoSampleFormat(Integer.toString(i4), str, str2, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f, bArr, i10, (ColorInfo) null, drmInitData3);
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0290: MOVE  (r8v4 java.lang.String) = (r25v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(androidx.media2.exoplayer.external.util.ParsableByteArray r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, androidx.media2.exoplayer.external.drm.DrmInitData r35, androidx.media2.exoplayer.external.extractor.mp4.AtomParsers.StsdData r36, int r37) throws androidx.media2.exoplayer.external.ParserException {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r3 = r35
            r15 = r36
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.setPosition(r4)
            r4 = 6
            r13 = 0
            if (r34 == 0) goto L_0x0020
            int r5 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            goto L_0x0024
        L_0x0020:
            r0.skipBytes(r5)
            r5 = 0
        L_0x0024:
            r12 = 2
            r6 = 16
            r11 = 1
            if (r5 == 0) goto L_0x0046
            if (r5 != r11) goto L_0x002d
            goto L_0x0046
        L_0x002d:
            if (r5 != r12) goto L_0x0045
            r0.skipBytes(r6)
            double r4 = r28.readDouble()
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r28.readUnsignedIntToInt()
            r6 = 20
            r0.skipBytes(r6)
            goto L_0x0058
        L_0x0045:
            return
        L_0x0046:
            int r7 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            int r4 = r28.readUnsignedFixedPoint1616()
            if (r5 != r11) goto L_0x0056
            r0.skipBytes(r6)
        L_0x0056:
            r5 = r4
            r4 = r7
        L_0x0058:
            int r6 = r28.getPosition()
            r7 = 1701733217(0x656e6361, float:7.0359778E22)
            r16 = 0
            r8 = r29
            if (r8 != r7) goto L_0x008d
            android.util.Pair r7 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r7 == 0) goto L_0x008a
            java.lang.Object r8 = r7.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0078
            r3 = r16
            goto L_0x0082
        L_0x0078:
            java.lang.Object r9 = r7.second
            androidx.media2.exoplayer.external.extractor.mp4.TrackEncryptionBox r9 = (androidx.media2.exoplayer.external.extractor.mp4.TrackEncryptionBox) r9
            java.lang.String r9 = r9.schemeType
            androidx.media2.exoplayer.external.drm.DrmInitData r3 = r3.copyWithSchemeType(r9)
        L_0x0082:
            androidx.media2.exoplayer.external.extractor.mp4.TrackEncryptionBox[] r9 = r15.trackEncryptionBoxes
            java.lang.Object r7 = r7.second
            androidx.media2.exoplayer.external.extractor.mp4.TrackEncryptionBox r7 = (androidx.media2.exoplayer.external.extractor.mp4.TrackEncryptionBox) r7
            r9[r37] = r7
        L_0x008a:
            r0.setPosition(r6)
        L_0x008d:
            r10 = r3
            r3 = 1633889587(0x61632d33, float:2.6191674E20)
            r9 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r7 = "audio/raw"
            if (r8 != r3) goto L_0x009c
            java.lang.String r3 = "audio/ac3"
            goto L_0x0119
        L_0x009c:
            r3 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r8 != r3) goto L_0x00a5
            java.lang.String r3 = "audio/eac3"
            goto L_0x0119
        L_0x00a5:
            r3 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r8 != r3) goto L_0x00ae
            java.lang.String r3 = "audio/ac4"
            goto L_0x0119
        L_0x00ae:
            r3 = 1685353315(0x64747363, float:1.803728E22)
            if (r8 != r3) goto L_0x00b7
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x0119
        L_0x00b7:
            r3 = 1685353320(0x64747368, float:1.8037286E22)
            if (r8 == r3) goto L_0x0117
            r3 = 1685353324(0x6474736c, float:1.803729E22)
            if (r8 != r3) goto L_0x00c2
            goto L_0x0117
        L_0x00c2:
            r3 = 1685353317(0x64747365, float:1.8037282E22)
            if (r8 != r3) goto L_0x00ca
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0119
        L_0x00ca:
            r3 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r8 != r3) goto L_0x00d2
            java.lang.String r3 = "audio/3gpp"
            goto L_0x0119
        L_0x00d2:
            r3 = 1935767394(0x73617762, float:1.7863284E31)
            if (r8 != r3) goto L_0x00da
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x0119
        L_0x00da:
            r3 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r8 == r3) goto L_0x0115
            r3 = 1936684916(0x736f7774, float:1.89725E31)
            if (r8 != r3) goto L_0x00e5
            goto L_0x0115
        L_0x00e5:
            r3 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r8 != r3) goto L_0x00ed
            java.lang.String r3 = "audio/mpeg"
            goto L_0x0119
        L_0x00ed:
            if (r8 != r9) goto L_0x00f2
            java.lang.String r3 = "audio/alac"
            goto L_0x0119
        L_0x00f2:
            r3 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r8 != r3) goto L_0x00fa
            java.lang.String r3 = "audio/g711-alaw"
            goto L_0x0119
        L_0x00fa:
            r3 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r8 != r3) goto L_0x0102
            java.lang.String r3 = "audio/g711-mlaw"
            goto L_0x0119
        L_0x0102:
            r3 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r8 != r3) goto L_0x010a
            java.lang.String r3 = "audio/opus"
            goto L_0x0119
        L_0x010a:
            r3 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r8 != r3) goto L_0x0112
            java.lang.String r3 = "audio/flac"
            goto L_0x0119
        L_0x0112:
            r3 = r16
            goto L_0x0119
        L_0x0115:
            r3 = r7
            goto L_0x0119
        L_0x0117:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x0119:
            r8 = r3
            r17 = r4
            r18 = r5
            r19 = r16
        L_0x0120:
            int r3 = r6 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x0284
            r0.setPosition(r6)
            int r5 = r28.readInt()
            if (r5 <= 0) goto L_0x0130
            r3 = 1
            goto L_0x0131
        L_0x0130:
            r3 = 0
        L_0x0131:
            java.lang.String r9 = "childAtomSize should be positive"
            androidx.media2.exoplayer.external.util.Assertions.checkArgument(r3, r9)
            int r3 = r28.readInt()
            r9 = 1702061171(0x65736473, float:7.183675E22)
            if (r3 == r9) goto L_0x0230
            if (r34 == 0) goto L_0x0148
            r11 = 2002876005(0x77617665, float:4.5729223E33)
            if (r3 != r11) goto L_0x0148
            goto L_0x0230
        L_0x0148:
            r4 = 1684103987(0x64616333, float:1.6630662E22)
            if (r3 != r4) goto L_0x016e
            int r3 = r6 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            androidx.media2.exoplayer.external.Format r3 = androidx.media2.exoplayer.external.audio.Ac3Util.parseAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
        L_0x015c:
            r27 = r7
            r25 = r8
            r21 = r10
            r1 = 0
            r20 = 1
            r22 = 2
            r7 = r6
            r6 = r5
        L_0x0169:
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x022d
        L_0x016e:
            r4 = 1684366131(0x64656333, float:1.692581E22)
            if (r3 != r4) goto L_0x0183
            int r3 = r6 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            androidx.media2.exoplayer.external.Format r3 = androidx.media2.exoplayer.external.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
            goto L_0x015c
        L_0x0183:
            r4 = 1684103988(0x64616334, float:1.6630663E22)
            if (r3 != r4) goto L_0x0198
            int r3 = r6 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            androidx.media2.exoplayer.external.Format r3 = androidx.media2.exoplayer.external.audio.Ac4Util.parseAc4AnnexEFormat(r0, r3, r14, r10)
            r15.format = r3
            goto L_0x015c
        L_0x0198:
            r4 = 1684305011(0x64647473, float:1.6856995E22)
            if (r3 != r4) goto L_0x01d6
            java.lang.String r3 = java.lang.Integer.toString(r32)
            r9 = 0
            r11 = -1
            r21 = -1
            r22 = 0
            r23 = 0
            r4 = r8
            r24 = r5
            r5 = r9
            r9 = r6
            r6 = r11
            r11 = r7
            r7 = r21
            r25 = r8
            r8 = r17
            r26 = r9
            r9 = r18
            r21 = r10
            r10 = r22
            r27 = r11
            r20 = 1
            r11 = r21
            r22 = 2
            r12 = r23
            r1 = 0
            r13 = r33
            androidx.media2.exoplayer.external.Format r3 = androidx.media2.exoplayer.external.Format.createAudioSampleFormat(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.format = r3
            r6 = r24
            r7 = r26
            goto L_0x0169
        L_0x01d6:
            r24 = r5
            r26 = r6
            r27 = r7
            r25 = r8
            r21 = r10
            r1 = 0
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            r20 = 1
            r22 = 2
            if (r3 != r5) goto L_0x01f9
            r6 = r24
            byte[] r3 = new byte[r6]
            r7 = r26
            r0.setPosition(r7)
            r0.readBytes(r3, r1, r6)
            r19 = r3
            goto L_0x022d
        L_0x01f9:
            r6 = r24
            r7 = r26
            r4 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r3 != r4) goto L_0x021a
            int r3 = r6 + -8
            byte[] r4 = opusMagic
            int r8 = r4.length
            int r8 = r8 + r3
            byte[] r8 = new byte[r8]
            int r9 = r4.length
            java.lang.System.arraycopy(r4, r1, r8, r1, r9)
            int r9 = r7 + 8
            r0.setPosition(r9)
            int r4 = r4.length
            r0.readBytes(r8, r4, r3)
            r19 = r8
            goto L_0x022d
        L_0x021a:
            r3 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r6 != r3) goto L_0x022d
            int r3 = r6 + -12
            byte[] r4 = new byte[r3]
            int r8 = r7 + 12
            r0.setPosition(r8)
            r0.readBytes(r4, r1, r3)
            r19 = r4
        L_0x022d:
            r8 = r25
            goto L_0x0275
        L_0x0230:
            r27 = r7
            r25 = r8
            r21 = r10
            r1 = 0
            r20 = 1
            r22 = 2
            r7 = r6
            r6 = r5
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r3 != r9) goto L_0x0244
            r3 = r7
            goto L_0x0248
        L_0x0244:
            int r3 = findEsdsPosition(r0, r7, r6)
        L_0x0248:
            if (r3 == r4) goto L_0x022d
            android.util.Pair r3 = parseEsdsFromParent(r0, r3)
            java.lang.Object r4 = r3.first
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x0275
            android.util.Pair r3 = androidx.media2.exoplayer.external.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(r19)
            java.lang.Object r4 = r3.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r18 = r4.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
        L_0x0275:
            int r6 = r6 + r7
            r1 = r30
            r10 = r21
            r7 = r27
            r9 = 1634492771(0x616c6163, float:2.7252807E20)
            r11 = 1
            r12 = 2
            r13 = 0
            goto L_0x0120
        L_0x0284:
            r27 = r7
            r25 = r8
            r21 = r10
            r22 = 2
            androidx.media2.exoplayer.external.Format r0 = r15.format
            if (r0 != 0) goto L_0x02c1
            r8 = r25
            if (r8 == 0) goto L_0x02c1
            r0 = r27
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x029e
            r7 = 2
            goto L_0x029f
        L_0x029e:
            r7 = -1
        L_0x029f:
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r2 = 0
            r3 = -1
            r4 = -1
            if (r19 != 0) goto L_0x02a9
            goto L_0x02af
        L_0x02a9:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r16 = r1
        L_0x02af:
            r10 = 0
            r1 = r8
            r5 = r17
            r6 = r18
            r8 = r16
            r9 = r21
            r11 = r33
            androidx.media2.exoplayer.external.Format r0 = androidx.media2.exoplayer.external.Format.createAudioSampleFormat(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.format = r0
        L_0x02c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.extractor.mp4.AtomParsers.parseAudioSampleEntry(androidx.media2.exoplayer.external.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, androidx.media2.exoplayer.external.drm.DrmInitData, androidx.media2.exoplayer.external.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        Assertions.checkArgument(num != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        if (parseSchiFromParent != null) {
            z = true;
        }
        Assertions.checkArgument(z, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(4, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 4, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[constrainValue] || jArr[constrainValue2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final int f10id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.f10id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }
    }
}
