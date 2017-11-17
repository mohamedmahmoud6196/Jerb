package com.example.m7mdmimo.jerb.dagger.module;

import com.example.m7mdmimo.jerb.fragment.PlanFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by m7md mimo on 11/9/2017.
 */

@Module
public abstract class PlanFragmentBuilder {

   /* @Binds
    @IntoMap
    @FragmentKey(PlanFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindTipsFragment(TipsFragmentComponent.Builder builder);*/

    @ContributesAndroidInjector(modules = PlanModule.class)
    abstract PlanFragment geTipsFragment();
}