package com.example.lesson2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.lesson2.R;
import com.vicmikhailau.maskededittext.MaskedEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    private static String login = "admin";
    private static String pass = "QWE123qwe";
    EditText mEditTextLogin;
    EditText mEditTextPass;
    Button mButtonCheck;
    Button mButtonCamera;
    Button mButtonNext;
    Switch mswitch;
    MaskedEditText maskedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextLogin = (EditText)findViewById(R.id.editText_Login);
        mEditTextPass=(EditText)findViewById(R.id.editText_Pass);
        mButtonCheck=(Button)findViewById(R.id.btn_Check);
        mButtonCheck.setOnClickListener(this);
        mButtonCamera=(Button)findViewById(R.id.btnCamera);
        mButtonCamera.setOnClickListener(this);
        mButtonNext=(Button)findViewById(R.id.btnNextActivity);
        mButtonNext.setOnClickListener(this);
        mswitch=(Switch)findViewById(R.id.switch_card_or_phone);
        mswitch.setOnCheckedChangeListener(this);
        maskedEditText=(MaskedEditText) findViewById(R.id.maskededittext_actyvity_main_for_test);
        maskedEditText.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Check:
                Toast.makeText(this,checking(),Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCamera:
               camera();
                break;
            case R.id.btnNextActivity:
                nextActivity();
                break;
        }
    }

    public String checking()
    {
        if (login.equals(mEditTextLogin.getText().toString()) &&
                pass.equals(mEditTextPass.getText().toString()))
        {
            return "OK";
        }
        else
            return "Ssorry";
    }
    public void camera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }
    public void nextActivity()
    {
        Intent intent = new Intent(this,MyActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch(compoundButton.getId()) {
            case R.id.switch_card_or_phone:
                if (!b)
                    maskedEditText.setMask("+7(7##)###-##-##");
                else
                    maskedEditText.setMask("#### #### #### ####");
                break;
        }
    }
}
