package com.example.m7mdmimo.jerb.dagger.subcomponent;

import com.example.m7mdmimo.jerb.dagger.module.GuestTodoModule;
import com.example.m7mdmimo.jerb.fragment.GusetToDoFramgent;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Subcomponent(modules = GuestTodoModule.class)
public interface GusetTodoFragmentComponent extends AndroidInjector<GusetToDoFramgent> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GusetToDoFramgent> {
    }
}