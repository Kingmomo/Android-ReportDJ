package id.ac.darmajaya.report;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.muddzdev.styleabletoast.StyleableToast;

import id.ac.darmajaya.report.Common.Common;
import id.ac.darmajaya.report.Common.Validate;
import id.ac.darmajaya.report.Model.Dosen;
import id.ac.darmajaya.report.Model.Post.GetLogin;
import id.ac.darmajaya.report.Model.Post.PostLogin;
import id.ac.darmajaya.report.Model.Post.PostStatus;
import id.ac.darmajaya.report.Retrofit.ApiClient;
import id.ac.darmajaya.report.Retrofit.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    private CompositeDisposable disposable = new CompositeDisposable();
    private ApiService apiService;
    private static final String TAG = "LOGIN";
    private TextInputEditText nik, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nik = findViewById(R.id.nik);
        password = findViewById(R.id.password);
        Button submit = findViewById(R.id.submit);
        apiService = ApiClient.getClient().create(ApiService.class);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostLogin login= new PostLogin(nik.getText().toString(),password.getText().toString());

                if (!Validate.cek(nik) && !Validate.cek(password)) {
                    disposable.add(apiService
                            .postLogins(login)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableSingleObserver<GetLogin>() {
                                @Override
                                public void onSuccess(GetLogin postStatus) {
                                    System.out.println("dasdas "+ postStatus.getMessage().getNama_dosen());
                                    if (postStatus.getStatus().equals("success")) {
                                        new StyleableToast.Builder(getApplicationContext())
                                                .text("Login Berhasil")
                                                .textColor(getResources().getColor(R.color.white_transparency))
                                                .backgroundColor(getResources().getColor(R.color.green_500))
                                                .iconStart(R.drawable.ic_check)
                                                .textBold()
                                                .cornerRadius(4)
                                                .show();
                                        Common.dosen = postStatus.getMessage();
                                        startActivity(new Intent(getApplicationContext(), FormActivity.class));

                                    } else {
                                        new StyleableToast.Builder(getApplicationContext())
                                                .text("Data Gagal Dilaporkan")
                                                .textColor(getResources().getColor(R.color.white_transparency))
                                                .iconStart(R.drawable.ic_error)
                                                .backgroundColor(getResources().getColor(R.color.red_500))
                                                .textBold()
                                                .cornerRadius(4)
                                                .show();
                                    }


                                }

                                @Override
                                public void onError(Throwable e) {
                                    new StyleableToast.Builder(getApplicationContext())
                                            .text("Pastikan Internet Hidup Saat Submit /n" + e.getMessage())
                                            .textColor(getResources().getColor(R.color.white_transparency))
                                            .iconStart(R.drawable.ic_error)
                                            .backgroundColor(getResources().getColor(R.color.red_500))
                                            .textBold()
                                            .cornerRadius(4)
                                            .show();
                                    Log.e(TAG, "onError: " + e.getMessage());
                                }
                            }));
                }
            }

        });

    }
}
