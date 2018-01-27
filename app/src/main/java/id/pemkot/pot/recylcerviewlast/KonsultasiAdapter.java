package id.pemkot.pot.recylcerviewlast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.pemkot.pot.*;
import id.pemkot.pot.recylcerviewlast.*;

import java.util.ArrayList;
import java.util.List;

public class KonsultasiAdapter extends RecyclerView.Adapter<id.pemkot.pot.recylcerviewlast.KonsultasiAdapter.MemberViewHolder>{

    private List<id.pemkot.pot.recylcerviewlast.Konsultasi> konsultasiList;

    public KonsultasiAdapter() {
        konsultasiList = new ArrayList<>();
    }

    private void add(id.pemkot.pot.recylcerviewlast.Konsultasi item) {
        konsultasiList.add(item);
        notifyItemInserted(konsultasiList.size() - 1);
    }

    public void addAll(List<id.pemkot.pot.recylcerviewlast.Konsultasi> konsultasiList) {
        for (id.pemkot.pot.recylcerviewlast.Konsultasi konsultasi : konsultasiList) {
            add(konsultasi);
        }
    }

    public void remove(id.pemkot.pot.recylcerviewlast.Konsultasi item) {
        int position = konsultasiList.indexOf(item);
        if (position > -1) {
            konsultasiList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public id.pemkot.pot.recylcerviewlast.Konsultasi getItem(int position){
        return konsultasiList.get(position);
    }

    @Override
    public id.pemkot.pot.recylcerviewlast.KonsultasiAdapter.MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_konsultasi, parent, false);
        id.pemkot.pot.recylcerviewlast.KonsultasiAdapter.MemberViewHolder memberViewHolder = new id.pemkot.pot.recylcerviewlast.KonsultasiAdapter.MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(id.pemkot.pot.recylcerviewlast.KonsultasiAdapter.MemberViewHolder holder, int position) {
        final id.pemkot.pot.recylcerviewlast.Konsultasi konsultasi = konsultasiList.get(position);

        holder.memberThumb.setImageResource(konsultasi.getThumb());
        holder.memberName.setText(konsultasi.getName());
        holder.memberTeam.setText(konsultasi.getTeam());
    }

    @Override
    public int getItemCount() {
        return konsultasiList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        ImageView memberThumb;
        TextView memberName;
        TextView memberTeam;

        public MemberViewHolder(View itemView) {
            super(itemView);

            memberThumb = (ImageView) itemView.findViewById(R.id.thumb);
            memberName = (TextView) itemView.findViewById(R.id.name);
            memberTeam = (TextView) itemView.findViewById(R.id.team);
        }
    }
}
