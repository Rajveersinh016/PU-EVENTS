package com.example.pu;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    private Context context;
    private List<DataClass> dataList;

    private  final  RecycleViewInterface recycleViewInterface;

    public MyAdapter(Context context, List<DataClass> dataList,RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.dataList = dataList;
        this.recycleViewInterface = recycleViewInterface;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycleritem, parent, false);
        return new MyViewHolder(view,recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getData_image()).into(holder.recImage);
        holder.recName.setText(dataList.get(position).getData_Name());
        holder.recDate.setText(dataList.get(position).getData_Date());
        holder.recTime.setText(dataList.get(position).getData_Time());
        holder.recPlace.setText(dataList.get(position).getData_Place());
        
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,studentRegister.class);
                intent.putExtra("Name",dataList.get(holder.getAdapterPosition()).getData_Name());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}

class  MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;

    TextView recName,recDate,recTime,recPlace;


    CardView recCard;




    public MyViewHolder(@NonNull View itemView,RecycleViewInterface recycleViewInterface) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recName = itemView.findViewById(R.id.recName);
        recDate = itemView.findViewById(R.id.recDate);
        recTime = itemView.findViewById(R.id.recTime);
        recPlace = itemView.findViewById(R.id.recPlace);
        recCard = itemView.findViewById(R.id.reCard);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( recycleViewInterface != null){
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        recycleViewInterface.onItemClick(pos);
                    }

                }
            }
        });

    }
}