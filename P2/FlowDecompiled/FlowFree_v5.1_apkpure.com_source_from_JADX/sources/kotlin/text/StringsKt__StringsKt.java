package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* compiled from: Strings.kt */
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (CharsKt__CharKt.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), i);
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            intProgression = new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), RangesKt___RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            intProgression = RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), RangesKt___RangesKt.coerceAtLeast(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intProgression.getFirst();
            int last = intProgression.getLast();
            int step = intProgression.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (true) {
                if (regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                    return first;
                }
                if (first == last) {
                    return -1;
                }
                first += step;
            }
        } else {
            int first2 = intProgression.getFirst();
            int last2 = intProgression.getLast();
            int step2 = intProgression.getStep();
            if (step2 >= 0) {
                if (first2 > last2) {
                    return -1;
                }
            } else if (first2 < last2) {
                return -1;
            }
            while (true) {
                if (StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z)) {
                    return first2;
                }
                if (first2 == last2) {
                    return -1;
                }
                first2 += step2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        T t;
        T t2;
        if (z || collection.size() != 1) {
            IntProgression intRange = !z2 ? new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), 0);
            if (charSequence instanceof String) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                int step = intRange.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it.next();
                            String str = (String) t2;
                            if (StringsKt__StringsJVMKt.regionMatches(str, 0, (String) charSequence, first, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) t2;
                        if (str2 == null) {
                            if (first == last) {
                                break;
                            }
                            first += step;
                        } else {
                            return TuplesKt.m5897to(Integer.valueOf(first), str2);
                        }
                    }
                }
            } else {
                int first2 = intRange.getFirst();
                int last2 = intRange.getLast();
                int step2 = intRange.getStep();
                if (step2 < 0 ? first2 >= last2 : first2 <= last2) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it2.next();
                            String str3 = (String) t;
                            if (regionMatchesImpl(str3, 0, charSequence, first2, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) t;
                        if (str4 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += step2;
                        } else {
                            return TuplesKt.m5897to(Integer.valueOf(first2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.single(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i2 = i;
        int indexOf$default = !z2 ? indexOf$default(charSequence2, str6, i2, false, 4, (Object) null) : lastIndexOf$default(charSequence2, str6, i2, false, 4, (Object) null);
        if (indexOf$default < 0) {
            return null;
        }
        return TuplesKt.m5897to(Integer.valueOf(indexOf$default), str5);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        Intrinsics.checkNotNullParameter(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, (Object) null);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return lastIndexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        Intrinsics.checkNotNullParameter(str, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(ArraysKt___ArraysJvmKt.asList(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$split");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(substring(charSequence, substring));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int indexOf = indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = RangesKt___RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if ((z2 && arrayList.size() == i - 1) || (indexOf = indexOf(charSequence, str, i2, z)) == -1) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                break;
            } while ((indexOf = indexOf(charSequence, str, i2, z)) == -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }
}