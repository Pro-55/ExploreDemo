package com.example.admin.exploredemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private int[] mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    GridViewAdapter(Context context, int[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.layout_grid_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.idIvGridItem.setImageResource(mData[i]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView idIvGridItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            idIvGridItem = itemView.findViewById(R.id.idIvGridItem);
        }
    }
}
