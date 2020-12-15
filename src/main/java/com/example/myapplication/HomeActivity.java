package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.base.Item;
import com.example.myapplication.person.HomePerson;
import com.example.myapplication.view.HomeView;

public class HomeActivity extends AppCompatActivity implements HomeView.View {


    private HomeView.Personss homePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePerson = new HomePerson(this);
        initDate();
    }

    private void initDate() {
        homePerson.getCity();
    }

    private static final String TAG = "HomeActivity";
    @Override
    public void getCitResult(Item item) {
        Log.d(TAG, "getCitResult: "+item.toString());
    }
}