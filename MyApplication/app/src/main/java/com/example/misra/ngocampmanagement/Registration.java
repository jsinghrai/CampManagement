package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {
    Button btnNewRegistration, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent i = getIntent();
        final String value = i.getStringExtra("value");
        btnNewRegistration=(Button)findViewById(R.id.btn_new_registration);
        btnSubmit=(Button)findViewById(R.id.btn_submit);

        btnNewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == "Doctors")
                {
                    Intent i = new Intent(Registration.this, Doctors_Registration.class);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(Registration.this, Patients_Registration.class);
                    startActivity(i);
                }

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == "Doctors")
                {
                    Intent i = new Intent(Registration.this, Doctors_Main_Page.class);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(Registration.this, Patients_Main_Page.class);
                    startActivity(i);
                }
            }
        });

    }

}
