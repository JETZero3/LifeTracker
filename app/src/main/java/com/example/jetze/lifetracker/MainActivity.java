package com.example.jetze.lifetracker;

import android.annotation.SuppressLint;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    private View mContentView;
    private String[] menuOptions;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        menuOptions = getResources().getStringArray(R.array.menu_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        //mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menuOptions));

        //Set up both player's life totals as integers
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        final Button p1UpBtn = (Button) findViewById(R.id.p1Up);
        Button p1DownBtn = (Button) findViewById(R.id.p1Down);
        Button p2UpBtn = (Button) findViewById(R.id.p2Up);
        Button p2DownBtn = (Button) findViewById(R.id.p2Down);

    }


    public void increaseP1(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        int temp = Integer.parseInt( p1LifeTotal.getText().toString());
        temp = temp + 1;
        p1LifeTotal.setText(Integer.toString(temp));
    }

    public void decreaseP1(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        int temp = Integer.parseInt( p1LifeTotal.getText().toString());
        temp = temp - 1;
        p1LifeTotal.setText(Integer.toString(temp));
    }

    public void increaseP2(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        int temp = Integer.parseInt( p2LifeTotal.getText().toString());
        temp = temp + 1;
        p2LifeTotal.setText(Integer.toString(temp));
    }

    public void decreaseP2(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        int temp = Integer.parseInt( p2LifeTotal.getText().toString());
        temp = temp - 1;
        p2LifeTotal.setText(Integer.toString(temp));
    }
}
