package id.pemkot.pot.recylcerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.pemkot.pot.*;

import java.util.ArrayList;
import java.util.List;

public class KonsultasiFragment extends Fragment {

    private RecyclerView listKonsultasi;
    private LinearLayoutManager linearLayoutManager;
    private KonsultasiAdapter konsultasiAdapter;

    protected Context context;

    public static KonsultasiFragment newInstance(){
        return new KonsultasiFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_konsultasi, container, false);

        listKonsultasi = (RecyclerView) rootView.findViewById(R.id.listKonsultasi);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        konsultasiAdapter = new KonsultasiAdapter();

        listKonsultasi.setLayoutManager(linearLayoutManager);
        listKonsultasi.setAdapter(konsultasiAdapter);

        loadData();
    }

    private void loadData(){
        List<Konsultasi> konsultasiList = new ArrayList<>();
        Konsultasi konsultasi;

        int thumb[] = {R.mipmap.sampah, R.mipmap.wifi, R.mipmap.noimage,
                R.mipmap.noimage, R.mipmap.noimage, R.mipmap.noimage};

        String name[] = {"Sampah Ditengah Warga", "Wifi taman gigi", "eKTP status Ready_Print_Record", "Lampu PJU Mati Hampir 1 Tahun",
                "Balapan Liar Jalan Ahmad Yani", "PUNGUTAN LIAR"};

        String team[] = {"Yth Dinas Kebersihan : Mohon untuk Solusinya untuk masalah sampah yang berada ditengah permukiman warga", "Oknum Security yang seenaknya mematikan fasilitas wifi yang sediakan pemerintah untuk warga bekasi", "Hari ini 20 Des 2017 saya cek ektp anak saya dikecamatan mustika jaya dan dijawab belum ada",
                "Mohon tindak lanjutnya untuk lampu PJU di Perumahan Jatibening Dua Tepatnya di depan JL Limau VI Blok L No.59", "Mohon Ditertibkan Balapan Liar di jalan ahmad yani depan stadion patriot bekasi", "Tolong untuk ditindak lanjuti sudah terlalu sering SDN CIMUNING 5 Melakukan PUNGLI bermacam-macam alasan"};

        for(int i=0; i < thumb.length; i++){
            konsultasi = new Konsultasi();

            konsultasi.setId(i+1);
            konsultasi.setName(name[i]);
            konsultasi.setTeam(team[i]);
            konsultasi.setThumb(thumb[i]);

            konsultasiList.add(konsultasi);
        }

        konsultasiAdapter.addAll(konsultasiList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}