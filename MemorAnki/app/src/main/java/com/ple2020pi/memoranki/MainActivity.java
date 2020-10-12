package com.ple2020pi.memoranki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences data;
    private SharedPreferences.Editor editor;
    private boolean lightMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getSharedPreferences( "Config", MODE_PRIVATE);
        editor = data.edit();

        lightMode = data.getBoolean("lightMode", true);

        if (lightMode)
            setTheme(R.style.LightTheme);
        else
            setTheme(R.style.DarkTheme);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_study, R.id.navigation_cards, R.id.navigation_preference)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
