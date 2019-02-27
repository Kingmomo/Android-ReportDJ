package id.ac.darmajaya.report.Model.Post;

public class PostKerusakan {
    private String nik;
    private String id_jenis_kerusakan;
    private String id_ruangan;
    private String id_jam_perkuliahan;

    public PostKerusakan(String nik, String id_jenis_kerusakan, String id_ruangan, String id_jam_perkuliahan) {
        this.nik = nik;
        this.id_jenis_kerusakan = id_jenis_kerusakan;
        this.id_ruangan = id_ruangan;
        this.id_jam_perkuliahan = id_jam_perkuliahan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getId_jenis_kerusakan() {
        return id_jenis_kerusakan;
    }

    public void setId_jenis_kerusakan(String id_jenis_kerusakan) {
        this.id_jenis_kerusakan = id_jenis_kerusakan;
    }

    public String getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(String id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getId_jam_perkuliahan() {
        return id_jam_perkuliahan;
    }

    public void setId_jam_perkuliahan(String id_jam_perkuliahan) {
        this.id_jam_perkuliahan = id_jam_perkuliahan;
    }
}
