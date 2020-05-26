package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private FirebaseDatabase database;
    private DatabaseReference dbref;
    private EditText nameView;
    private String name;
    private int maxid=0;
    public static ArrayList<String> data= new ArrayList<>();



    public void enterdata(View view){
        name= nameView.getText().toString();
        dbref.child(String.valueOf(maxid+1)).setValue(name);

        Toast.makeText(this,"name added",Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit= (Button) findViewById(R.id.submit);
        nameView= (EditText) findViewById(R.id.NameText);

        dbref= database.getInstance().getReference().child("users");

        dbref.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    maxid= (int) dataSnapshot.getChildrenCount();

                    data=new ArrayList<String>();
                    for(int i=1;i<=maxid;i++){
                        data.add(dataSnapshot.child(String.valueOf(i)).getValue().toString());
                    }
                }
                else{
                    //
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }


        });



    }

    public void Viewdata(View view) {

        Intent i= new Intent(this,showData.class);
        startActivity(i);
    }
}
