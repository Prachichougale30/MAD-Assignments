package com.example.inputcontrollers;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput;
    private CheckBox agreeCheck;
    private RadioGroup radioGroup;
    private RadioButton selectedGender;

    // Spinner variables
    private String selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML with Java
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        agreeCheck = findViewById(R.id.agreeCheck);
        radioGroup = findViewById(R.id.radioGroup);
        Button submitBtn = findViewById(R.id.submitBtn);

        // Spinner
        Spinner countrySpinner = findViewById(R.id.countrySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.countries,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCountry = "";
            }
        });

        // Button Click
        submitBtn.setOnClickListener(v -> {

            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            // Get selected gender
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                selectedGender = findViewById(selectedId);
            }

            String gender = (selectedGender != null) ? selectedGender.getText().toString() : "Not selected";

            // Checkbox
            if (!agreeCheck.isChecked()) {
                Toast.makeText(MainActivity.this, "Please agree to terms", Toast.LENGTH_SHORT).show();
                return;
            }

            // Show result
            Toast.makeText(MainActivity.this,
                    "Name: " + name +
                            "\nEmail: " + email +
                            "\nPassword: " + password +
                            "\nGender: " + gender +
                            "\nCountry: " + selectedCountry,
                    Toast.LENGTH_LONG).show();
        });
    }
}
