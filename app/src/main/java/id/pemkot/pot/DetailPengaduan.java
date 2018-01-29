package id.pemkot.pot;

import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Poncoe on 29/01/18.
 */

public class DetailPengaduan extends AppCompatActivity {

    private LayerDrawable shareMenuIcon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pengaduan);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CardView card_view1 = (CardView) findViewById(R.id.card1);
        CardView card_view2 = (CardView) findViewById(R.id.card2);

        card_view1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Lu Ngeklik Cardview", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(view.getContext(), TidakTersedia.class);
                //startActivity(i);
            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Lu Ngeklik Cardview", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(view.getContext(), TidakTersedia.class);
                //startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);

        shareMenuIcon = (LayerDrawable) menu.findItem(R.id.share).getIcon();

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share:
                Toast.makeText(getApplicationContext(),"Tombol Share Terpilih", Toast.LENGTH_SHORT).show();
                ///Intent intent = new Intent(DetailPengaduan.this, TidakTersedia.class);
                //startActivity(intent);
                break;
        }

        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}