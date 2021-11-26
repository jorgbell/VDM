package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.mopub.mobileads.vungle.BuildConfig;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.AdAssetDBAdapter;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.CookieDBAdapter;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.PlacementDBAdapter;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.VisionData;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.vision.VisionAggregationData;
import com.vungle.warren.vision.VisionAggregationInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Repository {
    /* access modifiers changed from: private */
    public static final String TAG = "Repository";
    /* access modifiers changed from: private */
    public Map<Class, DBAdapter> adapters;
    private final Context appCtx;
    protected DatabaseHelper dbHelper;
    /* access modifiers changed from: private */
    public final Designer designer;
    private final ExecutorService ioExecutor;
    /* access modifiers changed from: private */
    public final ExecutorService uiExecutor;

    public interface LoadCallback<T> {
        void onLoaded(T t);
    }

    public interface SaveCallback {
        void onError(Exception exc);

        void onSaved();
    }

    public Repository(Context context, Designer designer2, ExecutorService executorService, ExecutorService executorService2) {
        this(context, designer2, executorService, executorService2, 6);
    }

    public Repository(Context context, Designer designer2, ExecutorService executorService, ExecutorService executorService2, int i) {
        this.adapters = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.appCtx = applicationContext;
        this.ioExecutor = executorService;
        this.uiExecutor = executorService2;
        this.dbHelper = new DatabaseHelper(context, i, new VungleDatabaseCreator(applicationContext));
        this.designer = designer2;
        this.adapters.put(Placement.class, new PlacementDBAdapter());
        this.adapters.put(Cookie.class, new CookieDBAdapter());
        this.adapters.put(Report.class, new ReportDBAdapter());
        this.adapters.put(Advertisement.class, new AdvertisementDBAdapter());
        this.adapters.put(AdAsset.class, new AdAssetDBAdapter());
        this.adapters.put(VisionData.class, new VisionDataDBAdapter());
    }

    public void init() throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.dbHelper.init();
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", 3);
                Query query = new Query("advertisement");
                query.selection = "state=?";
                query.args = new String[]{String.valueOf(2)};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> List<T> loadAllModels(Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        if (dBAdapter == null) {
            return Collections.EMPTY_LIST;
        }
        return extractModels(cls, this.dbHelper.query(new Query(dBAdapter.tableName())));
    }

    /* access modifiers changed from: private */
    public <T> List<T> extractModels(Class<T> cls, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            DBAdapter dBAdapter = this.adapters.get(cls);
            while (cursor.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                arrayList.add(dBAdapter.fromContentValues(contentValues));
            }
            return arrayList;
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: private */
    public <T> T loadModel(String str, Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        Query query = new Query(dBAdapter.tableName());
        query.selection = "item_id = ? ";
        query.args = new String[]{str};
        Cursor query2 = this.dbHelper.query(query);
        if (query2 == null) {
            return null;
        }
        try {
            if (query2.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                return dBAdapter.fromContentValues(contentValues);
            }
            query2.close();
            return null;
        } finally {
            query2.close();
        }
    }

    /* access modifiers changed from: private */
    public <T> void saveModel(T t) throws DatabaseHelper.DBException {
        DBAdapter dBAdapter = this.adapters.get(t.getClass());
        this.dbHelper.insertWithConflict(dBAdapter.tableName(), dBAdapter.toContentValues(t), 5);
    }

    public <T> FutureResult<T> load(final String str, final Class<T> cls) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<T>() {
            public T call() {
                return Repository.this.loadModel(str, cls);
            }
        }));
    }

    public <T> void load(final String str, final Class<T> cls, final LoadCallback<T> loadCallback) {
        this.ioExecutor.execute(new Runnable() {
            public void run() {
                final Object access$000 = Repository.this.loadModel(str, cls);
                Repository.this.uiExecutor.execute(new Runnable() {
                    public void run() {
                        loadCallback.onLoaded(access$000);
                    }
                });
            }
        });
    }

    public <T> void save(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.saveModel(t);
                return null;
            }
        });
    }

    public <T> void save(final T t, final SaveCallback saveCallback, boolean z) {
        Future<?> submit = this.ioExecutor.submit(new Runnable() {
            public void run() {
                try {
                    Repository.this.saveModel(t);
                    if (saveCallback != null) {
                        Repository.this.uiExecutor.execute(new Runnable() {
                            public void run() {
                                saveCallback.onSaved();
                            }
                        });
                    }
                } catch (DatabaseHelper.DBException e) {
                    if (saveCallback != null) {
                        Repository.this.uiExecutor.execute(new Runnable() {
                            public void run() {
                                saveCallback.onError(e);
                            }
                        });
                    }
                }
            }
        });
        if (z) {
            try {
                submit.get();
            } catch (InterruptedException e) {
                Log.e(TAG, "InterruptedException ", e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                Log.e(TAG, "Error on execution during saving", e2);
            }
        }
    }

    public <T> void save(T t, SaveCallback saveCallback) {
        save(t, saveCallback, true);
    }

    public FutureResult<Advertisement> findValidAdvertisementForPlacement(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Advertisement>() {
            public Advertisement call() {
                String str;
                Log.i(Repository.TAG, " Searching for valid adv for pl " + str);
                Query query = new Query("advertisement");
                query.selection = "placement_id = ? AND (state = ? OR  state = ?) AND expire_time > ?";
                query.args = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
                query.limit = "1";
                query.orderBy = "state DESC";
                Cursor query2 = Repository.this.dbHelper.query(query);
                AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) Repository.this.adapters.get(Advertisement.class);
                ArrayList arrayList = new ArrayList();
                while (query2 != null && advertisementDBAdapter != null && query2.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                    arrayList.add(advertisementDBAdapter.fromContentValues(contentValues));
                }
                if (query2 != null) {
                    query2.close();
                }
                Advertisement advertisement = arrayList.size() > 0 ? (Advertisement) arrayList.get(0) : null;
                String access$300 = Repository.TAG;
                if (advertisement == null) {
                    str = "Didn't find valid adv";
                } else {
                    str = "Found valid adv " + advertisement.getId();
                }
                Log.i(access$300, str);
                return advertisement;
            }
        }));
    }

    public <T> FutureResult<List<T>> loadAll(final Class<T> cls) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<T>>() {
            public List<T> call() {
                return Repository.this.loadAllModels(cls);
            }
        }));
    }

    public FutureResult<List<Report>> loadAllReportToSend() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                List<Report> access$500 = Repository.this.loadAllModels(Report.class);
                for (Report next : access$500) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$500;
            }
        }));
    }

    public FutureResult<List<Report>> loadReadyOrFailedReportToSend() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                Query query = new Query("report");
                query.selection = "status = ?  OR status = ? ";
                query.args = new String[]{String.valueOf(1), String.valueOf(3)};
                List<Report> access$600 = Repository.this.extractModels(Report.class, Repository.this.dbHelper.query(query));
                for (Report next : access$600) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$600;
            }
        }));
    }

    public void updateAndSaveReportState(String str, String str2, int i, int i2) throws DatabaseHelper.DBException {
        final int i3 = i2;
        final String str3 = str;
        final int i4 = i;
        final String str4 = str2;
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i3));
                Query query = new Query("report");
                query.selection = "placementId = ?  AND status = ?  AND appId = ? ";
                query.args = new String[]{str3, String.valueOf(i4), str4};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    public FutureResult<List<AdAsset>> loadAllAdAssets(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<AdAsset>>() {
            public List<AdAsset> call() {
                return Repository.this.loadAllAdAssetModels(str);
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<AdAsset> loadAllAdAssetModels(String str) {
        Query query = new Query("adAsset");
        query.selection = "ad_identifier = ? ";
        query.args = new String[]{str};
        return extractModels(AdAsset.class, this.dbHelper.query(query));
    }

    public <T> void delete(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteModel(t);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(Class<T> cls, String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(cls).tableName());
        query.selection = "item_id=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    private void deleteAssetForAdId(String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(AdAsset.class).tableName());
        query.selection = "ad_identifier=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(T t) throws DatabaseHelper.DBException {
        deleteModel(t.getClass(), this.adapters.get(t.getClass()).toContentValues(t).getAsString("item_id"));
    }

    public void deleteAdvertisement(final String str) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteAdInternal(str);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteAdInternal(String str) throws DatabaseHelper.DBException {
        if (!TextUtils.isEmpty(str)) {
            deleteAssetForAdId(str);
            deleteModel(Advertisement.class, str);
            try {
                this.designer.deleteAssets(str);
            } catch (IOException e) {
                Log.e(TAG, "IOException ", e);
            }
        }
    }

    public FutureResult<Collection<Placement>> loadValidPlacements() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Collection<Placement>>() {
            public List<Placement> call() {
                List<Placement> access$600;
                synchronized (Repository.this) {
                    Query query = new Query("placement");
                    query.selection = "is_valid = ?";
                    query.args = new String[]{"1"};
                    access$600 = Repository.this.extractModels(Placement.class, Repository.this.dbHelper.query(query));
                }
                return access$600;
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<String> loadValidPlacementIds() {
        Query query = new Query("placement");
        query.selection = "is_valid = ?";
        query.args = new String[]{"1"};
        query.columns = new String[]{"item_id"};
        Cursor query2 = this.dbHelper.query(query);
        ArrayList arrayList = new ArrayList();
        if (query2 != null) {
            while (query2 != null) {
                try {
                    if (!query2.moveToNext()) {
                        break;
                    }
                    arrayList.add(query2.getString(query2.getColumnIndex("item_id")));
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
            query2.close();
        }
        return arrayList;
    }

    public FutureResult<File> getAdvertisementAssetDirectory(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<File>() {
            public File call() throws Exception {
                return Repository.this.designer.getAssetDirectory(str);
            }
        }));
    }

    public FutureResult<Collection<String>> getValidPlacementIds() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Collection<String>>() {
            public Collection<String> call() throws Exception {
                List access$1100;
                synchronized (Repository.this) {
                    access$1100 = Repository.this.loadValidPlacementIds();
                }
                return access$1100;
            }
        }));
    }

    public FutureResult<List<String>> getAvailableBidTokens(final int i) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<String>>() {
            /* JADX INFO: finally extract failed */
            public List<String> call() throws Exception {
                ArrayList arrayList;
                synchronized (Repository.this) {
                    Query query = new Query("advertisement");
                    query.selection = "bid_token != '' AND ( state = ? OR state = ? ) AND expire_time > ?";
                    query.columns = new String[]{"bid_token"};
                    query.args = new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000)};
                    query.limit = String.valueOf(i);
                    Cursor query2 = Repository.this.dbHelper.query(query);
                    arrayList = new ArrayList();
                    if (query2 != null) {
                        while (query2.moveToNext()) {
                            try {
                                arrayList.add(query2.getString(query2.getColumnIndex("bid_token")));
                            } catch (Throwable th) {
                                query2.close();
                                throw th;
                            }
                        }
                        query2.close();
                    }
                }
                return arrayList;
            }
        }));
    }

    public void setValidPlacements(final List<Placement> list) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Class<Placement> cls = Placement.class;
                synchronized (Repository.class) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_valid", Boolean.FALSE);
                    Repository.this.dbHelper.update(new Query("placement"), contentValues);
                    for (Placement placement : list) {
                        Placement placement2 = (Placement) Repository.this.loadModel(placement.getId(), cls);
                        if (!(placement2 == null || (placement2.isIncentivized() == placement.isIncentivized() && placement2.isHeaderBidding() == placement.isHeaderBidding()))) {
                            String access$300 = Repository.TAG;
                            Log.w(access$300, "Placements data for " + placement.getId() + " is different from disc, deleting old");
                            for (String access$900 : Repository.this.getAdsForPlacement(placement.getId())) {
                                Repository.this.deleteAdInternal(access$900);
                            }
                            Repository.this.deleteModel(cls, placement2.getId());
                        }
                        if (placement2 != null) {
                            placement.setWakeupTime(placement2.getWakeupTime());
                            placement.setAdSize(placement2.getAdSize());
                        }
                        placement.setValid(placement.getPlacementAdType() != 2);
                        Repository.this.saveModel(placement);
                    }
                }
                return null;
            }
        });
    }

    public FutureResult<List<String>> findAdsForPlacement(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<String>>() {
            public List<String> call() {
                return Repository.this.getAdsForPlacement(str);
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<String> getAdsForPlacement(String str) {
        Query query = new Query("advertisement");
        query.columns = new String[]{"item_id"};
        query.selection = "placement_id=?";
        query.args = new String[]{str};
        Cursor query2 = this.dbHelper.query(query);
        ArrayList arrayList = new ArrayList();
        while (query2 != null && query2.moveToNext()) {
            arrayList.add(query2.getString(query2.getColumnIndex("item_id")));
        }
        if (query2 != null) {
            query2.close();
        }
        return arrayList;
    }

    public void clearAllData() {
        this.dbHelper.dropDb();
        this.designer.clearCache();
    }

    public void saveAndApplyState(final Advertisement advertisement, final String str, final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                String access$300 = Repository.TAG;
                Log.i(access$300, "Setting " + i + " for adv " + advertisement.getId() + " and pl " + str);
                advertisement.setState(i);
                int i = i;
                if (i == 0 || i == 1) {
                    advertisement.setPlacementId(str);
                    Repository.this.saveModel(advertisement);
                } else if (i == 2) {
                    advertisement.setPlacementId((String) null);
                    Repository.this.saveModel(advertisement);
                } else if (i == 3 || i == 4) {
                    Repository.this.deleteAdInternal(advertisement.getId());
                }
                return null;
            }
        });
    }

    public void trimVisionData(final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Query query = new Query("vision_data");
                query.selection = "_id <= ( SELECT MAX( _id ) FROM vision_data ) - ?";
                query.args = new String[]{Integer.toString(i)};
                Repository.this.dbHelper.delete(query);
                return null;
            }
        });
    }

    public FutureResult<VisionAggregationInfo> getVisionAggregationInfo(final long j) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<VisionAggregationInfo>() {
            public VisionAggregationInfo call() {
                Query query = new Query("vision_data");
                query.selection = "timestamp >= ?";
                query.orderBy = "_id DESC";
                query.args = new String[]{Long.toString(j)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                VisionDataDBAdapter visionDataDBAdapter = (VisionDataDBAdapter) Repository.this.adapters.get(VisionData.class);
                if (query2 == null || visionDataDBAdapter == null) {
                    return null;
                }
                try {
                    if (query2.moveToFirst()) {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                        return new VisionAggregationInfo(query2.getCount(), visionDataDBAdapter.fromContentValues(contentValues).creative);
                    }
                    query2.close();
                    return null;
                } finally {
                    query2.close();
                }
            }
        }));
    }

    public FutureResult<List<VisionAggregationData>> getVisionAggregationData(long j, int i, String str) {
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<VisionAggregationData>>() {
            public List<VisionAggregationData> call() {
                ArrayList arrayList = new ArrayList();
                if (!"advertiser".equals(str2) && !"campaign".equals(str2) && !"creative".equals(str2)) {
                    return arrayList;
                }
                Query query = new Query("vision_data");
                String str = str2;
                query.columns = new String[]{"COUNT ( * ) as viewCount", "MAX ( timestamp ) as lastTimeStamp", str};
                query.selection = "timestamp >= ?";
                query.groupBy = str;
                query.orderBy = "_id DESC";
                query.limit = Integer.toString(i2);
                query.args = new String[]{Long.toString(j2)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                if (query2 != null) {
                    while (query2.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                            arrayList.add(new VisionAggregationData(contentValues.getAsString(str2), contentValues.getAsInteger("viewCount").intValue(), contentValues.getAsLong("lastTimeStamp").longValue()));
                        } finally {
                            query2.close();
                        }
                    }
                }
                return arrayList;
            }
        }));
    }

    private static class VungleDatabaseCreator implements DatabaseHelper.DatabaseFactory {
        private final Context context;

        public VungleDatabaseCreator(Context context2) {
            this.context = context2;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN status INTEGER DEFAULT 1");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS vision_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp NUMERIC, creative TEXT, campaign TEXT, advertiser TEXT )");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN tt_download NUMERIC DEFAULT -1");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN refresh_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN supported_template_types NUMERIC DEFAULT 0");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN header_bidding SHORT ");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN header_bidding SHORT ");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN autocache_priority NUMERIC DEFAULT 2147483647");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN ad_request_start_time NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN init_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
            }
            if (i < 6) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_enable_om_sdk NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_om_sdk_extra_vast TEXT ");
            }
        }

        public void create(SQLiteDatabase sQLiteDatabase) {
            dropOldFilesData();
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS advertisement(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE, ad_config TEXT,ad_type INT, expire_time NUMERIC, delay NUMERIC, show_close_delay INT, show_close_incentivized INT, countdown INT, video_height INT, video_width INT, cta_overlay_enabled SHORT, cta_click_area NUMERIC, retry_count INT, requires_non_market_install SHORT, app_id TEXT, campaign TEXT, video_url TEXT, md5 TEXT, postroll_bundle_url TEXT, cta_destination_url TEXT, cta_url TEXT, ad_token TEXT, video_identifier TEXT, mute_urls TEXT, unmute_urls TEXT, close_urls TEXT, postroll_click_urls TEXT, postroll_view_urls TEXT, click_urls TEXT, video_click_urls TEXT, template_url TEXT, TEMPLATE_ID TEXT, TEMPLATE_TYPE TEXT, ad_market_id TEXT,bid_token TEXT,  checkpoints TEXT, template_settings TEXT, mraid_files TEXT, cacheable_assets TEXT, state INT, placement_id TEXT, tt_download NUMERIC,asset_download_timestamp NUMERIC,asset_download_duration NUMERIC,ad_request_start_time NUMERIC,column_enable_om_sdk SHORT,column_om_sdk_extra_vast TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS placement(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, incentivized SHORT, auto_cached SHORT, is_valid SHORT, wakeup_time NUMERIC, header_bidding SHORT, refresh_duration NUMERIC, supported_template_types NUMERIC, ad_size TEXT, autocache_priority NUMERIC)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cookie(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, bools TEXT, ints TEXT, longs TEXT, strings TEXT )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS report(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE,appId TEXT, placementId TEXT, adToken TEXT, incentivized SHORT, header_bidding SHORT, adStartTime NUMERIC, url TEXT, ad_duration NUMERIC, tt_download NUMERIC, campaign TEXT, videoViewed NUMERIC, ad_type TEXT, template_id TEXT, was_CTAC_licked SHORT, clicked_through TEXT, errors TEXT, user_actions TEXT, user_id TEXT, ordinal INT, videoLength NUMERIC, status INT, ad_size TEXT, init_timestamp NUMERIC, asset_download_duration NUMERIC)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adAsset ( _id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, paren_id TEXT , ad_identifier TEXT NOT NULL, server_path TEXT, local_path TEXT NOT NULL, file_status SHORT, file_type SHORT, file_size INT, retry_count SHORT, retry_error SHORT, unique ( local_path, ad_identifier ));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS vision_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp NUMERIC, creative TEXT, campaign TEXT, advertiser TEXT )");
        }

        public void deleteData(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS advertisement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS placement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS report");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adAsset");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS vision_data");
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", (String[]) null);
            while (rawQuery != null && rawQuery.moveToNext()) {
                String string = rawQuery.getString(1);
                if (!string.equals("android_metadata") && !string.startsWith("sqlite_")) {
                    arrayList.add(string);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            for (String str : arrayList) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            create(sQLiteDatabase);
        }

        private void deleteDatabase(String str) {
            this.context.deleteDatabase(str);
        }

        private void dropOldFilesData() {
            deleteDatabase(BuildConfig.NETWORK_NAME);
            File externalFilesDir = this.context.getExternalFilesDir((String) null);
            if (((Build.VERSION.SDK_INT >= 19 || PermissionChecker.checkCallingOrSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) && Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null) && externalFilesDir.exists()) {
                try {
                    FileUtility.delete(new File(externalFilesDir, ".vungle"));
                } catch (IOException e) {
                    Log.e(Repository.TAG, "IOException ", e);
                }
            }
            File filesDir = this.context.getFilesDir();
            if (filesDir.exists()) {
                try {
                    FileUtility.delete(new File(filesDir, BuildConfig.NETWORK_NAME));
                } catch (IOException e2) {
                    Log.e(Repository.TAG, "IOException ", e2);
                }
            }
            try {
                FileUtility.delete(new File(this.context.getCacheDir() + File.separator + "downloads_vungle"));
            } catch (IOException e3) {
                Log.e(Repository.TAG, "IOException ", e3);
            }
        }
    }

    private void runAndWait(Callable<Void> callable) throws DatabaseHelper.DBException {
        try {
            this.ioExecutor.submit(callable).get();
        } catch (ExecutionException e) {
            if (!(e.getCause() instanceof DatabaseHelper.DBException)) {
                Log.e(TAG, "Exception during runAndWait", e);
                return;
            }
            throw ((DatabaseHelper.DBException) e.getCause());
        } catch (InterruptedException e2) {
            Log.e(TAG, "InterruptedException ", e2);
            Thread.currentThread().interrupt();
        }
    }
}
