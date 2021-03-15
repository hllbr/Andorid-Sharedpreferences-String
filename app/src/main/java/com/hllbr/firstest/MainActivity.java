package com.hllbr.firstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    String name;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        editText = findViewById(R.id.editText);
        prefs = this.getSharedPreferences("com.hllbr.firstest",Context.MODE_PRIVATE);
        name = prefs.getString("name", "No name defined");

        if(name.equals("No name defined")){
            textView.setText("??");
        }else{
            textView.setText("your Name "+ name);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (name.equals("No name defined")){
            textView.setText("YOUR NAME !!");
        }else{
            textView.setText("your name1 : "+name);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (name.equals("No name defined")){
            textView.setText("YOUR NAME !!");
        }else{
            textView.setText("your name2 : "+name);
        }


    }

    public void save(View view){
        if(editText.getText().toString().matches("No name defined")){
            textView.setText("enyer your name");
        }else{
            String name1 = editText.getText().toString();
            textView.setText("your name "+name1);

            prefs.edit().putString("name",name1).apply();
        }
    }
}