package com.example.m7mdmimo.jerb.presenter;

import com.example.m7mdmimo.jerb.concrete.PlanConcrete;
import com.example.m7mdmimo.jerb.domain.manger.PlanManger;

import javax.inject.Inject;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class PlanPresenter implements PlanConcrete.iPlanPresenter {
    PlanConcrete.iPlanView iTipsView;
    PlanManger planManger;

    @Inject
    public PlanPresenter(PlanConcrete.iPlanView iTipsView, PlanManger planManger) {
        this.iTipsView = iTipsView;
        this.planManger = planManger;
    }

    @Override
    public void savePlan(int friends_family, int cost, String city) {
        planManger.addPlan(friends_family, cost, city);
    }
}
