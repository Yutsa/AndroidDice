package com.openclassroomapp.ocdice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        setTitle(R.string.title);

        Button button_6 = (Button) findViewById(R.id.button_6_face);
        Button button_20 = (Button) findViewById(R.id.button_20_face);

        if (button_6 != null) {
            button_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(homepage.this, result.class);
                    intent.putExtra("max", 6);
                    startActivity(intent);
                }
            });
        }

        if (button_20 != null) {
            button_20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(homepage.this, result.class);
                    intent.putExtra("max", 20);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setIcon(R.drawable.logo);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(homepage.this, AboutPage.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}