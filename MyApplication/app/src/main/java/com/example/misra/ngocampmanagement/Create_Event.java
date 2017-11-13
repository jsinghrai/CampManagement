package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_Event extends AppCompatActivity {
    Button BtnCreateEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);
        BtnCreateEvent = (Button)findViewById(R.id.btn_create_event1);

        BtnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Create_Event.this, Doctors_Main_Page.class);
                startActivity(i);
            }
        });
    }
}
