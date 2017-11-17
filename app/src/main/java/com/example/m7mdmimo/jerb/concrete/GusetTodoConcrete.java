package com.example.m7mdmimo.jerb.concrete;

import com.example.m7mdmimo.jerb.domain.model.GuestTodo;
import com.example.m7mdmimo.jerb.domain.model.Plan;
import com.example.m7mdmimo.jerb.domain.model.Tips;

import java.util.ArrayList;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public interface GusetTodoConcrete {
    interface iGusetTodoPresenter {
        void loadTipList(GusetTodoConcrete.iGusetTodoView iGusetTodoView);

        void loadToDoList();

        void loadPlans(GusetTodoConcrete.iGusetTodoView iGusetTodoView);
    }

    interface iGusetTodoView {
        void showTipList(ArrayList<Tips> tipsArrayList);

        void startLoading();

        void stopLoading();

        void showToDoList(ArrayList<GuestTodo> guestTodoArrayList);

        void showError(String errorMessage);

        void showPlanList(ArrayList<Plan> planArrayList);
    }
}
