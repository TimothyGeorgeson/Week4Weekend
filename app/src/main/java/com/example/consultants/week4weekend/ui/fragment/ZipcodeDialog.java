package com.example.consultants.week4weekend.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;

public class ZipcodeDialog extends DialogFragment {
    public static final String TAG = ZipcodeDialog.class.getSimpleName() + "_TAG";

    public OnInputListener onInputListener;
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
                    tvZipError.setText("");
                    onInputListener.startWeatherWithZip(zip);
                    getDialog().dismiss();
                } else {
                    tvZipError.setText("5-digit numeric zip codes only");
                }
            }
        });

        return view;
    }

    //set up interface to begin weather network calls when zip code is entered
    public interface OnInputListener {
        void startWeatherWithZip(String zip);
    }

    //catches potential ClassCastExceptions when initializing listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onInputListener = (OnInputListener)getActivity();
        } catch (ClassCastException e) {
            Log.d(TAG, "onAttach: ClassCastException: " + e.getMessage());
        }
    }
}
