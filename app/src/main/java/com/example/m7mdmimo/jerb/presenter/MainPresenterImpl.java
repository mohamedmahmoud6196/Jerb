package com.example.m7mdmimo.jerb.presenter;

import com.example.m7mdmimo.jerb.concrete.MainConcrete;
import com.example.m7mdmimo.jerb.networking.retrofit.apirouting.ToDoApiService;
import com.example.m7mdmimo.jerb.view.MainView;

import javax.inject.Inject;

/**
 * Created by m7md mimo on 11/9/2017.
 */

public class MainPresenterImpl implements MainConcrete.iMainPresenter {
    private MainView mainView;
    private ToDoApiService toDoApiService;

    @Inject
    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }
}
