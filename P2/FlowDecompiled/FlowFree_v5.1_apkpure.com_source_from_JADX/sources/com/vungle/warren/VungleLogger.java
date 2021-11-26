package com.vungle.warren;

import android.util.Log;
import androidx.annotation.Keep;
import com.vungle.warren.log.LogManager;

public class VungleLogger {
    private static final String TAG = "VungleLogger";
    private static final VungleLogger _instance = new VungleLogger();
    private LogManager logManager;
    private LoggerLevel loggingLevel = LoggerLevel.DEBUG;

    private VungleLogger() {
    }

    static void setupLoggerWithLogLevel(LogManager logManager2, LoggerLevel loggerLevel, int i) {
        VungleLogger vungleLogger = _instance;
        vungleLogger.loggingLevel = loggerLevel;
        vungleLogger.logManager = logManager2;
        logManager2.setMaxEntries(i);
    }

    public static void debug(String str, String str2) {
        log(LoggerLevel.DEBUG, str, str2);
    }

    public static void warn(String str, String str2) {
        log(LoggerLevel.WARNING, str, str2);
    }

    public static void error(String str, String str2) {
        log(LoggerLevel.ERROR, str, str2);
    }

    private static void log(LoggerLevel loggerLevel, String str, String str2) {
        VungleLogger vungleLogger = _instance;
        LogManager logManager2 = vungleLogger.logManager;
        if (logManager2 == null) {
            Log.d(TAG, "Please setup Logger first.");
        } else if (logManager2.isLoggingEnabled() && loggerLevel.level >= vungleLogger.loggingLevel.level) {
            vungleLogger.logManager.saveLog(loggerLevel, str, str2, (String) null, (String) null);
        }
    }

    @Keep
    public enum LoggerLevel {
        DEBUG(0, "debug"),
        INFO(1, "info"),
        WARNING(2, "warn"),
        ERROR(3, "error"),
        CRASH(4, "crash");
        
        /* access modifiers changed from: private */
        public int level;
        private String levelString;

        private LoggerLevel(int i, String str) {
            this.level = i;
            this.levelString = str;
        }

        public String toString() {
            return this.levelString;
        }
    }
}
