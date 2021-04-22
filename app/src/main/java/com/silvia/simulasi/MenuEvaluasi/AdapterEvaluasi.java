package com.silvia.simulasi.MenuEvaluasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.silvia.simulasi.MenuMateri.AdapterMateri;

import com.silvia.simulasi.MenuMateri.ModelMateri;
import com.silvia.simulasi.R;

import java.util.ArrayList;

public class AdapterEvaluasi extends RecyclerView.Adapter<AdapterEvaluasi.ListViewHolder> {

    private Context context;
    private ArrayList<ModelEvaluasi> listMateri;

    public AdapterEvaluasi(Context context, ArrayList<ModelEvaluasi> listMateri) {
        this.context = context;
        this.listMateri = listMateri;
    }

    private AdapterEvaluasi.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(AdapterEvaluasi.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelEvaluasi data);
    }

    @Override
    public int getItemCount() {
        return listMateri.size();
    }

    /** Tempaat untuk masukkan sub layout / anak layout item */
    @NonNull
    @Override
    public AdapterEvaluasi.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_evaluasi, viewGroup, false);
        return new ListViewHolder(view);
    }

    /** Tempat untuk memasukkan nilai dari model ke layout anak */
    @Override
    public void onBindViewHolder(@NonNull final AdapterEvaluasi.ListViewHolder holder, int position) {
        ModelEvaluasi dataModel = listMateri.get(position);

        String id = dataModel.getIdmateri();
        String judul = dataModel.getJudul_materi();

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
              /*  Toast.makeText(context, "idnya : "+id, Toast.LENGTH_SHORT).show();*/
               Intent i = new Intent(context, Evaluasi.class);
                i.putExtra("id_materi",id);
                context.startActivity(i);
//                onItemClickCallBack.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    /** Tempat untuk deklasi item di layout anak */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView txtjudul,  txt_catatan, txt_tanggal;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtjudul = itemView.findViewById(R.id.nama_evaluasi);




        }
    }
}





