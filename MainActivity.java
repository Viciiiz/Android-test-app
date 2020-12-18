package com.example.firstchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Button buttonSelect, buttonSubmit;
    private EditText name, email, password, rePassword;
    private RadioGroup radioGroup;
    private Spinner spinner;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // everything about the image --> send toast message when clicked
        // initialize
        imageButton = findViewById(R.id.image);
        buttonSelect = findViewById(R.id.pick_image);
        // click listener
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image preview", Toast.LENGTH_SHORT).show();
            }
        });
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Selecting image", Toast.LENGTH_SHORT).show();
            }
        });




        // initialize checkbox, register button and editTexts
        checkBox = findViewById(R.id.checkbox);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.repassword);
        buttonSubmit = findViewById(R.id.register);


        // register if all the fields are completed
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return success if:
                // 1. all the editTexts are filled
                // 2. password and re-password match
                // 3. checkbox is checked
                // 4. password needs to have at least 4 characters
                // else, return error

                // EditTexts
                if(TextUtils.isEmpty(name.getText().toString())){ // A. name
                    Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email.getText().toString())){ // B. email
                    Toast.makeText(MainActivity.this, "Please enter an email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText().toString())){ // C. password
                    Toast.makeText(MainActivity.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(rePassword.getText().toString())){ // D. re-Password
                    Toast.makeText(MainActivity.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                } else if (!password.getText().toString().equals(rePassword.getText().toString())){ // if password and re-password don't match
                    Toast.makeText(MainActivity.this, "Password don't match. Enter again", Toast.LENGTH_SHORT).show();
                } else if (!checkBox.isChecked()){ // if checkbox is not checked
                    Toast.makeText(MainActivity.this, "Please agree with the conditions to continue", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length()<4){ // if password is too short
                    Toast.makeText(MainActivity.this, "Password must contain at least 4 characters.", Toast.LENGTH_SHORT).show();
                } else { //i f everything is ok
                    Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });



        // spinner
        spinner = findViewById(R.id.spinner);
        // arrayList of the elements in spinner
        ArrayList <String> countries = new ArrayList<>();
        countries.add("Germany");
        countries.add("USA");
        countries.add("France");
        countries.add("Other");
        // array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), country + " selected.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}