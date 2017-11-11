package co.edureka.session3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    // References to the Views. by default : they are null
    EditText eTxtName;
    EditText eTxtData;
    Button btnSubmit;

    void initViews() {
        eTxtName = (EditText) findViewById(R.id.editTextName);
        eTxtData = (EditText) findViewById(R.id.editTextData);

        btnSubmit = (Button) findViewById(R.id.button);
        btnSubmit.setOnClickListener(this);

        // Extract data from intent
        //Intent rcv = getIntent(); // Capture Intent passed by the activity which started HomeActivity
//        String name = rcv.getStringExtra("keyName");
//        String data = rcv.getStringExtra("keyData");
//        int age = rcv.getIntExtra("keyAge",0);


        /*Bundle rcvBun = rcv.getBundleExtra("keyBundle");

        String name = rcvBun.getString("keyName");
        String data = rcvBun.getString("keyData");
        int age = rcvBun.getInt("keyAge",0);

        eTxtName.setText(name);
        eTxtData.setText(data+" - "+age);*/

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {

            // Capture the data here
            String name = eTxtName.getText().toString();
            String data = eTxtData.getText().toString();

            Intent intent = new Intent(); // dummy. not carrying any action. only to hold the data.
            intent.putExtra("keyName",name);
            intent.putExtra("keyData",data);

            setResult(201,intent); // send back resultcode and intent with data to the callee activity

            finish(); // Destroy the activity. equivalent pressing the back key
        }
    }
}