package com.example.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ItemClickListener clickListener;
// 1- Data Source
    private ModelClass[] listData;

    public CustomAdapter(ModelClass[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener){
        this.clickListener=clickListener;
    }


//    2-view holder class

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView =  itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (clickListener!=null){
                clickListener.onClick(view,getAdapterPosition());
            }
        }
    }
//    3 impleting the methods

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.my_layout,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelClass  mylistData=listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}
