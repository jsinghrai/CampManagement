package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cancel_Appointment extends AppCompatActivity {
    Button BtnCancelAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel__appointment);
        BtnCancelAppointment = (Button)findViewById(R.id.btn_cancel_appointment1);

        BtnCancelAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cancel_Appointment.this, Patients_Main_Page.class);
                startActivity(i);
            }
        });
    }
}
