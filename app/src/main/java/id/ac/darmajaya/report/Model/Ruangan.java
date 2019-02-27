package id.ac.darmajaya.report.Model;

public class Ruangan {
    private String id;
    private String id_gedung;
    private String nama_ruang;

    public Ruangan(String id, String id_gedung, String nama_ruang) {
        this.id = id;
        this.id_gedung = id_gedung;
        this.nama_ruang = nama_ruang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_gedung() {
        return id_gedung;
    }

    public void setId_gedung(String id_gedung) {
        this.id_gedung = id_gedung;
    }

    public String getNama_ruang() {
        return nama_ruang;
    }

    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
    }
}
