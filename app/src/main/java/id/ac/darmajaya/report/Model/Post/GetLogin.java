package id.ac.darmajaya.report.Model.Post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.darmajaya.report.Model.Dosen;

public class GetLogin {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private Dosen message;

    public GetLogin(String status, Dosen message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Dosen getMessage() {
        return message;
    }

    public void setMessage(Dosen message) {
        this.message = message;
    }
}
