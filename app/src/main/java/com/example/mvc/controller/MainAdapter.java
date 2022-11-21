package com.example.mvc.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.R;
import com.example.mvc.model.Person;
import com.example.mvc.view.MainViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<Person> items = new ArrayList<>();
    private MainViewHolder.HolderClickListener holderClickListener;

    public MainAdapter(MainViewHolder.HolderClickListener holderClickListener){
        this.holderClickListener = holderClickListener;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_main, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
        mainViewHolder.setPerson(items.get(position));
        mainViewHolder.setOnHolderClickListener(holderClickListener);
    }

    public void setItems(List<Person> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Person> getItems() {
        return items;
    }
}
