package com.example.website;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import androidx.fragment.app.Fragment;

import javax.net.ssl.SSLEngineResult;
public class EmailFragment extends Fragment {
    EditText editText;
    Button button;
    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_email, container, false);
        button = v.findViewById(R.id.btButton1);
        editText=v.findViewById(R.id.etTextHere);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key",editText.getText().toString());
                StatusFragment fragment=new StatusFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.Framelayout_Statusfrag, fragment).commit();


            }
        });
        return v;

    }
}





















