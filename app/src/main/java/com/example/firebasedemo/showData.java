package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

 class Adapter extends ArrayAdapter {

     public Adapter(@NonNull Context context, ArrayList<String> data ,int background) {
        super(context,0,data);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;


        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.listitemview,parent,false);
        }
        String dataItem=(String) getItem(position);


        TextView textView= (TextView) listItemView.findViewById(R.id.displayname);
        textView.setText(dataItem);

        return listItemView;

    }

}

public class showData extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ListView listView = (ListView) findViewById(R.id.listview);
        Adapter adapter= new Adapter(getApplicationContext(),MainActivity.data,0);
        listView.setAdapter(adapter);




    }

}
