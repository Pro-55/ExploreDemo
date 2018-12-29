package com.example.admin.exploredemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private int[] mData;
    private LayoutInflater mInflater;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    // data is passed into the constructor
    GridViewAdapter(Context context, int[] data, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mStaggeredGridLayoutManager = staggeredGridLayoutManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.layout_grid_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int div = (i + 1) / 6;
        if (div == 0 || i == 0) {
        }
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
