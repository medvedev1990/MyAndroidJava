package com.example.lesson2.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public View baseView;
    public abstract  String getFragment();
    public abstract BaseFragment newInstance();
    public abstract  void customizeActiinBar();
    public abstract  int onLayoutId();
    public void OnPause(){
        super.onPause();
    }
    public  void onResume(){
        super.onResume();
    }
    public void onCreate(@Nullable Bundle savedInsanceState){
        super.onCreate(savedInsanceState);
    }

    @Override
    public void onHiddenChanged(boolean hidden)
{
    if(!hidden)
    {

    }
}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInsanceState){
        super.onCreateView(inflater,container,savedInsanceState);
        baseView = inflater.inflate(onLayoutId(),container,false);
    }

}
