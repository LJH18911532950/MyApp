package com.example.myapplication.api;

import com.example.myapplication.base.Item;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface SerevritApi {
    String Url="https://jisutqybmf.market.alicloudapi.com/";
    @Headers("Authorization:APPCODE 964e16aa1ae944e9828e87b8b9fbd30a")
    @GET("weather/city")
    Observable<Item> getDate();
}
