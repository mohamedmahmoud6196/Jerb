package com.example.m7mdmimo.jerb.domain.manger;


import com.example.m7mdmimo.jerb.domain.model.GuestTodResponse;
import com.example.m7mdmimo.jerb.domain.model.GuestTodo;
import com.example.m7mdmimo.jerb.networking.NetworkError;
import com.example.m7mdmimo.jerb.networking.retrofit.apirouting.ToDoApiService;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class GuestTodManger {
    private ToDoApiService toDoApiService;
    private Realm realm;

    public GuestTodManger(ToDoApiService toDoApiService) {
        this.toDoApiService = toDoApiService;
    }

    @Inject
    public GuestTodManger(Retrofit retrofit) {
        toDoApiService = retrofit.create(ToDoApiService.class);
        realm = Realm.getDefaultInstance();
    }

    public Subscription getGuestTodoList(final getGusetTodoListCallback callback) {

        Subscriber<GuestTodResponse> guestTodResponseSubscriber = new Subscriber<GuestTodResponse>() {

            @Override
            public void onNext(GuestTodResponse guestTodResponse) {
                ArrayList<GuestTodo> guestTodos = guestTodResponse.getGuestTodos();

                callback.onSuccess(guestTodos);
                saveToDoList(guestTodResponse);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(new NetworkError());
                if (geGuestTodoArrayList()!=null)
                    callback.onSuccess(geGuestTodoArrayList());
            }

        };

        return toDoApiService.getGuestTodosList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends GuestTodResponse>>() {
                    @Override
                    public Observable<? extends GuestTodResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(guestTodResponseSubscriber);
    }

    private void saveToDoList(GuestTodResponse guestTodResponse) {
        ArrayList<GuestTodo> guestTodos = guestTodResponse.getGuestTodos();
        realm.beginTransaction();
        realm.insert(guestTodos);
        realm.commitTransaction();
    }

    private ArrayList<GuestTodo> geGuestTodoArrayList() {
        RealmQuery<GuestTodo> query = realm.where(GuestTodo.class);
        ArrayList<GuestTodo> planArrayList;
        RealmResults<GuestTodo> planRealmResults = query.findAll();
        planArrayList = (ArrayList<GuestTodo>) realm.copyFromRealm(planRealmResults);
        if (planArrayList.size() > 0)
            return planArrayList;
        else return null;
    }

    public interface getGusetTodoListCallback {
        void onSuccess(ArrayList<GuestTodo> guestTodoArrayList);
        void onError(NetworkError networkError);
    }


}
