package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reset_Password extends AppCompatActivity {
    Button BtnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset__password);
        BtnResetPassword = (Button)findViewById(R.id.btn_reset_password);
        Intent i = getIntent();
        final String value = i.getStringExtra("value");

        BtnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == "Patients")
                {
                    Intent i = new Intent(Reset_Password.this, Patients_Main_Page.class);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(Reset_Password.this, Doctors_Main_Page.class);
                    startActivity(i);
                }

            }
        });
    }
}
