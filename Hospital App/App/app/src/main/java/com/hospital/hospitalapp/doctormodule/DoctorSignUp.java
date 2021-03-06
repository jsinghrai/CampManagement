package com.hospital.hospitalapp.doctormodule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.LoginActivity;
import com.hospital.hospitalapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class DoctorSignUp extends AppCompatActivity {

    private EditText et_doctor_username, et_doctor_email, et_doctor_phone, et_doctor_password, et_associatedhospital;
    Button btn_doctor_signup,btn_Cancel;
    String randompassword;
    String reg_url="http://10.34.31.61/hospital/doctor_signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);

        et_doctor_username = (EditText) findViewById(R.id.et_doctor_username);
        et_doctor_email = (EditText) findViewById(R.id.et_doctor_email);
        et_doctor_phone = (EditText) findViewById(R.id.et_doctor_phone);
        et_doctor_password = (EditText) findViewById(R.id.et_doctor_password);
        et_associatedhospital = (EditText) findViewById(R.id.et_associatedhospital);
        btn_doctor_signup = (Button) findViewById(R.id.btn_doctor_signup);
        btn_Cancel = (Button) findViewById(R.id.btn_Cancel);

        try {
             randompassword = SHA1(et_doctor_password.getText().toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        btn_doctor_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = et_doctor_username.getText().toString().trim();
                final String email = et_doctor_email.getText().toString().trim();
                final String password = et_doctor_password.getText().toString().trim();
                final String phonenumber = et_doctor_phone.getText().toString().trim();
                final String associatedhospital = et_associatedhospital.getText().toString().trim();

                Log.d("tag","randompassword--"+randompassword);
                //checking if email and passwords are empty
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(DoctorSignUp.this, "Please enter name", Toast.LENGTH_LONG).show();
                    return;

                }
               else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(DoctorSignUp.this, "Please enter email", Toast.LENGTH_LONG).show();
                    return;
                }
              else  if (TextUtils.isEmpty(password)) {
                    Toast.makeText(DoctorSignUp.this, "Please enter password", Toast.LENGTH_LONG).show();
                    return;
                }
             else    if (TextUtils.isEmpty(phonenumber)) {
                    Toast.makeText(DoctorSignUp.this, "Please enter phonenumber", Toast.LENGTH_LONG).show();
                    return;
                }
             else    if (TextUtils.isEmpty(associatedhospital)) {
                    Toast.makeText(DoctorSignUp.this, "Please enter hospital name", Toast.LENGTH_LONG).show();
                    return;
                }
//else {
                    RequestQueue requestQueue = Volley.newRequestQueue(DoctorSignUp.this);
                    final ProgressDialog progressDialog = new ProgressDialog(DoctorSignUp.this);
                    progressDialog.setMessage("Registering...");
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url,

                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    if (response != null) {
                                        Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_LONG).show();
                                    }

//                                    try {
//
//                                        Log.d("tag","response--"+response);
//                                        JSONArray jsonArray = new JSONArray(response);
//                                        JSONObject jsonObject = jsonArray.getJSONObject(0);
//                                        String status = jsonObject.getString("status");
//                                        String msg = jsonObject.getString("msg");
//                                        Log.d("tag","respo--"+msg +status);
//                                        Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_LONG).show();
//                                        if (status.equals("success")){
//                                            Intent gotologin = new Intent(DoctorSignUp.this, DoctorListActivity.class);
//
//                                            startActivity(gotologin);
//                                        }
//                                        progressDialog.hide();
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                        progressDialog.hide();
//                                    }

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
                            params.put("uid","doctor");
                            params.put("username", name);
                            params.put("email", email);
                            params.put("phone", phonenumber);
                            params.put("password", randompassword);
                            params.put("assohospital",associatedhospital);
                            return params;
                        }
                    };

                    requestQueue.add(stringRequest);
             //   }


            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                }
                else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        }
        return buf.toString();
    }


    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
}
