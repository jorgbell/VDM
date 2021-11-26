package com.flurry.sdk;

import com.flurry.sdk.C1548be;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gb */
public final class C1787gb {

    /* renamed from: a */
    private static final List<C1893jo> f4478a;

    static {
        ArrayList arrayList = new ArrayList();
        f4478a = arrayList;
        arrayList.add(C1893jo.SESSION_ID);
        arrayList.add(C1893jo.SESSION_INFO);
        arrayList.add(C1893jo.REPORTED_ID);
    }

    /* renamed from: a */
    public static C1548be.C1550b m4631a(File file) {
        try {
            return m4632a(m4633b(file));
        } catch (IOException e) {
            C1648cy.m4325b("FileWriterUtils", "Invalid frame data file: " + file + " => " + e.toString());
            C1548be.C1550b bVar = C1548be.C1550b.IOEXCEPTION;
            bVar.f3928g = e.toString();
            return bVar;
        }
    }

    /* renamed from: a */
    private static C1548be.C1550b m4632a(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet();
        C1548be.C1550b bVar = C1548be.C1550b.SUCCEED;
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                if (bArr.length > i) {
                    if (bArr.length - i <= 0) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame version";
                        break;
                    }
                    int i3 = i + 1;
                    byte[] bArr2 = new byte[3];
                    if (bArr.length - i3 < 3) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame type";
                        break;
                    }
                    bArr2[0] = bArr[i3];
                    bArr2[1] = bArr[i3 + 1];
                    bArr2[2] = bArr[i3 + 2];
                    int i4 = i3 + 3;
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArr2, 0, bArr3, 1, 3);
                    int i5 = ByteBuffer.wrap(bArr3).getInt();
                    arrayList.add(C1893jo.m4775a(i5));
                    for (C1893jo next : f4478a) {
                        if (i5 == next.f4693N) {
                            treeSet.add(next);
                        }
                    }
                    if (bArr.length - i4 < 8) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame timestamp";
                        break;
                    }
                    int i6 = i4 + 8;
                    if (bArr.length - i6 < 8) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame relative timestamp";
                        break;
                    }
                    int i7 = i6 + 8;
                    byte[] bArr4 = new byte[4];
                    if (bArr.length - i7 < 4) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame payload length";
                        break;
                    }
                    System.arraycopy(bArr, i7, bArr4, 0, 4);
                    int i8 = i7 + 4;
                    int i9 = ByteBuffer.wrap(bArr4).getInt();
                    byte[] bArr5 = new byte[i9];
                    if (bArr.length - i8 < i9) {
                        bVar = C1548be.C1550b.EOF;
                        bVar.f3928g = "EOF frame payload";
                        break;
                    }
                    System.arraycopy(bArr, i8, bArr5, 0, i9);
                    int i10 = i8 + i9;
                    try {
                        new JSONObject(new String(bArr5));
                        if (bArr.length - i10 < 4) {
                            bVar = C1548be.C1550b.EOF;
                            bVar.f3928g = "EOF frame checksum";
                            break;
                        }
                        i = i10 + 4;
                        i2++;
                    } catch (JSONException e) {
                        C1648cy.m4325b("FileWriterUtils", "Invalid Frame Payload: " + C1893jo.m4775a(i5));
                        C1548be.C1550b bVar2 = C1548be.C1550b.PAYLOAD_ERROR;
                        bVar2.f3928g = e.toString();
                        bVar = bVar2;
                    }
                } else {
                    break;
                }
            } catch (Exception | VirtualMachineError e2) {
                C1648cy.m4325b("FileWriterUtils", "Invalid Payload: " + e2.toString());
                C1548be.C1550b bVar3 = C1548be.C1550b.PAYLOAD_ERROR;
                bVar3.f3928g = e2.toString();
                bVar = bVar3;
            }
        }
        if (bVar == C1548be.C1550b.SUCCEED && treeSet.size() < f4478a.size()) {
            bVar = C1548be.C1550b.FRAME_MISSING;
        }
        bVar.f3929h = bArr.length;
        bVar.f3930i = i2;
        bVar.f3931j = arrayList;
        bVar.f3932k = treeSet;
        return bVar;
    }

    /* renamed from: b */
    private static byte[] m4633b(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int read = fileInputStream.read(bArr, 0, length);
            if (read < length) {
                int i = length - read;
                while (i > 0) {
                    int read2 = fileInputStream.read(bArr2, 0, i);
                    System.arraycopy(bArr2, 0, bArr, length - i, read2);
                    i -= read2;
                }
            }
            return bArr;
        } finally {
            fileInputStream.close();
        }
    }
}
