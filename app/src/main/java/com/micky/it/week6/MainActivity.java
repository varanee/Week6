package com.micky.it.week6;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    TextView tv;
    Button btn1;
    Button btn2;
    //AbsoluteLayout ab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        edt1 = (EditText) findViewById(R.id.editText3);
        tv = (TextView)findViewById(R.id.textView2);

        //ab = (AbsoluteLayout)findViewById(R.id.layout1);
       // ab.setBackgroundColor(Color.CYAN);


        String filename = "myfile";
        String string = "Hello world!";
        File file = new File(this.getFilesDir(), filename);

        try {
            FileOutputStream outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            InputStream is = this.openFileInput(filename);
            if (is != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = " ";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    inputStreamReader.close();
                    String ret = stringBuilder.toString();

                    Toast toast = Toast.makeText(this, ret, Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        } catch (IOException e) {
            Log.e("Login activity", "Can not read file:" + e.toString());
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }



}



