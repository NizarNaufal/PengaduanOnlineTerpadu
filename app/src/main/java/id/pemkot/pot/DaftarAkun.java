package id.pemkot.pot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class DaftarAkun extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.daftar_akun);

        findViewById(R.id.btn_daftar).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        if (v.getId() == R.id.btn_daftar) {
            startActivity(new Intent(DaftarAkun.this, LoginActivity.class));
        }
        if (v.getId() == R.id.btn_login) {
            startActivity(new Intent(DaftarAkun.this, LoginActivity.class));
        }
    }

    public void onBackPressed() {
        this. finish();

    }
}