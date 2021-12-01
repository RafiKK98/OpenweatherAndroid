package com.iub.openweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView temp1;
    static TextView temp2;
    static TextView temp3;
    static TextView temp4;
    static TextView temp5;
    static TextView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place = findViewById(R.id.place);
        temp1 = findViewById(R.id.temp1);
        temp2 = findViewById(R.id.temp2);
        temp3 = findViewById(R.id.temp3);
        temp4 = findViewById(R.id.temp4);
        temp5 = findViewById(R.id.temp5);


        Weather getData = new Weather();
//        getData.execute("https://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=6a74d0568f1e312900c750047ab804ef&units=metric");
        getData.execute("https://api.openweathermap.org/data/2.5/forecast?q=Dhaka&appid=6a74d0568f1e312900c750047ab804ef&units=metric");
    }
}