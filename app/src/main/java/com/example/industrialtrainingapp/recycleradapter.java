package com.example.industrialtrainingapp;


import static com.google.firebase.database.ktx.DatabaseKt.getSnapshots;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
public class recycleradapter extends RecyclerView.Adapter<recycleradapter.ViewHolder> {
    Context context;
    ArrayList<itemlist> list;
    ArrayList<DocumentSnapshot> documents;

    public recycleradapter(Recycler context, ArrayList<itemlist> list) {
        this.context=context;
        this.list=list;
    }
    public void setFilteredList(ArrayList<itemlist>filteredList){
        this.list=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
            return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.name.setText(list.get(position).getName());
            holder.roll.setText(list.get(position).getRoll());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemlist selectedStudent = list.get(position);
                Intent i = new Intent(context, three.class);
                Intent j = new Intent(context, firstyear.class);
                i.putExtra("selectedStudent", selectedStudent);
                j.putExtra("selectedStudent", selectedStudent);// Pass the UserModel object
                context.startActivity(i);
            }
        });
            }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, roll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roll = itemView.findViewById(R.id.textView9);
            name = itemView.findViewById(R.id.textView8);
        }
    }
}
