package com.projects.yur.carscatalog.Adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.yur.carscatalog.R;
import com.projects.yur.carscatalog.Utils.BitmapManager;

/**
 * Created by Yur on 26.09.2016.
 */

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    Context context;
    LayoutInflater inflater;
    String[] marks,items;
    int logos[];
    int type;
    public CustomSpinnerAdapter(Context context, int textViewResourceId,
                                String[] carMarks, int logos[]) {
        super(context, textViewResourceId, carMarks);
        type=textViewResourceId;
        this.context=context;
        this.marks=carMarks;
        this.logos=logos;
        inflater = (LayoutInflater.from(context));

    }

    public CustomSpinnerAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
        type=textViewResourceId;
        this.context=context;
        this.items=objects;
        inflater = (LayoutInflater.from(context));
    }


    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View row, ViewGroup parent) {
        if (type==R.id.textView) {
            row = inflater.inflate(R.layout.spinner_row_image, null);
            //View row=inflater.inflate(R.layout.spinner_row_image, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textView);
            label.setText(marks[position]);

            ImageView icon = (ImageView) row.findViewById(R.id.imageView);
            icon.setImageBitmap(BitmapManager.getCircullarBitmapWithBorder(
                    BitmapFactory.decodeResource(context.getResources(), logos[position]), 8, Color.WHITE));


        } else {
            row = inflater.inflate(R.layout.spinner_item, null);
            TextView label = (TextView) row.findViewById(R.id.spinner_item);
            label.setText(items[position]);
        }
        return row;
    }

}

