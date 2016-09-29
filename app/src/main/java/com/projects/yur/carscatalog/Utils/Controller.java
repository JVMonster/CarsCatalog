package com.projects.yur.carscatalog.Utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Yur on 28.09.2016.
 */

public class Controller extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration mRealmConfig=new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(mRealmConfig);

    }
}
