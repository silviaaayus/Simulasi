package com.silvia.simulasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    API api;
    Button btnlogin;
    EditText edtpass, edtusername;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AndroidNetworking.initialize(this);

        api = new API();

        edtpass = findViewById(R.id.edtpass);
        edtusername = findViewById(R.id.edtusername);



        btnlogin = findViewById(R.id.btnlogin);
        prefManager = new PrefManager(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getLogin();


            }
        });
        if (prefManager.getLoginStatus()){
            Intent intent = new Intent(Login.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

    }
    private void getLogin() {
        AndroidNetworking.post(api.URL_LOGIN)
                .addBodyParameter("username", edtusername.getText().toString())
                .addBodyParameter("password", edtpass.getText().toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int stat = response.getInt("status");
                            String message = response.getString("message");
                            Log.d("sukses", "code"+response);
                            if (stat == 1){
                                JSONArray data = response.getJSONArray("data");
                                JSONObject a = data.getJSONObject(0);
                                prefManager.setIdUser(a.getString("id_siswa"));
                                prefManager.setLoginStatus(true);
                                Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Login.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("eror", "code :"+anError);
                        Toast.makeText(Login.this, ""+anError, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}