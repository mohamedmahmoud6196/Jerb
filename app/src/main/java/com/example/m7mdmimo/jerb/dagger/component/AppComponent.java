package com.example.m7mdmimo.jerb.dagger.component;

import android.app.Application;

import com.example.m7mdmimo.jerb.application.JerbApp;
import com.example.m7mdmimo.jerb.dagger.module.ActivityBuilder;
import com.example.m7mdmimo.jerb.dagger.module.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
        })
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(JerbApp app);
}