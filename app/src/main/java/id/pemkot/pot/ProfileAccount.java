package id.pemkot.pot;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class ProfileAccount extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_account);
        //Check if the app has been run before.
        boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        if (firstrun){
            new AlertDialog.Builder(this)
                    .setTitle("Welcome!") //set the Title text
                    .setIcon(R.drawable.ololololo) //Set the picture in the top left of the popup
                    .setMessage("This dialog will only appear once." +
                            " In order to see it again you must either clear the app data (settings->apps->ManageAps) or uninstall then reinstall the app.")
                    .setNeutralButton("OK", null).show(); //Sets the button type
        }
        // Save the state with shared preferences
        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putBoolean("firstrun", false)
                .commit();
    }


    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        finish();
    }
}