package id.ac.darmajaya.report.Model.Post;

import com.google.gson.annotations.SerializedName;

public class PostLogin {
    @SerializedName("nik")
    private String nik;
    @SerializedName("password")
    private String password;

    public PostLogin(String nik, String password) {
        this.nik = nik;
        this.password = password;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
