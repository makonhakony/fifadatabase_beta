package com.example.hakony.fifadatabase;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {
    /*private static final int REQUEST_READ_CONTACTS = 0;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText mUserName = (EditText) findViewById(R.id.etUsername);
        final EditText mPassword = (EditText) findViewById(R.id.etPassword);
        final CardView btnLogin = (CardView) findViewById(R.id.loginbutton);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final ImageView logo= (ImageView) findViewById(R.id.logo);

        //--------------------------------------------------------------
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        //------------------------animation---------------------------------
        final Animation FadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        final Animation FadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        //-------------------------------------------------------------

        logo.startAnimation(FadeIn);
        mUserName.startAnimation(FadeIn);
        mPassword.startAnimation(FadeIn);
        btnLogin.startAnimation(FadeIn);
        tvRegisterLink.startAnimation(FadeIn);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mUserName.getText().toString();
                final String password = mPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String name = jsonResponse.getString("name");
                                Intent intent = new Intent(LoginActivity.this, MainContent.class);
                                intent.putExtra("name", name);
                                Toast.makeText(LoginActivity.this,"You are Sign in Successfuly.", Toast.LENGTH_LONG).show();
                                logo.startAnimation(FadeOut);
                                mUserName.startAnimation(FadeOut);
                                mPassword.startAnimation(FadeOut);
                                btnLogin.startAnimation(FadeOut);
                                tvRegisterLink.startAnimation(FadeOut);

                                LoginActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = mUserName.getText().toString();
                String Pwd = mPassword.getText().toString();
                if(UserName.equalsIgnoreCase("An") && Pwd.equals("123")){
                    Intent MainIntent = new Intent(LoginActivity.this, MainContent.class);
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this,"You are Sign in Successfuly.", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(LoginActivity.this,"Sorry,User Name or Password is incorrect.", Toast.LENGTH_LONG).show();
                }
            }
        });*/
        }


}
