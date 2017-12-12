package com.hospital.hospitalapp.doctormodule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.patientmodule.MyCalendarActivity;
import com.hospital.hospitalapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorListActivity extends AppCompatActivity {
    private LinearLayoutManager lLayout;
    String doctorListUrl = "http://10.34.31.61/hospital/doctorlist.php";
    final List<ItemObject> allItems = new ArrayList<ItemObject>();
    RecyclerViewAdapterr rcAdapter;
    // String patient_name, patient_email, doctor_name, doctor_email;
    ArrayList<String> doctorNameArray = new ArrayList<>();
    ArrayList<String> doctorEmailArray = new ArrayList<>();


    String patient_name, patient_email, patient_phone, patient_age, patient_adress, doctor_name, doctor_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        patient_name = getIntent().getStringExtra("username");
        patient_email = getIntent().getStringExtra("email");
        patient_phone = getIntent().getStringExtra("phone");
        patient_age = getIntent().getStringExtra("age");
        patient_adress = getIntent().getStringExtra("address");
        Log.d("tag", "datacalendardoctor--" + patient_name + patient_email);

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(DoctorListActivity.this);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        rcAdapter = new RecyclerViewAdapterr(DoctorListActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);


    }

    public List<ItemObject> getAllItemList() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, doctorListUrl,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    allItems.add(new ItemObject(jsonObject.getString("username"), R.drawable.d1));
                                    doctorNameArray.add(jsonObject.getString("username"));
                                    doctorEmailArray.add(jsonObject.getString("email"));
                                    Log.d("tag", "listdata--" + doctorNameArray.toString() + "\n" + doctorEmailArray.toString());

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //   progressDialog.hide();
                        }
                        rcAdapter.notifyDataSetChanged();


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
                return params;
            }
        };
        requestQueue.add(stringRequest);

        return allItems;
    }

    public class RecyclerViewAdapterr extends RecyclerView.Adapter<RecyclerViewHolders> {

        private List<ItemObject> itemList;
        private Context context;

        public RecyclerViewAdapterr(Context context, List<ItemObject> itemList) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
            RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolders holder, int position) {
            holder.doctorName.setText(itemList.get(position).getName());
            holder.doctorPhoto.setImageResource(itemList.get(position).getPhoto());


        }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView doctorName;
        public ImageView doctorPhoto;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            doctorName = (TextView) itemView.findViewById(R.id.country_name);
            doctorPhoto = (ImageView) itemView.findViewById(R.id.country_photo);

        }

        @Override
        public void onClick(View view) {
          //  Toast.makeText(view.getContext(), "Clicked  Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            Log.d("tag", "listdataview--" + doctorNameArray.toString() + "\n" + doctorEmailArray.toString());
            Intent intent1 = new Intent(DoctorListActivity.this, MyCalendarActivity.class);
            intent1.putExtra("patient_name", patient_name);
            intent1.putExtra("patient_email", patient_email);
            intent1.putExtra("doctor_name", doctorNameArray.get(getPosition()));
            intent1.putExtra("doctor_email", doctorEmailArray.get(getPosition()));

            startActivity(intent1);

        }


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
