package com.openclassroomapp.ocdice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * @author Édouard WILLISSECK
 */
public class result extends AppCompatActivity implements View.OnClickListener {
    private TextView diceResult;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_result_layout);

        max = getIntent().getIntExtra("max", 0);

        TextView dice_label = (TextView) findViewById(R.id.dice_label);

        if (max == 6)
            dice_label.setText(R.string.de_6);
        else
            dice_label.setText(R.string.de_20);

        diceResult = (TextView) findViewById(R.id.dice_result);
        diceResult.setText("");

        Button rollButton = (Button) findViewById(R.id.button_reroll);
        rollButton.setOnClickListener(this);
    }

    public int rollDice(int max) {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }

    @Override
    public void onClick(View v) {
        int result = rollDice(this.max);
        diceResult.setText("" + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(result.this, AboutPage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
