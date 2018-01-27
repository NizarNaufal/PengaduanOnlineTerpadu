package id.pemkot.pot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class PengaduanOnlineTerpadu extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    final String Email = "nizarnfl21@gmail.com"; //

    GridView grid; //Grid
    GridAdapter adapter; //grid
    String[] Judul; // grid
    int[] image; // grid
    private TextView messageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // GridView Awal

        Judul = new String[]{"Home", "Pengaduan", "Profile", "Logout", "TentangAplikasi",};
        image = new int[]{R.mipmap.home, R.mipmap.register, R.mipmap.login, R.mipmap.login,R.mipmap.informasi,};

        grid = (GridView) findViewById(R.id.gridview);
        adapter = new GridAdapter(getApplicationContext(), Judul, image);
        grid.setAdapter(adapter);

        // kasih fungsi jika diklik
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /* KETERANGAN!!

                kalo di gridview mau dikasih activity / intent pake kodingan ini :

                    myIntent = new Intent(view.getContext(), SitusSekolah.class);

                cuma kalo mau main ACTION_VIEW silahkan pake ini :

                    myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://twitter.com/official_Tels"));

                    sesuain kebutuhan aja..

                   --> image & judul bisa kalian ubah, intinya 1 gridview itu 1 judul & image.

                 */

                Intent myIntent = null;
                if (position == 0) {
                    //myIntent = new Intent(view.getContext(), SitusSekolah.class); <!-- contoh Kalo Mau Kasih Intent -->
                    myIntent = new Intent(view.getContext(), KonsultasiKedua.class);
                }
                if (position == 1) {
                    //myIntent = new Intent(view.getContext(), LetakSekolah.class); <!-- contoh Kalo Mau Kasih Intent -->
                    myIntent = new Intent(view.getContext(), Pengaduan.class);
                }
                if (position == 2) {
                    myIntent = new Intent(view.getContext(), ProfileAccount.class);
                }
                if (position == 3) {
                    myIntent = new Intent (view.getContext(),LogoutAccount.class);
                }
                if (position == 4) {
                    myIntent = new Intent (view.getContext(), TentangAplikasi.class);
                }
                startActivity(myIntent);

            }

        });
    }

    //GridView Akhir

    public void onBackPressed() {
        finish();//Pergi ke method exit
    }
}