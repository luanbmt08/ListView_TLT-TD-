package com.google.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class AdapterMonAn extends BaseAdapter {

    private Context context ;
    private int layout ;
    private List<MonAn> arraylist;

    public AdapterMonAn(Context context, int layout, List<MonAn> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
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
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        MonAn monAn = arraylist.get(position);

        TextView textV1 = convertView.findViewById(R.id.name);
        TextView textV2 = convertView.findViewById(R.id.mota);
        TextView textV3 = convertView.findViewById(R.id.gia);
        ImageView imageV = convertView.findViewById(R.id.imageHinh);

        textV1.setText (monAn.getTenmon()) ;
        textV2.setText (monAn.getMota()) ;
        textV3.setText (monAn.getGia()) ;
        imageV.setImageResource(monAn.getHinh()) ;
        return convertView;
    }
}