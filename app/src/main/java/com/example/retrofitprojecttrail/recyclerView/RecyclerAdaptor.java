package com.example.retrofitprojecttrail.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitprojecttrail.R;
import com.example.retrofitprojecttrail.pojos.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;


/**
 * Created by Aya on 05/04/2018.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyViewHolder>{

    private List<User> users;
    Context context;

    public RecyclerAdaptor(List<User> users,Context context) {
        this.users = users;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.realname.setText(users.get(position).getRealname());
        holder.team.setText(users.get(position).getTeam());
        holder.firstapperance.setText(users.get(position).getFirstapperance());
        holder.createdby.setText(users.get(position).getCreatedby());
        holder.publisher.setText(users.get(position).getPublisher());
        holder.bio.setText(users.get(position).getBio());
        String imageUri = users.get(position).getImageurl();
        Picasso.with(context).load(imageUri).into(holder.imageurl);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends ViewHolder
    {
        TextView name,realname,team,firstapperance,createdby,publisher,bio;
        ImageView imageurl;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            realname=(TextView)itemView.findViewById(R.id.realname);
            team=(TextView)itemView.findViewById(R.id.team);
            firstapperance=(TextView)itemView.findViewById(R.id.firstappearance);
            createdby=(TextView)itemView.findViewById(R.id.createdby);
            publisher=(TextView)itemView.findViewById(R.id.publisher);
            imageurl=(ImageView) itemView.findViewById(R.id.imageurl);
            bio=(TextView)itemView.findViewById(R.id.bio);
        }
    }
}
