package com.example.key.beekeepernote.utils;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Key on 29.06.2017.
 */

public class BeekeperApp extends Application {
    FirebaseDatabase fb;
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        if (!FirebaseApp.getApps(this).isEmpty())
        {
            fb = FirebaseDatabase.getInstance();
            fb.setPersistenceEnabled(true);
            fb.getReference().keepSynced(true);
        }
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
