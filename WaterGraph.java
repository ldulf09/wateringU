package com.example.startagain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class WaterGraph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_graph);

        double x,y;
        x = 0;
        GraphView graph = findViewById(R.id.waterGraph);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i <500; i++){
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x,y), true, 500);
        }
        graph.addSeries(series);
    }
}
