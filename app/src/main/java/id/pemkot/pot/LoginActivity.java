package id.pemkot.pot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_activity);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_daftar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        if (v.getId() == R.id.btn_login) {
            startActivity(new Intent(LoginActivity.this, PengaduanOnlineTerpadu.class));
        }
        if (v.getId() == R.id.btn_daftar) {
            startActivity(new Intent(LoginActivity.this, DaftarAkun.class));
        }
    }

    public void onBackPressed() {
        this. finish();

    }
}