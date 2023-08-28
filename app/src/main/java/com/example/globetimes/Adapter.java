package com.example.globetimes;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,  int position) {
        //Set the data according to our item or position
        holder.xcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });


        //To set data on recycler view
        holder.xtime.setText("Published At :-"+modelClassArrayList.get(position).getPublishedAt());
        holder.xauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.xheading.setText(modelClassArrayList.get(position).getTitle());
        holder.xcontent.setText(modelClassArrayList.get(position).getDescription());
        //to show the image
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.ximageView);







    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        TextView xheading, xcontent, xauthor, xtime;
        CardView xcardView;
        ImageView ximageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            xheading= itemView.findViewById(R.id.mainheading);
            xcontent= itemView.findViewById(R.id.content);
            xauthor= itemView.findViewById(R.id.author);
            xtime= itemView.findViewById(R.id.time);
            ximageView= itemView.findViewById(R.id.imageview);
            xcardView= itemView.findViewById(R.id.cardview);

        }
    }
}