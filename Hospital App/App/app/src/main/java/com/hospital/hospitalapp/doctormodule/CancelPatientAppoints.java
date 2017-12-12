package com.hospital.hospitalapp.doctormodule;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.R;
import com.hospital.hospitalapp.doctormodule.viewdocs.ShowDocuments;
import com.hospital.hospitalapp.uploadviewdocuments.ImageListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CancelPatientAppoints extends AppCompatActivity {
    ListView userList;
    UserCustomAdapter userAdapter;
    ArrayList<User> userArray = new ArrayList<User>();
    ArrayList<String> patientnamesArray = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();
    final ArrayList<String> allItems = new ArrayList<>();
    String clickdate;
    String checkdates_url = "http://10.34.31.61/hospital/appointmentcancel.php";
    String patientdocsurl = "http://10.34.31.61/hospital/getPatientDocs.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_patient_appoints);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        patientnamesArray = getIntent().getStringArrayListExtra("patient_namearray");
        clickdate = getIntent().getStringExtra("clickeddate");
        Log.d("tag","patient_namearray--"+patientnamesArray.toString() +"\n" +clickdate);


        for (int i=0; i<patientnamesArray.size(); i++){
            userArray.add(new User(patientnamesArray.get(i), "Spain", "Spain"));
        }


        userAdapter = new UserCustomAdapter(CancelPatientAppoints.this, R.layout.cancel_appointment_row,
                userArray);
        userList = (ListView) findViewById(R.id.listView);
        userList.setItemsCanFocus(false);
        userList.setAdapter(userAdapter);


        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {
                Log.i("List View Clicked", "**********");
                Toast.makeText(CancelPatientAppoints.this,
                        "List View Clicked:" + position, Toast.LENGTH_LONG)
                        .show();
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    class UserCustomAdapter extends ArrayAdapter<User> {
        Context context;
        int layoutResourceId;
        ArrayList<User> data = new ArrayList<User>();

        public UserCustomAdapter(Context context, int layoutResourceId,
                                 ArrayList<User> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = convertView;
            UserHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new UserHolder();
                holder.textName = (TextView) row.findViewById(R.id.textView1);
                holder.textAddress = (TextView) row.findViewById(R.id.textView2);
                holder.textLocation = (TextView) row.findViewById(R.id.textView3);
                holder.btnEdit = (Button) row.findViewById(R.id.button1);
                holder.btnDelete = (Button) row.findViewById(R.id.button2);
                row.setTag(holder);
            } else {
                holder = (UserHolder) row.getTag();
            }
            User user = data.get(position);
            holder.textName.setText(user.getName());
            holder.textAddress.setText(user.getAddress());
            holder.textLocation.setText(user.getLocation());
            holder.btnEdit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.i("Docs Button Clicked", "**********");
                    Toast.makeText(context, "Loading documents",
                            Toast.LENGTH_LONG).show();


                    imageUrls = getAllItemList(patientnamesArray.get(position));


                    final ProgressDialog progressDialog = new ProgressDialog(CancelPatientAppoints.this);
                    progressDialog.setMessage("Loading...");



                    Handler h = new Handler(){
                        @Override
                        public void handleMessage(Message msg) {

                            Intent docs = new Intent(CancelPatientAppoints.this, ShowDocuments.class);
                             docs.putStringArrayListExtra("imageUrls",imageUrls);
                            docs.putExtra("patient_name",patientnamesArray.get(position));
                            Log.d("tag","listdataimagesssintent--"+imageUrls.toString());
                            startActivity(docs);
                        }
                    };

                    h.sendEmptyMessageDelayed(0, 3000);


                }
            });
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.i("Cancel Button Clicked", "**********"+position);
                  //  Toast.makeText(context, "Cancel button Clicked",Toast.LENGTH_LONG).show();
                    Log.d("tag","patient_date--"+clickdate+"\n"+ patientnamesArray.get(position));
                    RequestQueue requestQueue = Volley.newRequestQueue(CancelPatientAppoints.this);
                    final ProgressDialog progressDialog = new ProgressDialog(CancelPatientAppoints.this);
                    progressDialog.setMessage("Registering...");
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, checkdates_url,

                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(CancelPatientAppoints.this,"Cancelled",Toast.LENGTH_SHORT).show();
                                    Log.d("tag","Response--"+response);

                                }
                            },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {
                        @Override

                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();

                            params.put("patient_name", patientnamesArray.get(position));
                            params.put("date", clickdate);
                            params.put("status", "cancel");

                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            });
            return row;
        }

         class UserHolder {
            TextView textName;
            TextView textAddress;
            TextView textLocation;
            Button btnEdit;
            Button btnDelete;
        }
    }
    public ArrayList<String> getAllItemList(final String s) {
        imageUrls.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, patientdocsurl,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("tag","docc--"+response);

                        try {

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    allItems.add(jsonObject.getString("image"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //   progressDialog.hide();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("patient_name",s);
                return params;
            }
        };
        requestQueue.add(stringRequest);

        return allItems;
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

