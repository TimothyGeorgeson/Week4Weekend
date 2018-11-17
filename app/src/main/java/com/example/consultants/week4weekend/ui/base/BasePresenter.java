package com.example.consultants.week4weekend.ui.base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);

    void onDetach();
}
