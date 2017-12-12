package com.hospital.hospitalapp.doctormodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hospital.hospitalapp.LoginActivity;
import com.hospital.hospitalapp.R;

import java.util.HashMap;

public class DoctorDisplayActivity extends AppCompatActivity {

Button btn_cancel_event,btn_view_appointments,btn_view_documents,btn_logout;
    TextView tv_dname,tv_uid;
    String doctor_id, patient_email, doctor_name, doctor_email,doctor_phone;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_display);


        tv_dname = (TextView) findViewById(R.id.tv_dname);
        tv_uid = (TextView) findViewById(R.id.tv_uid);

        btn_cancel_event = (Button) findViewById(R.id.btn_cancel_event);
        btn_view_appointments = (Button) findViewById(R.id.btn_view_appointments);
        btn_view_documents = (Button) findViewById(R.id.btn_view_documents);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        doctor_name = getIntent().getStringExtra("username");
        doctor_email = getIntent().getStringExtra("email");
        doctor_phone = getIntent().getStringExtra("phone");
        doctor_id = getIntent().getStringExtra("id");
        Log.d("tag", "datacalendardoctor--" + doctor_name + doctor_email +doctor_phone );

        tv_dname.setText(doctor_name);
        tv_uid.setText(doctor_id);


        btn_cancel_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(getApplicationContext(), DoctorCalendarActivtiy.class));
                Intent doctormain = new Intent(DoctorDisplayActivity.this, DoctorCalendarActivtiy.class);
                doctormain.putExtra("doctor_name", doctor_name);
                doctormain.putExtra("doctor_email", doctor_email);
                doctormain.putExtra("phone", doctor_phone);
                startActivity(doctormain);
            }
        });

        btn_view_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doctormain = new Intent(DoctorDisplayActivity.this, DoctorCalendarActivtiy.class);
                doctormain.putExtra("doctor_name", doctor_name);
                doctormain.putExtra("doctor_email", doctor_email);
                doctormain.putExtra("phone", doctor_phone);
                startActivity(doctormain);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));


            }
        });
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();

    }
}
