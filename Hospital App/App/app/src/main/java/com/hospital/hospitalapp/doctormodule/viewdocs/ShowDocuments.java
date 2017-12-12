package com.hospital.hospitalapp.doctormodule.viewdocs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.R;
import com.hospital.hospitalapp.uploadviewdocuments.CustomList;
import com.hospital.hospitalapp.uploadviewdocuments.GetAlImages;
import com.hospital.hospitalapp.uploadviewdocuments.ImageListView;
import com.hospital.hospitalapp.uploadviewdocuments.ViewFullImage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowDocuments extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String patientdocsurl = "http://10.34.31.61/hospital/getPatientDocs.php";
    final ArrayList<String> allItems = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();
    String patient_name;
    ArrayList<ListItem> listData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhow_documents);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ListView listView = (ListView) findViewById(R.id.custom_list);
        imageUrls = getIntent().getStringArrayListExtra("imageUrls");
        patient_name = getIntent().getStringExtra("patient_name");

        listData = getListData();

        listView.setAdapter(new CustomListAdapter(this, listData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
              //  Toast.makeText(ShowDocuments.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });

    }


    private ArrayList<ListItem> getListData() {
        ArrayList<ListItem> listMockData = new ArrayList<ListItem>();
        for (int i = 0; i < imageUrls.size(); i++) {
            ListItem newsData = new ListItem();
            newsData.setUrl(imageUrls.get(i));

            listMockData.add(newsData);
        }
        return listMockData;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

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
