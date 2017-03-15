package com.acadgild.session10;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter{

    public  class FacebookViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView cityTextView;
        public FacebookViewHolder(View itemView) {
            super(itemView);
            nameTextView=(TextView)itemView.findViewById(R.id.name_text);
            cityTextView=(TextView)itemView.findViewById(R.id.city_text);

        }
    }

    List<FacebookUser> users;
    Context context;
    public RecyclerViewAdapter(List<FacebookUser> users, Context context){
        this.users=users;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View singleFacebookUserView= LayoutInflater.from(context).inflate(R.layout.single_user_info,parent,false);
        RecyclerView.ViewHolder facebookViewHolder=new FacebookViewHolder(singleFacebookUserView);
        return facebookViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final String name=users.get(position).getName();
        final String city=users.get(position).getCity();

        FacebookViewHolder facebookViewHolder=(FacebookViewHolder)holder;

        facebookViewHolder.nameTextView.setText(name);
        facebookViewHolder.cityTextView.setText(city);

        facebookViewHolder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Data Deleted "+name, Toast.LENGTH_SHORT).show();
                users.remove(position);
                notifyItemRemoved(position);

                users.add(new FacebookUser(name +" duplicate "+position,city+" "));
                notifyItemInserted(users.size()-1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
