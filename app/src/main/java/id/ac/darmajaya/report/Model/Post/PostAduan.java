package id.ac.darmajaya.report.Model.Post;

public class PostAduan {
    private String nik;
    private String gedung;
    private String ruangan;
    private String jam_perkuliahan;
    private String nama_aduan;
    private String keterangan;

    public PostAduan(String nik, String gedung, String ruangan, String jam_perkuliahan, String nama_aduan, String keterangan) {
        this.nik = nik;
        this.gedung = gedung;
        this.ruangan = ruangan;
        this.jam_perkuliahan = jam_perkuliahan;
        this.nama_aduan = nama_aduan;
        this.keterangan = keterangan;
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

    public String getJam_perkuliahan() {
        return jam_perkuliahan;
    }

    public void setJam_perkuliahan(String jam_perkuliahan) {
        this.jam_perkuliahan = jam_perkuliahan;
    }

    public String getNama_aduan() {
        return nama_aduan;
    }

    public void setNama_aduan(String nama_aduan) {
        this.nama_aduan = nama_aduan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
