package com.spectrum.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {
   List<String> list;
   TextView textV;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_data);
      textV=findViewById(R.id.tv);
      textV.setText("");
      Intent i=getIntent();
      list=(ArrayList)i.getSerializableExtra("key");
      textV.setText(toString(list));
   }

   public String toString(List<String> list) {
      String s="";
      for(String i:list)
         s+=i+"\n";
      return s;
   }
}