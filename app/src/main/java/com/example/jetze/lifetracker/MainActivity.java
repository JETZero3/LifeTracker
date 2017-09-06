package com.example.jetze.lifetracker;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
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

    public static final String Life = "StartingLife";
    public static final String Commander = "Commander";
    public static final String Infect = "Infect";
    public static final String Players = "Players";
    int p1Life, p2Life, p3Life, p4Life, numPlayers, startingLife = 20;
    static final String savedP1 = "P1";
    static final String savedP2 = "P2";
    static final String savedP3 = "P3";
    static final String savedP4 = "P4";
    String[] lifeChoices = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50"};
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

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Set up both player's life totals
        if (savedInstanceState != null){
            p1Life = savedInstanceState.getInt(savedP1);
            p2Life = savedInstanceState.getInt(savedP2);
            p3Life = savedInstanceState.getInt(savedP3);
            p4Life = savedInstanceState.getInt(savedP4);
            numPlayers = savedInstanceState.getInt(Players);
            startingLife = savedInstanceState.getInt(Life);
            if (numPlayers == 4)
                set4visibility();
            else
                set2visibility();
        }

        else if (sharedPreferences.contains(savedP1 )){
            p1Life = sharedPreferences.getInt(savedP1, 0);
            p2Life = sharedPreferences.getInt(savedP2, 0);
            p3Life = sharedPreferences.getInt(savedP3, 0);
            p4Life = sharedPreferences.getInt(savedP4, 0);
            numPlayers = sharedPreferences.getInt(Players, 2);
            startingLife = sharedPreferences.getInt(Life, 20);
            if (numPlayers == 4)
                set4visibility();
            else
                set2visibility();
        }
        else{
            startingLife = 20;
            p1Life = startingLife;
            p2Life = startingLife;
            p3Life = startingLife;
            p4Life = startingLife;
            numPlayers = 2;

            set2visibility();
        }
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1LifeTotal.setTextColor(Color.RED);
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2LifeTotal.setTextColor(Color.BLUE);
        final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
        p3LifeTotal.setTextColor(Color.GREEN);
        final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
        p4LifeTotal.setTextColor(Color.WHITE);
        p1LifeTotal.setText(Integer.toString(p1Life));
        p2LifeTotal.setText(Integer.toString(p2Life));
        p3LifeTotal.setText(Integer.toString(p3Life));
        p4LifeTotal.setText(Integer.toString(p4Life));
        final Button p1UpBtn = (Button) findViewById(R.id.p1Up);
        final Button p1DownBtn = (Button) findViewById(R.id.p1Down);
        final Button p2UpBtn = (Button) findViewById(R.id.p2Up);
        final Button p2DownBtn = (Button) findViewById(R.id.p2Down);

    }


    public void increaseP1(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1Life = p1Life + 1;
        p1LifeTotal.setText(Integer.toString(p1Life));
    }

    public void decreaseP1(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1Life = p1Life - 1;
        p1LifeTotal.setText(Integer.toString(p1Life));
    }

    public void increaseP2(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2Life = p2Life + 1;
        p2LifeTotal.setText(Integer.toString(p2Life));
    }


    public void decreaseP2(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2Life = p2Life - 1;
        p2LifeTotal.setText(Integer.toString(p2Life));
    }

    public void increaseP3(View view){
        final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
        p3Life = p3Life + 1;
        p3LifeTotal.setText(Integer.toString(p3Life));
    }

    public void decreaseP3(View view){
        final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
        p3Life = p3Life - 1;
        p3LifeTotal.setText(Integer.toString(p3Life));
    }

    public void increaseP4(View view){
        final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
        p4Life = p4Life + 1;
        p4LifeTotal.setText(Integer.toString(p4Life));
    }


    public void decreaseP4(View view){
        final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
        p4Life = p4Life - 1;
        p4LifeTotal.setText(Integer.toString(p4Life));
    }
    public void increaseP1_5(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1Life = p1Life + 5;
        p1LifeTotal.setText(Integer.toString(p1Life));
    }

    public void decreaseP1_5(View view){
        final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
        p1Life = p1Life - 5;
        p1LifeTotal.setText(Integer.toString(p1Life));
    }

    public void increaseP2_5(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2Life = p2Life + 5;
        p2LifeTotal.setText(Integer.toString(p2Life));
    }


    public void decreaseP2_5(View view){
        final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
        p2Life = p2Life - 5;
        p2LifeTotal.setText(Integer.toString(p2Life));
    }

    public void increaseP3_5(View view){
        final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
        p3Life = p3Life + 5;
        p3LifeTotal.setText(Integer.toString(p3Life));
    }

    public void decreaseP3_5(View view){
        final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
        p3Life = p3Life - 5;
        p3LifeTotal.setText(Integer.toString(p3Life));
    }

    public void increaseP4_5(View view){
        final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
        p4Life = p4Life + 5;
        p4LifeTotal.setText(Integer.toString(p4Life));
    }


    public void decreaseP4_5(View view){
        final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
        p4Life = p4Life - 5;
        p4LifeTotal.setText(Integer.toString(p4Life));
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void set2visibility() {
        final LinearLayout p3p4 = (LinearLayout) findViewById(R.id.p3p4);
        final LinearLayout p3p4Buttons = (LinearLayout) findViewById(R.id.p3p4Buttons);
        p3p4.setVisibility(View.GONE);
        p3p4Buttons.setVisibility(View.GONE);
        numPlayers = 2;
    }

    private void set4visibility() {
        final LinearLayout p3p4 = (LinearLayout) findViewById(R.id.p3p4);
        final LinearLayout p3p4Buttons = (LinearLayout) findViewById(R.id.p3p4Buttons);
        p3p4.setVisibility(View.VISIBLE);
        p3p4Buttons.setVisibility(View.VISIBLE);
        numPlayers = 4;
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
                    final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
                    final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
                    p1Life = startingLife;
                    p2Life = startingLife;
                    p3Life = startingLife;
                    p4Life = startingLife;
                    p1LifeTotal.setText(Integer.toString(startingLife));
                    p2LifeTotal.setText(Integer.toString(startingLife));
                    p3LifeTotal.setText(Integer.toString(startingLife));
                    p4LifeTotal.setText(Integer.toString(startingLife));
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
        }else if (position == 1){
            AlertDialog.Builder playerBuilder = new AlertDialog.Builder(MainActivity.this);
            playerBuilder.setTitle("Set number of players.");
            playerBuilder.setCancelable(true);
            playerBuilder.setItems(R.array.players, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int position){
                    if (position == 0){
                        set2visibility();
                    }
                    else if (position == 1){
                        set4visibility();
                    }
                }
            });
            AlertDialog playerAlert = playerBuilder.create();
            playerAlert.show();
        }
        else if (position == 2) {
            final NumberPicker numberPicker = new NumberPicker(MainActivity.this);
            numberPicker.setMaxValue(lifeChoices.length);
            numberPicker.setMinValue(1);
            numberPicker.setDisplayedValues(lifeChoices);
            numberPicker.setValue(startingLife/5);
            AlertDialog.Builder lifeBuilder = new AlertDialog.Builder(MainActivity.this);
            lifeBuilder.setMessage("Set the starting life.");
            lifeBuilder.setView(numberPicker);
            lifeBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startingLife = numberPicker.getValue() * 5;
                    dialog.cancel();

                    AlertDialog.Builder newGameBuilder = new AlertDialog.Builder(MainActivity.this);
                    newGameBuilder.setMessage("Start a new game?");
                    newGameBuilder.setCancelable(true);

                    newGameBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            final TextView p1LifeTotal = (TextView) findViewById(R.id.p1Life);
                            final TextView p2LifeTotal = (TextView) findViewById(R.id.p2Life);
                            final TextView p3LifeTotal = (TextView) findViewById(R.id.p3Life);
                            final TextView p4LifeTotal = (TextView) findViewById(R.id.p4Life);
                            p1Life = startingLife;
                            p2Life = startingLife;
                            p3Life = startingLife;
                            p4Life = startingLife;
                            p1LifeTotal.setText(Integer.toString(startingLife));
                            p2LifeTotal.setText(Integer.toString(startingLife));
                            p3LifeTotal.setText(Integer.toString(startingLife));
                            p4LifeTotal.setText(Integer.toString(startingLife));
                            dialog.cancel();

                        }
                    });
                    newGameBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog newGameAlert = newGameBuilder.create();
                    newGameAlert.show();
                    newGameAlert.getWindow().setLayout(400, 200);


                }
            });
            lifeBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog lifeAlert = lifeBuilder.create();
            lifeAlert.show();

        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        //Save life totals
        savedInstanceState.putInt(savedP1, p1Life);
        savedInstanceState.putInt(savedP2, p2Life);
        savedInstanceState.putInt(savedP3, p3Life);
        savedInstanceState.putInt(savedP4, p4Life);
        savedInstanceState.putInt(Players, numPlayers);
        savedInstanceState.putInt(Life, startingLife);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onStop(){
        super.onStop();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(savedP1, p1Life);
        editor.putInt(savedP2, p2Life);
        editor.putInt(savedP3, p3Life);
        editor.putInt(savedP4, p4Life);
        editor.putInt(Players, numPlayers);
        editor.putInt(Life, startingLife);
        editor.apply();
    }

}
