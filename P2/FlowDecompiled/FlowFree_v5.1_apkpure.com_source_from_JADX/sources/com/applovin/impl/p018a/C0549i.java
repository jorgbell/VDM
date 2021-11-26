package com.applovin.impl.p018a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1094f;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.i */
public class C0549i {

    /* renamed from: a */
    private static DateFormat f213a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b */
    private static Random f214b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m280a(String str, long j, Uri uri, C0543d dVar, C1062k kVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String replace = str.replace("[ERRORCODE]", Integer.toString(dVar.mo7869a()));
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m283a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m282a()).replace("[TIMESTAMP]", m295b()));
            } catch (Throwable th) {
                C1107r z = kVar.mo9411z();
                z.mo9585b("VastUtils", "Unable to replace macros in URL string " + str, th);
                return null;
            }
        } else {
            kVar.mo9411z().mo9588e("VastUtils", "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C0543d m281a(C0536a aVar) {
        if (m296b(aVar) || m298c(aVar)) {
            return null;
        }
        return C0543d.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m282a() {
        return Integer.toString(f214b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    private static String m283a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j);
        long minutes = timeUnit.toMinutes(j);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        long seconds = j % timeUnit2.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1)), Long.valueOf(seconds)});
    }

    /* renamed from: a */
    public static String m284a(C0542c cVar) {
        C1166t c;
        if (cVar != null) {
            List<C1166t> b = cVar.mo7862b();
            int size = cVar.mo7862b().size();
            if (size <= 0 || (c = b.get(size - 1).mo9700c("VASTAdTagURI")) == null) {
                return null;
            }
            return c.mo9701c();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m285a(C1166t tVar, String str, String str2) {
        C1166t b = tVar.mo9698b(str);
        if (b != null) {
            String c = b.mo9701c();
            if (C1155o.m2673b(c)) {
                return c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static Set<C0547g> m286a(C0542c cVar, C1062k kVar) {
        if (cVar == null) {
            return null;
        }
        List<C1166t> b = cVar.mo7862b();
        Set<C0547g> hashSet = new HashSet<>(b.size());
        for (C1166t next : b) {
            C1166t c = next.mo9700c("Wrapper");
            if (c == null) {
                c = next.mo9700c("InLine");
            }
            hashSet = m287a(hashSet, c != null ? c.mo9697a("Error") : next.mo9697a("Error"), cVar, kVar);
        }
        C1107r z = kVar.mo9411z();
        z.mo9584b("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        return hashSet;
    }

    /* renamed from: a */
    private static Set<C0547g> m287a(Set<C0547g> set, List<C1166t> list, C0542c cVar, C1062k kVar) {
        if (list != null) {
            for (C1166t a : list) {
                C0547g a2 = C0547g.m276a(a, cVar, kVar);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m288a(C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C0543d dVar, int i, C1062k kVar) {
        if (kVar != null) {
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
            }
            m292a(m286a(cVar, kVar), dVar, kVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /* renamed from: a */
    public static void m289a(C1166t tVar, Map<String, Set<C0547g>> map, C0542c cVar, C1062k kVar) {
        List<C1166t> a;
        C1107r z;
        String str;
        if (kVar != null) {
            if (tVar == null) {
                z = kVar.mo9411z();
                str = "Unable to render event trackers; null node provided";
            } else if (map == null) {
                z = kVar.mo9411z();
                str = "Unable to render event trackers; null event trackers provided";
            } else {
                C1166t b = tVar.mo9698b("TrackingEvents");
                if (b != null && (a = b.mo9697a("Tracking")) != null) {
                    for (C1166t next : a) {
                        String str2 = next.mo9699b().get("event");
                        if (C1155o.m2673b(str2)) {
                            C0547g a2 = C0547g.m276a(next, cVar, kVar);
                            if (a2 != null) {
                                Set set = map.get(str2);
                                if (set != null) {
                                    set.add(a2);
                                } else {
                                    HashSet hashSet = new HashSet();
                                    hashSet.add(a2);
                                    map.put(str2, hashSet);
                                }
                            }
                        } else {
                            C1107r z2 = kVar.mo9411z();
                            z2.mo9588e("VastUtils", "Could not find event for tracking node = " + next);
                        }
                    }
                    return;
                }
                return;
            }
            z.mo9588e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m290a(List<C1166t> list, Set<C0547g> set, C0542c cVar, C1062k kVar) {
        C1107r z;
        String str;
        if (kVar != null) {
            if (list == null) {
                z = kVar.mo9411z();
                str = "Unable to render trackers; null nodes provided";
            } else if (set == null) {
                z = kVar.mo9411z();
                str = "Unable to render trackers; null trackers provided";
            } else {
                for (C1166t a : list) {
                    C0547g a2 = C0547g.m276a(a, cVar, kVar);
                    if (a2 != null) {
                        set.add(a2);
                    }
                }
                return;
            }
            z.mo9588e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m291a(Set<C0547g> set, long j, Uri uri, C0543d dVar, C1062k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C0547g b : set) {
                Uri a = m280a(b.mo7884b(), j, uri, dVar, kVar);
                if (a != null) {
                    kVar.mo9342S().mo9500a(C1094f.m2366o().mo9528c(a.toString()).mo9523a(false).mo9524a(), false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m292a(Set<C0547g> set, C0543d dVar, C1062k kVar) {
        m291a(set, -1, (Uri) null, dVar, kVar);
    }

    /* renamed from: a */
    public static void m293a(Set<C0547g> set, C1062k kVar) {
        m291a(set, -1, (Uri) null, C0543d.UNSPECIFIED, kVar);
    }

    /* renamed from: a */
    public static boolean m294a(C1166t tVar) {
        if (tVar != null) {
            return tVar.mo9700c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m295b() {
        f213a.setTimeZone(TimeZone.getDefault());
        return f213a.format(new Date());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = (r1 = r1.mo7837l()).mo7889a();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m296b(com.applovin.impl.p018a.C0536a r1) {
        /*
            r0 = 0
            if (r1 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.a.j r1 = r1.mo7837l()
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = r1.mo7889a()
            if (r1 == 0) goto L_0x0017
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p018a.C0549i.m296b(com.applovin.impl.a.a):boolean");
    }

    /* renamed from: b */
    public static boolean m297b(C1166t tVar) {
        if (tVar != null) {
            return tVar.mo9700c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m298c(C0536a aVar) {
        C0541b n;
        C0544e b;
        if (aVar == null || (n = aVar.mo7839n()) == null || (b = n.mo7855b()) == null) {
            return false;
        }
        return b.mo7873b() != null || C1155o.m2673b(b.mo7874c());
    }
}
