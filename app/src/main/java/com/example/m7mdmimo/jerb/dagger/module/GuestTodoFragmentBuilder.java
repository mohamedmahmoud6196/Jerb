package com.example.m7mdmimo.jerb.dagger.module;

import android.support.v4.app.Fragment;

import com.example.m7mdmimo.jerb.dagger.subcomponent.GusetTodoFragmentComponent;
import com.example.m7mdmimo.jerb.fragment.GusetToDoFramgent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by m7md mimo on 11/9/2017.
 */

@Module(subcomponents = GusetTodoFragmentComponent.class)
public abstract class GuestTodoFragmentBuilder {
/** you can used instead of ContributesAndroidInjector */


    @Binds
    @IntoMap
    @FragmentKey(GusetToDoFramgent.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindGuestTodoFragment(GusetTodoFragmentComponent.Builder builder);



}