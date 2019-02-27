package id.ac.darmajaya.report.Model;

public class Kerusakan {
    private String id;
    private String nama_kerusakan;

    public Kerusakan(String id, String nama_kerusakan) {
        this.id = id;
        this.nama_kerusakan = nama_kerusakan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_kerusakan() {
        return nama_kerusakan;
    }

    public void setNama_kerusakan(String nama_kerusakan) {
        this.nama_kerusakan = nama_kerusakan;
    }
}
