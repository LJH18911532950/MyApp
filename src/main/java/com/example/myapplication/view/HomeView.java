package com.example.myapplication.view;

import com.example.myapplication.ResultClass;
import com.example.myapplication.base.Item;

public interface HomeView {
    interface View {
        void getCitResult(Item item);
    }
    interface Personss{
        void getCity();
    }
    interface Mode{
        void getCity(ResultClass resultClass);
    }
}
