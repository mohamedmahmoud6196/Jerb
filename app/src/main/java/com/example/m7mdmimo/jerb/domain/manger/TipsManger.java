package com.example.m7mdmimo.jerb.domain.manger;

import com.example.m7mdmimo.jerb.domain.model.Tips;
import com.example.m7mdmimo.jerb.domain.model.TipsResponse;
import com.example.m7mdmimo.jerb.networking.NetworkError;
import com.example.m7mdmimo.jerb.networking.retrofit.apirouting.GetTipsApiService;

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

public class TipsManger {
    private GetTipsApiService tipsApiService;
    private Realm realm;

    public TipsManger(GetTipsApiService tipsApiService) {
        this.tipsApiService = tipsApiService;
    }

    @Inject
    public TipsManger(Retrofit retrofit) {
        tipsApiService = retrofit.create(GetTipsApiService.class);
        realm = Realm.getDefaultInstance();
    }

    public Subscription getTips(final getTipsCallBack callback) {

        Subscriber<TipsResponse> getTipsApiServiceSubscriber = new Subscriber<TipsResponse>() {

            @Override
            public void onNext(TipsResponse tipsResponse) {
                ArrayList<Tips> guestTodos = tipsResponse.getTipsArrayList();
                callback.onSuccess(guestTodos);
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable t) {
                callback.onError(new NetworkError());

            }

        };

        return tipsApiService.getTipsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends TipsResponse>>() {
                    @Override
                    public Observable<? extends TipsResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(getTipsApiServiceSubscriber);


    }

    private void saveToDoList(TipsResponse guestTodResponse) {
        ArrayList<Tips> guestTodos = guestTodResponse.getTipsArrayList();
        realm.beginTransaction();
        realm.insert(guestTodos);
        realm.commitTransaction();
    }

    private ArrayList<Tips> getTipsArrayList() {
        RealmQuery<Tips> query = realm.where(Tips.class);
        ArrayList<Tips> tipsArrayList;
        RealmResults<Tips> planRealmResults = query.findAll();
        tipsArrayList = (ArrayList<Tips>) realm.copyFromRealm(planRealmResults);
        if (tipsArrayList.size() > 0)
            return tipsArrayList;
        else return null;
    }

    public interface getTipsCallBack {
        void onSuccess(ArrayList<Tips> tipsArrayList);

        void onError(NetworkError networkError);
    }


}
