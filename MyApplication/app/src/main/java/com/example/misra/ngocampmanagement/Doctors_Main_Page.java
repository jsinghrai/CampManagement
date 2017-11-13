package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctors_Main_Page extends AppCompatActivity {
    Button BtnCreateEvent, BtnCancelEvent, BtnViewDocuments, BtnViewAppointments, BtnLogout, BtnResetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors__main__page);
        BtnCreateEvent = (Button)findViewById(R.id.btn_create_event);
        BtnCancelEvent = (Button)findViewById(R.id.btn_cancel_event);
        BtnViewAppointments = (Button)findViewById(R.id.btn_view_appointments);
        BtnViewDocuments = (Button)findViewById(R.id.btn_view_documents);
        BtnLogout = (Button)findViewById(R.id.btn_logout_doctors);
        BtnResetPassword = (Button)findViewById(R.id.btn_reset_password_doctors);

        BtnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, Create_Event.class);
                startActivity(i);
            }
        });

        BtnCancelEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, Cancel_Event.class);
                startActivity(i);
            }
        });

        BtnViewAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, Appointment_List.class);
                startActivity(i);
            }
        });

        BtnViewDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, Documents_List.class);
                startActivity(i);
            }
        });

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, MainActivity.class);
                startActivity(i);
            }
        });

        BtnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctors_Main_Page.this, Reset_Password.class);
                i.putExtra("value","Doctors");
                startActivity(i);
            }
        });
    }
}
