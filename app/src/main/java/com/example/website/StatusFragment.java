package com.example.website;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ResourceBundle;

public class StatusFragment extends Fragment {
    TextView textView;
    public StatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_status, container, false);
        textView = v.findViewById(R.id.tvTextview);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myString;
            myString = bundle.getString("key");
            textView.setText(myString);
        }
        return v;






    }
}


























































