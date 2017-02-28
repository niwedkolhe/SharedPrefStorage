package com.example.itsniv.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * Declare the VARIABLES
     */
    private static final String FILE_NAME="mySharedpref";
    private static final String FIRSTNAME="firstname";
    private static final String SECONDNAME="secondname";
    private EditText editfrstnm,editscndnm;

    //Declare the SharedPrefs
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    /**
     * Initialize the UI Components and Data
     */
    private void init() {
        editfrstnm=(EditText)findViewById(R.id.frstnm);
        editscndnm=(EditText)findViewById(R.id.scndnm);

        Button buttonsubmit=(Button)findViewById(R.id.button_submit);
        Button buttonget=(Button)findViewById(R.id.btn_getdata);

        //Create the SharedPrefs file to Store the Data
        sharedPreferences=getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        // /Add the Click listener to Button
        buttonsubmit.setOnClickListener(this);
        buttonget.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_submit:
                //Take Editor access to Edit the data into SharedPrefs file
                SharedPreferences.Editor edit=sharedPreferences.edit();
                if(editscndnm.getText().toString().length()>0 && editscndnm.getText().toString().length()>0){
                    edit.putString(FIRSTNAME,editfrstnm.getText().toString());
                    edit.putString(SECONDNAME,editscndnm.getText().toString());

                    edit.commit();
                    Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_getdata:
                /**
                 * 1 : KEY for taking values from SharePrefs file
                 * 2 : Default Value return by SharedPref file
                 */
                String firstname= sharedPreferences.getString(FIRSTNAME,"");
                String lastname= sharedPreferences.getString(SECONDNAME,"");

                Toast.makeText(MainActivity.this,"First name: "+firstname+" Second name: "+lastname,Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
