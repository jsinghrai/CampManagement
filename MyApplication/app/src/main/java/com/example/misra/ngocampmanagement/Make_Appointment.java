package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Make_Appointment extends AppCompatActivity {
    Button BtnMakeAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__appointment);
        BtnMakeAppointment=(Button)findViewById(R.id.btn_make_appointment1);

        BtnMakeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Make_Appointment.this, Patients_Main_Page.class);
                startActivity(i);
            }
        });
    }
}
