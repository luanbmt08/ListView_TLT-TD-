package com.google.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ListView listview;
        ArrayList<MonAn> arrayList;
        AdapterMonAn adapter;
        Boolean kt=false;
        int j=0;


       listview = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>() ;
        arrayList.add ( new MonAn ( "CÁ CHIÊN" ,"Cá mà chiên " ,"150.000", R.drawable.img ) ) ;
                arrayList.add ( new MonAn ( "HEO QUAY" , "Heo mà quay " ,"100.000", R.drawable.img_1 ) ) ;
        arrayList.add ( new MonAn ( "RAM CUỐN" , "Ram mà cuốn" , "80.000",R.drawable.img_2 ) ) ;
        arrayList.add ( new MonAn ( "VỊT QUAY" , "Vịt mà quay" ,"200.000", R.drawable.img_4 ) ) ;
        arrayList.add ( new MonAn ( "TÔM NƯỚNG" , "tôm mà nướng" ,"120.000", R.drawable.img_5 ) ) ;

        adapter = new AdapterMonAn ( MainActivity.this,R.layout.layout_monan ,arrayList) ;
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MainActivity2.class);
                    startActivity(intent);

            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent ,View view ,int position , long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xac nhan");
                dialog.setMessage("Ban co dong y xoa khong");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    } }
