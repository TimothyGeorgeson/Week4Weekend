package com.example.consultants.week4weekend.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;

public class MainActivity extends AppCompatActivity {
    public int zipCode;

    public TextView tvZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvZipCode = findViewById(R.id.tvZipCode);

        ZipcodeDialog zcDialog = new ZipcodeDialog();
        zcDialog.show(getSupportFragmentManager(), "ZipCodeDialog");

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
