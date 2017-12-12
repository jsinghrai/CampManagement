package com.hospital.hospitalapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hospital.hospitalapp.doctormodule.DoctorDisplayActivity;
import com.hospital.hospitalapp.doctormodule.DoctorListActivity;
import com.hospital.hospitalapp.doctormodule.DoctorSignUp;
import com.hospital.hospitalapp.doctormodule.ItemObject;
import com.hospital.hospitalapp.patientmodule.PatientDisplayActivity;
import com.hospital.hospitalapp.patientmodule.PatientSignUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    EditText et_login_username, et_login_password;
    Button btn_login,btn_doctor_signup,btn_patient_signup;
    TextView tv_reset_pwd;
    ProgressDialog progressDialog;
    String randompassword;
    String HttpUrl = "http://10.34.31.61/hospital/userlogin.php";
    String uid, username, email, phone, assohospital, age, address,id,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login_username = (EditText) findViewById(R.id.et_login_username);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        tv_reset_pwd = (TextView) findViewById(R.id.tv_reset_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_doctor_signup = (Button) findViewById(R.id.btn_doctor_signup);
        btn_patient_signup = (Button) findViewById(R.id.btn_patient_signup);


        tv_reset_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
            }
        });

        try {
            randompassword = SHA1(et_login_password.getText().toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_login_username.getText().toString();
                String password = et_login_password.getText().toString();

                UserLogin(randompassword);


            }
        });

        btn_doctor_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DoctorSignUp.class));
            }
        });

        btn_patient_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PatientSignUp.class));
            }
        });
    }

    // Creating user login function.
    public void UserLogin(final String randompassword) {

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {


//                        try {
//                            JSONArray jsonArray = new JSONArray(ServerResponse);
//
//                            if (jsonArray.length() == 0) {
//                                Toast.makeText(LoginActivity.this, "Username and password doesn't match", Toast.LENGTH_LONG).show();
//                                Log.d("tag", "jsonArray--" + jsonArray.length());
//                            } else {
//                                Toast.makeText(LoginActivity.this, "Yes", Toast.LENGTH_LONG).show();
//                                Log.d("tag", "jsonArrayexists--" + jsonArray.length());
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    try {
//                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                        uid = jsonObject.getString("uid");
//                                        Log.d("tag", "uid--" + uid);
//                                        if (uid.equalsIgnoreCase("doctor")) {
//                                            id = jsonObject.getString("id");
//                                            username = jsonObject.getString("username");
//                                            email = jsonObject.getString("email");
//                                            phone = jsonObject.getString("phone");
//                                            assohospital = jsonObject.getString("assohospital");
//                                            password = jsonObject.getString("password");
//                                            Log.d("tag", "doctor--" + username + email + phone + assohospital + "\n" + password + "\n" + LoginActivity.this.randompassword);
//                                            Intent doctormain = new Intent(getApplicationContext(), DoctorDisplayActivity.class);
//                                            doctormain.putExtra("id", id);
//                                            doctormain.putExtra("username", username);
//                                            doctormain.putExtra("email", email);
//                                            doctormain.putExtra("phone", phone);
//                                            startActivity(doctormain);
//
//                                        } else if (uid.equalsIgnoreCase("patient")) {
//                                            id = jsonObject.getString("id");
//                                            username = jsonObject.getString("username");
//                                            email = jsonObject.getString("email");
//                                            phone = jsonObject.getString("phone");
//                                            age = jsonObject.getString("age");
//                                            address = jsonObject.getString("address");
//                                            password = jsonObject.getString("password");
//                                            Log.d("tag", "patient--" + username + email + phone + age + address + "\n" + password + "\n" + LoginActivity.this.randompassword);
//
//                                            Intent patientdashboard = new Intent(LoginActivity.this, PatientDisplayActivity.class);
//                                            patientdashboard.putExtra("id", id);
//                                            patientdashboard.putExtra("username", username);
//                                            patientdashboard.putExtra("email", email);
//                                            patientdashboard.putExtra("phone", phone);
//                                            patientdashboard.putExtra("age", age);
//                                            patientdashboard.putExtra("address", address);
//
//                                            startActivity(patientdashboard);
//
//                                        }
//
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },


                      //  if (ServerResponse != null) {

                            // If response matched then show the toast.
                        //    Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                            try {

                                JSONArray jsonArray = new JSONArray(ServerResponse);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    try {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        uid = jsonObject.getString("uid");
                                        Log.d("tag", "uid--" + uid);
                                        if (uid.equalsIgnoreCase("doctor")) {
                                            id = jsonObject.getString("id");
                                            username = jsonObject.getString("username");
                                            email = jsonObject.getString("email");
                                            phone = jsonObject.getString("phone");
                                            assohospital = jsonObject.getString("assohospital");
                                            password = jsonObject.getString("password");
                                            Log.d("tag", "doctor--" + username + email + phone + assohospital +"\n"+password+"\n"+randompassword);
                                            Intent doctormain = new Intent(getApplicationContext(), DoctorDisplayActivity.class);
                                            doctormain.putExtra("id",id);
                                            doctormain.putExtra("username", username);
                                            doctormain.putExtra("email", email);
                                            doctormain.putExtra("phone", phone);
                                            startActivity(doctormain);

                                        } else if (uid.equalsIgnoreCase("patient")) {
                                            id = jsonObject.getString("id");
                                            username = jsonObject.getString("username");
                                            email = jsonObject.getString("email");
                                            phone = jsonObject.getString("phone");
                                            age = jsonObject.getString("age");
                                            address = jsonObject.getString("address");
                                            password = jsonObject.getString("password");
                                            Log.d("tag", "patient--" + username + email + phone + age + address +"\n"+password+"\n"+randompassword);

                                            Intent patientdashboard = new Intent(LoginActivity.this, PatientDisplayActivity.class);
                                            patientdashboard.putExtra("id",id);
                                            patientdashboard.putExtra("username", username);
                                            patientdashboard.putExtra("email", email);
                                            patientdashboard.putExtra("phone", phone);
                                            patientdashboard.putExtra("age", age);
                                            patientdashboard.putExtra("address", address);

                                            startActivity(patientdashboard);

                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                //   progressDialog.hide();
                            }

//
//                        } else {
//
//                            // Showing Echo Response Message Coming From Server.
//                           // Toast.makeText(LoginActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
//
//                            Toast.makeText(LoginActivity.this, "Username and password doesn't match", Toast.LENGTH_LONG).show();
//
//                        }


//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }


                    }
                },


                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.

                        // Showing error message if something goes wrong.
                        Toast.makeText(LoginActivity.this, "Retry", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("username", et_login_username.getText().toString());
                params.put("password", randompassword);

                return params;
            }

        };
        requestQueue.add(stringRequest);

    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
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
