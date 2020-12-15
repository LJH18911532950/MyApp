package com.example.myapplication.person;

import com.example.myapplication.ResultClass;
import com.example.myapplication.base.Item;
import com.example.myapplication.mdeloi.HomeMdelo;
import com.example.myapplication.view.HomeView;

public class HomePerson implements HomeView.Personss {
     HomeView.View view;
     HomeView.Mode homeMdelo;

    public HomePerson(HomeView.View view) {
        this.view = view;
        this.homeMdelo = new HomeMdelo();
    }


    @Override
    public void getCity() {
        this.homeMdelo.getCity(new ResultClass() {
            @Override
            public void onSelll(Object o) {
                if(view!=null){
                    view.getCitResult((Item) o);
                }

            }

            @Override
            public void onfrom(String m) {

            }
        });
    }
}
