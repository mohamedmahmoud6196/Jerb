package com.example.m7mdmimo.jerb.dagger.module;

import com.example.m7mdmimo.jerb.activity.MainActivity;
import com.example.m7mdmimo.jerb.presenter.MainPresenterImpl;
import com.example.m7mdmimo.jerb.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Module()

public   abstract   class MainActivityModule {

    @Provides
    MainActivity provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }


    @Provides
    MainPresenterImpl provideMainPresenter(MainView mainView) {
        return new MainPresenterImpl(mainView);
    }

}