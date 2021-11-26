package com.applovin.impl.sdk.p037c;

import android.net.Uri;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.p018a.C0550j;
import com.applovin.sdk.AppLovinAdSize;
import com.mopub.mobileads.VastVideoViewController;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.c.b */
public class C0965b<T> implements Comparable {

    /* renamed from: T */
    public static final C0965b<Boolean> f1568T;

    /* renamed from: U */
    public static final C0965b<String> f1569U = m1746a("device_id", "");

    /* renamed from: V */
    public static final C0965b<Boolean> f1570V;

    /* renamed from: W */
    public static final C0965b<String> f1571W = m1746a("device_token", "");

    /* renamed from: X */
    public static final C0965b<Long> f1572X = m1746a("publisher_id", 0L);

    /* renamed from: Y */
    public static final C0965b<Boolean> f1573Y;

    /* renamed from: Z */
    public static final C0965b<String> f1574Z = m1746a("sc", "");

    /* renamed from: a */
    private static final List<?> f1575a;

    /* renamed from: aA */
    public static final C0965b<String> f1576aA = m1746a("text_alert_consent_title", "Make this App Better and Stay Free!");

    /* renamed from: aB */
    public static final C0965b<String> f1577aB = m1746a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");

    /* renamed from: aC */
    public static final C0965b<String> f1578aC = m1746a("text_alert_consent_yes_option", "I Agree");

    /* renamed from: aD */
    public static final C0965b<String> f1579aD = m1746a("text_alert_consent_no_option", "Cancel");

    /* renamed from: aE */
    public static final C0965b<Long> f1580aE = m1746a("ttc_max_click_duration_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: aF */
    public static final C0965b<Integer> f1581aF = m1746a("ttc_max_click_distance_dp", 10);

    /* renamed from: aG */
    public static final C0965b<Integer> f1582aG = m1746a("ttc_acrs", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.DISABLED.ordinal()));

