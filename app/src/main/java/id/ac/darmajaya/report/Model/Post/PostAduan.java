package id.ac.darmajaya.report.Model.Post;

public class PostAduan {
    private String nik;
    private String gedung;
    private String ruangan;
    private String jam_perkuliahan;
    private String aduan;

    public PostAduan(String nik, String gedung, String ruangan, String jam_perkuliahan, String aduan) {
        this.nik = nik;
        this.gedung = gedung;
        this.ruangan = ruangan;
        this.jam_perkuliahan = jam_perkuliahan;
        this.aduan = aduan;
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

    public String getAduan() {
        return aduan;
    }

    public void setAduan(String aduan) {
        this.aduan = aduan;
    }
}
