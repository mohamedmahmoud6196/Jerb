package com.example.m7mdmimo.jerb.dagger.module;

import android.app.Application;
import android.content.Context;

import com.example.m7mdmimo.jerb.dagger.subcomponent.MainActivityComponent;
import com.example.m7mdmimo.jerb.domain.manger.GuestTodManger;
import com.example.m7mdmimo.jerb.domain.manger.PlanManger;
import com.example.m7mdmimo.jerb.domain.manger.TipsManger;
import com.example.m7mdmimo.jerb.networking.retrofit.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Module(subcomponents = MainActivityComponent.class)
public class AppModule {


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    static GuestTodManger guestTodManger() {
        return new GuestTodManger(ApiClient.getClient());
    }

    @Provides
    static TipsManger tipsManger() {
        return new TipsManger(ApiClient.getClient());
    }

    @Provides
    static PlanManger getPlanManger() {
        return new PlanManger();
    }

    @Provides
    @Singleton
    Retrofit getApiClient() {
        return ApiClient.getClient();
    }
}