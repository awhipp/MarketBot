package com.w9jds.marketbot.data;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.w9jds.eveapi.Models.MarketItemBase;
import com.w9jds.marketbot.classes.MarketBot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

/**
 * Created by Jeremy on 2/19/2016.
 */
public abstract class BaseDataManager implements DataLoadingSubject {

    private AtomicInteger loadingCount;
    private AtomicInteger updatingCount;
    private List<DataLoadingCallbacks> loadingCallbacks;
    private List<DataUpdatingCallbacks> updatingCallbacks;

    public BaseDataManager() {
        // setup the API access objects
        loadingCount = new AtomicInteger(0);
        updatingCount = new AtomicInteger(0);
    }

    public abstract void onDataLoaded(List<? extends MarketItemBase> data);
    public abstract void onDataLoaded(Object data);

    @Override
    public boolean isDataLoading() {
        return loadingCount.get() > 0;
    }

    protected int updatingCount() {
        return updatingCount.intValue();
    }

    protected void loadStarted() {
        dispatchLoadingStartedCallbacks();
    }

    protected void loadFinished() {
        dispatchLoadingFinishedCallbacks();
    }

    protected  void loadFailed(String errorMessage) {
        dispatchLoadingFailedCallbacks(errorMessage);
    }

    protected void updateStarted() {
        dispatchUpdateStartedCallbacks();
    }

    protected void updateFinished(SQLiteDatabase database) {
        dispatchUpdateFinishedCallbacks(database);
    }

    protected void resetLoadingCount() {
        loadingCount.set(0);
    }

    protected void incrementLoadingCount() {
        loadingCount.incrementAndGet();
    }

    protected void decrementLoadingCount() {
        loadingCount.decrementAndGet();
    }

    protected void incrementUpdatingCount() {
        updatingCount.incrementAndGet();
    }

    protected void incrementUpdatingCount(int count) {
        updatingCount.set(count);
    }

    protected void decrementUpdatingCount() {
        updatingCount.decrementAndGet();
    }

    @Override
    public void registerCallback(DataLoadingSubject.DataLoadingCallbacks callback) {
        if (loadingCallbacks == null) {
            loadingCallbacks = new ArrayList<>(1);
        }

        loadingCallbacks.add(callback);
    }

    @Override
    public void registerCallback(DataLoadingSubject.DataUpdatingCallbacks callback) {
        if (updatingCallbacks == null) {
            updatingCallbacks = new ArrayList<>(1);
        }

        updatingCallbacks.add(callback);
    }

    @Override
    public void unregisterCallback(DataLoadingSubject.DataLoadingCallbacks callback) {
        if (loadingCallbacks.contains(callback)) {
            loadingCallbacks.remove(callback);
        }
    }

    @Override
    public void unregisterCallback(DataLoadingSubject.DataUpdatingCallbacks callback) {
        if (updatingCallbacks.contains(callback)) {
            updatingCallbacks.remove(callback);
        }
    }

    protected void dispatchLoadingStartedCallbacks() {
        if (loadingCount.intValue() == 0) {
            if (loadingCallbacks != null && !loadingCallbacks.isEmpty()) {
                for (DataLoadingCallbacks loadingCallback : loadingCallbacks) {
                    loadingCallback.dataStartedLoading();
                }
            }
        }
    }

    protected void dispatchLoadingFinishedCallbacks() {
        if (loadingCount.intValue() == 0) {
            if (loadingCallbacks != null && !loadingCallbacks.isEmpty()) {
                for (DataLoadingCallbacks loadingCallback : loadingCallbacks) {
                    loadingCallback.dataFinishedLoading();
                }
            }
        }
    }

    protected void dispatchLoadingFailedCallbacks(String errorMessage) {
        if (loadingCallbacks != null && !loadingCallbacks.isEmpty()) {
            for (DataLoadingCallbacks loadingCallback : loadingCallbacks) {
                loadingCallback.dataFailedLoading(errorMessage);
            }
        }
    }

    protected void dispatchUpdateStartedCallbacks() {
        if (updatingCount.intValue() == 0) {
            if (updatingCallbacks != null && !updatingCallbacks.isEmpty()) {
                for (DataUpdatingCallbacks updatingCallback : updatingCallbacks) {
                    updatingCallback.dataUpdatingStarted();
                }
            }
        }
    }

    protected void dispatchUpdateFinishedCallbacks(SQLiteDatabase database) {
        if (updatingCount.intValue() == 0) {
            if (updatingCallbacks != null && !updatingCallbacks.isEmpty()) {
                for (DataUpdatingCallbacks updatingCallback : updatingCallbacks) {
                    updatingCallback.dataUpdatingFinished();
                }
            }
        }
    }
}