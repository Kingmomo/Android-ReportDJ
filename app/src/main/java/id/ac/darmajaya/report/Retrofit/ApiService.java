package id.ac.darmajaya.report.Retrofit;

import java.util.List;

import id.ac.darmajaya.report.Model.Contact;
import id.ac.darmajaya.report.Model.DataDJ;
import id.ac.darmajaya.report.Model.Kerusakan;
import id.ac.darmajaya.report.Model.Post.PostAduan;
import id.ac.darmajaya.report.Model.Post.PostKerusakan;
import id.ac.darmajaya.report.Model.Post.PostStatus;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("contacts.php")
    Single<List<Contact>> getContacts(@Query("search") String query);

    @GET("get")
    Single<DataDJ> getKampus();

    @POST("post_kerusakan")
    Single<PostStatus> postKerusakan(@Body PostKerusakan kerusakan);

    @POST("post_aduan")
    Single<PostStatus> postAduan(@Body PostAduan aduan);

}
