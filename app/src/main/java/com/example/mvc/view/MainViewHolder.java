package com.example.mvc.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.R;
import com.example.mvc.model.Person;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private Button delete;
    private HolderClickListener listener;
    private Person person;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        delete = itemView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null){
                    listener.onDeleteClick(person);
                }
            }
        });
    }

    public void setPerson(Person person){
        this.person = person;
        name.setText(person.getName());
    }

    public void setOnHolderClickListener(HolderClickListener listener) {
        this.listener = listener;
    }

    public interface HolderClickListener{
        void onDeleteClick(Person person);
    }
}
