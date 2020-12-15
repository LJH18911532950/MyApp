package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import com.example.myapplication.api.SerevritApi;
import com.example.myapplication.base.Item;
import com.example.myapplication.com.http.HttpMag;

import java.nio.channels.AsynchronousChannel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private static final String TAG = "MainActivity";
    private void initView() {
        SerevritApi serevritApi = HttpMag.getHttpMag().getserevritApi();
        serevritApi.getDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Item>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Item item) {
                        Log.d(TAG, "onResponse: "+item);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onFailure: "+ e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}