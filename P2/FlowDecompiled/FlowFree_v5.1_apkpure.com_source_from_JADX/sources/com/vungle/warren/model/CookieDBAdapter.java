package com.vungle.warren.model;

import android.content.ContentValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vungle.warren.persistence.DBAdapter;
import java.lang.reflect.Type;
import java.util.Map;

public class CookieDBAdapter implements DBAdapter<Cookie> {
    Type boolType = new TypeToken<Map<String, Boolean>>(this) {
    }.getType();
    private Gson gson = new GsonBuilder().create();
    Type intType = new TypeToken<Map<String, Integer>>(this) {
    }.getType();
    Type longType = new TypeToken<Map<String, Long>>(this) {
    }.getType();
    Type stringType = new TypeToken<Map<String, String>>(this) {
    }.getType();

    public String tableName() {
        return "cookie";
    }

    public ContentValues toContentValues(Cookie cookie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", cookie.identifier);
        contentValues.put("bools", this.gson.toJson((Object) cookie.booleans, this.boolType));
        contentValues.put("ints", this.gson.toJson((Object) cookie.integers, this.intType));
        contentValues.put("longs", this.gson.toJson((Object) cookie.longs, this.longType));
        contentValues.put("strings", this.gson.toJson((Object) cookie.strings, this.stringType));
        return contentValues;
    }

    public Cookie fromContentValues(ContentValues contentValues) {
        Cookie cookie = new Cookie(contentValues.getAsString("item_id"));
        cookie.booleans = (Map) this.gson.fromJson(contentValues.getAsString("bools"), this.boolType);
        cookie.longs = (Map) this.gson.fromJson(contentValues.getAsString("longs"), this.longType);
        cookie.integers = (Map) this.gson.fromJson(contentValues.getAsString("ints"), this.intType);
        cookie.strings = (Map) this.gson.fromJson(contentValues.getAsString("strings"), this.stringType);
        return cookie;
    }
}
