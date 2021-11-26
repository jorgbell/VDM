package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellSignalStrength;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.flurry.sdk.C1519au;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/* renamed from: com.flurry.sdk.av */
public class C1521av extends C1907m<C1519au> {
    protected static long MINIMUM_REFRESH_INTERVAL = 3600000;

    /* renamed from: a */
    private boolean f3840a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f3841b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3842d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1519au.C1520a f3843e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f3844f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f3845g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f3846h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f3847i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f3848j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f3849k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3850l = -1;

    /* renamed from: m */
    private C1916q f3851m;
    protected C1914o<C1920r> mAppStateListener = new C1914o<C1920r>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            if (((C1920r) obj).f4752b == C1915p.FOREGROUND) {
                C1521av.this.refresh();
            }
        }
    };

    /* renamed from: n */
    private BroadcastReceiver f3852n;

    /* renamed from: o */
    private ConnectivityManager.NetworkCallback f3853o;

    /* renamed from: p */
    private PhoneStateListener f3854p;

    /* access modifiers changed from: protected */
    public ConnectivityManager.NetworkCallback getNetworkCallback() {
        if (this.f3853o == null) {
            this.f3853o = new ConnectivityManager.NetworkCallback() {
                public final void onAvailable(Network network) {
                    C1521av.this.runAsync(new C1702eb((SignalStrength) null) {
                        /* renamed from: a */
                        public final void mo11257a() throws Exception {
                            C1521av.this.getCellularData(r2);
                            C1521av.this.refresh();
                        }
                    });
                }

                public final void onLost(Network network) {
                    C1521av.this.runAsync(new C1702eb((SignalStrength) null) {
                        /* renamed from: a */
                        public final void mo11257a() throws Exception {
                            C1521av.this.getCellularData(r2);
                            C1521av.this.refresh();
                        }
                    });
                }
            };
        }
        return this.f3853o;
    }

    /* access modifiers changed from: protected */
    public BroadcastReceiver getNetworkChangeReceiver() {
        if (this.f3852n == null) {
            this.f3852n = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    C1521av.this.runAsync(new C1702eb((SignalStrength) null) {
                        /* renamed from: a */
                        public final void mo11257a() throws Exception {
                            C1521av.this.getCellularData(r2);
                            C1521av.this.refresh();
                        }
                    });
                }
            };
        }
        return this.f3852n;
    }

    /* access modifiers changed from: protected */
    public PhoneStateListener getPhoneStateListener() {
        if (this.f3854p == null) {
            try {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                    Looper.loop();
                }
                this.f3854p = new PhoneStateListener() {

                    /* renamed from: b */
                    private long f3859b;

                    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        super.onSignalStrengthsChanged(signalStrength);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.f3859b > C1521av.MINIMUM_REFRESH_INTERVAL) {
                            this.f3859b = currentTimeMillis;
                            C1521av.this.runAsync(new C1702eb(signalStrength) {
                                /* renamed from: a */
                                public final void mo11257a() throws Exception {
                                    C1521av.this.getCellularData(r2);
                                    C1521av.this.refresh();
                                }
                            });
                        }
                    }
                };
            } catch (Throwable th) {
                C1648cy.m4317a(5, "NetworkProvider", "Failed to initialize PhoneStateListener: " + th.toString());
            }
        }
        return this.f3854p;
    }

    public C1521av(C1916q qVar) {
        super("NetworkProvider");
        if (C1738fd.m4508c()) {
            m4033c();
            this.f3851m = qVar;
            qVar.subscribe(this.mAppStateListener);
            return;
        }
        this.f3841b = true;
        this.f3843e = C1519au.C1520a.NONE_OR_UNKNOWN;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public boolean m4032b() {
        if (!C1738fd.m4508c()) {
            return true;
        }
        ConnectivityManager d = m4035d();
        if (d == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } else if (getNetworkTypeM(d) != C1519au.C1520a.NONE_OR_UNKNOWN) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable th) {
            C1648cy.m4317a(5, "NetworkProvider", "Failed to get Network status: " + th.toString());
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public void getCellularData(SignalStrength signalStrength) {
        TelephonyManager e = m4037e();
        String networkOperatorName = e.getNetworkOperatorName();
        String networkOperator = e.getNetworkOperator();
        String simOperator = e.getSimOperator();
        String simOperatorName = e.getSimOperatorName();
        String str = "";
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                CharSequence simCarrierIdName = e.getSimCarrierIdName();
                if (simCarrierIdName != null) {
                    str = simCarrierIdName.toString();
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        int i = 0;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 24) {
                i = e.getNetworkType();
            } else if (C1738fd.m4509d()) {
                i = e.getDataNetworkType();
            } else if (i2 < 29) {
                i = e.getNetworkType();
            }
        } catch (SecurityException unused2) {
        }
        String num = Integer.toString(i);
        int a = m4022a(signalStrength);
        if (!TextUtils.equals(this.f3844f, networkOperatorName) || !TextUtils.equals(this.f3845g, networkOperator) || !TextUtils.equals(this.f3846h, simOperator) || !TextUtils.equals(this.f3847i, str) || !TextUtils.equals(this.f3848j, simOperatorName) || !TextUtils.equals(this.f3849k, num) || this.f3850l != a) {
            C1648cy.m4317a(3, "NetworkProvider", "Cellular Name: " + networkOperatorName + ", Operator: " + networkOperator + ", Sim Operator: " + simOperator + ", Sim Id: " + str + ", Sim Name: " + simOperatorName + ", Band: " + num + ", Signal Strength: " + a);
            this.f3842d = true;
            this.f3844f = networkOperatorName;
            this.f3845g = networkOperator;
            this.f3846h = simOperator;
            this.f3847i = str;
            this.f3848j = simOperatorName;
            this.f3849k = num;
            this.f3850l = a;
        }
    }

    /* renamed from: a */
    private int m4022a(SignalStrength signalStrength) {
        if (signalStrength == null) {
            return this.f3850l;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                for (CellSignalStrength dbm : signalStrength.getCellSignalStrengths()) {
                    int dbm2 = dbm.getDbm();
                    if (dbm2 != Integer.MAX_VALUE) {
                        return dbm2;
                    }
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        char c = 0;
        try {
            return ((Integer) signalStrength.getClass().getMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            if (signalStrength.isGsm()) {
                int a = m4023a(signalStrength, "getLteDbm", "rsrp", 9);
                if (a != Integer.MAX_VALUE) {
                    return a;
                }
                int a2 = m4023a(signalStrength, "getTdScdmaDbm", "mTdscdma", 14);
                if (a2 <= -25 && a2 != Integer.MAX_VALUE) {
                    if (a2 >= -49) {
                        c = 4;
                    } else if (a2 >= -73) {
                        c = 3;
                    } else if (a2 >= -97) {
                        c = 2;
                    } else if (a2 >= -110) {
                        c = 1;
                    }
                }
                if (c != 0) {
                    return a2;
                }
                int a3 = m4023a(signalStrength, "getWcdmaDbm", "mWcdma", 17);
                if (a3 != Integer.MAX_VALUE) {
                    return a3;
                }
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if ((gsmSignalStrength == 99 ? -1 : gsmSignalStrength) != -1) {
                    return (gsmSignalStrength * 2) - 113;
                }
                return -1;
            }
            int cdmaDbm = signalStrength.getCdmaDbm();
            int evdoDbm = signalStrength.getEvdoDbm();
            return (evdoDbm != -120 && (cdmaDbm == -120 || cdmaDbm >= evdoDbm)) ? evdoDbm : cdmaDbm;
        }
    }

    /* renamed from: a */
    private static int m4023a(SignalStrength signalStrength, String str, String str2, int i) {
        int i2;
        int i3 = Integer.MAX_VALUE;
        try {
            i2 = ((Integer) signalStrength.getClass().getMethod(str, new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            i2 = Integer.MAX_VALUE;
        }
        if (i2 == Integer.MAX_VALUE) {
            String signalStrength2 = signalStrength.toString();
            int indexOf = signalStrength2.indexOf(str2 + "=");
            if (indexOf != -1) {
                Scanner scanner = new Scanner(signalStrength2.substring(indexOf + str2.length() + 1));
                if (scanner.hasNextInt() && (i2 = scanner.nextInt()) == 99) {
                    i2 = Integer.MAX_VALUE;
                }
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        String[] split = signalStrength.toString().split(" ");
        if (split.length <= i) {
            return i2;
        }
        try {
            int parseInt = Integer.parseInt(split[i]);
            if (parseInt != 99) {
                i3 = parseInt;
            }
            return i3;
        } catch (NumberFormatException unused2) {
            return i2;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: c */
    private synchronized void m4033c() {
        if (!this.f3840a) {
            this.f3841b = m4032b();
            this.f3843e = getNetworkType();
            if (Build.VERSION.SDK_INT >= 29) {
                runAsync(new C1702eb() {
                    /* renamed from: a */
                    public final void mo11257a() throws Exception {
                        C1521av.m4035d().registerNetworkCallback(new NetworkRequest.Builder().build(), C1521av.this.getNetworkCallback());
                    }
                });
            } else {
                C1536b.m4057a().registerReceiver(getNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            m4037e().listen(getPhoneStateListener(), 256);
            this.f3840a = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static ConnectivityManager m4035d() {
        return (ConnectivityManager) C1536b.m4057a().getSystemService("connectivity");
    }

    /* renamed from: e */
    private static TelephonyManager m4037e() {
        return (TelephonyManager) C1536b.m4057a().getSystemService("phone");
    }

    /* renamed from: f */
    private synchronized void m4040f() {
        if (this.f3840a) {
            if (this.f3853o != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    m4035d().unregisterNetworkCallback(this.f3853o);
                }
                this.f3853o = null;
            }
            if (this.f3852n != null) {
                C1536b.m4057a().unregisterReceiver(this.f3852n);
                this.f3852n = null;
            }
            if (this.f3854p != null) {
                m4037e().listen(this.f3854p, 0);
                this.f3854p = null;
            }
            this.f3840a = false;
        }
    }

    public void destroy() {
        super.destroy();
        m4040f();
        C1916q qVar = this.f3851m;
        if (qVar != null) {
            qVar.unsubscribe(this.mAppStateListener);
        }
    }

    public boolean isNetworkEnabled() {
        return this.f3841b;
    }

    @SuppressLint({"MissingPermission"})
    public C1519au.C1520a getNetworkType() {
        if (!C1738fd.m4508c()) {
            return C1519au.C1520a.NONE_OR_UNKNOWN;
        }
        ConnectivityManager d = m4035d();
        if (d == null) {
            return C1519au.C1520a.NONE_OR_UNKNOWN;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return getNetworkTypeM(d);
            }
            return getNetworkTypePreM(d);
        } catch (Throwable th) {
            C1648cy.m4317a(5, "NetworkProvider", "Failed to get Network type: " + th.toString());
            return C1519au.C1520a.NONE_OR_UNKNOWN;
        }
    }

    @SuppressLint({"MissingPermission"})
    public C1519au.C1520a getNetworkTypeM(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return C1519au.C1520a.NONE_OR_UNKNOWN;
        }
        if (networkCapabilities.hasTransport(1)) {
            return C1519au.C1520a.WIFI;
        }
        if (networkCapabilities.hasTransport(0)) {
            return C1519au.C1520a.CELL;
        }
        return C1519au.C1520a.NETWORK_AVAILABLE;
    }

    @SuppressLint({"MissingPermission"})
    public C1519au.C1520a getNetworkTypePreM(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C1519au.C1520a.NONE_OR_UNKNOWN;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return C1519au.C1520a.WIFI;
            }
            if (!(type == 2 || type == 3 || type == 4 || type == 5)) {
                if (type != 8) {
                    return C1519au.C1520a.NETWORK_AVAILABLE;
                }
                return C1519au.C1520a.NONE_OR_UNKNOWN;
            }
        }
        return C1519au.C1520a.CELL;
    }

    public static String getCellularBand(int i) {
        switch (i) {
            case 1:
                return "2G - GPRS";
            case 2:
                return "2G - EDGE";
            case 3:
                return "3G - UMTS";
            case 4:
                return "2G - CDMA";
            case 5:
                return "3G - EVDO_0";
            case 6:
                return "3G - EVDO_A";
            case 7:
                return "2G - 1xRTT";
            case 8:
                return "3G - HSDPA";
            case 9:
                return "3G - HSUPA";
            case 10:
                return "3G - HSPA";
            case 11:
                return "2G - IDEN";
            case 12:
                return "3G - EVDO_B";
            case 13:
                return "4G - LTE";
            case 14:
                return "3G - EHRPD";
            case 15:
                return "3G - HSPAP";
            case 16:
                return "2G - GSM";
            case 17:
                return "3G - TD_SCDMA";
            case 18:
                return "4G - IWLAN";
            case 20:
                return "5G - NR";
            default:
                return "Unknown - ".concat(String.valueOf(i));
        }
    }

    public void subscribe(C1914o<C1519au> oVar) {
        super.subscribe(oVar);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1521av avVar = C1521av.this;
                boolean unused = avVar.f3841b = avVar.m4032b();
                C1521av avVar2 = C1521av.this;
                C1519au.C1520a unused2 = avVar2.f3843e = avVar2.getNetworkType();
                C1521av avVar3 = C1521av.this;
                avVar3.notifyObservers(new C1519au(avVar3.f3843e, C1521av.this.f3841b, C1521av.this.f3844f, C1521av.this.f3845g, C1521av.this.f3846h, C1521av.this.f3847i, C1521av.this.f3848j, C1521av.this.f3849k, C1521av.this.f3850l));
            }
        });
    }

    public void refresh() {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                boolean a = C1521av.this.m4032b();
                C1519au.C1520a networkType = C1521av.this.getNetworkType();
                if (C1521av.this.f3841b != a || C1521av.this.f3843e != networkType || C1521av.this.f3842d) {
                    boolean unused = C1521av.this.f3841b = a;
                    C1519au.C1520a unused2 = C1521av.this.f3843e = networkType;
                    boolean unused3 = C1521av.this.f3842d = false;
                    C1521av avVar = C1521av.this;
                    avVar.notifyObservers(new C1519au(avVar.getNetworkType(), C1521av.this.f3841b, C1521av.this.f3844f, C1521av.this.f3845g, C1521av.this.f3846h, C1521av.this.f3847i, C1521av.this.f3848j, C1521av.this.f3849k, C1521av.this.f3850l));
                }
            }
        });
    }
}
