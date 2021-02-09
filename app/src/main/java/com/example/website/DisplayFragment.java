package com.example.website;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;


public class DisplayFragment extends Fragment {

    TextView tvProdname, tvProdprice, tvProdexpire;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.display_fragment, container, false);


        getActivity().setTitle("DISPLAY DETAILS");
        tvProdname = v.findViewById(R.id.tvProdname);
        tvProdprice = v.findViewById(R.id.tvProdprice);
        tvProdexpire = v.findViewById(R.id.tvProdexpire);
        SharedPreferences sp = getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
        if (sp.contains("product_name"))
            tvProdname.setText(sp.getString("product_name", ""));
            tvProdprice.setText(sp.getString("product_price", ""));
            tvProdexpire.setText(sp.getString("product_date", ""));


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstance);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        SharedPreferences sp = getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
        if (sp.contains("product_name")){
            inflater.inflate(R.menu.menu, menu);
            super.onCreateOptionsMenu(menu, inflater);}

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete) {
            SharedPreferences sp= getActivity().getSharedPreferences("datafile", MODE_PRIVATE);
            SharedPreferences.Editor ed=sp.edit();
            ed.remove("product_name");
            ed.remove("product_price");
            ed.remove("product_date");
            ed.commit();
            tvProdname.setText("");
            tvProdprice.setText("");
            tvProdexpire.setText("");

        }
        return super.onOptionsItemSelected(item);


    }
}






