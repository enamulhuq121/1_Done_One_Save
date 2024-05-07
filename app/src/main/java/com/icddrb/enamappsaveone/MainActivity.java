package com.icddrb.enamappsaveone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText participantNameEdit;
    private Button addParticipantBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        participantNameEdit = findViewById(R.id.idParticipantName);
        addParticipantBtn = findViewById(R.id.idBtnParticipantDetails);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String participantName = participantNameEdit.getText().toString();


                // validating if the text fields are empty or not.
                if (participantName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewParticipant(participantName);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Participant has been added.", Toast.LENGTH_SHORT).show();
                participantNameEdit.setText("");

            }
        });
    }
}
