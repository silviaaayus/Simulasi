package com.silvia.simulasi.MenuEvaluasi;

public class ModelEvaluasi {

    private String id_materi;
    private String judul_materi;

    public ModelEvaluasi(String id_materi, String  judul_materi) {

        this.id_materi = id_materi;
        this.judul_materi = judul_materi;
    }



    public String getIdmateri() {
        return id_materi;
    }

    public void setId_materi(String id_materi) {
        this.id_materi = id_materi;
    }

    public String getJudul_materi() {
        return judul_materi;
    }

    public void setJudul_materi(String judul_materi) {
        this.judul_materi = judul_materi;
    }
}
