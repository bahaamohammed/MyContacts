package com.bahaadev.mycontacts.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bahaadev.mycontacts.Model.Contact;
import com.bahaadev.mycontacts.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<Contact> contactList;

    public recyclerAdapter(ArrayList<Contact> contactList){
        this.contactList = contactList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName, tvPhone, tvAddress;

        public MyViewHolder(final View view){
            super(view);
            tvName = view.findViewById(R.id.tvContactName);
            tvPhone = view.findViewById(R.id.tvContactNumber);
            tvAddress = view.findViewById(R.id.tvContactAddress);


        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = contactList.get(position).getName();
        String phone = contactList.get(position).getPhone();
        String address = contactList.get(position).getAddress();
        holder.tvName.setText(name);
        holder.tvPhone.setText(phone);
        holder.tvAddress.setText(address);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
