package com.example.misra.ngocampmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cancel_Event extends AppCompatActivity {
    Button BtnCancelEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel__event);
        BtnCancelEvent = (Button)findViewById(R.id.btn_cancel_event1);

        BtnCancelEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cancel_Event.this, Doctors_Main_Page.class);
                startActivity(i);
            }
        });
    }
}
