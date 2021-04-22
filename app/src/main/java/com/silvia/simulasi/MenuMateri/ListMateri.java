package com.silvia.simulasi.MenuMateri;

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
import com.silvia.simulasi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListMateri extends AppCompatActivity {
    private API api;
    private RecyclerView rvHeroes;
    private ArrayList<ModelMateri> list = new ArrayList<>();
    private AdapterMateri listNoteAdapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi);

        api = new API();
        requestQueue = Volley.newRequestQueue(this);
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        showRecyclerList();
        ambilData();
    }
    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        listNoteAdapter = new AdapterMateri(this, list);
        rvHeroes.setAdapter(listNoteAdapter);

        listNoteAdapter.setOnItemClickCallBack(new AdapterMateri.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelMateri data) {
                String id = data.getId_materi();
                Toast.makeText(ListMateri.this, id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ambilData(){

        String url = api.URL_MATERI;
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
                        String id_materi = obj.getString("id_materi");
                        String judul_materi = obj.getString("judul_materi");
                        String file = obj.getString("file");

                        list.add(new ModelMateri(
                                id_materi,judul_materi,file
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
                Toast.makeText(ListMateri.this, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}


