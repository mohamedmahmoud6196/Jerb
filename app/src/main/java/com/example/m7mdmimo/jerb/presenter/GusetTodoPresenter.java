package com.example.m7mdmimo.jerb.presenter;

import com.example.m7mdmimo.jerb.concrete.GusetTodoConcrete;
import com.example.m7mdmimo.jerb.domain.manger.GuestTodManger;
import com.example.m7mdmimo.jerb.domain.manger.PlanManger;
import com.example.m7mdmimo.jerb.domain.manger.TipsManger;
import com.example.m7mdmimo.jerb.domain.model.GuestTodo;
import com.example.m7mdmimo.jerb.domain.model.Plan;
import com.example.m7mdmimo.jerb.domain.model.Tips;
import com.example.m7mdmimo.jerb.networking.NetworkError;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class GusetTodoPresenter implements GusetTodoConcrete.iGusetTodoPresenter {
    private final PlanManger planManger;
    private GuestTodManger guestTodManger;
    private GusetTodoConcrete.iGusetTodoView iGusetTodoView;
    private TipsManger tipsManger;

    @Inject
    public GusetTodoPresenter(GusetTodoConcrete.iGusetTodoView iGusetTodoView, GuestTodManger guestTodManger, TipsManger tipsManger, PlanManger planManger) {
        this.guestTodManger = guestTodManger;
        this.tipsManger = tipsManger;
        this.planManger = planManger;
    }

    @Override
    public void loadTipList(final GusetTodoConcrete.iGusetTodoView iGusetTodoViewpar) {
        this.iGusetTodoView = iGusetTodoViewpar;
        iGusetTodoViewpar.startLoading();
        tipsManger.getTips(new TipsManger.getTipsCallBack() {
                               @Override
                               public void onSuccess( ArrayList<Tips> tipsArrayList ) {
                                   try {

                                       iGusetTodoView.showTipList(tipsArrayList);
                                       loadToDoList();
                                   } catch (Exception e) {
                                       iGusetTodoView.showError("Sorry,Server may be down ");
                                   }
                                   iGusetTodoViewpar.stopLoading();

                               }

                               @Override
                               public void onError(NetworkError networkError) {
                                   iGusetTodoView.showError(networkError.getErrorMessage());
                                   iGusetTodoViewpar.stopLoading();
                               }

                           }
        );
    }

    @Override
    public void loadToDoList() {
        guestTodManger.getGuestTodoList(new GuestTodManger.getGusetTodoListCallback() {
            @Override
            public void onSuccess( ArrayList<GuestTodo> guestTodos) {
                try {
                    iGusetTodoView.showToDoList(guestTodos);

                } catch (Exception e) {
                    iGusetTodoView.showError("Sorry,Server may be down ");

                }
            }

            @Override
            public void onError(NetworkError networkError) {
                iGusetTodoView.showError(networkError.getErrorMessage());
            }
        });
    }

    @Override
    public void loadPlans(final GusetTodoConcrete.iGusetTodoView iGusetTodoView) {
        planManger.getListOfPlans(new PlanManger.PlanListCallback() {
            @Override
            public void onSuccess(ArrayList<Plan> planArrayList) {
                iGusetTodoView.showPlanList(planArrayList);
            }

            @Override
            public void onError() {

            }
        });
    }
}
