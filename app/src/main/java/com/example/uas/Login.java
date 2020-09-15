package com.example.uas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;



public class Login extends AppCompatActivity {
    EditText edtUser;
    EditText edtPass;
    Button btnCancel;
    Button btnLogin;
    String username = "17164018";
    String pass = "imam1995";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtUser.getText();
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtPass.getText();
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODOAuto-generated method stub
                edtUser.setText("");
                edtPass.setText("");
            }
        });

        btnLogin = (Button) findViewById(R.id.btnLogin);
        final Intent pindah = new Intent(Login.this,MainActivity.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODOAuto-generated method stub
                if (edtUser.getText().toString().equals(username) && edtPass.getText().toString().equals(pass)){
                    startActivity(pindah);
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity inAndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}