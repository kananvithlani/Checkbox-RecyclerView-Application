package com.example.kanu.checkboxrecyclerviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListModel> items = new ArrayList<>();
    RecyclerView recyclerView;
    ListAdapter listAdapter;

    Button count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        count = (Button) findViewById(R.id.count);

        listAdapter = new ListAdapter(items);

        //Get the array of price
        final int[] pricearray = getResources().getIntArray(R.array.price);

        //Add the items and price in the list
        for (int i = 0;i<50;i++){
            ListModel listModel = new ListModel(i,pricearray[i]);
            items.add(listModel);
        }

        //Set the adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(listAdapter);

        //Add the price of the selected items
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = 0;
                for(int j = 0;j<50;j++){
                    if(((ListAdapter)recyclerView.getAdapter()).sparseBooleanArray.get(j) == true){
                        item = item + pricearray[j];
                    }
                }
                Toast.makeText(getApplicationContext(),"Price of selected item = "+item,Toast.LENGTH_LONG).show();
            }
        });

    }
}
