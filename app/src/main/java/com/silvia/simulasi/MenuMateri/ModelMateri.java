package com.silvia.simulasi.MenuMateri;

public class ModelMateri {
private String id_materi;
private String judul_materi;
private String file;

    public ModelMateri(String id_materi, String judul_materi, String file) {
        this.id_materi = id_materi;
        this.judul_materi = judul_materi;
        this.file = file;

    }

    public String getId_materi() {
        return id_materi;
    }

    public String getJudul_materi() {
        return judul_materi;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setId_materi(String id_materi) {
        this.id_materi = id_materi;
    }

    public void setJudul_materi(String judul_materi) {
        this.judul_materi = judul_materi;
    }
}
