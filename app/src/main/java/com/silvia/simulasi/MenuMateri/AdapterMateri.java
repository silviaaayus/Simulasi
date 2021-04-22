package com.silvia.simulasi.MenuMateri;

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


    public class AdapterMateri extends  RecyclerView.Adapter<AdapterMateri.ListViewHolder> {

        private Context context;
        private ArrayList<ModelMateri> listHero;

        public AdapterMateri(Context context, ArrayList<ModelMateri> list) {
            this.context = context;
            this.listHero = list;
        }

        private OnItemClickCallBack onItemClickCallBack;

        public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
            this.onItemClickCallBack = onItemClickCallBack;
        }

        public interface OnItemClickCallBack {
            void onItemClicked(ModelMateri data);
        }

        @Override
        public int getItemCount() {
            return listHero.size();
        }

        /** Tempaat untuk masukkan sub layout / anak layout item */
        @NonNull
        @Override
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_materi, viewGroup, false);
            return new ListViewHolder(view);
        }

        /** Tempat untuk memasukkan nilai dari model ke layout anak */
        @Override
        public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
            ModelMateri dataModel = listHero.get(position);

            String id = dataModel.getId_materi();
            String judul = dataModel.getJudul_materi();
            String file = dataModel.getFile();





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
                    Intent i = new Intent(context, IsiListMateri.class);
                    i.putExtra("file",file);
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

                txtjudul = itemView.findViewById(R.id.nama_materi);




            }
        }
    }

