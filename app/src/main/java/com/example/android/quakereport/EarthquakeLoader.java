package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.NetworkInfo;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();

    private String url;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (url == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(url);
        return earthquakes;
    }
}
