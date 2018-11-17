package com.example.consultants.week4weekend.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;

public class ZipcodeDialog extends DialogFragment {

    private EditText etZip;
    private Button btnZip;
    private TextView tvZipError;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_zipcode, container, false);
        etZip = view.findViewById(R.id.etZip);
        btnZip = view.findViewById(R.id.btnZip);
        tvZipError = view.findViewById(R.id.tvZipError);

        btnZip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zip = etZip.getText().toString();
                if (zip.length() == 5) {
                    ((MainActivity)getActivity()).zipCode = Integer.parseInt(zip);
                    ((MainActivity)getActivity()).tvZipCode.setText("Zip Code: " + zip);
                    tvZipError.setText("");
                    getDialog().dismiss();
                }
                else {
                    tvZipError.setText("5-digit numeric zip codes only");
                }
            }
        });

        return view;
    }
}
