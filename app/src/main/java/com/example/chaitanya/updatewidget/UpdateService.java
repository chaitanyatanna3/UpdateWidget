package com.example.chaitanya.updatewidget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by chaitanyatanna on 3/15/16.
 */
public class UpdateService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        buildUpdate();
        return super.onStartCommand(intent, flags, startId);
    }

    private void buildUpdate() {

        Random random = new Random();
        int randomInt = random.nextInt(100);
        String lastUpdate = "R: " + randomInt;

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.update_widget);
        remoteViews.setTextViewText(R.id.textView, lastUpdate);
        ComponentName theWidget = new ComponentName(this, UpdateWidget.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        manager.updateAppWidget(theWidget, remoteViews);
    }
}
