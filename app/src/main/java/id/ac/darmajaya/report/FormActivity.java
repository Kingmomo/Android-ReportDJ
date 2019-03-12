package id.ac.darmajaya.report;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.ac.darmajaya.report.Common.Validate;
import id.ac.darmajaya.report.Model.DataDJ;
import id.ac.darmajaya.report.Model.Gedung;
import id.ac.darmajaya.report.Model.Jam;
import id.ac.darmajaya.report.Model.Kerusakan;
import id.ac.darmajaya.report.Model.Post.PostAduan;
import id.ac.darmajaya.report.Model.Post.PostKerusakan;
import id.ac.darmajaya.report.Model.Post.PostStatus;
import id.ac.darmajaya.report.Model.Ruangan;
import id.ac.darmajaya.report.Retrofit.ApiClient;
import id.ac.darmajaya.report.Retrofit.ApiService;
import id.ac.darmajaya.report.view.LocalSearchActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class FormActivity extends AppCompatActivity {

    @BindView(R.id.date)
    TextView title;
    @BindView(R.id.jam)
    TextView jamperkuliahan;
    @BindView(R.id.gedung)
    TextView gedung;
    @BindView(R.id.nik)
    TextView nik;
    @BindView(R.id.dosen)
    TextView dosen;
    @BindView(R.id.kategori)
    TextView kategori;
    @BindView(R.id.kerusakan)
    TextView kerusakan;
    @BindView(R.id.namagedung)
    TextView namagedung;
    @BindView(R.id.ruangan)
    TextView ruangan;
    @BindView(R.id.aduan)
    TextInputLayout aduan;
    @BindView(R.id.etaduan)
    TextInputEditText etaduan;
    @BindView(R.id.submit)
    Button submit;

    private static final String TAG = "FormActivity";


    static final int PICK_DATA_DOSEN = 1;

    private CompositeDisposable disposable = new CompositeDisposable();
    private ApiService apiService;
    private List<Jam> jamList = new ArrayList<>();
    private List<Gedung> gedungList = new ArrayList<>();
    private List<Ruangan> ruanganList = new ArrayList<>();
    private List<Kerusakan> kerusakanList = new ArrayList<>();
    private CharSequence[] itemKetegori = {"Kerusakan", "Aduan"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        apiService = ApiClient.getClient().create(ApiService.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String currentdate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        title.setText(currentdate);
        ruangan.setEnabled(false);
        fetchContacts();


    }

    @OnClick(R.id.submit)
    public void submitdata() {
//        if (validasi())

        if (kategori.getText().toString().equals(itemKetegori[0].toString())) {
            LaporKerusakan();
        } else {
            LaporAduan();
        }
    }

    @OnClick({R.id.dosen, R.id.nik})
    public void opensearchactivity() {
        Intent intent = new Intent(this, LocalSearchActivity.class);
        startActivityForResult(intent, PICK_DATA_DOSEN);
    }

    @OnClick(R.id.jam)
    public void openjam() {
        showJamPerkuliahan();
    }

    @OnClick(R.id.kategori)
    public void openkategori() {
        showkategori();
    }

    @OnClick(R.id.gedung)
    public void opengedung() {
        showGedung();
    }

    @OnClick(R.id.ruangan)
    public void openRuangan() {
        showRuangan();
    }

    @OnClick(R.id.kerusakan)
    public void openkerusakan() {
        showKerusakan();
    }

    private void showRuangan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Ruangan");
        final String[] itemTitles = getRuanganArray();

        builder.setSingleChoiceItems(itemTitles, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                ruangan.setText(itemTitles[item]);
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showKerusakan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Jenis Kerusakan");
        final String[] itemTitles = getitemKerusakan();

        builder.setSingleChoiceItems(itemTitles, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                kerusakan.setText(itemTitles[item]);
                dialog.dismiss();
                System.out.println("idKerusakan " + findidkerusakan(kerusakan.getText().toString()));

            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showJamPerkuliahan() {
        // Use the Builder class for convenient dialog construction

      /*  LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView= inflater.inflate(R.layout.radio_button_dialog, null);
        builder.setView(dialogView);

        builder.setMessage("Jam Perkuliahan")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });

        RadioGroup rg = (RadioGroup) dialogView.findViewById(R.id.radio_group);


        for (int i = 0; i < jamList.size(); i++) {
            RadioButton rb = new RadioButton(this); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(jamList.get(i).getJam_perkuliahan());
            rg.addView(rb);
        }*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Jam Perkuliahan");
        final String[] itemTitles = getitemJamPerkualiahanArray();

        builder.setSingleChoiceItems(itemTitles, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                jamperkuliahan.setText(itemTitles[item]);
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }

    private void showGedung() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Gedung");
        final String[] itemTitles = getGedungArray();

        builder.setSingleChoiceItems(itemTitles, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                ruangan.setEnabled(true);
                gedung.setText(itemTitles[item]);
                namagedung.setText(gedungList.get(item).getNama_lain());
                dialog.dismiss();

                ruanganList.clear();
                ruanganList.addAll(gedungList.get(item).getRuangan());

            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showkategori() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pilih Kategori");

        builder.setSingleChoiceItems(itemKetegori, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                kategori.setText(itemKetegori[item]);
                switch (item) {
                    case 0:
                        kerusakan.setVisibility(View.VISIBLE);
                        aduan.setVisibility(View.GONE);
                        break;
                    case 1:
                        kerusakan.setVisibility(View.GONE);
                        aduan.setVisibility(View.VISIBLE);
                        break;
                }


                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private String[] getitemJamPerkualiahanArray() {
        final int itemCount = jamList.size();
        String[] itemTitles = new String[itemCount];
        for (int i = 0; i < itemCount; ++i) {
            itemTitles[i] = jamList.get(i).getJam_perkuliahan();
        }
        return itemTitles;
    }

    private String[] getitemKerusakan() {
        final int itemCount = kerusakanList.size();
        String[] itemTitles = new String[itemCount];
        for (int i = 0; i < itemCount; ++i) {
            itemTitles[i] = kerusakanList.get(i).getNama_kerusakan();
        }
        return itemTitles;
    }

    private String[] getGedungArray() {
        final int itemCount = gedungList.size();
        String[] itemTitles = new String[itemCount];
        for (int i = 0; i < itemCount; ++i) {
            itemTitles[i] = gedungList.get(i).getNama_gedung();
        }
        return itemTitles;
    }

    private String[] getRuanganArray() {

        final int itemCount = ruanganList.size();
        System.out.println("hdah "+ itemCount);
        System.out.println("hdah "+ findRuanganByIdgedung());
        String[] itemTitles = new String[itemCount];
        for (int i = 0; i < itemCount; ++i) {
            itemTitles[i] = ruanganList.get(i).getNama_ruang();
        }
        return itemTitles;
    }

    private void fetchContacts() {

        disposable.add(apiService
                .getKampus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DataDJ>() {
                    @Override
                    public void onSuccess(DataDJ dataDJS) {
                        jamList.clear();
                        gedungList.clear();
                        kerusakanList.clear();
                        jamList.addAll(dataDJS.getJam());
                        gedungList.addAll(dataDJS.getGedung());
                        kerusakanList.addAll(dataDJS.getKerusakan());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }

    private void LaporKerusakan() {
        PostKerusakan postKerusakan = new PostKerusakan(
                nik.getText().toString(),
                gedung.getText().toString(),
                ruangan.getText().toString(),
                findidkerusakan(kerusakan.getText().toString()),
                kerusakan.getText().toString(),
                jamperkuliahan.getText().toString()


        );
        disposable.add(apiService
                .postKerusakan(postKerusakan)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<PostStatus>() {
                    @Override
                    public void onSuccess(PostStatus postStatus) {
                        if (postStatus.getStatus().equals("success")) {
                            new StyleableToast.Builder(getApplicationContext())
                                    .text("Data Berhasil Dilaporkan")
                                    .textColor(getResources().getColor(R.color.white_transparency))
                                    .backgroundColor(getResources().getColor(R.color.green_500))
                                    .iconStart(R.drawable.ic_check)
                                    .textBold()
                                    .cornerRadius(4)
                                    .show();
                        } else {
                            new StyleableToast.Builder(getApplicationContext())
                                    .text("Data Sudah Pernah Dilaporkan")
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
                                .text("Pastikan Internet Hidup Saat Submit \n" + e.getMessage())
                                .textColor(getResources().getColor(R.color.white_transparency))
                                .iconStart(R.drawable.ic_error)
                                .backgroundColor(getResources().getColor(R.color.red_500))
                                .textBold()
                                .cornerRadius(4)
                                .show();
                    }
                }));
    }

    private void LaporAduan() {
        PostAduan postAduan = new PostAduan(
                nik.getText().toString(),
                gedung.getText().toString(),
                ruangan.getText().toString(),
                jamperkuliahan.getText().toString(),
                etaduan.getText().toString()

        );
        disposable.add(apiService
                .postAduan(postAduan)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<PostStatus>() {
                    @Override
                    public void onSuccess(PostStatus postStatus) {
                        if (postStatus.getStatus().equals("success")) {
                            new StyleableToast.Builder(getApplicationContext())
                                    .text("Data Berhasil Dilaporkan")
                                    .textColor(getResources().getColor(R.color.white_transparency))
                                    .backgroundColor(getResources().getColor(R.color.green_500))
                                    .iconStart(R.drawable.ic_check)
                                    .textBold()
                                    .cornerRadius(4)
                                    .show();
                        } else {
                            new StyleableToast.Builder(getApplicationContext())
                                    .text("Data Sudah Pernah Dilaporkan")
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


    private String findjamid() {
        for (Jam jam : jamList) {
            if (jam.getJam_perkuliahan().equals(jamperkuliahan.getText().toString()))
                return jam.getId();
        }
        return null;
    }

    private String findidkerusakan(String name) {
        for (Kerusakan kerusakan : kerusakanList) {
            if (kerusakan.getNama_kerusakan().equals(name))
                return kerusakan.getId();
        }
        return null;
    }

    private String findidruangan() {
        for (Ruangan ruangann : ruanganList) {
            if (ruangann.getNama_ruang().equals(ruangan.getText().toString()))
                return ruangann.getId();
        }
        return null;
    }

    private List<Ruangan> findRuanganByIdgedung() {
        for (Gedung gedungg : gedungList) {
            if (gedungg.getNama_gedung().equals(gedung.getText().toString())) ;
            return gedungg.getRuangan();
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_DATA_DOSEN) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result_nik = data.getStringExtra("result_nik");
                String result_dosen = data.getStringExtra("result_dosen");
                nik.setText(result_nik.trim());
                dosen.setText(result_dosen.trim());


            }
        }
    }

    private Boolean validasi() {
        if (!Validate.cek(nik)
                && !Validate.cek(dosen)
                && !Validate.cek(jamperkuliahan)
                && !Validate.cek(gedung)
                && !Validate.cek(ruangan)
                && !Validate.cek(kategori))
                return true;
        else
        {
            return false;
        }
    }
}
