package com.Amisha.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Amisha.myapplication.R;
import com.Amisha.myapplication.UserDataModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<UserDataModel> dataList;

    public RecyclerViewAdapter(ArrayList<UserDataModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(dataList.get(position).getName());
        holder.tvAge.setText(String.valueOf(dataList.get(position).getAge()));
        holder.tvOccupation.setText(dataList.get(position).getOccupation());
        holder.tvAddress.setText(dataList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAge,tvOccupation,tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvOccupation = itemView.findViewById(R.id.tvOccupation);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }
}

