package id.ac.darmajaya.report.Model.Post;

public class PostAduan {
    private String nik;
    private String id_ruangan;
    private String id_jam_perkuliahan;
    private String aduan;


    public PostAduan(String nik, String id_ruangan, String id_jam_perkuliahan, String aduan) {
        this.nik = nik;
        this.id_ruangan = id_ruangan;
        this.id_jam_perkuliahan = id_jam_perkuliahan;
        this.aduan = aduan;
    }

    public PostAduan() {
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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

    public String getAduan() {
        return aduan;
    }

    public void setAduan(String aduan) {
        this.aduan = aduan;
    }
}
