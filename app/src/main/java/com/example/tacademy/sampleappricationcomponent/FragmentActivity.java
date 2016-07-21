package com.example.tacademy.sampleappricationcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity implements OneFragment.OnMessageCallback {


    private static final String TAG_ONE = "one";
    private static final String TAG_TWO = "two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btn = (Button)findViewById(R.id.btn_on);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAG_ONE);

                if(old == null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    OneFragment f = OneFragment.newInstance("input message");
                    ft.replace(R.id.container, f, TAG_ONE);
                    ft.commit();
                }
            }
        });

        btn = (Button)findViewById(R.id.btn_two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAG_TWO);
                if(old ==null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    TwoFragment f = new TwoFragment();
                    ft.replace(R.id.container, f, TAG_TWO);
                    ft.commit();
                }
            }
        });

        btn = (Button)findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FragmentActivity.this, OtherFragmentActivity.class ));
            }
        });

    }


    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, "message:"+ message, Toast.LENGTH_SHORT).show();
    }
}
