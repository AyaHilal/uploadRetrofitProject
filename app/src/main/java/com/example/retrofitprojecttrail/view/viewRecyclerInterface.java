package com.example.retrofitprojecttrail.view;

import android.content.Context;

import com.example.retrofitprojecttrail.pojos.User;

import java.util.List;

/**
 * Created by Aya on 05/04/2018.
 */

public interface viewRecyclerInterface {
    public void getRecyclerView(List<User> users, Context context);
}
