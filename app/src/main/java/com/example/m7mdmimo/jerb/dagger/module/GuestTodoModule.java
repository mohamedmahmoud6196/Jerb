package com.example.m7mdmimo.jerb.dagger.module;

import com.example.m7mdmimo.jerb.concrete.GusetTodoConcrete;
import com.example.m7mdmimo.jerb.domain.manger.GuestTodManger;
import com.example.m7mdmimo.jerb.domain.manger.PlanManger;
import com.example.m7mdmimo.jerb.domain.manger.TipsManger;
import com.example.m7mdmimo.jerb.fragment.GusetToDoFramgent;
import com.example.m7mdmimo.jerb.networking.retrofit.ApiClient;
import com.example.m7mdmimo.jerb.presenter.GusetTodoPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Module
public abstract class GuestTodoModule {
    @Provides
    static GusetToDoFramgent provideMainView(GusetToDoFramgent gusetToDoFramgent) {
        return gusetToDoFramgent;
    }

    @Provides
    static GusetTodoConcrete.iGusetTodoView provideToDoView() {
        return new GusetToDoFramgent();
    }

    @Provides
    static GusetTodoPresenter provideMainPresenter(GusetTodoConcrete.iGusetTodoView iGusetTodoView, GuestTodManger guestTodManger, TipsManger tipsManger, PlanManger planManger) {
        return new GusetTodoPresenter(iGusetTodoView, guestTodManger, tipsManger, planManger);
    }


    @Provides
    @Singleton
    static Retrofit getApiClient() {
        return ApiClient.getClient();
    }
}