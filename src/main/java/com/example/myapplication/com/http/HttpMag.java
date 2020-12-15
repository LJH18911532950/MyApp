package com.example.myapplication.com.http;

import com.example.myapplication.api.SerevritApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpMag {
    private static HttpMag httpMag;
    public static HttpMag getHttpMag(){
        if(httpMag==null){
            synchronized (HttpMag.class){
                if(httpMag==null){
                    httpMag=new HttpMag();
                }
            }
        }
        return httpMag;
    }
    private SerevritApi serevritApi;

    private Retrofit getRetroit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(SerevritApi.Url)
                .client(getOkhttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;


    }
    private OkHttpClient getOkhttp(){
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new Lonhrtrth())
                .build();
        return build;
    }
    static class Lonhrtrth implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
    public SerevritApi getserevritApi(){
        if(serevritApi==null){
            serevritApi=getRetroit().create(SerevritApi.class);

        }
        return serevritApi;
    }
}
