package com.example.fragement;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.subjectHolder>  {
    ArrayList personNames;
    Context context;
    //private String[] data;
    /*public adapter(String[] data){
        this.data=data;
    }*/

    public adapter(Context context, ArrayList personNames) {

        this.context = context;
        this.personNames = personNames;
    }

    @NonNull
    @Override
    public subjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list,parent,false);

        return new subjectHolder(view);

    }


    public void onBindViewHolder(@NonNull subjectHolder holder,int position) {
        //Third t=new Third();
        //Bundle bundle=new Bundle();
        String title= (String) personNames.get(position);
        //bundle.putString("name",title);
        holder.name.setText(title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    Toast.makeText(view.getContext(), "Item is clicked "+title, Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putString("title", title);

                Third t = new Third();
                t.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().add(R.id.fragment3, t).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }



    public  class subjectHolder extends RecyclerView.ViewHolder {


        TextView name;

        public subjectHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
        }

    }

}
