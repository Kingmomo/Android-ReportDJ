package id.ac.darmajaya.report.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataDJ {
    @SerializedName("dosen")
    private List<Dosen> dosen;
    @SerializedName("gedung")
    private List<Gedung> gedung;
    @SerializedName("jam_perkuliahan")
    private List<Jam> jam;
    @SerializedName("jenis_kerusakan")
    private List<Kerusakan> kerusakan;
    @SerializedName("status")
    private String status;

    public DataDJ() {
    }

    public DataDJ(List<Dosen> dosen, List<Gedung> gedung, List<Jam> jam, List<Kerusakan> kerusakan, String status) {
        this.dosen = dosen;
        this.gedung = gedung;
        this.jam = jam;
        this.kerusakan = kerusakan;
        this.status = status;
    }


    public List<Dosen> getDosen() {
        return dosen;
    }

    public void setDosen(List<Dosen> dosen) {
        this.dosen = dosen;
    }

    public List<Gedung> getGedung() {
        return gedung;
    }

    public void setGedung(List<Gedung> gedung) {
        this.gedung = gedung;
    }

    public List<Jam> getJam() {
        return jam;
    }

    public void setJam(List<Jam> jam) {
        this.jam = jam;
    }

    public List<Kerusakan> getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(List<Kerusakan> kerusakan) {
        this.kerusakan = kerusakan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
