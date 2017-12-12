package com.hospital.hospitalapp.patientmodule;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hospital.hospitalapp.LoginActivity;
import com.hospital.hospitalapp.R;
import com.hospital.hospitalapp.doctormodule.DoctorListActivity;
import com.hospital.hospitalapp.patientmodule.statuslist.PatientAppointmentStatus;
import com.hospital.hospitalapp.uploadviewdocuments.UploadActivity;

public class PatientDisplayActivity extends AppCompatActivity {

    Button btn_cancel_event,btn_view_appointments,btn_view_documents,btn_logout,btn_status;
    String patient_name, patient_email,patient_phone,patient_age,patient_adress, doctor_name, doctor_email,
            patient_id;
    TextView tv_pname,pid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_display);



        patient_name = getIntent().getStringExtra("username");
        patient_email = getIntent().getStringExtra("email");
        patient_phone = getIntent().getStringExtra("phone");
        patient_age = getIntent().getStringExtra("age");
        patient_adress = getIntent().getStringExtra("address");
        patient_id = getIntent().getStringExtra("id");

//        doctor_name = getIntent().getStringExtra("doctor_name");
//        doctor_email = getIntent().getStringExtra("doctor_email");

        Log.d("tag", "datacalendar--" + patient_name +patient_email +patient_phone +patient_age +patient_adress);



        btn_cancel_event = (Button) findViewById(R.id.btn_cancel_event);
        btn_view_appointments = (Button) findViewById(R.id.btn_view_appointments);
        btn_view_documents = (Button) findViewById(R.id.btn_view_documents);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_status = (Button) findViewById(R.id.btn_status);

        tv_pname = (TextView) findViewById(R.id.tv_pname);
        pid = (TextView) findViewById(R.id.tv_pid);

        tv_pname.setText(patient_name);
        pid.setText(patient_id);

        btn_cancel_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(getApplicationContext(), DoctorCalendarActivtiy.class));
                Intent patient = new Intent(PatientDisplayActivity.this, DoctorListActivity.class);
                patient.putExtra("doctor_name", doctor_name);
                patient.putExtra("doctor_email", doctor_email);

                startActivity(patient);
            }
        });

        btn_view_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patient = new Intent(PatientDisplayActivity.this, DoctorListActivity.class);

                patient.putExtra("username", patient_name);
                patient.putExtra("email", patient_email);
                patient.putExtra("phone", patient_phone);
                patient.putExtra("age", patient_age);
                patient.putExtra("address", patient_adress);

                startActivity(patient);

            }
        });

        btn_view_documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent doc_upload = new Intent(PatientDisplayActivity.this, UploadActivity.class);

                doc_upload.putExtra("username", patient_name);
                doc_upload.putExtra("email", patient_email);
                doc_upload.putExtra("phone", patient_phone);
                startActivity(doc_upload);
            }
        });



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        // Clear the User session data
        // and redirect user to LoginActivity

            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PatientDisplayActivity.this, "Loading",
                        Toast.LENGTH_LONG).show();

                Handler h = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {

                        Intent status = new Intent(PatientDisplayActivity.this, PatientAppointmentStatus.class);
                        status.putExtra("username", patient_name);
                        startActivity(status);
                    }
                };

                h.sendEmptyMessageDelayed(0, 3000);


            }
        });

    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();

    }
}
