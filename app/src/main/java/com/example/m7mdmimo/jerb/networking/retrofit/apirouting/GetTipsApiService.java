package com.example.m7mdmimo.jerb.networking.retrofit.apirouting;

import com.example.m7mdmimo.jerb.domain.model.TipsResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by m7md mimo on 11/9/2017.
 */

public interface GetTipsApiService {
    @GET("tips")
    Observable<TipsResponse> getTipsList();
}
