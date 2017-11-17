package com.example.m7mdmimo.jerb.dagger.subcomponent;

import com.example.m7mdmimo.jerb.fragment.PlanFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by m7md mimo on 11/9/2017.
 */
@Subcomponent
public interface TipsFragmentComponent extends AndroidInjector<PlanFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PlanFragment> {
    }
}