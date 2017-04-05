package com.acadgild.session13;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

public class MyMessageInterface extends ContentProvider{
    public MyMessageInterface() {
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        ContentResolver smsResolver=getContext().getContentResolver();
        Cursor smsCursor=smsResolver.query(Uri.parse("content://sms/inbox"),null,null,null,null);


//
//        while (smsCursor.moveToNext()){
//            for (int i=0;i<smsCursor.getColumnCount();i++){
//
//            }
//        }

        return smsCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
