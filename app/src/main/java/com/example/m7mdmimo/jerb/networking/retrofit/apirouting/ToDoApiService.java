package com.example.m7mdmimo.jerb.networking.retrofit.apirouting;

import com.example.m7mdmimo.jerb.domain.model.GuestTodResponse;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by m7md mimo on 11/9/2017.
 */

public interface ToDoApiService {
    @POST("guest_todos")
    Observable<GuestTodResponse> getGuestTodosList();
}
