package com.example.admin.exploredemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arasthel.spannedgridlayoutmanager.SpanSize;
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager;

import java.util.ArrayList;

import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> data = new ArrayList<>();

        for (int x = 0; x < 1000; x++) {
            data.add(String.valueOf(x));
        }

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.idRvExploreGrid);
        int numberOfColumns = 3;
        final SpannedGridLayoutManager spannedGridLayoutManager = new SpannedGridLayoutManager(
                SpannedGridLayoutManager.Orientation.VERTICAL, numberOfColumns);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, numberOfColumns);
        spannedGridLayoutManager.setItemOrderIsStable(true);
        spannedGridLayoutManager.setSpanSizeLookup(new SpannedGridLayoutManager.SpanSizeLookup(new Function1<Integer, SpanSize>() {
            @Override
            public SpanSize invoke(Integer i) {
                int mod = i % 4;
                if (mod == 0 || i == 0) {
                    return new SpanSize(2, 2);
//                    return new SpanSize(1, 1);
                } else {
                    return new SpanSize(1, 1);
                }
//                return (i + 1) % 4 == 0 ? new SpanSize(2, 2) : new SpanSize(1, 1);
            }
        }));
        recyclerView.setLayoutManager(spannedGridLayoutManager);
        adapter = new GridViewAdapter(this, data);
        recyclerView.setAdapter(adapter);

        Button idBtExploreButton = findViewById(R.id.idBtExploreButton);
        idBtExploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "On Explore!", Toast.LENGTH_SHORT).show();
            }
        });
        Button idBtExploreHideButton = findViewById(R.id.idBtExploreHideButton);
        idBtExploreHideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Not On Explore!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
