package com.example.newactivity;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LaunchFragment launchFragment = new LaunchFragment();
        getSupportFragmentManager().beginTransaction()
        .add(R.id.activity_main, launchFragment)
                .addToBackStack(null)
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast toast = Toast.makeText(this, getResources().getString(R.string.action_settings),Toast.LENGTH_LONG);
                SettingsFragment settingsFragment = new SettingsFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main, settingsFragment)
                        .addToBackStack(null)
                        .commit();
                toast.show();
                return true;
            case R.id.action_research:
                Toast toast1 = Toast.makeText(this, getResources().getString(R.string.action_research),Toast.LENGTH_LONG);
                 ResearchFragment researchFragment = new ResearchFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main, researchFragment)
                        .addToBackStack(null)
                        .commit();
                toast1.show();
                return true;
            case R.id.action_exit:
                Toast toast2 = Toast.makeText(this, getResources().getString(R.string.action_exit),Toast.LENGTH_LONG);
                toast2.show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
