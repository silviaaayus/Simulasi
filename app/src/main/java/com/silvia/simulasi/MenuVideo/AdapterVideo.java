package com.silvia.simulasi.MenuVideo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.silvia.simulasi.MenuRpp.AdapterRpp;
import com.silvia.simulasi.MenuRpp.IsiListRpp;
import com.silvia.simulasi.MenuRpp.ModelRpp;
import com.silvia.simulasi.R;

import java.util.ArrayList;

public class AdapterVideo extends  RecyclerView.Adapter<AdapterVideo.ListViewHolder>{

    private Context context;
    private ArrayList<ModelVideo> listVideo;

    public AdapterVideo(Context context, ArrayList<ModelVideo> listVideo) {
        this.context = context;
        this.listVideo = listVideo;
    }
    private AdapterVideo.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(AdapterVideo.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack =  onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelVideo data);
    }

    @Override
    public int getItemCount() {
        return listVideo.size();
    }

    /** Tempaat untuk masukkan sub layout / anak layout item */
    @NonNull
    @Override
    public AdapterVideo.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_video, viewGroup, false);
        return new ListViewHolder(view);
    }

    /** Tempat untuk memasukkan nilai dari model ke layout anak */
    @Override
    public void onBindViewHolder(@NonNull final AdapterVideo.ListViewHolder holder, int position) {
        ModelVideo dataVideo = listVideo.get(position);

        String id = dataVideo.getId_video();
        String judul = dataVideo.getJudul_video();
        String link = dataVideo.getLink();





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
                Intent i = new Intent(context, IsiListVideo.class);
                i.putExtra("link",link);
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

            txtjudul = itemView.findViewById(R.id.nama_video);




        }
    }
}
