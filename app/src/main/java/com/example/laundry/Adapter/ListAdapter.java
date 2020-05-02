package com.example.laundry.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundry.Model.Laundry;
import com.example.laundry.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Laundry> laundries;
    OnCustomerClickListener mListener;

    public ListAdapter(List<Laundry> laundries) {
        this.laundries = laundries;
    }

    public interface OnCustomerClickListener {
        void onItemClick(int position);
    }

    public void setOnCustomerClickListener(OnCustomerClickListener listener)
    {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_pelanggan, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Laundry laundry = laundries.get(position);
        holder.nama.setText(laundry.getLaundryName());
        holder.tanggal.setText(laundry.getLaundryTanggal());
        if (laundry.getLaundryBayar()==0){
            holder.lunas.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return laundries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, tanggal;
        ImageView lunas;
        public ViewHolder(@NonNull View itemView, final OnCustomerClickListener listener) {
            super(itemView);
            nama = itemView.findViewById(R.id.tv_user);
            tanggal = itemView.findViewById(R.id.tv_tgl);
            lunas = itemView.findViewById(R.id.lunas);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        final int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
