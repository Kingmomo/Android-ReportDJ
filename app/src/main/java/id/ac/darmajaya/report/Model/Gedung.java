package id.ac.darmajaya.report.Model;

import java.util.List;

public class Gedung {
    private int id;
    private String nama_gedung;
    private String nama_lain;
    private List<Ruangan> ruangan;

    public Gedung(int id, String nama_gedung, String nama_lain, List<Ruangan> ruangan) {
        this.id = id;
        this.nama_gedung = nama_gedung;
        this.nama_lain = nama_lain;
        this.ruangan = ruangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_gedung() {
        return nama_gedung;
    }

    public void setNama_gedung(String nama_gedung) {
        this.nama_gedung = nama_gedung;
    }

    public String getNama_lain() {
        return nama_lain;
    }

    public void setNama_lain(String nama_lain) {
        this.nama_lain = nama_lain;
    }

    public List<Ruangan> getRuangan() {
        return ruangan;
    }

    public void setRuangan(List<Ruangan> ruangan) {
        this.ruangan = ruangan;
    }
}
