package id.ac.darmajaya.report.Common;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Validate {

    public static boolean cek(TextView et) {
            View focusView = null;
            Boolean cancel=false;
            if (TextUtils.isEmpty(et.getText().toString().trim())) {
                et.setError("Inputan Harus Di Isi");
                focusView = et;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();
            }
            return cancel;
    }


    public static boolean cekPassword(EditText et, String Password, String ConfirmPassword){
        View focusView = null;
        Boolean cancel=false;
        if (!Password.equals(ConfirmPassword)) {
            et.setError("Password tidak sama");
            focusView = et;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        }
        return cancel;
    }

}
