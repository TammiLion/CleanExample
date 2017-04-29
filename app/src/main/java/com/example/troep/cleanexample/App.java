package com.example.troep.cleanexample;

import android.app.Application;

import com.example.troep.cleanexample.components.DaggerInjector;
import com.example.troep.cleanexample.components.Injector;

import timber.log.Timber;

/**
 * Created by troep on 4/29/17.
 */

public class App extends Application {

    private Injector mInjector;
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mInjector = DaggerInjector.create();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * @return the instance of itself.
     */
    public static App get() {
        return sInstance;
    }

    /**
     * @return injector for injecting modules.
     */
    public Injector getInjector() {
        return mInjector;
    }


}
