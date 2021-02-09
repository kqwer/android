package com.example.website;

import  android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class CallFragment extends Fragment {
    TextView txtView;
    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_call, container, false);
        //txtView=v.findViewById(R.id.SendData);
        Bundle bundle =this.getArguments();
        if (bundle != null){
            String myString;
            myString = bundle.getString("key");

            txtView.setText(myString);}
        return v;

    }
}



































