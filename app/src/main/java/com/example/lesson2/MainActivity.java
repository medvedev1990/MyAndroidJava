package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String login = "admin";
    private static String pass = "QWE123qwe";
    EditText mEditTextLogin;
    EditText mEditTextPass;
    Button mButtonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextLogin = (EditText)findViewById(R.id.editText_Login);
        mEditTextPass=(EditText)findViewById(R.id.editText_Pass);
        mButtonCheck=(Button)findViewById(R.id.btn_Check);
        mButtonCheck.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Check:
                Toast.makeText(this,checking(),Toast.LENGTH_LONG).show();

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
}
