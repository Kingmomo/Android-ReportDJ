package id.ac.darmajaya.report.Model;

public class Aduan {
    private String id;
    private String nama_aduan;

    public Aduan(String id, String nama_aduan) {
        this.id = id;
        this.nama_aduan = nama_aduan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_aduan() {
        return nama_aduan;
    }

    public void setNama_aduan(String nama_aduan) {
        this.nama_aduan = nama_aduan;
    }
}
