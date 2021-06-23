package com.spectrum.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   EditText name,branch,year,redg;
   List<String> list;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      list=new ArrayList<>();
      name=findViewById(R.id.editName);
      branch=findViewById(R.id.editBranch);
      year=findViewById(R.id.editYear);
      redg=findViewById(R.id.editRedg);
   }

   public void lunch(View view) {
      if(check()) return;
      list.add(name.getText().toString());
      list.add(branch.getText().toString());
      list.add(year.getText().toString());
      list.add(redg.getText().toString());
      Intent i=new Intent(MainActivity.this,DataActivity.class);
      i.putExtra("key", (Serializable) list);
      startActivity(i);
      reset();
   }

   private boolean check() {
      if(name.getText().toString().length()!=0)
         if(branch.getText().toString().length()!=0)
            if(year.getText().toString().length()!=0 && year.getText().toString().length()<=4)
               if(redg.getText().toString().length()!=0)
                  return false;
               else Error(redg,"Write a Valid Registration Number");
            else Error(year,"Write a Valid Year");
         else Error(branch,"Write a Valid Branch");
      else Error(name,"Write a Valid Name");
      return true;
   }

   public void Error(View v,String s){
      Vibrator vibrator=(Vibrator) getSystemService(this.VIBRATOR_SERVICE);
      EditText e=(EditText) v;
      e.startAnimation(AnimationUtils.loadAnimation(this,R.anim.shake));
      vibrator.vibrate(70);
      e.setError(s);
      e.requestFocus();
   }

   private void reset() {
      name.setText("");
      year.setText("");
      branch.setText("");
      redg.setText("");
   }
}