package com.example.m7mdmimo.jerb.dagger.module;

import com.example.m7mdmimo.jerb.concrete.PlanConcrete;
import com.example.m7mdmimo.jerb.domain.manger.PlanManger;
import com.example.m7mdmimo.jerb.fragment.PlanFragment;
import com.example.m7mdmimo.jerb.presenter.PlanPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Module
public   class PlanModule {

    @Provides
    PlanFragment provideMainView(PlanFragment tipsFragment) {
        return tipsFragment;
    }

    @Provides
    static PlanConcrete.iPlanView provideToDoView() {
        return new PlanFragment();
    }
    @Provides
    PlanPresenter provideMainPresenter(PlanConcrete.iPlanView iTipsView, PlanManger planManger) {
        return new PlanPresenter(iTipsView, planManger);
    }
}