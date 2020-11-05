package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    ArrayList<DataModel> dataHolder;

    public Adapter(ArrayList<DataModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infos, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.image.setImageResource(dataHolder.get(position).getImages());
        holder.title.setText(dataHolder.get(position).getTitle());
        holder.year.setText(dataHolder.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, year;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.img1);
            title=itemView.findViewById(R.id.title);
            year=itemView.findViewById(R.id.year);
        }
    }
}
