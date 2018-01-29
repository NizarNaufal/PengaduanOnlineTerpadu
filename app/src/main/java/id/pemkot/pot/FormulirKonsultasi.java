package id.pemkot.pot;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import id.pemkot.pot.spinner.MaterialSpinner;

public class FormulirKonsultasi extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_PERMISSIONS = 123;
    private int PICK_IMAGE_REQUEST = 125;
    private String realPath;
    private final int REQUEST_APP_SETTINGS = 321;

    private static final String[] PILIH_TOPIK = {
            "Pilihan 1",
            "Pilihan 2",
            "Pilihan 3",
            "Pilihan 4"
    };

    private static final String[] PILIH_INSTANSI = {
            "Pilihan 1",
            "Pilihan 2",
            "Pilihan 3",
            "Pilihan 4"
    };

    private static final String[] PILIH_KATEGORI = {
            "Pilihan 1",
            "Pilihan 2",
            "Pilihan 3",
            "Pilihan 4"
    };

    private static final String[] PILIH_RAHASIA_IDENTITAS = {
            "Pilihan 1",
            "Pilihan 2",
            "Pilihan 3",
            "Pilihan 4"
    };

    private static final String[] PILIH_RAHASIA_PENGADUAN = {
            "Pilihan 1",
            "Pilihan 2",
            "Pilihan 3",
            "Pilihan 4"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulir_konsultasi);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        findViewById(R.id.btnchoose).setOnClickListener(this);
        findViewById(R.id.btnsimpan).setOnClickListener(this);

        /* Awal All About Spinner **/

        // Spinner Topik

        MaterialSpinner spinnerTopik = (MaterialSpinner) findViewById(R.id.spinnertopik);
        spinnerTopik.setItems(PILIH_TOPIK);
        spinnerTopik.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Anda Memilih " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinnerTopik.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinnerTopik) {
                Snackbar.make(spinnerTopik, "", Snackbar.LENGTH_LONG).show();
            }
        });

        // Spinner Instansi

        MaterialSpinner spinnerInstansi = (MaterialSpinner) findViewById(R.id.spinnerinstansi);
        spinnerInstansi.setItems(PILIH_INSTANSI);
        spinnerInstansi.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Anda Memilih " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinnerInstansi.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinnerInstansi) {
                Snackbar.make(spinnerInstansi, "", Snackbar.LENGTH_LONG).show();
            }
        });

        // Spinner Instansi

        MaterialSpinner spinnerKategori = (MaterialSpinner) findViewById(R.id.spinnerkategori);
        spinnerKategori.setItems(PILIH_KATEGORI);
        spinnerKategori.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Anda Memilih " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinnerKategori.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinnerKategori) {
                Snackbar.make(spinnerKategori, "", Snackbar.LENGTH_LONG).show();
            }
        });

        // Spinner Rahasia Identitas

        MaterialSpinner spinnerRahasiaID = (MaterialSpinner) findViewById(R.id.spinnerrahasiaid);
        spinnerRahasiaID.setItems(PILIH_RAHASIA_IDENTITAS);
        spinnerRahasiaID.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Anda Memilih " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinnerRahasiaID.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinnerRahasiaID) {
                Snackbar.make(spinnerRahasiaID, "", Snackbar.LENGTH_LONG).show();
            }
        });

        // Spinner Rahasia Pengaduan

        MaterialSpinner spinnerRahasiaPengaduan = (MaterialSpinner) findViewById(R.id.spinnerrahasiapengaduan);
        spinnerRahasiaPengaduan.setItems(PILIH_RAHASIA_PENGADUAN);
        spinnerRahasiaPengaduan.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Anda Memilih " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinnerRahasiaPengaduan.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinnerRahasiaPengaduan) {
                Snackbar.make(spinnerRahasiaPengaduan, "", Snackbar.LENGTH_LONG).show();
            }
        });

        /* Akhir dari All About Spinner **/

    }

        // Pilih Gambar

    public void selectImage() {


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            int hasWriteContactsPermission = checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS);
                return;

            } else
                //already granted
                selectPicture();


        } else {
            //normal process
            selectPicture();
        }


    }

    private void selectPicture() {

        realPath = null;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture_title)), PICK_IMAGE_REQUEST);
    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {

        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("BATAL", null)
                .create()
                .show();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case REQUEST_PERMISSIONS:

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    selectPicture();

                } else {
                    // Permission Denied
                    showMessageOKCancel(String.valueOf(R.string.permissionsgambar),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    goToSettings();

                                }
                            });

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }


    private void goToSettings() {

        Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + getPackageName()));
        myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
        myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(myAppSettings, REQUEST_APP_SETTINGS);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_APP_SETTINGS) {

            if (hasPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)) {

                selectPicture();

            } else {

                showMessageOKCancel(String.valueOf(R.string.permissionsgambar),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                goToSettings();

                            }
                        });

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean hasPermissions(@NonNull String... permissions) {
        for (String permission : permissions)
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, permission))
                return false;
        return true;

    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

        if (v.getId() == R.id.btnchoose) {
            selectImage();
        }
        if (v.getId() == R.id.btnsimpan) {
            Toast.makeText(getApplicationContext(),"Masuk Kedalam Detail Pengaduan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(FormulirKonsultasi.this, DetailPengaduan.class));
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
