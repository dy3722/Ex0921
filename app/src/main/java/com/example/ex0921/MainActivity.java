package com.example.ex0921;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/**
 * @author David Yusupov <dy3722@bs.amalnet.k12.il>
 * @version 1.0
 * @since 4/1/2026
 * A background color changer
 */
public class MainActivity extends AppCompatActivity {
    Intent si;
    AlertDialog.Builder adb;
    AlertDialog ad;
    LinearLayout ll;
    Random rnd;

    /**
     * Called when the activity is first created.
     * <p>
     * This method initializes the activity, sets the content view to the main layout,
     * and sets up essential components such as the Intent for credits, the main layout
     * container, and the random number generator.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     * being shut down then this Bundle contains the data it most recently supplied.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        si = new Intent(this,CreditsActivity.class);
        ll = findViewById(R.id.main);
        rnd = new Random();
    }

    /**
     * Generates a random color from a predefined set of colors.
     * <p>
     * This method selects a random integer between 0 and 8 (inclusive) and maps
     * it to a specific Color constant.
     *
     * @return An integer representing a color constant (e.g., Color.RED, Color.GREEN).
     */
    public int rndColor()
    {
        int rndNum = rnd.nextInt(9);
        switch (rndNum)
        {
            case 0: return Color.RED;
            case 1: return Color.GREEN;
            case 2: return Color.BLUE;
            case 3: return Color.YELLOW;
            case 4: return Color.GRAY;
            case 5: return Color.MAGENTA;
            case 6: return Color.CYAN;
            case 7: return Color.LTGRAY;
        }
        return Color.DKGRAY;
    }

    /**
     * Initialize the contents of the Activity's standard options menu.
     * <p>
     * This method inflates the menu resource (R.menu.main) into the provided Menu
     * object and adds the items to the action bar.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * <p>
     * This implementation checks if the selected item is the "Credits" menu item
     * and, if so, starts the activity defined by the Intent 'si'.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed,
     * true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuCtedits)
        {
            startActivity(si);
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Displays a simple alert dialog containing only a title and a message.
     * <p>
     * This method initializes an AlertDialog builder, sets a static title and
     * message, and then creates and displays the dialog to the user.
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void onlyText(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("Only text");
        adb.setMessage("Only text");

        ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog containing a title, a message, and a specific icon.
     * <p>
     * This method initializes an AlertDialog builder, sets the text content,
     * and attaches a drawable resource (R.drawable.icon_smile) as the dialog's icon.
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void textAndIcon(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("Text and icon");
        adb.setMessage("Text and icon");
        adb.setIcon(R.drawable.icon_smile);

        ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with a title, message, icon, and a cancel button.
     * <p>
     * This method configures the dialog to be non-cancelable via the back button or
     * clicking outside. It includes a negative button that dismisses the dialog.
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void textAndIconAndCancel(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("Text and icon and cancel");
        adb.setMessage("Text and icon and cancel");
        adb.setIcon(R.drawable.icon_smile);
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);

        ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog that allows the user to change the background color.
     * <p>
     * This method creates a non-cancelable dialog with two options: a positive button
     * that sets the layout's background to a random color using rndColor(),
     * and a negative button to dismiss the dialog.
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void changeColor(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("Change color");
        adb.setMessage("Change to random color or cancel");
        adb.setIcon(R.drawable.icon_smile);
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(rndColor());
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);

        ad = adb.create();
        ad.show();
    }


    /**
     * Displays an alert dialog with options to change, reset, or cancel the background color.
     * <p>
     * This method provides three choices: a positive button to set a random color,
     * a neutral button to reset the background to white, and a negative button
     * to dismiss the dialog without changes.
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void changeColorOrReset(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("Change color or reset");
        adb.setMessage("Change to random color or reset");
        adb.setIcon(R.drawable.icon_smile);
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(rndColor());
            }
        });
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);

        ad = adb.create();
        ad.show();
    }
}