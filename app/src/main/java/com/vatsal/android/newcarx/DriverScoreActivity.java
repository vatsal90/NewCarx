package com.vatsal.android.newcarx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DriverScoreActivity extends AppCompatActivity {

    private Button mHard_Breaking;
    private Button mRapid_Accels;
    private Button mSpeeding;
    private Button mIdle_Time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverscore);

        mHard_Breaking = (Button) findViewById(R.id.Hard_Breaking);
        mHard_Breaking.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        });

        mRapid_Accels = (Button) findViewById(R.id.Rapid_Accels);
        mRapid_Accels.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

            }
        });

        mSpeeding = (Button) findViewById(R.id.Speeding);
        mSpeeding.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

            }
        });

        mIdle_Time = (Button) findViewById(R.id.Idle_Time);
        mIdle_Time.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

            }
        });

    }
    }


