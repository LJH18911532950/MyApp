package com.example.myapplication.mdeloi;

import android.util.Log;

import androidx.appcompat.widget.DialogTitle;

import com.example.myapplication.ResultClass;
import com.example.myapplication.api.SerevritApi;
import com.example.myapplication.base.Item;
import com.example.myapplication.com.http.HttpMag;
import com.example.myapplication.person.HomePerson;
import com.example.myapplication.view.HomeView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeMdelo implements HomeView.Mode {
    private static final String TAG = "HomeMdelo";

    @Override
    public void getCity(final ResultClass resultClass) {
        SerevritApi serevritApi = HttpMag.getHttpMag().getserevritApi();
        serevritApi.getDate().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Item>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Item item) {
                        resultClass.onSelll(item);
                        Log.d(TAG, "onNext: "+item);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
