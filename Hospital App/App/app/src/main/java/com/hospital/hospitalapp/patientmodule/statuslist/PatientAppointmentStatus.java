package com.hospital.hospitalapp.patientmodule.statuslist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.LoginActivity;
import com.hospital.hospitalapp.R;
import com.hospital.hospitalapp.doctormodule.DoctorDisplayActivity;
import com.hospital.hospitalapp.patientmodule.PatientDisplayActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientAppointmentStatus extends AppCompatActivity {


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    String patient_name,doctor_name,date,status;
    String statusUrl = "http://10.34.31.61/hospital/getAppointmentStatus.php";
    public static class MyData {
        static ArrayList<String> nameArray = new ArrayList<>();
      static ArrayList<String> versionArray = new ArrayList<>();
        static ArrayList<String> dateArray = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_appointment_status);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        patient_name = getIntent().getStringExtra("username");

        MyData.nameArray.clear();
      //  myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        RequestQueue requestQueue = Volley.newRequestQueue(PatientAppointmentStatus.this);
        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, statusUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        if (ServerResponse != null) {

                            try {

                                JSONArray jsonArray = new JSONArray(ServerResponse);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    try {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                                        doctor_name = jsonObject.getString("doctor_name");
                                        date = jsonObject.getString("date");
                                        status = jsonObject.getString("status");

                                        MyData.nameArray.add(doctor_name);
                                        MyData.versionArray.add(status);
                                        MyData.dateArray.add(date);

                                        data = new ArrayList<DataModel>();
                                        for (int j = 0; j < MyData.nameArray.size() ; j++) {
                                            data.add(new DataModel(
                                                    MyData.nameArray.get(j),
                                                    MyData.versionArray.get(j),
                                                    MyData.dateArray.get(j)

                                            ));
                                        }
                                        adapter = new CustomAdapter(data);
                                        recyclerView.setAdapter(adapter);


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                //   progressDialog.hide();
                            }

                        } else {

                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(PatientAppointmentStatus.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Showing error message if something goes wrong.
                        Toast.makeText(PatientAppointmentStatus.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same sa your MySQL database table columns.
                params.put("patient_name", patient_name);
                //params.put("doctor_name", doctor_name);
                return params;
            }

        };
        requestQueue.add(stringRequest);

        removedItems = new ArrayList<Integer>();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home :
            finish();

        }
        return true;
    }
}
