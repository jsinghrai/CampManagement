package com.hospital.hospitalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ForgotPassword extends AppCompatActivity {

    EditText et_forgot_email,et_forgot_password;
    Button btn_submit;
    public static int NO_OPTIONS=0;
    String newpassword,email,SHApassword;
    private String SHAHash;
    String resetpasswordlink = "http://10.34.31.61/hospital/resetpassword.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_forgot_email = (EditText) findViewById(R.id.et_forgot_email);
        et_forgot_password = (EditText) findViewById(R.id.et_forgot_password);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = et_forgot_email.getText().toString();

                newpassword = et_forgot_password.getText().toString();
                SHApassword = computeSHAHash(newpassword);

                RequestQueue requestQueue = Volley.newRequestQueue(ForgotPassword.this);

                final ProgressDialog progressDialog = new ProgressDialog(ForgotPassword.this);
                progressDialog.setMessage("Registering...");
                StringRequest stringRequest = new StringRequest(Request.Method.POST, resetpasswordlink,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {

                                    JSONArray jsonArray = new JSONArray(response);
                                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                                    Log.d("tag","resetresponse" +jsonObject + "\n" +response);
//                                    Intent gotologin = new Intent(ForgotPassword.this, GoogleFbActivity.class);
//                                    //   gotologin.putStringArrayListExtra("key", listItems);
//                                    startActivity(gotologin);
                                    progressDialog.hide();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    progressDialog.hide();
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

                        params.put("email", email);
                        params.put("SHApassword", SHApassword);
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
            }

            });
        }
    public String computeSHAHash(String newpassword)
    {
        MessageDigest mdSha1 = null;
        try
        {
            mdSha1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e1) {
            Log.e("myapp", "Error initializing SHA1 message digest");
        }
        try {
            mdSha1.update(newpassword.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] data = mdSha1.digest();
        try {
            SHAHash=convertToHex(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("tag","shapwd"+SHAHash);
        return SHAHash;

        //result.setText("SHA-1 hash generated is: " + " " + SHAHash);
    }

    private static String convertToHex(byte[] data) throws java.io.IOException
    {

        StringBuffer sb = new StringBuffer();
        String hex=null;

        hex= Base64.encodeToString(data, 0, data.length, NO_OPTIONS);

        sb.append(hex);

        return sb.toString();
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
