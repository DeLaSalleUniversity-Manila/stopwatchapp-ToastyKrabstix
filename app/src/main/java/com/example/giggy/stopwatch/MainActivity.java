package com.example.giggy.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    private int sec = 0;
    private boolean prevRun = false;
    private boolean curRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            sec = savedInstanceState.getInt("seconds");
            curRun = savedInstanceState.getBoolean("curRun");
            prevRun = savedInstanceState.getBoolean("prevRun");
        }
        startTime();
    }

    @Override
    protected void onStart(){
        super.onStart();
        curRun = prevRun;
    }

    @Override
    protected void onResume(){
        super.onResume();
        curRun = prevRun;
    }

    @Override
    protected void onStop(){
        super.onStop();
        prevRun = curRun;
        curRun = false;
    }

    @Override
    protected void onPause(){
        super.onPause();
        prevRun = curRun;
        curRun= false;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", sec);
        savedInstanceState.putBoolean("prevRun", prevRun);
        savedInstanceState.putBoolean("curRun", curRun);
    }

    public void onClickStop(View view){
        curRun = false;
    }
    public void onClickStart(View view){
        curRun= true;
    }
    public void onClickReset(View view){
        curRun = false;
        sec = 0;
    }

    private void startTime(){
       final TextView time = (TextView)findViewById(R.id.timertext);
        final Handler handle = new Handler();
        handle.post(new Runnable(){
           @Override
        public void run(){
               int hours = sec/3600;
               int mins = (sec%3600)/60;
               int secs = sec%60;
               String timer = String.format("%d:%02d:%02d", hours, mins,secs);
               time.setText(timer);
               if(curRun){
                   sec++;
               }
               handle.postDelayed(this, 1000);
           }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
