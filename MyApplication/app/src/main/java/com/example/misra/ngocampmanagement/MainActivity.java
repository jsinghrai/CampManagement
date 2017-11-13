package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDoctors, btnPatients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDoctors=(Button)findViewById(R.id.btn_Doctors);
        btnPatients=(Button)findViewById(R.id.btn_patients);

        btnDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                i.putExtra("value","Doctors");
                startActivity(i);
            }
        });

        btnPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                i.putExtra("value","Patients");
                startActivity(i);
            }
        });


    }
}
