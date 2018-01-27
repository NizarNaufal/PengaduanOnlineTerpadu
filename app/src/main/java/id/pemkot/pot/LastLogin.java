package id.pemkot.pot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LastLogin extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2 , spinner3 ,spinner4 , spinner5;
    private Button btnchoose, btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulir_konsultasi);

        // When we select this spinner item, a Toast message will be displayed
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.topik, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);


        CustomAddValues();
        CustomAddSpinner();
        CustomAddSpinner4();
        CustomAddSpinner5();
        addListenerOnButton();
    }

    // add items into spinner dynamically
    public void CustomAddValues() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Badan Kepegawaian,Pendidikan dan Pelatihan");
        list.add("Dinas Penanaman Modal dan Perizinan Terpadu");
        list.add("Badan Perencanaan Pembangunan Daerah");
        list.add("Dinas Kearsipan Daerah");
        list.add("Dinas Lingkungan Hidup");
        list.add("Dinas Pemberdayaan Perempuan Dan Perlindungan Anak");
        list.add("Badan Pengelolaan Keuangan dan Aset Daerah");
        list.add("Dinas Perpusatakaan Daerah");
        list.add("Badan Penanggulangan Bencana Daerah");
        list.add("Dinas Pendidikan");
        list.add("Dinas Perhubungan");
        list.add("Dinas Sosial");
        list.add("Dinas Kependudukan dan Catatan Sipil");
        list.add("Dinas Kesehatan");
        list.add("Dinas Pekerjaan Umum dan Penataan Ruang");
        list.add("Dinas Kepemudaan dan Olahraga");
        list.add("Badan Penelitian dan Pengembangan Daerah");
        list.add("Dinas Perdagangan dan Perindustrian");
        list.add("Dinas Koperasi dan Usaha Kecil Menengah");
        list.add("Badan Pendapatan Daerah");
        list.add("Dinas Pariwisata dan Kebudayaan");
        list.add("Rumah Sakit Umum Daerah Kota Bekasi");
        list.add("Inspektorat");
        list.add("Satuan Polisi Pamong Praja");
        list.add("Sekretaris DPRD");
        list.add("Kecamatan Bekasi Timur");
        list.add("Kecamatan Bekasi Barat");
        list.add("Kecamatan Bekasi Utara");
        list.add("Kecamatan Bekasi Selatan");
        list.add("Kecamatan Jatiasih");
        list.add("Kecamatan Pondok Gede");
        list.add("Kecamatan Bantargebang");
        list.add("Kecamatan Jatisampurna");
        list.add("Kecamatan Rawalumbu");
        list.add("Kecamatan Mustika Jaya");
        list.add("Kecamatan Medan Satria");
        list.add("Bagian Hubungan Masyarakat");
        list.add("PDAM Tirta Patriot");
        list.add("Dinas Pertanian dan Perikanan");
        list.add("Dinas Kebersihan");
        list.add("Dinas Komunikasi, Informatika, Statistik dan Persandian");
        list.add("Dinas Koperasi Usaha Kecil dan Menengah");
        list.add("Dinas Perumahan Kawasan Permukiman dan Pertanahan");
        list.add("Bagian Umum");
        list.add("Dinas Tenaga Kerja");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void CustomAddSpinner() {

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> list = new ArrayList<String>();
        list.add("Saran");
        list.add("Permintaan Informasi");
        list.add("Keluhan");
        list.add("Pengaduan");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }

    public void CustomAddSpinner4() {

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        List<String> list = new ArrayList<String>();
        list.add("Tidak");
        list.add("Ya");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter);
    }

    public void CustomAddSpinner5() {

        spinner5 = (Spinner) findViewById(R.id.spinner5);
        List<String> list = new ArrayList<String>();
        list.add("Terbuka");
        list.add("Tertutup");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(dataAdapter);
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        btnchoose=(Button) findViewById(R.id.btnchoose);
        btnkirim = (Button) findViewById(R.id.btnsimpan);

        btnkirim.setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View v) {

                Toast.makeText(LastLogin.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+
                                String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+
                                String.valueOf(spinner2.getSelectedItem())+
                                "\nSpinner 3 : "+
                                String.valueOf(spinner2.getSelectedItem())+
                                "\nSpinner 4 : "+
                                String.valueOf(spinner2.getSelectedItem())+
                                "\nSpinner 5 : "+
                                String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected
            (AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " +
                        parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}