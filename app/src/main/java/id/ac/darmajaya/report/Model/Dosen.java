package id.ac.darmajaya.report.Model;

import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("nik")
    private String nik;
    @SerializedName("nama_dosen")
    private String nama_dosen;

    public Dosen(String nik, String nama_dosen) {
        this.nik = nik;
        this.nama_dosen = nama_dosen;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama_dosen() {
        return nama_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }
}
