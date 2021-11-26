package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public class Cocos2dxBitmap {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    private static Context context;

    private static native void nativeInitBitmapDC(int i, int i2, byte[] bArr);

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void createTextBitmap(String str, String str2, int i, int i2, int i3, int i4) {
        String refactorString = refactorString(str);
        Paint newPaint = newPaint(str2, i, i2);
        TextProperty computeTextProperty = computeTextProperty(refactorString, newPaint, i3, i4);
        if (i4 == 0) {
            i4 = computeTextProperty.totalHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(computeTextProperty.maxWidth, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i5 = -newPaint.getFontMetricsInt().ascent;
        for (String str3 : computeTextProperty.lines) {
            canvas.drawText(str3, (float) computeX(newPaint, str3, computeTextProperty.maxWidth, i2), (float) i5, newPaint);
            i5 += computeTextProperty.heightPerLine;
        }
        initNativeObject(createBitmap);
    }

    private static int computeX(Paint paint, String str, int i, int i2) {
        if (i2 == 50) {
            return i;
        }
        if (i2 != 51) {
            return 0;
        }
        return i / 2;
    }

    private static class TextProperty {
        int heightPerLine;
        String[] lines;
        int maxWidth;
        int totalHeight;

        TextProperty(int i, int i2, String[] strArr) {
            this.maxWidth = i;
            this.heightPerLine = i2;
            this.totalHeight = i2 * strArr.length;
            this.lines = strArr;
        }
    }

    private static TextProperty computeTextProperty(String str, Paint paint, int i, int i2) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int ceil = (int) Math.ceil((double) (fontMetricsInt.descent - fontMetricsInt.ascent));
        String[] splitString = splitString(str, i2, i, paint);
        int i3 = 0;
        for (String str2 : splitString) {
            int ceil2 = (int) Math.ceil((double) paint.measureText(str2, 0, str2.length()));
            if (ceil2 > i3) {
                i3 = ceil2;
            }
        }
        return new TextProperty(i3, ceil, splitString);
    }

    private static String[] splitString(String str, int i, int i2, Paint paint) {
        String[] split = str.split("\\n");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int ceil = i / ((int) Math.ceil((double) (fontMetricsInt.descent - fontMetricsInt.ascent)));
        int i3 = 0;
        if (i2 != 0) {
            LinkedList linkedList = new LinkedList();
            int length = split.length;
            while (i3 < length) {
                String str2 = split[i3];
                if (((int) Math.ceil((double) paint.measureText(str2))) > i2) {
                    linkedList.addAll(divideStringWithMaxWidth(paint, str2, i2));
                } else {
                    linkedList.add(str2);
                }
                if (ceil > 0 && linkedList.size() >= ceil) {
                    break;
                }
                i3++;
            }
            if (ceil > 0 && linkedList.size() > ceil) {
                while (linkedList.size() > ceil) {
                    linkedList.removeLast();
                }
            }
            String[] strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
            return strArr;
        } else if (i == 0 || split.length <= ceil) {
            return split;
        } else {
            LinkedList linkedList2 = new LinkedList();
            while (i3 < ceil) {
                linkedList2.add(split[i3]);
                i3++;
            }
            String[] strArr2 = new String[linkedList2.size()];
            linkedList2.toArray(strArr2);
            return strArr2;
        }
    }

    private static LinkedList<String> divideStringWithMaxWidth(Paint paint, String str, int i) {
        int length = str.length();
        LinkedList<String> linkedList = new LinkedList<>();
        int i2 = 1;
        int i3 = 0;
        while (i2 <= length) {
            int ceil = (int) Math.ceil((double) paint.measureText(str, i3, i2));
            if (ceil >= i) {
                int lastIndexOf = str.substring(0, i2).lastIndexOf(" ");
                if (lastIndexOf != -1 && lastIndexOf > i3) {
                    linkedList.add(str.substring(i3, lastIndexOf));
                    i2 = lastIndexOf;
                } else if (ceil > i) {
                    linkedList.add(str.substring(i3, i2 - 1));
                    i2--;
                } else {
                    linkedList.add(str.substring(i3, i2));
                }
                i3 = i2;
            }
            i2++;
        }
        if (i3 < length) {
            linkedList.add(str.substring(i3));
        }
        return linkedList;
    }

    private static Paint newPaint(String str, int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        if (str.endsWith(".ttf")) {
            try {
                paint.setTypeface(Cocos2dxTypefaces.get(context, str));
            } catch (Exception unused) {
                Log.e("Cocos2dxBitmap", "error to create ttf type face: " + str);
                paint.setTypeface(Typeface.create(str, 0));
            }
        } else {
            paint.setTypeface(Typeface.create(str, 0));
        }
        switch (i2) {
            case 49:
                paint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                paint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                paint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                paint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return paint;
    }

    private static String refactorString(String str) {
        if (str.compareTo("") == 0) {
            return " ";
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        for (int indexOf = sb.indexOf("\n"); indexOf != -1; indexOf = sb.indexOf("\n", i)) {
            if (indexOf == 0 || sb.charAt(indexOf - 1) == 10) {
                sb.insert(i, " ");
                i = indexOf + 2;
            } else {
                i = indexOf + 1;
            }
            if (i > sb.length() || indexOf == sb.length()) {
                break;
            }
        }
        return sb.toString();
    }

    private static void initNativeObject(Bitmap bitmap) {
        byte[] pixels = getPixels(bitmap);
        if (pixels != null) {
            nativeInitBitmapDC(bitmap.getWidth(), bitmap.getHeight(), pixels);
        }
    }

    private static byte[] getPixels(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight() * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        bitmap.copyPixelsToBuffer(wrap);
        return bArr;
    }
}
