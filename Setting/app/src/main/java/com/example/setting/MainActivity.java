package com.example.setting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SharedPreferences msharedpreference;
    String mcount;
    String backgroundColor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        msharedpreference = PreferenceManager.getDefaultSharedPreferences(this);

        mcount = msharedpreference.getString("editText_pref", "0");
        textView.setText(mcount);

        backgroundColor = msharedpreference.getString("backgroundColor_pref", getString(R.string.default_background_color));
        textView.setBackgroundColor(Color.parseColor(backgroundColor));


    }

    @Override
    protected void onResume() {
        super.onResume();
        msharedpreference = PreferenceManager.getDefaultSharedPreferences(this);

        mcount = msharedpreference.getString("editText_pref", "0");
        textView.setText(mcount);

        backgroundColor = msharedpreference.getString("backgroundColor_pref", getString(R.string.default_background_color));
        textView.setBackgroundColor(Color.parseColor(backgroundColor));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.setting)
        {
            Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
