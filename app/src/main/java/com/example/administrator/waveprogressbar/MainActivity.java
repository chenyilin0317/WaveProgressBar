package com.example.administrator.waveprogressbar;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mylibrary.WaveProgress;

public class MainActivity extends AppCompatActivity {

    private Thread thread;
    private WaveProgress mProgress1;
    private WaveProgress mProgress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress1 = (WaveProgress) findViewById(R.id.progress1);
        mProgress2 = (WaveProgress) findViewById(R.id.progress2);
        setViewProgress();
        thread.start();
    }

    public void setViewProgress(){
        thread = new Thread() {
            int progress=0;
            @Override
            public void run() {
                while (progress!=100) {
                    progress++;
                    SystemClock.sleep(100);
                    mProgress1.setProgress(progress);
                    mProgress2.setProgress(progress);
                }
            }
        };
    }

}
