package com.example.dim.wineroom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * todo clear code
 * todo declare view bindings
 * todo create data logic
 * todo search spinners logic
 * todo test data filter and dataSort
 * todo color selected spinner for searchDrawer
 *
 */
public class WelcomeWine extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private final String ARG_WELCOME="WelcomeWine";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_wine);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<String> strList= new ArrayList<>();
        strList.add("totoA");
        strList.add("totoB");
        strList.add("totoC");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, strList) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView)view.findViewById(android.R.id.text1)).setTextColor(getResources().getColor(R.color.colorBlack));
                return view;
            }
        };
        ((ListView)findViewById(R.id.nav_right)).setAdapter(adapter);

        Spinner spinnerFilter = (Spinner) findViewById(R.id.spinnerFilter);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterFilter = ArrayAdapter.createFromResource(this,
                R.array.action_filter_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterFilter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerFilter.setAdapter(adapterFilter);

        spinnerFilter.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItem() != null) {
                    Spinner spinnerSort = (Spinner) findViewById(R.id.spinnerSort);
                    String s = adapterView.getSelectedItem().toString();
                    Log.i(ARG_WELCOME, "spinnerFilter.OnItemSelectedListener.onItemSelected : "+s);
                    if (s.equalsIgnoreCase("vins")) {
                        ArrayAdapter<CharSequence> adapterSorter = ArrayAdapter.createFromResource(getApplicationContext(),
                                R.array.action_sort_array_vins, android.R.layout.simple_spinner_item);
                        adapterSorter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerSort.setAdapter(adapterSorter);
                    } else {
                        ArrayAdapter<CharSequence> adapterSorter = ArrayAdapter.createFromResource(getApplicationContext(),
                                R.array.action_sort_array_vignerons, android.R.layout.simple_spinner_item);
                        adapterSorter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerSort.setAdapter(adapterSorter);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.i(ARG_WELCOME, "spinnerFilter.OnItemSelectedListener.onNothingSelected !");

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            ((DrawerLayout)findViewById(R.id.drawer_layout)).openDrawer(Gravity.RIGHT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*
        if (id == R.id.nav_maCave) {
            // Handle the camera action
        } else if (id == R.id.nav_mesVignerons) {

        } else if (id == R.id.nav_search_vin) {
           // getLayoutInflater().inflate(R.layout.list_item_search, item.)
        } else if (id == R.id.nav_search_vigneron) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
