package com.example.kanu.checkboxrecyclerviewapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<ListModel> items;
    ListModel listModel;
    SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        listModel = items.get(position);
        int item = listModel.getPosition();
        holder.checkBox.setText("Item " + (item + 1));
        holder.checkBox.setChecked(sparseBooleanArray.get(item));
        holder.price.setText("Price : " + String.valueOf(listModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;
        public TextView price;

        public MyViewHolder(final View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkBox);
            price = itemView.findViewById(R.id.price);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int item = getAdapterPosition();
                    
                    if (sparseBooleanArray.get(item, false)) {
                        checkBox.setChecked(false);
                        sparseBooleanArray.put(item, false);
                    } else {
                        checkBox.setChecked(true);
                        sparseBooleanArray.put(item, true);
                    }
                }
            });
        }
    }

    public ListAdapter(List<ListModel> items) {
        this.items = items;
    }

}
