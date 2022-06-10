package com.example.expapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expapi.R;
import com.example.expapi.model.User;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {

    List<User> userList;
    public userAdapter(List<User> list){
        this.userList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=userList.get(position);
        if(user==null)
            return;
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvName.setText(user.getUsername());
        holder.tvEmail.setText(user.getEmail());
        holder.tvAddress.setText((CharSequence) user.getAddress());
        holder.tvPhone.setText(user.getPhone());
        holder.tvWebsite.setText(user.getWebsite());
    }

    @Override
    public int getItemCount() {
        if(userList!=null)
            return userList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId,tvName,tvAddress,tvPhone,tvEmail,tvWebsite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tv_id);
            tvName=itemView.findViewById(R.id.tv_name);
            tvAddress=itemView.findViewById(R.id.tv_address);
            tvEmail=itemView.findViewById(R.id.tv_email);
            tvPhone=itemView.findViewById(R.id.tv_phone);
            tvWebsite=itemView.findViewById(R.id.tv_website);
        }
    }
}
