package com.example.retrofitprojecttrail.activities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.retrofitprojecttrail.model.ApiUser;
import com.example.retrofitprojecttrail.model.ApiUserInterface;
import com.example.retrofitprojecttrail.R;
import com.example.retrofitprojecttrail.model.presenterImpl;
import com.example.retrofitprojecttrail.presenter.presenterInt;
import com.example.retrofitprojecttrail.recyclerView.RecyclerAdaptor;
import com.example.retrofitprojecttrail.pojos.User;
import com.example.retrofitprojecttrail.recyclerView.itemDecoration;
import com.example.retrofitprojecttrail.view.viewRecyclerInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.RecyclerView.*;

public class MainActivity extends AppCompatActivity implements viewRecyclerInterface
        {

    private RecyclerView recyclerView;
    private LayoutManager layoutManager;
    private RecyclerAdaptor recyclerAdaptor;
    private List<User> users;
    int x;
    private ApiUserInterface apiUserInterface;
  //  ListView listView;
    presenterInt presenterIntObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // listView = findViewById(R.id.listView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new itemDecoration(this));
  //      recyclerView.setHasFixedSize(true);
        presenterIntObj=new presenterImpl(MainActivity.this,this);
        presenterIntObj.getInfoRecycler();
    }

    @Override
    public void getRecyclerView(List<User> users, Context context) {
        recyclerAdaptor = new RecyclerAdaptor(users,context);
        recyclerView.setAdapter(recyclerAdaptor);
    }

}
