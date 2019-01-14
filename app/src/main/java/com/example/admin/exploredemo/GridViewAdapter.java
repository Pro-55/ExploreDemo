package com.example.admin.exploredemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridItemViewHolder> {

    private ArrayList<String> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    GridViewAdapter(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public GridItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.layout_grid_image, viewGroup, false);
        return new GridItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridItemViewHolder viewHolder, int i) {
        viewHolder.idTvItemNumber.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class GridItemViewHolder extends RecyclerView.ViewHolder {
        TextView idTvItemNumber;

        GridItemViewHolder(@NonNull View itemView) {
            super(itemView);
            idTvItemNumber = itemView.findViewById(R.id.idTvItemNumber);
        }
    }
}
