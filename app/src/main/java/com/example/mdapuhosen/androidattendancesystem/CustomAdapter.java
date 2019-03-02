package com.example.mdapuhosen.androidattendancesystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] image;
    String[] Feature;
    private LayoutInflater Inflater;
    CustomAdapter(Context context,String[] Feature,int[] image){
      this.context = context;
      this.Feature = Feature;
      this.image = image;
    }
    @Override
    public int getCount() {
        return Feature.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
           Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = Inflater.inflate(R.layout.grid,parent,false);

        }
        ImageView imageView = convertView.findViewById(R.id.imageHolder);
        TextView textView = convertView.findViewById(R.id.namePlacer);
        imageView.setImageResource(image[position]);
        textView.setText(Feature[position]);
        return convertView;
    }
}
