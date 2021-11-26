package androidx.media2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import android.widget.RelativeLayout;
import androidx.media2.widget.Cea708CCParser;
import androidx.media2.widget.ClosedCaptionWidget;
import androidx.media2.widget.SubtitleController;
import androidx.media2.widget.SubtitleTrack;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Cea708CaptionRenderer extends SubtitleController.Renderer {
    private Cea708CCWidget mCCWidget;
    private final Context mContext;

    Cea708CaptionRenderer(Context context) {
        this.mContext = context;
    }

    public boolean supports(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("mime")) {
            return "text/cea-708".equals(mediaFormat.getString("mime"));
        }
        return false;
    }

    public SubtitleTrack createTrack(MediaFormat mediaFormat) {
        if ("text/cea-708".equals(mediaFormat.getString("mime"))) {
            if (this.mCCWidget == null) {
                this.mCCWidget = new Cea708CCWidget(this, this.mContext);
            }
            return new Cea708CaptionTrack(this.mCCWidget, mediaFormat);
        }
        throw new RuntimeException("No matching format: " + mediaFormat.toString());
    }

    static class Cea708CaptionTrack extends SubtitleTrack {
        private final Cea708CCParser mCCParser;
        private final Cea708CCWidget mRenderingWidget;

        Cea708CaptionTrack(Cea708CCWidget cea708CCWidget, MediaFormat mediaFormat) {
            super(mediaFormat);
            this.mRenderingWidget = cea708CCWidget;
            this.mCCParser = new Cea708CCParser(cea708CCWidget);
        }

        public void onData(byte[] bArr, boolean z, long j) {
            this.mCCParser.parse(bArr);
        }

        public SubtitleTrack.RenderingWidget getRenderingWidget() {
            return this.mRenderingWidget;
        }
    }

    class Cea708CCWidget extends ClosedCaptionWidget implements Cea708CCParser.DisplayListener {
        private final CCHandler mCCHandler;

        Cea708CCWidget(Cea708CaptionRenderer cea708CaptionRenderer, Context context) {
            this(cea708CaptionRenderer, context, (AttributeSet) null);
        }

        Cea708CCWidget(Cea708CaptionRenderer cea708CaptionRenderer, Context context, AttributeSet attributeSet) {
            this(cea708CaptionRenderer, context, attributeSet, 0);
        }

        Cea708CCWidget(Cea708CaptionRenderer cea708CaptionRenderer, Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mCCHandler = new CCHandler((CCLayout) this.mClosedCaptionLayout);
        }

        public ClosedCaptionWidget.ClosedCaptionLayout createCaptionLayout(Context context) {
            return new CCLayout(this, context);
        }

        public void emitEvent(Cea708CCParser.CaptionEvent captionEvent) {
            this.mCCHandler.processCaptionEvent(captionEvent);
            setSize(getWidth(), getHeight());
            SubtitleTrack.RenderingWidget.OnChangedListener onChangedListener = this.mListener;
            if (onChangedListener != null) {
                onChangedListener.onChanged(this);
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            ((ViewGroup) this.mClosedCaptionLayout).draw(canvas);
        }

        class ScaledLayout extends ViewGroup {
            private Rect[] mRectArray;
            private final Comparator<Rect> mRectTopLeftSorter = new Comparator<Rect>(this) {
                public int compare(Rect rect, Rect rect2) {
                    int i = rect.top;
                    int i2 = rect2.top;
                    if (i != i2) {
                        return i - i2;
                    }
                    return rect.left - rect2.left;
                }
            };

            ScaledLayout(Cea708CCWidget cea708CCWidget, Context context) {
                super(context);
            }

            class ScaledLayoutParams extends ViewGroup.LayoutParams {
                public float scaleEndCol;
                public float scaleEndRow;
                public float scaleStartCol;
                public float scaleStartRow;

                ScaledLayoutParams(ScaledLayout scaledLayout, float f, float f2, float f3, float f4) {
                    super(-1, -1);
                    this.scaleStartRow = f;
                    this.scaleEndRow = f2;
                    this.scaleStartCol = f3;
                    this.scaleEndCol = f4;
                }

                ScaledLayoutParams(ScaledLayout scaledLayout, Context context, AttributeSet attributeSet) {
                    super(-1, -1);
                }
            }

            public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
                return new ScaledLayoutParams(this, getContext(), attributeSet);
            }

            /* access modifiers changed from: protected */
            public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
                return layoutParams instanceof ScaledLayoutParams;
            }

            /* access modifiers changed from: protected */
            public void onMeasure(int i, int i2) {
                int i3;
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int childCount = getChildCount();
                this.mRectArray = new Rect[childCount];
                int i4 = 0;
                while (i4 < childCount) {
                    View childAt = getChildAt(i4);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ScaledLayoutParams) {
                        ScaledLayoutParams scaledLayoutParams = (ScaledLayoutParams) layoutParams;
                        float f = scaledLayoutParams.scaleStartRow;
                        float f2 = scaledLayoutParams.scaleEndRow;
                        float f3 = scaledLayoutParams.scaleStartCol;
                        float f4 = scaledLayoutParams.scaleEndCol;
                        if (f < 0.0f || f > 1.0f) {
                            throw new RuntimeException("A child of ScaledLayout should have a range of scaleStartRow between 0 and 1");
                        } else if (f2 < f || f > 1.0f) {
                            throw new RuntimeException("A child of ScaledLayout should have a range of scaleEndRow between scaleStartRow and 1");
                        } else if (f4 < 0.0f || f4 > 1.0f) {
                            throw new RuntimeException("A child of ScaledLayout should have a range of scaleStartCol between 0 and 1");
                        } else if (f4 < f3 || f4 > 1.0f) {
                            throw new RuntimeException("A child of ScaledLayout should have a range of scaleEndCol between scaleStartCol and 1");
                        } else {
                            float f5 = (float) paddingLeft;
                            int i5 = paddingLeft;
                            float f6 = (float) paddingTop;
                            int i6 = size;
                            int i7 = size2;
                            int i8 = childCount;
                            this.mRectArray[i4] = new Rect((int) (f3 * f5), (int) (f * f6), (int) (f4 * f5), (int) (f2 * f6));
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (f5 * (f4 - f3)), 1073741824);
                            childAt.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                            if (childAt.getMeasuredHeight() > this.mRectArray[i4].height()) {
                                int measuredHeight = ((childAt.getMeasuredHeight() - this.mRectArray[i4].height()) + 1) / 2;
                                Rect[] rectArr = this.mRectArray;
                                rectArr[i4].bottom += measuredHeight;
                                rectArr[i4].top -= measuredHeight;
                                if (rectArr[i4].top < 0) {
                                    rectArr[i4].bottom -= rectArr[i4].top;
                                    rectArr[i4].top = 0;
                                }
                                if (rectArr[i4].bottom > paddingTop) {
                                    rectArr[i4].top -= rectArr[i4].bottom - paddingTop;
                                    rectArr[i4].bottom = paddingTop;
                                }
                            }
                            childAt.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (f6 * (f2 - f)), 1073741824));
                            i4++;
                            paddingLeft = i5;
                            size = i6;
                            size2 = i7;
                            childCount = i8;
                        }
                    } else {
                        throw new RuntimeException("A child of ScaledLayout cannot have the UNSPECIFIED scale factors");
                    }
                }
                int i9 = size;
                int i10 = size2;
                int i11 = childCount;
                int[] iArr = new int[i11];
                Rect[] rectArr2 = new Rect[i11];
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    if (getChildAt(i13).getVisibility() == 0) {
                        iArr[i12] = i12;
                        rectArr2[i12] = this.mRectArray[i13];
                        i12++;
                    }
                }
                Arrays.sort(rectArr2, 0, i12, this.mRectTopLeftSorter);
                int i14 = 0;
                while (true) {
                    i3 = i12 - 1;
                    if (i14 >= i3) {
                        break;
                    }
                    int i15 = i14 + 1;
                    for (int i16 = i15; i16 < i12; i16++) {
                        if (Rect.intersects(rectArr2[i14], rectArr2[i16])) {
                            iArr[i16] = iArr[i14];
                            rectArr2[i16].set(rectArr2[i16].left, rectArr2[i14].bottom, rectArr2[i16].right, rectArr2[i14].bottom + rectArr2[i16].height());
                        }
                    }
                    i14 = i15;
                }
                while (i3 >= 0) {
                    if (rectArr2[i3].bottom > paddingTop) {
                        int i17 = rectArr2[i3].bottom - paddingTop;
                        for (int i18 = 0; i18 <= i3; i18++) {
                            if (iArr[i3] == iArr[i18]) {
                                rectArr2[i18].set(rectArr2[i18].left, rectArr2[i18].top - i17, rectArr2[i18].right, rectArr2[i18].bottom - i17);
                            }
                        }
                    }
                    i3--;
                }
                setMeasuredDimension(i9, i10);
            }

            /* access modifiers changed from: protected */
            public void onLayout(boolean z, int i, int i2, int i3, int i4) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() != 8) {
                        Rect[] rectArr = this.mRectArray;
                        childAt.layout(rectArr[i5].left + paddingLeft, rectArr[i5].top + paddingTop, rectArr[i5].right + paddingTop, rectArr[i5].bottom + paddingLeft);
                    }
                }
            }

            public void dispatchDraw(Canvas canvas) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt.getVisibility() != 8) {
                        Rect[] rectArr = this.mRectArray;
                        if (i < rectArr.length) {
                            int save = canvas.save();
                            canvas.translate((float) (rectArr[i].left + paddingLeft), (float) (rectArr[i].top + paddingTop));
                            childAt.draw(canvas);
                            canvas.restoreToCount(save);
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        class CCLayout extends ScaledLayout implements ClosedCaptionWidget.ClosedCaptionLayout {
            private final ScaledLayout mSafeTitleAreaLayout;

            CCLayout(Cea708CCWidget cea708CCWidget, Context context) {
                super(cea708CCWidget, context);
                ScaledLayout scaledLayout = new ScaledLayout(cea708CCWidget, context);
                this.mSafeTitleAreaLayout = scaledLayout;
                addView(scaledLayout, new ScaledLayout.ScaledLayoutParams(this, 0.1f, 0.9f, 0.1f, 0.9f));
            }

            public void addOrUpdateViewToSafeTitleArea(CCWindowLayout cCWindowLayout, ScaledLayout.ScaledLayoutParams scaledLayoutParams) {
                if (this.mSafeTitleAreaLayout.indexOfChild(cCWindowLayout) < 0) {
                    this.mSafeTitleAreaLayout.addView(cCWindowLayout, scaledLayoutParams);
                } else {
                    this.mSafeTitleAreaLayout.updateViewLayout(cCWindowLayout, scaledLayoutParams);
                }
            }

            public void removeViewFromSafeTitleArea(CCWindowLayout cCWindowLayout) {
                this.mSafeTitleAreaLayout.removeView(cCWindowLayout);
            }

            public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
                int childCount = this.mSafeTitleAreaLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ((CCWindowLayout) this.mSafeTitleAreaLayout.getChildAt(i)).setCaptionStyle(captionStyle);
                }
            }

            public void setFontScale(float f) {
                int childCount = this.mSafeTitleAreaLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ((CCWindowLayout) this.mSafeTitleAreaLayout.getChildAt(i)).setFontScale(f);
                }
            }
        }

        class CCHandler implements Handler.Callback {
            private final CCLayout mCCLayout;
            private final CCWindowLayout[] mCaptionWindowLayouts = new CCWindowLayout[8];
            private CCWindowLayout mCurrentWindowLayout;
            private final Handler mHandler;
            private boolean mIsDelayed = false;
            private final ArrayList<Cea708CCParser.CaptionEvent> mPendingCaptionEvents = new ArrayList<>();

            CCHandler(CCLayout cCLayout) {
                this.mCCLayout = cCLayout;
                this.mHandler = new Handler(this);
            }

            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    delayCancel();
                    return true;
                } else if (i != 2) {
                    return false;
                } else {
                    clearWindows(255);
                    return true;
                }
            }

            public void processCaptionEvent(Cea708CCParser.CaptionEvent captionEvent) {
                if (this.mIsDelayed) {
                    this.mPendingCaptionEvents.add(captionEvent);
                    return;
                }
                switch (captionEvent.type) {
                    case 1:
                        sendBufferToCurrentWindow((String) captionEvent.obj);
                        return;
                    case 2:
                        sendControlToCurrentWindow(((Character) captionEvent.obj).charValue());
                        return;
                    case 3:
                        setCurrentWindowLayout(((Integer) captionEvent.obj).intValue());
                        return;
                    case 4:
                        clearWindows(((Integer) captionEvent.obj).intValue());
                        return;
                    case 5:
                        displayWindows(((Integer) captionEvent.obj).intValue());
                        return;
                    case 6:
                        hideWindows(((Integer) captionEvent.obj).intValue());
                        return;
                    case 7:
                        toggleWindows(((Integer) captionEvent.obj).intValue());
                        return;
                    case 8:
                        deleteWindows(((Integer) captionEvent.obj).intValue());
                        return;
                    case 9:
                        delay(((Integer) captionEvent.obj).intValue());
                        return;
                    case 10:
                        delayCancel();
                        return;
                    case 11:
                        reset();
                        return;
                    case 12:
                        setPenAttr((Cea708CCParser.CaptionPenAttr) captionEvent.obj);
                        return;
                    case 13:
                        setPenColor((Cea708CCParser.CaptionPenColor) captionEvent.obj);
                        return;
                    case 14:
                        setPenLocation((Cea708CCParser.CaptionPenLocation) captionEvent.obj);
                        return;
                    case 15:
                        setWindowAttr((Cea708CCParser.CaptionWindowAttr) captionEvent.obj);
                        return;
                    case 16:
                        defineWindow((Cea708CCParser.CaptionWindow) captionEvent.obj);
                        return;
                    default:
                        return;
                }
            }

            private void setCurrentWindowLayout(int i) {
                CCWindowLayout cCWindowLayout;
                if (i >= 0) {
                    CCWindowLayout[] cCWindowLayoutArr = this.mCaptionWindowLayouts;
                    if (i < cCWindowLayoutArr.length && (cCWindowLayout = cCWindowLayoutArr[i]) != null) {
                        this.mCurrentWindowLayout = cCWindowLayout;
                    }
                }
            }

            private ArrayList<CCWindowLayout> getWindowsFromBitmap(int i) {
                CCWindowLayout cCWindowLayout;
                ArrayList<CCWindowLayout> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < 8; i2++) {
                    if (!(((1 << i2) & i) == 0 || (cCWindowLayout = this.mCaptionWindowLayouts[i2]) == null)) {
                        arrayList.add(cCWindowLayout);
                    }
                }
                return arrayList;
            }

            private void clearWindows(int i) {
                if (i != 0) {
                    Iterator<CCWindowLayout> it = getWindowsFromBitmap(i).iterator();
                    while (it.hasNext()) {
                        it.next().clear();
                    }
                }
            }

            private void displayWindows(int i) {
                if (i != 0) {
                    Iterator<CCWindowLayout> it = getWindowsFromBitmap(i).iterator();
                    while (it.hasNext()) {
                        it.next().show();
                    }
                }
            }

            private void hideWindows(int i) {
                if (i != 0) {
                    Iterator<CCWindowLayout> it = getWindowsFromBitmap(i).iterator();
                    while (it.hasNext()) {
                        it.next().hide();
                    }
                }
            }

            private void toggleWindows(int i) {
                if (i != 0) {
                    Iterator<CCWindowLayout> it = getWindowsFromBitmap(i).iterator();
                    while (it.hasNext()) {
                        CCWindowLayout next = it.next();
                        if (next.isShown()) {
                            next.hide();
                        } else {
                            next.show();
                        }
                    }
                }
            }

            private void deleteWindows(int i) {
                if (i != 0) {
                    Iterator<CCWindowLayout> it = getWindowsFromBitmap(i).iterator();
                    while (it.hasNext()) {
                        CCWindowLayout next = it.next();
                        next.removeFromCaptionView();
                        this.mCaptionWindowLayouts[next.getCaptionWindowId()] = null;
                    }
                }
            }

            public void reset() {
                this.mCurrentWindowLayout = null;
                this.mIsDelayed = false;
                this.mPendingCaptionEvents.clear();
                for (int i = 0; i < 8; i++) {
                    CCWindowLayout[] cCWindowLayoutArr = this.mCaptionWindowLayouts;
                    if (cCWindowLayoutArr[i] != null) {
                        cCWindowLayoutArr[i].removeFromCaptionView();
                    }
                    this.mCaptionWindowLayouts[i] = null;
                }
                this.mCCLayout.setVisibility(4);
                this.mHandler.removeMessages(2);
            }

            private void setWindowAttr(Cea708CCParser.CaptionWindowAttr captionWindowAttr) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.setWindowAttr(captionWindowAttr);
                }
            }

            private void defineWindow(Cea708CCParser.CaptionWindow captionWindow) {
                int i;
                if (captionWindow != null && (i = captionWindow.f18id) >= 0) {
                    CCWindowLayout[] cCWindowLayoutArr = this.mCaptionWindowLayouts;
                    if (i < cCWindowLayoutArr.length) {
                        CCWindowLayout cCWindowLayout = cCWindowLayoutArr[i];
                        if (cCWindowLayout == null) {
                            cCWindowLayout = new CCWindowLayout(Cea708CCWidget.this, this.mCCLayout.getContext());
                        }
                        cCWindowLayout.initWindow(this.mCCLayout, captionWindow);
                        this.mCaptionWindowLayouts[i] = cCWindowLayout;
                        this.mCurrentWindowLayout = cCWindowLayout;
                    }
                }
            }

            private void delay(int i) {
                if (i >= 0 && i <= 255) {
                    this.mIsDelayed = true;
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(1), (long) (i * 100));
                }
            }

            private void delayCancel() {
                this.mIsDelayed = false;
                processPendingBuffer();
            }

            private void processPendingBuffer() {
                Iterator<Cea708CCParser.CaptionEvent> it = this.mPendingCaptionEvents.iterator();
                while (it.hasNext()) {
                    processCaptionEvent(it.next());
                }
                this.mPendingCaptionEvents.clear();
            }

            private void sendControlToCurrentWindow(char c) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.sendControl(c);
                }
            }

            private void sendBufferToCurrentWindow(String str) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.sendBuffer(str);
                    this.mHandler.removeMessages(2);
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(2), 60000);
                }
            }

            private void setPenAttr(Cea708CCParser.CaptionPenAttr captionPenAttr) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.setPenAttr(captionPenAttr);
                }
            }

            private void setPenColor(Cea708CCParser.CaptionPenColor captionPenColor) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.setPenColor(captionPenColor);
                }
            }

            private void setPenLocation(Cea708CCParser.CaptionPenLocation captionPenLocation) {
                CCWindowLayout cCWindowLayout = this.mCurrentWindowLayout;
                if (cCWindowLayout != null) {
                    cCWindowLayout.setPenLocation(captionPenLocation.row, captionPenLocation.column);
                }
            }
        }

        private class CCWindowLayout extends RelativeLayout implements View.OnLayoutChangeListener {
            private final SpannableStringBuilder mBuilder;
            private CCLayout mCCLayout;
            private CCView mCCView;
            private CaptioningManager.CaptionStyle mCaptionStyle;
            private int mCaptionWindowId;
            private final List<CharacterStyle> mCharacterStyles;
            private float mFontScale;
            private int mLastCaptionLayoutHeight;
            private int mLastCaptionLayoutWidth;
            private int mRow;
            private int mRowLimit;
            private float mTextSize;
            private String mWidestChar;

            private int getScreenColumnCount() {
                return 42;
            }

            public void sendControl(char c) {
            }

            public void setPenColor(Cea708CCParser.CaptionPenColor captionPenColor) {
            }

            public void setWindowAttr(Cea708CCParser.CaptionWindowAttr captionWindowAttr) {
            }

            CCWindowLayout(Cea708CCWidget cea708CCWidget, Context context) {
                this(cea708CCWidget, context, (AttributeSet) null);
            }

            CCWindowLayout(Cea708CCWidget cea708CCWidget, Context context, AttributeSet attributeSet) {
                this(cea708CCWidget, context, attributeSet, 0);
            }

            CCWindowLayout(Cea708CCWidget cea708CCWidget, Context context, AttributeSet attributeSet, int i) {
                super(context, attributeSet, i);
                this.mRowLimit = 0;
                this.mBuilder = new SpannableStringBuilder();
                this.mCharacterStyles = new ArrayList();
                this.mRow = -1;
                this.mCCView = new CCView(cea708CCWidget, context);
                addView(this.mCCView, new RelativeLayout.LayoutParams(-2, -2));
                CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
                this.mFontScale = captioningManager.getFontScale();
                setCaptionStyle(captioningManager.getUserStyle());
                this.mCCView.setText("");
                updateWidestChar();
            }

            public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
                this.mCaptionStyle = captionStyle;
                this.mCCView.setCaptionStyle(captionStyle);
            }

            public void setFontScale(float f) {
                this.mFontScale = f;
                updateTextSize();
            }

            public int getCaptionWindowId() {
                return this.mCaptionWindowId;
            }

            public void setCaptionWindowId(int i) {
                this.mCaptionWindowId = i;
            }

            public void clear() {
                clearText();
                hide();
            }

            public void show() {
                setVisibility(0);
                requestLayout();
            }

            public void hide() {
                setVisibility(4);
                requestLayout();
            }

            public void setPenAttr(Cea708CCParser.CaptionPenAttr captionPenAttr) {
                this.mCharacterStyles.clear();
                if (captionPenAttr.italic) {
                    this.mCharacterStyles.add(new StyleSpan(2));
                }
                if (captionPenAttr.underline) {
                    this.mCharacterStyles.add(new UnderlineSpan());
                }
                int i = captionPenAttr.penSize;
                if (i == 0) {
                    this.mCharacterStyles.add(new RelativeSizeSpan(0.75f));
                } else if (i == 2) {
                    this.mCharacterStyles.add(new RelativeSizeSpan(1.25f));
                }
                int i2 = captionPenAttr.penOffset;
                if (i2 == 0) {
                    this.mCharacterStyles.add(new SubscriptSpan());
                } else if (i2 == 2) {
                    this.mCharacterStyles.add(new SuperscriptSpan());
                }
            }

            public void setPenLocation(int i, int i2) {
                int i3 = this.mRow;
                if (i3 >= 0) {
                    while (i3 < i) {
                        appendText("\n");
                        i3++;
                    }
                }
                this.mRow = i;
            }

            public void sendBuffer(String str) {
                appendText(str);
            }

            /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x013b  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0160  */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0164  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void initWindow(androidx.media2.widget.Cea708CaptionRenderer.Cea708CCWidget.CCLayout r19, androidx.media2.widget.Cea708CCParser.CaptionWindow r20) {
                /*
                    r18 = this;
                    r0 = r18
                    r1 = r19
                    r2 = r20
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout r3 = r0.mCCLayout
                    if (r3 == r1) goto L_0x0017
                    if (r3 == 0) goto L_0x000f
                    r3.removeOnLayoutChangeListener(r0)
                L_0x000f:
                    r0.mCCLayout = r1
                    r1.addOnLayoutChangeListener(r0)
                    r18.updateWidestChar()
                L_0x0017:
                    int r1 = r2.anchorVertical
                    float r1 = (float) r1
                    boolean r3 = r2.relativePositioning
                    r4 = 99
                    if (r3 == 0) goto L_0x0023
                    r5 = 99
                    goto L_0x0025
                L_0x0023:
                    r5 = 74
                L_0x0025:
                    float r5 = (float) r5
                    float r1 = r1 / r5
                    int r5 = r2.anchorHorizontal
                    float r5 = (float) r5
                    if (r3 == 0) goto L_0x002d
                    goto L_0x002f
                L_0x002d:
                    r4 = 209(0xd1, float:2.93E-43)
                L_0x002f:
                    float r3 = (float) r4
                    float r5 = r5 / r3
                    java.lang.String r3 = "CCWindowLayout"
                    r4 = 0
                    r6 = 1065353216(0x3f800000, float:1.0)
                    int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                    if (r7 < 0) goto L_0x003e
                    int r7 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                    if (r7 <= 0) goto L_0x005a
                L_0x003e:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "The vertical position of the anchor point should be at the range of 0 and 1 but "
                    r7.append(r8)
                    r7.append(r1)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.i(r3, r7)
                    float r1 = java.lang.Math.min(r1, r6)
                    float r1 = java.lang.Math.max(r4, r1)
                L_0x005a:
                    int r7 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                    if (r7 < 0) goto L_0x0062
                    int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r7 <= 0) goto L_0x007e
                L_0x0062:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "The horizontal position of the anchor point should be at the range of 0 and 1 but "
                    r7.append(r8)
                    r7.append(r5)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.i(r3, r7)
                    float r3 = java.lang.Math.min(r5, r6)
                    float r5 = java.lang.Math.max(r4, r3)
                L_0x007e:
                    r3 = 17
                    int r7 = r2.anchorId
                    int r8 = r7 % 3
                    r9 = 3
                    int r7 = r7 / r9
                    r10 = 2
                    r11 = 1
                    if (r8 == 0) goto L_0x0112
                    if (r8 == r11) goto L_0x009b
                    if (r8 == r10) goto L_0x0094
                    r16 = 0
                L_0x0090:
                    r17 = 1065353216(0x3f800000, float:1.0)
                    goto L_0x011e
                L_0x0094:
                    r3 = 5
                    r17 = r5
                    r16 = 0
                    goto L_0x011e
                L_0x009b:
                    float r3 = r6 - r5
                    float r3 = java.lang.Math.min(r3, r5)
                    int r8 = r2.columnCount
                    int r8 = r8 + r11
                    int r12 = r18.getScreenColumnCount()
                    int r8 = java.lang.Math.min(r12, r8)
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    r12.<init>()
                    r13 = 0
                L_0x00b2:
                    if (r13 >= r8) goto L_0x00bc
                    java.lang.String r14 = r0.mWidestChar
                    r12.append(r14)
                    int r13 = r13 + 1
                    goto L_0x00b2
                L_0x00bc:
                    android.graphics.Paint r8 = new android.graphics.Paint
                    r8.<init>()
                    android.view.accessibility.CaptioningManager$CaptionStyle r13 = r0.mCaptionStyle
                    android.graphics.Typeface r13 = r13.getTypeface()
                    r8.setTypeface(r13)
                    float r13 = r0.mTextSize
                    r8.setTextSize(r13)
                    java.lang.String r12 = r12.toString()
                    float r8 = r8.measureText(r12)
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout r12 = r0.mCCLayout
                    int r12 = r12.getWidth()
                    if (r12 <= 0) goto L_0x00f0
                    r12 = 1073741824(0x40000000, float:2.0)
                    float r8 = r8 / r12
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout r12 = r0.mCCLayout
                    int r12 = r12.getWidth()
                    float r12 = (float) r12
                    r13 = 1061997773(0x3f4ccccd, float:0.8)
                    float r12 = r12 * r13
                    float r8 = r8 / r12
                    goto L_0x00f1
                L_0x00f0:
                    r8 = 0
                L_0x00f1:
                    int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                    if (r12 <= 0) goto L_0x0102
                    int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                    if (r12 >= 0) goto L_0x0102
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCView r3 = r0.mCCView
                    android.text.Layout$Alignment r12 = android.text.Layout.Alignment.ALIGN_NORMAL
                    r3.setAlignment(r12)
                    float r5 = r5 - r8
                    goto L_0x0119
                L_0x0102:
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCView r8 = r0.mCCView
                    android.text.Layout$Alignment r9 = android.text.Layout.Alignment.ALIGN_CENTER
                    r8.setAlignment(r9)
                    float r8 = r5 - r3
                    float r5 = r5 + r3
                    r17 = r5
                    r16 = r8
                    r3 = 1
                    goto L_0x011e
                L_0x0112:
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCView r3 = r0.mCCView
                    android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_NORMAL
                    r3.setAlignment(r8)
                L_0x0119:
                    r16 = r5
                    r3 = 3
                    goto L_0x0090
                L_0x011e:
                    if (r7 == 0) goto L_0x013b
                    if (r7 == r11) goto L_0x012d
                    if (r7 == r10) goto L_0x0128
                    r14 = 0
                L_0x0125:
                    r15 = 1065353216(0x3f800000, float:1.0)
                    goto L_0x013f
                L_0x0128:
                    r3 = r3 | 80
                    r15 = r1
                    r14 = 0
                    goto L_0x013f
                L_0x012d:
                    r3 = r3 | 16
                    float r6 = r6 - r1
                    float r4 = java.lang.Math.min(r6, r1)
                    float r5 = r1 - r4
                    float r6 = r1 + r4
                    r14 = r5
                    r15 = r6
                    goto L_0x013f
                L_0x013b:
                    r3 = r3 | 48
                    r14 = r1
                    goto L_0x0125
                L_0x013f:
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout r1 = r0.mCCLayout
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$ScaledLayout$ScaledLayoutParams r4 = new androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$ScaledLayout$ScaledLayoutParams
                    androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout r13 = r0.mCCLayout
                    r13.getClass()
                    r12 = r4
                    r12.<init>(r13, r14, r15, r16, r17)
                    r1.addOrUpdateViewToSafeTitleArea(r0, r4)
                    int r1 = r2.f18id
                    r0.setCaptionWindowId(r1)
                    int r1 = r2.rowCount
                    r0.setRowLimit(r1)
                    r0.setGravity(r3)
                    boolean r1 = r2.visible
                    if (r1 == 0) goto L_0x0164
                    r18.show()
                    goto L_0x0167
                L_0x0164:
                    r18.hide()
                L_0x0167:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media2.widget.Cea708CaptionRenderer.Cea708CCWidget.CCWindowLayout.initWindow(androidx.media2.widget.Cea708CaptionRenderer$Cea708CCWidget$CCLayout, androidx.media2.widget.Cea708CCParser$CaptionWindow):void");
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9 = i3 - i;
                int i10 = i4 - i2;
                if (i9 != this.mLastCaptionLayoutWidth || i10 != this.mLastCaptionLayoutHeight) {
                    this.mLastCaptionLayoutWidth = i9;
                    this.mLastCaptionLayoutHeight = i10;
                    updateTextSize();
                }
            }

            private void updateWidestChar() {
                Paint paint = new Paint();
                paint.setTypeface(this.mCaptionStyle.getTypeface());
                Charset forName = Charset.forName("ISO-8859-1");
                float f = 0.0f;
                for (int i = 0; i < 256; i++) {
                    String str = new String(new byte[]{(byte) i}, forName);
                    float measureText = paint.measureText(str);
                    if (f < measureText) {
                        this.mWidestChar = str;
                        f = measureText;
                    }
                }
                updateTextSize();
            }

            private void updateTextSize() {
                if (this.mCCLayout != null) {
                    StringBuilder sb = new StringBuilder();
                    int screenColumnCount = getScreenColumnCount();
                    for (int i = 0; i < screenColumnCount; i++) {
                        sb.append(this.mWidestChar);
                    }
                    String sb2 = sb.toString();
                    Paint paint = new Paint();
                    paint.setTypeface(this.mCaptionStyle.getTypeface());
                    float f = 0.0f;
                    float f2 = 255.0f;
                    while (f < f2) {
                        float f3 = (f + f2) / 2.0f;
                        paint.setTextSize(f3);
                        if (((float) this.mCCLayout.getWidth()) * 0.8f > paint.measureText(sb2)) {
                            f = f3 + 0.01f;
                        } else {
                            f2 = f3 - 0.01f;
                        }
                    }
                    float f4 = f2 * this.mFontScale;
                    this.mTextSize = f4;
                    this.mCCView.setTextSize(f4);
                }
            }

            public void removeFromCaptionView() {
                CCLayout cCLayout = this.mCCLayout;
                if (cCLayout != null) {
                    cCLayout.removeViewFromSafeTitleArea(this);
                    this.mCCLayout.removeOnLayoutChangeListener(this);
                    this.mCCLayout = null;
                }
            }

            public void appendText(String str) {
                updateText(str, true);
            }

            public void clearText() {
                this.mBuilder.clear();
                this.mCCView.setText("");
            }

            private void updateText(String str, boolean z) {
                if (!z) {
                    this.mBuilder.clear();
                }
                if (str != null && str.length() > 0) {
                    int length = this.mBuilder.length();
                    this.mBuilder.append(str);
                    for (CharacterStyle span : this.mCharacterStyles) {
                        SpannableStringBuilder spannableStringBuilder = this.mBuilder;
                        spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 33);
                    }
                }
                String[] split = TextUtils.split(this.mBuilder.toString(), "\n");
                String join = TextUtils.join("\n", Arrays.copyOfRange(split, Math.max(0, split.length - (this.mRowLimit + 1)), split.length));
                SpannableStringBuilder spannableStringBuilder2 = this.mBuilder;
                spannableStringBuilder2.delete(0, spannableStringBuilder2.length() - join.length());
                int length2 = this.mBuilder.length() - 1;
                int i = 0;
                while (i <= length2 && this.mBuilder.charAt(i) <= ' ') {
                    i++;
                }
                int i2 = length2;
                while (i2 >= i && this.mBuilder.charAt(i2) <= ' ') {
                    i2--;
                }
                if (i == 0 && i2 == length2) {
                    this.mCCView.setText(this.mBuilder);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
                spannableStringBuilder3.append(this.mBuilder);
                if (i2 < length2) {
                    spannableStringBuilder3.delete(i2 + 1, length2 + 1);
                }
                if (i > 0) {
                    spannableStringBuilder3.delete(0, i);
                }
                this.mCCView.setText(spannableStringBuilder3);
            }

            public void setRowLimit(int i) {
                if (i >= 0) {
                    this.mRowLimit = i;
                    return;
                }
                throw new IllegalArgumentException("A rowLimit should have a positive number");
            }
        }

        class CCView extends SubtitleView {
            CCView(Cea708CCWidget cea708CCWidget, Context context) {
                this(cea708CCWidget, context, (AttributeSet) null);
            }

            CCView(Cea708CCWidget cea708CCWidget, Context context, AttributeSet attributeSet) {
                this(cea708CCWidget, context, attributeSet, 0);
            }

            CCView(Cea708CCWidget cea708CCWidget, Context context, AttributeSet attributeSet, int i) {
                super(context, attributeSet, i);
            }

            /* access modifiers changed from: package-private */
            public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (captionStyle.hasForegroundColor()) {
                        setForegroundColor(captionStyle.foregroundColor);
                    }
                    if (captionStyle.hasBackgroundColor()) {
                        setBackgroundColor(captionStyle.backgroundColor);
                    }
                    if (captionStyle.hasEdgeType()) {
                        setEdgeType(captionStyle.edgeType);
                    }
                    if (captionStyle.hasEdgeColor()) {
                        setEdgeColor(captionStyle.edgeColor);
                    }
                }
                setTypeface(captionStyle.getTypeface());
            }
        }
    }
}
