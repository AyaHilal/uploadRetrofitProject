package com.example.retrofitprojecttrail.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.retrofitprojecttrail.pojos.User;
import com.example.retrofitprojecttrail.presenter.presenterInt;
import com.example.retrofitprojecttrail.view.viewRecyclerInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aya on 05/04/2018.
 */

public class presenterImpl implements presenterInt{
    private List<User> users;
    private ApiUserInterface apiUserInterface;
    viewRecyclerInterface viewRecyclerInterface;
    List<String>urls = new ArrayList<String>();
    Context context;

    public presenterImpl(com.example.retrofitprojecttrail.view.viewRecyclerInterface viewRecyclerInterface,Context context) {
        this.viewRecyclerInterface = viewRecyclerInterface;
        this.context=context;
    }

    @Override
    public void getInfoRecycler() {
        apiUserInterface = ApiUser.getApiClient().create(ApiUserInterface.class);
        //Log.i("hello",apiUserInterface.toString());
        Call<List<User>> call = apiUserInterface.getContacts();
        //Log.i("hello",call.toString());
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                //Log.i("hello","on Response"+call.toString());
                users=response.body();
                for(User u:users)
                {
                    urls.add(u.getImageurl());
                }

                viewRecyclerInterface.getRecyclerView(users,context);
//                for(User u:users)
//                {
//                    Log.i("hello",u.getName());
//                }
//                String[] usersName = new String[users.size()];
//                for(int i=0;i<users.size();i++)
//                {
//                    usersName[i]=users.get(i).getName();
//
//                }
                //Log.i("hello",usersName[0]);
//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,usersName));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("hello",t.getMessage());
                Log.i("hello","failed to get json");
            }
        });

    }
}
