package id.ac.darmajaya.report.Model;

public class Jam {
    private String id;
    private String jam_perkuliahan;

    public Jam(String id, String jam_perkuliahan) {
        this.id = id;
        this.jam_perkuliahan = jam_perkuliahan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJam_perkuliahan() {
        return jam_perkuliahan;
    }

    public void setJam_perkuliahan(String jam_perkuliahan) {
        this.jam_perkuliahan = jam_perkuliahan;
    }
}
