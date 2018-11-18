package com.example.consultants.week4weekend.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.consultants.week4weekend.R;

public class TopFragment extends Fragment {

    // Required empty public constructor
    public TopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        ImageButton btnSettings = view.findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog to ask for zipcode
                ZipcodeDialog zcDialog = new ZipcodeDialog();
                zcDialog.show(getFragmentManager(), "ZipCodeDialog");
            }
        });

        return view;
    }
}
