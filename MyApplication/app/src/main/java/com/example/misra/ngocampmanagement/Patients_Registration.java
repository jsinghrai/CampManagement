package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Patients_Registration extends AppCompatActivity {
    Button btnPatientRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients__registration);
        btnPatientRegistration=(Button)findViewById(R.id.btn_patientsregistration);
        btnPatientRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patients_Registration.this, Patients_Main_Page.class);
                startActivity(i);
            }
        });
    }
}
