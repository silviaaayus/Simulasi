package com.silvia.simulasi.MenuRpp;

public class ModelRpp {

    private String id_rpp;
    private String judul_rpp;
    private String file;

    public ModelRpp(String id_rpp, String judul_rpp, String file) {
        this.id_rpp = id_rpp;
        this.judul_rpp = judul_rpp;
        this.file = file;
    }

    public String getId_rpp() {
        return id_rpp;
    }

    public void setId_rpp(String id_rpp) {
        this.id_rpp = id_rpp;
    }

    public String getJudul_rpp() {
        return judul_rpp;
    }

    public void setJudul_rpp(String judul_rpp) {
        this.judul_rpp = judul_rpp;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
