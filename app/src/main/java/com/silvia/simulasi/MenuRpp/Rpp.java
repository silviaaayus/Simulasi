package com.silvia.simulasi.MenuRpp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.silvia.simulasi.API;
import com.silvia.simulasi.MenuEvaluasi.ListEvaluasi;
import com.silvia.simulasi.MenuEvaluasi.ModelEvaluasi;
import com.silvia.simulasi.MenuMateri.AdapterMateri;
import com.silvia.simulasi.MenuMateri.ListMateri;
import com.silvia.simulasi.MenuMateri.ModelMateri;
import com.silvia.simulasi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Rpp extends AppCompatActivity {
    private API api;
    private RecyclerView rvHeroes;
    private ArrayList<ModelRpp> list = new ArrayList<>();
    private AdapterRpp listNoteAdapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpp);

        api = new API();
        requestQueue = Volley.newRequestQueue(this);
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        showRecyclerList();
        ambilData();
    }
    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        listNoteAdapter = new AdapterRpp(this, list);
        rvHeroes.setAdapter(listNoteAdapter);

        listNoteAdapter.setOnItemClickCallBack(new AdapterRpp.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelRpp data) {
                String id = data.getId_rpp();
                Toast.makeText(Rpp.this, id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ambilData(){

        String url = api.URL_RPP;
        Log.e("urlnyo",url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject res) {
                try {

                    String pesan = res.getString("pesan");
                    Integer status = res.getInt("status");
                    JSONArray data = res.getJSONArray("data");
                    for(int i = 0; i < data.length();i++){
                        JSONObject obj = data.getJSONObject(i);
                        String id_rpp = obj.getString("id_rpp");
                        String judul_rpp = obj.getString("judul_rpp");
                        String file = obj.getString("file");


                        list.add(new ModelRpp(
                                id_rpp,judul_rpp,file
                        ));

                    }

                    listNoteAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(Rpp.this, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}