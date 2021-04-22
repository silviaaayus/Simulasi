package com.silvia.simulasi.MenuRpp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.silvia.simulasi.R;

import java.util.ArrayList;

public class AdapterRpp extends  RecyclerView.Adapter<AdapterRpp.ListViewHolder> {

    private Context context;
    private ArrayList<ModelRpp> listHero;

    public AdapterRpp(Context context, ArrayList<ModelRpp> list) {
        this.context = context;
        this.listHero = list;
    }

    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(AdapterRpp.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelRpp data);
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    /** Tempaat untuk masukkan sub layout / anak layout item */
    @NonNull
    @Override
    public AdapterRpp.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_rpp, viewGroup, false);
        return new ListViewHolder(view);
    }

    /** Tempat untuk memasukkan nilai dari model ke layout anak */
    @Override
    public void onBindViewHolder(@NonNull final AdapterRpp.ListViewHolder holder, int position) {
        ModelRpp dataRpp = listHero.get(position);

        String id = dataRpp.getId_rpp();
        String judul = dataRpp.getJudul_rpp();
        String file = dataRpp.getFile();






        holder.txtjudul.setText(judul);

        /** holder.btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Toast.makeText(context, "idnya : "+id, Toast.LENGTH_SHORT).show();
        }
        }); */

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, IsiListRpp.class);
                i.putExtra("file",file);
                context.startActivity(i);
//                onItemClickCallBack.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    /** Tempat untuk deklasi item di layout anak */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView txtjudul;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtjudul = itemView.findViewById(R.id.nama_rpp);




        }
    }
}
