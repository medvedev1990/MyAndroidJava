package com.example.lesson2.Base;

import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lesson2.R;

public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbarBase;
    private TextView mTexeViewToolbarTitle;
    public Toolbar getBaseToolbar()
    {
        return mToolbarBase;
    }
    public TextView getTextViewToolBarTitle()
    {
        return mTexeViewToolbarTitle;
    }
    public int getLayout()
    {
        return R.layout.activity_base;
    }
    public BaseFragment onInitFragment();

    public void initializedFragment()
    {
        if (getCurrentFragment()!=null){
            displayFragment(onInitFragment());
        }
    }

    public void displayFragment(BaseFragment baseFragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount()>0 && getCurrentFragment() !=null){
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            if(fm.getBackStackEntryCount()>0){
                fragmentTransaction.hide(getCurrentFragment());
            }
            fragmentTransaction.add(R.id.fragment_container,fragment.getFragmentTag());
            fragmentTransaction.commit();
        }

    }
    private BaseFragment getCurrentFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int entryCount = fragmentManager.getBackStackEntryCount();
        if(entryCount>0){
            String fragmentTag = fragmentManager.getBackStackEntryAt(entryCount =1).getName();
            return (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);
        }
    }
    public void onBackPressed(){
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryAt()>1)
        {
            getSupportFragmentManager().popBackStack();
        }
        else
        {
            finish();
        }
    }
}
