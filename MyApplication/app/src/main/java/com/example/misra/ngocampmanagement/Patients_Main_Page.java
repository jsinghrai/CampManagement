package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Patients_Main_Page extends AppCompatActivity {
    Button BtnMakeAppointment,BtnCancelAppointment,BtnUploadDocuments,BtnResetPassword,BtnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients__main__page);
        BtnMakeAppointment=(Button)findViewById(R.id.btn_make_appointment);
        BtnCancelAppointment=(Button)findViewById(R.id.btn_cancel_appointment);
        BtnUploadDocuments=(Button)findViewById(R.id.btn_upload_documents);
        BtnResetPassword=(Button)findViewById(R.id.btn_reset_password_patients);
        BtnLogout=(Button)findViewById(R.id.btn_logout_patients);

        BtnMakeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patients_Main_Page.this, Make_Appointment.class);
                startActivity(i);
            }
        });

        BtnCancelAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patients_Main_Page.this, Cancel_Appointment.class);
                startActivity(i);
            }
        });

        BtnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patients_Main_Page.this, Reset_Password.class);
                i.putExtra("value","Patients");
                startActivity(i);
            }
        });

        BtnUploadDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patients_Main_Page.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
