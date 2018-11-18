package com.example.consultants.week4weekend.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;

public class MainActivity extends AppCompatActivity {
    public int zipCode;

    public TextView tvZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvZipCode = findViewById(R.id.tvZipCode);

        ZipcodeDialog zcDialog = new ZipcodeDialog();
        zcDialog.show(getSupportFragmentManager(), "ZipCodeDialog");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
