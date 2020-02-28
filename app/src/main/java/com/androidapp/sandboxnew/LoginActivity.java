package com.androidapp.sandboxnew;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {
    private static final String TAG="LoginActivity";
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameET=findViewById(R.id.usernameET);
        final EditText passwordET=findViewById(R.id.passwordET);
        usernameET.setText("");
        passwordET.setText("");
        Button loginBTN=findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=usernameET.getText().toString();
                password=passwordET.getText().toString();
                if(CheckLoginInfo()){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(LoginActivity.this,"Username or password is incorrect,Try again!" , Toast.LENGTH_LONG).show();
                }

            }
        });
        TextView website=findViewById(R.id.website);
        TextView sign_up=findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/accounts/signup/phone?hl=en") );
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: website");
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com") );
                startActivity(intent);
            }
        });
    }

    private boolean CheckLoginInfo() {
        String u="hesam_srk";
        String v="09011524292";
        return username.toLowerCase().equals(u) && password.toLowerCase().equals(v);
    }
}
