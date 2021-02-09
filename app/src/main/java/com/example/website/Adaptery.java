package com.example.website;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.website.model.UserInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
*  Adapter should not hold context from external world
* */

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private ArrayList<UserInfo> movieList;
    private static OnItemClickListener mListener;

    public static void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public Adaptery(ArrayList<UserInfo> movieList){
        this.movieList= movieList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v;
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        v=inflater.inflate(R.layout.movie_item, parent ,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position){

        UserInfo currentItem = movieList.get(position);
        String imageUrl = currentItem.getOwner().getAvatarUrl();
        Picasso.with(holder.itemView.getContext()).load(imageUrl).fit().centerInside().into(holder.img);
        holder.name.setText(movieList.get(position).getName());
        holder.fullname.setText(movieList.get(position).getFullName());
        holder.description.setText(movieList.get(position).getDescription());
        holder.Private.setChecked(movieList.get(position).getPrivate());
        holder.fork.setChecked(movieList.get(position).getFork());

    }

    @Override
    public int getItemCount(){
        return movieList.size();

    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView fullname;
        TextView description;
        ImageView img;
        SwitchCompat Private;
        SwitchCompat fork;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.text_view_name);
            fullname = itemView.findViewById(R.id.text_view_fullname);
            description = itemView.findViewById(R.id.text_view_description);
            Private = itemView.findViewById(R.id.switch1);
            fork= itemView.findViewById(R.id.switch2);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });



        }
    }



}