    /* renamed from: aH */
    public static final C0965b<Integer> f1583aH = m1746a("ttc_acrsv2a", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN.ordinal()));

    /* renamed from: aI */
    public static final C0965b<Integer> f1584aI = m1746a("ttc_edge_buffer_dp", 0);

    /* renamed from: aJ */
    public static final C0965b<String> f1585aJ = m1746a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");

    /* renamed from: aK */
    public static final C0965b<String> f1586aK = m1746a("fetch_settings_endpoint", "https://ms.applovin.com/");

    /* renamed from: aL */
    public static final C0965b<String> f1587aL = m1746a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aM */
    public static final C0965b<String> f1588aM = m1746a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: aN */
    public static final C0965b<String> f1589aN = m1746a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: aO */
    public static final C0965b<String> f1590aO = m1746a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: aP */
    public static final C0965b<String> f1591aP = m1746a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: aQ */
    public static final C0965b<String> f1592aQ = m1746a("event_tracking_endpoint_v2", "https://rt.applovin.com/");

    /* renamed from: aR */
    public static final C0965b<String> f1593aR = m1746a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");

    /* renamed from: aS */
    public static final C0965b<String> f1594aS = m1746a("fetch_variables_endpoint", "https://ms.applovin.com/");

    /* renamed from: aT */
    public static final C0965b<String> f1595aT = m1746a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aU */
    public static final C0965b<String> f1596aU = m1746a("token_type_prefixes_r", "4!");

    /* renamed from: aV */
    public static final C0965b<String> f1597aV = m1746a("token_type_prefixes_arj", "json_v3!");

    /* renamed from: aW */
    public static final C0965b<String> f1598aW = m1746a("top_level_events", "landing,paused,resumed,ref,rdf,checkout,iap");

    /* renamed from: aX */
    public static final C0965b<String> f1599aX;

    /* renamed from: aY */
    public static final C0965b<Boolean> f1600aY;

    /* renamed from: aZ */
    public static final C0965b<Integer> f1601aZ = m1746a("super_property_string_max_length", 1024);

    /* renamed from: aa */
    public static final C0965b<String> f1602aa = m1746a("sc2", "");

    /* renamed from: ab */
    public static final C0965b<String> f1603ab = m1746a("sc3", "");

    /* renamed from: ac */
    public static final C0965b<String> f1604ac = m1746a("server_installed_at", "");

    /* renamed from: ad */
    public static final C0965b<Boolean> f1605ad;

    /* renamed from: ae */
    public static final C0965b<Boolean> f1606ae;

    /* renamed from: af */
    public static final C0965b<Boolean> f1607af;

    /* renamed from: ag */
    public static final C0965b<Boolean> f1608ag;

    /* renamed from: ah */
    public static final C0965b<Long> f1609ah = m1746a("sicd_ms", 0L);

    /* renamed from: ai */
    public static final C0965b<Integer> f1610ai = m1746a("logcat_max_line_size", 1000);

    /* renamed from: aj */
    public static final C0965b<Integer> f1611aj = m1746a("stps", 32);

    /* renamed from: ak */
    public static final C0965b<Boolean> f1612ak;

    /* renamed from: al */
    public static final C0965b<Boolean> f1613al;

    /* renamed from: am */
    public static final C0965b<Boolean> f1614am;

    /* renamed from: an */
    public static final C0965b<String> f1615an = m1746a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");

    /* renamed from: ao */
    public static final C0965b<Boolean> f1616ao;

    /* renamed from: ap */
    public static final C0965b<Long> f1617ap = m1746a("consent_dialog_show_from_alert_delay_ms", 450L);

    /* renamed from: aq */
    public static final C0965b<Boolean> f1618aq;

    /* renamed from: ar */
    public static final C0965b<Boolean> f1619ar;

    /* renamed from: as */
    public static final C0965b<Boolean> f1620as;

    /* renamed from: at */
    public static final C0965b<Boolean> f1621at;

    /* renamed from: au */
    public static final C0965b<Long> f1622au;

    /* renamed from: av */
    public static final C0965b<Long> f1623av;

    /* renamed from: aw */
    public static final C0965b<Long> f1624aw;

    /* renamed from: ax */
    public static final C0965b<Long> f1625ax;

    /* renamed from: ay */
    public static final C0965b<Long> f1626ay;

    /* renamed from: az */
    public static final C0965b<Long> f1627az;

    /* renamed from: b */
    private static final Map<String, C0965b<?>> f1628b = new HashMap(512);

    /* renamed from: bA */
    public static final C0965b<Boolean> f1629bA;

    /* renamed from: bB */
    public static final C0965b<Long> f1630bB;

    /* renamed from: bC */
    public static final C0965b<Integer> f1631bC = m1746a("viewability_adview_banner_min_width", 320);

    /* renamed from: bD */
    public static final C0965b<Integer> f1632bD = m1746a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));

    /* renamed from: bE */
    public static final C0965b<Integer> f1633bE;

    /* renamed from: bF */
    public static final C0965b<Integer> f1634bF;

    /* renamed from: bG */
    public static final C0965b<Integer> f1635bG = m1746a("viewability_adview_leader_min_width", 728);

    /* renamed from: bH */
    public static final C0965b<Integer> f1636bH = m1746a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));

    /* renamed from: bI */
    public static final C0965b<Float> f1637bI = m1746a("viewability_adview_min_alpha", Float.valueOf(10.0f));

    /* renamed from: bJ */
    public static final C0965b<Long> f1638bJ;

    /* renamed from: bK */
    public static final C0965b<Long> f1639bK = m1746a("viewability_timer_interval_ms", 100L);

    /* renamed from: bL */
    public static final C0965b<Integer> f1640bL = m1746a("expandable_close_button_size", 27);

    /* renamed from: bM */
    public static final C0965b<Integer> f1641bM = m1746a("expandable_h_close_button_margin", 10);

    /* renamed from: bN */
    public static final C0965b<Integer> f1642bN = m1746a("expandable_t_close_button_margin", 10);

    /* renamed from: bO */
    public static final C0965b<Boolean> f1643bO;

    /* renamed from: bP */
    public static final C0965b<Integer> f1644bP = m1746a("expandable_close_button_touch_area", 0);

    /* renamed from: bQ */
    public static final C0965b<Boolean> f1645bQ;

    /* renamed from: bR */
    public static final C0965b<Integer> f1646bR = m1746a("auxiliary_operations_threads", 3);

    /* renamed from: bS */
    public static final C0965b<Integer> f1647bS = m1746a("caching_operations_threads", 8);

    /* renamed from: bT */
    public static final C0965b<Long> f1648bT;

    /* renamed from: bU */
    public static final C0965b<Long> f1649bU = m1746a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(2)));

    /* renamed from: bV */
    public static final C0965b<Boolean> f1650bV;

    /* renamed from: bW */
    public static final C0965b<Integer> f1651bW = m1746a("close_button_right_margin_video", 4);

    /* renamed from: bX */
    public static final C0965b<Integer> f1652bX = m1746a("close_button_size_video", 30);

    /* renamed from: bY */
    public static final C0965b<Integer> f1653bY = m1746a("close_button_top_margin_video", 8);

    /* renamed from: bZ */
    public static final C0965b<Boolean> f1654bZ;

    /* renamed from: ba */
    public static final C0965b<Integer> f1655ba = m1746a("super_property_url_max_length", 1024);

    /* renamed from: bb */
    public static final C0965b<Long> f1656bb;

    /* renamed from: bc */
    public static final C0965b<Boolean> f1657bc;

    /* renamed from: bd */
    public static final C0965b<Boolean> f1658bd;

    /* renamed from: be */
    public static final C0965b<Long> f1659be = m1746a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

    /* renamed from: bf */
    public static final C0965b<Integer> f1660bf = m1746a("cache_max_size_mb", -1);

    /* renamed from: bg */
    public static final C0965b<String> f1661bg = m1746a("precache_delimiters", ")]',");

    /* renamed from: bh */
    public static final C0965b<Boolean> f1662bh;

    /* renamed from: bi */
    public static final C0965b<Boolean> f1663bi;

    /* renamed from: bj */
    public static final C0965b<String> f1664bj = m1746a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: bk */
    public static final C0965b<String> f1665bk = m1746a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");

    /* renamed from: bl */
    public static final C0965b<Integer> f1666bl = m1746a("vr_retry_count_v1", 1);

    /* renamed from: bm */
    public static final C0965b<Integer> f1667bm = m1746a("cr_retry_count_v1", 1);

    /* renamed from: bn */
    public static final C0965b<Boolean> f1668bn;

    /* renamed from: bo */
    public static final C0965b<String> f1669bo = m1746a("text_incent_warning_title", "Attention!");

    /* renamed from: bp */
    public static final C0965b<String> f1670bp = m1746a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: bq */
    public static final C0965b<String> f1671bq = m1746a("text_incent_warning_close_option", "Close");

    /* renamed from: br */
    public static final C0965b<String> f1672br = m1746a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: bs */
    public static final C0965b<Boolean> f1673bs;

    /* renamed from: bt */
    public static final C0965b<String> f1674bt = m1746a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: bu */
    public static final C0965b<String> f1675bu = m1746a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: bv */
    public static final C0965b<String> f1676bv = m1746a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: bw */
    public static final C0965b<String> f1677bw = m1746a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: bx */
    public static final C0965b<Boolean> f1678bx;

    /* renamed from: by */
    public static final C0965b<Integer> f1679by = m1746a("close_button_touch_area", 0);

    /* renamed from: bz */
    public static final C0965b<Integer> f1680bz = m1746a("close_button_outside_touch_area", 0);

    /* renamed from: cA */
    public static final C0965b<Integer> f1681cA = m1746a("progress_bar_vertical_padding", -8);

    /* renamed from: cB */
    public static final C0965b<Long> f1682cB = m1746a("video_resume_delay", 250L);

    /* renamed from: cC */
    public static final C0965b<Boolean> f1683cC;

    /* renamed from: cD */
    public static final C0965b<Integer> f1684cD = m1746a("vs_buffer_indicator_size", 50);

    /* renamed from: cE */
    public static final C0965b<Boolean> f1685cE;

    /* renamed from: cF */
    public static final C0965b<Long> f1686cF = m1746a("set_poststitial_muted_initial_delay_ms", 500L);

    /* renamed from: cG */
    public static final C0965b<Integer> f1687cG = m1746a("minepsv", 2012000);

    /* renamed from: cH */
    public static final C0965b<Integer> f1688cH = m1746a("maxepsv", -1);

    /* renamed from: cI */
    public static final C0965b<Boolean> f1689cI;

    /* renamed from: cJ */
    public static final C0965b<Integer> f1690cJ;

    /* renamed from: cK */
    public static final C0965b<Integer> f1691cK = m1746a("submit_postback_retries", 4);

    /* renamed from: cL */
    public static final C0965b<Integer> f1692cL = m1746a("max_postback_attempts", 3);

    /* renamed from: cM */
    public static final C0965b<Boolean> f1693cM;

    /* renamed from: cN */
    public static final C0965b<Boolean> f1694cN;

    /* renamed from: cO */
    public static final C0965b<Integer> f1695cO;

    /* renamed from: cP */
    public static final C0965b<Integer> f1696cP;

    /* renamed from: cQ */
    public static final C0965b<Integer> f1697cQ;

    /* renamed from: cR */
    public static final C0965b<Boolean> f1698cR;

    /* renamed from: cS */
    public static final C0965b<Integer> f1699cS;

    /* renamed from: cT */
    public static final C0965b<Integer> f1700cT = m1746a("fetch_ad_retry_count_v1", 1);

    /* renamed from: cU */
    public static final C0965b<Boolean> f1701cU;

    /* renamed from: cV */
    public static final C0965b<Boolean> f1702cV;

    /* renamed from: cW */
    public static final C0965b<Integer> f1703cW = m1746a("submit_data_retry_count_v1", 1);

    /* renamed from: cX */
    public static final C0965b<Integer> f1704cX = m1746a("response_buffer_size", Integer.valueOf(VastVideoViewController.MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON));

    /* renamed from: cY */
    public static final C0965b<Integer> f1705cY;

    /* renamed from: cZ */
    public static final C0965b<Integer> f1706cZ = m1746a("fetch_basic_settings_retry_count", 3);

    /* renamed from: ca */
    public static final C0965b<Integer> f1707ca = m1746a("video_countdown_clock_margin", 10);

    /* renamed from: cb */
    public static final C0965b<Integer> f1708cb = m1746a("video_countdown_clock_gravity", 83);

    /* renamed from: cc */
    public static final C0965b<Integer> f1709cc = m1746a("countdown_clock_size", 32);

    /* renamed from: cd */
    public static final C0965b<Integer> f1710cd = m1746a("countdown_clock_stroke_size", 4);

    /* renamed from: ce */
    public static final C0965b<Integer> f1711ce = m1746a("countdown_clock_text_size", 28);

    /* renamed from: cf */
    public static final C0965b<Boolean> f1712cf;

    /* renamed from: cg */
    public static final C0965b<Boolean> f1713cg;

    /* renamed from: ch */
    public static final C0965b<Boolean> f1714ch;

    /* renamed from: ci */
    public static final C0965b<Boolean> f1715ci;

    /* renamed from: cj */
    public static final C0965b<Long> f1716cj = m1746a("inter_display_delay", 200L);

    /* renamed from: ck */
    public static final C0965b<Boolean> f1717ck;

    /* renamed from: cl */
    public static final C0965b<Boolean> f1718cl;

    /* renamed from: cm */
    public static final C0965b<String> f1719cm = m1746a("soft_buttons_resource_id", "config_showNavigationBar");

    /* renamed from: cn */
    public static final C0965b<Boolean> f1720cn;

    /* renamed from: co */
    public static final C0965b<Boolean> f1721co;

    /* renamed from: cp */
    public static final C0965b<Boolean> f1722cp;

    /* renamed from: cq */
    public static final C0965b<Boolean> f1723cq;

    /* renamed from: cr */
    public static final C0965b<Boolean> f1724cr;

    /* renamed from: cs */
    public static final C0965b<Boolean> f1725cs;

    /* renamed from: ct */
    public static final C0965b<Boolean> f1726ct;

    /* renamed from: cu */
    public static final C0965b<Integer> f1727cu = m1746a("mute_button_size", 32);

    /* renamed from: cv */
    public static final C0965b<Integer> f1728cv = m1746a("mute_button_margin", 10);

    /* renamed from: cw */
    public static final C0965b<Integer> f1729cw = m1746a("mute_button_gravity", 85);

    /* renamed from: cx */
    public static final C0965b<Boolean> f1730cx;

    /* renamed from: cy */
    public static final C0965b<Long> f1731cy = m1746a("progress_bar_step", 25L);

    /* renamed from: cz */
    public static final C0965b<Integer> f1732cz = m1746a("progress_bar_scale", 10000);

    /* renamed from: dA */
    public static final C0965b<Boolean> f1733dA;

    /* renamed from: dB */
    public static final C0965b<Boolean> f1734dB;

    /* renamed from: dC */
    public static final C0965b<Boolean> f1735dC;

    /* renamed from: dD */
    public static final C0965b<Boolean> f1736dD;

    /* renamed from: dE */
    public static final C0965b<Boolean> f1737dE;

    /* renamed from: dF */
    public static final C0965b<Float> f1738dF = m1746a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: dG */
    public static final C0965b<Boolean> f1739dG;

    /* renamed from: dH */
    public static final C0965b<Boolean> f1740dH;

    /* renamed from: dI */
    public static final C0965b<Boolean> f1741dI;

    /* renamed from: dJ */
    public static final C0965b<String> f1742dJ = m1746a("webview_package_name", "com.google.android.webview");

    /* renamed from: dK */
    public static final C0965b<Boolean> f1743dK;

    /* renamed from: dL */
    public static final C0965b<Boolean> f1744dL;

    /* renamed from: dM */
    public static final C0965b<Float> f1745dM = m1746a("movement_degradation", Float.valueOf(0.75f));

    /* renamed from: dN */
    public static final C0965b<Integer> f1746dN = m1746a("device_sensor_period_ms", 250);

    /* renamed from: dO */
    public static final C0965b<Boolean> f1747dO;

    /* renamed from: dP */
    public static final C0965b<Boolean> f1748dP;

    /* renamed from: dQ */
    public static final C0965b<Long> f1749dQ = m1746a("anr_debug_thread_refresh_time_ms", -1L);

    /* renamed from: dR */
    public static final C0965b<Boolean> f1750dR;

    /* renamed from: dS */
    public static final C0965b<Boolean> f1751dS;

    /* renamed from: dT */
    public static final C0965b<Integer> f1752dT;

    /* renamed from: dU */
    public static final C0965b<Integer> f1753dU = m1746a("submit_ad_stats_retry_count", 1);

    /* renamed from: dV */
    public static final C0965b<Integer> f1754dV = m1746a("submit_ad_stats_max_count", 500);

    /* renamed from: dW */
    public static final C0965b<Boolean> f1755dW;

    /* renamed from: dX */
    public static final C0965b<Boolean> f1756dX;

    /* renamed from: dY */
    public static final C0965b<Integer> f1757dY = m1746a("error_reporting_log_limit", 100);

    /* renamed from: dZ */
    public static final C0965b<String> f1758dZ = m1746a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: da */
    public static final C0965b<Boolean> f1759da;

    /* renamed from: db */
    public static final C0965b<Boolean> f1760db;

    /* renamed from: dc */
    public static final C0965b<Integer> f1761dc;

    /* renamed from: dd */
    public static final C0965b<Integer> f1762dd;

    /* renamed from: de */
    public static final C0965b<Boolean> f1763de;

    /* renamed from: df */
    public static final C0965b<Boolean> f1764df;

    /* renamed from: dg */
    public static final C0965b<Boolean> f1765dg;

    /* renamed from: dh */
    public static final C0965b<Integer> f1766dh = m1746a("ad_session_minutes", 60);

    /* renamed from: di */
    public static final C0965b<Boolean> f1767di;

    /* renamed from: dj */
    public static final C0965b<Long> f1768dj = m1746a("session_tracking_resumed_cooldown_minutes", 90L);

    /* renamed from: dk */
    public static final C0965b<Long> f1769dk = m1746a("session_tracking_paused_cooldown_minutes", 90L);

    /* renamed from: dl */
    public static final C0965b<Boolean> f1770dl;

    /* renamed from: dm */
    public static final C0965b<Boolean> f1771dm;

    /* renamed from: dn */
    public static final C0965b<Boolean> f1772dn;

    /* renamed from: do */
    public static final C0965b<Boolean> f1773do;

    /* renamed from: dp */
    public static final C0965b<Boolean> f1774dp;

    /* renamed from: dq */
    public static final C0965b<Boolean> f1775dq;

    /* renamed from: dr */
    public static final C0965b<Boolean> f1776dr;

    /* renamed from: ds */
    public static final C0965b<Boolean> f1777ds;

    /* renamed from: dt */
    public static final C0965b<Boolean> f1778dt;

    /* renamed from: du */
    public static final C0965b<String> f1779du = m1746a("plugin_version", "");

    /* renamed from: dv */
    public static final C0965b<Boolean> f1780dv;

    /* renamed from: dw */
    public static final C0965b<Boolean> f1781dw;

    /* renamed from: dx */
    public static final C0965b<Boolean> f1782dx;

    /* renamed from: dy */
    public static final C0965b<Boolean> f1783dy;

    /* renamed from: dz */
    public static final C0965b<Boolean> f1784dz;

    /* renamed from: eA */
    public static final C0965b<Boolean> f1785eA;

    /* renamed from: eB */
    public static final C0965b<Boolean> f1786eB;

    /* renamed from: eC */
    public static final C0965b<Boolean> f1787eC;

    /* renamed from: eD */
    public static final C0965b<Boolean> f1788eD;

    /* renamed from: eE */
    public static final C0965b<Boolean> f1789eE;

    /* renamed from: eF */
    public static final C0965b<Boolean> f1790eF;

    /* renamed from: eG */
    public static final C0965b<Boolean> f1791eG;

    /* renamed from: eH */
    public static final C0965b<Boolean> f1792eH;

    /* renamed from: eI */
    public static final C0965b<Boolean> f1793eI;

    /* renamed from: eJ */
    public static final C0965b<Integer> f1794eJ = m1746a("mmbfas", -1);

    /* renamed from: eK */
    public static final C0965b<Boolean> f1795eK;

    /* renamed from: eL */
    public static final C0965b<String> f1796eL = m1746a("config_consent_dialog_state", "unknown");

    /* renamed from: eM */
    public static final C0965b<String> f1797eM = m1746a("country_code", "");

    /* renamed from: eN */
    public static final C0965b<String> f1798eN = m1746a("c_sticky_topics", "adjust_init,safedk_init,max_ad_events,send_http_request,adapter_initialization_status,privacy_setting_updated");

    /* renamed from: eO */
    public static final C0965b<Boolean> f1799eO;

    /* renamed from: eP */
    public static final C0965b<String> f1800eP = m1746a("zt_endpoint", "https://a.applovin.com/");

    /* renamed from: eQ */
    public static final C0965b<String> f1801eQ = m1746a("zt_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: eR */
    public static final C0965b<Integer> f1802eR = m1746a("zt_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: eS */
    public static final C0965b<Long> f1803eS = m1746a("zt_flush_interval_s", -1L);

    /* renamed from: eT */
    public static final C0965b<Boolean> f1804eT;

    /* renamed from: eU */
    public static final C0965b<Boolean> f1805eU;

    /* renamed from: eV */
    public static final C0965b<Boolean> f1806eV;

    /* renamed from: eW */
    public static final C0965b<Boolean> f1807eW;

    /* renamed from: ea */
    public static final C0965b<String> f1808ea = m1746a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: eb */
    public static final C0965b<Integer> f1809eb = m1746a("vast_max_response_length", 640000);

    /* renamed from: ec */
    public static final C0965b<Integer> f1810ec = m1746a("vast_max_wrapper_depth", 5);

    /* renamed from: ed */
    public static final C0965b<Long> f1811ed;

    /* renamed from: ee */
    public static final C0965b<String> f1812ee = m1746a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: ef */
    public static final C0965b<String> f1813ef = m1746a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: eg */
    public static final C0965b<Boolean> f1814eg;

    /* renamed from: eh */
    public static final C0965b<Integer> f1815eh = m1746a("vast_video_selection_policy", Integer.valueOf(C0550j.C0552a.MEDIUM.ordinal()));

    /* renamed from: ei */
    public static final C0965b<Integer> f1816ei = m1746a("vast_wrapper_resolution_retry_count_v1", 1);

    /* renamed from: ej */
    public static final C0965b<Integer> f1817ej;

    /* renamed from: ek */
    public static final C0965b<Boolean> f1818ek;

    /* renamed from: el */
    public static final C0965b<Boolean> f1819el;

    /* renamed from: em */
    public static final C0965b<Long> f1820em = m1746a("server_timestamp_ms", (Long) null);

    /* renamed from: en */
    public static final C0965b<Long> f1821en = m1746a("device_timestamp_ms", (Long) null);

    /* renamed from: eo */
    public static final C0965b<Integer> f1822eo = m1746a("gzip_min_length", 0);

    /* renamed from: ep */
    public static final C0965b<Boolean> f1823ep;

    /* renamed from: eq */
    public static final C0965b<Boolean> f1824eq;

    /* renamed from: er */
    public static final C0965b<Boolean> f1825er;

    /* renamed from: es */
    public static final C0965b<Boolean> f1826es;

    /* renamed from: et */
    public static final C0965b<Boolean> f1827et;

    /* renamed from: eu */
    public static final C0965b<Boolean> f1828eu;

    /* renamed from: ev */
    public static final C0965b<Boolean> f1829ev;

    /* renamed from: ew */
    public static final C0965b<Boolean> f1830ew;

    /* renamed from: ex */
    public static final C0965b<Boolean> f1831ex;

    /* renamed from: ey */
    public static final C0965b<Boolean> f1832ey;

    /* renamed from: ez */
    public static final C0965b<Boolean> f1833ez;

    /* renamed from: c */
    private final String f1834c;

    /* renamed from: d */
    private final T f1835d;

    static {
        Class<String> cls = String.class;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        Class<Float> cls4 = Float.class;
        f1575a = Arrays.asList(new Class[]{Boolean.class, cls4, cls3, cls2, cls});
        Boolean bool = Boolean.FALSE;
        f1568T = m1746a("is_disabled", bool);
        Boolean bool2 = Boolean.TRUE;
        f1570V = m1746a("rss", bool2);
        f1573Y = m1746a("is_verbose_logging", bool);
        f1605ad = m1746a("track_network_response_codes", bool);
        f1606ae = m1746a("submit_network_response_codes", bool);
        f1607af = m1746a("clear_network_response_codes_on_request", bool2);
        f1608ag = m1746a("clear_completion_callback_on_failure", bool);
        f1612ak = m1746a("ustp", bool);
        f1613al = m1746a("exception_handler_enabled", bool2);
        f1614am = m1746a("publisher_can_show_consent_dialog", bool2);
        f1616ao = m1746a("consent_dialog_immersive_mode_on", bool);
        f1618aq = m1746a("alert_consent_for_dialog_rejected", bool);
        f1619ar = m1746a("alert_consent_for_dialog_closed", bool);
        f1620as = m1746a("alert_consent_for_dialog_closed_with_back_button", bool);
        f1621at = m1746a("alert_consent_after_init", bool);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f1622au = m1746a("alert_consent_after_init_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1623av = m1746a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(timeUnit.toMillis(30)));
        f1624aw = m1746a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1625ax = m1746a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1626ay = m1746a("alert_consent_after_cancel_interval_ms", Long.valueOf(timeUnit.toMillis(10)));
        f1627az = m1746a("alert_consent_reschedule_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1599aX = m1746a("valid_super_property_types", cls.getName() + "," + cls3.getName() + "," + cls2.getName() + "," + Double.class.getName() + "," + cls4.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());
        Boolean bool3 = Boolean.TRUE;
        f1600aY = m1746a("persist_super_properties", bool3);
        f1656bb = m1746a("cached_advertising_info_ttl_ms", Long.valueOf(timeUnit.toMillis(10)));
        f1657bc = m1746a("use_per_format_cache_queues", bool3);
        Boolean bool4 = Boolean.FALSE;
        f1658bd = m1746a("cache_cleanup_enabled", bool4);
        f1662bh = m1746a("ad_resource_caching_enabled", bool3);
        f1663bi = m1746a("fail_ad_load_on_failed_video_cache", bool3);
        f1668bn = m1746a("incent_warning_enabled", bool4);
        f1673bs = m1746a("incent_nonvideo_warning_enabled", bool4);
        f1678bx = m1746a("check_webview_has_gesture", bool4);
        f1629bA = m1746a("creative_debugger_enabled", bool4);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        f1630bB = m1746a("viewability_adview_imp_delay_ms", Long.valueOf(timeUnit2.toMillis(1)));
        AppLovinAdSize appLovinAdSize = AppLovinAdSize.MREC;
        f1633bE = m1746a("viewability_adview_mrec_min_width", Integer.valueOf(appLovinAdSize.getWidth()));
        f1634bF = m1746a("viewability_adview_mrec_min_height", Integer.valueOf(appLovinAdSize.getHeight()));
        f1638bJ = m1746a("viewability_timer_min_visible_ms", Long.valueOf(timeUnit2.toMillis(1)));
        f1643bO = m1746a("expandable_lhs_close_button", bool4);
        f1645bQ = m1746a("iaad", bool4);
        f1648bT = m1746a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(timeUnit2.toMillis(10)));
        Boolean bool5 = Boolean.FALSE;
        f1650bV = m1746a("lhs_close_button_video", bool5);
        Boolean bool6 = Boolean.TRUE;
        f1654bZ = m1746a("show_close_on_exit", bool6);
        f1712cf = m1746a("draw_countdown_clock", bool6);
        f1713cg = m1746a("force_back_button_enabled_always", bool5);
        f1714ch = m1746a("force_back_button_enabled_close_button", bool5);
        f1715ci = m1746a("force_back_button_enabled_poststitial", bool5);
        f1717ck = m1746a("lock_specific_orientation", bool5);
        f1718cl = m1746a("lhs_skip_button", bool6);
        f1720cn = m1746a("countdown_toggleable", bool5);
        f1721co = m1746a("track_app_killed", bool5);
        f1722cp = m1746a("mute_controls_enabled", bool5);
        f1723cq = m1746a("allow_user_muting", bool6);
        f1724cr = m1746a("mute_videos", bool5);
        f1725cs = m1746a("show_mute_by_default", bool5);
        f1726ct = m1746a("mute_with_user_settings", bool6);
        f1730cx = m1746a("video_immersive_mode_enabled", bool5);
        f1683cC = m1746a("is_video_skippable", bool5);
        f1685cE = m1746a("video_zero_length_as_computed", bool5);
        f1689cI = m1746a("pctfnc", bool5);
        TimeUnit timeUnit3 = TimeUnit.SECONDS;
        f1690cJ = m1746a("submit_postback_timeout", Integer.valueOf((int) timeUnit3.toMillis(10)));
        f1693cM = m1746a("fppopq", bool5);
        f1694cN = m1746a("retry_on_all_errors", bool5);
        f1695cO = m1746a("get_retry_delay_v1", Integer.valueOf((int) timeUnit3.toMillis(10)));
        f1696cP = m1746a("http_connection_timeout", Integer.valueOf((int) timeUnit3.toMillis(30)));
        f1697cQ = m1746a("http_socket_timeout", Integer.valueOf((int) timeUnit3.toMillis(20)));
        Boolean bool7 = Boolean.FALSE;
        f1698cR = m1746a("force_ssl", bool7);
        f1699cS = m1746a("fetch_ad_connection_timeout", Integer.valueOf((int) timeUnit3.toMillis(30)));
        f1701cU = m1746a("faer", bool7);
        f1702cV = m1746a("faroae", bool7);
        f1705cY = m1746a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) timeUnit3.toMillis(10)));
        f1759da = m1746a("fetch_basic_settings_on_reconnect", bool7);
        f1760db = m1746a("skip_fetch_basic_settings_if_not_connected", bool7);
        f1761dc = m1746a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) timeUnit3.toMillis(2)));
        f1762dd = m1746a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) timeUnit3.toMillis(5)));
        f1763de = m1746a("idflrwbe", bool7);
        f1764df = m1746a("falawpr", bool7);
        f1765dg = m1746a("sort_query_parameters", bool7);
        Boolean bool8 = Boolean.TRUE;
        f1767di = m1746a("session_tracking_cooldown_on_event_fire", bool8);
        f1770dl = m1746a("qq", bool7);
        f1771dm = m1746a("qq1", bool8);
        f1772dn = m1746a("qq3", bool8);
        f1773do = m1746a("qq4", bool8);
        f1774dp = m1746a("qq5", bool8);
        f1775dq = m1746a("qq6", bool8);
        f1776dr = m1746a("qq7", bool8);
        f1777ds = m1746a("qq8", bool8);
        f1778dt = m1746a("pui", bool8);
        f1780dv = m1746a("hgn", bool7);
        f1781dw = m1746a("cso", bool7);
        f1782dx = m1746a("cfs", bool7);
        f1783dy = m1746a("cmi", bool7);
        f1784dz = m1746a("crat", bool7);
        f1733dA = m1746a("cvs", bool7);
        f1734dB = m1746a("caf", bool7);
        f1735dC = m1746a("cf", bool7);
        f1736dD = m1746a("cnr", bool7);
        f1737dE = m1746a("adr", bool7);
        f1739dG = m1746a("system_user_agent_collection_enabled", bool7);
        f1740dH = m1746a("user_agent_collection_enabled", bool7);
        f1741dI = m1746a("http_headers_collection_enabled", bool7);
        f1743dK = m1746a("collect_device_angle", bool7);
        f1744dL = m1746a("collect_device_movement", bool7);
        f1747dO = m1746a("dte", bool8);
        Boolean bool9 = Boolean.FALSE;
        f1748dP = m1746a("idcw", bool9);
        f1750dR = m1746a("is_track_ad_info", bool8);
        f1751dS = m1746a("submit_ad_stats_enabled", bool9);
        TimeUnit timeUnit4 = TimeUnit.SECONDS;
        f1752dT = m1746a("submit_ad_stats_connection_timeout", Integer.valueOf((int) timeUnit4.toMillis(30)));
        f1755dW = m1746a("asdm", bool9);
        f1756dX = m1746a("error_reporting_enabled", bool9);
        f1811ed = m1746a("vast_progress_tracking_countdown_step", Long.valueOf(timeUnit4.toMillis(1)));
        Boolean bool10 = Boolean.TRUE;
        f1814eg = m1746a("vast_validate_with_extension_if_no_video_type", bool10);
        f1817ej = m1746a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) timeUnit4.toMillis(30)));
        f1818ek = m1746a("ree", bool10);
        f1819el = m1746a("btee", bool10);
        f1823ep = m1746a("gzip_encoding_default", bool9);
        f1824eq = m1746a("fetch_settings_gzip", bool9);
        f1825er = m1746a("device_init_gzip", bool9);
        f1826es = m1746a("fetch_ad_gzip", bool9);
        f1827et = m1746a("event_tracking_gzip", bool9);
        f1828eu = m1746a("submit_ad_stats_gzip", bool9);
        f1829ev = m1746a("reward_postback_gzip", bool9);
        f1830ew = m1746a("zt_flush_gzip", bool9);
        f1831ex = m1746a("force_rerender", bool9);
        f1832ey = m1746a("daostr", bool9);
        f1833ez = m1746a("tctlaa", bool9);
        f1785eA = m1746a("rwvdv", bool9);
        f1786eB = m1746a("handle_render_process_gone", bool10);
        f1787eC = m1746a("comcr", bool10);
        f1788eD = m1746a("gcoas", bool9);
        f1789eE = m1746a("teorpc", bool9);
        f1790eF = m1746a("rmpibt", bool9);
        f1791eG = m1746a("spbcioa", bool9);
        f1792eH = m1746a("set_webview_render_process_client", bool9);
        f1793eI = m1746a("disable_webview_hardware_acceleration", bool9);
        Boolean bool11 = Boolean.FALSE;
        f1795eK = m1746a("fvrunc", bool11);
        f1799eO = m1746a("zt_enabled", bool10);
        f1804eT = m1746a("zt_bg_aware_timer", bool10);
        f1805eU = m1746a("zt_flush_on_impression", bool10);
        f1806eV = m1746a("zt_flush_on_app_bg", bool11);
        f1807eW = m1746a("zt_continue_through_error", bool10);
    }

    public C0965b(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.f1834c = str;
            this.f1835d = t;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    /* renamed from: a */
    protected static <T> C0965b<T> m1746a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (f1575a.contains(t.getClass())) {
            C0965b<T> bVar = new C0965b<>(str, t);
            Map<String, C0965b<?>> map = f1628b;
            if (!map.containsKey(str)) {
                map.put(str, bVar);
                return bVar;
            }
            throw new IllegalArgumentException("Setting has already been used: " + str);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + t.getClass());
        }
    }

    /* renamed from: c */
    public static Collection<C0965b<?>> m1747c() {
        return Collections.synchronizedCollection(f1628b.values());
    }

    /* renamed from: a */
    public T mo9116a(Object obj) {
        return this.f1835d.getClass().cast(obj);
    }

    /* renamed from: a */
    public String mo9117a() {
        return this.f1834c;
    }

    /* renamed from: b */
    public T mo9118b() {
        return this.f1835d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof C0965b)) {
            return 0;
        }
        return this.f1834c.compareTo(((C0965b) obj).mo9117a());
    }
}
