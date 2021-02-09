package com.example.website;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.*;


public class StoreFragment extends Fragment {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button save;
    SharedPreferences sharedPreferences;


    private static final String PROD_NAME = "proname";
    private static final String PROD_PRICE = "proprice";
    private static final String PROD_DATE = "prodate";

    private String text;

    public StoreFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.store_fragment, container, false);
        getActivity().setTitle("STORE PRODUCT");
        save = v.findViewById(R.id.submit);
        editText1 = v.findViewById(R.id.etProdname);
        editText2 = v.findViewById(R.id.etProdprice);
        editText3 = v.findViewById(R.id.etProdexpire);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();

                ed.putString("product_name", editText1.getText().toString());
                ed.putString("product_price", editText2.getText().toString());
                ed.putString("product_date", editText3.getText().toString());
                ed.commit();

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");

            }

        });


        return v;
    }

}