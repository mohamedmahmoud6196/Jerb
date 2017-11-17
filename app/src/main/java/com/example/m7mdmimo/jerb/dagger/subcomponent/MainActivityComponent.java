package com.example.m7mdmimo.jerb.dagger.subcomponent;

import com.example.m7mdmimo.jerb.activity.MainActivity;
import com.example.m7mdmimo.jerb.dagger.module.GuestTodoFragmentBuilder;
import com.example.m7mdmimo.jerb.dagger.module.MainActivityModule;
import com.example.m7mdmimo.jerb.dagger.module.PlanFragmentBuilder;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Subcomponent(modules = { GuestTodoFragmentBuilder.class, PlanFragmentBuilder.class, MainActivityModule.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}