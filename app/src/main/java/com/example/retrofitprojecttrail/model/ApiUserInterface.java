package com.example.retrofitprojecttrail.model;

import com.example.retrofitprojecttrail.pojos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aya on 05/04/2018.
 */

public interface ApiUserInterface {
   @GET("marvel")
   Call<List<User>> getContacts();
}
