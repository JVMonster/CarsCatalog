package com.projects.yur.carscatalog.Adapters;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.yur.carscatalog.Models.Car;
import com.projects.yur.carscatalog.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

/**
 * Created by Yur on 26.09.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<Car> cars=new ArrayList<Car>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Car car=cars.get(position);
        holder.name.setText(car.getName());
        holder.price.setText(car.getPrice());
        holder.model.setText(car.getModel());
        holder.location.setText(car.getLocation());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,price,model,location;

        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.nameTxt);
            price=(TextView) itemView.findViewById(R.id.priceTxt);
            model=(TextView) itemView.findViewById(R.id.modelTxt);
            location=(TextView) itemView.findViewById(R.id.locationTxt);
        }
    }
}
