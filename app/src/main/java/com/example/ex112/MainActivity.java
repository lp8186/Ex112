package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Liad Peretz
 * @version 1.0
 * @since 15 /12/20
 * Short description- Practice for Shared Preferences.
 */
public class MainActivity extends AppCompatActivity {

    String text2;
    int num;
    TextView number;
    EditText text1;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number= (TextView) findViewById(R.id.number);
        text1= (EditText) findViewById(R.id.text1);

        SharedPreferences settings= getSharedPreferences("TEXT_AND_NUM",MODE_PRIVATE);

        text2= settings.getString("Text","Enter Something");
        num= settings.getInt("Number", 0);

        number.setText(String.valueOf(num));
        text1.setHint(text2);


    }

    /**
     * Count
     * Short descriptions- Defines num= num+1.
     * <p>
     *    View view
     * @param view the view
     */
    public void count(View view) {
        num++;
        number.setText(String.valueOf(num));

    }

    /**
     * Reset
     * Short descriptions- Defines num= num+1.
     * <p>
     *    View view
     * @param view the view
     */
    public void reset(View view) {
        num=0;
        number.setText(String.valueOf(num));
    }

    /**
     * Exit
     * Short descriptions- Save the information and close the app.
     * <p>
     *    View view
     * @param view the view
     */
    public void exit(View view) {
        text2= text1.getText().toString();
        SharedPreferences.Editor editor= getSharedPreferences("TEXT_AND_NUM",MODE_PRIVATE).edit();
        editor.putString("Text",text2);
        editor.putInt("Number",num);
        editor.commit();
        finish();

    }

    /**
     * OnCreateOptionsMenu
     * Short descriptions- Creates an options menu.
     * <p>
     *    Menu menu
     * @param menu the menu
     * @return true if it worked.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0, 0, 100, "Credits");
        return true;
    }

    /**
     * OnOptionsItemSelected
     * Short description- Starts the credits activity.
     * <p>
     *     MenuItem item
     * @param item the selected item
     * @return true if it worked.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent si = new Intent(this, Credits.class);
        startActivity(si);
        return true;
    }
}