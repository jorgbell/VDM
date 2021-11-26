package androidx.sqlite.p006db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;

/* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteStatement */
class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }
}
