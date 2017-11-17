package com.example.m7mdmimo.jerb.domain.manger;

import com.example.m7mdmimo.jerb.domain.model.Plan;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class PlanManger {
    private final Realm realm;
    private ArrayList<Plan> planArrayList;

    @Inject
    public PlanManger() {
        realm = Realm.getDefaultInstance();

    }

    public void addPlan(int guest_num, int cost, String location) {
        Plan plan = new Plan(guest_num, cost, location);
        realm.beginTransaction();
        realm.copyToRealm(plan);
        realm.commitTransaction();
    }

    public ArrayList<Plan> getListOfPlans(final PlanListCallback planListCallback) {
        RealmQuery<Plan> query = realm.where(Plan.class);
        try {
            RealmResults<Plan> planRealmResults = query.findAll();
            planArrayList = (ArrayList<Plan>) realm.copyFromRealm(planRealmResults);
            if (planArrayList.size() > 0)
                planListCallback.onSuccess(planArrayList);
        } catch (Exception e) {
            planListCallback.onError();
        }

        return planArrayList;
    }

    public interface PlanListCallback {
        //// TODO: 11/10/2017 update Response abstract class and pass it to getGuestTodoList And getTodo
        void onSuccess(ArrayList<Plan> planArrayList);

        void onError();
    }
}
