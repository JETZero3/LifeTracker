package com.example.jetze.lifetracker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
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

    public static final String FileName = "LTPrefs";
    public static final String Preferences = "MyPrefs";
    public static final String Life = "StartingLife";
    public static final String Commander = "Commander";
    public static final String Infect = "Infect";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        menuOptions = getResources().getStringArray(R.array.menu_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menuOptions));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //Set up both player's life totals as integers
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1LifeTotal.setTextColor(Color.RED);
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2LifeTotal.setTextColor(Color.BLUE);
        final Button p1UpBtn = (Button) findViewById(R.id.p1Up);
        final Button p1DownBtn = (Button) findViewById(R.id.p1Down);
        final Button p2UpBtn = (Button) findViewById(R.id.p2Up);
        final Button p2DownBtn = (Button) findViewById(R.id.p2Down);

        //sharedPreferences = getSharedPreferences(FileName, Context.MODE_PRIVATE);
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

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        if (position == 0){
            AlertDialog.Builder newGameBuilder = new AlertDialog.Builder(MainActivity.this);
            newGameBuilder.setMessage("Are you sure?");
            newGameBuilder.setCancelable(true);

            newGameBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
                    final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
                    p1LifeTotal.setText(Integer.toString(getResources().getInteger(R.integer.starting_life)));
                    p2LifeTotal.setText(Integer.toString(getResources().getInteger(R.integer.starting_life)));
                    dialog.cancel();

                }
            });
            newGameBuilder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                }
            });
            AlertDialog newGameAlert = newGameBuilder.create();
            newGameAlert.show();
            newGameAlert.getWindow().setLayout(400, 200);
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }


}
