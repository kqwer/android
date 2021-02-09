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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;


public class UpdateFragment extends Fragment {
    EditText UpdateText1;
    EditText UpdateText2;
    EditText UpdateText3;
    Button btUpdate;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String PROD_NAME = "proname";
    private static final String PROD_PRICE = "proprice";
    private static final String PROD_DATE = "prodate";


    public UpdateFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.update_fragment, container, false);
        getActivity().setTitle("UPDATE DETAILS");
        UpdateText1 = v.findViewById(R.id.etEditProdname);
        UpdateText2 = v.findViewById(R.id.etEditProdprice);
        UpdateText3 = v.findViewById(R.id.etEditProdexpire);
        btUpdate = v.findViewById(R.id.btUpdate);

        SharedPreferences sp = getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
        if (sp.contains("product_name"))
            UpdateText1.setText(sp.getString("product_name", ""));
        UpdateText2.setText(sp.getString("product_price", ""));
        UpdateText3.setText(sp.getString("product_date", ""));


        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();

                ed.putString("product_name", UpdateText1.getText().toString());
                ed.putString("product_price", UpdateText2.getText().toString());
                ed.putString("product_date", UpdateText3.getText().toString());
                ed.commit();

                UpdateText1.setText("");
                UpdateText2.setText("");
                UpdateText3.setText("");

            }

        });


        return v;
    }
}
















