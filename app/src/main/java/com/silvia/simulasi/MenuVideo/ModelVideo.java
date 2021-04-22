package com.silvia.simulasi.MenuVideo;

public class ModelVideo {
    private String id_video;
    private String judul_video;
    private String link ;

    public ModelVideo(String id_video, String judul_video, String link) {
        this.id_video = id_video;
        this.judul_video = judul_video;
        this.link = link;
    }

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    public String getJudul_video() {
        return judul_video;
    }

    public void setJudul_video(String judul_video) {
        this.judul_video = judul_video;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
