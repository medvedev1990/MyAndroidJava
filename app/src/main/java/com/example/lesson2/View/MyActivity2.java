package com.example.lesson2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.lesson2.Contracts.SecondActivitiesContracts;
import com.example.lesson2.R;

public class MyActivity2 extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener,
        SecondActivitiesContracts.View,
        RadioGroup.OnCheckedChangeListener
        {

    Switch mswitch;
    CheckBox mcheckBox;
    RadioGroup mradioGroup;
    TextView mtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);
        initializedViews();
        InitializeListeren();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.switch_second_activity_hide:
                if(b)
                    mradioGroup.setVisibility(View.GONE);
                else
                    mradioGroup.setVisibility(View.VISIBLE);

                break;
            case R.id.checkbox_secondActivity_deny:
                break;
            case R.id.radioGroup_activity_second_text_show:
                break;
        }
    }

    @Override
    public void InitializeListeren() {
        mcheckBox.setOnCheckedChangeListener(this);
        mswitch.setOnCheckedChangeListener(this);
        mradioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void initializedViews() {
         mswitch = (Switch)findViewById(R.id.switch_second_activity_hide);
         mcheckBox = (CheckBox)findViewById(R.id.checkbox_secondActivity_deny);
         mradioGroup = (RadioGroup)findViewById(R.id.radioGroup_activity_second_text_show);
         mtextView=(TextView)findViewById(R.id.textview_text);
    }

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_second_activity_happy:
                        mtextView.setText(getString(R.string.happy));
                        break;
                    case R.id.rb_second_activity_sed:
                        mtextView.setText(getString(R.string.sed));
                        break;
                    case R.id.rb_second_activity_glory:

                        mtextView.setText(getString(R.string.glory));
                    break;
                }
            }
        }
