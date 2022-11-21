package com.example.mvc.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mvc.R;
import com.example.mvc.model.Database;
import com.example.mvc.model.Person;
import com.example.mvc.view.MainViewHolder;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainViewHolder.HolderClickListener {
    //    public static final String TAG = MainActivity.class.getSimpleName();
    public final String TAG = this.getClass().getSimpleName();

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;
    Database database = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리사이클러뷰 선언 & 세팅
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setItems(database.getPersonList()); // Model
        database.setOndatabaseListener(new Database.DatabaseListener(){
            @Override
            public void onChanged() {
                adapter.setItems(database.getPersonList());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        database.add(new Person(System.currentTimeMillis(), String.format("New Charles %d", new Random().nextInt(1000))));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDeleteClick(Person person) {
        database.remove(person);
    }
}