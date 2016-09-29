package com.projects.yur.carscatalog.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.yur.carscatalog.Activities.CarsListActivity;
import com.projects.yur.carscatalog.R;
import com.projects.yur.carscatalog.Utils.BitmapManager;

/**
 * Created by Yur on 26.09.2016.
 */

public class GridViewAdapter extends BaseAdapter  {
    Context context;
    String[] marks;
    int[] logos;
    LayoutInflater inflater;
    public static final int RESULT_CODE=10;



    public GridViewAdapter(Context context, String[] marks, int[] logos){
        this.context=context;
        this.marks=marks;
        this.logos=logos;
        inflater= (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return marks.length;
    }

    @Override
    public Object getItem(int possition) {
        return possition;
    }

    @Override
    public long getItemId(int possition) {
        return possition;
    }




    public class Holder
    {
        TextView text;
        ImageView image;
    }
    public interface OnItemClick
    {
        public void onUpdateTitle(String title);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View row;

        row = inflater.inflate(R.layout.grid_item, null);
        holder.text=(TextView) row.findViewById(R.id.grid_text);
        holder.image=(ImageView) row.findViewById(R.id.grid_iamge);

        holder.text.setText(marks[position]);
        holder.image.setImageBitmap(BitmapManager.getCircullarBitmapWithBorder(
                BitmapFactory.decodeResource(context.getResources(),logos[position]),7, Color.WHITE));

        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarsListActivity.class);

                intent.putExtra("mark",marks[position]);
                ((Activity) context).startActivityForResult(intent, RESULT_CODE);

            }
        });

        return row;
    }
}
