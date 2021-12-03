package com.example.startagain;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    FloatingActionButton switchToUserProfile;
    FloatingActionButton switchToSettings;
    FloatingActionButton switchToWaterGraph;
    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra(UserProfile.USER_NAME);
        int weight = intent.getIntExtra(UserProfile.USER_WEIGHT, 137);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText("hello " + name + ",");

        switchToSettings = findViewById(R.id.floatingActionButton13);
        switchToSettings.setOnClickListener(view -> switchSettingsPage());

        switchToWaterGraph = findViewById(R.id.floatingActionButton14);
        switchToWaterGraph.setOnClickListener(view -> switchGraphPage());

        switchToUserProfile = findViewById(R.id.floatingActionButton15);
        switchToUserProfile.setOnClickListener(view -> switchProfilePage());

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLoadingText = (TextView) findViewById(R.id.progressText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

    }

    private void switchSettingsPage() {
        Intent switchSettings = new Intent(this, Settings.class);
        startActivity(switchSettings);
    }
    private void switchGraphPage() {
        Intent switchWaterGraph = new Intent(this, WaterGraph.class);
        startActivity(switchWaterGraph);
    }
    private void switchProfilePage() {
        Intent switchUserProfile = new Intent(this, UserProfile.class);
        startActivity(switchUserProfile);
    }
}