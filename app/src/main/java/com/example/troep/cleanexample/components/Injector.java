package com.example.troep.cleanexample.components;

import com.example.troep.cleanexample.network.ApiModule;
import com.example.troep.cleanexample.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by troep on 4/29/17.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface Injector {
    void inject(MainActivity activity);
}

