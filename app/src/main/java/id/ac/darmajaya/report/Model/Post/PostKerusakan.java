package id.ac.darmajaya.report.Model.Post;

public class PostKerusakan {
    private String nik;
    private String gedung;
    private String ruangan;
    private String id_jenis_kerusakan;
    private String nama_kerusakan;
    private String jam_perkuliahan;

    public PostKerusakan(String nik, String gedung, String ruangan, String id_jenis_kerusakan, String nama_kerusakan, String jam_perkuliahan) {
        this.nik = nik;
        this.gedung = gedung;
        this.ruangan = ruangan;
        this.id_jenis_kerusakan = id_jenis_kerusakan;
        this.nama_kerusakan = nama_kerusakan;
        this.jam_perkuliahan = jam_perkuliahan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getGedung() {
        return gedung;
    }

    public void setGedung(String gedung) {
        this.gedung = gedung;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getId_jenis_kerusakan() {
        return id_jenis_kerusakan;
    }

    public void setId_jenis_kerusakan(String id_jenis_kerusakan) {
        this.id_jenis_kerusakan = id_jenis_kerusakan;
    }

    public String getNama_kerusakan() {
        return nama_kerusakan;
    }

    public void setNama_kerusakan(String nama_kerusakan) {
        this.nama_kerusakan = nama_kerusakan;
    }

    public String getJam_perkuliahan() {
        return jam_perkuliahan;
    }

    public void setJam_perkuliahan(String jam_perkuliahan) {
        this.jam_perkuliahan = jam_perkuliahan;
    }
}
