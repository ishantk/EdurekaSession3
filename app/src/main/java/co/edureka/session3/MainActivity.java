package co.edureka.session3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // References to the Views. by default : they are null
    EditText eTxtName;
    EditText eTxtData;
    Button btnSubmit;

    void initViews() {
        eTxtName = (EditText) findViewById(R.id.editTextName);
        eTxtData = (EditText) findViewById(R.id.editTextData);

        btnSubmit = (Button) findViewById(R.id.button);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("keyName",eTxtName.getText().toString());
        outState.putString("keyData",eTxtData.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        eTxtName.setText(savedInstanceState.getString("keyName"));
        eTxtData.setText(savedInstanceState.getString("keyData"));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Toast.makeText(this,"MainActivity - onCreate--",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {

            // Read the content from EditText
            //String name = eTxtName.getText().toString();
            //String data = eTxtData.getText().toString();


            // USAGE OF INTENT : To Navigate from one Component to Other

            // Create an Intent
            /*Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_TEXT,data);
            startActivity(Intent.createChooser(intent,"Send Email to: "+name));*/

            //Intent intent = new Intent(Intent.ACTION_DIAL);
            //Intent intent = new Intent(Intent.ACTION_CALL);

            /*Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);

            intent.setData(Uri.parse("tel:9988998899"));


            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Please grant permissions to make a call",Toast.LENGTH_LONG).show();
            }else {
                startActivity(intent);
            }*/

            // IMPLICIT INTENT
            // Pass the action created in Manifest File here...
            //Intent intent = new Intent("co.edureka.session3.homeactivity");
            //startActivity(intent);

            // EXPLICIT INTENT
            // No action but source and destination...
            //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            //startActivity(intent);

            //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//            intent.putExtra("keyName",name); // HashMap (Key-Value Pair)
//            intent.putExtra("keyData",data);
//            intent.putExtra("keyAge",30);

//            Bundle bundle = new Bundle();
//            bundle.putString("keyName",name);
//            bundle.putString("keyData",data);
//            bundle.putInt("keyAge",31);
//
//            intent.putExtra("keyBundle",bundle);

           // startActivity(intent);

            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivityForResult(intent,101); // intent and request code(any number of your choice)
        }

    }

    // this is executed when activity started for result shall call the setResult method.
                                                                     // Intent data contains the data passed from HomeActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
            String text = data.getStringExtra("keyData");

            eTxtName.setText(name);
            eTxtData.setText(text);
        }
    }
}
