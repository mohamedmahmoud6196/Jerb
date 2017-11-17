package com.example.m7mdmimo.jerb.dagger.module;

import android.app.Activity;

import com.example.m7mdmimo.jerb.activity.MainActivity;
import com.example.m7mdmimo.jerb.dagger.subcomponent.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by m7md mimo on 11/9/2017.
 */

@Module(subcomponents = MainActivityComponent.class)
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity
        (MainActivityComponent.Builder builder);

  /*  @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();*/


}